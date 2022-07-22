package carinsurance;
import java.io.Serializable;

//Third Party Policy class - inheritance
public class ThirdPartyPolicy extends InsurancePolicies implements Serializable{
    //Declare additional attributes of this class
    protected String comments;
    
    //Constructor with Exception
    /*public ThirdPartyPolicy(String policyHolderName, int id, Car car, int numberOfClaims, MyDate expiryDate, String comments) throws PolicyException, PolicyHolderNameException{
        super(policyHolderName, id, car, numberOfClaims, expiryDate);
        this.comments = comments;
    }*/
    
    //Constructor without Exception
    public ThirdPartyPolicy(String policyHolderName, int id, Car car, int numberOfClaims, MyDate expiryDate, String comments) {
        super(policyHolderName, id, car, numberOfClaims, expiryDate);
        this.comments = comments;
    }
    
    //Create Copy Constructor - WEEK 6 / LAB 4
    public ThirdPartyPolicy(ThirdPartyPolicy thirdpartyPolicy) throws PolicyException, PolicyHolderNameException{
        super(thirdpartyPolicy.policyHolderName, thirdpartyPolicy.id, thirdpartyPolicy.car, thirdpartyPolicy.numberOfClaims, thirdpartyPolicy.expiryDate);
        this.comments = thirdpartyPolicy.comments;
    }
    
    //Print method
    @Override
    public void print(){
        super.print();
        System.out.println("Comments: " + comments);
    }
    //toString method
    @Override
    public String toString(){
        return super.toString() + "Comments: " + comments + "\n";
    }
    //Calculate the premium of policy
    @Override
    public double calcPayment(int flatRate){
        return (car.getPrice())/100 + numberOfClaims*200 + flatRate;
    }
    
    //Delimited String - LAB 6
    public String toDelimitedString(){
        return "TPP" + "," + super.toDelimitedString() + "," + comments;
        //String finalInfo = "TPP";
        //return "TPP" + "," + policyHolderName + "," + id + "," + car.toDelimitedString() + "," + numberOfClaims + "," + expiryDate.toDelimitedString() + "," + comments;
    }
}
