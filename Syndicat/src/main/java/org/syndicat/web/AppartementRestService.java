package org.syndicat.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import org.syndicat.Repository.AppartementRepository;
import org.syndicat.models.Appartement;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
public class AppartementRestService {
    @Autowired
    public AppartementRepository appartementRepository ;

    @RequestMapping(value = "/listAppartements", method = RequestMethod.GET)
    public List<Appartement> getAppartements(){

        return appartementRepository.findAll();
    }

    @RequestMapping(value = "/appartement/{id}", method = RequestMethod.GET)
    public Optional<Appartement> getAppartement(@PathVariable Long id){
        return appartementRepository.findById(id);
    }

    @RequestMapping(value="/appartement", method=RequestMethod.POST)
    public Appartement saveAppartement(@RequestBody Appartement app){
        return appartementRepository.save(app);
    }

    @RequestMapping(value="/appartement/{id}", method=RequestMethod.PUT)
    public Appartement updateAppartement(@PathVariable Long id,@RequestBody Appartement app){
        app.setId(id);
        return appartementRepository.save(app);
    }
    @RequestMapping(value="/appartement/{id}", method=RequestMethod.DELETE)
    public boolean deleteAppartement(@PathVariable Long id) throws Exception{
        appartementRepository.deleteById(id);
        return true;
    }


   /* @RequestMapping(value="/searchAppartement", method=RequestMethod.GET)
   public Page<Appartement> searchAppartement(
            @RequestParam(name="mc", defaultValue = "") String mc,
            @RequestParam(name="page", defaultValue = "0") int page,
            @RequestParam(name="size", defaultValue = "8") int size){
        return appartementRepository.search("%"+mc+"%", PageRequest.of(page, size));
    }*/
}
