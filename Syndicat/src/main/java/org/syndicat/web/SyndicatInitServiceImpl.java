package org.syndicat.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.syndicat.Repository.*;
import org.syndicat.models.*;

import javax.transaction.Transactional;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.stream.Stream;

@Service
@Transactional
public class SyndicatInitServiceImpl implements ISyndicatInitService {
    @Autowired
    private ImmeubleRepository immeubleRepository;
    @Autowired
    private AppartementRepository appartementRepository;
    @Autowired
    private UtilisateurRepository utilisateurRepository;
    @Autowired
    private CaisseRepository caisseRepository;
    @Autowired
    private AnnonceUtilisateurRepository annonceUtilisateurRepository;
    @Autowired
    private ReglementRepository reglementRepository;
    @Override
    public void initImmeuble() {
     /*Stream.of("Résidance Amane", "Résidance Sarra","Résidance Wafae","Résidance Gala", "Résidance Farid Lmotawakil")
                .forEach(nameImmeuble->{
                    Immeuble immeuble = new Immeuble();
                    immeuble.setNom(nameImmeuble);
                    immeuble.setVile("Casablanca");
                    immeuble.setNombreEtages(5+(int) (Math.random()*10));
                    immeuble.setNombreAppartements(15+(int)(Math.random()*30));
                    immeubleRepository.save(immeuble);
                });*/
    }

    @Override
    public void initAppartement() {
       /*immeubleRepository.findAll().forEach(immeuble -> {
            for(int i=15; i<immeuble.getNombreAppartements();i++){
                Appartement  appartement = new Appartement();
                appartement.setImmeuble(immeuble);
                appartement.setNumero(i);
                appartement.setNumeroEtage(1+(int)(Math.random()*15));
                appartementRepository.save(appartement);
            }
        });*/

    }

    @Override
    public void initUtilisateur() {
           /*Utilisateur utilisateur1 = new Utilisateur();
            utilisateur1.setNom("Elyaaqobi");
            utilisateur1.setPrenom("Ahmed");
            utilisateur1.setEmail(utilisateur1.getNom()+"2022@gmil.com");
            utilisateur1.setPassword(utilisateur1.getNom()+".2020");
            utilisateur1.setTypeUtilisateur(TypeUtilisateur.RESIDANT);
            utilisateur1.setTel("0620202020");
            utilisateur1.setAppartement(appartementRepository.findById(2L).get());
            utilisateur1.setImmeuble(immeubleRepository.findById(1L).get());
            utilisateurRepository.save(utilisateur1);

            Utilisateur utilisateur2 = new Utilisateur();
            utilisateur2.setNom("Yassir");
            utilisateur2.setPrenom("Ayoub");
            utilisateur2.setEmail(utilisateur2.getNom()+"2022@gmil.com");
            utilisateur2.setPassword(utilisateur2.getNom()+".2020");
            utilisateur2.setTypeUtilisateur(TypeUtilisateur.SYNDIC_EXTERNE);
            utilisateur2.setTel("0630303030");
            utilisateur2.setAppartement(appartementRepository.findById(4L).get());
            utilisateur2.setImmeuble(immeubleRepository.findById(5L).get());
            utilisateurRepository.save(utilisateur2);

            Utilisateur utilisateur3 = new Utilisateur();
            utilisateur3.setNom("benhamou");
            utilisateur3.setPrenom("brahim");
            utilisateur3.setEmail(utilisateur3.getNom()+"2022@gmil.com");
            utilisateur3.setPassword(utilisateur3.getNom()+".2020");
            utilisateur3.setTypeUtilisateur(TypeUtilisateur.SYNDIC_RESIDANT);
            utilisateur3.setTel("0640404040");
            utilisateur3.setAppartement(appartementRepository.findById(1L).get());
            utilisateur3.setImmeuble(immeubleRepository.findById(2L).get());
            utilisateurRepository.save(utilisateur3);


        Utilisateur utilisateur4 = new Utilisateur();
        utilisateur4.setNom("hakimi");
        utilisateur4.setPrenom("adil");
        utilisateur4.setEmail(utilisateur4.getNom()+"2022@gmil.com");
        utilisateur4.setPassword(utilisateur4.getNom()+".2020");
        utilisateur4.setTypeUtilisateur(TypeUtilisateur.RESIDANT);
        utilisateur4.setTel("0630303030");
        utilisateur4.setAppartement(appartementRepository.findById(6L).get());
        utilisateur4.setImmeuble(immeubleRepository.findById(1L).get());
        utilisateurRepository.save(utilisateur4);*/


     /*String[] noms = new String[]{"Ahmed","Yassir","Inas","Youssef"};
        String[] sf = new String[]{"marie", "divorcé","Célibataire"};
        immeubleRepository.findAll().forEach(immeuble -> {
            immeuble.getAppartements().forEach(appartement -> {
                Utilisateur utilisateur = new Utilisateur();
                utilisateur.setAppartement(appartement);
                utilisateur.setPrenom(noms[new Random().nextInt(noms.length)]);
                utilisateur.setImmeuble(immeuble);
                utilisateur.setTypeUtilisateur(TypeUtilisateur.values()[new  Random().nextInt(TypeUtilisateur.values().length)]);
                utilisateur.setEmail(utilisateur.getPrenom()+"22@gmail.com");
                utilisateur.setPassword("123."+utilisateur.getPrenom());
                utilisateur.setSituationFamiliale(sf[new Random().nextInt(sf.length)]);
                utilisateur.setAdresse("immeuble : "+immeuble.getNom()+" Appartement numero : "+appartement.getNumero());
                DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                try {
                    utilisateur.setDateNaissance(df.parse("11/11/1990"));
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
                utilisateur.setDateDebut(new Date());
                utilisateurRepository.save(utilisateur);

            });

        });*/

    }

    @Override
    public void initCaisse() {
        double[] somme = new double[] {100, 150, 200, 300, 120,140};

           /*immeubleRepository.findAll().forEach(immeuble -> {
                immeuble.getUtilisateurs().forEach(utilisateur -> {
                    Stream.of("Cotisation","Menage","Traveaux","Don").forEach(type->{
                    Caisse caisse = new Caisse();
                    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                    try {
                        caisse.setDate(dateFormat.parse("10/01/2017"));
                    } catch (ParseException e) {
                        throw new RuntimeException(e);
                    }
                    caisse.setType(Type.values()[new Random().nextInt(Type.values().length)]);
                    caisse.setDetailType(type);
                    caisse.setSomme(somme[new Random().nextInt(somme.length)]);
                    caisse.setImmeuble(immeuble);
                    caisse.setUtilisateur(utilisateur);
                    caisseRepository.save(caisse);
                });
            });
        });*/


    }

    @Override
    public void initAnnonceUtilisateur() {

      /* immeubleRepository.findAll().forEach(immeuble -> {
            immeuble.getUtilisateurs().forEach(utilisateur -> {
                AnnonceUtilisateur annonceUtilisateur = new AnnonceUtilisateur();
                annonceUtilisateur.setUtilisateur(utilisateur);
                annonceUtilisateur.setImmeuble(immeuble);
                annonceUtilisateur.setSujet(" annoncer par "+utilisateur.getPrenom());
                annonceUtilisateur.setContenu("Le contenu de cette annonce concerne l'immeuble de nom : "+immeuble.getNom());
                annonceUtilisateurRepository.save(annonceUtilisateur);

            });
        });*/


    }

    @Override
    public void initReglement() {
        /*Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).forEach(num->{
            Reglement reglement = new Reglement();
            reglement.setNumeroArticle(num);
            reglement.setContenuArticle("article Numero : "+num);
            reglementRepository.save(reglement);
        });*/

    }
}
