package com.ekan.ekanproject.application.rest.v1.document.mapper;

import com.ekan.ekanproject.domain.dto.beneficiary.DocumentDto;
import com.ekan.ekanproject.domain.dto.beneficiary.DocumentTypeDto;
import com.ekan.ekanproject.domain.dto.shared.mapper.GenericMapper;
import com.ekan.ekanproject.domain.dto.shared.mapper.MapperSupport;
import com.ekan.ekanproject.domain.model.Document;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DocumentMapperImpl extends MapperSupport implements GenericMapper<DocumentDto, Document> {

    /**
     * Service available to convert DTOs to models
     * @param arg List<DocumentDto>
     * @return List<Document>
     */
    @Override
    public List<Document> dtoToModelWithList(List<DocumentDto> arg) {
        return arg.stream()
                .map(e -> modelMapper.map(e, Document.class))
                .collect(Collectors.toList());
    }

    /**
     * Service available to convert models to DTOs
     * @param arg List<Document>
     * @return List<DocumentDto>
     */
    @Override
    public List<DocumentDto> modelToDtoWithList(List<Document> arg) {
        return arg.stream()
                .map(e -> DocumentDto.builder()
                        .id(e.getId())
                        .documentType(
                                DocumentTypeDto.builder()
                                        .description(e.getId().getDocumentType().getDescription())
                                        .build()
                        )
                        .description(e.getDescription())
                        .eventDate(e.getEventDate())
                        .updateDate(e.getUpdateDate())
                        .build())
                .collect(Collectors.toList());
    }

    /**
     * Service available to convert DTO to model
     * @param arg DocumentDto
     * @return Document
     */
    @Override
    public Document dtoToModel(DocumentDto arg) {
        return modelMapper.map(arg, Document.class);
    }

    /**
     * Service available to convert model to DTO
     * @param arg Document
     * @return DocumentDto
     */
    @Override
    public DocumentDto modelToDto(Document arg) {
        return DocumentDto.builder()
                .id(arg.getId())
                .documentType(
                        DocumentTypeDto.builder()
                                .description(arg.getId().getDocumentType().getDescription())
                                .build()
                )
                .description(arg.getDescription())
                .eventDate(arg.getEventDate())
                .updateDate(arg.getUpdateDate())
                .build();
    }

}
