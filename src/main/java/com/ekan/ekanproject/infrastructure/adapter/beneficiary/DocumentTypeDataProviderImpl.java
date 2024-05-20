package com.ekan.ekanproject.infrastructure.adapter.beneficiary;

import com.ekan.ekanproject.domain.dto.shared.enums.ProductType;
import com.ekan.ekanproject.domain.model.DocumentType;
import com.ekan.ekanproject.infrastructure.adapter.iface.GenericDataProvider;
import com.ekan.ekanproject.infrastructure.repository.DocumentTypeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class DocumentTypeDataProviderImpl implements GenericDataProvider<DocumentType, DocumentType> {

    private final DocumentTypeRepository repository;

    public DocumentTypeDataProviderImpl(DocumentTypeRepository repository) {
        this.repository = repository;
    }

    @Override
    public Page<DocumentType> findAll(final String uuid,
                                     final ProductType product,
                                     final Pageable pageable){

        return repository.findAll(pageable);

    }

    /**
     * @param uuid
     * @param product
     * @param arg
     * @return
     */
    @Override
    public DocumentType findById(String uuid, ProductType product, Long arg) {
        return repository.findById(arg).orElseThrow();
    }

    /**
     * @param uuid
     * @param product
     * @param arg
     * @return
     */
    @Override
    public DocumentType save(String uuid, ProductType product, DocumentType arg) {
        return repository.save(arg);
    }

    /**
     * @param uuid String
     * @param product ProductType
     * @param arg Long
     * @return Beneficiary
     */
    @Override
    public DocumentType update(String uuid, ProductType product, DocumentType arg) {
        return repository.save(arg);
    }

    /**
     * @param uuid String
     * @param product ProductType
     * @param arg Long
     */
    @Override
    public void remove(String uuid, ProductType product, Long arg) {
        repository.deleteById(arg);
    }


}
