package rcs.order;

import rcs.order.RentalOrder;

import java.io.Serializable;

public class SedanCarOrder extends RentalOrder implements Serializable {

    private double bill;
    private final int COST_OF_SEDAN_PER_DAY = 14;
    private final double COST_OF_SEDAN_PER_KM = 0.25;

    public SedanCarOrder(String carID, String carType, String maker, String modelName, String registrationNumber, String plateNumber, String paymentMethod, int numberOfDays, double startOdometer, double endOdometer,double costPerDay,double costPerKm) {
        super( carID,  carType,  maker,  modelName,  registrationNumber,  plateNumber,  paymentMethod,  numberOfDays,  startOdometer,  endOdometer);
        carRentCalculation( costPerDay, costPerKm);
        setOrderType();
    }

    public double getBill() {
        return bill;
    }

    public void setBill(double bill) {
        this.bill = bill;
    }

    @Override
    public void setOrderType() {
        super.orderType= "Sedan Car Order";
    }

    @Override
    public void carRentCalculation(double costPerDay,double costPerKm){
        double total = getNumberOfDays()*costPerDay + ((getEndOdometer()-getStartOdometer())*costPerKm);
        setBill(total);
    }

    @Override
    public String toString() {
        return super.toString()+
                "SedanCarOrder{" +
                "bill=" + bill + " $"+
                ", orderID=" + getOrderID() +
                '}';
    }
}
