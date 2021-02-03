package com.jaume.penjat;

import java.util.Scanner;

public class Tauler {
    private Integer intents;
    private char[] paraulaSecreta;
    private String[] palabraEndevinada;

    public Tauler() {
    }

    public Tauler(Integer intents, char[] paraulaSecreta) {
        this.intents = intents;
        this.paraulaSecreta = paraulaSecreta;
    }

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
    }

    public void setParaulaSecreta(char[] paraulaSecreta) {
        this.paraulaSecreta = paraulaSecreta;
    }

    public void setPalabraEndevinada(String[] palabraEndevinada) {
        this.palabraEndevinada = palabraEndevinada;
    }


    public void inicialitzarPartida(String paraula, Integer vides) {
        char[] words = paraula.toCharArray();
        setParaulaSecreta(words);
        setIntents(vides);
    }

    public void restarIntent() {
        this.intents--;
    }

    public String imprimirVides() {
        String frase = String.format("Te quedan %v vidas", intents);
        if (intents == 1) frase = String.format("Te quedan %v vidas", intents);
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
                    palabraEndevinada[i] = letra;
                }
            }
            if (!existe) {
                restarIntent();
            }
        }
        return "";
    }

    public void imprimir() {
        for (int i = 0; i < palabraEndevinada.length; i++) {
            if (palabraEndevinada[i].equals("")) {
                System.out.println("_");
            } else {
                System.out.println(palabraEndevinada[i]);
            }
        }
    }

    public boolean hasGuanyat() {
        boolean estat = true;
        for (int i = 0; i < palabraEndevinada.length; i++) {
            if (palabraEndevinada[i] == null) {
                return false;
            }
        }
        return true;
    }
}
