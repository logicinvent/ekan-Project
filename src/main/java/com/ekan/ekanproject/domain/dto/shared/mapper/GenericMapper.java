package com.ekan.ekanproject.domain.dto.shared.mapper;

import java.util.List;

public interface GenericMapper<dto, model> {

    List<model> dtoToModelWithList(final List<dto> arg);
    List<dto> modelToDtoWithList(final List<model> arg);

    model dtoToModel(final dto arg);
    dto modelToDto(final model arg);

}
