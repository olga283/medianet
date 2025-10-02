package com.medianet.mapper;

import com.medianet.config.MapStructConfig;
import com.medianet.model.Profile;
import com.medianet.model.dto.ProfileDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(config = MapStructConfig.class)
public interface ProfileDtoMapper {
    Profile map(ProfileDto profileDto);
    ProfileDto map(Profile profile);
    List<ProfileDto> map(List<Profile> profiles);
}
