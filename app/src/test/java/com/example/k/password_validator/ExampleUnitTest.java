package com.example.k.password_validator;

import org.junit.BeforeClass;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    static private String testpass;
    //testpass = "Password1!";

    /*
    //sample password strings
    String pass1 = "password";
    String pass2 = "passwd";
    String pass3 = "password1234";
    String pass4 = "Qwerty1234";
     */

    @Test
    public void notPassword() throws Exception {
        assertTrue(notPassword(testpass));
    }

    @Test
    public void minChar() throws Exception {
        assertTrue(longEnough(testpass));
    }

    @Test
    public void lowerUpperCase() throws Exception{
        assertTrue(hasLowerUpper(testpass));
    }

    @Test
    public void hasOneDigit() throws Exception{
        assertTrue(hasNum(testpass));
    }

    @Test
    public void hasOneSpecialChar() throws Exception{
        assertTrue(specialChar(testpass));
    }

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

    //3 extra tests
    public boolean hasLowerUpper(String inputPassword){
        if(inputPassword.equals(inputPassword.toLowerCase()) || inputPassword.equals(inputPassword.toUpperCase())){
            System.out.print("password must have an uppercase and lowercase character");
            return false;
        }
        return true;
    }
    public boolean hasNum(String inputPassword){
        if(!inputPassword.matches(".*\\d.*")){
            System.out.print("password must have at least one number");
            return false;
        }
        return true;
    }
    public boolean specialChar(String testpass){
        if(!ExampleUnitTest.testpass.matches(".*[~!@#$%^&*()_+].*")){
            System.out.print("password must have at least one special characters \n(~, !, @, #, $, %, ^, &, *, (, ), _, +)");
            return false;
        }
        return true;
    }
}