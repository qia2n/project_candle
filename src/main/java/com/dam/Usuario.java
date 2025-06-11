package com.dam;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Usuario {
    protected String email;
    protected String passWord;
    protected String name;

    public Usuario(String email, String passWord, String name){
        this.email = email;
        this.passWord = passWord;
        this.name = name;
    }
    public String getName(){return name;}
    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getEmail() {
        return email;
    }

    public static boolean emailValido(String email){
        Pattern p = Pattern.compile("^[a-zA-Z0-9._%+-]+@(gmail\\.com|hotmail\\.com|onFire\\.com)$");
        Matcher m = p.matcher(email);
        return m.find();
    }

    public void setEmail(String email) {
            this.email = email;
    }

    public String AFichero(){
        return email + ";" + passWord + ";" + name;
    }


    public String ToString(){
        return "email: " + email + " Nombre: " + name;
    }

    public static void guardarUsuario(String fichero, String contenido)
    {

    }
}
