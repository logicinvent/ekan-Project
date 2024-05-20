package com.ekan.ekanproject.application.rest.v1.documenttype.remove;

import com.ekan.ekanproject.application.entrypoint.resource.remove.IResourceRemove;
import com.ekan.ekanproject.application.port.out.TransferObject;
import com.ekan.ekanproject.domain.dto.beneficiary.DocumentTypeDto;
import com.ekan.ekanproject.domain.dto.shared.enums.ProductType;
import com.ekan.ekanproject.domain.usecase.iface.GenericGetByIdUseCase;
import com.ekan.ekanproject.infrastructure.util.Constants;
import io.swagger.annotations.Api;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api/document-type")
@Api(tags = {"Services available to document types"})
public class DocumentTypeRemoveController implements IResourceRemove {

    private final GenericGetByIdUseCase<TransferObject<DocumentTypeDto>> useCase;

    public DocumentTypeRemoveController(GenericGetByIdUseCase<TransferObject<DocumentTypeDto>> useCase) {
        this.useCase = useCase;
    }

    @Override
    @DeleteMapping(value = "/{id}/remove")
    public ResponseEntity<Void> execute(
            @RequestHeader(value = Constants.UUID) final String uuid,
            @RequestHeader(value = Constants.PRODUCT) final ProductType product,
            @PathVariable(value = "id") Long id) {
        useCase.execute(uuid, product, id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
