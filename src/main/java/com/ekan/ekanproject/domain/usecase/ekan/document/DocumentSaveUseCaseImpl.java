package com.ekan.ekanproject.domain.usecase.ekan.document;

import com.ekan.ekanproject.application.port.out.TransferObject;
import com.ekan.ekanproject.domain.dto.document.DocumentDto;
import com.ekan.ekanproject.domain.dto.shared.enums.ProductType;
import com.ekan.ekanproject.domain.dto.shared.mapper.GenericMapper;
import com.ekan.ekanproject.domain.model.Document;
import com.ekan.ekanproject.domain.usecase.iface.GenericSaveUseCase;
import com.ekan.ekanproject.infrastructure.adapter.iface.GenericDataProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DocumentSaveUseCaseImpl implements GenericSaveUseCase<TransferObject<DocumentDto>, DocumentDto> {

    private final GenericDataProvider<Document, Document> dataProvider;

    private final GenericMapper<DocumentDto, Document> mapper;

    public DocumentSaveUseCaseImpl(GenericDataProvider<Document, Document> dataProvider, GenericMapper<DocumentDto, Document> mapper) {
        this.dataProvider = dataProvider;
        this.mapper = mapper;
    }

    @Override
    public TransferObject<DocumentDto> execute(final String uuid,
                                               final ProductType product,
                                               final DocumentDto arg) {

        log.info("UUID: {} - PRODUCT: {} - CLASS: {}", uuid, product, this);
        var result = dataProvider.save(uuid, product, mapper.dtoToModel(arg));

        return TransferObject.<DocumentDto>builder()
                .content(mapper.modelToDto(result))
                .build();

    }


}
