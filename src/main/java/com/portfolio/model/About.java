package com.portfolio.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "abouts")
@Data                   // Generates getters, setters, toString, equals, hashCode
@NoArgsConstructor       // Generates a no-args constructor
@AllArgsConstructor      // Generates an all-args constructor
public class About {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(length = 2000)
    private String description;

    private String imgUrl;
}
