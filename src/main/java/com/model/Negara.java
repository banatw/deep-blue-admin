package com.model;


import org.hibernate.validator.constraints.NotEmpty;

public class Negara {
    @NotEmpty(message = "ID tidak boleh kosong")
    private String idNegara;

    @NotEmpty(message = "Nama tidak boleh kosong")
    private String name;

    public String getIdNegara() {
        return idNegara;
    }

    public void setIdNegara(String idNegara) {
        this.idNegara = idNegara;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
