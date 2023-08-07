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
        if (this.phoneOne == null) {
            if (this.phoneTwo != null) {
                if (this.phoneTwo.getImei().equals(phoneOne.getImei())) {
                    throw new IllegalArgumentException("Phone already registered");
                }
            }
            if (this.phoneThree != null) {
                if (this.phoneThree.getImei().equals(phoneOne.getImei())) {
                    throw new IllegalArgumentException("Phone already registered");
                }
            }
            this.phoneOne = phoneOne;
        }
    }

    public void setPhoneTwo(Phone phoneTwo) {
        if (this.phoneTwo == null) {
            if (this.phoneOne != null) {
                if (this.phoneOne.getImei().equals(phoneTwo.getImei())) {
                    throw new IllegalArgumentException("Phone already registered");
                }
            }
            if (this.phoneThree != null) {
                if (this.phoneThree.getImei().equals(phoneTwo.getImei())) {
                    throw new IllegalArgumentException("Phone already registered");
                }
            }
            this.phoneTwo = phoneTwo;
        }
    }

    public void setPhoneThree(Phone phoneThree) {
        if (this.phoneThree == null) {
            if (this.phoneOne != null) {
                if (this.phoneOne.getImei().equals(phoneThree.getImei())) {
                    throw new IllegalArgumentException("Phone already registered");
                }
            }
            if (this.phoneTwo != null) {
                if (this.phoneTwo.getImei().equals(phoneThree.getImei())) {
                    throw new IllegalArgumentException("Phone already registered");
                }
            }
            this.phoneThree = phoneThree;
        }
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
        return null;
    }

    public int addMinutes(Phone phone) {
        return 0;

    }

}
