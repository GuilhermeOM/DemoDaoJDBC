package main;

import db.DB;
import java.sql.Connection;
import java.util.Date;
import model.entities.Department;
import model.entities.Seller;

public class Test1 {
    public static void main(String[] args) {
        Connection conn = DB.getConnection();
        if(conn != null){
            System.out.println("Done!");
            DB.closeConnection();
        }
        
        Seller sellerTest = new Seller(1, "Tester", "test@gmail.com", new Date(), 12345.00, new Department(1, "TestDepartment"));
        System.out.println(sellerTest);
    }
}