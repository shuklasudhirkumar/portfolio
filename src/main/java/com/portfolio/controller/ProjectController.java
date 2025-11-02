package com.portfolio.controller;

import com.portfolio.model.Projects;
import com.portfolio.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;

    @GetMapping
    public ResponseEntity<List<Projects>> getAllWorks() {
        List<Projects> works = projectService.getAllWorks();
        if (works.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(works);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Projects> getWorkById(@PathVariable Long id) {
        try {
            Projects work = projectService.getWorkById(id);
            return ResponseEntity.ok(work);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Projects> createWork(@RequestBody Projects work) {
        Projects created = projectService.createWork(work);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Projects> updateWork(@PathVariable Long id, @RequestBody Projects work) {
        try {
            Projects updated = projectService.updateWork(id, work);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWork(@PathVariable Long id) {
        try {
            projectService.deleteWork(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
