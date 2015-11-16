package com.github.superproxy.codegenerator.web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/domain")
@Controller
public class DomainController {

    /**
     * 对应路径 /template
     *
     * @return
     */
    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String edit() {
        // 显示界面，然后生成转换后的，支持手动编辑

        // 配置选项



        return "car/index";
    }
}
