package com.wpt.risk.web;


import com.wpt.risk.base.utils.ErrorCode;
import com.wpt.risk.engine.dto.EditCategoryDTO;
import com.wpt.risk.engine.dto.NewCategoryDTO;
import com.wpt.risk.engine.dto.SearchDTO;
import com.wpt.risk.engine.manage.RequestManager;
import com.wpt.risk.util.ApiUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private RequestManager requestManager;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String show() {
        return "custom";
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String newSecond(Model model) {
        model.addAttribute("new", "1");
        return "ctedit";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String editSecond(Model model) {
        model.addAttribute("new", "0");
        return "ctedit";
    }

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ResponseBody
    public Object delitem(@Valid @RequestBody SearchDTO dto) {
        Object o = requestManager.getAllCategorys(dto);
        return ApiUtils.getResponseBody(ErrorCode.SUCCESS, o);
    }

    @RequestMapping(value = "/delitem/{id}", method = RequestMethod.POST)
    @ResponseBody
    public Object delitem(@Valid @PathVariable("id") Integer id) {
        requestManager.logicDelCategory(id);
        return ApiUtils.getResponseBody(ErrorCode.SUCCESS);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public Object addItem(@RequestBody NewCategoryDTO dto) {
        requestManager.addCategory(dto);
        return ApiUtils.getResponseBody(ErrorCode.SUCCESS);
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    @ResponseBody
    public Object editItem(@RequestBody EditCategoryDTO dto) {
        requestManager.editCategory(dto);
        return ApiUtils.getResponseBody(ErrorCode.SUCCESS);
    }
}