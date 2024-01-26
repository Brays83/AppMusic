package com.brayan.appmusic.Profile.Interfaces.Rest.resources;

public record ProfileResource(
        Long id,
        String fullName,
        String email,
        byte[] photo
) {
}
