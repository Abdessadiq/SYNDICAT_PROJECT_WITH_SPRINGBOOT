package org.syndicat.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.syndicat.Repository.CaisseRepository;
import org.syndicat.models.Caisse;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
public class CaisseRestService {
    @Autowired
    public CaisseRepository caisseRepository ;

    @RequestMapping(value = "/listCaisses", method = RequestMethod.GET)
    public List<Caisse> getCaisse(){
        return caisseRepository.findAll();
    }

    @RequestMapping(value = "/caisse/{id}", method = RequestMethod.GET)
    public Optional<Caisse> getCaisse(@PathVariable Long id){
        return caisseRepository.findById(id);
    }

    @RequestMapping(value="/caisse", method=RequestMethod.POST)
    public Caisse saveCaisse(@RequestBody Caisse caisse){
        return caisseRepository.save(caisse);
    }

    @RequestMapping(value="/caisse/{id}", method=RequestMethod.PUT)
    public Caisse updateCaisse(@PathVariable Long id, @RequestBody Caisse caisse){
        caisse.setId(id);
        return caisseRepository.save(caisse);
    }

    @RequestMapping(value="/caisse/{id}", method=RequestMethod.DELETE)
    public boolean deleteCaisse(@PathVariable Long id) throws Exception{
        caisseRepository.deleteById(id);
        return true;
    }
}
