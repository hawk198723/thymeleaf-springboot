package com.jason.dao;

import com.jason.pojo.Department;
import com.jason.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class EmployeeDao {
    private static Map<Integer, Employee> employees = null;
    @Autowired
    private DepartmentDao departmentDao;
    static {

        employees = new HashMap<Integer, Employee>();

        employees.put(101,new Employee(1001, "Jason","jason232424@gmail.com",1,new Department(101,"admin")));
        employees.put(102,new Employee(1002, "Lucas","lucaserer4@gmail.com",1,new Department(102,"op")));
        employees.put(103,new Employee(1003, "Cheng","2456ff24@gmail.com",0,new Department(103,"eng")));
        employees.put(104,new Employee(1004, "Green","rtyry424@gmail.com",0,new Department(104,"combat")));
        employees.put(105,new Employee(1005, "Beaver","2drer4@gmail.com",0,new Department(105,"supply")));
    }
// add employee
    private static Integer initId =1006;
    public void save(Employee employee){
        if(employee.getId() == null){
            employee.setId(initId++);
        }

        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));

        employees.put(employee.getId(),employee);
    }

    // search
    public Collection<Employee> getAll(){
        return employees.values();
    }

    public Employee getEmployeeById(Integer id){
        return employees.get(id);
    }

    public void delete(Integer id){
        employees.remove(id);
    }
}
