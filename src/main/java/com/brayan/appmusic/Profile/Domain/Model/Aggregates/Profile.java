package com.brayan.appmusic.Profile.Domain.Model.Aggregates;

import com.brayan.appmusic.Profile.Domain.Model.ValueObjects.EmailAddress;
import com.brayan.appmusic.Profile.Domain.Model.ValueObjects.PersonName;
import com.brayan.appmusic.Shared.Domain.model.entities.AuditableModel;
import com.fasterxml.jackson.databind.util.NativeImageUtil;
import jakarta.persistence.*;

import jakarta.validation.constraints.Email;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.AbstractAggregateRoot;

import java.util.Date;

@Getter
@Entity
public class Profile extends AuditableModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Embedded
    private PersonName name;

    @Embedded
    private EmailAddress email;

    @Lob
    @Column(length = 500000)
    private byte[] photo;


    public Profile(){}

    public Profile(byte[] photo,String email,String firstName,String lastName){
        this.name=new PersonName(firstName,lastName);
        this.email=new EmailAddress(email);
        this.photo=photo;
        this.setCreateAt(new Date());

    }

    public void updateName(String firstName,String lastName){
        this.name=new PersonName(firstName,lastName);
    }

    public String gettFullName(){
        return this.name.getFullName();
    }

    public String getEmail(){
        return this.email.address();
    }




}
