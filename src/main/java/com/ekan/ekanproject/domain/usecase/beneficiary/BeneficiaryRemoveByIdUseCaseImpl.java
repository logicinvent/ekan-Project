package com.ekan.ekanproject.domain.usecase.beneficiary;

import com.ekan.ekanproject.domain.dto.shared.enums.ProductType;
import com.ekan.ekanproject.domain.model.Beneficiary;
import com.ekan.ekanproject.domain.usecase.iface.GenericRemoveByIdUseCase;
import com.ekan.ekanproject.infrastructure.adapter.iface.GenericDataProvider;
import org.springframework.stereotype.Service;

@Service
public class BeneficiaryRemoveByIdUseCaseImpl implements GenericRemoveByIdUseCase {

    private final GenericDataProvider<Beneficiary, Beneficiary> dataProvider;

    public BeneficiaryRemoveByIdUseCaseImpl(GenericDataProvider<Beneficiary, Beneficiary> dataProvider) {
        this.dataProvider = dataProvider;
    }

    @Override
    public void execute(final String uuid,
                        final ProductType product,
                        final Long id){
        dataProvider.remove(uuid, product, id);
    }


}
