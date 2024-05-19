package com.ekan.ekanproject.domain.dto.beneficiary;

import com.ekan.ekanproject.application.port.in.InputPort;
import com.ekan.ekanproject.application.port.out.OutputPort;
import lombok.Builder;

import java.time.LocalDate;

@Builder
public class DocumentDto implements InputPort, OutputPort {

    private Long id;
    private DocumentTypeDto documentType;
    private String description;
    private LocalDate eventDate;
    private LocalDate updateDate;

}
