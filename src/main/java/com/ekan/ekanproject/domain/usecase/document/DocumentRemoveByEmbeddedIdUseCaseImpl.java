package com.ekan.ekanproject.domain.usecase.document;

import com.ekan.ekanproject.domain.dto.shared.enums.ProductType;
import com.ekan.ekanproject.domain.model.Document;
import com.ekan.ekanproject.domain.model.DocumentId;
import com.ekan.ekanproject.domain.usecase.iface.GenericRemoveByEmbeddeIdUseCase;
import com.ekan.ekanproject.infrastructure.adapter.iface.DocumentDataProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DocumentRemoveByEmbeddedIdUseCaseImpl implements GenericRemoveByEmbeddeIdUseCase {

    private final DocumentDataProvider<Document, DocumentId> dataProvider;

    public DocumentRemoveByEmbeddedIdUseCaseImpl(DocumentDataProvider<Document, DocumentId> dataProvider) {
        this.dataProvider = dataProvider;
    }


    @Override
    public void execute(final String uuid,
                        final ProductType product,
                        final Long beneficiaryId,
                        final Long documentTypeId) {

        log.info("UUID: {} - PRODUCT: {} - CLASS: {}", uuid, product, this);
        dataProvider.deleteById(uuid, product,
                new DocumentId()
                        .setBeneficiary(beneficiaryId)
                        .setDocumentType(documentTypeId));
    }


}
