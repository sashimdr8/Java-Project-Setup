package com.dharmasun.data.error;




import com.dharmasun.data.model.BaseResponse;

import java.io.IOException;

/**
 * Braindigit
 * Created on 12/12/16.
 */

public class FailedResponseException extends IOException {
    public final int status;
    public BaseResponse baseResponse;

    public FailedResponseException(BaseResponse baseResponse) {
        super(baseResponse.getMessage());
        this.baseResponse = baseResponse;
        this.status = baseResponse.getCode();
    }

}
