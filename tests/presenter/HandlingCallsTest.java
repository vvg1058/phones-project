package presenter;

import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import org.junit.Test;

import model.ServicePhone;

public class HandlingCallsTest {
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
}
