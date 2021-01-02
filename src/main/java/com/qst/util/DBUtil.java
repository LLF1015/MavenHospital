package com.qst.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

public class DBUtil {

//    public static Connection getConnection() throws Exception {
//        //读取配置文件
//        InputStream in=Thread.currentThread().getContextClassLoader().getResourceAsStream("resources/db.properties");
//        Properties properties=new Properties();
//        properties.load(in);
//        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
//        return dataSource.getConnection();
//    }
//
//    /**
//     *
//     * @param conn
//     * @param ps
//     * @param rs
//     * 关闭数据库连接
//     */
//    public static void close(Connection conn, PreparedStatement ps, ResultSet rs) {
//        if(rs!=null){
//            try {
//                rs.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//
//        if(ps!=null){
//            try {
//                ps.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//
//        if(conn!=null){
//            try {
//                conn.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//    }


    /**
     *
     */
    private static  String url="jdbc:mysql://localhost:3306/hospitalpro?useSSL=false&characterEncoding=UTF-8";
    private static final String user="root";
    private static final String password="12345";
    private static Connection conn=null;
    private static PreparedStatement ps=null;
    private static ResultSet rs=null;
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //init();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    /**
     *
     */
    private static void init(){
        String sql="create database if not exists hospitalpro";
        executeUpdate(sql,null);
        url="jdbc:mysql://localhost:3306/hospitalpro?useSSL=false";
    }

    /**
     *
     * @return
     */
    public static Connection createConn(){
        try {
            return DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     *
     * @param sql
     * @param params
     * @return
     */
    public static ResultSet executeQuery(String sql, Object[] params){
        conn=createConn();
        try {
            ps=conn.prepareStatement(sql);
            prepare(ps,params);
            rs=ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    /**
     *
     * @param sql
     * @param params
     * @return
     */
    public static boolean executeUpdate(String sql, Object[] params){
        conn=createConn();
        int i=0;
        try {
            ps=conn.prepareStatement(sql);
            //得到值
            prepare(ps,params);
            i=ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeAll();
        }
        if(i>0)
            return true;
        return false;
    }

    /**
     *
     *
     * @param sql
     * @param params
     * @return
     */
    public static int getCount(String sql, Object[] params){
        conn=createConn();
        int i=0;
        try {
            rs=executeQuery(sql,params);
            if(rs.next()){
                i=rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeAll();
        }
        return i;
    }

    /**
     *
     * @param sql
     */
    public static void Batch(String sql){
        conn=createConn();
        try {
            ps=conn.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param o
     */
    public static void addBatch(Object[] o){
        try {
            prepare(ps,o);
            ps.addBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     */
    public static void executeBatch(){
        try {
            ps.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeAll();
        }
    }

    /**
     *
     * @param ps
     * @param params
     * @throws SQLException
     */
    private static void prepare(PreparedStatement ps, Object[] params) throws SQLException {
        if(params!=null){
            for(int i=0;i<params.length;i++){
                ps.setObject(i+1,params[i]);
            }
        }
    }

    /**
     *
     */
    public static void closeAll(){
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(ps!=null){
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     *
     * @param sql
     * @param params
     * @return
     */
    public static ArrayList<HashMap<String, String>> getHashmap(String sql, Object[] params){
        ArrayList<HashMap<String,String>> list=new ArrayList<>();
        ResultSet rs = executeQuery(sql, params);
        try {
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();
            while (rs.next()){
                HashMap<String, String> hashMap = new HashMap<>();
                for(int i=1;i<=columnCount;i++){
                    hashMap.put(rsmd.getColumnLabel(i),rs.getString(i));
                }
                list.add(hashMap);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeAll();
        }
        return list;
    }

    public static void main(String[] args) {
        Connection connection=DBUtil.createConn();
        System.out.println(connection);
    }
}
