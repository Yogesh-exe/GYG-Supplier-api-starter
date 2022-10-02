package com.getyourguide.mycompany.exception.wrapper;

import com.getyourguide.mycompany.exception.MyCompanyBusinessException;
import com.getyourguide.mycompany.exception.MyCompanyException;
import com.getyourguide.mycompany.exception.MyCompanyServiceException;
import com.getyourguide.mycompany.exception.MyCompanyTechnicalException;
import com.getyourguide.supplier.exception.ErrorCode;
import com.getyourguide.supplier.exception.OperationId;
import com.getyourguide.supplier.exception.ServiceException;
import org.springframework.stereotype.Component;

@Component
public class MyCompanyExceptionToGYGExceptionWrapper {
    //TODO: Yogesh to provide error wrappings.
    public ServiceException getWrappedException(MyCompanyException myCompanyException) {

        if (myCompanyException instanceof MyCompanyBusinessException) {
            return this.wrapBusinessException(myCompanyException);
        } else if (myCompanyException instanceof MyCompanyServiceException) {
            return this.wrapServiceException(myCompanyException);
        } else if (myCompanyException instanceof MyCompanyTechnicalException) {
            return this.wrapTechnicalException(myCompanyException);
        } else {
            return new ServiceException(OperationId.DEFAULT, ErrorCode.INTERNAL_SYSTEM_FAILURE, "Something went wrong");
        }

    }

    private ServiceException wrapTechnicalException(MyCompanyException myCompanyException) {
        return null;
    }

    private ServiceException wrapServiceException(MyCompanyException myCompanyException) {
        return null;
    }

    private ServiceException wrapBusinessException(MyCompanyException myCompanyException) {
        return null;
    }
}
