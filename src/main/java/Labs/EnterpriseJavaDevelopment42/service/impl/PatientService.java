package Labs.EnterpriseJavaDevelopment42.service.impl;

import Labs.EnterpriseJavaDevelopment42.model.Patient;
import Labs.EnterpriseJavaDevelopment42.repository.PatientRepository;
import Labs.EnterpriseJavaDevelopment42.service.interfaces.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Service
public class PatientService implements IPatientService {
    @Autowired
    PatientRepository patientRepository;

    /* *********** GET *********** */
    public Optional<Patient> getPatient(Integer id){
        Optional<Patient> patientOptional = patientRepository.findById(id);
        if (patientOptional.isEmpty()) return null;
        return patientOptional;
    }

    /* *********** PUT *********** */


    public void updatePatient(Patient patient, Integer id) {
        Optional <Patient> patientOptional = patientRepository.findById(id);
        if(patientOptional.isEmpty()) return;
        patient.setPatient(id);
        patientRepository.save(patient);
    }

}
