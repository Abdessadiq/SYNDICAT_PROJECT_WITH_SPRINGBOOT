package org.syndicat.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.syndicat.models.Utilisateur;
import org.syndicat.web.UtilisateurService;

@RestController
@Slf4j
@AllArgsConstructor
@CrossOrigin("http://localhost:4200")
public class UtlisateurController {
    UtilisateurService utilisateurService;

    @PostMapping(path = "/register")
    public Utilisateur registerUtilisateur(@RequestBody Utilisateur utilisateur) throws Exception{
        String tempEmail = utilisateur.getEmail();
        if(tempEmail!=null && !"".equals(tempEmail)){
            Utilisateur utilisateurObj=utilisateurService.fetchByEmail(tempEmail);
            if (utilisateurObj!=null){
                throw new Exception("Cet Utilisateur "+tempEmail+" existe déjà !!");
            }
        }
        log.info("Test : "+utilisateur.getEmail());
        Utilisateur utilisateur1=null;
        utilisateur1 = utilisateurService.register(utilisateur);
        return utilisateur1;
    }
    @PostMapping(path = "/login")
    public Utilisateur login(@RequestBody Utilisateur utilisateur) throws Exception{
        String tempEmail = utilisateur.getEmail();
        String tempPassword  = utilisateur.getPassword();
        Utilisateur utilisateurObj=null;
        if (tempEmail!=null && tempPassword!=null){
            utilisateurObj= utilisateurService.fetchByEmailAndPassword(tempEmail,tempPassword);
        }
        if (utilisateurObj==null){
            throw new Exception("Problème de connexion !!");
        }
        return  utilisateurObj;
    }
}
