package com.squizzato.modelotorneodos.Clases;

public class Proximopartidoclase {
    String lugar;
    String dia;
    String fecha;
    String hora;
    String EquipoA;
    String EquipoB;

    public Proximopartidoclase(String lugar, String dia, String fecha, String hora, String equipoA, String equipoB) {
        this.lugar = lugar;
        this.dia = dia;
        this.fecha = fecha;
        this.hora = hora;
        EquipoA = equipoA;
        EquipoB = equipoB;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
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
}
