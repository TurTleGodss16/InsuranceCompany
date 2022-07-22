package carinsurance;
import java.io.Serializable;

enum CarType{SUV, SED, LUX, HATCH};
//Define Car class and CarType enum
public class Car implements Cloneable, Serializable {
    //Declare 4 attributes of Car class
    private String model;
    private CarType type;
    private int ManufacturingYear;
    private double Price;
    //Constructor to creata a car
    public Car(String model, CarType type,int ManufacturingYear, double Price){
        this.model = model;
        this.ManufacturingYear = ManufacturingYear;
        this.Price = Price;
        this.type = type;
    }
    
    //Create Copy Constructor - WEEK 6 / LAB 4
    public Car(Car car){
        this.model = car.model;
        this.ManufacturingYear = car.ManufacturingYear;
        this.Price = car.Price;
        this.type = car.type;
    }
    
    //Get model of car
    public String getModel(){
        return model;
    }
    //Get manufacturing year of car
    public int getYear(){
        return ManufacturingYear;
    }
    //Get price of car
    public double getPrice(){
        return Price;
    }
    //Get type of car
    public CarType getType(){
        return type;
    }
    //Week 2 Added
    //Set price of car
    public void setPrice(double price){
        Price = price;
    }
    //Set car model
    public void setModel(String model){
        this.model = model;
    }
    //Price rise of car
    public void priceRise(double rise){
        Price = Price*(1+rise);
    }
    
    //WEEK 6 - LAB 4
    //Cloneable Interface
    @Override
    public Car clone() throws CloneNotSupportedException{
        return (Car)super.clone();
    }
    
    //Delimited String - LAB 6
    public String toDelimitedString(){
        return model + "," + type + "," + ManufacturingYear + "," + Price;
    }
}
