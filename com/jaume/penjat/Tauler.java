package com.jaume.penjat;

import java.util.Scanner;

public class Tauler {
    private Integer intents;
    private char[] paraulaSecreta;
    private String[] palabraEndevinada;
    private Integer totalLife;
    private String paraula;
    private String letra;


    //Constructor vacio
    public Tauler() {

    }
    //constructor
    public Tauler(Integer intents, char[] paraulaSecreta, String[] palabraEndevinada, Integer totalLife, String paraula, String letra) {
        setIntents(intents);
        setParaulaSecreta(paraulaSecreta);
        setPalabraEndevinada(palabraEndevinada);
        setTotalLife(totalLife);
        setParaula(paraula);
        setLetra(letra);
    }

    //Getters y setters
    public Integer getIntents() {
        return intents;
    }

    public char[] getParaulaSecreta() {
        return paraulaSecreta;
    }

    public String[] getPalabraEndevinada() {
        return palabraEndevinada;
    }

    public void setTotalLife(Integer totalLife) {
        this.totalLife = totalLife;
    }
    

    public String setLetra(String letra) {
        this.letra = letra;
        return letra;
    }

    public void setParaula(String paraula) {
        this.paraula = paraula;
    }

    public void setIntents(Integer intents) {
        this.intents = intents;
        this.totalLife = intents;
    }

    public void setParaulaSecreta(char[] paraulaSecreta) {
        this.paraulaSecreta = paraulaSecreta;
        this.palabraEndevinada = new String[paraulaSecreta.length];
    }

    public void setPalabraEndevinada(String[] palabraEndevinada) {
        this.palabraEndevinada = palabraEndevinada;
    }

    //Metodos
    public void inicialitzarPartida(String paraula, Integer totalLife) {
        char[] palabras = paraula.toCharArray();
        setParaulaSecreta(palabras);
        setIntents(totalLife);
    }

    public String verificar(String letra) {
        String letraNueva = setLetra(letra);
        if (letra.length() > 1) {
            return "Lletra incorrecte";
        } else {
            boolean existe = false;
            for (int i = 0; i < paraulaSecreta.length; i++) {
                if (paraulaSecreta[i] == letra.charAt(0)) {
                    existe = true;
                    palabraEndevinada[i] = String.valueOf(letra.charAt(0));
                }
            }
            if (!existe) {
                restarIntent();
            }
        }
        return "";
    }

    public void restarIntent() {
        this.intents--;
    }

    public String imprimir() {
        String exit = "";
        for (int i = 0; i < palabraEndevinada.length; i++) {
            if (palabraEndevinada[i] == (null)) {
                System.out.println("_");
            } else {
                System.out.println(palabraEndevinada[i]);
            }
        }
        return exit;
    }

    public String imprimirVides() {
        String frase = String.format("Et queden %s vides de %s", intents, totalLife);
        if (intents == 1) frase = String.format("Et queda %s vida de %s", intents, totalLife);
        return frase;
    }

    public boolean hasGuanyat() {
        boolean valor = true;
        for (int i = 0; i < palabraEndevinada.length; i++) {
            if (palabraEndevinada[i] == (null)) {
                valor = false;
            }
        }
        return valor;
    }

}
