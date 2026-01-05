package com.umi.prjt.webservice.service;

import com.umi.prjt.webservice.model.Adresse;
import com.umi.prjt.webservice.model.Personne; // Zid had l'import
import com.umi.prjt.webservice.repositories.AdresseRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class AdresseService {

    private final AdresseRepository adresseRepository;

    public List<Adresse> findAll() {
        log.info("Récupération de toutes les adresses");
        List<Adresse> adresses = adresseRepository.findAll();

        return adresses.stream().map(this::enrichirAvecPersonne).collect(Collectors.toList());
    }


    public Adresse findById(Long id) {
        log.debug("Recherche de l'adresse avec ID: {}", id);
        Adresse adresse = adresseRepository.findById(id).orElseThrow(() -> {
            log.error("Adresse avec ID {} non trouvée", id);
            return new RuntimeException("Adresse non trouvée avec l'ID: " + id);
        });

        return enrichirAvecPersonne(adresse);
    }


    public Adresse create(Adresse adresse) {
        if (adresse.getIdPersonne() == null) {
            log.error("Tentative de création d'une adresse sans ID Personne");
            throw new RuntimeException("L'ID Personne est obligatoire pour créer une adresse");
        }
        log.info("Enregistrement d'une nouvelle adresse pour la personne ID: {}", adresse.getIdPersonne());
        return adresseRepository.save(adresse);
    }

    public void delete(Long id) {
        log.warn("Suppression de l'adresse avec ID: {}", id);
        adresseRepository.deleteById(id);
    }


    private Adresse enrichirAvecPersonne(Adresse adresse) {
        if (adresse.getIdPersonne() != null) {
            Personne p = new Personne();
            p.setId(adresse.getIdPersonne());
            p.setNom("Nom_Simulé_" + adresse.getIdPersonne());
            p.setPrenom("Prenom_Simulé");

            adresse.setPersonne(p);
        }
        return adresse;
    }
}