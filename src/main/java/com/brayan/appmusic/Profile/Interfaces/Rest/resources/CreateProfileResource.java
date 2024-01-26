package com.brayan.appmusic.Profile.Interfaces.Rest.resources;

import org.springframework.web.multipart.MultipartFile;

public record CreateProfileResource(
        MultipartFile photo,
        String firstName,
        String lastName,
        String email
) {
}
