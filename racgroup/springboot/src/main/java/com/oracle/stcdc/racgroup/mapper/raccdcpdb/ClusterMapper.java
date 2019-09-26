package com.oracle.stcdc.racgroup.mapper.raccdcpdb;

import com.oracle.stcdc.racgroup.entity.Cluster;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ClusterMapper {

    /**
     * 根据id查询 cluster信息
     * @param id
     * @return
     */
    public Cluster getClusterInfoById(int id);

    /**
     * 根据node name查询cluster 信息
     * @param nodeName
     * @return
     */
    public Cluster getClusterInfoByNode(String nodeName);

    /**
     * Get the clusters by owner
     * @param owner
     * @return
     */
    public List<Cluster> getClustersByOwner(String owner);

    /**
     * Modify the owner of the cluster
     * @param node - node name
     * @param newOwner -- new owner
     * @return
     */
    public boolean modifyClusterOwner(String node, String newOwner);

}
