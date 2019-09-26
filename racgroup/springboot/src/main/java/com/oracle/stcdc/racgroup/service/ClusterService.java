package com.oracle.stcdc.racgroup.service;


import com.oracle.stcdc.racgroup.entity.Cluster;
import com.oracle.stcdc.racgroup.mapper.raccdcpdb.ClusterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClusterService {

    @Autowired
    ClusterMapper clusterMapper;
    /**
     * 根据id查询 cluster信息
     * @param id
     * @return
     */
    public Cluster getClusterInfoById(int id){
        return clusterMapper.getClusterInfoById(id);
    }

    /**
     * 根据node name查询cluster 信息
     * @param nodeName
     * @return
     */
    public Cluster getClusterInfoByNode(String nodeName){
        return clusterMapper.getClusterInfoByNode(nodeName);
    }

    /**
     * Get the clusters by owner
     * @param owner
     * @return
     */
    public List<Cluster> getClustersByOwner(String owner){
        return clusterMapper.getClustersByOwner(owner);
    }

    /**
     * Modify the owner of the cluster
     * @param id
     * @return
     */
    public boolean modifyClusterOwner(String node, String newOwner){
        return  clusterMapper.modifyClusterOwner(node, newOwner);
    }
}
