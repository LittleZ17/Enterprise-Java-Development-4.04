package Labs.EnterpriseJavaDevelopment42.repository;

import Labs.EnterpriseJavaDevelopment42.enums.Status;
import Labs.EnterpriseJavaDevelopment42.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {
    List<Patient> findByDateOfBirthBetween(Date date1, Date date2);
    List<Patient> findByAdmittedByDepartment(String department);
    List<Patient> findByAdmittedByStatus(Status status);
}
