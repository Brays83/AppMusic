package com.brayan.appmusic.Profile.Domain.Model.Queries;

import com.brayan.appmusic.Profile.Domain.Model.ValueObjects.EmailAddress;

public record GetProfileByEmailQuery(EmailAddress emailAddress) {
}
