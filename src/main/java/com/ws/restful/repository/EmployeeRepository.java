package com.ws.restful.repository;

import com.ws.restful.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

@Repository("employeeRepository")
public interface EmployeeRepository extends JpaRepository<Employee, Serializable> {

    public abstract Employee findById(int idEmployee);
    public abstract Integer deleteEmployeeEntityById(int idEmployee);

}
