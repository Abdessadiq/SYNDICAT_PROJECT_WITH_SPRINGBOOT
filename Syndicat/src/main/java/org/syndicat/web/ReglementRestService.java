package org.syndicat.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import org.syndicat.Repository.ReglementRepository;
import org.syndicat.models.AnnonceUtilisateur;
import org.syndicat.models.Appartement;
import org.syndicat.models.Reglement;
import org.syndicat.models.Utilisateur;


import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
public class ReglementRestService {
    @Autowired
    public ReglementRepository reglementRepository ;

    @RequestMapping(value = "/listReglements", method = RequestMethod.GET)
    public List<Reglement> getAppartements(){
        return reglementRepository.findAll();
    }

    @RequestMapping(value = "/reglement/{id}", method = RequestMethod.GET)
    public Optional<Reglement> getReglement(@PathVariable Long id){
        return reglementRepository.findById(id);
    }

    @RequestMapping(value="/reglement", method=RequestMethod.POST)
    public Reglement saveReglement(@RequestBody Reglement reg){
        return reglementRepository.save(reg);
    }


    @RequestMapping(value="/reglement/{id}", method=RequestMethod.PUT)
    public Reglement updateReglement(@PathVariable Long id, @RequestBody Reglement reg){
        reg.setId(id);
        return reglementRepository.save(reg);
    }
    @RequestMapping(value="/reglement/{id}", method=RequestMethod.DELETE)
    public boolean deleteReglement(@PathVariable Long id) throws Exception{
        reglementRepository.deleteById(id);
        return true;
    }

    @RequestMapping(value="/searchReglement", method=RequestMethod.GET)
    public Page<Reglement> searchReglement(
            @RequestParam(name="mc", defaultValue = "") String mc,
            @RequestParam(name="page", defaultValue = "0") int page,
            @RequestParam(name="size", defaultValue = "8") int size){
        return reglementRepository.search("%"+mc+"%", PageRequest.of(page, size));
    }
}
