package com.medianet.service.impl;

import com.medianet.model.Profile;
import com.medianet.service.LoginService;
import com.medianet.service.ProfileService;
import com.medianet.service.encoder.PasswordCoder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {
    private final ProfileService profileService;
    private final PasswordCoder passwordCoder;

    @Override
    public String login(String userId, String password) {
        Profile profileById = profileService.getProfileByUserId(userId);
        String profilePassword = profileById.getPassword();
        if (!passwordCoder.matches(password, profilePassword)) {
            return "Wrong password";
        }
        return "Success";
    }
}
