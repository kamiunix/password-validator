package com.example.k.password_validator;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    /*
    //sample password strings
    String pass1 = "password";
    String pass2 = "passwd";
    String pass3 = "password1234";
    String pass4 = "Qwerty1234";
     */

    static private String testpass;

    @Test
    public void notPassword() throws Exception {
        assertTrue(notPassword(testpass));
    }

    @Test
    public void minChar() throws Exception {
        assertTrue(longEnough(testpass));
    }

    @Test

    private boolean notPassword(String pass) {
        if (pass.equals("password")) {
            System.out.print("Password can not be 'password'");
            return false;
        }
        return true;
    }
    private boolean longEnough(String pass) {
        if (pass.length() < 8) {
            System.out.println("Password must be at least 8 characters");
            return false;
        }
        return true;
    }

}