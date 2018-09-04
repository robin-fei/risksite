package com.wpt.risk.web;

import com.wpt.risk.base.utils.ErrorCode;
import com.wpt.risk.engine.manage.RequestManager;
import com.wpt.risk.engine.vo.PersonaVo;
import com.wpt.risk.util.ApiUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/persona")
public class PersonaController {

    @Autowired
    private RequestManager requestManager;


    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ResponseBody
    public Object list() {
        List<PersonaVo> personas = requestManager.getAllPersonas();
        return ApiUtils.getResponseBody(ErrorCode.SUCCESS, personas);
    }
}