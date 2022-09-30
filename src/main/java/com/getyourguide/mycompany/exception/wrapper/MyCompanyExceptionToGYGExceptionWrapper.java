package com.getyourguide.mycompany.exception.wrapper;

import com.getyourguide.mycompany.exception.MyCompanyBusinessException;
import com.getyourguide.mycompany.exception.MyCompanyException;
import com.getyourguide.mycompany.exception.MyCompanyServiceException;
import com.getyourguide.mycompany.exception.MyCompanyTechnicalException;
import org.springframework.stereotype.Component;

@Component
public class MyCompanyExceptionToGYGExceptionWrapper {
    //TODO: Yogesh to provide error wrappings.
    public RuntimeException getWrappedException(MyCompanyException myCompanyException) {

        if (myCompanyException instanceof MyCompanyBusinessException) {
            return this.wrapBusinessException(myCompanyException);
        } else if (myCompanyException instanceof MyCompanyServiceException) {
            return this.wrapServiceException(myCompanyException);
        } else if (myCompanyException instanceof MyCompanyTechnicalException) {
            return this.wrapTechnicalException(myCompanyException);
        } else {
            return new RuntimeException("Something went wrong");
        }

    }

    private RuntimeException wrapTechnicalException(MyCompanyException myCompanyException) {
        return null;
    }

    private RuntimeException wrapServiceException(MyCompanyException myCompanyException) {
        return null;
    }

    private RuntimeException wrapBusinessException(MyCompanyException myCompanyException) {
        return null;
    }
}
