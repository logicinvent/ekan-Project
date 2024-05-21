package com.ekan.ekanproject.domain.usecase.ekan.documenttype;

import com.ekan.ekanproject.application.port.out.TransferObject;
import com.ekan.ekanproject.domain.dto.beneficiary.DocumentTypeDto;
import com.ekan.ekanproject.domain.dto.shared.enums.ProductType;
import com.ekan.ekanproject.domain.dto.shared.mapper.GenericMapper;
import com.ekan.ekanproject.domain.model.DocumentType;
import com.ekan.ekanproject.domain.usecase.iface.GenericGetByIdUseCase;
import com.ekan.ekanproject.infrastructure.adapter.iface.GenericDataProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DocumentTypeGetByIdUseCaseImpl implements GenericGetByIdUseCase<TransferObject<DocumentTypeDto>> {

    private final GenericDataProvider<DocumentType, DocumentType> dataProvider;

    private final GenericMapper<DocumentTypeDto, DocumentType> mapper;

    public DocumentTypeGetByIdUseCaseImpl(GenericDataProvider<DocumentType, DocumentType> dataProvider, GenericMapper<DocumentTypeDto, DocumentType> mapper) {
        this.dataProvider = dataProvider;
        this.mapper = mapper;
    }

    @Override
    public TransferObject<DocumentTypeDto> execute(final String uuid,
                                                   final ProductType product,
                                                   final Long id) {

        log.info("UUID: {} - PRODUCT: {} - CLASS: {}", uuid, product, this);
        return TransferObject.<DocumentTypeDto>builder()
                .content(mapper.modelToDto(dataProvider.findById(uuid, product, id)))
                .build();

    }


}
