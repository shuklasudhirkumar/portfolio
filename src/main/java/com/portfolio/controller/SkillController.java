package com.portfolio.controller;

import com.portfolio.model.Projects;
import com.portfolio.model.Skill;
import com.portfolio.service.SkillService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/skills")
@RequiredArgsConstructor
public class SkillController {

    private final SkillService skillService;

    @GetMapping
    public ResponseEntity<List<Skill>> getAllSkills() {

        List<Skill> skills = skillService.getAllSkills();
        if (skills.isEmpty()){
                return ResponseEntity.noContent().build();
            }
        return  ResponseEntity.ok(skills);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Skill> getSkillById(@PathVariable Long id) {

        try{
            Skill skill = skillService.getSkillById(id);
            return ResponseEntity.ok(skill);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Skill> createSkill(@RequestBody Skill skill) {

        Skill skill1 = skillService.createSkill(skill);
        return ResponseEntity.status(HttpStatus.CREATED).body(skill1);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Skill> updateSkill(@PathVariable Long id, @RequestBody Skill skill) {

        try {
            Skill updated = skillService.updateSkill(id, skill);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSkill(@PathVariable Long id) {

        try {
            skillService.deleteSkill(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
