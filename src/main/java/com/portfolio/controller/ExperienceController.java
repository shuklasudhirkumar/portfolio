package com.portfolio.controller;

import com.portfolio.model.About;
import com.portfolio.model.Experience;
import com.portfolio.service.ExperienceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/experiences")
@RequiredArgsConstructor
public class ExperienceController {

    private final ExperienceService experienceService;

    @GetMapping
    public ResponseEntity<List<Experience>> getAllExperiences() {

        List<Experience> experiences = experienceService.getAllExperiences();
        if (experiences.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(experiences);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Experience> getExperienceById(@PathVariable Long id) {

        try{
            Experience experience = experienceService.getExperienceById(id);
            return ResponseEntity.ok(experience);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Experience> createExperience(@RequestBody Experience experience) {

        Experience experience1 = experienceService.createExperience(experience);
        return ResponseEntity.status(HttpStatus.CREATED).body(experience1);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Experience> updateExperience(@PathVariable Long id, @RequestBody Experience experience) {

        try {
            Experience updated = experienceService.updateExperience(id, experience);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExperience(@PathVariable Long id) {

        try {
            experienceService.deleteExperience(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}

