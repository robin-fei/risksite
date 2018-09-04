package com.wpt.risk.web;

import com.wpt.risk.base.utils.ErrorCode;
import com.wpt.risk.engine.manage.RequestManager;
import com.wpt.risk.engine.vo.ExpressionVo;
import com.wpt.risk.util.ApiUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/expression")
public class ExpressionController {

    @Autowired
    private RequestManager requestManager;


    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ResponseBody
    public Object list() {
        List<ExpressionVo> expressions = requestManager.getAllExpressions();
        return ApiUtils.getResponseBody(ErrorCode.SUCCESS, expressions);
    }
}