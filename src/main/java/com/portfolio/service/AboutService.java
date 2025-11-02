package com.portfolio.service;

import com.portfolio.model.About;

import java.util.List;

public interface AboutService {

    List<About> getAllAbouts();
    About getAboutById(Long id);
    About createAbout(About about);
    About updateAbout(Long id, About about);
    void deleteAbout(Long id);

}
