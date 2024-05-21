package com.ekan.ekanproject.domain.usecase.ekan.beneficiary;

import com.ekan.ekanproject.domain.dto.shared.enums.ProductType;
import com.ekan.ekanproject.domain.model.Beneficiary;
import com.ekan.ekanproject.domain.usecase.iface.GenericRemoveByIdUseCase;
import com.ekan.ekanproject.infrastructure.adapter.iface.GenericDataProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class BeneficiaryRemoveByIdUseCaseImpl implements GenericRemoveByIdUseCase {

    private final GenericDataProvider<Beneficiary, Beneficiary> dataProvider;

    public BeneficiaryRemoveByIdUseCaseImpl(GenericDataProvider<Beneficiary, Beneficiary> dataProvider) {
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
