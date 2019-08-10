package com.ws.restful.converter;


import com.ws.restful.entity.Employee;
import com.ws.restful.model.EmployeeModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("employeeConverter")
public class EmployeeConverter {

    public Employee employeeModelToEmployeeEntity(EmployeeModel employeeModel){
        Employee employee = new Employee();
        if(employeeModel != null){
            employee.setId(employeeModel.getId());
            employee.setName(employeeModel.getName());
            employee.setDesignation(employeeModel.getDesignation());
            employee.setExpertise(employeeModel.getExpertise());
            employee.setCreatedAt(employeeModel.getCreatedAt());
            employee.setUpdatedAt(employeeModel.getUpdatedAt());
        }
        return employee;
    }

    public EmployeeModel employeeEntityToEmployeeModel(Employee employee){
        EmployeeModel employeeModel = new EmployeeModel();
        if(employee != null){
            employeeModel.setId(employee.getId());
            employeeModel.setName(employee.getName());
            employeeModel.setDesignation(employee.getDesignation());
            employeeModel.setExpertise(employee.getExpertise());
            employeeModel.setCreatedAt(employee.getCreatedAt());
            employeeModel.setUpdatedAt(employee.getUpdatedAt());
        }
        return employeeModel;
    }

    public List<Employee> listEmployeeModelToListEmployeeEntity(List<EmployeeModel> employeeModelList){
        List<Employee> employeeEntities = new ArrayList<>();
        for(EmployeeModel employeeModel : employeeModelList){
            employeeEntities.add(employeeModelToEmployeeEntity(employeeModel));
        }
        return employeeEntities;
    }

    public List<EmployeeModel> listEmployeeEntityToListEmployeeModel(List<Employee> employeeList){
        List<EmployeeModel> employeeModelList = new ArrayList<>();
        for (Employee employee : employeeList) {
            employeeModelList.add(employeeEntityToEmployeeModel(employee));
        }
        return employeeModelList;
    }
}
