package com.oracle.stcdc.racgroup.mapper.bugdb;

import com.oracle.stcdc.racgroup.entity.Node;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


@Repository
@Mapper
public interface BugDBMapper {

    public Node getNodeInfo(String nodename);
}
