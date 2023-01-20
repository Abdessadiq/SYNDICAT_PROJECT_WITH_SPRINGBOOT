package org.syndicat.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import org.syndicat.Repository.AnnonceUtilisateurRepository;
import org.syndicat.models.AnnonceUtilisateur;


import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
public class AnnonceRestService {
    @Autowired
    public AnnonceUtilisateurRepository annonceUtilisateurRepository ;

    @RequestMapping(value = "/listAnnonces", method = RequestMethod.GET)
    public List<AnnonceUtilisateur> getAnnonces(){
        return annonceUtilisateurRepository.findAll();
    }


    @RequestMapping(value = "/annonce/{id}", method = RequestMethod.GET)
    public Optional<AnnonceUtilisateur> getAnnonce(@PathVariable Long id){
        return annonceUtilisateurRepository.findById(id);
    }

    @RequestMapping(value="/annonce", method=RequestMethod.POST)
    public AnnonceUtilisateur saveAnnonce(@RequestBody AnnonceUtilisateur ann){
        return annonceUtilisateurRepository.save(ann);
    }


    @RequestMapping(value="/annonce/{id}", method=RequestMethod.PUT)
    public AnnonceUtilisateur updateAnnonce(@PathVariable Long id,@RequestBody AnnonceUtilisateur ann){
        ann.setId(id);
        return annonceUtilisateurRepository.save(ann);
    }
    @RequestMapping(value="/annonce/{id}", method=RequestMethod.DELETE)
    public boolean deleteAnnonce(@PathVariable Long id) throws Exception{
        annonceUtilisateurRepository.deleteById(id);
            return true;
    }


    @RequestMapping(value="/searchAnnonce", method=RequestMethod.GET)
    public Page<AnnonceUtilisateur> searchAnnonce(
            @RequestParam(name="mc", defaultValue = "") String mc,
            @RequestParam(name="page", defaultValue = "0") int page,
            @RequestParam(name="size", defaultValue = "8") int size){
        return annonceUtilisateurRepository.search("%"+mc+"%", PageRequest.of(page, size));
    }

}
