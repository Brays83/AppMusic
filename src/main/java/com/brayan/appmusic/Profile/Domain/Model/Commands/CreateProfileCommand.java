package com.brayan.appmusic.Profile.Domain.Model.Commands;

public record CreateProfileCommand(byte[] photo,String email,String firstName,String lastName) {
}
