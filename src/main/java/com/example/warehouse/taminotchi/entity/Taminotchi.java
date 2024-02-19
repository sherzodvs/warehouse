package com.example.warehouse.taminotchi.entity;

import com.example.warehouse.common.abstractClass.AbsClass;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Taminotchi extends AbsClass {

    @NotBlank
    @Column(unique = true, nullable = false)
    private String name;

    @NotBlank
    @Column(unique = true, nullable = false)
    //@Pattern(regexp = "(\\+?\\d{1,4}[-.\\s]?\\(?\\d{1,3}\\)?[-.\\s]?\\d{1,4}[-.\\s]?\\d{1,9})")
    private String phoneNumber;

//    public boolean isValid() {
//        return isValidName() && isValidPhoneNumber();
//    }

    private boolean isValidName(String name) {
        // Name uchun regex pattern
        String namePattern = "^[A-Za-z\\s]{1,50}$"; // Harflar va probellar, 1 dan 50 gacha
        return validateField(name, namePattern);
    }

    private boolean isValidPhoneNumber() {
        // PhoneNumber uchun regex pattern (o'zgartiring)
        String phoneNumberPattern = "(\\+?\\d{1,4}[-.\\s]?\\(?\\d{1,3}\\)?[-.\\s]?\\d{1,4}[-.\\s]?\\d{1,9})"; // Raqamlar, + belgisi (agar bor bo'lsa), 1 dan 15 gacha
        return validateField(phoneNumber, phoneNumberPattern);
    }

    private boolean validateField(String fieldValue, String pattern) {
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(fieldValue);
        return matcher.matches();
    }

    public void setName(String name) {
        if (isValidName(name)){

        }
        this.name = name;
    }
}
