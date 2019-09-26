package com.oracle.stcdc.racgroup.entity;

import java.io.Serializable;

/**
 * Node information
 */
public class Node implements Serializable{


    private static final long serialVersionUID = -2652819469373311137L;

    private String name;

    private String rootAccess;

    private int clusterId;

    private String gridAccess;

    private String oracleAccess;

    private String vip;

    private String publicNic;

    private String giRsp;

    private String dbhomeRsp;

    private String dbRsp;

    public int getClusterId() {
        return clusterId;
    }

    public void setClusterId(int clusterId) {
        this.clusterId = clusterId;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRootAccess() {
        return rootAccess;
    }

    public void setRootAccess(String rootAccess) {
        this.rootAccess = rootAccess;
    }

    public String getGridAccess() {
        return gridAccess;
    }

    public void setGridAccess(String gridAccess) {
        this.gridAccess = gridAccess;
    }

    public String getOracleAccess() {
        return oracleAccess;
    }

    public void setOracleAccess(String oracleAccess) {
        this.oracleAccess = oracleAccess;
    }

    public String getVip() {
        return vip;
    }

    public void setVip(String vip) {
        this.vip = vip;
    }

    public String getPublicNic() {
        return publicNic;
    }

    public void setPublicNic(String publicNic) {
        this.publicNic = publicNic;
    }

    public String getGiRsp() {
        return giRsp;
    }

    public void setGiRsp(String giRsp) {
        this.giRsp = giRsp;
    }

    public String getDbhomeRsp() {
        return dbhomeRsp;
    }

    public void setDbhomeRsp(String dbhomeRsp) {
        this.dbhomeRsp = dbhomeRsp;
    }

    public String getDbRsp() {
        return dbRsp;
    }

    public void setDbRsp(String dbRsp) {
        this.dbRsp = dbRsp;
    }
}
