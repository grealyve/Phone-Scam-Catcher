package com.phoneScamCatcher.scatcher.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "phone")
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int phoneId;
    @Getter
    @Setter
    @Column(name = "phone_number")
    private String phoneNumber;
    @Getter
    @Setter
    @Column(name = "report_count")
    private int reportCount;

}
