package com.iut.banque.test.dao;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.iut.banque.controller.CreerUtilisateur;
import com.iut.banque.modele.Client;
import com.iut.banque.modele.Utilisateur;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestsCreerUtilisateur {

    private final CreerUtilisateur creerUtilisateur = new CreerUtilisateur();

    /**
     * Tests de la fonction de cryptage de mot de passe
     */
    @Test
    public void testHashPassword() {
        String plainPassword = "secretPassword";
        try {
            String hashedPassword = creerUtilisateur.hashPassword(plainPassword);
            assertNotEquals(plainPassword, hashedPassword);
        } catch (IllegalArgumentException e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }
}
