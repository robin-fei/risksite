//package com.wpt.risk.engine.config;
//
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.PropertySource;
//
//@Configuration
//@PropertySource("classpath:appConfig-dev.properties")
//@ConfigurationProperties(prefix = "phoenix")
//public class PhoenixConfig {
//
//    private String connectionUrl;
//    private String driverName;
//
//    public String getConnectionUrl() {
//        return connectionUrl;
//    }
//
//    public void setConnectionUrl(String connectionUrl) {
//        this.connectionUrl = connectionUrl;
//    }
//
//    public String getDriverName() {
//        return driverName;
//    }
//
//    public void setDriverName(String driverName) {
//        this.driverName = driverName;
//    }
//
//
//    @Override
//    public String toString() {
//        return "PhoenixConfig{" +
//                "connectionUrl='" + connectionUrl + '\'' +
//                ", driverName='" + driverName + '\'' +
//                '}';
//    }
//}