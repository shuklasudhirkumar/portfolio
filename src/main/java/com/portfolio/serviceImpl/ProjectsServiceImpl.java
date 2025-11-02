package com.portfolio.serviceImpl;

import com.portfolio.model.Projects;
import com.portfolio.repository.ProjectsRepository;

import com.portfolio.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectsServiceImpl implements ProjectService {

    private final ProjectsRepository workRepository;

    @Override
    public List<Projects> getAllWorks() {
        return workRepository.findAll();
    }

    @Override
    public Projects getWorkById(Long id) {
        return workRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Work not found with id: " + id));
    }

    @Override
    public Projects createWork(Projects work) {
        return workRepository.save(work);
    }

    @Override
    public Projects updateWork(Long id, Projects updatedWork) {
        Projects work = getWorkById(id);
        work.setTitle(updatedWork.getTitle());
        work.setDescription(updatedWork.getDescription());
        work.setProjectLink(updatedWork.getProjectLink());
        work.setCodeLink(updatedWork.getCodeLink());
        work.setImgUrl(updatedWork.getImgUrl());
        work.setTags(updatedWork.getTags());
        return workRepository.save(work);
    }

    @Override
    public void deleteWork(Long id) {
        workRepository.deleteById(id);
    }
}
