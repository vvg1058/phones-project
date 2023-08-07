package model;

import java.time.LocalDate;

public class Phone {
    private String imei;
    private String number;
    private LocalDate manufacturingDate;
    private CellPlan cellPlan;

    public Phone(String imei, String number, LocalDate manufacturingDate, CellPlan cellPlan) {
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;

    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public LocalDate getManufacturingDate() {
        return manufacturingDate;
    }

    public void setManufacturingDate(LocalDate manufacturingDate) {
        this.manufacturingDate = manufacturingDate;
    }

    public CellPlan getCellPlan() {
        return cellPlan;
    }

    public void setCellPlan(CellPlan cellPlan) {
        this.cellPlan = cellPlan;
    }

    public int getAge() {
        return 0;
    }

    @Override
    public String toString() {
        return "IMEI " + imei + "" +
                "Number " + number + "" + "Manufacturing Date " +
                manufacturingDate + "" + "Cell plan" + cellPlan;

    }

}
