package com.portfolio.service;

import com.portfolio.model.Skill;
import java.util.List;

public interface SkillService {
    List<Skill> getAllSkills();
    Skill getSkillById(Long id);
    Skill createSkill(Skill skill);
    Skill updateSkill(Long id, Skill skill);
    void deleteSkill(Long id);
}
