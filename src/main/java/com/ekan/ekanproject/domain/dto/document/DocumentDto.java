package com.ekan.ekanproject.domain.dto.document;

import com.ekan.ekanproject.application.port.in.InputPort;
import com.ekan.ekanproject.application.port.out.OutputPort;
import com.ekan.ekanproject.domain.dto.beneficiary.BeneficiaryDto;
import com.ekan.ekanproject.domain.dto.beneficiary.DocumentTypeDto;
import com.ekan.ekanproject.domain.model.DocumentId;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class DocumentDto implements InputPort, OutputPort {

    private DocumentId id;
    private DocumentTypeDto documentType;
    private BeneficiaryDto beneficiary;
    private String description;
    private LocalDateTime eventDate;
    private LocalDateTime updateDate;

}
