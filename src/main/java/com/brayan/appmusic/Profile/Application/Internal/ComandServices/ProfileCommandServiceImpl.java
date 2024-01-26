package com.brayan.appmusic.Profile.Application.Internal.ComandServices;

import com.brayan.appmusic.Profile.Domain.Model.Aggregates.Profile;
import com.brayan.appmusic.Profile.Domain.Model.Commands.CreateProfileCommand;
import com.brayan.appmusic.Profile.Domain.Model.ValueObjects.EmailAddress;
import com.brayan.appmusic.Profile.Domain.Services.ProfileCommandService;
import com.brayan.appmusic.Profile.Infrastructure.Persistence.JPA.Repositories.ProfileRepository;
import com.brayan.appmusic.Profile.Infrastructure.Util.ImageUtils;
import org.springframework.stereotype.Service;

@Service
public class ProfileCommandServiceImpl implements ProfileCommandService {
    private final ProfileRepository profileRepository;

    public ProfileCommandServiceImpl(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Override
    public Long handle(CreateProfileCommand command) {

        var emailAddres = new EmailAddress(command.email());

        profileRepository.findByEmail(emailAddres).map(profile -> {
           throw  new IllegalArgumentException("Existe un perfil con este email");
        });

        //Comprimir imagen
        var photoCompressed = ImageUtils.compressImage(command.photo());
        var profile = new Profile(photoCompressed,command.email(), command.firstName(), command.lastName());

        profileRepository.save(profile);
        return profile.getId();
    }
}
