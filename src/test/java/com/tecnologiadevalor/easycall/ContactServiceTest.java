package com.tecnologiadevalor.easycall;

import com.tecnologiadevalor.easycall.exception.ContactCellPhoneAlreadyExistsException;
import com.tecnologiadevalor.easycall.exception.ContactEmailAlreadyExistsException;
import com.tecnologiadevalor.easycall.model.Contact;
import com.tecnologiadevalor.easycall.repository.ContactRepository;
import com.tecnologiadevalor.easycall.service.ContactService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ContactServiceTest {

    @Mock
    private ContactRepository contactRepository;

    @InjectMocks
    private ContactService contactService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveContact_defaultFlow() {
        Contact contact = new Contact();
        contact.setId(1L);
        contact.setName("Dev Jobson");
        contact.setEmail("jobson@email.com");
        contact.setPhone("9999999999");
        contact.setCellPhone("99999999999");

        when(contactRepository.save(contact)).thenReturn(contact);

        Contact savedContact = contactService.saveContact(contact);

        assertNotNull(savedContact);
        assertEquals(1L, savedContact.getId());
        assertEquals("Dev Jobson", savedContact.getName());
        assertEquals(11, savedContact.getCellPhone().length());
        assertEquals(10, savedContact.getPhone().length());
        assertEquals("jobson@email.com", savedContact.getEmail());

        verify(contactRepository, times(1)).save(contact);
    }

    @Test
    void testSaveContact_emailAlreadyExistsException() {
        Contact contact1 = new Contact();
        contact1.setEmail("jobson@email.com");

        // Simulating that the email already exists
        when(contactRepository.existsByEmail(contact1.getEmail())).thenReturn(true);

        assertThrowsExactly(ContactEmailAlreadyExistsException.class, () -> {
            contactService.saveContact(contact1);
        });
    }

    @Test
    void testSaveContact_cellphoneAlreadyExistsException() {
        Contact contact1 = new Contact();
        contact1.setCellPhone("99999999999");

        when(contactRepository.existsByCellPhone(contact1.getCellPhone())).thenReturn(true);

        assertThrowsExactly(ContactCellPhoneAlreadyExistsException.class, () -> {
            contactService.saveContact(contact1);
        });
    }
}
