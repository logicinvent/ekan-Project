package com.ekan.ekanproject.infrastructure.adapter.beneficiary;

import com.ekan.ekanproject.domain.dto.shared.enums.ProductType;
import com.ekan.ekanproject.domain.exception.BeneficiaryNotFoundException;
import com.ekan.ekanproject.domain.model.Beneficiary;
import com.ekan.ekanproject.infrastructure.adapter.iface.GenericDataProvider;
import com.ekan.ekanproject.infrastructure.repository.BeneficiaryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class BeneficiaryDataProviderImpl implements GenericDataProvider<Beneficiary, Beneficiary> {

    private final BeneficiaryRepository repository;

    public BeneficiaryDataProviderImpl(BeneficiaryRepository repository) {
        this.repository = repository;
    }

    @Override
    public Page<Beneficiary> findAll(final String uuid,
                                     final ProductType product,
                                     final Pageable pageable) {
        log.info("UUID: {} - PRODUCT: {} - CLASS: {}", uuid, product, this);
        var result = repository.findAll(pageable);

        if (result.isEmpty())
            throw new BeneficiaryNotFoundException("No results available");

        return result;

    }

    /**
     * @param uuid
     * @param product
     * @param arg
     * @return
     */
    @Override
    public Beneficiary findById(String uuid, ProductType product, Long arg) {
        log.info("UUID: {} - PRODUCT: {} - CLASS: {}", uuid, product, this);
        return repository.findById(arg)
                .orElseThrow(() -> new BeneficiaryNotFoundException("Beneficiary not found with id: " + arg));
    }

    /**
     * @param uuid
     * @param product
     * @param arg
     * @return
     */
    @Override
    public Beneficiary save(String uuid, ProductType product, Beneficiary arg) {
        log.info("UUID: {} - PRODUCT: {} - CLASS: {}", uuid, product, this);
        return repository.save(arg);
    }

    /**
     * @param uuid    String
     * @param product ProductType
     * @param arg     Long
     * @return Beneficiary
     */
    @Override
    public Beneficiary update(String uuid, ProductType product, Beneficiary arg) {
        log.info("UUID: {} - PRODUCT: {} - CLASS: {}", uuid, product, this);
        return repository.save(arg);
    }

    /**
     * @param uuid    String
     * @param product ProductType
     * @param arg     Long
     */
    @Override
    public void remove(String uuid, ProductType product, Long arg) {
        log.info("UUID: {} - PRODUCT: {} - CLASS: {}", uuid, product, this);
        repository.deleteById(arg);
    }


}
