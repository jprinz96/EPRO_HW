package org.lecture;

import java.util.ArrayList;
import java.util.List;

public class Kunde {
    private final int id;
    private final String name;
    private final String email;

    public Kunde(int id, String name, String email) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name darf nicht null oder leer sein.");
        }
        if (email == null || email.isEmpty() || !email.contains("@")) {
            throw new IllegalArgumentException("Ungültige Email-Adresse.");
        }
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}