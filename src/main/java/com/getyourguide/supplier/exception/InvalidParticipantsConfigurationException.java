package com.getyourguide.supplier.exception;


import com.getyourguide.connectivity.supplierapi.openapi.model.GroupConfigurationDTO;
import com.getyourguide.connectivity.supplierapi.openapi.model.ParticipantsConfigurationDTO;

public class InvalidParticipantsConfigurationException extends ServiceException {
    private static final long serialVersionUID = 1L;

    private ParticipantsConfigurationDTO participantsConfiguration;

    private GroupConfigurationDTO groupConfiguration;

    public InvalidParticipantsConfigurationException(
        OperationId operationId,
        String message,
        ParticipantsConfigurationDTO participantsConfiguration,
        GroupConfigurationDTO groupConfiguration
    ) {
            super(operationId, ErrorCode.INVALID_PARTICIPANTS_CONFIGURATION, message);
        if (participantsConfiguration.getMin() == null) {
            participantsConfiguration.setMin(1);
        }
        this.participantsConfiguration = participantsConfiguration;
        this.groupConfiguration = groupConfiguration;
    }

    public InvalidParticipantsConfigurationException(
        OperationId operationId,
        String message,
        ParticipantsConfigurationDTO participantsConfiguration
    ) {
        this(operationId, message, participantsConfiguration, null);
    }

    public ParticipantsConfigurationDTO getParticipantsConfiguration() {
        return participantsConfiguration;
    }

    public GroupConfigurationDTO getGroupConfiguration() {
        return groupConfiguration;
    }
}
