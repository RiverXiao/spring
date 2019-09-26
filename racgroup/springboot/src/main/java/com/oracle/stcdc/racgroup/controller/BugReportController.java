package com.oracle.stcdc.racgroup.controller;

import com.oracle.stcdc.racgroup.entity.Cluster;
import com.oracle.stcdc.racgroup.service.ClusterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/bugdb")
public class BugReportController {

    @Autowired
    ClusterService clusterService;

    @GetMapping("/search")
    public String bugsearch(ModelMap map){
        return "search";
    }

    @GetMapping("/cluster")
    public String testDB(@RequestParam int id,  ModelMap map){
        Cluster cluster = clusterService.getClusterInfoById(id);
        map.addAttribute("attr", cluster.getOsVersion());
        return "index";
    }


}
