package com.github.superproxy.codegenerator.web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/test")
@Controller
public class TestController {

    /**
     * 对应路径 /template
     *
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index() {
        return "test";
    }

    @RequestMapping(value = "/2", method = RequestMethod.GET)
    public String index2() {
        return "test";
    }
}
