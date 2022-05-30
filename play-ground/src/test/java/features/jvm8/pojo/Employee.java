package features.jvm8.pojo;



import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Employee {
    private Long employeeId;
    private String firstName;
    private String middleName;
    private String lastName;

    private String department;
    private Double salary;
    private List<Email> emailList;

    public Employee(Long employeeId, String firstName, String middleName, String lastName, String department, Double salary, List<Email> emailList) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.department = department;
        this.salary = salary;
        this.emailList = emailList;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public List<Email> getEmailList() {
        return emailList;
    }

    public void setEmailList(List<Email> emailList) {
        this.emailList = emailList;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                ", emailList=" + emailList +
                '}';
    }
}
