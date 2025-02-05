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

@Service
@RequiredArgsConstructor
public class ContactService {

    private final ContactRepository contactRepository;

    private final Util util = new Util();

    private final int SIZE_CELL_PHONE = 11;

    public Contact saveContact(Contact contact) {
        if(contact.getEmail() != null && contactRepository.existsByEmail(contact.getEmail())) {
            throw new ContactEmailAlreadyExistsException();
        } else if(contact.getCellPhone() != null && contactRepository.existsByCellPhone(contact.getCellPhone())) {
            throw new ContactCellPhoneAlreadyExistsException();
        } else if(contact.getCellPhone() != null
                && contact.getCellPhone().length() != SIZE_CELL_PHONE
                && util.isNumeric(contact.getCellPhone())) {
            throw new BadRequestException("Invalid CellPhone", "The CellPhone field must have "+SIZE_CELL_PHONE+" numeric characters");
        }
        contact.setCreatedAt(LocalDateTime.now());
        contact.setUpdatedAt(LocalDateTime.now());
        contact.setDeleted(false);
        contact.setActive(true);
        contact.setFavorite(contact.isFavorite());
        return contactRepository.save(contact);
    }

    public List<Contact> findContactsByCellPhone(String cellPhone) {
        return contactRepository.findByCellPhoneContaining(cellPhone);
    }
}
