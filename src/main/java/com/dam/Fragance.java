package com.dam;

public class Fragance {
    private String name;
    private String ID;
    private String descripcion;

    public Fragance(String name, String ID, String descripcion) {
        this.name = name;
        this.ID = ID;
        this.descripcion = descripcion;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
