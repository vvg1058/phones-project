package presenter;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.time.LocalDate;
import java.util.NoSuchElementException;

import org.junit.Test;
import org.junit.Before;

import model.ServicePhone;

public class HandlingCallsTest {
    @Before
    public void cleanUp() {
        ServicePhone servicePhone = new ServicePhone();
        servicePhone.setPhoneOne(null);
        servicePhone.setPhoneTwo(null);
        servicePhone.setPhoneThree(null);
    }

    @Test
    public void testAddPhone() {
        HandlingCalls handlingCalls = new HandlingCalls();
        boolean phoneOne = handlingCalls.addPhone("123456789012345", "1234567890", LocalDate.now(), "description", 10);
        boolean phoneTwo = handlingCalls.addPhone("123456789012346", "1234567891", LocalDate.now(), "Description 2",
                20);
        boolean phoneThree = handlingCalls.addPhone("123456789012347", "1234567892", LocalDate.now(), "Description 3",
                30);
        boolean phoneFail = handlingCalls.addPhone("123456789012345", "1234567891", LocalDate.now(), "description", 10);
        assertTrue("Phone added", phoneOne);
        assertTrue("Phone added", phoneTwo);
        assertTrue("Phone added", phoneThree);
        assertTrue("Phone not added", !phoneFail);
    }

    @Test
    public void testFindPhone() {
        HandlingCalls handlingCalls = new HandlingCalls();
        handlingCalls.addPhone("123456789012345", "1234567890", LocalDate.now(), "description", 10);
        String phoneFound = handlingCalls.findPhone("123456789012345");
        assertTrue("Phone found", phoneFound != null);
    }

    @Test
    public void testRegistryCall() {
        try {
            HandlingCalls handlingCalls = new HandlingCalls();
            handlingCalls.addPhone("123456789012345", "1234567890", LocalDate.now(), "description", 10);
            boolean callRegistered = handlingCalls.registryCall("123456789012345", "MOVIL", 10);
            assertTrue("Call registered", callRegistered);
        } catch (NoSuchElementException e) {
            fail("Unexpected exception");
        }
    }

    @Test
    public void testRegistryCallFailed() {
        try {
            HandlingCalls handlingCalls = new HandlingCalls();
            handlingCalls.addPhone("123456789012345", "1234567890", LocalDate.now(), "description", 10);
            handlingCalls.registryCall("123456789012343", "MOVIL", 10);
            fail("Expected exception");
        } catch (NoSuchElementException e) {
            assertEquals("Phone with IMEI 123456789012343 not found or does not exist.", e.getMessage());
        }
    }

    @Test
    public void testAddMinutes() {
        try {
            HandlingCalls handlingCalls = new HandlingCalls();
            handlingCalls.addPhone("123456789012345", "1234567890", LocalDate.now(), "description", 10);
            int totalMinutes = handlingCalls.addMinutes("123456789012345", 10);
            assertEquals(20, totalMinutes);
        } catch (NoSuchElementException e) {
            fail("Unexpected exception");
        }
    }

    @Test
    public void testAddMinutesFail() {
        try {
            HandlingCalls handlingCalls = new HandlingCalls();
            handlingCalls.addPhone("123456789012345", "1234567890", LocalDate.now(), "description", 10);
            handlingCalls.addMinutes("123456789012343", 10);
            fail("Expected exception");
        } catch (NoSuchElementException e) {
            assertEquals("Phone with IMEI 123456789012343 not found or does not exist.", e.getMessage());
        }
    }
}
