package model.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Seller implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private Integer id;
    private String name;
    private String email;
    private Date birthDate;
    private Double baseSalary;
    
    private Department department;
    
    public Seller(Integer id, String name, String email, Date birthDate, Double baseSalary, Department department){
        this.id = id;
        this.name = name;
        this.email = email;
        this.birthDate = birthDate;
        this.baseSalary = baseSalary;
        this.department = department;
    }
    
    public void setId(Integer id){
        this.id = id;
    }
    public Integer getId(){
        return id;
    }
    
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    public String getEmail(){
        return email;
    }
    
    public void setBirthDate(Date birthDate){
        this.birthDate = birthDate;
    }
    public Date getBirthDate(){
        return birthDate;
    }
    
    public void setBaseSalary(Double baseSalary){
        this.baseSalary = baseSalary;
    }
    public Double getBaseSalary(){
        return baseSalary;
    }
    
    public void setDepartment(Department department){
        this.department = department;
    }
    public Department getDepartment(){
        return department;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Seller other = (Seller) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        
        sb.append("ID ").append(id).append(" - ");
        sb.append(name).append(", ").append(email).append(", ").append(birthDate).append(", $").append(baseSalary);
        sb.append(", ").append("Department: ").append(department);
        
        return sb.toString();
    }
}