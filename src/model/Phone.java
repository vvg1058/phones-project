package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Phone {
    private String imei;
    private String number;
    private LocalDate manufacturingDate;
    private CellPlan cellPlan;

    public Phone(String imei, String number, LocalDate manufacturingDate, CellPlan cellPlan) {
        this.imei = imei;
        this.number = number;
        this.manufacturingDate = manufacturingDate;
        this.cellPlan = cellPlan;
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
        return String.format(
                "The phone with IMEI %s has the number %s, was manufactured on %s and has the following cell plan: %s",
                imei, number, manufacturingDate.format(DateTimeFormatter.ISO_LOCAL_DATE), cellPlan);
    }

}
