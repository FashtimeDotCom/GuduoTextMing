package org.guduo.textming.webView.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @athor Lijian
 * @date 2016年04月22日
 */
@Controller
@RequestMapping("/")
public class IndexController {
    private static Logger log = LoggerFactory.getLogger(IndexController.class);

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("login")
    public String login(){
        return "login";
    }

    @RequestMapping("dashboard")
    public String dashboard(){
        return "dashboard";
    }
}
