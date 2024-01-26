package com.brayan.appmusic.Profile.Infrastructure.Persistence.JPA.Repositories;

import com.brayan.appmusic.Profile.Domain.Model.Aggregates.Profile;
import com.brayan.appmusic.Profile.Domain.Model.ValueObjects.EmailAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfileRepository extends JpaRepository<Profile,Long> {
    Optional<Profile> findByEmail(EmailAddress emailAddress);
    Boolean existsByEmail(EmailAddress emailAddress);
}
