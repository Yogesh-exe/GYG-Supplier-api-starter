package com.getyourguide.supplier.service.Impl;

import com.getyourguide.connectivity.supplierapi.openapi.model.ErrorResponseAvailabilityDTO;
import com.getyourguide.connectivity.supplierapi.openapi.model.GetAvailabilities200ResponseDTO;
import com.getyourguide.mycompany.model.Product;
import com.getyourguide.mycompany.service.MyCompanyClientService;
import com.getyourguide.supplier.mapper.AvailabilityMapper;
import com.getyourguide.supplier.product.ProductIdDeserializer;
import com.getyourguide.supplier.product.ProductIdValidator;
import com.getyourguide.supplier.service.AvailabilityService;
import java.time.OffsetDateTime;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
public class AvailabilityServiceImpl extends AbstractService implements AvailabilityService {

    private final AvailabilityMapper availabilityMapper;

    public AvailabilityServiceImpl(ProductIdDeserializer productIdDeserializer,
                                   ProductIdValidator productIdValidator,
                                   MyCompanyClientService myCompanyClientService,
                                   AvailabilityMapper availabilityMapper) {
        super(productIdDeserializer, productIdValidator, myCompanyClientService);
        this.availabilityMapper = availabilityMapper;
    }

    @Override
    public GetAvailabilities200ResponseDTO getAvailabilities(Product product, OffsetDateTime fromDateTime,
                                                             OffsetDateTime toDateTime) {
        //TODO: implement the method
        return new ErrorResponseAvailabilityDTO().errorCode(
            ErrorResponseAvailabilityDTO.ErrorCodeEnum.INTERNAL_SYSTEM_FAILURE);
    }
}
