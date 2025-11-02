package com.portfolio.serviceImpl;

import com.portfolio.model.Contact;
import com.portfolio.repository.ContactRepository;
import com.portfolio.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContactServiceImpl implements ContactService {

    private final ContactRepository contactRepository;

    @Override
    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }

    @Override
    public Contact getContactById(Long id) {
        return contactRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contact not found with id: " + id));
    }

    @Override
    public Contact createContact(Contact contact) {
        return contactRepository.save(contact);
    }

    @Override
    public Contact updateContact(Long id, Contact updatedContact) {
        Contact contact = getContactById(id);
        contact.setEmail(updatedContact.getEmail());
        contact.setPhone(updatedContact.getPhone());
        contact.setAddress(updatedContact.getAddress());
        contact.setLinkedIn(updatedContact.getLinkedIn());
        contact.setGithub(updatedContact.getGithub());
        contact.setTwitter(updatedContact.getTwitter());
        return contactRepository.save(contact);
    }

    @Override
    public void deleteContact(Long id) {
        contactRepository.deleteById(id);
    }
}
