package com.ekan.ekanproject.application.entrypoint.resource.get;

import com.ekan.ekanproject.application.port.out.OutputPort;
import com.ekan.ekanproject.application.port.out.TransferObject;
import com.ekan.ekanproject.domain.dto.shared.enums.ProductType;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

import static com.ekan.ekanproject.infrastructure.util.Constants.RECORD_OBTAINED;
import static com.ekan.ekanproject.infrastructure.util.Constants.UNKNOWN_ERROR;

@RestControllerAdvice
public interface IResourceGet<TOutputPort extends OutputPort> {

    /**
     * This feature provides access to the complete list of items
     *
     * @param uuid     String
     * @param product  Product
     * @param pageable Pageable
     * @return List<TOutputPort>
     */
    @Operation(summary = "Service available to obtain all records")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                    description = RECORD_OBTAINED),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400",
                    description = UNKNOWN_ERROR)
    })
    ResponseEntity<TransferObject<List<TOutputPort>>> execute(
            final String uuid,
            final ProductType product,
            final Pageable pageable);

}
