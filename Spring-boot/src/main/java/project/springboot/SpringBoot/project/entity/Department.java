package project.springboot.SpringBoot.project.entity;

//this class is used for department project in springboot

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.Length;

@Entity
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long departmentID;

    @NotBlank(message = "Please add Department Name")

    //Some of the annotations to validate input data coming in the form of JSON
//    @Length(max = 5, min = 1)
//    @Size(max = 10, min = 1)
//    @Email
//    @Positive
//    @Negative
//    @PositiveOrZero
//    @NegativeOrZero
//    @Future
//    @FutureOrPresent
//    @Past
//    @PastOrPresent

    private String departmentName;
    private String departmentAddress;
    private String departmentCode;

    public Department(Long departmentID, String departmentName, String departmentAddress, String departmentCode) {
        this.departmentID = departmentID;
        this.departmentName = departmentName;
        this.departmentAddress = departmentAddress;
        this.departmentCode = departmentCode;
    }

    public Department(){

    }


    public Long getDepartmentID(){
        return departmentID;
    }

    public void setDepartmentID(Long departmentID){
        this.departmentID = departmentID;
    }

    public String getDepartmentName(){
        return departmentName;
    }

    public void setDepartmentName(String departmentName){
        this.departmentName = departmentName;
    }

    public String getDepartmentAddress(){
        return departmentAddress;
    }

    public void setDepartmentAddress(String departmentAddress){
        this.departmentAddress = departmentAddress;
    }
    public String getDepartmentCode(){
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode){
        this.departmentCode = departmentCode;
    }

    @Override
    public String toString() {
        return STR."Department{departmentID=\{departmentID}, departmentName='\{departmentName}\{'\''}, departmentAddress='\{departmentAddress}\{'\''}, departmentCode='\{departmentCode}\{'\''}\{'}'}";
    }

}
