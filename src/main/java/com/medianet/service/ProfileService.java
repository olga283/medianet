package com.medianet.service;

import com.medianet.model.Profile;

public interface ProfileService {
    Profile getProfileByUserId(String userId);
    Profile saveProfile(Profile profile);
}
