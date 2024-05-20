package com.ekan.ekanproject.domain.dto.beneficiary;

import com.ekan.ekanproject.application.port.in.InputPort;
import com.ekan.ekanproject.application.port.out.OutputPort;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DocumentTypeDto implements InputPort, OutputPort {

    private Long id;
    private String description;

}
