package com.portfolio.controller;

import com.portfolio.model.Skill;
import com.portfolio.model.Testimonial;
import com.portfolio.service.TestimonialService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/testimonials")
@RequiredArgsConstructor
public class TestimonialController {

    private final TestimonialService testimonialService;

    @GetMapping
    public ResponseEntity<List<Testimonial>> getAllTestimonials() {

        List<Testimonial> testimonials = testimonialService.getAllTestimonials();
        if (testimonials.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(testimonials);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Testimonial> getTestimonialById(@PathVariable Long id) {

        try {
            Testimonial testimonial = testimonialService.getTestimonialById(id);
            return ResponseEntity.ok(testimonial);
        }
        catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Testimonial> createTestimonial(@RequestBody Testimonial testimonial) {
        Testimonial testimonial1 = testimonialService.createTestimonial(testimonial);
        return ResponseEntity.status(HttpStatus.CREATED).body(testimonial1);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Testimonial> updateTestimonial(@PathVariable Long id, @RequestBody Testimonial testimonial) {

        try {
            Testimonial updated = testimonialService.updateTestimonial(id, testimonial);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTestimonial(@PathVariable Long id) {

        try {
            testimonialService.deleteTestimonial(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
