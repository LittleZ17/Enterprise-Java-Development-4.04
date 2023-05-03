package Labs.EnterpriseJavaDevelopment42.model;

import Labs.EnterpriseJavaDevelopment42.enums.Status;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@Data
@NoArgsConstructor
public class Doctor {
    @Id
    private Integer employeeId;
    private String department;
    private String name;

    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToMany(mappedBy = "admittedBy")
    @JsonIgnore
    private List<Patient> patientList;

    public Doctor(Integer employeeId, String department, String name, Status status, List<Patient> patientList) {
        this.employeeId = employeeId;
        this.department = department;
        this.name = name;
        this.status = status;
        this.patientList = patientList;
    }
}
