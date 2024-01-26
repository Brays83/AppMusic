package com.brayan.appmusic.Profile.Interfaces.Rest;

import com.brayan.appmusic.Profile.Domain.Model.Queries.GetAllProfilesQuery;
import com.brayan.appmusic.Profile.Domain.Model.Queries.GetProfileByIdQuery;
import com.brayan.appmusic.Profile.Domain.Services.ProfileCommandService;
import com.brayan.appmusic.Profile.Domain.Services.ProfileQueryService;
import com.brayan.appmusic.Profile.Interfaces.Rest.Transform.CreateProfileCommandFromResourceAssembler;
import com.brayan.appmusic.Profile.Interfaces.Rest.Transform.ProfileResourceFromEntityAssembler;
import com.brayan.appmusic.Profile.Interfaces.Rest.resources.CreateProfileResource;
import com.brayan.appmusic.Profile.Interfaces.Rest.resources.ProfileResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "api/v1/profiles", produces = APPLICATION_JSON_VALUE)
public class ProfileController {
    private final ProfileCommandService profileCommandService;
    private final ProfileQueryService profileQueryService;

    public ProfileController(ProfileCommandService profileCommandService, ProfileQueryService profileQueryService) {

        this.profileCommandService = profileCommandService;
        this.profileQueryService = profileQueryService;
    }

    @GetMapping
    public ResponseEntity<List<ProfileResource>> getAllProfiles(){
        var getAllProfilesQuery =new GetAllProfilesQuery();

        var profiles = profileQueryService.handle(getAllProfilesQuery);
        var profileResources = profiles.stream().map(ProfileResourceFromEntityAssembler::toResourceFromEntity).collect(Collectors.toList());

        return ResponseEntity.ok(profileResources);
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<ProfileResource> createProfile( @ModelAttribute CreateProfileResource resource) throws IOException {

        var createProfileCommand = CreateProfileCommandFromResourceAssembler.toCommandFromResource(resource);
        var profileId = profileCommandService.handle(createProfileCommand);

        if(profileId==0){
            return ResponseEntity.badRequest().build();
        }

        var getProfileByIdQuery = new GetProfileByIdQuery(profileId);
        var profile = profileQueryService.handle(getProfileByIdQuery);

        if(profile.isEmpty()){
            return ResponseEntity.badRequest().build();
        }

        var profileResource = ProfileResourceFromEntityAssembler.toResourceFromEntity(profile.get());
        return new ResponseEntity<>(profileResource, HttpStatus.CREATED);
    }
}

