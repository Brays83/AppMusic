package com.brayan.appmusic.MusicManager.Domain.Model.Entities;

import com.brayan.appmusic.Shared.Domain.model.entities.AuditableModel;
import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.web.service.annotation.GetExchange;

import javax.print.attribute.standard.MediaSize;
import java.util.Date;


@Entity
@Getter
public class Album extends AuditableModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String Name;


    @OneToOne
    @JoinColumn(name = "artist_id")
    private Artist artist;

    public Album(){}

    public Album(String name,Artist artist){
        this.Name= name;
        this.artist=artist;
        this.setCreateAt(new Date());

    }
}
