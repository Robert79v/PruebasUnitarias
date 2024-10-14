package com.example;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import static com.example.PasswordUtil.SecurityLevel.MEDIUM;
import static com.example.PasswordUtil.SecurityLevel.STRONG;
import static com.example.PasswordUtil.SecurityLevel.WEAK;

public class PasswordUtilTest {
    // Prueba para verificar que una contraseña vacía sea clasificada como WEAK.
    @Test
    public void weak_when_password_is_empty() {
        assertEquals(WEAK, PasswordUtil.assessPassword(""));
    }
    
    //Prueba para verificar que una contraseña con menos de 8 caracteres sea clasificada como WEAK.
    @Test
    public void weak_when_has_less_than_8_letters() {
        assertEquals(WEAK, PasswordUtil.assessPassword("1234567"));
    }
    
    //Prueba para verificar que una contraseña que contiene solo letras sea clasificada como WEAK.
    @Test
    public void weak_when_has_only_letters() {
        assertEquals(WEAK, PasswordUtil.assessPassword("abcdefg"));
    }
    
    @Test
    public void medium_when_has_letters_and_numbers() {
        assertEquals(MEDIUM, PasswordUtil.assessPassword("abc12345"));
    }
    
    @Test
    public void strong_when_has_letters_numbers_and_special_chars() {
        assertEquals(STRONG, PasswordUtil.assessPassword("abc12345!@#"));
    }
}
