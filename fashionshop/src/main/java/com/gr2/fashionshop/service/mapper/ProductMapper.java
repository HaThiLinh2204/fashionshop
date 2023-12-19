package com.gr2.fashionshop.service.mapper;

import com.gr2.fashionshop.domain.Category;
import com.gr2.fashionshop.domain.Product;
import com.gr2.fashionshop.service.dto.ProductDTO;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

/**
 * Mapper for the entity {@link Product} and its DTO {@link ProductDTO}.
 */
@Mapper(componentModel = "spring")
public interface ProductMapper extends EntityMapper<ProductDTO, Product> {
//    @Mapping(target = "category", source = "category", qualifiedByName = "categoryId")
//    ProductDTO toDTO(Product s);
}
