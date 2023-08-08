package model;

import java.time.LocalDate;

import org.junit.Test;

import static org.junit.Assert.*;

public class ServicePhoneTest {
    @Test
    public void testFindPhone() {
        Phone phoneOne = new Phone("123", "123", LocalDate.now(), null);
        Phone phoneTwo = new Phone("456", "456", LocalDate.now(), null);
        Phone phoneThree = new Phone("789", "789", LocalDate.now(), null);
        ServicePhone servicePhone = new ServicePhone();
        servicePhone.setPhoneOne(phoneOne);
        servicePhone.setPhoneTwo(phoneTwo);
        servicePhone.setPhoneThree(phoneThree);
        Phone phoneFound = servicePhone.findPhone("123");
        assertSame(phoneOne, phoneFound);
    }

    @Test
    public void testRegistryCall() {
        Phone phoneOne = new Phone("123", "123", LocalDate.now(), new CellPlan("30 minutes all destination", 30));
        Phone phoneTwo = new Phone("456", "456", LocalDate.now(), new CellPlan("1000 minutes all destination", 1000));
        Phone phoneThree = new Phone("789", "789", LocalDate.now(), new CellPlan("2000 minutes all destination", 2000));
        ServicePhone servicePhone = new ServicePhone();
        servicePhone.setPhoneOne(phoneOne);
        servicePhone.setPhoneTwo(phoneTwo);
        servicePhone.setPhoneThree(phoneThree);
        boolean callRegistered = servicePhone.registryCall(phoneOne, 30, ETypeCall.MOVIL);
        boolean callRegistered2 = servicePhone.registryCall(phoneTwo, 250, ETypeCall.FIXED);
        boolean callRegistered3 = servicePhone.registryCall(phoneThree, 500, ETypeCall.INTERNATIONAL);
        assertTrue(callRegistered);
        assertTrue(callRegistered2);
        assertTrue(callRegistered3);
        assertEquals(0, phoneOne.getCellPlan().getMinutes());
        assertEquals(500, phoneTwo.getCellPlan().getMinutes());
        assertEquals(500, phoneThree.getCellPlan().getMinutes());

    }
}
