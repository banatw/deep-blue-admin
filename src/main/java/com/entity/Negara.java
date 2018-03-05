package com.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Negara {
    @Id
    public Integer idNegara;
    private String name;
    private boolean selected;

    public Integer getIdNegara() {
        return idNegara;
    }

    public void setIdNegara(Integer idNegara) {
        this.idNegara = idNegara;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Negara() {
    }

    public Negara(Integer idNegara, String name) {
        this.idNegara = idNegara;
        this.name = name;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
