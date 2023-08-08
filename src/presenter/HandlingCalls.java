package presenter;

import java.nio.file.ProviderNotFoundException;
import java.time.LocalDate;
import java.util.NoSuchElementException;

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

    public int addMinutes(String imei, int minutes) throws NoSuchElementException {
        Phone foundPhone = servicePhone.findPhone(imei);

        if (foundPhone != null) {
            CellPlan cellPlan = foundPhone.getCellPlan();
            int totalMinutes = cellPlan.getMinutes() + minutes;
            cellPlan.setMinutes(totalMinutes);
            return totalMinutes;
        } else {
            throw new NoSuchElementException("Phone with IMEI " + imei + " not found or does not exist.");
        }
    }

    public boolean registryCall(String imei, String typeCall, int minutes) throws NoSuchElementException {
        Phone foundPhone = servicePhone.findPhone(imei);
        if (foundPhone != null) {
            ETypeCall eTypeCall = ETypeCall.valueOf(typeCall);
            return servicePhone.registryCall(foundPhone, minutes, eTypeCall);
        } else {
            throw new NoSuchElementException("Phone with IMEI " + imei + " not found or does not exist.");
        }
    }
}