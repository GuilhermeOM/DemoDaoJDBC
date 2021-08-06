package model.entities;

import java.io.Serializable;
import java.util.Objects;

public class Department implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private Integer id;
    private String name;
    
    public Department(Integer id, String name){
        this.id = id;
        this.name = name;
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.id);
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
        final Department other = (Department) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString(){
        return "ID " + id + " - " + name;
    }
}