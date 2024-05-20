package com.ekan.ekanproject.application.rest.v1.documenttype.getbyid;

import com.ekan.ekanproject.application.entrypoint.resource.getbyid.IResourceGetById;
import com.ekan.ekanproject.application.port.out.TransferObject;
import com.ekan.ekanproject.domain.dto.beneficiary.DocumentTypeDto;
import com.ekan.ekanproject.domain.dto.shared.enums.ProductType;
import com.ekan.ekanproject.domain.usecase.iface.GenericGetByIdUseCase;
import com.ekan.ekanproject.infrastructure.util.Constants;
import io.swagger.annotations.Api;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api/document-type")
@Api(tags = {"Services available to document types"})
public class DocumentTypeGetByIdController implements IResourceGetById<DocumentTypeDto> {

    private final GenericGetByIdUseCase<TransferObject<DocumentTypeDto>> useCase;

    public DocumentTypeGetByIdController(GenericGetByIdUseCase<TransferObject<DocumentTypeDto>> useCase) {
        this.useCase = useCase;
    }

    @Override
    @GetMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TransferObject<DocumentTypeDto>> execute(
            @RequestHeader(value = Constants.UUID) final String uuid,
            @RequestHeader(value = Constants.PRODUCT) final ProductType product,
            @PathVariable(value = "id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(useCase.execute(uuid, product, id));
    }
}
