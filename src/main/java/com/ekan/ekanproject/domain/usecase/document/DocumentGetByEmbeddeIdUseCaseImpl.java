package com.ekan.ekanproject.domain.usecase.document;

import com.ekan.ekanproject.application.port.out.TransferObject;
import com.ekan.ekanproject.domain.dto.beneficiary.DocumentDto;
import com.ekan.ekanproject.domain.dto.shared.enums.ProductType;
import com.ekan.ekanproject.domain.dto.shared.mapper.GenericMapper;
import com.ekan.ekanproject.domain.model.Beneficiary;
import com.ekan.ekanproject.domain.model.Document;
import com.ekan.ekanproject.domain.model.DocumentId;
import com.ekan.ekanproject.domain.model.DocumentType;
import com.ekan.ekanproject.domain.usecase.iface.GenericGetByEmbeddeIdUseCase;
import com.ekan.ekanproject.infrastructure.adapter.iface.DocumentDataProvider;
import org.springframework.stereotype.Service;

@Service
public class DocumentGetByEmbeddeIdUseCaseImpl implements GenericGetByEmbeddeIdUseCase<TransferObject<DocumentDto>> {

    private final DocumentDataProvider<Document, DocumentId> documentDataProvider;

    private final GenericMapper<DocumentDto, Document> mapper;

    public DocumentGetByEmbeddeIdUseCaseImpl(DocumentDataProvider<Document, DocumentId> documentDataProvider, GenericMapper<DocumentDto, Document> mapper) {
        this.documentDataProvider = documentDataProvider;
        this.mapper = mapper;
    }

    @Override
    public TransferObject<DocumentDto> execute(final String uuid,
                                                        final ProductType product,
                                                        final Long beneficiaryId,
                                                        final Long documentTypeId){

        return TransferObject.<DocumentDto>builder()
                .content(mapper.modelToDto(documentDataProvider.findById(uuid, product,
                        new DocumentId().setDocumentType(new DocumentType().setId(documentTypeId))
                                .setBeneficiary(new Beneficiary().setId(beneficiaryId)))))
                .build();

    }

}
