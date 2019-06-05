package org.sid.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StartupController {

    @RequestMapping(value = "/", method= RequestMethod.GET)
    public String home () {

        return "layout";
    }

    @RequestMapping(value = "/login", method=RequestMethod.GET)
    public String login () {

        return "login";
    }
}
