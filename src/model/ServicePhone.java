package model;

public class ServicePhone {

    private Phone phoneOne;
    private Phone phoneTwo;
    private Phone phoneThree;

    public Phone getPhoneOne() {
        return phoneOne;
    }

    public void setPhoneOne(Phone phoneOne) {
        this.phoneOne = phoneOne;
    }

    public void setPhoneTwo(Phone phoneTwo) {
        this.phoneTwo = phoneTwo;
    }

    public void setPhoneThree(Phone phoneThree) {
        this.phoneThree = phoneThree;
    }

    public Phone getPhoneTwo() {
        return phoneTwo;
    }

    public Phone getPhoneThree() {
        return phoneThree;
    }

    public boolean registryCall(Phone phone, int minutes, ETypeCall eTypeCall) {
        int minutesToDeduct;

        switch (eTypeCall) {
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
                throw new IllegalArgumentException("Invalid call type: " + eTypeCall);
        }
        minutesToDeduct = minutes * minutesToDeduct;

        CellPlan cellPlan = phone.getCellPlan();

        if (cellPlan.getMinutes() >= minutesToDeduct) {
            cellPlan.setMinutes(cellPlan.getMinutes() - minutesToDeduct);
            return true;
        }

        return false;

    }

    public Phone findPhone(String imei) {
        if (this.phoneOne != null && this.phoneOne.getImei().equals(imei)) {
            return this.phoneOne;
        } else if (this.phoneTwo != null && this.phoneTwo.getImei().equals(imei)) {
            return this.phoneTwo;
        } else if (this.phoneThree != null && this.phoneThree.getImei().equals(imei)) {
            return this.phoneThree;
        }
        return null;
    }

    public int addMinutes(Phone phone) {
        return phone.getCellPlan().getMinutes();
    }
}
