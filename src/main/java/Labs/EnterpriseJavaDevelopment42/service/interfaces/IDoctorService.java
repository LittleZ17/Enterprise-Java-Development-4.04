package Labs.EnterpriseJavaDevelopment42.service.interfaces;

import Labs.EnterpriseJavaDevelopment42.controller.dto.DoctorStatusDTO;
import Labs.EnterpriseJavaDevelopment42.enums.Status;
import Labs.EnterpriseJavaDevelopment42.model.Doctor;

import java.util.List;
import java.util.Optional;

public interface IDoctorService {

    public List<Doctor> getDoctorsByStatus(Optional<Status> status);
    public List<Doctor> getDoctorsByDepartment(Optional<String> department);
    public Doctor getDoctor(Integer id);

    void updateDoctorStatus(Status status, Integer id);

    void updateDoctorDepartment(String department, Integer id);
}
