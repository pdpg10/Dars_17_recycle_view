package com.example.dars_17_advanced_rv.model;

import java.util.Objects;

public class NameModel {
    private String name;

    public NameModel(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NameModel model = (NameModel) o;
        return Objects.equals(name, model.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}



