package com.ws.restful.service.impl;

import com.ws.restful.converter.EmployeeConverter;
import com.ws.restful.entity.Employee;
import com.ws.restful.model.EmployeeModel;
import com.ws.restful.repository.EmployeeRepository;
import com.ws.restful.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service("employeeServiceImpl")
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    @Qualifier("employeeRepository")
    private EmployeeRepository employeeRepository;

    @Autowired
    @Qualifier("employeeConverter")
    private EmployeeConverter employeeConverter;

    @Override
    public EmployeeModel addEmployee(EmployeeModel employeeModel) {
        if(employeeModel.getCreatedAt() == null){
            employeeModel.setCreatedAt(LocalDate.now());
        } else {
            employeeModel.setUpdatedAt(LocalDate.now());
        }
        Employee employee = employeeRepository.save(employeeConverter.employeeModelToEmployeeEntity(employeeModel));
        return employeeConverter.employeeEntityToEmployeeModel(employee);
    }

    @Override
    public Integer deleteEmployee(int idEmployee) {
        return employeeRepository.deleteEmployeeEntityById(idEmployee);
    }

    @Override
    public List<EmployeeModel> listAllEmployees() {
        return employeeConverter.listEmployeeEntityToListEmployeeModel(employeeRepository.findAll());
    }

    @Override
    public EmployeeModel findEmployeeById(int idEmployee) {
        return employeeConverter.employeeEntityToEmployeeModel(employeeRepository.findById(idEmployee));
    }

    @Override
    public EmployeeModel updateEmployee(int idEmployee, EmployeeModel employeeModelDetails) {
        EmployeeModel employeeModel =  employeeConverter.employeeEntityToEmployeeModel(employeeRepository.findById(idEmployee));
        if(employeeModel != null){
            employeeModel.setName(employeeModelDetails.getName());
            employeeModel.setDesignation(employeeModelDetails.getDesignation());
            employeeModel.setExpertise(employeeModelDetails.getExpertise());
            employeeModel.setUpdatedAt(LocalDate.now());
            return employeeConverter.employeeEntityToEmployeeModel(employeeRepository.save(employeeConverter.employeeModelToEmployeeEntity(employeeModel)));
        }
        return null;
    }
}
