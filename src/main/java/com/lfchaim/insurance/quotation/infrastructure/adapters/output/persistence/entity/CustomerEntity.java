package com.lfchaim.insurance.quotation.infrastructure.adapters.output.persistence.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerEntity {

	private String document_number;
    private String name;
    private String type;
    private String gender;
    private String date_of_birth;
    private String email;
    private Long phone_number;
    
}