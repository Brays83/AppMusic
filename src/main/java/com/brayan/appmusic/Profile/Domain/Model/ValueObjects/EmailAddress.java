package com.brayan.appmusic.Profile.Domain.Model.ValueObjects;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Email;

@Embeddable
public record EmailAddress(
        @Email
        String address) {
    public EmailAddress(){this(null);}
}
