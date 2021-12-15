package searchPatient.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import searchPatient.model.Patient;
import searchPatient.repository.PatientRepository;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class PatientServiceTest {

    @InjectMocks
    PatientService searchPatientService;

    @Mock
    PatientRepository patientRepository;

    @Test
    public void loadService() {
        assertNotNull(searchPatientService);
    }

    @Test
    public void getPatientInformationTest() {
        searchPatientService.getPatientInformation("firstname", "name");
        verify(patientRepository).findByfirstnameAndLastname("firstname", "name");
    }

    @Test
    public void addPatientInformationTest() {
        Patient patient = Patient.builder().id(1).build();
        searchPatientService.addPatientInformation(patient);
        verify(patientRepository).save(patient);
    }

    @Test
    public void updatePatientInformationTest() {
        Patient patient = Patient.builder().id(1).build();
        searchPatientService.updatePatientInformation(patient);
        verify(patientRepository).save(patient);
    }

    @Test
    public void removePatientInformationTest() {
        Patient patient = Patient.builder().id(1).build();
        searchPatientService.removePatientInformation(patient);
        verify(patientRepository).delete(patient);
    }

    @Test
    public void findAllTest() {
        searchPatientService.findAll();
        verify(patientRepository).findAll();
    }

    @Test
    public void getPatientByIdTest() {
        searchPatientService.getPatientById(1);
        verify(patientRepository).getOne(1);
    }

}
