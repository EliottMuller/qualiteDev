package com.iut.banque.test.dao;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.iut.banque.controller.CreerUtilisateur;
import com.iut.banque.modele.Client;
import com.iut.banque.modele.Utilisateur;
import org.junit.Before;
import org.junit.Test;

import static com.iut.banque.controller.CreerUtilisateur.hashPassword;
import static org.junit.Assert.*;

public class TestsCreerUtilisateur {

    /**
     * Tests de la fonction de cryptage de mot de passe
     */
    @Test
    public void testHashPassword() {
        String plainPassword = "secretPassword";
        try {
            String hashedPassword = hashPassword(plainPassword);
            assertNotEquals(plainPassword, hashedPassword);
        } catch (IllegalArgumentException e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }
}
