package main;

import db.DB;
import java.sql.Connection;

public class Test1 {
    public static void main(String[] args) {
        Connection conn = DB.getConnection();
        if(conn != null){
            System.out.println("Done!");
            DB.closeConnection();
        }
    }
}