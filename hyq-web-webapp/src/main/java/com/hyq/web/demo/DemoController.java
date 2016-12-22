package com.hyq.web.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Administrator on 2016/12/22.
 */
@Controller
@RequestMapping("/demo")
public class DemoController {

    @RequestMapping("/index")
    public ModelAndView demo(){
        return new ModelAndView("/home/index");
    }

}
