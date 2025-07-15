package Entity;

import jakarta.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "empdetails")
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int emp_id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "hire_date")
    private Date hireDate;

    // Getters and Setters
    public int getEmp_id() { return emp_id; }
    public void setEmp_id(int emp_id) { this.emp_id = emp_id; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public Date getHireDate() { return hireDate; }
    public void setHireDate(Date hireDate) { this.hireDate = hireDate; }

    @Override
    public String toString() {
        return "EmployeeEntity [emp_id=" + emp_id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", hireDate=" + hireDate + "]";
    }
}

