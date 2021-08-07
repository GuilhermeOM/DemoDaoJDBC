package model.dao.impl;

import java.util.List;
import model.dao.SellerDAO;
import model.entities.Department;
import model.entities.Seller;
import java.sql.Connection;

public class SellerDaoJDBC implements SellerDAO{
    
    private static Connection conn;
    
    public SellerDaoJDBC(Connection conn){
        this.conn = conn;
    }

    @Override
    public void insert(Seller obj) {
    }

    @Override
    public void update(Seller obj) {
    }

    @Override
    public void deleteById(Integer id) {
    }

    @Override
    public Seller findById(Integer id) {
        return null;
    }

    @Override
    public List<Seller> findByDepartment(Department department) {
        return null;
    }

    @Override
    public List<Seller> findAll() {
        return null;
    }
}