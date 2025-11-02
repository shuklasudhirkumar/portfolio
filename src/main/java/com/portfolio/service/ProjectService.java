package com.portfolio.service;

import com.portfolio.model.Projects;
import java.util.List;

public interface ProjectService {
    List<Projects> getAllWorks();
    Projects getWorkById(Long id);
    Projects createWork(Projects work);
    Projects updateWork(Long id, Projects work);
    void deleteWork(Long id);
}
