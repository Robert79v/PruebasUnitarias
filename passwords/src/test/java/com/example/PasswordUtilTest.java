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
        assertEquals(MEDIUM, PasswordUtil.assessPassword("abc123456"));
    }
    
    @Test
    public void strong_when_has_letters_numbers_and_special_chars() {
        assertEquals(STRONG, PasswordUtil.assessPassword("a1A34-1w1d"));
    }

    @Test
    public void weak_when_has_only_numbers() {
        assertEquals(WEAK, PasswordUtil.assessPassword("12345678"));
    }

    // Contraseña que contiene solo caracteres especiales
    @Test
    public void weak_when_has_only_special_chars() {
        assertEquals(WEAK, PasswordUtil.assessPassword("!@#$%^&*"));
    }

    // Contraseña con longitud mayor a 8 pero solo letras mayúsculas
    @Test
    public void weak_when_has_only_uppercase_letters() {
        assertEquals(WEAK, PasswordUtil.assessPassword("ABCDEFGH"));
    }

    // Contraseña con mezcla de mayúsculas, minúsculas, números y caracteres especiales
    @Test
    public void strong_when_has_upper_lower_numbers_and_special_chars() {
        assertEquals(STRONG, PasswordUtil.assessPassword("Abcdef1@"));
    }

    // Contraseña que contiene mayúsculas y números pero sin caracteres especiales
    @Test
    public void medium_when_has_uppercase_letters_and_numbers() {
        assertEquals(MEDIUM, PasswordUtil.assessPassword("ABC12345"));
    }
}
