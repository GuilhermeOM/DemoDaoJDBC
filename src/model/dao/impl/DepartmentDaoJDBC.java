package model.dao.impl;

import java.util.List;
import model.dao.DepartmentDAO;
import model.entities.Department;
import java.sql.Connection;

public class DepartmentDaoJDBC implements DepartmentDAO{

    private static Connection conn;
    
    public DepartmentDaoJDBC(Connection conn){
        this.conn = conn;
    }
    
    @Override
    public void insert(Department obj) {
    }

    @Override
    public void update(Department obj) {
    }

    @Override
    public void deleteById(Integer id) {
    }

    @Override
    public Department findById(Integer id) {
        return null;
    }

    @Override
    public List<Department> findAll() {
        return null;
    }   
}