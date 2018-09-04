package com.wpt.risk.util;

import com.wpt.risk.base.utils.ErrorCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ApiUtils {

    private static final Logger LOG = LoggerFactory.getLogger(ApiUtils.class);

    public static ResponseEntity getResponseBody(ErrorCode errorCode) {
        LOG.debug("response entity --> errorCode=[{}], payload=[{}]", errorCode, null);
        return new ResponseEntity(new ApiResult(errorCode), HttpStatus.OK);
    }

    public static ResponseEntity getResponseBody(ErrorCode errorCode, Object result) {
        LOG.debug("response entity --> errorCode=[{}], payload=[{}]", errorCode, result);
        return new ResponseEntity(new ApiResult<>(errorCode, result), HttpStatus.OK);
    }
}