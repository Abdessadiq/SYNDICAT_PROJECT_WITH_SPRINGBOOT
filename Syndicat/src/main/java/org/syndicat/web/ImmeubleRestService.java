package org.syndicat.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import org.syndicat.Repository.ImmeubleRepository;
import org.syndicat.models.AnnonceUtilisateur;
import org.syndicat.models.Appartement;
import org.syndicat.models.Immeuble;
import org.syndicat.models.Utilisateur;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
public class ImmeubleRestService {
    @Autowired
    public ImmeubleRepository immeubleRepository;

    @RequestMapping(value = "/listImmeubles", method = RequestMethod.GET)
    public List<Immeuble> getImmeuble(){
        return immeubleRepository.findAll();
    }
    @RequestMapping(value = "/immeuble/{id}", method = RequestMethod.GET)
    public Optional<Immeuble> getImmeuble(@PathVariable Long id){
        return immeubleRepository.findById(id);
    }

    @RequestMapping(value="/immeuble", method=RequestMethod.POST)
    public Immeuble saveImmeuble(@RequestBody Immeuble imm){
        return immeubleRepository.save(imm);
    }

    @RequestMapping(value="/immeuble/{id}", method=RequestMethod.PUT)
    public Immeuble updateImmeuble(@PathVariable Long id, @RequestBody Immeuble imm){
        imm.setId(id);
        return immeubleRepository.save(imm);
    }
    @RequestMapping(value="/immeuble/{id}", method=RequestMethod.DELETE)
    public boolean deleteImmeuble(@PathVariable Long id) throws Exception{
        immeubleRepository.deleteById(id);
        return true;
    }

    @RequestMapping(value="/searchImmeuble", method=RequestMethod.GET)
    public Page<Immeuble> searchImmeuble(
            @RequestParam(name="mc", defaultValue = "") String mc,
            @RequestParam(name="page", defaultValue = "0") int page,
            @RequestParam(name="size", defaultValue = "8") int size){
        return immeubleRepository.search("%"+mc+"%", PageRequest.of(page, size));
    }
}
