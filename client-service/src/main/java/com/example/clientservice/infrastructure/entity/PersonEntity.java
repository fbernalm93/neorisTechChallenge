package com.example.clientservice.infrastructure.entity;

import com.example.clientservice.domain.model.Gender;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Data
@Table(name = "person")
@Inheritance(strategy = InheritanceType.JOINED)
public class PersonEntity {
    @NotEmpty(message = "Field is required")
    @Size(min = 10, max = 10, message = "The length of identification should be 10")
    @Id
    @Column(name = "id", length = 10)
    @Pattern(regexp = "^[0-9]*$", message = "The field Name should always contain digits")
    private String id;

    @NotEmpty(message = "Field is required")
    @Column(name = "name", length = 100)
    @Pattern(regexp = "^[A-Za-z ]*$", message = "The field Name should always contain alphabetic characters")
    private String name;

    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "age")
    private Integer age;

    @NotEmpty(message = "Field is required")
    @Column(name = "address", length = 100)
    private String address;

    @NotEmpty(message = "Field is required")
    @Column(name = "phonenumber", length = 10)
    private String phoneNumber;
}
