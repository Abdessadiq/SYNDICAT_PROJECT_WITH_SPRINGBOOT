package org.syndicat.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import org.syndicat.Repository.UtilisateurRepository;
import org.syndicat.models.AnnonceUtilisateur;
import org.syndicat.models.Appartement;
import org.syndicat.models.Utilisateur;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
public class UtilisateurRestService {
    @Autowired
    public UtilisateurRepository utilisateurRepository;

    @RequestMapping(value = "/listUtilisateurs", method = RequestMethod.GET)
    public List<Utilisateur> getAppartements(){
        return utilisateurRepository.findAll();
    }



    @RequestMapping(value = "/utilisateur/{id}", method = RequestMethod.GET)
    public Optional<Utilisateur> getUtilisateur(@PathVariable Long id){
        return utilisateurRepository.findById(id);
    }

    @RequestMapping(value="/utilisateur", method=RequestMethod.POST)
    public Utilisateur saveUtilisateur(@RequestBody  Utilisateur user){
        return utilisateurRepository.save(user);
    }

    @RequestMapping(value="/utilisateur/{id}", method=RequestMethod.PUT)
    public Utilisateur updateUtilisateur(@PathVariable Long id, @RequestBody Utilisateur user){
        user.setId(id);
        return utilisateurRepository.save(user);
    }
    @RequestMapping(value="/utilisateur/{id}", method=RequestMethod.DELETE)
    public boolean deleteUtilisateur(@PathVariable Long id) throws Exception{
        utilisateurRepository.deleteById(id);
        return true;
    }

    @RequestMapping(value="/searchUtilisateur", method=RequestMethod.GET)
    public Page<Utilisateur> searchUtilisateur(@RequestParam(name="mc", defaultValue = "") String mc,
                                                  @RequestParam(name="page", defaultValue = "0") int page,
                                                  @RequestParam(name="size", defaultValue = "8") int size){
        return utilisateurRepository.search("%"+mc+"%", PageRequest.of(page, size));
    }

}
