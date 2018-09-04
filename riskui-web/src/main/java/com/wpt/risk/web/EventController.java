package com.wpt.risk.web;

import com.wpt.risk.base.utils.ErrorCode;
import com.wpt.risk.engine.dto.EventDTO;
import com.wpt.risk.engine.manage.RequestManager;
import com.wpt.risk.util.ApiUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/event")
public class EventController {

    @Autowired
    private RequestManager requestManager;

    @PostMapping(value = "/query")
    public ResponseEntity eventResultQuery(@Valid @RequestBody EventDTO eventDTO) {
        Object o = requestManager.queryEVents(eventDTO);
        return ApiUtils.getResponseBody(ErrorCode.SUCCESS, o);
    }
}