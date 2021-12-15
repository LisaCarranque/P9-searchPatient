package searchPatient.model;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class PatientTest {

    @InjectMocks
    Patient patient;

    @Test
    public void testGetAndSetPatient() {
        Patient patient = Patient.builder().build();
        patient.setGenre("Femme");
        patient.setBirthdate(LocalDate.of(1990, Month.DECEMBER, 01));
        patient.setAddress("1500 Culver");
        patient.setFirstname("firstname");
        patient.setId(1);
        patient.setLastname("lastname");
        patient.setPhone("123456789");
        assertNotNull(patient);
        assertEquals("1500 Culver", patient.getAddress());
        assertEquals(LocalDate.of(1990, Month.DECEMBER, 01), patient.getBirthdate());
        assertEquals("Femme", patient.getGenre());
        assertEquals("123456789", patient.getPhone());
        assertEquals("lastname", patient.getLastname());
        assertEquals(Integer.valueOf(1), patient.getId());
    }

    @Test
    public void testBuildPatient() {
        Patient patient = Patient.builder().genre("Femme").birthdate(LocalDate.of(1990, Month.DECEMBER, 01)).address("1500 Culver")
                .phone("1234567889").id(1).lastname("lastname").firstname("firstname").build();
        assertNotNull(patient);
        assertEquals("1500 Culver", patient.getAddress());
        assertEquals(LocalDate.of(1990, Month.DECEMBER, 01), patient.getBirthdate());
        assertEquals("Femme", patient.getGenre());
        assertEquals("1234567889", patient.getPhone());
        assertEquals("lastname", patient.getLastname());
        assertEquals(Integer.valueOf(1), patient.getId());
    }

    @Test
    public void testNoArgumentConstructorPatient() {
        Patient patient = Patient.builder().build();
        assertNotNull(patient);
    }

}
