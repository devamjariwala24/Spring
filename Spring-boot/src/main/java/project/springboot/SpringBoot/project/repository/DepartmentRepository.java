package project.springboot.SpringBoot.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.springboot.SpringBoot.project.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    public Department findByDepartmentName(String departmentName);

    public Department findByDepartmentNameIgnoreCase(String departName);

}
