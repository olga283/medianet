package com.medianet.mapper;

import com.medianet.config.MapStructConfig;
import com.medianet.model.Profile;
import com.medianet.model.entity.ProfileEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(config = MapStructConfig.class)
public interface ProfileEntityMapper {
    Profile map(ProfileEntity profileEntity);
    ProfileEntity map(Profile profile);
    List<Profile> map(List<ProfileEntity> profileEntities);
}
