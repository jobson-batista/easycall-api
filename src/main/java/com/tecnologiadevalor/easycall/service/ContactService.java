package com.tecnologiadevalor.easycall.service;

import com.tecnologiadevalor.easycall.exception.BadRequestException;
import com.tecnologiadevalor.easycall.exception.ContactCellPhoneAlreadyExistsException;
import com.tecnologiadevalor.easycall.exception.ContactEmailAlreadyExistsException;
import com.tecnologiadevalor.easycall.model.Contact;
import com.tecnologiadevalor.easycall.repository.ContactRepository;
import com.tecnologiadevalor.easycall.util.Util;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ContactService {

    private final ContactRepository contactRepository;

    private final Util util = new Util();

    public Contact saveContact(Contact contact) {
        int SIZE_CELL_PHONE = 11;
        if(contact.getEmail() != null && contactRepository.existsByEmail(contact.getEmail())) {
            throw new ContactEmailAlreadyExistsException();
        } else if(contact.getCellPhone() != null && contactRepository.existsByCellPhone(contact.getCellPhone())) {
            throw new ContactCellPhoneAlreadyExistsException();
        } else if(contact.getCellPhone() != null
                && contact.getCellPhone().length() != SIZE_CELL_PHONE
                && util.isNumeric(contact.getCellPhone())) {
            throw new BadRequestException("Invalid CellPhone", "The CellPhone field must have "+ SIZE_CELL_PHONE +" numeric characters");
        }
        contact.setCreatedAt(LocalDateTime.now());
        contact.setUpdatedAt(LocalDateTime.now());
        contact.setIsDeleted(Boolean.FALSE);
        contact.setIsActive(Boolean.TRUE);
        if(contact.getIsFavorite() == null) {
            contact.setIsFavorite(Boolean.FALSE);
        } else {
            contact.setIsFavorite(contact.getIsFavorite());
        }
        return contactRepository.save(contact);
    }

    public List<Contact> findContactsByCellPhone(String cellPhone) {
        return contactRepository.findByCellPhoneContainingAndIsDeletedFalse(cellPhone);
    }

    public Contact updateContact(Long id, Contact updatedContact) {

        Optional<Contact> existingContactOpt = contactRepository.findById(id);

        if (existingContactOpt.isPresent()) {

            Contact existingContact = existingContactOpt.get();

            if (updatedContact.getName() != null && !updatedContact.getName().isEmpty()) {
                existingContact.setName(updatedContact.getName());
            }
            if (updatedContact.getEmail() != null && !updatedContact.getEmail().isEmpty()) {
                existingContact.setEmail(updatedContact.getEmail());
            }
            if (updatedContact.getPhone() != null && !updatedContact.getPhone().isEmpty()) {
                existingContact.setPhone(updatedContact.getPhone());
            }
            if (updatedContact.getCellPhone() != null && !updatedContact.getCellPhone().isEmpty()) {
                existingContact.setCellPhone(updatedContact.getCellPhone());
            }
            if (updatedContact.getIsFavorite() != null && updatedContact.getIsFavorite() != existingContact.getIsFavorite()) {
                existingContact.setIsFavorite(updatedContact.getIsFavorite());
            }
            if (updatedContact.getIsActive()!= null && updatedContact.getIsActive() != existingContact.getIsActive()) {
                existingContact.setIsActive(updatedContact.getIsActive());
            }

            return contactRepository.save(existingContact);
        } else {
            throw new BadRequestException("Contact Not Found","Contact not found with ID: " + id);
        }
    }

    public Contact markLikeFavorite(Long id) {
        Optional<Contact> contact = contactRepository.findById(id);
        if(contact.isPresent()) {
            contact.get().setIsFavorite(Boolean.TRUE);
            return contactRepository.save(contact.get());
        } else {
            throw new BadRequestException("Contact Not Found","Contact not found with ID: " + id);
        }
    }

    public void deleteContact(Long id) {
        Optional<Contact> contact = contactRepository.findById(id);
        if(contact.isPresent()) {
            contact.get().setIsDeleted(Boolean.TRUE);
            contactRepository.save(contact.get());
        } else {
            throw new BadRequestException("Contact Not Found","Contact not found with ID: " + id);
        }
    }

}
