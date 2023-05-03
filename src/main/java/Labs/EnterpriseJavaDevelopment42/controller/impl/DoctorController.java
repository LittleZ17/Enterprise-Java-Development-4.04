package Labs.EnterpriseJavaDevelopment42.controller.impl;

import Labs.EnterpriseJavaDevelopment42.controller.dto.DoctorDepartmentDTO;
import Labs.EnterpriseJavaDevelopment42.controller.dto.DoctorStatusDTO;
import Labs.EnterpriseJavaDevelopment42.controller.interfaces.IDoctorController;
import Labs.EnterpriseJavaDevelopment42.enums.Status;
import Labs.EnterpriseJavaDevelopment42.model.Doctor;
import Labs.EnterpriseJavaDevelopment42.repository.DoctorRepository;
import Labs.EnterpriseJavaDevelopment42.service.interfaces.IDoctorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class DoctorController implements IDoctorController {
    @Autowired
    DoctorRepository doctorRepository;
    @Autowired
    IDoctorService doctorService;

    /* *********** GET *********** */

    @GetMapping("/doctors")
    public List<Doctor> getDoctors(){
        return doctorRepository.findAll();
    }

    @GetMapping("/doctors/status")
    public List<Doctor> getDoctorsByStatus(@RequestParam Optional <Status> status){
        return doctorService.getDoctorsByStatus(status);
    }

    @GetMapping("/doctors/department")
    public List<Doctor> getDoctorsByDepartment(@RequestParam Optional<String> department){
        return doctorService.getDoctorsByDepartment(department);
    }

    @GetMapping("/doctors/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Doctor getDoctor(@PathVariable Integer id){
        return doctorService.getDoctor(id);
    }


    /* *********** POST *********** */

    @PostMapping("/doctors")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveDoctor(@RequestBody @Valid Doctor doctor){
        doctorRepository.save(doctor);
    }

    /* *********** PUT *********** */

    @PatchMapping("/doctors/status/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateDoctorStatus(@RequestBody DoctorStatusDTO doctorStatusDTO, @PathVariable Integer id){
        doctorService.updateDoctorStatus(doctorStatusDTO.getStatus(), id);
    }

    @PatchMapping("/doctors/department/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateDoctorDepartment(@RequestBody DoctorDepartmentDTO doctorDepartmentDTO, @PathVariable Integer id){
        doctorService.updateDoctorDepartment(doctorDepartmentDTO.getDepartment(), id);
    }


}
