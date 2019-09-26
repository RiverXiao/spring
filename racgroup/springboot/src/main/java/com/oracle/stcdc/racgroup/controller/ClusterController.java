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
@RequestMapping("/cluster")
public class ClusterController {

    @Autowired
    ClusterService clusterService;

    @GetMapping("/info")
    public String clusterInfo(@RequestParam int id,  ModelMap map){
        Cluster cluster = clusterService.getClusterInfoById(id);
        if(cluster != null){
            map.addAttribute(cluster);
        }

        return "cluster";
    }


}
