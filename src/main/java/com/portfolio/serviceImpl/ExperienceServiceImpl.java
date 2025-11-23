package com.portfolio.serviceImpl;

import com.portfolio.model.Experience;
import com.portfolio.repository.ExperienceRepository;
import com.portfolio.service.ExperienceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExperienceServiceImpl implements ExperienceService {

    private final ExperienceRepository experienceRepository;

    @Override
    public List<Experience> getAllExperiences() {
        return experienceRepository.findAll();
    }

    @Override
    public Experience getExperienceById(Long id) {
        return experienceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Experience not found with id: " + id));
    }

    @Override
    public Experience createExperience(Experience experience) {
        return experienceRepository.save(experience);
    }

    @Override
    public Experience updateExperience(Long id, Experience updatedExperience) {
        Experience experience = getExperienceById(id);

        // Update fields
        experience.setRole(updatedExperience.getRole());
        experience.setCompany(updatedExperience.getCompany());
        experience.setPeriod(updatedExperience.getPeriod());
        experience.setDescription(updatedExperience.getDescription());
        experience.setSkills(updatedExperience.getSkills());

        return experienceRepository.save(experience);
    }

    @Override
    public void deleteExperience(Long id) {
        experienceRepository.deleteById(id);
    }
}
