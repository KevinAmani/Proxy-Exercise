package com.riskiq.cache;

import java.util.HashMap;
import java.util.Map;

public class MetricsCache {

    //path -> lines
    private static Long lines = 0L;

    //serviceName -> owner
    private static Map<String, String> serviceMap = new HashMap<>();

    private volatile static MetricsCache instance;



    private MetricsCache () {}

    public static MetricsCache getInstance() {
        if (instance == null) {
            synchronized (MetricsCache.class) {
                if (instance == null) {
                    instance = new MetricsCache();
                }
            }
        }

        return instance;
    }


    public Long setLines(Long lines) {

        this.lines = lines;
        return this.lines;
    }

    public Long getLines() {

        return lines;
    }


    public String setOwner(String serviceName, String owner) {

        return serviceMap.put(serviceName, owner);
    }

    public String getOwner(String serviceName) {
        return serviceMap.get(serviceName);
    }


}
