package com.medianet.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Date;

@Getter
@Setter
@Table("profile")
@NoArgsConstructor
@AllArgsConstructor
public class ProfileEntity {
    @Id
    Long id;
    @Column("user_id")
    String userId;
    @Column("first_name")
    String name;
    @Column("second_name")
    String surname;
    Date birthday;
    String gender;
    String biography;
    String city;
    String password;
}
