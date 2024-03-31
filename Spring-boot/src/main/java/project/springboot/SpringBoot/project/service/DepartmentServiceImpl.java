package project.springboot.SpringBoot.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.springboot.SpringBoot.project.entity.Department;
import project.springboot.SpringBoot.project.repository.DepartmentRepository;

import java.util.List;
import java.util.Objects;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    private DepartmentRepository departmentRepository;
    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> fetchDepartmentList() {
        List<Department> l = departmentRepository.findAll();
        System.out.println(l);
        return l;
    }

    @Override
    public Department fetchDepartmentById(Long departmentId) {
        return departmentRepository.findById(departmentId).get();
    }

    @Override
    public void deleteDepartmentById(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }

    @Override
    public Department updateDepartment(Long departmentId, Department department) {
        Department departmentDB = departmentRepository.findById(departmentId).get();


        if(Objects.nonNull(department.getDepartmentName()) && !"".equals(department.getDepartmentName())){
            departmentDB.setDepartmentName(department.getDepartmentName());
        }

        if(Objects.nonNull(department.getDepartmentAddress()) && !"".equals(department.getDepartmentAddress())){
            departmentDB.setDepartmentAddress(department.getDepartmentAddress());
        }

        if(Objects.nonNull(department.getDepartmentCode()) && !"".equals(department.getDepartmentCode())){
            departmentDB.setDepartmentCode(department.getDepartmentCode());
        }
        return departmentRepository.save(departmentDB);
    }

    @Override
    public Department fetchDepartmentByName(String departmentName) {
        return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
    }




}
