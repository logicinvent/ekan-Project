package com.ekan.ekanproject.domain.usecase.documenttype;

import com.ekan.ekanproject.domain.dto.shared.enums.ProductType;
import com.ekan.ekanproject.domain.model.DocumentType;
import com.ekan.ekanproject.domain.usecase.iface.GenericRemoveByIdUseCase;
import com.ekan.ekanproject.infrastructure.adapter.iface.GenericDataProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DocumentTypeRemoveByIdUseCaseImpl implements GenericRemoveByIdUseCase {

    private final GenericDataProvider<DocumentType, DocumentType> dataProvider;

    public DocumentTypeRemoveByIdUseCaseImpl(GenericDataProvider<DocumentType, DocumentType> dataProvider) {
        this.dataProvider = dataProvider;
    }

    @Override
    public void execute(final String uuid,
                        final ProductType product,
                        final Long id) {

        log.info("UUID: {} - PRODUCT: {} - CLASS: {}", uuid, product, this);
        dataProvider.remove(uuid, product, id);
    }


}
