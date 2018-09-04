package com.wpt.risk.web;


import com.wpt.risk.base.utils.ErrorCode;
import com.wpt.risk.engine.dto.EditCustomDTO;
import com.wpt.risk.engine.dto.NewCustomDTO;
import com.wpt.risk.engine.dto.SearchDTO;
import com.wpt.risk.engine.manage.RequestManager;
import com.wpt.risk.util.ApiUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/custom")
public class CustomController {

    @Autowired
    private RequestManager requestManager;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String show() {
        return "custom";
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String newProfile(Model model) {
        model.addAttribute("new", "1");
        return "cedit";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String editProfile(Model model) {
        model.addAttribute("new", "0");
        return "cedit";
    }


    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ResponseBody
    public Object list(@RequestBody SearchDTO customDTO) {
        Object o = requestManager.getAllCustoms(customDTO);
        return ApiUtils.getResponseBody(ErrorCode.SUCCESS, o);
    }

    @RequestMapping(value = "/delitem/{id}", method = RequestMethod.POST)
    @ResponseBody
    public Object delitem(@Valid @PathVariable("id") Integer id) {
        requestManager.logicDelCustom(id);
        return ApiUtils.getResponseBody(ErrorCode.SUCCESS);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public Object addCustom(@Valid @RequestBody NewCustomDTO dto) {
        requestManager.addCustom(dto);
        return ApiUtils.getResponseBody(ErrorCode.SUCCESS);
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    @ResponseBody
    public Object editCustom(@RequestBody @Valid EditCustomDTO dto) {
        requestManager.editCustom(dto);
        return ApiUtils.getResponseBody(ErrorCode.SUCCESS);
    }
}