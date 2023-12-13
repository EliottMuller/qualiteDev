package com.iut.banque.test.dao;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.iut.banque.controller.CreerUtilisateur;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestsCreerUtilisateur {

    /**
     * Tests de la fonction de cryptage de mot de passe
     */


    private CreerUtilisateur creerUtilisateur;

    @Before
    public void setUp() {
        creerUtilisateur = new CreerUtilisateur();
    }

    @Test
    public void testHashPassword() {
        String plainPassword = "secretPassword";
        try {
            String hashedPassword = creerUtilisateur.hashPassword(plainPassword);
            assertNotEquals(plainPassword, hashedPassword);
            assertTrue(BCrypt.verifyer().verify(plainPassword.toCharArray(), hashedPassword).verified);

        } catch (IllegalArgumentException e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testHashPasswordWithInvalidInput() {
        creerUtilisateur.hashPassword(null);
    }
}
