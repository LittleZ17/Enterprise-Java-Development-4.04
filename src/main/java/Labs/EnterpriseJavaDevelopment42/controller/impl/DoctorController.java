package Labs.EnterpriseJavaDevelopment42.controller.impl;

import Labs.EnterpriseJavaDevelopment42.controller.interfaces.IDoctorController;
import Labs.EnterpriseJavaDevelopment42.enums.Status;
import Labs.EnterpriseJavaDevelopment42.model.Doctor;
import Labs.EnterpriseJavaDevelopment42.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class DoctorController implements IDoctorController {
    @Autowired
    DoctorRepository doctorRepository;

    @GetMapping("/doctors")
    public List<Doctor> getDoctors(){
        return doctorRepository.findAll();
    }

    @GetMapping("/doctors/status")
    public List<Doctor> getDoctorsByStatus(@RequestParam Optional <Status> status){
        if(status.isPresent()){
            return doctorRepository.findByStatus(status.get());
        }
        return null;
    }

    @GetMapping("/doctors/department")
    public List<Doctor> getDoctorsByDepartment(@RequestParam Optional<String> department){
        if (department.isPresent()) {
            return doctorRepository.findByDepartment(department.get());
        }
        return null;
    }

    @GetMapping("/doctors/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Doctor getDoctor(@PathVariable Integer id){
        Optional<Doctor> doctorOptional = doctorRepository.findById(id);
        if (doctorOptional.isEmpty()) return  null;
        return doctorOptional.get();
    }

}
