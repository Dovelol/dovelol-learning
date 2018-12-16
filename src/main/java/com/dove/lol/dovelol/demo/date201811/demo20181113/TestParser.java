package com.dove.lol.dovelol.demo.date201811.demo20181113;

import com.alibaba.druid.sql.ast.SQLStatement;
import com.alibaba.druid.sql.dialect.mysql.parser.MySqlStatementParser;

/**
 * @author Dovelol
 * @date 2018/11/13 23:13
 */
public class TestParser {

    public static void main(String[] args) {
        //String sql = "insert into employee(id,name,sharding_id) values(5,'yzh',10000)";
        String sql = "select * from tbl_injoy_detail;";
        int count = 1000000;
        long start = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            MySqlStatementParser mySqlStatementParser = new MySqlStatementParser(sql);
            SQLStatement statement = mySqlStatementParser.parseStatement();
        }
        System.out.println(System.currentTimeMillis() - start);

    }


}
