package org.syndicat.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.syndicat.models.Immeuble;
import org.syndicat.models.Reglement;
import org.syndicat.models.Utilisateur;

@RepositoryRestResource
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
    //La methode pour chercher un utilisateur
    @Query("select user from Utilisateur user where user.nom like :x")
    public Page<Utilisateur> search(@Param("x")String mc, Pageable pageable);


    // La methode à implémenter pour l'inscription
    public Utilisateur findByEmail(String email);
    // La methode à implémenter pour la connexion
    public Utilisateur findByEmailAndPassword(String email, String password);
}
