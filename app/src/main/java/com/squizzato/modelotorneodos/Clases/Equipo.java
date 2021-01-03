package com.squizzato.modelotorneodos.Clases;

public class Equipo {
    String nombre;
    String PG;
    String PE;
    String PP;
    String GF;
    String GC;
    int puntos;
    int PJ;
    int Dif;

    public Equipo(String nombre, String PG, String PE, String PP, String GF, String GC) {
        this.nombre = nombre;
        this.PG = PG;
        this.PE = PE;
        this.PP = PP;
        this.GF = GF;
        this.GC = GC;

        puntos = Integer.valueOf(getPG())*3+Integer.valueOf(getPE());
        PJ = Integer.valueOf(getPG())+Integer.valueOf(getPE())+Integer.valueOf(getPP());
        Dif = Integer.valueOf(getGF())-Integer.valueOf(getGC());
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPG() {
        return PG;
    }

    public void setPG(String PG) {
        this.PG = PG;
    }

    public String getPE() {
        return PE;
    }

    public void setPE(String PE) {
        this.PE = PE;
    }

    public String getPP() {
        return PP;
    }

    public void setPP(String PP) {
        this.PP = PP;
    }

    public String getGF() {
        return GF;
    }

    public void setGF(String GF) {
        this.GF = GF;
    }

    public String getGC() {
        return GC;
    }

    public void setGC(String GC) {
        this.GC = GC;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public int getPJ() {
        return PJ;
    }

    public void setPJ(int PJ) {
        this.PJ = PJ;
    }

    public int getDif() {
        return Dif;
    }

    public void setDif(int dif) {
        Dif = dif;
    }
}
