package com.ekan.ekanproject.infrastructure.adapter.documenttype;

import com.ekan.ekanproject.domain.dto.shared.enums.ProductType;
import com.ekan.ekanproject.domain.exception.DocumentTypeNotFoundException;
import com.ekan.ekanproject.domain.model.DocumentType;
import com.ekan.ekanproject.infrastructure.adapter.iface.GenericDataProvider;
import com.ekan.ekanproject.infrastructure.repository.DocumentTypeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DocumentTypeDataProviderImpl implements GenericDataProvider<DocumentType, DocumentType> {

    private final DocumentTypeRepository repository;

    public DocumentTypeDataProviderImpl(DocumentTypeRepository repository) {
        this.repository = repository;
    }

    @Override
    public Page<DocumentType> findAll(final String uuid,
                                      final ProductType product,
                                      final Pageable pageable) {
        log.info("UUID: {} - PRODUCT: {} - CLASS: {}", uuid, product, this);

        var result = repository.findAll(pageable);

        if (result.isEmpty())
            throw new DocumentTypeNotFoundException("No results available");

        return result;

    }

    /**
     * @param uuid
     * @param product
     * @param arg
     * @return
     */
    @Override
    public DocumentType findById(String uuid, ProductType product, Long arg) {
        log.info("UUID: {} - PRODUCT: {} - CLASS: {}", uuid, product, this);
        return repository.findById(arg)
                .orElseThrow(() -> new DocumentTypeNotFoundException("Document type not found with id: " + arg));
    }

    /**
     * @param uuid
     * @param product
     * @param arg
     * @return
     */
    @Override
    public DocumentType save(String uuid, ProductType product, DocumentType arg) {
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
    public DocumentType update(String uuid, ProductType product, DocumentType arg) {
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
