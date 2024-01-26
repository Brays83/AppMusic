package com.brayan.appmusic.Profile.Domain.Services;

import com.brayan.appmusic.Profile.Domain.Model.Aggregates.Profile;
import com.brayan.appmusic.Profile.Domain.Model.Queries.GetAllProfilesQuery;
import com.brayan.appmusic.Profile.Domain.Model.Queries.GetProfileByEmailQuery;
import com.brayan.appmusic.Profile.Domain.Model.Queries.GetProfileByIdQuery;

import java.util.List;
import java.util.Optional;

public interface ProfileQueryService {
    Optional<Profile> handle(GetProfileByEmailQuery query);
    Optional<Profile> handle(GetProfileByIdQuery query);
    List<Profile> handle(GetAllProfilesQuery query);



}
