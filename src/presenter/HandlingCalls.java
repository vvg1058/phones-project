package presenter;

import java.time.LocalDate;

import model.ServicePhone;

public class HandlingCalls {

    private ServicePhone servicePhone;

    public HandlingCalls() {
    }

    public boolean addPhone(String imei, String number, LocalDate manufacturingDate, String description, int minutes) {
        return false;
    }

    public String findPhone(String imei) {
        return null;
    }

    public boolean registryCall(String number, String imei, int minutes) {
        return false;
    }

}
