package Labs.EnterpriseJavaDevelopment42.service.impl;

import Labs.EnterpriseJavaDevelopment42.enums.Status;
import Labs.EnterpriseJavaDevelopment42.model.Doctor;
import Labs.EnterpriseJavaDevelopment42.repository.DoctorRepository;
import Labs.EnterpriseJavaDevelopment42.service.interfaces.IDoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class DoctorService implements IDoctorService {

    @Autowired
    DoctorRepository doctorRepository;

    /* *********** GET *********** */

    public List<Doctor> getDoctorsByStatus(Optional<Status> status){
        if(status.isPresent()){
            return doctorRepository.findByStatus(status.get());
        }
        return null;
    }

    public List<Doctor> getDoctorsByDepartment(Optional<String> department){
        if (department.isPresent()) {
            return doctorRepository.findByDepartment(department.get());
        }
        return null;
    }

    public Doctor getDoctor(Integer id){
        Optional<Doctor> doctorOptional = doctorRepository.findById(id);
        if (doctorOptional.isEmpty()) return  null;
        return doctorOptional.get();
    }

    /* *********** PATCH *********** */

    @Override
    public void updateDoctorStatus(Status status, Integer id) {
        Optional<Doctor> doctorOptional = doctorRepository.findById(id);
        if(doctorOptional.isEmpty()) return;
        Doctor doctor = doctorOptional.get();
        doctor.setStatus(status);

        doctorRepository.save(doctor);
    }

    @Override
    public void updateDoctorDepartment(String department, Integer id) {
        Optional<Doctor> doctorOptional = doctorRepository.findById(id);
        if(doctorOptional.isEmpty()) return;
        Doctor doctor = doctorOptional.get();
        doctor.setDepartment(department);

        doctorRepository.save(doctor);
    }
}
