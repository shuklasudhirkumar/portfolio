package com.portfolio.serviceImpl;

import com.portfolio.model.About;
import com.portfolio.repository.AboutRepository;
import com.portfolio.service.AboutService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AboutServiceImpl implements AboutService {

    private final AboutRepository aboutRepository;

    @Override
    public List<About> getAllAbouts() {
        return aboutRepository.findAll();
    }

    @Override
    public About getAboutById(Long id) {
        return aboutRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("About not found with id: " + id));
    }

    @Override
    public About createAbout(About about) {
        return aboutRepository.save(about);
    }

    @Override
    public About updateAbout(Long id, About updatedAbout) {
        About about = getAboutById(id);
        about.setTitle(updatedAbout.getTitle());
        about.setDescription(updatedAbout.getDescription());
        about.setImgUrl(updatedAbout.getImgUrl());
        return aboutRepository.save(about);
    }

    @Override
    public void deleteAbout(Long id) {
        aboutRepository.deleteById(id);
    }
}
