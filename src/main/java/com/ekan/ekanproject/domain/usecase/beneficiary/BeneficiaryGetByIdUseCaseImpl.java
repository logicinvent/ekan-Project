package com.ekan.ekanproject.domain.usecase.beneficiary;

import com.ekan.ekanproject.application.port.out.TransferObject;
import com.ekan.ekanproject.domain.dto.beneficiary.BeneficiaryDto;
import com.ekan.ekanproject.domain.dto.shared.enums.ProductType;
import com.ekan.ekanproject.domain.dto.shared.mapper.GenericMapper;
import com.ekan.ekanproject.domain.model.Beneficiary;
import com.ekan.ekanproject.domain.usecase.iface.GenericGetByIdUseCase;
import com.ekan.ekanproject.infrastructure.adapter.iface.GenericDataProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class BeneficiaryGetByIdUseCaseImpl implements GenericGetByIdUseCase<TransferObject<BeneficiaryDto>> {

    private final GenericDataProvider<Beneficiary, Beneficiary> dataProvider;

    private final GenericMapper<BeneficiaryDto, Beneficiary> mapper;

    public BeneficiaryGetByIdUseCaseImpl(GenericDataProvider<Beneficiary, Beneficiary> dataProvider, GenericMapper<BeneficiaryDto, Beneficiary> mapper) {
        this.dataProvider = dataProvider;
        this.mapper = mapper;
    }

    @Override
    public TransferObject<BeneficiaryDto> execute(final String uuid,
                                                  final ProductType product,
                                                  final Long id) {

        log.info("UUID: {} - PRODUCT: {} - CLASS: {}", uuid, product, this);
        return TransferObject.<BeneficiaryDto>builder()
                .content(mapper.modelToDto(dataProvider.findById(uuid, product, id)))
                .build();

    }


}
