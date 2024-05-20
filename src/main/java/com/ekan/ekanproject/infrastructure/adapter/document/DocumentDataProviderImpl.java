package com.ekan.ekanproject.infrastructure.adapter.document;

import com.ekan.ekanproject.domain.dto.shared.enums.ProductType;
import com.ekan.ekanproject.domain.exception.DocumentNotFoundException;
import com.ekan.ekanproject.domain.model.Document;
import com.ekan.ekanproject.domain.model.DocumentId;
import com.ekan.ekanproject.infrastructure.adapter.iface.DocumentDataProvider;
import com.ekan.ekanproject.infrastructure.adapter.iface.GenericDataProvider;
import com.ekan.ekanproject.infrastructure.repository.DocumentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import static com.ekan.ekanproject.infrastructure.util.Constants.METHOD_NOT_AVAILABLE;

@Slf4j
@Service
public class DocumentDataProviderImpl implements GenericDataProvider<Document, Document>,
        DocumentDataProvider<Document, DocumentId> {

    private final DocumentRepository repository;

    public DocumentDataProviderImpl(DocumentRepository repository) {
        this.repository = repository;
    }

    @Override
    public Page<Document> findAll(final String uuid,
                                     final ProductType product,
                                     final Pageable pageable){
        log.info("UUID: {} - PRODUCT: {} - CLASS: {}", uuid, product, this);
        return repository.findAll(pageable);

    }

    /**
     * @param uuid
     * @param product
     * @param arg
     * @return
     */
    @Deprecated
    @Override
    public Document findById(String uuid, ProductType product, Long arg) {
        log.warn(METHOD_NOT_AVAILABLE);
        return null;
    }

    public Document findById(String uuid, ProductType product, DocumentId arg) {
        log.info("UUID: {} - PRODUCT: {} - CLASS: {}", uuid, product, this);
        return repository.findById(arg)
                .orElseThrow(() -> new DocumentNotFoundException("Document not found with id: " + arg));
    }

    /**
     * @param uuid
     * @param product
     * @param arg
     */
    @Override
    public void deleteById(String uuid, ProductType product, DocumentId arg) {
        log.info("UUID: {} - PRODUCT: {} - CLASS: {}", uuid, product, this);
        repository.deleteById(arg);
    }

    /**
     * @param uuid
     * @param product
     * @param arg
     * @return
     */
    @Override
    public Document save(String uuid, ProductType product, Document arg) {
        log.info("UUID: {} - PRODUCT: {} - CLASS: {}", uuid, product, this);
        return repository.save(arg);
    }

    /**
     * @param uuid String
     * @param product ProductType
     * @param arg Long
     * @return Beneficiary
     */
    @Override
    public Document update(String uuid, ProductType product, Document arg) {
        log.info("UUID: {} - PRODUCT: {} - CLASS: {}", uuid, product, this);
        return repository.save(arg);
    }

    /**
     * @param uuid String
     * @param product ProductType
     * @param arg Long
     */
    @Override
    public void remove(String uuid, ProductType product, Long arg) {
        log.warn(METHOD_NOT_AVAILABLE);
    }


}
