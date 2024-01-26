package com.brayan.appmusic.Profile.Domain.Model.ValueObjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record PersonName(String firstName,String lastName) {
    public PersonName(){
        this(null,null);
    }
    public PersonName{
        if(firstName==null || firstName.isBlank()){
            throw new IllegalArgumentException("El nombre no puede estar vacio");

        }
        if(lastName==null||lastName.isBlank()){
            throw new IllegalArgumentException("El apellido no puede estar vacio");

        }
    }
    public String getFullName(){
        return String.format("%s %s",firstName,lastName);
    }
}
