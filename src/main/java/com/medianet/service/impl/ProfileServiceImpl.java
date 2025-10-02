package com.medianet.service.impl;

import com.medianet.exception.ProfileNotFoundException;
import com.medianet.mapper.ProfileEntityMapper;
import com.medianet.model.Profile;
import com.medianet.model.entity.ProfileEntity;
import com.medianet.repository.ProfileRepository;
import com.medianet.service.ProfileService;
import com.medianet.service.encoder.PasswordCoder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService {
    private final ProfileRepository profileRepository;
    private final ProfileEntityMapper profileEntityMapper;
    private final PasswordCoder passwordCoder;

    @Override
    public Profile getProfileByUserId(String userId) {
        ProfileEntity profileEntity = profileRepository
                .getProfileByUserId(userId).orElseThrow(() -> new ProfileNotFoundException(userId));
        return profileEntityMapper.map(profileEntity);
    }

    @Override
    public Profile saveProfile(Profile profile) {
        ProfileEntity profileEntity = new ProfileEntity();

        String userId = UUID.randomUUID().toString();
        profileEntity.setUserId(userId);
        profileEntity.setName(profile.getName());
        profileEntity.setSurname(profile.getSurname());
        profileEntity.setBirthday(profile.getBirthday());
        profileEntity.setGender(profile.getGender());
        profileEntity.setBiography(profile.getBiography());
        profileEntity.setCity(profile.getCity());
        String codedPassword = passwordCoder.encode(profile.getPassword());
        profileEntity.setPassword(codedPassword);
        ProfileEntity savedProfileEntity = profileRepository.save(profileEntity);

        return profileEntityMapper.map(savedProfileEntity);
    }
}
