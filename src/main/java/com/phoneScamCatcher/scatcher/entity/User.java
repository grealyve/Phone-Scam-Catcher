package com.phoneScamCatcher.scatcher.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;
    @Setter
    @Getter
    private String name;
    @Setter
    @Getter
    private String password;
    @Getter
    @Setter
    private String phoneNumber;
}
