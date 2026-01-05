package com.umi.prjt.webservice.service;

import com.umi.prjt.webservice.model.Adresse;
import com.umi.prjt.webservice.repositories.AdresseRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class AdresseService {
    private final AdresseRepository adresseRepository;

    public List<Adresse> findAll() {
        log.info("Récupération de toutes les adresses");
        return adresseRepository.findAll();
    }
    public Adresse findById(Long id) {
        log.debug("Recherche de l'adresse avec ID: {}", id);
        return adresseRepository.findById(id).orElseThrow(() -> {
            log.error("Adresse avec ID {} non trouvée", id);
            return new RuntimeException("Adresse non trouvée avec l'ID: " + id);
        });
    }

    public Adresse create(Adresse adresse) {
        log.info("Enregistrement d'une nouvelle adresse: {}", adresse.getVille());
        return adresseRepository.save(adresse);
    }

    public void delete(Long id) {
        log.warn("Suppression de l'adresse avec ID: {}", id);
        adresseRepository.deleteById(id);
    }
}
