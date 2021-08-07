package model.dao.impl;

import db.DB;
import db.DbException;
import java.util.List;
import model.dao.SellerDAO;
import model.entities.Department;
import model.entities.Seller;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SellerDaoJDBC implements SellerDAO{
    
    private static Connection conn;
    
    public SellerDaoJDBC(Connection conn){
        this.conn = conn;
    }

    @Override
    public void insert(Seller obj) {
        PreparedStatement st = null;
        try{
            st = conn.prepareStatement(
                    "INSERT INTO seller "
                    + "(Name, Email, BirthDate, BaseSalary, DepartmentId) "
                    + "VALUES "      
                    + "(?, ?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS
            );
            st.setString(1, obj.getName());
            st.setString(2, obj.getEmail());
            st.setDate(3, new java.sql.Date(obj.getBirthDate().getTime()));
            st.setDouble(4, obj.getBaseSalary());
            st.setInt(5, obj.getDepartment().getId());

            int rowsAffected = st.executeUpdate();
            
            if(rowsAffected > 0){
                ResultSet rs = st.getGeneratedKeys();
                while(rs.next()){
                    int id = rs.getInt(1);
                    obj.setId(id);
                }
            }else{
                throw new DbException("Unexpected Error! No rows affected...");
            }
        }catch(SQLException e){
            throw new DbException(e.getMessage());
        }
        finally{
            DB.closePreparedStatement(st);
        }
    }

    @Override
    public void update(Seller obj) {
        PreparedStatement st = null;
        try{
            st = conn.prepareStatement(
                    "UPDATE seller "
                    + "SET Name = ?, Email = ?, BirthDate = ?, BaseSalary = ?, DepartmentId = ? "
                    + "WHERE Id = ?"
            );
            st.setString(1, obj.getName());
            st.setString(2, obj.getEmail());
            st.setDate(3, new java.sql.Date(obj.getBirthDate().getTime()));
            st.setDouble(4, obj.getBaseSalary());
            st.setInt(5, obj.getDepartment().getId());
            st.setInt(6, obj.getId());
            
            st.executeUpdate();
        }catch(SQLException e){
            throw new DbException(e.getMessage());
        }
        finally{
            DB.closePreparedStatement(st);
        }
    }
    
    @Override
    public void deleteById(Integer id) {
        PreparedStatement st = null;
        try{
            st = conn.prepareStatement(
                    "DELETE FROM seller "
                    + "WHERE Id = ?"
            );
            st.setInt(1, id);
            
            st.executeUpdate();
        }catch(SQLException e){
            throw new DbException(e.getMessage()); 
        }
        finally{
            DB.closePreparedStatement(st);
        }
    }

    @Override
    public Seller findById(Integer id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try{
            st = conn.prepareStatement(
                    "SELECT seller.*,department.Name as DepName "
                    + "FROM seller INNER JOIN department "
                    + "ON seller.departmentId = department.Id "
                    + "WHERE seller.Id = ?"
            );
            st.setInt(1, id);
            
            rs = st.executeQuery();
            if(rs.next()){
                Department department = instantiateDepartment(rs);
                Seller seller = instantiateSeller(rs, department);
                
                return seller;
            }
            return null;
        }catch(SQLException e){
            throw new DbException(e.getMessage());
        }
        finally{
            DB.closeResulSet(rs);
            DB.closePreparedStatement(st);
        }
    }

    @Override
    public List<Seller> findByDepartment(Department department) {
        return null;
    }

    @Override
    public List<Seller> findAll() {
        return null;
    }
    
    private Department instantiateDepartment(ResultSet rs) throws SQLException{
        Department department = new Department();
        department.setId(rs.getInt("DepartmentId"));
        department.setName(rs.getString("DepName"));
        
        return department;
    }
    
    private Seller instantiateSeller(ResultSet rs, Department department) throws SQLException{
        Seller seller = new Seller();
        seller.setId(rs.getInt("Id"));
        seller.setName(rs.getString("Name"));
        seller.setEmail(rs.getString("Email"));
        seller.setBirthDate(rs.getDate("BirthDate"));
        seller.setBaseSalary(rs.getDouble("BaseSalary"));
        seller.setDepartment(department);
        
        return seller;
    }
}