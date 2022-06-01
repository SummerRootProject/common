package com.first.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/index")
    public String index()
    {
        return "/index";
    }

    @GetMapping("/dashboard")
    public String dashboard()
    {

        return "/dashboard";
    }

    @GetMapping("/icons")
    public String icons() {

        return "/icons";
    }

    @GetMapping("/map")
    public String map() {

        return "/map";
    }

    @GetMapping("/notifications")
    public String notifications() {

        return "/notifications";
    }

    @GetMapping("/tables")
    public String tables() {

        return "/tables";
    }

    @GetMapping("/typography")
    public String typography() {

        return "/typography";
    }

    @GetMapping("/upgrade")
    public String upgrade() {

        return "/upgrade";
    }



}
