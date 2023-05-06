package com.project.demo.mappers;

import com.project.demo.models.dtomodels.Select2ModelDto;
import java.util.Map;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface Select2Mapper {

  @Mapping(source = "entry.key", target = "id")
  @Mapping(source = "entry.value", target = "text")
  Select2ModelDto roleModelToSelect2ModelDto(Map.Entry<Integer, String> entry);

}
