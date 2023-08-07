package presenter;

import java.time.LocalDate;

import model.Phone;
import model.ServicePhone;

public class HandlingCalls {

    private ServicePhone servicePhone;

    public HandlingCalls() {
    }

    public boolean addPhone(String imei, String number, LocalDate manufacturingDate, String description, int minutes) {
        return false;
    }

    public String findPhone(String imei) {
        Phone phoneFound = this.servicePhone.findPhone(imei);
        return phoneFound.toString();
    }

    public boolean registryCall(String number, String imei, int minutes) {
        return false;
    }

}
