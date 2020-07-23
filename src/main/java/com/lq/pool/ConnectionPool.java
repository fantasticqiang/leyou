package com.lq.pool;

import java.util.LinkedList;

/**
 * Created by lq on 2020/4/21.
 */
public class ConnectionPool {

    private LinkedList<Connection> pool = new LinkedList<>();

    public ConnectionPool(int initSize) {
        if(initSize > 0) {

        }
    }
}
