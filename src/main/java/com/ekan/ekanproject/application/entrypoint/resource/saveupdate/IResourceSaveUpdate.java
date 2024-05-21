package com.ekan.ekanproject.application.entrypoint.resource.saveupdate;

import com.ekan.ekanproject.application.port.in.InputPort;
import com.ekan.ekanproject.application.port.out.OutputPort;
import com.ekan.ekanproject.application.port.out.TransferObject;
import com.ekan.ekanproject.domain.dto.shared.enums.ProductType;
import com.ekan.ekanproject.infrastructure.util.Constants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import org.springframework.http.ResponseEntity;

import static com.ekan.ekanproject.infrastructure.util.Constants.*;

public interface IResourceSaveUpdate<TInputPort extends InputPort, TOutputPort extends OutputPort> {

    /**
     * This feature provides access to save/update a complete information
     *
     * @param uuid    String
     * @param product Product
     * @param arg     TInputPort
     * @return TransferObject<TOutputPort>
     */
    @Operation(summary = SERVICE_AVAILABLE_TO_SAVE_POST_OR_UPDATE_PUT_INFORMATION)
    @io.swagger.v3.oas.annotations.responses.ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = UPDATE_OR_INCLUSION_CARRIED_OUT_SUCCESSFULLY,
                    content = {@Content(mediaType = "application/json")}),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = UNKNOWN_ERROR,
                    content = @Content)
    })
    ResponseEntity<TransferObject<TOutputPort>> execute(final String uuid, final ProductType product, TInputPort arg);

}
