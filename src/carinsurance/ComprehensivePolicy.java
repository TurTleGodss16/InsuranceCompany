package carinsurance;
import java.io.Serializable;

//Comprehensive policy class - inheritance
public class ComprehensivePolicy extends InsurancePolicies implements Serializable{
    //Declare additional attributes of this class
    protected int driverAge;
    protected int level;
    
    //Constructor with Exception
    /*public ComprehensivePolicy(String policyHolderName, int id, Car car, int numberOfClaims, MyDate expiryDate, int driverAge, int level) throws PolicyException, PolicyHolderNameException{
        super(policyHolderName, id, car, numberOfClaims, expiryDate);
        this.driverAge = driverAge;
        this.level = level;
    }
*/
    
    //Constructor without Exception
    public ComprehensivePolicy(String policyHolderName, int id, Car car, int numberOfClaims, MyDate expiryDate, int driverAge, int level) {
        super(policyHolderName, id, car, numberOfClaims, expiryDate);
        this.driverAge = driverAge;
        this.level = level;
    }
    
    //Create Copy Constructor - WEEK 6 / LAB 4
    public ComprehensivePolicy(ComprehensivePolicy comprehensivePolicy) throws PolicyException, PolicyHolderNameException{
        super(comprehensivePolicy.policyHolderName, comprehensivePolicy.id, comprehensivePolicy.car, comprehensivePolicy.numberOfClaims, comprehensivePolicy.expiryDate);
        this.driverAge = comprehensivePolicy.driverAge;
        this.level = comprehensivePolicy.level;
    }
    
    //Print method
    @Override
    public void print(){
        super.print();
        System.out.printf("Driver age: %d; Level: %d\n" , driverAge, level);
    }
    //toString method
    @Override
    public String toString(){
        return super.toString() + "Driver age: " + driverAge + "; Level: " + level + "\n";
    }
    //Calculate the premium of policy
    @Override
    public double calcPayment(int flatRate){
        if(driverAge < 30)
               return (car.getPrice())/50 + numberOfClaims*200 + flatRate + (30-driverAge)*50;
        return (car.getPrice())/50 + numberOfClaims*200 + flatRate;
    }
    
    //Delimited String - LAB 6
    public String toDelimitedString(){
        //return "CP" + "," + super.toDelimitedString() + "," + driverAge + "," + level;
        //Combined driverAge and level to one field
        return "CP" + "," + super.toDelimitedString() + "," + driverAge + ";" + level;
        //return "CP" + "," + policyHolderName + "," + id + "," + car.toDelimitedString() + "," + numberOfClaims + "," + expiryDate + "," + driverAge + ";" + level;
    }
}
