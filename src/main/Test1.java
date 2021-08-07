package main;

import java.util.Date;
import model.dao.DaoFactory;
import model.dao.SellerDAO;
import model.entities.Seller;

public class Test1 {
    public static void main(String[] args) {
        
        SellerDAO seDAO = DaoFactory.createSellerDAO();
//==============================================================================
//        Seller sellerTest = new Seller(null, "Tester", "test@gmail.com", new Date(), 12345.00, new Department(1, null));
//        seDAO.insert(sellerTest);
//        System.out.println("Done!");
//==============================================================================
//        Seller sellerTest = new Seller(10, "Tester2.0", "test2@gmail.com", new Date(), 12345.00, new Department(2, null));
//        seDAO.update(sellerTest);
    }
}