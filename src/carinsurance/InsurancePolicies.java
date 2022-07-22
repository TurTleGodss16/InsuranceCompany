package carinsurance;
import java.util.*;
import java.io.Serializable;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.*;
import java.util.stream.*;
import java.util.function.*;

//Abstract bass class policy that supports the common features of all policies
public abstract class InsurancePolicies implements Cloneable, Comparable<InsurancePolicies>, Serializable{
    protected String policyHolderName;
    protected int id;
    protected Car car;
    protected int numberOfClaims;
    protected MyDate expiryDate;
    //Constructor with throws
    /*public InsurancePolicies(String policyHolderName, int id, Car car, int numberOfClaims, MyDate expiryDate) throws PolicyException, PolicyHolderNameException{
        if(!Pattern.matches("[A-Z]{1}[a-z]{1,} [A-Z]{1}[a-z]{1,}", policyHolderName))
        {
            throw new PolicyHolderNameException(policyHolderName);
        }
        this.policyHolderName = policyHolderName;
        if(id<3000000 || id>3999999)
        {
            throw new PolicyException(id);
        }
        this.id = id;
        this.numberOfClaims = numberOfClaims;
        //this.car = new Car("SUV-12", 2018, 5000.0);
        this.car = car;
        this.expiryDate = expiryDate;
    }*/
    
    //Constructor without throws
    public InsurancePolicies(String policyHolderName, int id, Car car, int numberOfClaims, MyDate expiryDate){
        this.policyHolderName = policyHolderName;
        this.id = id;
        this.numberOfClaims = numberOfClaims;
        //this.car = new Car("SUV-12", 2018, 5000.0);
        this.car = car;
        this.expiryDate = expiryDate;
    }
    
    //Create Copy Constructor - WEEK 6 / LAB 4
    public InsurancePolicies(InsurancePolicies policy){
        this.policyHolderName = policy.policyHolderName;
        this.id = policy.id;
        this.numberOfClaims = policy.numberOfClaims;
        this.car = new Car(policy.car);
        this.expiryDate = new MyDate(policy.expiryDate);
    }
    
    //Display info
    public void print(){
        System.out.print("Policy holder name: " + policyHolderName + "; ");
        System.out.print("ID: " + id + "; ");
        System.out.print("Type: " + car.getType());
        System.out.printf(", Model: %s, Manufacturing year: %d, Price: %.1f; ", car.getModel(), car.getYear(), car.getPrice());
        System.out.print("Number of claims: " + numberOfClaims + "; ");
        System.out.print(" The expiry date: " + expiryDate.getDate() + "; ");
    }
    public String toString(){
        return "Policy holder name: " + policyHolderName + "; ID: " + id + "; Type: " + car.getType() + ", Model: " + car.getModel() + ", Manufacturing year: " + car.getYear() + ", Price: " + car.getPrice() + "; Number of claims: " + numberOfClaims + "; The expiry date: " + expiryDate.getDate() + "; ";
    }
    public abstract double calcPayment(int flatRate);
    
    //WEEK 2 CODE ADDED
    //Get ID
    public int getID(){
        return this.id;
    }
    
    //Get name
    public String getPolicyHolderName(){
        return this.policyHolderName;
    }
    
    //Get number of claims
    public int getNumberOfClaims(){
        return this.numberOfClaims;
    }
    
    //Set policy holder name
    public void setPolicyHolderName(String newPolicyHolderName){
        policyHolderName = newPolicyHolderName;
    }
    //Set car model
    public void setCarModel(String model){
        car.setModel(model);
    }
    //Print a list of policies - ArrayList
    /*public static void printPolicies(ArrayList<InsurancePolicies> policies){
        for(InsurancePolicies policy:policies)
        {
            policy.print();
        }
    }*/
    
    //Print a list of policies - ArrayList - Lambda / Stream
    public static void printPolicies(ArrayList<InsurancePolicies> policies){
       policies.forEach(x -> x.print());
    }
    
    //Print policies - HashMap
    public static void printPolicies(HashMap<Integer, InsurancePolicies> policies){
        for(InsurancePolicies policy:policies.values())
        {
            policy.print();
        }
    }
    
    //Calculate total payment premium - ArrayList
    /*public static double calcTotalPayment(ArrayList<InsurancePolicies> policies, int flatRate){
        double totalPayment = 0;
        for(InsurancePolicies policy:policies)
        {
            totalPayment += policy.calcPayment(flatRate);
        }
        return totalPayment;
    }*/
    
    //Calculate total payment premium - ArrayList - Lambda / Stream
    public static double calcTotalPayment(ArrayList<InsurancePolicies> policies, int flatRate){
       return policies.stream().map(x -> x.calcPayment(flatRate)).reduce(0.0, (x,y) -> x+y);
    }
    
    //Calculate total payment - HashMap
    public static double calcTotalPayment(HashMap<Integer, InsurancePolicies> policies, int flatRate){
        double totalPayment = 0;
        for(InsurancePolicies policy:policies.values())
        {
            totalPayment += policy.calcPayment(flatRate);
        }
        return totalPayment;
    }
    
    //Car price rise
    public void carPriceRise(double risePercent){
        car.priceRise(risePercent);
    }
    
    //Car price rise ALL - ArrayList
    /*public static void carPriceRiseAll(ArrayList<InsurancePolicies> policies, double risePercent){
        for(InsurancePolicies policy:policies)
        {
            policy.carPriceRise(risePercent);
        }
    }*/
    
    //Car price rise ALL - ArrayList - Lambda / Stream - LAB8
    public static void carPriceRiseAll(ArrayList<InsurancePolicies> policies, double risePercent){
       policies.forEach(x -> x.carPriceRise(risePercent));
    }
    
    //Car price rise ALL - HashMap
    public static void carPriceRiseAll(HashMap<Integer, InsurancePolicies> policies, double risePercent){
        for(InsurancePolicies policy:policies.values())
        {
            policy.carPriceRise(risePercent);
        }
    }
    
    //Filter by Car Model - ArrayList
    /*public static ArrayList<InsurancePolicies> filterByCarModel(ArrayList<InsurancePolicies> policies, String carModel){
        ArrayList<InsurancePolicies> filterPolicy = new ArrayList<InsurancePolicies>();
        for(InsurancePolicies policy:policies)
        {
            if(policy.car.getModel().contains(carModel))
            {
                filterPolicy.add(policy);
            }
        }
        return filterPolicy;
    }*/
    
    //Filter by Car Model - ArrayList - Lambda / Stream - LAB8
    public static ArrayList<InsurancePolicies> filterByCarModel(ArrayList<InsurancePolicies> policies, String carModel){
        return (ArrayList<InsurancePolicies>)(policies.stream()
                .filter(x -> x.getCar().getModel().contains(carModel))
                .collect(Collectors.toList()));
    }
    
    //Filter by Car Model - HashMap
    public static HashMap<Integer, InsurancePolicies> filterByCarModel(HashMap<Integer, InsurancePolicies> policies, String carModel){
        HashMap<Integer, InsurancePolicies> filterPolicy = new HashMap<Integer, InsurancePolicies>();
        for(InsurancePolicies policy:policies.values())
        {
            if(policy.car.getModel().contains(carModel))
            {
                filterPolicy.put(policy.getID(), policy);
            }
        }
        return filterPolicy;
    }
    
    //WEEK 3 CODE ADDED
    //Get expiry date of policy
    public MyDate getExpiryDate(){
        MyDate expiryDateGet = new MyDate(expiryDate.getYear(), expiryDate.getMonth(), expiryDate.getDay());
        return expiryDateGet;
    }
    
    //Filter policies by expiry date and add to a list - ArrayList
    /*public static ArrayList<InsurancePolicies> filterByExpiryDate(ArrayList<InsurancePolicies> policies, MyDate date){
        ArrayList<InsurancePolicies> filterExpiryDate = new ArrayList<InsurancePolicies>();
        for(InsurancePolicies policy:policies)
        {
            //MyDate policyDate = new MyDate(policy.expiryDate.getYear(), policy.expiryDate.getMonth(), policy.expiryDate.getDay());
            MyDate policyDate = policy.getExpiryDate();
            if(policyDate.isExpired(date))
            {
                filterExpiryDate.add(policy);
            }
        }
        return filterExpiryDate;
    }*/
    
    //Filter policies by expiry date and add to a list - ArrayList - Lambda / Stream - LAB8
    public static ArrayList<InsurancePolicies> filterByExpiryDate(ArrayList<InsurancePolicies> policies, MyDate date){
        return (ArrayList<InsurancePolicies>)(policies.stream()
                .filter(x -> x.getExpiryDate().isExpired(date))
                .collect(Collectors.toList()));
    }
    
    //Filter Policies by Date - HashMap
    public static HashMap<Integer, InsurancePolicies> filterByExpiryDate(HashMap<Integer, InsurancePolicies> policies, MyDate date){
        HashMap<Integer, InsurancePolicies> filterExpiryDate = new HashMap<Integer, InsurancePolicies>();
        for(InsurancePolicies policy:policies.values())
        {
            MyDate policyDate = policy.getExpiryDate();
            if(policyDate.isExpired(date))
            {
                filterExpiryDate.put(policy.getID(), policy);
            }
        }
        return filterExpiryDate;
    }
    
    //get car
    public Car getCar(){
        return car;
    }
    
    //WEEK 6 - LAB 4
    //Cloneable Interface
    @Override
    public InsurancePolicies clone() throws CloneNotSupportedException{
        InsurancePolicies output = (InsurancePolicies)super.clone();
        output.car = car.clone();
        output.expiryDate = expiryDate.clone();
        return output;
    }
    
    //Shallow copy ArrayList of policies - ArrayList / ArrayList
    /*public static ArrayList<InsurancePolicies> shallowCopy(ArrayList<InsurancePolicies> policies){
        ArrayList<InsurancePolicies> shallowCopyList = new ArrayList<InsurancePolicies>();
        for(InsurancePolicies policy:policies)
        {
            shallowCopyList.add(policy);
        }
        return shallowCopyList;
    }*/
    
    //Shallow copy ArrayList of policies - ArrayList / ArrayList - Lambda / Stream - LAB8
    public static ArrayList<InsurancePolicies> shallowCopy(ArrayList<InsurancePolicies> policies){
        return (ArrayList<InsurancePolicies>)(policies.stream()
                .collect(Collectors.toList()));
    }
    
    //Deep copy ArrayList of policies with clone() - ArrayList / ArrayList
    /*public static ArrayList<InsurancePolicies> deepCopy(ArrayList<InsurancePolicies> policies) throws CloneNotSupportedException{
        ArrayList<InsurancePolicies> deepCopyList = new ArrayList<InsurancePolicies>();
        for(InsurancePolicies policy:policies)
        {
            deepCopyList.add(policy.clone());
        }
        return deepCopyList;
    }*/
    
    //Deep copy ArrayList of policies with clone() - ArrayList / ArrayList - Lambda / Stream - LAB8
    public static ArrayList<InsurancePolicies> deepCopy(ArrayList<InsurancePolicies> policies) throws CloneNotSupportedException{
        return (ArrayList<InsurancePolicies>)(policies.stream()
                .map(x -> {
                    try
                    {
                       return x.clone();
                    }
                    catch(CloneNotSupportedException e)
                    {
                        throw new RuntimeException(e);
                    }
                })
                .collect(Collectors.toList()));
    }
    
    //Shallow Copy - ArrayList / HashMap
    public static ArrayList<InsurancePolicies> shallowCopy(HashMap<Integer, InsurancePolicies> policies){
        ArrayList<InsurancePolicies> shallowCopyList = new ArrayList<InsurancePolicies>();
        for(InsurancePolicies policy:policies.values())
        {
            shallowCopyList.add(policy);
        }
        return shallowCopyList;
    }
    
    //Deep Copy with clone() - ArrayList / HashMap
    public static ArrayList<InsurancePolicies> deepCopy(HashMap<Integer, InsurancePolicies> policies) throws CloneNotSupportedException{
        ArrayList<InsurancePolicies> deepCopyList = new ArrayList<InsurancePolicies>();
        for(InsurancePolicies policy:policies.values())
        {
            deepCopyList.add(policy.clone());
        }
        return deepCopyList;
    }
    
    //Shallow Copy - HashMap / HashMap
    public static HashMap<Integer, InsurancePolicies> shallowCopyHashMap(HashMap<Integer, InsurancePolicies> policies){
        HashMap<Integer, InsurancePolicies> shallowCopyList = new HashMap<Integer, InsurancePolicies>();
        for(InsurancePolicies policy:policies.values())
        {
            shallowCopyList.put(policy.getID(), policy);
        }
        return shallowCopyList;
    }
    
    //Deep Copy - HashMap / HashMap
    public static HashMap<Integer, InsurancePolicies> deepCopyHashMap(HashMap<Integer, InsurancePolicies> policies) throws CloneNotSupportedException{
        HashMap<Integer, InsurancePolicies> deepCopyList = new HashMap<Integer, InsurancePolicies>();
        for(InsurancePolicies policy:policies.values())
        {
            deepCopyList.put(policy.getID(), policy.clone());
        }
        return deepCopyList;
    }
    
    //Comparable based on expiryDate
    @Override
    public int compareTo(InsurancePolicies otherPolicy){
        return policyHolderName.compareTo(otherPolicy.policyHolderName);
        //return getExpiryDate().compareTo(otherPolicy.getExpiryDate());
    }
    
    //Serialization and Binary search File - LAB 6
    
    //Static method to Load file by using Serialization
    public static HashMap<Integer, InsurancePolicies> load(String fileName) throws IOException{
        HashMap<Integer, InsurancePolicies> loadHashMap = new HashMap<Integer, InsurancePolicies>();
        loadHashMap.clear();
        ObjectInputStream inputst = null;
        try
        {
            inputst = new ObjectInputStream(Files.newInputStream(Paths.get(fileName)));
        }
        catch(IOException ex)
        {
            System.err.println("Error in create/open the file");
            System.exit(1);
        }
        
        try
        {
            while(true)
            {
                InsurancePolicies policy = (InsurancePolicies) inputst.readObject();
                loadHashMap.put(policy.getID(), policy);
            }
        }
        catch(EOFException ex)
        {
            System.out.println("No more record!");
        }
        catch(ClassNotFoundException ex)
        {
            System.err.println("Error in wrong class in the file");
        }
        catch(IOException ex)
        {
            System.err.println("Error in add object to the file");
            System.exit(1);
        }
        
        try
        {
            if(inputst != null)
            {
                inputst.close();
            }
        }
        catch(IOException ex)
        {
            System.err.println("Error in close the file");
            System.exit(1);
        }
        return loadHashMap;
    }
    
    public static boolean save(HashMap<Integer, InsurancePolicies> listPolicies, String fileName) throws IOException{
        ObjectOutputStream outputst = null;
        
        try
        {
            outputst = new ObjectOutputStream(Files.newOutputStream(Paths.get(fileName)));
        }
        catch(IOException ex)
        {
            System.err.println("Error in create/open the file");
            System.exit(1);
            return false;
        }
        
        try
        {
            for(InsurancePolicies policy:listPolicies.values())
            {
                outputst.writeObject(policy);
            }
        }
        catch(IOException ex)
        {
            System.err.println("Error in adding the objects to the file");
            System.exit(1);
            return false;
        }
        
        try
        {
            if(outputst != null)
            outputst.close();
        }
        catch(IOException ex)
        {
            System.err.println("Error in closing the file");
            System.exit(1);
            return false;
        }
        
        return true;
    }
    
    //Delimited String - LAB 6
    public String toDelimitedString(){
        return policyHolderName + "," + id + "," + car.toDelimitedString() + "," + numberOfClaims + "," + expiryDate.toDelimitedString();
    }
    
    //public abstract String toDelimitedString();
    
    //Read HashMap Policies from a text file
    public static HashMap<Integer, InsurancePolicies> loadTextFile(String fileName) throws IOException, PolicyException, PolicyHolderNameException{
        HashMap<Integer, InsurancePolicies> loadHashMap = new HashMap<Integer, InsurancePolicies>();
        BufferedReader inp = new BufferedReader(new FileReader(fileName));
        String line = inp.readLine();
        while(line != null)
        {
            line = line.trim();
            String[] field = line.split(",");
            switch(field[0])
            {
                case "CP":
                    String policyHolderName = field[1];
                    int id = Integer.parseInt(field[2]);
                    String model = field[3];
                    CarType type = CarType.valueOf(field[4]);
                    int manufacturingYear = Integer.parseInt(field[5]);
                    double price = Double.parseDouble(field[6]);
                    int numberOfClaims = Integer.parseInt(field[7]);
                    int year = Integer.parseInt(field[8]);
                    int month = Integer.parseInt(field[9]);
                    int day = Integer.parseInt(field[10]);
                    String[] driverAge_level = field[11].split(";");
                    int driverAge = Integer.parseInt(driverAge_level[0]);
                    int level = Integer.parseInt(driverAge_level[1]);
                    
                    Car carCP = new Car(model, type, manufacturingYear, price);
                    MyDate expiryDateCP = new MyDate(year, month, day);
                    
                    ComprehensivePolicy cp = new ComprehensivePolicy(policyHolderName, id, carCP, numberOfClaims, expiryDateCP, driverAge, level);
                    loadHashMap.put(cp.getID(), cp);
                    break;
                case "TPP":
                    policyHolderName = field[1];
                    id = Integer.parseInt(field[2]);
                    model = field[3];
                    type = CarType.valueOf(field[4]);
                    manufacturingYear = Integer.parseInt(field[5]);
                    price = Double.parseDouble(field[6]);
                    numberOfClaims = Integer.parseInt(field[7]);
                    year = Integer.parseInt(field[8]);
                    month = Integer.parseInt(field[9]);
                    day = Integer.parseInt(field[10]);
                    String comment = field[11];
                    
                    Car carTPP = new Car(model, type, manufacturingYear, price);
                    MyDate expiryDateTPP = new MyDate(year, month, day);
                    
                    ThirdPartyPolicy tpp = new ThirdPartyPolicy(policyHolderName, id, carTPP, numberOfClaims, expiryDateTPP, comment);
                    loadHashMap.put(tpp.getID(), tpp);
                    break;
            }
            line = inp.readLine();
        }
        inp.close();
        return loadHashMap;
    }
    
    //Write HashMap Policies to a text file
    public static boolean saveTextFile(HashMap<Integer, InsurancePolicies> listPolicy, String fileName) throws IOException{
        BufferedWriter out = new BufferedWriter(new FileWriter(fileName));
        for(InsurancePolicies policy:listPolicy.values())
        {
            out.write(policy.toDelimitedString() + "\n");
        }
        out.close();
        return true;
    }
    
    //Filter policies with criteria (predicate) as an argument - Stream / Lambda - LAB8
    public static ArrayList<InsurancePolicies> filterPolicies(ArrayList<InsurancePolicies> policies, Predicate<InsurancePolicies> criteria){
        ArrayList<InsurancePolicies> listPolicy = new ArrayList<InsurancePolicies>();
        listPolicy = (ArrayList<InsurancePolicies>)policies.stream()
                             .filter(criteria).collect(Collectors.toList());
        return listPolicy;
    }
}
