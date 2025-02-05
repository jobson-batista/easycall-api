package com.tecnologiadevalor.easycall.model;

import jakarta.persistence.*;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Contact extends EntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String name;

    private String email;

    @Column(length = 10)
    private String phone;

    @Column(length = 11)
    private String cellPhone;

    private Boolean isFavorite;

    private Boolean isActive;
}
