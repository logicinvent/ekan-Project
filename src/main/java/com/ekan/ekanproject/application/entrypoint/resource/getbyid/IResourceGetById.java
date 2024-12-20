package com.ekan.ekanproject.application.entrypoint.resource.getbyid;

import com.ekan.ekanproject.application.port.out.OutputPort;
import com.ekan.ekanproject.application.port.out.TransferObject;
import com.ekan.ekanproject.domain.dto.shared.enums.ProductType;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;

import static com.ekan.ekanproject.infrastructure.util.Constants.*;

public interface IResourceGetById<TOutputPort extends OutputPort> {

    /**
     * This feature provides access to the complete information by id
     *
     * @param uuid    String
     * @param product Product
     * @param id      Long
     * @return TransferObject<TOutputPort>
     */
    @Operation(summary = SERVICE_AVAILABLE_TO_OBTAIN_REGISTERED_INFORMATION_BY_ID)
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = RECORD_OBTAINED,
                    content = {@Content(mediaType = "application/json")}),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = UNKNOWN_ERROR,
                    content = @Content)
    })
    ResponseEntity<TransferObject<TOutputPort>> execute(final String uuid, final ProductType product, Long id);

}
