package com.lfchaim.insurance.quotation.infrastructure.adapters.output.persistence.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection="recordings")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductEntity {

    private String id;

    private String name;

    private String description;

}
