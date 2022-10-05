package com.getyourguide.mycompany.exception.wrapper;

import com.getyourguide.mycompany.constants.ErrorCodeConstant;
import com.getyourguide.mycompany.exception.MyCompanyBusinessException;
import com.getyourguide.mycompany.exception.MyCompanyException;
import com.getyourguide.mycompany.exception.MyCompanyServiceException;
import com.getyourguide.mycompany.exception.MyCompanyTechnicalException;
import com.getyourguide.supplier.exception.ErrorCode;
import com.getyourguide.supplier.exception.OperationId;
import com.getyourguide.supplier.exception.ServiceException;
import com.getyourguide.supplier.exception.ValidationFailureException;
import org.springframework.stereotype.Component;

@Component
public class MyCompanyExceptionToGYGExceptionWrapper {

    //TODO: Based on the MyCompanyException return the appropriate GYG Service Exception.
    // With the help of this exception proper Error entity is returned in ErrorHandler
    public ServiceException getWrappedException(MyCompanyException myCompanyException,
                                                OperationId operationId) {

        if (myCompanyException instanceof MyCompanyBusinessException) {
            return this.wrapBusinessException(myCompanyException,operationId);
        } else if (myCompanyException instanceof MyCompanyServiceException) {
            return this.wrapServiceException(myCompanyException,operationId);
        } else if (myCompanyException instanceof MyCompanyTechnicalException) {
            return this.wrapTechnicalException(myCompanyException,operationId);
        } else {
            return new ServiceException(OperationId.DEFAULT, ErrorCode.INTERNAL_SYSTEM_FAILURE, "Something went wrong");
        }

    }
    // Example
    private ServiceException wrapTechnicalException(MyCompanyException myCompanyException,
                                                    OperationId operationId) {
        return null;
    }

    private ServiceException wrapServiceException(MyCompanyException myCompanyException,
                                                  OperationId operationId) {
        return null;
    }

    private ServiceException wrapBusinessException(MyCompanyException myCompanyException,
                                                   OperationId operationId) {
        if(myCompanyException.getErrorCode() == ErrorCodeConstant.PRODUCT_NOT_FOUND_ERROR_CODE
            || myCompanyException.getErrorCode() == ErrorCodeConstant.PRODUCT_NO_LONGER_ACTIVE_ERROR_CODE){
            return new ValidationFailureException(operationId, myCompanyException.getErrorMessage());
        }
        return null;
    }
}
