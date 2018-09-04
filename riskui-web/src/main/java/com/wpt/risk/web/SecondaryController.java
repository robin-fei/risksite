package com.wpt.risk.web;


import com.wpt.risk.base.utils.ErrorCode;
import com.wpt.risk.engine.dto.EditSecondaryDTO;
import com.wpt.risk.engine.dto.NewSecondaryDTO;
import com.wpt.risk.engine.dto.SearchDTO;
import com.wpt.risk.engine.manage.RequestManager;
import com.wpt.risk.util.ApiUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/secondary")
public class SecondaryController {

    @Autowired
    private RequestManager requestManager;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String show() {
        return "custom";
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String newSecond(Model model) {
        model.addAttribute("new", "1");
        return "sedit";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String editSecond(Model model) {
        model.addAttribute("new", "0");
        return "sedit";
    }

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ResponseBody
    public Object delitem(@Valid @RequestBody SearchDTO dto) {
        Object o = requestManager.getAllSecondarys(dto);
        return ApiUtils.getResponseBody(ErrorCode.SUCCESS, o);
    }

    @RequestMapping(value = "/delitem/{id}", method = RequestMethod.POST)
    @ResponseBody
    public Object delitem(@Valid @PathVariable("id") Integer id) {
        requestManager.logicDelSecondary(id);
        return ApiUtils.getResponseBody(ErrorCode.SUCCESS);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public Object addItem(@RequestBody NewSecondaryDTO dto) {
        requestManager.addSecondary(dto);
        return ApiUtils.getResponseBody(ErrorCode.SUCCESS);
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    @ResponseBody
    public Object editItem(@RequestBody EditSecondaryDTO dto) {
        requestManager.editSecondary(dto);
        return ApiUtils.getResponseBody(ErrorCode.SUCCESS);
    }
}