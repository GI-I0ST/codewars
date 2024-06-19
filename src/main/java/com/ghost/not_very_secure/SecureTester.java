package com.ghost.not_very_secure;

public class SecureTester{

    public static boolean alphanumeric(String s){
        return s.matches("^[a-zA-Z0-9]+$");
    }

}