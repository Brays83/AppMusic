package com.brayan.appmusic.Profile.Interfaces.Rest.Transform;

import com.brayan.appmusic.Profile.Domain.Model.Commands.CreateProfileCommand;
import com.brayan.appmusic.Profile.Interfaces.Rest.resources.CreateProfileResource;

import java.io.IOException;

public class CreateProfileCommandFromResourceAssembler {
    public static CreateProfileCommand toCommandFromResource(CreateProfileResource resource) throws IOException {
        return  new CreateProfileCommand(resource.photo().getBytes(),resource.email(),resource.firstName(),resource.lastName());
    }
}
