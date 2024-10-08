package com.example;

import static org.junit.Assert.*;
import static com.example.PasswordUtil.SecurityLevel.*;
import org.junit.Test;

public class PasswordUtilTest {
    @Test
    public void weak_when_password_is_empty() {
        assertEquals(WEAK, PasswordUtil.assessPassword(""));
    }
    
    @Test
    public void weak_when_has_less_than_8_letters() {
        assertEquals(WEAK, PasswordUtil.assessPassword("1234567"));
    }
    
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
