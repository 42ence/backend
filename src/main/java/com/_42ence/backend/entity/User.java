package com._42ence.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "intra_id")
    private String intraId;

    private double level;

    @UpdateTimestamp
    private LocalDateTime reloadTime;

    @Column(name = "access_token")
    private String accessToken;

}
