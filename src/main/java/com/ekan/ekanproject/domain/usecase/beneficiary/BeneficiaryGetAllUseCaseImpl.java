package com.ekan.ekanproject.domain.usecase.beneficiary;

import com.ekan.ekanproject.application.port.out.TransferObject;
import com.ekan.ekanproject.domain.dto.beneficiary.BeneficiaryDto;
import com.ekan.ekanproject.domain.dto.shared.enums.ProductType;
import com.ekan.ekanproject.domain.dto.shared.mapper.GenericMapper;
import com.ekan.ekanproject.domain.model.Beneficiary;
import com.ekan.ekanproject.domain.usecase.iface.GenericGetAllUseCase;
import com.ekan.ekanproject.infrastructure.adapter.iface.GenericDataProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class BeneficiaryGetAllUseCaseImpl implements GenericGetAllUseCase<TransferObject<List<BeneficiaryDto>>, Beneficiary> {

    private final GenericDataProvider<Beneficiary, Beneficiary> dataProvider;

    private final GenericMapper<BeneficiaryDto, Beneficiary> mapper;

    public BeneficiaryGetAllUseCaseImpl(GenericDataProvider<Beneficiary, Beneficiary> dataProvider, GenericMapper<BeneficiaryDto, Beneficiary> mapper) {
        this.dataProvider = dataProvider;
        this.mapper = mapper;
    }

    @Override
    public TransferObject<List<BeneficiaryDto>> execute(final String uuid,
                                                        final ProductType product,
                                                        final Pageable pageable) {

        log.info("UUID: {} - PRODUCT: {} - CLASS: {}", uuid, product, this);
        var result = dataProvider.findAll(uuid, product, pageable);

        if (result.isEmpty())
            return null;

        return TransferObject.<List<BeneficiaryDto>>builder()
                .content(mapper.modelToDtoWithList(result.getContent()))
                .pageNumber(pageable.getPageNumber())
                .pageSize(result.getNumberOfElements())
                .totalElements(result.getTotalElements())
                .totalPages(result.getTotalPages()).build();

    }


}
