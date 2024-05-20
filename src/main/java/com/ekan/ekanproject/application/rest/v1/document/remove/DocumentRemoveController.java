package com.ekan.ekanproject.application.rest.v1.document.remove;

import com.ekan.ekanproject.application.entrypoint.resource.remove.IResourceRemoveByEmbeddedId;
import com.ekan.ekanproject.application.port.out.TransferObject;
import com.ekan.ekanproject.domain.dto.beneficiary.DocumentDto;
import com.ekan.ekanproject.domain.dto.shared.enums.ProductType;
import com.ekan.ekanproject.domain.usecase.iface.GenericGetByEmbeddeIdUseCase;
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
@RequestMapping("/v1/api/document")
@Api(tags = {"Services available to documents"})
public class DocumentRemoveController implements IResourceRemoveByEmbeddedId {

    private final GenericGetByEmbeddeIdUseCase<TransferObject<DocumentDto>> useCase;

    public DocumentRemoveController(GenericGetByEmbeddeIdUseCase<TransferObject<DocumentDto>> useCase) {
        this.useCase = useCase;
    }

    @Override
    @DeleteMapping(value = "/{beneficiaryId}/{documentTypeId}")
    public ResponseEntity<Void> execute(
            @RequestHeader(value = Constants.UUID) final String uuid,
            @RequestHeader(value = Constants.PRODUCT) final ProductType product,
            @PathVariable(value = "beneficiaryId") Long beneficiaryId,
            @PathVariable(value = "documentTypeId") Long documentTypeId) {
        useCase.execute(uuid, product, beneficiaryId, documentTypeId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
