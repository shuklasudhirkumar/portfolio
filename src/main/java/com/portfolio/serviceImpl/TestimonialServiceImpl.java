package com.portfolio.serviceImpl;

import com.portfolio.model.Testimonial;
import com.portfolio.repository.TestimonialRepository;
import com.portfolio.service.TestimonialService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TestimonialServiceImpl implements TestimonialService {

    private final TestimonialRepository testimonialRepository;

    @Override
    public List<Testimonial> getAllTestimonials() {
        return testimonialRepository.findAll();
    }

    @Override
    public Testimonial getTestimonialById(Long id) {
        return testimonialRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Testimonial not found with id: " + id));
    }

    @Override
    public Testimonial createTestimonial(Testimonial testimonial) {
        return testimonialRepository.save(testimonial);
    }

    @Override
    public Testimonial updateTestimonial(Long id, Testimonial updated) {
        Testimonial existing = getTestimonialById(id);
        existing.setName(updated.getName());
        existing.setCompany(updated.getCompany());
        existing.setImgurl(updated.getImgurl());
        existing.setFeedback(updated.getFeedback());
        return testimonialRepository.save(existing);
    }

    @Override
    public void deleteTestimonial(Long id) {
        testimonialRepository.deleteById(id);
    }
}
