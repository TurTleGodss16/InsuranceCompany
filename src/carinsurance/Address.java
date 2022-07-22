package carinsurance;
import java.io.Serializable;

//New class week 2 - Address
public class Address implements Cloneable, Comparable<Address>, Serializable {
    //Declare attributes of Address class
    private int streetNum;
    private String street, suburb, city;
    //Constructor
    public Address(int streetNum, String street, String suburb, String city){
        this.streetNum = streetNum;
        this.street = street;
        this.suburb = suburb;
        this.city = city;
    }
    
    //Create Copy Constructor - WEEK 6 / LAB 4
    public Address(Address address){
        this.streetNum = address.streetNum;
        this.street = address.street;
        this.suburb = address.suburb;
        this.city = address.city;
    }
    
    //Get the address
    public String getAddress(){
        return "Street number is: " + streetNum + ", on street: " + street + ", suburb: " + suburb + ", city: " + city;
    }
    //Set city
    public void setCity(String city){
        this.city = city;
    }
    
    //Set street num
    public void setStreetNum(int num){
        this.streetNum = num;
    }
    
    //Set Street
    public void setStreet(String street){
        this.street = street;
    }
    
    //Set Subrub
    public void setSuburb(String suburb){
        this.suburb = suburb;
    }
    
    //Set address
    public void setAddress(Address newAddress){
        this.streetNum = newAddress.streetNum;
        this.street = newAddress.street;
        this.suburb = newAddress.suburb;
        this.city = newAddress.city;
    }
    //Get streetNum
    public int getStreetNum(){
        return streetNum;
    }
    //Get street
    public String getStreet(){
        return street;
    }
    //Get suburb
    public String getSuburb(){
        return suburb;
    }
    //Get city
    public String getCity(){
        return city;
    }
    
    //WEEK 6 - LAB 4
    //Cloneable Interface
    @Override
    public Address clone() throws CloneNotSupportedException{
        return (Address)super.clone();
    }
    
    //Comparable Interface
    @Override
    public int compareTo(Address otherAddress){
        return city.compareTo(otherAddress.city);
    }
    
    //Delimited String
    public String toDelimitedString(){
        return streetNum + "," + street + "," + suburb + "," + city;
    }
}
