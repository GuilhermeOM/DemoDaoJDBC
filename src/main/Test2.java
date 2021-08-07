package main;

import db.DB;
import java.util.ArrayList;
import java.util.List;
import model.dao.DaoFactory;
import model.dao.DepartmentDAO;
import model.entities.Department;
import java.util.Scanner;

public class Test2 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        
        DepartmentDAO dpDAO = DaoFactory.createDepartmentDAO();
//=============================|Insert|=========================================
//        Department department = new Department(null, "Test");
//        dpDAO.insert(department);
//        System.out.println("Done!");
//=============================|Update|=========================================
//        Department department = dpDAO.findById(9);
//        department.setName("Test1");
//        dpDAO.update(department);
//        System.out.println("Updated!");
//=============================|DeleteById|=====================================
//        System.out.print("Enter the ID to delete: ");
//        int id = scan.nextInt();
//        dpDAO.deleteById(id);
//        System.out.println("Deleted!");
//=============================|FindByID|=======================================
//        System.out.print("Enter the seller ID to get its data: ");
//        int id = scan.nextInt();
//        Department department = dpDAO.findById(id);
//        System.out.println(department);
//=============================|FindAll|========================================
//        List<Department> departments = dpDAO.findAll();
//        departments.forEach(System.out :: println);
//==============================================================================
        DB.closeConnection();
    }
}
