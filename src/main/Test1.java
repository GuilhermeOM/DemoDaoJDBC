package main;

import db.DB;
import java.util.Date;
import model.dao.DaoFactory;
import model.dao.DepartmentDAO;
import model.dao.SellerDAO;
import model.entities.Department;
import model.entities.Seller;

public class Test1 {
    public static void main(String[] args) {
        
        SellerDAO seDAO = DaoFactory.createSellerDAO();
        DepartmentDAO dpDAO = DaoFactory.createDepartmentDAO();
        
        Seller sellerTest = new Seller(1, "Tester", "test@gmail.com", new Date(), 12345.00, new Department(1, "TestDepartment"));
        System.out.println(sellerTest);
    }
}