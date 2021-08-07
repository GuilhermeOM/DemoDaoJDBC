package model.dao.impl;

import db.DB;
import java.util.List;
import java.util.ArrayList;
import model.dao.DepartmentDAO;
import model.entities.Department;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import db.DbException;

public class DepartmentDaoJDBC implements DepartmentDAO{

    private static Connection conn;
    
    public DepartmentDaoJDBC(Connection conn){
        this.conn = conn;
    }
    
    @Override
    public void insert(Department obj) {
        PreparedStatement st = null;
        try{
            st = conn.prepareStatement(
                    "INSERT INTO department "
                    + "(Name) "
                    + "VALUES "
                    + "(?)",
                    Statement.RETURN_GENERATED_KEYS
            );
            st.setString(1, obj.getName());
            
            int rowsAffected = st.executeUpdate();
            
            if(rowsAffected > 0){
                ResultSet rs = st.getGeneratedKeys();
                while(rs.next()){
                    int id = rs.getInt(1);
                    obj.setId(id);
                }
            }
        }catch(SQLException e){
            throw new DbException(e.getMessage());
        }
        finally{
            DB.closePreparedStatement(st);
        }
    }

    @Override
    public void update(Department obj) {
        PreparedStatement st = null;
        try{
            st = conn.prepareStatement(
                    "UPDATE department "
                    + "SET Name = ? "
                    + "WHERE Id = ?"
            );
            st.setString(1, obj.getName());
            st.setInt(2, obj.getId());
            
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
                    "DELETE FROM department "
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
    public Department findById(Integer id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try{
            st = conn.prepareStatement(
                    "SELECT* FROM department "
                    + "WHERE Id = ?"
            );
            st.setInt(1, id);
            
            rs = st.executeQuery();
            if(rs.next()){
                Department department = instantiateDepartment(rs);
                return department;
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
    public List<Department> findAll() {
        PreparedStatement st = null;
        ResultSet rs = null;
        try{
            st = conn.prepareStatement(
                    "SELECT* FROM seller"
            );
            
            rs = st.executeQuery();
            
            List<Department> departments = new ArrayList<>();
            
            while(rs.next()){
                Department department = instantiateDepartment(rs);
                departments.add(department);
            }
            return departments;
        }catch(SQLException e){
            throw new DbException(e.getMessage());
        }
        finally{
            DB.closeResulSet(rs);
            DB.closePreparedStatement(st);
        }
    }   
    
    private Department instantiateDepartment(ResultSet rs) throws SQLException{
        Department department = new Department();
        department.setId(rs.getInt("Id"));
        department.setName(rs.getString("Name"));
        
        return department;
    }
}