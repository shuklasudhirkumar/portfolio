package com.portfolio.controller;


import com.portfolio.model.About;
import com.portfolio.model.Skill;
import com.portfolio.service.AboutService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/about")
@RequiredArgsConstructor   // Injects final AboutService automatically
public class AboutController {

    private final AboutService aboutService;

    @GetMapping
    public ResponseEntity<List<About>> getAllAbouts() {

        List<About> abouts = aboutService.getAllAbouts();
        if (abouts.isEmpty()){
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(abouts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<About> getAboutById(@PathVariable Long id) {

        try{
            About about = aboutService.getAboutById(id);
            return ResponseEntity.ok(about);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<About> createAbout(@RequestBody About about) {

        About about1 = aboutService.createAbout(about);
        return ResponseEntity.status(HttpStatus.CREATED).body(about1);

    }

    @PutMapping("/{id}")
    public ResponseEntity<About> updateAbout(@PathVariable Long id, @RequestBody About about) {

        try {
            About updated = aboutService.updateAbout(id, about);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAbout(@PathVariable Long id) {

        try {
            aboutService.deleteAbout(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
