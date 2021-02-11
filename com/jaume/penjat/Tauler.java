package com.jaume.penjat;

import java.util.Scanner;

public class Tauler {
    private Integer intents;
    private char[] paraulaSecreta;
    private String[] palabraEndevinada;
    private Integer totalLife;



    public Integer getTotalLife() {
        return totalLife;
    }

    public void setTotalLife(Integer totalLife) {
        this.totalLife = totalLife;
    }

    //Constructor vacio
    public Tauler() {
    }

    //constructor
    public Tauler(Integer intents, char[] paraulaSecreta, String[] palabraEndevinada, Integer totalLife) {
        setIntents(intents);
        setParaulaSecreta(paraulaSecreta);
        setPalabraEndevinada(palabraEndevinada);
        setTotalLife(totalLife);

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

    public void setIntents(Integer intents) {
        this.intents = intents;
        this.totalLife = totalLife;
    }

    public void setParaula(String palabra) {
        setParaula(palabra);
    }

    public String setLetra(String letra) {
        setLetra(letra);
        return letra;
    }

    public void setParaulaSecreta(char[] paraulaSecreta) {
        this.paraulaSecreta = paraulaSecreta;
        this.palabraEndevinada = new String[paraulaSecreta.length];
    }

    public void setPalabraEndevinada(String[] palabraEndevinada) {
        this.palabraEndevinada = palabraEndevinada;
    }

    public void inicialitzarPartida(String paraula, Integer totalLife) {
        char[] palabras = paraula.toCharArray();
        setParaulaSecreta(palabras);
        setIntents(totalLife);
    }

    //Metodos
    public void restarIntent() {
        this.intents--;
    }

    public String imprimirVides() {
        String frase = String.format("Te quedan %s vidas de %s ", intents, totalLife);
        if (intents == 1) frase = String.format("Te quedan %s vida de %", intents, totalLife);
        return frase;
    }

    public String verificar(String letra) {
        if (letra.length() > 1) {
            return "te has equivocado";
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

    public String imprimir() {
        String exit = "";
        for (int i = 0; i < palabraEndevinada.length; i++) {
            if (palabraEndevinada[i].equals("")) {
                System.out.println("_");
            } else {
                System.out.println(palabraEndevinada[i]);
            }
        }
        return exit;
    }

    public boolean hasGuanyat() {
        boolean valor = true;
        for (int i = 0; i < palabraEndevinada.length; i++) {
            if (palabraEndevinada[i].equals("")) {
                valor = false;
            }
        }
        return valor;
    }
}
