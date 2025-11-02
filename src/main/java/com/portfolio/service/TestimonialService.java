package com.portfolio.service;

import com.portfolio.model.Testimonial;
import java.util.List;

public interface TestimonialService {
    List<Testimonial> getAllTestimonials();
    Testimonial getTestimonialById(Long id);
    Testimonial createTestimonial(Testimonial testimonial);
    Testimonial updateTestimonial(Long id, Testimonial testimonial);
    void deleteTestimonial(Long id);
}
