package carinsurance;
import java.util.*;
import java.io.Serializable;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.*;

public class InsuranceCompany implements Cloneable, Serializable{
    private String name;
    //private ArrayList<User> users;
    private String adminUsername;
    private String adminPassword;
    private int flatRate;
    private HashMap<Integer, User> users_list;
    
    
    //Default constructor - LAB 6
    public InsuranceCompany(){
        
    }
    
    //Constructor for Insurance Company to create an object
    public InsuranceCompany(String name, String adminUsername, String adminPassword, int flatRate){
        this.name = name;
        this.adminUsername = adminUsername;
        this.adminPassword = adminPassword;
        this.flatRate = flatRate;
        this.users_list = new HashMap<Integer, User>();
        //this.users = new ArrayList<User>();
    }
    
    //Create Copy Constructor - WEEk 6 / LAB 4
    public InsuranceCompany(InsuranceCompany company){
        this.name = company.name;
        this.adminUsername = company.adminUsername;
        this.adminPassword = company.adminPassword;
        this.flatRate = company.flatRate;
        /*this.users = new ArrayList<User>();
        for(User user:users)
        {
            users.add(new User (user));
        }*/
        this.users_list = new HashMap<Integer, User>();
        for(User user:company.users_list.values())
        {
            this.users_list.put(user.getUserID(), user);
        }
    }
    
    //Check username and password of admin login
    public boolean validateAdmin(String username, String password){
        if(username.equals(adminUsername) && password.equals(adminPassword))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    //Check login admin
    public InsuranceCompany validateAdmin1(String username, String password){
        InsuranceCompany newComp = new InsuranceCompany(this.name, username, password, this.flatRate);
        if(validateAdmin(username, password))
        {
            return newComp;
        }
        return null;
    }
    
    //If user ID is unique, add this user to the list of company - ArrayList
    /*public boolean addUser(User user){
        for(User userInList:users)
        {
            if(userInList.getUserID() == user.getUserID()) //if the User ID is not unique
            {
                return false;
            }
        }
        users.add(user);
        return true;
    }*/
    
    //Add User - HashMap
    public boolean addUser(User user){
        for(int user_id:users_list.keySet())
        {
            if(user_id == user.getUserID())
            {
                return false;
            }
        }
        users_list.put(user.getUserID(), user);
        return true;
    }
    
    //Create a new user and add to the list if user ID is unique
    public boolean addUser(String name, int userID, Address address, String userName, String userPassword){
        User newUser = new User(name, userID, address, userName, userPassword);
        /*if(addUser(newUser))
        {
            return true;
        }
        else
            return false;*/
        return addUser(newUser);
    }
    
    //Find the user with user ID - ArrayList
    /*public User findUser(int userID){
        for(User user:users)
        {
            if(user.getUserID() == userID)
            {
                return user;
            }
        }
        return null;
    }*/
    
    //Find User - HashMap
    public User findUser(int userID){
        for(int user_id:users_list.keySet())
        {
            if(user_id == userID)
            {
                return users_list.get(user_id);
            }
        }
        return null;
    }
    
    //Find user with given ID and add policy to this user
    public boolean addPolicy(String adminUsername, String adminPassword, int userID, InsurancePolicies policy){
        if(adminUsername.equals(this.adminUsername) && adminPassword.equals(this.adminPassword))
        {
            //If user ID is exsit
            if(findUser(userID) != null)
            {
                User user = findUser(userID);
                //If policy is unique
                /*if(user.findPolicy(policy.getID()) == null)
                {
                    user.addPolicy(policy);
                    return true;
                }
                else
                    return false;*/
                return user.addPolicy(user.getUserNameLogin(), user.getUserPassword(), policy);
            }
            //If user ID is not exist
            else
                return false;
        }
        else
            return false;
    }
    
    //Find the policy for the given user ID
    public InsurancePolicies findPolicy(int userID, int policyID){
        //If the user ID is exist
        if(findUser(userID) != null)
        {
            User user = findUser(userID);
            //If the policy ID is exist in the user
            if(user.findPolicy(policyID) != null)
            {
                return user.findPolicy(policyID);
            }
            //If the policy ID is not exist in the user
            return null;
            //return user.findPolicy(policyID);
        }
        //If the user ID is not exist
        return null;
    }
    
    //Print the user informatoin and all the policies for the given user ID
    public void printPolicies(int userID){
        User user = findUser(userID);
        user.print();
    }
    
    //Display all users and all policies of each user by User.PrintPolicies(int flatRate) method - ArrayList
    /*public void print(){
        for(User user:users)
        {
            System.out.print(user.getUserInfo());
            user.printPolicies(flatRate);
            System.out.printf("The Total Payment of this User: %.2f\n\n", user.calcTotalPremiums1(flatRate));
            System.out.println();
        }
    }*/
    
    //Display all users and all policies of each user by User.PrintPolicies(int flatRate) method - HashMap
    public void print(){
       for(User user:users_list.values())
       {
           System.out.print(user.getUserInfo());
           user.printPolicies(flatRate);
           System.out.printf("The Total Payment of this User: %.2f\n\n", user.calcTotalPremiums1(user.getUserNameLogin(), user.getUserPassword(), flatRate));
           System.out.println();
       }
    }
    
    //Display all users and all policies for each user by converting to string - ArrayList
    /*public String toString(){
        String finalInfor = "";
        for(User user:users)
        {
            finalInfor += user.toString();
            //finalInfor += 
            finalInfor += "\n";
        }
        return finalInfor;
    }*/
    
    //Display all users and all policies for each user by converting to string - HashMap
    public String toString(){
        String finalInfor = "";
        for(User user:users_list.values())
        {
            finalInfor += user.toString();
            finalInfor += "\n";
        }
        return finalInfor;
    }
    
    //Find user with given ID and create third party policy for that user
    public boolean createThirdPartyPolicy(int userID, String policyHolderName, int id, Car car, int numberOfClaims, MyDate expiryDate, String comments) throws PolicyException, PolicyHolderNameException{
        if(findUser(userID) != null)
        {
           User user = findUser(userID);
           boolean create = user.createThirdPartyPolicy(user.getUserNameLogin(), user.getUserPassword(), policyHolderName, id, car, numberOfClaims, expiryDate, comments);
           /*if(create == true)
               return true;
           else
               return false;*/
           return create;
        }
        else
            return false;
    }
    
    //Find user with given ID and create comprehensive policy for that user
    public boolean createComprehensivePolicy(int userID, String policyHolderName, int id, Car car, int numberOfClaims, MyDate expiryDate, int driverAge, int level) throws PolicyException, PolicyHolderNameException{
        if(findUser(userID) != null)
        {
            User user = findUser(userID);
            boolean create = user.createComprehensivePolicy(user.getUserNameLogin(), user.getUserPassword(), policyHolderName, id, car, numberOfClaims, expiryDate, driverAge, level);
            /*if(create == true)
                return true;
            else
                return false;*/
            return create;
        }
        else
            return false;
    }
    
    //Display total premium payments for the given user
    public double calcTotalPayment(String adminUsername, String adminPassword, int userID){
        if(validateAdmin(adminUsername, adminPassword))
        {
            User user = findUser(userID);
            double totalPremiumPayment = user.calcTotalPremiums1(user.getUserNameLogin(), user.getUserPassword(), flatRate);
            return totalPremiumPayment;
        }
        else
            return -1.0;
    }
    
    //Display total premium payments for all users in the company - ArrayList
    /*public double calcTotalPayment(){
        double totalPremiumPaymentAllUsers = 0;
        for(User user:users)
        {
            totalPremiumPaymentAllUsers += calcTotalPayment(user.getUserID());
        }
        return totalPremiumPaymentAllUsers;
    }*/
    
    //Display total premium payments for all users in the company - HashMap
    /*public double calcTotalPayment(){
       double totalPremiumPaymentAllUsers = 0;
       for(User user:users_list.values())
       {
           totalPremiumPaymentAllUsers += calcTotalPayment(this.adminUsername, this.adminPassword, user.getUserID());
       }
       return totalPremiumPaymentAllUsers;
    }*/
    
    //Calculate total premium payments for all users in the company - HashMap - Stream / Lambda - LAB8
    public double calcTotalPayment(){
        return users_list.values().stream()
                .mapToDouble(x -> x.calcTotalPremiums1(x.getUserNameLogin(), x.getUserPassword(), flatRate))
                .sum();
    }
    
    //Rise price all car for the given user, return false if can't find the user
    public boolean carPriceRise(int userID, double risePercent){
        if(findUser(userID) != null)
        {
            User user = findUser(userID);
            user.carPriceRiseAll1(risePercent);
            return true;
        }
        else
        {
            return false;
        }
    }
    
    //Rise price all car for all users in the company - ArrayList
    /*public void carPriceRise(double risePercent){
        for(User user:users)
        {
            user.carPriceRiseAll1(risePercent);
        }
    }*/
    
    //Rise price all car for all users in the company - HashMap
    /*public void carPriceRise(double risePercent){
       for(User user:users_list.values())
       {
           user.carPriceRiseAll1(risePercent);
       }
    }*/
    
    //Rise price all car for all users in the company - Stream / Lambda - LAB8
    public void carPriceRise(double risePercent){
       users_list.values().forEach(x -> x.carPriceRiseAll1(risePercent));
    }
    
    //Print a list of all policies in the company across all users - ArrayList
    /*public ArrayList<InsurancePolicies> allPolicies(){
        ArrayList<InsurancePolicies> allPoliciesOfAllUsers = new ArrayList<InsurancePolicies>();
        for(User user:users)
        {
            ArrayList<InsurancePolicies> allPoliciesOfUser = user.allPolicies(); //Call this method to create list of all policies of each user
            //allPoliciesOfAllUsers.addAll(allPoliciesOfUser);//Use addAll
            //Use for loop to add
            for(InsurancePolicies policy:allPoliciesOfUser)
            {
                allPoliciesOfAllUsers.add(policy);
            }
        }
        return allPoliciesOfAllUsers;
    }*/
    
    //Return a list of all policies in the company across all users - HashMap
    public HashMap<Integer, InsurancePolicies> allPolicies(){
       HashMap<Integer, InsurancePolicies> allPoliciesOfAllUsers = new HashMap<Integer, InsurancePolicies>();
       for(User user:users_list.values())
       {
           HashMap<Integer, InsurancePolicies> allPoliciesOfUser = user.allPolicies();
           allPoliciesOfAllUsers.putAll(allPoliciesOfUser);
       }
       return allPoliciesOfAllUsers;
    }
    
    //Find the user and filter by car model for the given user - ArrayList
    /*public ArrayList<InsurancePolicies> filterByCarModel(int userID, String carModel){
        User user = findUser(userID);
        return user.filterByCarModel1(carModel);
    }*/
    
    //Filter By Car Model for Given User - HashMap
    public HashMap<Integer, InsurancePolicies> filterByCarModel(int userID, String carModel){
       User user = findUser(userID);
       return user.filterByCarModel(carModel);
    }
    
    //Find the user and filter by expiry date for the given user - ArrayList / Return ArrayList
    /*public ArrayList<InsurancePolicies> filterByExpiryDate(int userID, MyDate date){
        User user = findUser(userID);
        return user.filterByExpiryDate(date);
    }*/
        
    //Filter By Expiry Date for Given User - HashMap / Return HashMap
    public HashMap<Integer, InsurancePolicies> filterByExpiryDate(int userID, MyDate date){
        User user = findUser(userID);
        return user.filterByExpiryDate(date);
    }
    
    //Filter all policies in the company by car model for all users - ArrayList / Return ArrayList
    /*public ArrayList<InsurancePolicies> filterByCarModel(String carModel){
        ArrayList<InsurancePolicies> allUsers = new ArrayList<InsurancePolicies>();
        for(User user:users)
        {
            ArrayList<InsurancePolicies> oneUser = user.filterByCarModel1(carModel);
            //allUsers.addAll(oneUser);//Use addAll
            //Use for loop to add
            for(InsurancePolicies policy:oneUser)
            {
                allUsers.add(policy);
            }
        }
        return allUsers;
    }*/
    
    //Filter all policies in the company by car model for all users - HashMap
    public HashMap<Integer, InsurancePolicies> filterByCarModel1(String carModel){
       HashMap<Integer, InsurancePolicies> allUsers = new HashMap<Integer, InsurancePolicies>();
       for(User user:users_list.values())
       {
           HashMap<Integer, InsurancePolicies> oneUser = user.filterByCarModel(carModel);
           allUsers.putAll(oneUser);
       }
       return allUsers;
    }
    
    //Filter all policies in the company by car model for all users - Stream / Lambda - LAB8
    public ArrayList<InsurancePolicies> filterByCarModel(String carModel){
        return (ArrayList<InsurancePolicies>)(users_list.values().stream()
                .map(x -> x.filterByCarModel1(carModel)));
    }
    
    //Filter all policies in the company by expiry date for all users - ArrayList
    /*public ArrayList<InsurancePolicies> filterByExpiryDate(MyDate date){
        ArrayList<InsurancePolicies> allUsers = new ArrayList<InsurancePolicies>();
        for(User user:users)
        {
            ArrayList<InsurancePolicies> oneUser = user.filterByExpiryDate(date);
            //allUsers.addAll(oneUser);//Use addAll
            for(InsurancePolicies policy:oneUser)
            {
                allUsers.add(policy);
            }
        }
        return allUsers;
    }*/
    
    //Filter all policies in the company by expiry date for all users - Hash Map
    public HashMap<Integer, InsurancePolicies> filterByExpiryDate(MyDate date){
        HashMap<Integer, InsurancePolicies> allUsers = new HashMap<Integer, InsurancePolicies>();
        for(User user:users_list.values())
        {
            HashMap<Integer, InsurancePolicies> oneUser = user.filterByExpiryDate(date);
            allUsers.putAll(oneUser);
        }
        return allUsers;
    }
    
    //WEEK 4 ADDED - ASSIGNMENT 1 - STANDARD LEVEL
    //Goes through all the users and populate a list of distinct city names for all users and returns it as a list - ArrayList
    /*public ArrayList<String> populateDistinctCityNames(){
        ArrayList<String> cityNames = new ArrayList<String>();
        for(User user:users)
        {
            Address userAddress = user.getAddress();
            boolean checkExist = false;
            for(String city:cityNames)
            {
                if(city.equals(userAddress.getCity()))
                {
                    checkExist = true;
                    break;
                }
            }
            if(checkExist == false)
            {
                cityNames.add(userAddress.getCity());
            }
        }
        return cityNames;
    }*/
    
    //Goes through all the users and populate a list of distinct city names for all users and returns it as a list - HashMap
    public ArrayList<String> populateDistinctCityNames(){
        ArrayList<String> cityNames = new ArrayList<String>();
        for(User user:users_list.values())
        {
            Address userAddress = user.getAddress();
            boolean checkExist = false;
            for(String city:cityNames)
            {
                if(city.equals(userAddress.getCity()))
                {
                    checkExist = true;
                    break;
                }
            }
            if(checkExist == false)
            {
                cityNames.add(userAddress.getCity());
            }
        }
        return cityNames;
    }
    
    //Returns the total premium payment for the given city across all users - ArrayList
    /*public double getTotalPaymentForCity(String city){
        double totalPaymentForCity = 0.0;
        for(User user:users)
        {
            Address userAddress = user.getAddress();
            if(city.equals(userAddress.getCity()))
            {
                totalPaymentForCity += user.calcTotalPremiums1(flatRate);
            }
        }
        return totalPaymentForCity;
    }*/
    
    //Returns the total premium payment for the given city across all users - HashMap
    public double getTotalPaymentForCity(String city){
        double totalPaymentForCity = 0.0;
        for(User user:users_list.values())
        {
            Address userAddress = user.getAddress();
            if(city.equals(userAddress.getCity()))
            {
                totalPaymentForCity += user.calcTotalPremiums1(user.getUserNameLogin(), user.getUserPassword(), flatRate);
            }
        }
        return totalPaymentForCity;
    }
    
    //Aggregates the total premium payments for each city in the list and returns it as a double list with the same order as city names.
    //This method calls getTotalPaymentForCity (String city)
    public ArrayList<Double> getTotalPaymentPerCity(ArrayList<String> cities){
        ArrayList<Double> totalPaymentPerCity = new ArrayList<Double>();
        for(String city:cities)
        {
            totalPaymentPerCity.add(getTotalPaymentForCity(city));
        }
        return totalPaymentPerCity;
    }
    
    //Generates the report
    public void reportPaymentPerCity(ArrayList<String> cities, ArrayList<Double> payments){
        System.out.printf("%-10s \t \t %25s\n", "City Name", "Total Premium Payments");
        for(int i = 0; i < cities.size(); i++)
        {
            //System.out.println(cities.get(i) + " \t \t " + payments.get(i));
            System.out.printf("%-10s \t \t %.2f\n", cities.get(i), payments.get(i));
        }
    }
    
    //ADVANCED LEVEL - ASSIGNMENT 1
    //Goes through all the users within the InsuranceCompany and populates a list of distinct car models - ArrayList
    /*public ArrayList<String> populateDistinctCarModel(){
       ArrayList<String> firstList = new ArrayList<String>();
       ArrayList<String> distinctList = new ArrayList<String>();
       for(User user:users)
       {
           firstList.addAll(user.populateDistinctCarModels());
       }
       for(String carModel:firstList)
       {
           if(!distinctList.contains(carModel))
           {
               distinctList.add(carModel);
           }
       }
       return distinctList;
    }*/
    
    //Goes through all the users within the InsuranceCompany and populates a list of distinct car models - HashMap
    public ArrayList<String> populateDistinctCarModel(){
       ArrayList<String> firstList = new ArrayList<String>();
       ArrayList<String> distinctList = new ArrayList<String>();
       for(User user:users_list.values())
       {
           firstList.addAll(user.populateDistinctCarModels());
       }
       for(String carModel:firstList)
       {
           if(!distinctList.contains(carModel))
           {
               distinctList.add(carModel);
           }
       }
       return distinctList;
    }
    
    //Returns the count for each model across all the users - ArrayList
    /*public ArrayList<Integer> getTotalCountPerCarModel(ArrayList<String> carModels){
        ArrayList<Integer> countList = new ArrayList<Integer>();
        for(String carModel:carModels)
        {
            int totalPerCarModel = 0;
            for(User user:users)
            {
                totalPerCarModel += user.getTotalCountForCarModel(carModel);
            }
            countList.add(totalPerCarModel);
        }
        return countList;
    }*/
    
    //Returns the count for each model across all the users - HashMap
    public ArrayList<Integer> getTotalCountPerCarModel(ArrayList<String> carModels){
        ArrayList<Integer> countList = new ArrayList<Integer>();
        for(String carModel:carModels)
        {
            int totalPerCarModel = 0;
            for(User user:users_list.values())
            {
                totalPerCarModel += user.getTotalCountForCarModel(carModel);
            }
            countList.add(totalPerCarModel);
        }
        return countList;
    }
    
    //Returns total payment for each model across all the users - ArrayList
    /*public ArrayList<Double> getTotalPaymentPerCarModel(ArrayList<String> carModels, int flatRate){
        ArrayList<Double> totalList = new ArrayList<Double>();
        for(String carModel:carModels)
        {
            double totalPaymentPerCarModel = 0.0;
            for(User user:users)
            {
                totalPaymentPerCarModel += user.getTotalPaymentForCarModel(carModel, flatRate);
            }
            totalList.add(totalPaymentPerCarModel);
        }
        return totalList;
    }*/
    
    //Returns total payment for each model across all the users - HashMap
    public ArrayList<Double> getTotalPaymentPerCarModel(ArrayList<String> carModels, int flatRate){
        ArrayList<Double> totalList = new ArrayList<Double>();
        for(String carModel:carModels)
        {
            double totalPaymentPerCarModel = 0.0;
            for(User user:users_list.values())
            {
                totalPaymentPerCarModel += user.getTotalPaymentForCarModel(carModel, flatRate);
            }
            totalList.add(totalPaymentPerCarModel);
        }
        return totalList;
    }
    
    //Generate the same report across all users
    public void reportPaymentPerCarModel(ArrayList<String> carModels, ArrayList<Integer> counts, ArrayList<Double> premiumPayments){
        System.out.printf("%-15s \t \t %25s \t \t %25s \n", "Car Model", "Total Premium Payment", "Average Premium Payment");
        for(int i = 0; i < carModels.size(); i++)
        {
            //System.out.println(carModels.get(i) + " \t \t \t \t " + premiumPayments.get(i) + " \t \t \t \t " + premiumPayments.get(i) / (double)counts.get(i));
             System.out.printf("%-15s \t \t \t \t %.2f \t \t \t \t %.2f\n", carModels.get(i), premiumPayments.get(i), premiumPayments.get(i) / (double)counts.get(i));
        }
    }
    
    //Admin remove policy from a policy
    public boolean removePolicy(int userID, int policyID){
        User userRemovePol = findUser(userID);
        return userRemovePol.removePolicy(policyID);
    }
    
    //Admin remove user by user ID - ArrayList
    /*public boolean removeUser(int userID){
        boolean checkExist = false;
        for(User user:users)
        {
            if(user.getUserID() == userID)
            {
                checkExist = true;
            }
        }
        if(checkExist)
        {
            users.remove(findUser(userID));
            return true;
        }
        else
            return false;
    }*/
    
    //Admin remove user by user ID - HashMap
    public boolean removeUser(int userID){
        ArrayList<User> users = new ArrayList<User>();
        users = User.shallowCopy(users_list);
        boolean checkExist = false;
        for(User user:users)
        {
            if(user.getUserID() == userID)
            {
                checkExist = true;
            }
        }
        if(checkExist)
        {
            users.remove(findUser(userID));
            return true;
        }
        else
            return false;
    }
    
    //Admin change password
    public void setPasswordd(String newPassword){
        this.adminPassword = newPassword;
    }
    
    //Check password before change
    public boolean checkPassword(String oldPassword){
        if(oldPassword.equals(adminPassword))
            return true;
        else
            return false;
    }
    
    //Set admin password
    public void setPassword(String newPassword){
        adminPassword = newPassword;
    }
    
    //Get admin password
    public String getPassword(){
        return adminPassword;
    }
    
    //Get admin name
    public String getName(){
        return adminUsername;
    }
    
    //WEEK 6 - LAB 4
    //Cloneable Interface - ArrayList
    /*@Override
    public InsuranceCompany clone() throws CloneNotSupportedException{
        InsuranceCompany output = (InsuranceCompany)super.clone();
        output.users = new ArrayList<>();
        for(User user:users)
        {
            output.users.add(user.clone());
        }
        return output;
        //return (InsuranceCompany)super.clone();
    }*/
    
    //Cloneable Interface - HashMap
    @Override
    public InsuranceCompany clone() throws CloneNotSupportedException{
       InsuranceCompany output = (InsuranceCompany)super.clone();
       output.users_list = new HashMap<>();
       for(User user:users_list.values())
       {
           output.users_list.put(user.getUserID(), user.clone());
       }
       return output; 
    }
    
    //Deep copy ArrayList of Users - ArrayList / Return ArrayList
    /*public ArrayList<User> deepCopyUser() throws CloneNotSupportedException{
        ArrayList<User> deepCopyList = new ArrayList<User>();
        for(User user:users)
        {
            deepCopyList.add(user.clone());
        }
        return deepCopyList;
    }*/
    
    //Deep Copy - HashMap / Return ArrayList
    public ArrayList<User> deepCopyUser() throws CloneNotSupportedException{
       ArrayList<User> deepCopyList = new ArrayList<User>();
       for(User user:users_list.values())
       {
           deepCopyList.add(user.clone());
       }
       return deepCopyList;
    }
    
    //Deep Copy - HashMap / Return HashMap
    public HashMap<Integer, User> deepCopyUserHashMap() throws CloneNotSupportedException{
        HashMap<Integer, User> deepCopyList = new HashMap<Integer, User>();
        for(User user:users_list.values())
        {
            deepCopyList.put(user.getUserID(), user.clone());
        }
        return deepCopyList;
    }
    
    //Shallow copy ArrayList of Users - ArrayList / Return ArrayList
    /*public ArrayList<User> shallowCopyUser(){
        ArrayList<User> shallowCopyList = new ArrayList<User>();
        for(User user:users)
        {
            shallowCopyList.add(user);
        }
        return shallowCopyList;
    }*/
    
    //Shallow Copy - HashMap / Return ArrayList
    public ArrayList<User> shallowCopyUser(){
        ArrayList<User> shallowCopyList = new ArrayList<User>();
        for(User user:users_list.values())
        {
            shallowCopyList.add(user);
        }
        return shallowCopyList;
    }
    
    //Shallow Copy - HashMap / Return HashMap
    public HashMap<Integer, User> shallowCopyUserHashMap(){
        HashMap<Integer, User> shallowCopyList = new HashMap<Integer, User>();
        for(User user:users_list.values())
        {
            shallowCopyList.put(user.getUserID(), user);
        }
        return shallowCopyList;
    }
    
    //Sort user by compareTo() - city and totel premium payment (change in Comparable Interface in User class) - ArrayList
    /*public ArrayList<User> sortUsers(){
        ArrayList<User> listUser = new ArrayList<User>();
        for(User user:users)
        {
            listUser.add(user);
        }
        Collections.sort(listUser);
        return listUser;
    }*/
    
    //Sort User by City or Total Payment - HashMap
    public ArrayList<User> sortUsers(){
       ArrayList<User> listUser = new ArrayList<User>();
       listUser = User.shallowCopy(users_list); //Make shallow copy of User
       Collections.sort(listUser);
       return listUser;
    }
    
    //Print User list
    public void printUser(ArrayList<User> userList){
        for(User user:userList)
        {
            System.out.print(user.getUserInfo());
            user.printPolicies(flatRate);
            System.out.printf("The Total Payment of this User: %.2f\n\n", user.calcTotalPremiums1(user.getUserNameLogin(), user.getUserPassword(), flatRate));
            System.out.println();
        }
    }
    
    //Aggregates the total premium payments for users from any given city within the company
    public HashMap<String, Double> getTotalPremiumPerCity(){
        HashMap<String, Double> totalByCity = new HashMap<String, Double>();
        ArrayList<String> cityList = new ArrayList<String>();
        for(User user:users_list.values())
        {
            String city = user.getAddress().getCity();
            if(!cityList.contains(city))
            {
                cityList.add(city);
            }
        }
        for(String city:cityList)
        {
            double totalPayment = getTotalPaymentForCity(city);
            totalByCity.put(city, totalPayment);
        }
        return totalByCity;
    }
    
    //Aggreagates the total premium payments for users from any given city within the company - Stream / Lambda - LAB8
    public HashMap<String, Double> getTotalPremiumPerCityNew(){
        ArrayList<String> cityList = new ArrayList<String>();
        
        cityList = (ArrayList<String>)(users_list.values()
                                    .stream()
                                    .map((x -> x.getAddress().getCity()))
                                    .distinct()
                                    .collect(Collectors.toList()));
        
        HashMap<String, Double> totalByCity = new HashMap<>();
        cityList.forEach((x) -> {totalByCity.put(x, getTotalPaymentForCity(x));});
        return totalByCity;
    }
    
    //Returns a list of pairs of (Car Model, Count) as a HashMap across all the users within the company
    public HashMap<String, Integer> getTotalPerCarModel(){
        HashMap<String, Integer> totalPerCarModel = new HashMap<String, Integer>();
        for(User user:users_list.values())
        {
            //totalPerCarModel.putAll(user.getTotalCountPerCarModel());
            HashMap<String, Integer> carModel = user.getTotalCountPerCarModel();
            for(String model:carModel.keySet())
            {
                if(totalPerCarModel.containsKey(model))
                {
                    //Increase value of Model key if this Model key is exist
                    int temp1 = totalPerCarModel.get(model);
                    int temp2 = carModel.get(model);
                    temp1 += temp2;
                    //Change the value of Model key by put function
                    totalPerCarModel.put(model, temp1);
                }
                else
                {
                    //If the Model key is not exist, create new
                    totalPerCarModel.put(model, carModel.get(model));
                }
            }
        }
        return totalPerCarModel;
    }
    
    //Get total for given car model
    public int getTotalCountForGivenCarModel(String carModel){
        int count = 0;
        ArrayList<InsurancePolicies> listPolicies = new ArrayList<>();
        for(User user:users_list.values())
        {
            listPolicies.addAll(user.getPolicies1());
        }
        for(InsurancePolicies policy:listPolicies)
        {
            String carModel1 = policy.getCar().getModel();
            if(carModel1.equals(carModel))
            {
                count++;
            }
        }
        return count;
    }
    
    //Get total payment for given car model
    public double getTotalPaymentForGivenCarModel(String carModel){
        double totalPayment = 0;
        ArrayList<InsurancePolicies> listPolicies = new ArrayList<>();
        for(User user:users_list.values())
        {
            listPolicies.addAll(user.getPolicies1());
        }
        for(InsurancePolicies policy:listPolicies)
        {
            String carModel1 = policy.getCar().getModel();
            if(carModel1.equals(carModel))
            {
                totalPayment += policy.calcPayment(flatRate);
            }
        }
        return totalPayment;
    }
    
    //Aggregate a list of pairs of (Car Model, Count) as a HashMap across all the users within the company - Stream / Lambda - A3
    public HashMap<String, Integer> getTotalPerCarModelNew(){
        HashMap<String, Integer> totalPerCarModel = new HashMap<String, Integer>();
        ArrayList<String> listCarModel = new ArrayList<>();
        ArrayList<InsurancePolicies> listPolicies = new ArrayList<>();
        //Get all policies of all users
        users_list.values().forEach((x) -> listPolicies.addAll(x.getPolicies1()));
        //Get all distinct policies of all users
        listCarModel = (ArrayList<String>)listPolicies.stream()
                                   .map(x -> x.getCar().getModel())
                                   .distinct()
                                   .collect(Collectors.toList());
        listCarModel.forEach((x) -> {totalPerCarModel.put(x, getTotalCountForGivenCarModel(x));});
        return totalPerCarModel;
    }
    
    //Returns a list of pairs of (Car Model, Total Premium Payments)  as a HashMap across all the users within the company
    public HashMap<String, Double> getTotalPremiumPerCarModel(){
        HashMap<String, Double> totalPremiumPerCarModel = new HashMap<String, Double>();
        for(User user:users_list.values())
        {
            //totalPremiumPerCarModel.putAll(user.getTotalPremiumPerCarModel(flatRate));
            HashMap<String, Double> carPayment = user.getTotalPremiumPerCarModel(flatRate);
            for(String model:carPayment.keySet())
            {
                if(totalPremiumPerCarModel.containsKey(model))
                {
                    //Increase value of Model key if this Model key is exist
                    double temp1 = totalPremiumPerCarModel.get(model);
                    double temp2 = carPayment.get(model);
                    temp1 += temp2;
                    //Change the value of Model key by put function
                    totalPremiumPerCarModel.put(model, temp1);
                }
                else
                {
                    //If the Model key is not exist, create new
                    totalPremiumPerCarModel.put(model, carPayment.get(model));
                }
            }
        }
        return totalPremiumPerCarModel;
    }
    
    //Aggregate a list of pairs of (Car Model, Total Premium Paymenst) as a HashMap across al the users within the company - Stream . Lambda - A3
    public HashMap<String, Double> getTotalPremiumPerCarModelNew(){
        HashMap<String, Double> totalPaymentPerCarModel = new HashMap<String, Double>();
        ArrayList<String> listCarModel = new ArrayList<>();
        ArrayList<InsurancePolicies> listPolicies = new ArrayList<>();
        //Get all policies of all users
        users_list.values().forEach((x) -> listPolicies.addAll(x.getPolicies1()));
        //Get all distinct policies of all users
        listCarModel = (ArrayList<String>)listPolicies.stream()
                                   .map(x -> x.getCar().getModel())
                                   .distinct()
                                   .collect(Collectors.toList());
        listCarModel.forEach((x) -> {totalPaymentPerCarModel.put(x, getTotalPaymentForGivenCarModel(x));});
        return totalPaymentPerCarModel;
    }
    
    //Report By City - HashMap
    public void reportByCity(HashMap<String, Double> cityList){
        //System.out.println("City Name \t \t Total Premium Payments");
        System.out.printf("%-10s \t \t %25s\n", "City Name", "Total Premium Payments");
        for(String city:cityList.keySet())
        {
            //System.out.println(city + " \t \t " + cityList.get(city));
            System.out.printf("%-10s \t \t %.2f\n", city, cityList.get(city));
        }
    }
    
    //Report by Car Model - HashMap
    public void reportByCarModel(HashMap<String, Integer> countCarModel, HashMap<String, Double> totalPaymentCarModel){
       System.out.printf("%-15s \t \t %25s \t \t %25s \n", "Car Model", "Total Premium Payment", "Average Premium Payment");
        for(String city:countCarModel.keySet())
        {
            System.out.printf("%-15s \t \t \t \t %.2f \t \t \t \t %.2f\n", city, totalPaymentCarModel.get(city), (double) totalPaymentCarModel.get(city)/countCarModel.get(city));
        }
    }
    
    //Serialization - LAB 6
    //Add a default constructor (a constructor with no parameter to create an empty object) to your insuranceCompany.
    //In your test code create an empty InsuranceCompany object
    //with default constructor and then call object.load to fill the information from file to the object 
    public boolean load(String fileName) throws IOException{
        ObjectInputStream inputst = null;
        
        try
        {
            inputst = new ObjectInputStream(Files.newInputStream(Paths.get(fileName)));
        }
        catch(IOException ex)
        {
            System.err.println("Error in create / open file");
            System.exit(1);
            //return false;
        }
        
        try
        {
            InsuranceCompany company = (InsuranceCompany)inputst.readObject();    
        }
        catch(EOFException ex)
        {
            System.out.println("No more record");
        }
        catch(ClassNotFoundException ex)
        {
            System.err.println("Error in wrong class in the file");
        }
        catch(IOException ex)
        {
            System.err.println("Error in add object to the file");
            System.exit(1);
            //return false;
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
        return true;
    }
    
    //Save the InsurancePolicy object (this) into the file
    public boolean save(String fileName) throws IOException{
        ObjectOutputStream outputst = null;
        
        try
        {
            outputst = new ObjectOutputStream(Files.newOutputStream(Paths.get(fileName)));
        }
        catch(IOException ex)
        {
            System.err.println("Error in create / open the file");
            System.exit(1);
            return false;
        }
        
        try
        {
            outputst.writeObject(this);
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
    //Get Count Users
    public int countUsers(){
        return users_list.size();
    }
    
    //Get Users list Hash Map
    public HashMap<Integer, User> getUsersList(){
        return users_list;
    }
    
    //Delimited String
    public String toDelimitedString(){
        String companyInfo = "";
        companyInfo += name + "," + adminUsername + "," + adminPassword + "," + flatRate;
        for(User user:users_list.values())
        {
            companyInfo += "," + user.toDelimitedString2() + ",";
        }
        return companyInfo;
    }
    
    //Add Users
    public void addUsers(User user){
        users_list.put(user.getUserID(), user);
    }
    
    //Read Insurance Company from text file by using toDelimitedString
    public boolean loadTextFile(String fileName) throws IOException, PolicyException, PolicyHolderNameException{
        BufferedReader inp = new BufferedReader(new FileReader(fileName));
        String line = inp.readLine();
        while(line != null)
        {
            line = line.trim();
            String[] field = line.split(",");
            String name = field[0];
            String adminUser = field[1];
            String adminPassword = field[2];
            int flatRate = Integer.parseInt(field[3]);
            InsuranceCompany company = new InsuranceCompany(name, adminUser, adminPassword, flatRate);
            int numberOfUsers = Integer.parseInt(field[4]);
            for(int i = 0; i < numberOfUsers; i++)
            {
                String userName = field[5 + i*7];
                int userID = Integer.parseInt(field[6] + i*7);
                int streetNum = Integer.parseInt(field[7] + i*7);
                String street = field[8 + i*7];
                String suburb = field[9 + i*7];
                String city = field[10 + i*7];
                String userNameLog = field[11 + i*7];
                String userPassword = field[12 + i*7];
                Address address = new Address(streetNum, street, suburb, city);
                User user = new User(userName, userID, address, userNameLog, userPassword);
                company.addUser(user);
                int numberOfPolicies = user.getPoliciesCount();
                
            }
            int startPolicies = 12 + (numberOfUsers - 1)*7 + 1;
            int numberOfPolicies = Integer.parseInt(field[startPolicies]);
            int nextPos = startPolicies + 1;
            for(int i = 0; i < numberOfPolicies; i++)
            {
                switch(field[nextPos + i*12])
                {
                    case "CP":
                        String policyHolderName = field[nextPos + 1 + i*12];
                        int id = Integer.parseInt(field[nextPos + 2 + i*12]);
                        String model = field[nextPos + 3 + i*12];
                        CarType type = CarType.valueOf(field[nextPos + 4 + i*12]);
                        int manufacturingYear = Integer.parseInt(field[nextPos + 5 + i*12]);
                        double price = Double.parseDouble(field[nextPos + 6 + i*12]);
                        int numberOfClaims = Integer.parseInt(field[nextPos + 7 + i*12]);
                        int year = Integer.parseInt(field[nextPos + 8 + i*12]);
                        int month = Integer.parseInt(field[nextPos + 9 + i*12]);
                        int day = Integer.parseInt(field[nextPos + 10 + i*12]);
                        String[] driverAge_level = field[nextPos + 11 + i*12].split(";");
                        int driverAge = Integer.parseInt(driverAge_level[0]);
                        int level = Integer.parseInt(driverAge_level[1]);
                        
                        Car carCP = new Car(model, type, manufacturingYear, price);
                        MyDate expiryDateCP = new MyDate(year, month, day);
                        
                        ComprehensivePolicy cp = new ComprehensivePolicy(policyHolderName, id, carCP, numberOfClaims, expiryDateCP, driverAge, level);
                        
                        break;
                    case "TPP":
                        policyHolderName = field[nextPos + 1 + i*12];
                        id = Integer.parseInt(field[nextPos + 2 + i*12]);
                        model = field[nextPos + 3 + i*12];
                        type = CarType.valueOf(field[nextPos + 4 + i*12]);
                        manufacturingYear = Integer.parseInt(field[nextPos + 5 + i*12]);
                        price = Double.parseDouble(field[nextPos + 6 + i*12]);
                        numberOfClaims = Integer.parseInt(field[nextPos + 7 + i*12]);
                        year = Integer.parseInt(field[nextPos + 8 + i*12]);
                        month = Integer.parseInt(field[nextPos + 9 + i*12]);
                        day = Integer.parseInt(field[nextPos + 10 + i*12]);
                        String comment = field[nextPos + 11 + i*12];
                        
                        Car carTPP = new Car(model, type, manufacturingYear, price);
                        MyDate expiryDateTPP = new MyDate(year, month, day);
                        
                        ThirdPartyPolicy tpp = new ThirdPartyPolicy(policyHolderName, id, carTPP, numberOfClaims, expiryDateTPP, comment);
                        break;
                }
            }
            line = inp.readLine();
        }
        inp.close();
        return true;
    }
    
    //Write Insurance Company to text file by using toDelimitedString
    public boolean saveTextFile(String fileName) throws IOException{
        BufferedWriter out = new BufferedWriter(new FileWriter(fileName));
        out.write(this.toDelimitedString());
        out.close();
        return true;
    }
    
    //ASSIGNMENT 2 - WEEK 9
    //Use new Comparator to sort all users by premium
    public ArrayList<User> sortUserByPremium(){
        ArrayList<User> listUser = new ArrayList<User>();
        listUser = User.shallowCopy(users_list);
        Collections.sort(listUser, new User());
        return listUser;
    }
    
    //Returns a hashmap with the city name as key and a list of all users from that city as value
    public HashMap<String, ArrayList<User>> getUsersPerCity(){
        HashMap<String, ArrayList<User>> usersPerCity = new HashMap<String, ArrayList<User>>();
        ArrayList<String> listCity = new ArrayList<String>();
        for(User user:users_list.values())
        {
            String city = user.getAddress().getCity();
            if(!listCity.contains(city))
            {
                listCity.add(city);
            }
        }
        
        for(String city : listCity)
        {
            //Create new ArrayList that contains User of each City
            usersPerCity.put(city, new ArrayList<User>());
            for(User user:users_list.values())
            {
                String userCity = user.getAddress().getCity();
                if(city.equals(userCity))
                {
                    //listUserPerCity.add(user);
                    usersPerCity.get(city).add(user);
                }
            }
        }
        return usersPerCity;
    }
    
    //Returns a HashMap of user full name as key, and for each name all the policies owned by user and expired by given date
    public HashMap<String, ArrayList<InsurancePolicies>> filterPoliciesByExpiryDate(MyDate expiryDate){
        HashMap<String, ArrayList<InsurancePolicies>> usersAndDate = new HashMap<String, ArrayList<InsurancePolicies>>();
        for(User user:users_list.values())
        {
            String userName = user.getUserNameLogin();
            usersAndDate.put(userName, new ArrayList<InsurancePolicies>());
            HashMap<Integer, InsurancePolicies> listPolicies = user.getPolicies();
            for(InsurancePolicies policy:listPolicies.values())
            {
                MyDate policyExpiredDate = policy.getExpiryDate();
                if(policyExpiredDate.isExpired(expiryDate))
                {
                    usersAndDate.get(userName).add(policy);
                }
            }
        }
        return usersAndDate;
    }
    
    //Gets a range array as input, returns number of policies in the company per range
    public int[] policyCount(String adminUsername, String adminPassword, int[] ranges){
        int[] count = new int[ranges.length];
        if(validateAdmin(adminUsername, adminPassword))
        {
            for(int i = 0; i < ranges.length; i++)
            {
                for(User user:users_list.values())
                {
                    int[] count_user = user.policyCount(user.getUserNameLogin(), user.getUserPassword(), ranges);
                    count[i] += count_user[i];
                }
            }
            return count;
        }
        else
        {
            return count;
        }
    }
    
    //Gets a range array as input, returns number of policies in the company per range - Stream / Lambda - A3
    public int[] policyCountNew(String adminUsername, String adminPassword, int[] ranges){
        int[] count = new int[ranges.length];
        if(validateAdmin(adminUsername, adminPassword))
        {
            Integer[] count_user = (Integer[])users_list.values()
                                         .stream()
                                         .map(x -> x.policyCount(x.getUserNameLogin(), x.getUserPassword(), ranges))
                                         .toArray();
            for(int i = 0; i < ranges.length; i++)
            {
                count[i] += count_user[i];
            }
            
            return count;
        }
        else
        {
            return count;
        }
    }
    
    //Gets a range array as input, returns number of policies per range per city
    public HashMap<String, Integer[]> policyCityCount(String adminUsername, String adminPassword, int[] ranges){
        HashMap<String, Integer[]> count = new HashMap<String, Integer[]>();
        if(validateAdmin(adminUsername, adminPassword))
        {
            ArrayList<String> cityList = new ArrayList<String>();
            //Find diffirent city in Company
            for(User user:users_list.values())
            {
                String cityUser = user.getAddress().getCity();
                if(!cityList.contains(cityUser))
                {
                    cityList.add(cityUser);
                }
            }
            
            //For each city
            for(String city:cityList)
            {
                int[] count_pol = new int[ranges.length];
                for(int i = 0; i < ranges.length; i++)
                {
                    for(User user:users_list.values())
                    {
                        String cityUser = user.getAddress().getCity();
                        if(cityUser.equals(city))
                        {
                            int[] count_user = user.policyCount(user.getUserNameLogin(), user.getUserPassword(), ranges);
                            count_pol[i] += (count_user[i]);
                        }
                    }
                }
                
                //Adjust int[] to Integer[]
                Integer[] count_final = new Integer[ranges.length];
                for(int i = 0; i < ranges.length; i++)
                {
                    count_final[i] = Integer.valueOf(count_pol[i]);
                }
                count.put(city, count_final);
            }
            return count;
        }
        else
        {
            return count;
        }
    }
    
    //Gets a range array as input, returns the number of users in company per range
    public int[] userCount(String adminUsername, String adminPassword, int[] ranges){
        int[] count = new int[ranges.length];
        if(validateAdmin(adminUsername, adminPassword))
        {
            for(int  i = 0; i < ranges.length; i++)
            {
                for(User user:users_list.values())
                {
                    int[] count_user = user.policyCount(user.getUserNameLogin(), user.getUserPassword(), ranges);
                    if(count_user[i] != 0)
                    {
                        count[i]++;
                    }
                }
            }
            return count;
        }
        else
        {
            return count;
        }
    }
    
    //Gets a range array as input and returns the number of users in the company per range per car model
    public HashMap<String, Integer[]> userCarModelCount(String adminUsername, String adminPassword, int[] ranges){
        HashMap<String, Integer[]> count = new HashMap<String, Integer[]>();
        if(validateAdmin(adminUsername, adminPassword))
        {
            ArrayList<String> carModelList = new ArrayList<String>();
            for(User user:users_list.values())
            {
                HashMap<Integer, InsurancePolicies> polList = user.getPolicies();
                for(InsurancePolicies pol:polList.values())
                {
                    String carModel = pol.getCar().getModel();
                    if(!carModelList.contains(carModel))
                    {
                        carModelList.add(carModel);
                    }
                }
            }
            for(String carModel:carModelList)
            {
                int[] count_user_carModel = new int[ranges.length];
                for(User user:users_list.values())
                {
                    boolean check = false;
                    HashMap<Integer, InsurancePolicies> polList = user.getPolicies();
                    for(InsurancePolicies pol:polList.values())
                    {
                        if(carModel.equals(pol.getCar().getModel()) && pol.calcPayment(5) <= ranges[0])
                        {
                            check = true;
                        }
                    }
                    if(check == true)
                    {
                        count_user_carModel[0]++;
                    }
                }
                for(int i = 1; i < ranges.length; i++)
                {
                    for(User user:users_list.values())
                    {
                        boolean check = false;
                        HashMap<Integer, InsurancePolicies> polList = user.getPolicies();
                        //int[] count_user_pol = user.policyCount(user.getUserName(), user.getUserPassword(), ranges);
                        for(InsurancePolicies pol:polList.values())
                        {
                            if(carModel.equals(pol.getCar().getModel()) && pol.calcPayment(5) > ranges[i-1] && pol.calcPayment(5) <= ranges[i])
                            {
                                check = true;
                            }
                        }
                        if(check == true)
                        {
                            count_user_carModel[i]++;
                        }
                    }
                }
                //Convert int[] to Integer[]
                Integer[] count_final = new Integer[ranges.length];
                for(int i = 0; i < ranges.length; i++)
                {
                    count_final[i] = Integer.valueOf(count_user_carModel[i]);
                }
                count.put(carModel, count_final);
            }
            return count;
        }
        else
        {
            return count;
        }
    }
    
    //Gets a range array as input, returns number of policies in the company per range per car model
    public HashMap<String, Integer[]> policyCarModelCount(String adminUsername, String adminPassword, int[] ranges){
        HashMap<String, Integer[]> count = new HashMap<String, Integer[]>();
        if(validateAdmin(adminUsername, adminPassword))
        {
            ArrayList<String> carModelList = new ArrayList<String>();
            for(User user:users_list.values())
            {
                HashMap<Integer, InsurancePolicies> polList = user.getPolicies();
                for(InsurancePolicies pol:polList.values())
                {
                    String carModel = pol.getCar().getModel();
                    if(!carModelList.contains(carModel))
                    {
                        carModelList.add(carModel);
                    }
                }
            }
            for(String carModel:carModelList)
            {
                int[] count_user_carModel = new int[ranges.length];
                for(User user:users_list.values())
                {
                    HashMap<Integer, InsurancePolicies> polList = user.getPolicies();
                    for(InsurancePolicies pol:polList.values())
                    {
                        if(carModel.equals(pol.getCar().getModel()) && pol.calcPayment(5) <= ranges[0])
                        {
                            count_user_carModel[0]++;
                        }
                    }
                }
                for(int i = 1; i < ranges.length; i++)
                {
                    for(User user:users_list.values())
                    {
                        boolean check = false;
                        HashMap<Integer, InsurancePolicies> polList = user.getPolicies();
                        //int[] count_user_pol = user.policyCount(user.getUserName(), user.getUserPassword(), ranges);
                        for(InsurancePolicies pol:polList.values())
                        {
                            if(carModel.equals(pol.getCar().getModel()) && pol.calcPayment(5) > ranges[i-1] && pol.calcPayment(5) <= ranges[i])
                            {
                                count_user_carModel[i]++;
                            }
                        }
                    }
                }
                //Convert int[] to Integer[]
                Integer[] count_final = new Integer[ranges.length];
                for(int i = 0; i < ranges.length; i++)
                {
                    count_final[i] = Integer.valueOf(count_user_carModel[i]);
                }
                count.put(carModel, count_final);
            }
            return count;
        }
        else
        {
            return count;
        }
    }
    
    //Get User with validate user
    public User validateUser(String username, String password){
        for(User user:users_list.values())
        {
            if(user.validateUser(username, password))
                return user;
        }
        return null;
    }
    
    //Load file static for login - From Binary File
    public static InsuranceCompany load() throws IOException, ClassNotFoundException{
        ObjectInputStream inputst = new ObjectInputStream(Files.newInputStream(Paths.get("Test.bin", new String[0]), new java.nio.file.OpenOption[0]));
        InsuranceCompany insCompany = (InsuranceCompany) inputst.readObject();
        inputst.close();
        return insCompany;
    }
    
    //Save file static for login - From Binary File
    public void save() throws IOException{
        ObjectOutputStream outputst = new ObjectOutputStream(Files.newOutputStream(Paths.get("Test.bin", new String[0]), new java.nio.file.OpenOption[0]));
        outputst.writeObject(this);
        outputst.close();
    }
    
    //Get all user id
    public ArrayList<String> getAllUserID(){
        ArrayList<String> listID = new ArrayList<String>();
        for(int id:users_list.keySet())
        {
            listID.add(String.valueOf(id));
        }
        return listID;
    }
}
