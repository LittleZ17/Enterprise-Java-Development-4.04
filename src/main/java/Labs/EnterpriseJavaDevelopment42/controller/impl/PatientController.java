package Labs.EnterpriseJavaDevelopment42.controller.impl;

import Labs.EnterpriseJavaDevelopment42.controller.interfaces.IPatientController;
import Labs.EnterpriseJavaDevelopment42.enums.Status;
import Labs.EnterpriseJavaDevelopment42.model.Patient;
import Labs.EnterpriseJavaDevelopment42.repository.PatientRepository;
import Labs.EnterpriseJavaDevelopment42.service.interfaces.IPatientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
public class PatientController implements IPatientController{

    @Autowired
    PatientRepository patientRepository;
    @Autowired
    IPatientService patientService;

    /* *********** GET *********** */

    @GetMapping("/patients")
    @ResponseStatus(HttpStatus.OK)
    public List<Patient> getPatients(){
        return patientRepository.findAll();
    }

    @GetMapping("/patients/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Patient> getPatient(@PathVariable Integer id){
        return patientService.getPatient(id);
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


    /* *********** POST *********** */

    @PostMapping("/patients")
    @ResponseStatus(HttpStatus.CREATED)
    public void savePatient(@RequestBody Patient patient){
        patientRepository.save(patient);
    }


    /* *********** PUT *********** */

    @PutMapping("/patients/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updatePatients(@RequestBody @Valid Patient patient, @PathVariable Integer id){
        patientService.updatePatient(patient, id);
    }
}
