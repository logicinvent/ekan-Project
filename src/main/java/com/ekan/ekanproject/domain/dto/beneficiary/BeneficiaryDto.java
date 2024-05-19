package com.ekan.ekanproject.domain.dto.beneficiary;

import com.ekan.ekanproject.application.port.in.InputPort;
import com.ekan.ekanproject.application.port.out.OutputPort;
import lombok.Builder;

import java.time.LocalDate;
import java.util.List;

@Builder
public class BeneficiaryDto implements InputPort, OutputPort {

    private Long id;
    private String name;
    private String phone;
    private LocalDate birthDay;
    private List<DocumentDto> documents;
    private LocalDate eventDate;
    private LocalDate updateDate;


}
