package com.brayan.appmusic.Profile.Interfaces.Rest.Transform;

import com.brayan.appmusic.Profile.Domain.Model.Aggregates.Profile;
import com.brayan.appmusic.Profile.Infrastructure.Util.ImageUtils;
import com.brayan.appmusic.Profile.Interfaces.Rest.resources.ProfileResource;

public class ProfileResourceFromEntityAssembler {
    public static ProfileResource toResourceFromEntity(Profile entity){
        return new ProfileResource(entity.getId(),entity.gettFullName(),entity.getEmail(), ImageUtils.decompressImage(entity.getPhoto()));
    }
}
