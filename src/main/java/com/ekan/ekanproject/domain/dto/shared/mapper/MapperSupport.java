package com.ekan.ekanproject.domain.dto.shared.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public abstract class MapperSupport {

    public ModelMapper modelMapper = new ModelMapper();

}
