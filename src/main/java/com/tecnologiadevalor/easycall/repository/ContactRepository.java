package com.tecnologiadevalor.easycall.repository;

import com.tecnologiadevalor.easycall.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {

    boolean existsByCellPhone(String cellPhone);
    boolean existsByEmail(String email);
}
