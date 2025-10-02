package com.medianet.model;

import lombok.Data;

import java.util.Date;

@Data
public class Profile {
    String userId;
    String name;
    String surname;
    Date birthday;
    String gender;
    String biography;
    String city;
    String password;
}
