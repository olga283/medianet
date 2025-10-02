package com.medianet.model.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ProfileDto {
    String userId;
    String name;
    String surname;
    Date birthday;
    String gender;
    String biography;
    String city;
    String password;
}
