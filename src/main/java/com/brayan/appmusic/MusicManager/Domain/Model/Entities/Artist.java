package com.brayan.appmusic.MusicManager.Domain.Model.Entities;

import com.brayan.appmusic.Shared.Domain.model.entities.AuditableModel;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

import java.util.Date;

@Getter
@Entity
public class Artist extends AuditableModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String Name;

    private byte[] photo;


    public Artist(){}

    public Artist(String name,byte[] photo){
        this.Name= name;
        this.photo = photo;
        this.setCreateAt(new Date());
    }
    public Artist updateInformation(String name,byte[] photo){
        this.Name=name;
        this.photo=photo;

        return this;

    }



}
