package model;

public class ServicePhone {

    private Phone phoneOne;
    private Phone phoneTwo;
    private Phone phoneThree;
    private ETypeCall eTypeCall;

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
        return false;
    }

    public Phone findPhone(String imei) {
        if (this.phoneOne.getImei().equals(imei)) {
            return this.phoneOne;
        } else if (this.phoneTwo.getImei().equals(imei)) {
            return this.phoneTwo;
        } else if (this.phoneThree.getImei().equals(imei)) {
            return this.phoneThree;
        }
        return null;
    }

    public int addMinutes(Phone phone) {
        return 0;

    }

}
