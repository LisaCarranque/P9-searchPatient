package searchPatient.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import searchPatient.model.Gender;
import searchPatient.model.Patient;
import searchPatient.repository.PatientRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * This class is responsible for testing PatientService
 */
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
    public void addPatientInformationTest() {
        UUID uuid = UUID.randomUUID();
        Patient patient = Patient.builder().id(1).firstname("John")
                .lastname("Smith").address("1st street").phone("0000000000").uuid(uuid).birthdate(LocalDate.now()).gender(Gender.M).build();
        searchPatientService.addPatientInformation(patient);
        verify(patientRepository).save(patient);
    }

    @Test
    public void updatePatientInformationTest() {
        UUID uuid = UUID.randomUUID();
        Patient patient = Patient.builder().id(1).firstname("John")
                .lastname("Smith").address("1st street").phone("0000000000").uuid(uuid).birthdate(LocalDate.now()).gender(Gender.M).build();
        searchPatientService.updatePatientInformation(patient);
        verify(patientRepository).save(patient);
    }

    @Test
    public void removePatientInformationTest() {
        UUID uuid = UUID.randomUUID();
        Patient patient = Patient.builder().id(1).firstname("John")
                .lastname("Smith").address("1st street").phone("0000000000").uuid(uuid).birthdate(LocalDate.now())
                .gender(Gender.M).build();
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
        verify(patientRepository).findById(1);
    }

    @Test
    public void getPatientByLastnameTest() {
        searchPatientService.getPatientByLastname("lastname");
        verify(patientRepository).findByLastname("lastname");
    }

    @Test
    public void findAllDistinctLastnameTest() {
        List<Patient> patients = new ArrayList<>();
        Patient patient1 = Patient.builder()
                .id(1)
                .firstname("firstname1")
                .uuid(UUID.randomUUID())
                .address("1 street")
                .birthdate(LocalDate.now()).gender(Gender.F).phone("0000000000")
                .lastname("lastname").build();
        Patient patient2 = Patient.builder()
                .id(2)
                .firstname("firstname2")
                .uuid(UUID.randomUUID())
                .address("1 street")
                .birthdate(LocalDate.now()).gender(Gender.F).phone("0000000000")
                .lastname("lastname").build();
        patients.add(patient1);
        patients.add(patient2);
        when(patientRepository.findAll()).thenReturn(patients);
        searchPatientService.findAllDistinctLastnames();
        verify(patientRepository).findAll();
        assertEquals(Collections.singletonList("lastname"), searchPatientService.findAllDistinctLastnames());
    }

}
