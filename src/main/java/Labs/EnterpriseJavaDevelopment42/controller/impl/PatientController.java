package Labs.EnterpriseJavaDevelopment42.controller.impl;

import Labs.EnterpriseJavaDevelopment42.controller.interfaces.IPatientController;
import Labs.EnterpriseJavaDevelopment42.enums.Status;
import Labs.EnterpriseJavaDevelopment42.model.Patient;
import Labs.EnterpriseJavaDevelopment42.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
public class PatientController implements IPatientController{

    @Autowired
    PatientRepository patientRepository;

    @GetMapping("/patients")
    @ResponseStatus(HttpStatus.OK)
    public List<Patient> getPatients(){
        return patientRepository.findAll();
    }

    @GetMapping("/patients/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Patient> getPatient(@PathVariable Integer id){
        Optional<Patient> patientOptional = patientRepository.findById(id);
        if (patientOptional.isEmpty()) return null;
        return patientOptional;
    }

    //url: http://localhost:8080/patients/between-date-of-birth?date1=1980-01-01&date2=1999-12-31
    @GetMapping("/patients/between-date-of-birth")
    @ResponseStatus(HttpStatus.OK)
    public List<Patient> getPatientsByBirthDay(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date date1, @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date date2){
        return patientRepository.findByDateOfBirthBetween(date1, date2);
    }

    @GetMapping("/patients/doctor-department/{department}")
    @ResponseStatus(HttpStatus.OK)
    public List<Patient> getPatientsByDepartmentAdd(@PathVariable String department){
        return patientRepository.findByAdmittedByDepartment(department);
    }

    @GetMapping("/patients/doctor-off")
    @ResponseStatus(HttpStatus.OK)
    public List<Patient> getPatientsDoctorOff(){
        return patientRepository.findByAdmittedByStatus(Status.OFF);
    }
}
