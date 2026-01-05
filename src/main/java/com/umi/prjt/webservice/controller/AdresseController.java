package com.umi.prjt.webservice.controller;


import com.umi.prjt.webservice.model.Adresse;
import com.umi.prjt.webservice.service.AdresseService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Adresse")
@AllArgsConstructor
@Slf4j
public class AdresseController {
    private final AdresseService adresseService;

    @GetMapping
    public List<Adresse> listeAdresses() {
        return adresseService.findAll();
    }

    @GetMapping("/{id}")
    public Adresse findAdresseById(@PathVariable Long id) {
        Adresse adresse = adresseService.findById(id);
        return adresse;
    }

    @PostMapping
    public Adresse saveAdresse(@RequestBody Adresse adresse) {
        Adresse savedAdresse = adresseService.create(adresse);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/ws/Adresse/" + savedAdresse.getId());
        return savedAdresse;

    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAdresse(@PathVariable Long id) {
        adresseService.delete(id);
    }
}
