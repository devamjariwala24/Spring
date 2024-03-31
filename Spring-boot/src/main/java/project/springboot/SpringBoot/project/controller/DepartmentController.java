package project.springboot.SpringBoot.project.controller;

import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import project.springboot.SpringBoot.project.entity.Department;
import project.springboot.SpringBoot.project.error.DepartmentNotFoundException;
import project.springboot.SpringBoot.project.service.DepartmentService;

import java.util.List;

@RestController
public class DepartmentController {


    //autowire the particular object that you have in your spring container to this reference which we have created.
    @Autowired
    private DepartmentService departmentService;

    //slf4j logging library, we don't have to include this in the pom.xml file, it is already available in the system.
    private final Logger logger = LoggerFactory.getLogger(DepartmentController.class);


    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department){
        logger.info("Inside the saveDepartment method of DepartmentController Class");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> fetchDepartmentList(){
        logger.info("Inside the fetchDepartmentList method of DepartmentController Class");
        return departmentService.fetchDepartmentList();
    }

    @GetMapping("/departments/{id}")
    public Department fetchDepartmentByID(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
        logger.info("Inside the fetchDepartmentByID method of DepartmentController Class");
        return departmentService.fetchDepartmentById(departmentId);
    }

    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId){
        logger.info("Inside the deleteDepartmentById method of DepartmentController Class");
        departmentService.deleteDepartmentById(departmentId);
        return "Department Deleted Successfully";
    }

    @PutMapping("/departments/{id}")
    public Department updateDepartment(@PathVariable("id") Long departmentId, @RequestBody Department department){
        logger.info("Inside the updateDepartment method of DepartmentController Class");
        return departmentService.updateDepartment(departmentId, department);
    }

    @GetMapping("/departments/name/{name}")
    public Department fetchDepartmentByName(@PathVariable("name") String departmentName){
        logger.info("Inside the fetchDepartmentByName method of DepartmentController Class");
        return departmentService.fetchDepartmentByName(departmentName);
    }
}
