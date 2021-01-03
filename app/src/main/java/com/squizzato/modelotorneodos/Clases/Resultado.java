package com.squizzato.modelotorneodos.Clases;

public class Resultado {
    String EquipoA;
    String EquipoB;
    String GolA;
    String GolB;

    public Resultado(String equipoA, String equipoB, String golA, String golB) {
        EquipoA = equipoA;
        EquipoB = equipoB;
        GolA = golA;
        GolB = golB;
    }

    public String getEquipoA() {
        return EquipoA;
    }

    public void setEquipoA(String equipoA) {
        EquipoA = equipoA;
    }

    public String getEquipoB() {
        return EquipoB;
    }

    public void setEquipoB(String equipoB) {
        EquipoB = equipoB;
    }

    public String getGolA() {
        return GolA;
    }

    public void setGolA(String golA) {
        GolA = golA;
    }

    public String getGolB() {
        return GolB;
    }

    public void setGolB(String golB) {
        GolB = golB;
    }
}
