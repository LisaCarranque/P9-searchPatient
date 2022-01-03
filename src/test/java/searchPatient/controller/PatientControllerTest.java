package searchPatient.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;
import searchPatient.model.Patient;
import searchPatient.service.PatientService;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class PatientControllerTest {


    @InjectMocks
    PatientController patientController;

    @Mock
    PatientService patientService;

    @Mock
    Model model;

    @Test
    public void loadController() {
        assertNotNull(patientController);
    }

    @Test
    public void updatePatientInformationTest() {
        patientController.updatePatientInformation(model, 1);
        verify(patientService).getPatientById(1);
    }

    @Test
    public void addPatientInformationTest() {
        Patient patient = Patient.builder().id(1).build();
        patientController.addPatientInformation(model, patient);
        verify(patientService).findAll();
    }

    @Test
    public void validatePatientInformationTest() {
        Patient patient = Patient.builder().id(1).build();
        patientController.validateUpdate(model, patient);
        verify(patientService).updatePatientInformation(patient);
        verify(patientService).findAll();
    }

    @Test
    public void homeTest() {
        patientController.home(model);
        verify(patientService).findAll();
    }
}
