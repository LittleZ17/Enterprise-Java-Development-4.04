package Labs.EnterpriseJavaDevelopment42.repository;

import Labs.EnterpriseJavaDevelopment42.enums.Status;
import Labs.EnterpriseJavaDevelopment42.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.print.Doc;
import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
    List<Doctor> findByStatus(Status status);
    List<Doctor> findByDepartment(String department);

}
