package com.tecnologiadevalor.easycall.service;

import com.tecnologiadevalor.easycall.exception.ContactCellPhoneAlreadyExistsException;
import com.tecnologiadevalor.easycall.exception.ContactEmailAlreadyExistsException;
import com.tecnologiadevalor.easycall.model.Contact;
import com.tecnologiadevalor.easycall.repository.ContactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ContactService {

    private final ContactRepository contactRepository;

    public Contact saveContact(Contact contact) {
        if(contactRepository.existsByEmail(contact.getEmail())) {
            throw new ContactEmailAlreadyExistsException();
        } else if(contactRepository.existsByCellPhone(contact.getCellPhone())) {
            throw new ContactCellPhoneAlreadyExistsException();
        }
        contact.setCreatedAt(LocalDateTime.now());
        contact.setUpdatedAt(LocalDateTime.now());
        contact.setDeleted(false);
        contact.setActive(true);
        contact.setFavorite(contact.isFavorite());
        return contactRepository.save(contact);
    }
}
