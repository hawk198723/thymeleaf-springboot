package com.jason.dao;

import com.jason.pojo.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class DepartmentDao {
    @Autowired
    private static Map<Integer, Department> departments = null;
    static {
        departments = new HashMap<Integer, Department>();

        departments.put(101,new Department(101, "admin"));
        departments.put(102,new Department(102, "op"));
        departments.put(103,new Department(103, "eng"));
        departments.put(104,new Department(104, "combat"));
        departments.put(105,new Department(105, "supply"));
    }

    public Collection<Department> getDepartments(){
        return departments.values();
    }

    public Department getDepartmentById(Integer id){
        return departments.get(id);
    }
}
