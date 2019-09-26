package com.oracle.stcdc.racgroup.entity;

import java.io.Serializable;
import java.util.List;

/**
 * cluster infomation
 */
public class Cluster implements Serializable {


    private static final long serialVersionUID = 95150430900137668L;

    private int id;

    private int nodeCount;

    private String osVersion;

    private String hostNode;

    private String storage;

    private String owner;

    private String scan;

    private String gns;

    private String gnsDomain;

    private String scanIPv6;

    private String gnsIPv6;

    private String gnsDomainIPv6;

    private String usage;

    private String SR;

    private List<Node> nodeList;

    public int getId() {
        return id;
    }

    public String getHostNode() {
        return hostNode;
    }

    public void setHostNode(String hostNode) {
        this.hostNode = hostNode;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNodeCount() {
        return nodeCount;
    }

    public void setNodeCount(int nodeCount) {
        this.nodeCount = nodeCount;
    }

    public String getOsVersion() {
        return osVersion;
    }

    public void setOsVersion(String osVersion) {
        this.osVersion = osVersion;
    }

    public String getStorage() {
        return storage;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getScan() {
        return scan;
    }

    public void setScan(String scan) {
        this.scan = scan;
    }

    public String getGns() {
        return gns;
    }

    public void setGns(String gns) {
        this.gns = gns;
    }

    public String getGnsDomain() {
        return gnsDomain;
    }

    public void setGnsDomain(String gnsDomain) {
        this.gnsDomain = gnsDomain;
    }

    public String getScanIPv6() {
        return scanIPv6;
    }

    public void setScanIPv6(String scanIPv6) {
        this.scanIPv6 = scanIPv6;
    }

    public String getGnsIPv6() {
        return gnsIPv6;
    }

    public void setGnsIPv6(String gnsIPv6) {
        this.gnsIPv6 = gnsIPv6;
    }

    public String getGnsDomainIPv6() {
        return gnsDomainIPv6;
    }

    public void setGnsDomainIPv6(String gnsDomainIPv6) {
        this.gnsDomainIPv6 = gnsDomainIPv6;
    }

    public String getUsage() {
        return usage;
    }

    public void setUsage(String usage) {
        this.usage = usage;
    }

    public String getSR() {
        return SR;
    }

    public void setSR(String SR) {
        this.SR = SR;
    }

    public List<Node> getNodeList() {
        return nodeList;
    }

    public void setNodeList(List<Node> nodeList) {
        this.nodeList = nodeList;
    }
}
