package com.getyourguide.supplier.exception;


import com.getyourguide.connectivity.supplierapi.openapi.model.GroupConfigurationDTO;
import com.getyourguide.connectivity.supplierapi.openapi.model.ParticipantsConfigurationDTO;

public class InvalidParticipantsConfigurationException extends ServiceException {
    private static final long serialVersionUID = 1L;

    private final ParticipantsConfigurationDTO participantsConfiguration;

    private final GroupConfigurationDTO groupConfiguration;

    public InvalidParticipantsConfigurationException(
        String message,
        ParticipantsConfigurationDTO participantsConfiguration,
        GroupConfigurationDTO groupConfiguration
    ) {
        super(ErrorCode.INVALID_PARTICIPANTS_CONFIGURATION, message);
        if (participantsConfiguration.getMin() == null) {
            participantsConfiguration.setMin(1);
        }
        this.participantsConfiguration = participantsConfiguration;
        this.groupConfiguration = groupConfiguration;
    }

    public InvalidParticipantsConfigurationException(
        String message,
        ParticipantsConfigurationDTO participantsConfiguration
    ) {
        this(message, participantsConfiguration, null);
    }

    public ParticipantsConfigurationDTO getParticipantsConfiguration() {
        return participantsConfiguration;
    }

    public GroupConfigurationDTO getGroupConfiguration() {
        return groupConfiguration;
    }
}
