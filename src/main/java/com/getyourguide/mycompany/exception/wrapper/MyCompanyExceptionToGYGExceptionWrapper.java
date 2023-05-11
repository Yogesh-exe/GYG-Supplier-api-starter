package com.getyourguide.mycompany.exception.wrapper;

import com.getyourguide.mycompany.constants.ErrorCodeConstant;
import com.getyourguide.mycompany.exception.MyCompanyBusinessException;
import com.getyourguide.mycompany.exception.MyCompanyException;
import com.getyourguide.mycompany.exception.MyCompanyTechnicalException;
import com.getyourguide.supplier.exception.ErrorCode;
import com.getyourguide.supplier.exception.ServiceException;
import com.getyourguide.supplier.exception.ValidationFailureException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MyCompanyExceptionToGYGExceptionWrapper {

    //TODO: Based on the MyCompanyException return the appropriate GYG Service Exception.
    // With the help of this exception proper Error entity is returned in ErrorHandler
    public ServiceException getWrappedException(MyCompanyException myCompanyException ) {
        log.error("Call to mycompany failed.", myCompanyException);

        if (myCompanyException instanceof MyCompanyBusinessException) {
            return this.wrapBusinessException(myCompanyException);
        } else if (myCompanyException instanceof MyCompanyTechnicalException) {
            return this.wrapTechnicalException(myCompanyException);
        } else {
            return new ServiceException(ErrorCode.INTERNAL_SYSTEM_FAILURE, "Something went wrong");
        }

    }

    // Example
    private ServiceException wrapTechnicalException(MyCompanyException myCompanyException) {
        return null;
    }

    private ServiceException wrapServiceException(MyCompanyException myCompanyException ) {
        return null;
    }

    private ServiceException wrapBusinessException(MyCompanyException myCompanyException ) {
        if (myCompanyException.getErrorCode() == ErrorCodeConstant.PRODUCT_NOT_FOUND_ERROR_CODE
            || myCompanyException.getErrorCode() == ErrorCodeConstant.PRODUCT_NO_LONGER_ACTIVE_ERROR_CODE) {
            return new ValidationFailureException(myCompanyException.getErrorMessage());
        }
        return null;
    }
}
