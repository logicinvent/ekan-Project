package com.ekan.ekanproject.application.entrypoint.resource.whitelabel;

import com.ekan.ekanproject.application.entrypoint.resource.getbyid.IResourceGetByEmbeddedId;
import com.ekan.ekanproject.application.entrypoint.resource.getbyid.IResourceGetById;
import com.ekan.ekanproject.application.entrypoint.resource.remove.IResourceRemove;
import com.ekan.ekanproject.application.entrypoint.resource.remove.IResourceRemoveByEmbeddedId;
import com.ekan.ekanproject.application.entrypoint.resource.saveupdate.IResourceSaveUpdate;
import com.ekan.ekanproject.domain.dto.document.DocumentDto;
import com.ekan.ekanproject.domain.dto.beneficiary.DocumentTypeDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Component
public class StrategyDocumentTypeUseCaseMode {

    private final List<IResourceGetByEmbeddedId<DocumentDto>> iResourceGetByEmbeddedIds; //wait
    private final List<IResourceRemoveByEmbeddedId> iResourceRemoveByEmbeddedIds; //wait
    private final List<IResourceGetById<DocumentTypeDto>> iResourceGetByIds;
    private final List<IResourceRemove> iResourceRemoves;
    private final List<IResourceSaveUpdate<DocumentTypeDto, DocumentTypeDto>> iResourceSaveUpdates;

    public StrategyDocumentTypeUseCaseMode(List<IResourceGetByEmbeddedId<DocumentDto>> iResourceGetByEmbeddedIds,
                                           List<IResourceRemoveByEmbeddedId> iResourceRemoveByEmbeddedIds,

                                           List<IResourceGetById<DocumentTypeDto>> iResourceGetByIds,
                                           List<IResourceRemove> iResourceRemoves,
                                           List<IResourceSaveUpdate<DocumentTypeDto, DocumentTypeDto>> iResourceSaveUpdates) {
        this.iResourceGetByEmbeddedIds = iResourceGetByEmbeddedIds;
        this.iResourceGetByIds = iResourceGetByIds;
        this.iResourceRemoves = iResourceRemoves;
        this.iResourceRemoveByEmbeddedIds = iResourceRemoveByEmbeddedIds;
        this.iResourceSaveUpdates = iResourceSaveUpdates;

    }

    @Bean
    public void findiResourceGetByIds(){
        Map<String, IResourceGetById<DocumentTypeDto>> map = new HashMap<>();
        iResourceGetByIds.forEach(
                e -> {
                    map.put(e.getClass().getName(), e);
                }
        );

        log.error(map.toString());
    }



}
