//package com.wpt.risk.base.utils;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import java.util.Properties;
//
//public enum MyDatasource {
//
//    DATASOURCE;
//
//    private static final Logger logger = LoggerFactory.getLogger(MyDatasource.class);
//    private static final Properties pro = new Properties();
//
//    static {
//        try {
//            Class.forName("org.apache.phoenix.jdbc.PhoenixDriver");
//            pro.setProperty("phoenix.schema.isNamespaceMappingEnabled", "true");
//        } catch (Exception e) {
//            logger.error("init jdbc eroor");
//        }
//    }
//
//    public Connection getConnection(String connectionUrl) throws SQLException {
//        try {
//            return DriverManager.getConnection(connectionUrl, pro);
//        } catch (SQLException e) {
//            logger.error("get connection eroor");
//            throw e;
//        }
//    }
//}