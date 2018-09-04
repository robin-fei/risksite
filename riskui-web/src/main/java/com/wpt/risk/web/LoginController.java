package com.wpt.risk.web;

import com.wpt.risk.base.exception.AuthenticationException;
import com.wpt.risk.base.exception.UserFoundException;
import com.wpt.risk.base.exception.UserNotFoundException;
import com.wpt.risk.base.utils.Constants;
import com.wpt.risk.base.utils.ErrorCode;
import com.wpt.risk.dal.pojo.WUser;
import com.wpt.risk.engine.dto.LoginDTO;
import com.wpt.risk.engine.manage.LoginManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class LoginController {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private LoginManager loginManager;

    @GetMapping("/visual")
    public String index() {
        return "visual";
    }

    @GetMapping("/login")
    public String login(Model model,
                        @RequestParam(value = "redirectURL", defaultValue = "/visual") String redirectURL) {
        model.addAttribute("person", new LoginDTO());
        model.addAttribute("redirectURL", redirectURL);
        return "login";
    }

    @GetMapping("/reg")
    public String reg(Model model) {
        model.addAttribute("person", new LoginDTO());
        return "reg";
    }

    @PostMapping("/login")
    public String doLogin(@Valid @ModelAttribute("person") LoginDTO loginDto,
                          BindingResult result,
                          RedirectAttributesModelMap modelMap,
                          @RequestParam(value = "redirectURL", defaultValue = "/visual") String redirectURL) {
        if (result.hasErrors()) {
            modelMap.addFlashAttribute("person", loginDto);
            modelMap.addFlashAttribute("redirectURL", redirectURL);
            return "login";
        }

        ErrorCode errorCode = null;
        WUser user = null;
        try {
            user = loginManager.auth(loginDto.getUsername(), loginDto.getPassword());
        } catch (UserNotFoundException e) {
            errorCode = e.getErrorCode();
        } catch (AuthenticationException e) {
            errorCode = e.getErrorCode();
        }

        if (errorCode != null) {
            modelMap.addFlashAttribute("loginErrorMsg", errorCode.getErrorMsg());
            modelMap.addFlashAttribute("person", loginDto);
            modelMap.addFlashAttribute("redirectURL", redirectURL);
            return "login";
        }

        WebUtils.setSessionAttribute(request, Constants.CUR_USER, user);
        return "redirect:" + redirectURL;
    }

    @PostMapping("/reg")
    public String doRegister(@Valid @ModelAttribute("person") LoginDTO loginDto,
                             BindingResult result,
                             RedirectAttributesModelMap modelMap) {
        if (result.hasErrors()) {
            modelMap.addFlashAttribute("person", loginDto);
            return "reg";
        }

        ErrorCode errorCode = null;
        try {
            loginManager.reg(loginDto.getUsername(), loginDto.getPassword());
        } catch (UserFoundException e) {
            errorCode = e.getErrorCode();
        }

        if (errorCode != null) {
            modelMap.addFlashAttribute("loginErrorMsg", errorCode.getErrorMsg());
            modelMap.addFlashAttribute("person", loginDto);
            return "reg";
        }

        return "redirect:/login";
    }

}