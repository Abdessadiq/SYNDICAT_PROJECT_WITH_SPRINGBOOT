package org.syndicat.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.syndicat.Repository.UtilisateurRepository;
import org.syndicat.models.Utilisateur;

@Service
public class UtilisateurService {
    @Autowired
    UtilisateurRepository utilisateurRepository;
    public Utilisateur register(Utilisateur utilisateur){
        return utilisateurRepository.save(utilisateur);
    }
    public Utilisateur fetchByEmail(String email){
        return utilisateurRepository.findByEmail(email);
    }
    public Utilisateur fetchByEmailAndPassword(String email, String password){
        return utilisateurRepository.findByEmailAndPassword(email, password);
    }
}
