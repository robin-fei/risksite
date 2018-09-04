package com.wpt.risk.web;


import com.wpt.risk.base.utils.ErrorCode;
import com.wpt.risk.engine.dto.EditProfileDTO;
import com.wpt.risk.engine.dto.NewProfileDTO;
import com.wpt.risk.engine.dto.SearchDTO;
import com.wpt.risk.engine.manage.RequestManager;
import com.wpt.risk.util.ApiUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/profile")
public class ProflieController {

    @Autowired
    private RequestManager requestManager;

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public String show() {
        return "profile";
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String newProfile(Model model) {
        model.addAttribute("new", "1");
        return "pedit";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String editProfile(Model model) {
        model.addAttribute("new", "0");
        return "pedit";
    }

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ResponseBody
    public Object list(@RequestBody SearchDTO profileDTO) {
        Object o = requestManager.getAllProfiles(profileDTO);
        return ApiUtils.getResponseBody(ErrorCode.SUCCESS, o);
    }

    @RequestMapping(value = "/delitem/{id}", method = RequestMethod.POST)
    @ResponseBody
    public Object delitem(@Valid @PathVariable("id") Integer id) {
        requestManager.logicDelProfile(id);
        return ApiUtils.getResponseBody(ErrorCode.SUCCESS);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public Object addItem(@RequestBody NewProfileDTO dto) {
        requestManager.addProfile(dto);
        return ApiUtils.getResponseBody(ErrorCode.SUCCESS);
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    @ResponseBody
    public Object editItem(@RequestBody EditProfileDTO dto) {
        requestManager.editProfile(dto);
        return ApiUtils.getResponseBody(ErrorCode.SUCCESS);
    }
}