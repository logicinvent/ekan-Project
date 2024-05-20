package com.ekan.ekanproject.application.rest.v1.documenttype.mapper;

import com.ekan.ekanproject.domain.dto.beneficiary.DocumentTypeDto;
import com.ekan.ekanproject.domain.dto.shared.mapper.GenericMapper;
import com.ekan.ekanproject.domain.dto.shared.mapper.MapperSupport;
import com.ekan.ekanproject.domain.model.DocumentType;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DocumentTypeMapperImpl extends MapperSupport implements GenericMapper<DocumentTypeDto, DocumentType> {

    /**
     * Service available to convert DTOs to models
     * @param arg List<DocumentTypeDto>
     * @return List<DocumentType>
     */
    @Override
    public List<DocumentType> dtoToModelWithList(List<DocumentTypeDto> arg) {
        return arg.stream()
                .map(e -> modelMapper.map(e, DocumentType.class))
                .collect(Collectors.toList());
    }

    /**
     * Service available to convert models to DTOs
     * @param arg List<DocumentType>
     * @return List<DocumentTypeDto>
     */
    @Override
    public List<DocumentTypeDto> modelToDtoWithList(List<DocumentType> arg) {
        return arg.stream()
                .map(e -> DocumentTypeDto.builder()
                        .id(e.getId())
                        .description(e.getDescription())
                        .build())
                .collect(Collectors.toList());
    }

    /**
     * Service available to convert DTO to model
     * @param arg DocumentTypeDto
     * @return DocumentType
     */
    @Override
    public DocumentType dtoToModel(DocumentTypeDto arg) {
        return modelMapper.map(arg, DocumentType.class);
    }

    /**
     * Service available to convert model to DTO
     * @param arg DocumentType
     * @return DocumentTypeDto
     */
    @Override
    public DocumentTypeDto modelToDto(DocumentType arg) {
        return DocumentTypeDto.builder()
                .id(arg.getId())
                .description(arg.getDescription())
                .build();
    }

}
