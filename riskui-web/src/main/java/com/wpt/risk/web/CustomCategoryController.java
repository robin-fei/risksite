package com.wpt.risk.web;

import com.wpt.risk.base.utils.ErrorCode;
import com.wpt.risk.engine.dto.CustomCategoryDTO;
import com.wpt.risk.engine.manage.RequestManager;
import com.wpt.risk.engine.vo.CustomCategoryVo;
import com.wpt.risk.util.ApiUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/customCategory")
public class CustomCategoryController {

    @Autowired
    private RequestManager requestManager;


    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ResponseBody
    public Object list() {
        List<CustomCategoryVo> customCategorys = requestManager.getAllCustomCategorys();
        return ApiUtils.getResponseBody(ErrorCode.SUCCESS, customCategorys);
    }


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public Object addItem(@Valid @RequestBody CustomCategoryDTO dto) {
        int lastId = requestManager.addCustomCategory(dto.getCategoryName());
        dto.setCategoryId(lastId);
        return ApiUtils.getResponseBody(ErrorCode.SUCCESS, dto);
    }
}