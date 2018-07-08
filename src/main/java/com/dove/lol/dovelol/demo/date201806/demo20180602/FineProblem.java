package com.dove.lol.dovelol.demo.date201806.demo20180602;

import java.sql.*;

/**
 * @author Dovelol
 * @date 2018/6/2 9:24
 */
public class FineProblem {


    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String URL = "jdbc:mysql://localhost:3306/injoy?characterEncoding=utf-8&autoReconnect=true";
        String USER = "room";
        String PASSWORD = "room1435";
        //1.加载驱动程序
        Class.forName("com.mysql.jdbc.Driver");
        //2.获得数据库链接
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        //3.通过数据库的连接操作数据库，实现增删改查（使用Statement类）
        Statement st = conn.createStatement();
        String sql = "INSERT INTO `injoy`.`tbl_user_action_reward` (`account_id`, `reference_id`, `action_type`, `action_value`, `reward_value`, `create_id`, `create_time`, `update_id`, `update_time`, `is_deleted`) VALUES (?, '0', '102', '0', '0', '318567', '2018-06-02 01:00:00', '318567', '2018-06-02 02:00:00', '0');";
        PreparedStatement prest = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_READ_ONLY);
        conn.setAutoCommit(false);
        long statrTime = System.currentTimeMillis();
        for (int i = 510000; i < 520000; i++) {
            prest.setInt(1, i);
            prest.addBatch();
            if (i % 1000 == 0) {
                prest.executeBatch();
                conn.commit();
            }
        }
        System.out.println("time:::::::::::::"+ (System.currentTimeMillis() - statrTime));
        //关闭资源
        st.close();
        conn.close();
    }

}
