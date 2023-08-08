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
        Phone foundPhone = findPhone(phone.getImei());

        if (foundPhone != null) {
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

            CellPlan cellPlan = foundPhone.getCellPlan();

            if (cellPlan.getMinutes() >= minutesToDeduct) {
                cellPlan.setMinutes(cellPlan.getMinutes() - minutesToDeduct);
                return true;
            }
        }

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
        Phone foundPhone = findPhone(phone.getImei());

        if (foundPhone != null) {
            int addMinutes = phone.getCellPlan().getMinutes();
            return addMinutes;
        } else {
            return 0;
        }
    }
}
