package presenter;

import java.time.LocalDate;

import model.Phone;
import model.CellPlan;
import model.ETypeCall;
import model.ServicePhone;

public class HandlingCalls {

    private ServicePhone servicePhone;

    public HandlingCalls() {
        servicePhone = new ServicePhone();
    }

    public boolean addPhone(String imei, String number, LocalDate manufacturingDate, String description, int minutes) {
        try {
            if (servicePhone.findPhone(imei) != null) {
                return false;
            }
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

    public int addMinutes(String imei, int minutes) {
        Phone foundPhone = servicePhone.findPhone(imei);

        if (foundPhone != null) {
            CellPlan cellPlan = foundPhone.getCellPlan();
            int totalMinutes = cellPlan.getMinutes() + minutes;
            cellPlan.setMinutes(totalMinutes);
            return servicePhone.addMinutes(foundPhone);
        } else {
            return 0;
        }
    }

    public boolean registryCall(String imei, String numberToCall, int minutes) {
        Phone foundPhone = servicePhone.findPhone(imei);
        if (foundPhone != null) {
            if (numberToCall.charAt(0) == "+".charAt(0) && !numberToCall.substring(0, 3).equals("+57")) {
                return servicePhone.registryCall(foundPhone, minutes, ETypeCall.INTERNATIONAL);
            } else if (numberToCall.charAt(0) == "6".charAt(0)) {
                return servicePhone.registryCall(foundPhone, minutes, ETypeCall.FIXED);
            } else if (numberToCall.charAt(0) == "3".charAt(0)) {
                return servicePhone.registryCall(foundPhone, minutes, ETypeCall.MOVIL);
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}