package com.ekan.ekanproject.domain.usecase.document;

import com.ekan.ekanproject.application.port.out.TransferObject;
import com.ekan.ekanproject.domain.dto.beneficiary.DocumentDto;
import com.ekan.ekanproject.domain.dto.shared.enums.ProductType;
import com.ekan.ekanproject.domain.dto.shared.mapper.GenericMapper;
import com.ekan.ekanproject.domain.model.Document;
import com.ekan.ekanproject.domain.usecase.iface.GenericGetAllUseCase;
import com.ekan.ekanproject.infrastructure.adapter.iface.GenericDataProvider;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentUseCaseImpl implements GenericGetAllUseCase<TransferObject<List<DocumentDto>>, Document> {

    private final GenericDataProvider<Document, Document> dataProvider;

    private final GenericMapper<DocumentDto, Document> mapper;

    public DocumentUseCaseImpl(GenericDataProvider<Document, Document> dataProvider, GenericMapper<DocumentDto, Document> mapper) {
        this.dataProvider = dataProvider;
        this.mapper = mapper;
    }

    @Override
    public TransferObject<List<DocumentDto>> execute(final String uuid,
                                                        final ProductType product,
                                                        final Pageable pageable){

        var result = dataProvider.findAll(uuid, product, pageable);

        if (result.isEmpty())
            return null;

        return TransferObject.<List<DocumentDto>>builder()
                .content(mapper.modelToDtoWithList(result.getContent()))
                .pageNumber(pageable.getPageNumber())
                .pageSize(result.getNumberOfElements())
                .totalElements(result.getTotalElements())
                .totalPages(result.getTotalPages()).build();

    }


}
