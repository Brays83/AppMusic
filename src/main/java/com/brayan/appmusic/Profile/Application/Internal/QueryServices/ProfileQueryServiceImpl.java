package com.brayan.appmusic.Profile.Application.Internal.QueryServices;

import com.brayan.appmusic.Profile.Domain.Model.Aggregates.Profile;
import com.brayan.appmusic.Profile.Domain.Model.Queries.GetAllProfilesQuery;
import com.brayan.appmusic.Profile.Domain.Model.Queries.GetProfileByEmailQuery;
import com.brayan.appmusic.Profile.Domain.Model.Queries.GetProfileByIdQuery;
import com.brayan.appmusic.Profile.Domain.Services.ProfileQueryService;
import com.brayan.appmusic.Profile.Infrastructure.Persistence.JPA.Repositories.ProfileRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfileQueryServiceImpl implements ProfileQueryService {

    private final ProfileRepository profileRepository;

    public ProfileQueryServiceImpl(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Override
    public Optional<Profile> handle(GetProfileByEmailQuery query) {
        return profileRepository.findByEmail(query.emailAddress());
    }

    @Override
    public Optional<Profile> handle(GetProfileByIdQuery query) {
        return profileRepository.findById(query.Id());
    }

    @Override
    public List<Profile> handle(GetAllProfilesQuery query) {
        return profileRepository.findAll();
    }
}
/*    public String uploadImage(MultipartFile file) throws IOException {
        ImageData imageData = repository.save(ImageData.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .imageData(ImageUtils.compressImage(file.getBytes())).build());
        if (imageData != null) {
            return "file uploaded successfully : " + file.getOriginalFilename();
        }
        return null;
    }



    public byte[] downloadImage(String fileName) {
        Optional<ImageData> dbImageData = repository.findByName(fileName);
        byte[] images = ImageUtils.decompressImage(dbImageData.get().getImageData());
        return images;
    }*/
