package com.ws.restful.controller;

import com.ws.restful.model.EmployeeModel;
import com.ws.restful.service.EmployeeService;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/company")
public class EmployeeController {

    private final static Log LOG = LogFactory.getLog(EmployeeController.class);

    @Autowired
    @Qualifier("employeeServiceImpl")
    private EmployeeService employeeService;


    /*
    201 CREATED
    Successful creation occurred (via either POST or PUT).
    Set the Location header to contain a link to the newly-created resource (on POST).
    Response body content may or may not be present.
     */
    @PostMapping("/employees")
    public ResponseEntity<?> createEmployee(@Valid @RequestBody EmployeeModel employeeModel){
        LOG.info("Method: createEmployee()" + " -- Param: " + employeeModel.toString());
        EmployeeModel employee = employeeService.addEmployee(employeeModel);
        if(employee == null){
            LOG.warn("Employee Create not found!");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("/employees/" + employee.getId(),HttpStatus.CREATED);
    }

    /*
    200 OK
    General success status code. This is the most common code.
    Used to indicate success.
     */
    @GetMapping("/employees/{id}")
    public ResponseEntity<?> getEmployeeById(@PathVariable(value = "id") int idEmployee){
        LOG.info("Method: getEmployeeById()");
        EmployeeModel employeeModel = employeeService.findEmployeeById(idEmployee);
        if(employeeModel == null){
            LOG.warn("Employee not found!");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        LOG.info("Employee: " + employeeModel.toString());
        return new ResponseEntity<>(employeeModel, HttpStatus.OK);
    }

    /*
    204 NO CONTENT
    Indicates success but nothing is in the response body,
    often used for DELETE and PUT operations.
     */
    @PutMapping("/employees/{id}")
    public ResponseEntity<?> updateEmployee(@PathVariable(value = "id") int idEmployee, @Valid @RequestBody EmployeeModel employeeModelDetails){
        LOG.info("Method: updateEmployee()" + " -- Params: " + employeeModelDetails.toString());
        EmployeeModel employeeModel = employeeService.updateEmployee(idEmployee, employeeModelDetails);
        if(employeeModel == null){
            LOG.warn("Employee not found!");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("/employees/" + employeeModel.getId(), HttpStatus.NO_CONTENT);
    }

    /*
    204 NO CONTENT
    Indicates success but nothing is in the response body,
    often used for DELETE and PUT operations.
     */
    @DeleteMapping("/employees/{id}")
    public ResponseEntity deleteEmployee(@PathVariable(value = "id") int idEmployee){
        LOG.info("Method: deleteEmployee()");
        if(employeeService.deleteEmployee(idEmployee) != 0){
            LOG.warn("Employee not found to delete!");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        LOG.info("Employee Delete: ");
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/employees")
    public ResponseEntity<List<EmployeeModel>> getAllEmployees(){
        LOG.info("Method: getAllEmployees()");
        List<EmployeeModel> listEmployees = employeeService.listAllEmployees();
        if(listEmployees == null || listEmployees.size() == 0){
            LOG.warn("There are no employees!");
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(listEmployees, HttpStatus.OK);
//        return employeeService.listAllEmployees();
    }

}
