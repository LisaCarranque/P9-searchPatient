package searchPatient.IT;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import searchPatient.configuration.DatabaseConfig;
import searchPatient.controller.PatientController;
import searchPatient.model.Patient;
import searchPatient.repository.PatientRepository;
import searchPatient.service.IPatientService;
import searchPatient.service.PatientService;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.Assert.assertNotNull;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {PatientController.class, PatientRepository.class, PatientService.class, IPatientService.class})
@EnableConfigurationProperties(value = DatabaseConfig.class)
@TestPropertySource("classpath:server-test.properties")
@ComponentScan("searchPatient")
@EnableJpaRepositories(basePackageClasses = PatientRepository.class)
@Log4j2
class PatientServiceIT {

    @Autowired
    PatientController patientController;


    @Autowired
    PatientService patientService;

    @Test
    public void addPatientInformationTest() {
        Patient patient = Patient.builder().birthdate(LocalDate.of(1990, Month.DECEMBER, 01)).address("1500 Culver")
                .phone("12345678").firstname("firstname").lastname("lastname")
                .genre("F").build();
        assertNotNull(patientService.addPatientInformation(patient));
    }

    @Test
    public void getPatientInformationTest() {
        assertNotNull(patientService.getPatientById(1000));

    }

    @Test
    public void getAllPatientInformationTest() {
        assertNotNull(patientService.findAll());
    }

}
