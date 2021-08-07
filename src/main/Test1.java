package main;

import java.util.Date;
import model.dao.DaoFactory;
import model.dao.SellerDAO;
import model.entities.Seller;
import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        SellerDAO seDAO = DaoFactory.createSellerDAO();
//==============================================================================
//        Seller sellerTest = new Seller(null, "Tester", "test@gmail.com", new Date(), 12345.00, new Department(1, null));
//        seDAO.insert(sellerTest);
//        System.out.println("Done!");
//==============================================================================
//        Seller sellerTest = new Seller(10, "Tester2.0", "test2@gmail.com", new Date(), 12345.00, new Department(2, null));
//        seDAO.update(sellerTest);
//        System.out.println("Updated!");
//==============================================================================
//        System.out.print("Enter the ID to delete: ");
//        int id = scan.nextInt();
//        seDAO.deleteById(id);
//        System.out.println("Deleted!");
    }
}