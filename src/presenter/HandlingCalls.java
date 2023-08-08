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

    public boolean registryCall(String imei, ETypeCall callType)
            throws NoSuchElementException, IllegalArgumentException {
        Phone foundPhone = servicePhone.findPhone(imei);

        if (foundPhone != null) {
            int minutesToDeduct;

            switch (callType) {
                case MOVIL:
                    minutesToDeduct = 1;
                    break;
                case FIXED:
                    minutesToDeduct = 2;
                    break;
                case INTERNATIONAL:
                    minutesToDeduct = 3;
                    break;
                default:
                    throw new IllegalArgumentException("Invalid call type: " + callType);
            }

            CellPlan cellPlan = foundPhone.getCellPlan();

            if (cellPlan.getMinutes() >= minutesToDeduct) {
                cellPlan.setMinutes(cellPlan.getMinutes() - minutesToDeduct);
                return true;
            } else {
                return false;
            }
        } else {
            throw new NoSuchElementException("Phone with IMEI " + imei + " not found or does not exist.");
        }
    }
}