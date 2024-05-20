package com.ekan.ekanproject.domain.usecase.document;

import com.ekan.ekanproject.domain.dto.shared.enums.ProductType;
import com.ekan.ekanproject.domain.model.Beneficiary;
import com.ekan.ekanproject.domain.model.Document;
import com.ekan.ekanproject.domain.model.DocumentId;
import com.ekan.ekanproject.domain.model.DocumentType;
import com.ekan.ekanproject.domain.usecase.iface.GenericRemoveByEmbeddeIdUseCase;
import com.ekan.ekanproject.infrastructure.adapter.iface.DocumentDataProvider;
import org.springframework.stereotype.Service;

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
                        final Long documentTypeId){
        dataProvider.deleteById(uuid, product,
                new DocumentId()
                        .setBeneficiary(new Beneficiary().setId(beneficiaryId))
                        .setDocumentType(new DocumentType().setId(documentTypeId)));
    }


}
