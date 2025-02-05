package com.tecnologiadevalor.easycall.controller;

import com.tecnologiadevalor.easycall.model.Contact;
import com.tecnologiadevalor.easycall.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contact")
@RequiredArgsConstructor
public class ContactController {

    private final ContactService contactService;

    @PostMapping
    public ResponseEntity<Contact> saveContact(@RequestBody Contact contact) {
        return new ResponseEntity<>(contactService.saveContact(contact), HttpStatus.OK);
    }

    @GetMapping("/{cellPhone}")
    public ResponseEntity<List<Contact>> findContactsByCellPhone(@PathVariable String cellPhone) {
        return new ResponseEntity<>(contactService.findContactsByCellPhone(cellPhone), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Contact> updateContactById(@PathVariable Long id, @RequestBody Contact contact) {
        return new ResponseEntity<>(contactService.updateContact(id, contact), HttpStatus.OK);
    }
}
