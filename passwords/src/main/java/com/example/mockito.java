package com.example;
import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.*;
import org.junit.Test;
import org.mockito.Mockito;

public class mockito {

        @Test
        public void testWeakPassword() {
            String weakPassword = "abc";
            PasswordUtil passwordUtil = new PasswordUtil();
            PasswordUtil.SecurityLevel result = passwordUtil.assessPassword(weakPassword);
            assertEquals(PasswordUtil.SecurityLevel.WEAK, result);
        }

        @Test
        public void testMediumPassword() {
            String mediumPassword = "abc123";
            PasswordUtil passwordUtil = new PasswordUtil();
            PasswordUtil.SecurityLevel result = passwordUtil.assessPassword(mediumPassword);
            assertEquals(PasswordUtil.SecurityLevel.MEDIUM, result);
        }

        @Test
        public void testStrongPassword() {
            String strongPassword = "abc123$";
            PasswordUtil passwordUtil = new PasswordUtil();
            PasswordUtil.SecurityLevel result = passwordUtil.assessPassword(strongPassword);
            assertEquals(PasswordUtil.SecurityLevel.STRONG, result);
        }
    }
