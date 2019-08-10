package com.ws.restful.service;

import com.ws.restful.model.EmployeeModel;

import java.util.List;

public interface EmployeeService {

    public abstract EmployeeModel addEmployee(EmployeeModel employeeModel);
    public abstract Integer deleteEmployee(int idEmployee);
    public abstract List<EmployeeModel> listAllEmployees();
    public abstract EmployeeModel findEmployeeById(int idEmployee);
    public abstract EmployeeModel updateEmployee(int idEmployee, EmployeeModel employeeModelDetails);

}
