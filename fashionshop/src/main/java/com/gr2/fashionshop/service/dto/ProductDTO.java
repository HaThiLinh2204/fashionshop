package com.gr2.fashionshop.service.dto;

import com.gr2.fashionshop.domain.Category;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import lombok.NoArgsConstructor;

/**
 * A DTO for the {@link com.gr2.fashionshop.domain.Product} entity.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO implements Serializable {

    private String product_id;

    private String name;

    private String description;

    private Double price;


}
