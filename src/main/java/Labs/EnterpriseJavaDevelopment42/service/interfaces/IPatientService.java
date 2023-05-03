package Labs.EnterpriseJavaDevelopment42.service.interfaces;

import Labs.EnterpriseJavaDevelopment42.model.Patient;

import java.util.Optional;

public interface IPatientService {

   /* *********** GET *********** */
    public Optional<Patient> getPatient(Integer id);

    /* *********** PUT *********** */
    void updatePatient(Patient patient, Integer id);


    /* *********** PATCH *********** */

    /* *********** DELETE *********** */
    }
