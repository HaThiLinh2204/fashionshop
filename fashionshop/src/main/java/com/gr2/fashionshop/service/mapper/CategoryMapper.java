package com.gr2.fashionshop.service.mapper;

import com.gr2.fashionshop.domain.Category;
import com.gr2.fashionshop.service.dto.CategoryDTO;
import org.mapstruct.Mapper;

/**
 * Mapper for the entity {@link Category} and its DTO {@link CategoryDTO}.
 */
@Mapper(componentModel = "spring")
public interface CategoryMapper extends EntityMapper<CategoryDTO, Category> {}
