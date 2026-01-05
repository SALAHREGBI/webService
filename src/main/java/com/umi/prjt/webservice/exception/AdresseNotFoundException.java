package com.umi.prjt.webservice.exception;

public class AdresseNotFoundException extends RuntimeException {
    public AdresseNotFoundException(Long id) {
        super("Adresse " + id + " n'existe pas");
    }
}
