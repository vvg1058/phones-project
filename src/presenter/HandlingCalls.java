package presenter;

import java.time.LocalDate;

import model.Phone;
import model.CellPlan;
import model.ServicePhone;

public class HandlingCalls {

    private ServicePhone servicePhone;

    public HandlingCalls() {
        servicePhone = new ServicePhone();
    }

    public boolean addPhone(String imei, String number, LocalDate manufacturingDate, String description, int minutes) {
        try {
            Phone phone = new Phone(imei, number, manufacturingDate, new CellPlan(description, minutes));
            if (servicePhone.getPhoneOne() == null) {
                servicePhone.setPhoneOne(phone);
                return true;
            }
            if (servicePhone.getPhoneTwo() == null) {
                servicePhone.setPhoneTwo(phone);
                return true;
            }
            if (servicePhone.getPhoneThree() == null) {
                servicePhone.setPhoneThree(phone);
                return true;
            }
            return false;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    public String findPhone(String imei) {
        Phone phoneFound = this.servicePhone.findPhone(imei);
        return phoneFound.toString();
    }

    public boolean registryCall(String number, String imei, int minutes) {
        return false;
    }

}
