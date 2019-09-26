package com.oracle.stcdc.racgroup.controller;


import com.oracle.stcdc.racgroup.entity.Cluster;
import com.oracle.stcdc.racgroup.service.ClusterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class TestController {

    @Autowired
    ClusterService clusterService;

    @GetMapping("/index")
    public String getInfo(ModelMap map){
        map.addAttribute("attr", "this is the attribute");
        return  "index";
    }

    @GetMapping("testdb")
    public String testDB(ModelMap map){
        Cluster cluster = clusterService.getClusterInfoById(2);
        map.addAttribute("attr", cluster.getOsVersion());
        return "index";
    }

    @ModelAttribute("message")
    public String message(){
        return "This is Model attribute";
    }
}
