package com.brayan.appmusic.Profile.Domain.Services;

import com.brayan.appmusic.Profile.Domain.Model.Commands.CreateProfileCommand;

public interface ProfileCommandService {
    Long handle(CreateProfileCommand command);
}
