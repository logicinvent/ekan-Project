package com.ekan.ekanproject.domain.usecase.beneficiary;

import com.ekan.ekanproject.application.port.out.TransferObject;
import com.ekan.ekanproject.domain.dto.beneficiary.BeneficiaryDto;
import com.ekan.ekanproject.domain.dto.shared.enums.ProductType;
import com.ekan.ekanproject.domain.dto.shared.mapper.GenericMapper;
import com.ekan.ekanproject.domain.model.Beneficiary;
import com.ekan.ekanproject.domain.usecase.iface.GenericSaveUseCase;
import com.ekan.ekanproject.infrastructure.adapter.iface.GenericDataProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class BeneficiarySaveUseCaseImpl implements GenericSaveUseCase<TransferObject<BeneficiaryDto>, BeneficiaryDto> {

    private final GenericDataProvider<Beneficiary, Beneficiary> dataProvider;

    private final GenericMapper<BeneficiaryDto, Beneficiary> mapper;

    public BeneficiarySaveUseCaseImpl(GenericDataProvider<Beneficiary, Beneficiary> dataProvider, GenericMapper<BeneficiaryDto, Beneficiary> mapper) {
        this.dataProvider = dataProvider;
        this.mapper = mapper;
    }

    @Override
    public TransferObject<BeneficiaryDto> execute(final String uuid,
                                                        final ProductType product,
                                                        final BeneficiaryDto arg){

        log.info("UUID: {} - PRODUCT: {} - CLASS: {}", uuid, product, this);
        var result = dataProvider.save(uuid, product, mapper.dtoToModel(arg));

        return TransferObject.<BeneficiaryDto>builder()
                .content(mapper.modelToDto(result))
                .build();

    }


}
