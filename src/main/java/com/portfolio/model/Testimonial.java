package com.portfolio.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "testimonials")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Testimonial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String company;

    // Store image URL (from CDN, Cloudinary, etc.)
    @Column(name = "img_url")
    private String imgurl;

    @Column(columnDefinition = "TEXT")
    private String feedback;
}
