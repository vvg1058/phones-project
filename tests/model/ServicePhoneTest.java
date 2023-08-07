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
}
