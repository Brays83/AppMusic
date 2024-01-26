package com.brayan.appmusic.MusicManager.Domain.Model.Entities;

import com.brayan.appmusic.Shared.Domain.model.entities.AuditableModel;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.Date;

@Entity
@Getter
public class Song extends AuditableModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String Name;

    @ManyToOne
    @JoinColumn(name = "album_id")
    private Album album;

    public Song(){}

    public Song(String name,Album album){
        this.Name=name;
        this.album=album;
        this.setCreateAt(new Date());
    }



}
