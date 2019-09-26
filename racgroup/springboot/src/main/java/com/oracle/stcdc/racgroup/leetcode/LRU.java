package com.oracle.stcdc.racgroup.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 第 146 号问题：LRU缓存机制
 */
public class LRU{

    private int capacity;

    private List<Object> list;

    private Map<Object, Integer> map;   //存储索引

    private int eldest;  //

    private int i = 1;

    public LRU(int capacity){
        this.capacity = capacity;
        list = new ArrayList<Object>(capacity);
        map = new HashMap<>(capacity);
        eldest = 0;
    }

    /**
     * 写数据
     * @param value
     */
    public void put(Object o){

       if(i < capacity){
           list.set(eldest, o);
       }

    }

    public static void main(String[] args) {

    }
}
