package carinsurance;

//Main class
import java.util.*;
import java.io.*;
import java.util.stream.*;
import java.util.function.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;

public class CarInsurance{
    //Create One Insurance Company
    private static final int flatRate = 5; // Flat Rate - Constant value
    public static void main(String[] args) throws CloneNotSupportedException, PolicyException, IOException, PolicyHolderNameException{
        Scanner sc = new Scanner(System.in);
    
        //Input the flat rate from the manager
        /*System.out.print("Input the flat rate: ");
        double flatRate = sc.nextDouble();*/
        /*
        //Create 3 policies for my example
        //Car 1 - third party policy
        CarType typeCar1 = CarType.SUV;
        //Car typeCar1 = Car(Car.CarType.SUV);
        Car car1 = new Car("SUV-12", typeCar1, 2018, 5000.0);
        ThirdPartyPolicy policy1 = new ThirdPartyPolicy("Tran", 12, car1, 3, "Good");
        //Car 2 - comprehensive policy
        CarType typeCar2 = CarType.SED;
        Car car2 = new Car("SED-13", typeCar2, 2019, 5000.5);
        ComprehensivePolicy policy2 = new ComprehensivePolicy("Dang", 13, car2, 3, 31, 2);
        //Car 3 - comprehensive policy
        CarType typeCar3 = CarType.LUX;
        Car car3 = new Car("LUX-14", typeCar3, 2020, 5001.5);
        ComprehensivePolicy policy3 = new ComprehensivePolicy("Dat", 14, car3, 3, 29, 2);
        
        //Create list for 3 policies of my example
        ArrayList<InsurancePolicies> policies = new ArrayList<>();
        policies.add(policy1);
        policies.add(policy2);
        policies.add(policy3);
        
        //Print all policies by using print method
        for(InsurancePolicies pol : policies)
        {
            pol.print();
            System.out.printf("\n Premium payment: %.3f", pol.calcPayment(flatRate));
            System.out.println();
        }
        System.out.println();
        //Print all policies by using toString method
        for(InsurancePolicies pol : policies)
        {
            System.out.print(pol);
            System.out.printf("\n Premium payment: %.3f", pol.calcPayment(flatRate));
            System.out.println();
        }
        
        System.out.println();
        //Calculate the total of premium payment
        double totalPremiumPayment = 0;
        for(InsurancePolicies pol : policies)
        {
            totalPremiumPayment += pol.calcPayment(flatRate);
        }
        System.out.println("The total of premium payment is: " + totalPremiumPayment);*/
        
        /*System.out.println("=============================================");
        
        //WEEEK 2 ADDED
        System.out.println("NEW TEST CODE IN WEEK 2");
        //Create few examples of Third Party and Comprehensive Policy
        //Policy 1
        Car newCar1 = new Car("SUV-12", CarType.SUV, 2021, 4500.5);
        MyDate expiryDate1 = new MyDate(2022, 01, 13);
        ThirdPartyPolicy newPolicy1 = new ThirdPartyPolicy("Tran", 21, newCar1, 3, expiryDate1, "Good");
        
        //Policy2
        Car newCar2 = new Car("SED-12", CarType.SED, 2022, 8200.1);
        MyDate expiryDate2 = new MyDate(2022, 11, 20);
        ComprehensivePolicy newPolicy2 = new ComprehensivePolicy("Dang", 22, newCar2, 3, expiryDate2, 33, 2);
        
        //Policy3
        Car newCar3 = new Car("HATCH", CarType.HATCH, 2023, 6400.5);
        MyDate expiryDate3 = new MyDate(2022, 02, 28);
        ThirdPartyPolicy newPolicy3 = new ThirdPartyPolicy("Dat", 23, newCar3, 3, expiryDate3, "Nice");
        
        //One User example
        Address userAddress = new Address(159, "Northfield Ave", "Wollongong", "Wollongong");
        User userTest = new User("Dang Dat Tran", 13, userAddress);
        
        //Add Policy  to the user by addPolicy()
        //Check if can add this policy and add it
        if(userTest.addPolicy(newPolicy1))
        {
            System.out.println("Successful to add new policy");
        }
        else
        {
            System.out.println("Not successful to add this policy");
        }
        //Check if can add this policy and add it
        if(userTest.addPolicy(newPolicy2))
        {
            System.out.println("Successful to add new policy");
        }
        else
        {
            System.out.println("Not successful to add this policy");
        }
        //Check if can add this policy and add it
        if(userTest.addPolicy(newPolicy3))
        {
            System.out.println("Successful to add new policy");
        }
        else
        {
            System.out.println("Not successful to add this policy");
        }
        
        //Print information of user and all policies information with print() method
        System.out.println("Print() method:");
        userTest.print();
        //Print information of user and all policies information with toString() method;
        System.out.println();
        System.out.println("toString() method:");
        System.out.println(userTest);
        
        //Find a policy for a given Policy ID, if it cannot be found <input policyID from the keyboard>
        System.out.print("Please enter a policy ID you want to check: ");
        int policyIDCheck = Integer.parseInt(sc.nextLine());
        if(userTest.findPolicy(policyIDCheck) == null)
        {
            System.out.println("Policy has not been found");
        }
        //Find a policy with a given ID, if it can be found
        else
        {
            System.out.print(userTest.findPolicy(policyIDCheck));
            userTest.findPolicy(policyIDCheck).carPriceRise(0.1);
            userTest.findPolicy(policyIDCheck).setPolicyHolderName("Robert");
            userTest.findPolicy(policyIDCheck).setCarModel("Toyota Camry 2018");
            System.out.println("Information of policy after adjust: ");
            System.out.println(userTest.findPolicy(policyIDCheck));
        }
        
        //Change the city of user to "Wollongong"
        userAddress.setCity("Wollongong");
        
        //Ask the customer (user) to enter the information for new Address
        System.out.print("Please enter your new street number: ");
        int newStreetNum = Integer.parseInt(sc.nextLine());
        System.out.print("Please enter your new street: ");
        String newStreet = sc.nextLine();
        System.out.print("Please enter your new suburb: ");
        String newSuburb = sc.nextLine();
        System.out.print("Please enter your new city: ");
        String newCity = sc.nextLine();
        
        //Change the user address and print it
        Address newUserAddress = new Address(newStreetNum, newStreet, newSuburb, newCity);
        userAddress.setAddress(newUserAddress);
        System.out.println("The new address is: " + userAddress.getAddress());
        //Print the total premium payments for all policies of this user
        System.out.println("The total premium payment of user: " + userTest.calcTotalPremiums1(flatRate));
        
        //Add 10% to the price of cars for all policies of this user
        userTest.carPriceRiseAll1(0.1);
        
        //Print the total premium after rise
        System.out.println("The total premium of user after rise: " + userTest.calcTotalPremiums1(flatRate));
        //Ask the customer (user) enter car model and store the filtered list
        System.out.print("Please enter your car model you want to have filtered list: ");
        String carModel = sc.nextLine();
        ArrayList<InsurancePolicies> filteredList = new ArrayList<InsurancePolicies>();
        filteredList.add(newPolicy1);
        filteredList.add(newPolicy2);
        filteredList.add(newPolicy3);
        
        //print the filtered list by calling static method in Insuracepolicies class
        System.out.println(InsurancePolicies.filterByCarModel(filteredList, carModel));
        //print the filtered list by calling method in User class
        System.out.println(userTest.filterByCarModel1(carModel));*/
        
        
        System.out.println("=============================================");
        
        /*
        //WEEEK 3 ADDED
        System.out.println("NEW TEST CODE IN WEEK 3");
        //Create few examples of Third Party and Comprehensive Policy
        //Policy 1 - Dang Dat Tran user
        Car newCar1 = new Car("SUV-12", CarType.SUV, 2021, 4500.5);
        MyDate expiryDate1 = new MyDate(2022, 01, 13);
        ThirdPartyPolicy newPolicy1 = new ThirdPartyPolicy("Dang Dat Tran", 21, newCar1, 3, expiryDate1, "Good");
        
        //Policy2 - Dang Dat Tran user
        Car newCar2 = new Car("SED-12", CarType.SED, 2022, 8200.1);
        MyDate expiryDate2 = new MyDate(2022, 11, 20);
        ComprehensivePolicy newPolicy2 = new ComprehensivePolicy("Dang Dat Tran", 22, newCar2, 3, expiryDate2, 33, 2);
        
        //Policy3 - Charlie Puth user
        Car newCar3 = new Car("HATCH", CarType.HATCH, 2023, 6400.5);
        MyDate expiryDate3 = new MyDate(2022, 02, 28);
        ThirdPartyPolicy newPolicy3 = new ThirdPartyPolicy("Charlie Puth", 23, newCar3, 3, expiryDate3, "Nice");
        
        //Policy4 - Charlie Puth user
        Car newCar4 = new Car("LUX-23", CarType.LUX, 2024, 7600.5);
        MyDate expiryDate4 = new MyDate(2022, 03, 01);
        ComprehensivePolicy newPolicy4 = new ComprehensivePolicy("Charlie Puth", 24, newCar4, 3, expiryDate4, 29, 2);
        
        //Policy5 - Boyce Avenue user
        Car newCar5 = new Car("SUV-22", CarType.SUV, 2022, 4700.0);
        MyDate expiryDate5 = new MyDate(2023, 01, 01);
        ThirdPartyPolicy newPolicy5 = new ThirdPartyPolicy("Boyce Avenue", 25, newCar5, 3, expiryDate5, "Good");
        
        //Policy6 - Boyce Avenue user
        Car newCar6 = new Car("HATCH-22", CarType.HATCH, 2022, 3200.0);
        MyDate expiryDate6 = new MyDate(2024, 01, 01);
        ComprehensivePolicy newPolicy6 = new ComprehensivePolicy("Boyce Avenue", 26, newCar6, 3, expiryDate6, 31, 2);
        
        //Create Two Wrong examples when add them to users in the company
        //Policy7 - Wrong user ID Test
        Car newCar7 = new Car("SED-31", CarType.SED, 2022, 2500.0);
        MyDate expiryDate7 = new MyDate(2023, 02, 03);
        ThirdPartyPolicy newPolicyWrongUserID = new ThirdPartyPolicy("Dang Dat Tran", 27, newCar7, 3, expiryDate7, "Medium");
        
        //Policy8 - Duplicate policy - Duplicate with policy 4
        ComprehensivePolicy newPolicyDuplicate = new ComprehensivePolicy("Charlie Puth", 24, newCar4, 3, expiryDate4, 29, 2);
        
        //Create User 1 example
        Address userAddress1 = new Address(159, "Street 1", "Suburb 1", "City 1");
        User userTest1 = new User("Dang Dat Tran", 13, userAddress1);
        
        //Create User 2 example
        Address userAddress2 = new Address(169, "Street 2", "Suburb 2", "City 2");
        User userTest2 = new User("Charlie Puth", 14, userAddress2);
        
        //Create User 3 example
        Address userAddress3 = new Address(179, "Street 3", "Suburb 3", "City 3");
        User userTest3 = new User("Boyce Avenue", 15, userAddress3);
        
        //Create One Insurance Company
        InsuranceCompany companyTest = new InsuranceCompany("Insurance Company", "adminname", "123456", flatRate);
        
        //Question 2: Login to the Insurance Company
        System.out.println("REQUIREMENT 2: ");
        //Successful login with given name and password
        if(companyTest.validateAdmin("adminname", "123456"))
        {
           System.out.println("Successful Login!");
        }
        else
        {
           System.out.println("Login Failed!!! Please try again the user name and password");
        }
        //Fail login with given name and password
        if(companyTest.validateAdmin("adminame", "123456"))
        {
           System.out.println("Successful Login!");
        }
        else
        {
           System.out.println("Login Failed!!! Please try again the user name and password");
        }
        //Ask the admin (input from keyboard) to login
        System.out.print("Please enter admin name: ");
        String adminName = sc.nextLine();
        System.out.print("Please enter password: ");
        String adminPassword = sc.nextLine();
        if(companyTest.validateAdmin(adminName, adminPassword))
        {
            System.out.println("Successful Login!");
        }
        else
        {
            System.out.println("Login Failed!!! Please try again the user name and password");
        }
        System.out.println();
        
        //Question 3: Add users to the Insurance Company by using both version of addUser()
        System.out.println("REQUIREMENT 3: ");
        //Add User 1 - Ver 1
        if(companyTest.addUser(userTest1))
        {
            System.out.println("Successful to add First user to company");
        }
        else
        {
            System.out.println("Failed to add First user to company");
        }
        //Add user 1 - Ver 2
        if(companyTest.addUser("Dang Dat Tran", 13, userAddress1))
        {
            System.out.println("Successful to add First user to company");
        }
        else
        {
            System.out.println("Failed to add First user to company");
        }
        System.out.println();
        //Add User 2 - Ver 1
        if(companyTest.addUser(userTest2))
        {
            System.out.println("Sucessful to add Second user to company");
        }
        else
        {
            System.out.println("Failed to add Second user to company");
        }
        //Add User 2 - Ver 2
        if(companyTest.addUser("Charlie Puth", 14, userAddress2))
        {
            System.out.println("Sucessful to add Second user to company");
        }
        else
        {
            System.out.println("Failed to add Second user to company");
        }
        System.out.println();
        //Add User 3 - Ver 1
        if(companyTest.addUser(userTest3))
        {
            System.out.println("Successful to add Third user to company");
        }
        else
        {
            System.out.println("Failed to add Third user to company");
        }
        //Add User 3 - Ver 2
        if(companyTest.addUser("Boyce Avenue", 15, userAddress3))
        {
            System.out.println("Successful to add Third user to company");
        }
        else
        {
            System.out.println("Failed to add Third user to company");
        }
        System.out.println();
        
        //Question 4: Add several policies to the users
        System.out.println("REQUIREMENT 4: ");
        //Add Policy 1, Policy 2 and Wrong User ID policy to the User 1 by addPolicy()
        //Policy 1 - User 1
        if(companyTest.addPolicy(userTest1.getUserID(), newPolicy1))
        {
            System.out.println("Successful to add new policy to User 1");
        }
        else
        {
            if(userTest1.findPolicy(newPolicy1.getID()) != null)
            {
                System.out.println("Duplicate policy ID: This policy ID is existed in User 1");
            }
            else
            {
                System.out.println("The User ID is wrong!!!");
            }
        }
        //Policy 2 - User 1
        if(companyTest.addPolicy(userTest1.getUserID(), newPolicy2))
        {
            System.out.println("Successful to add new policy to User 1");
        }
        else
        {
            if(userTest1.findPolicy(newPolicy2.getID()) != null)
            {
                System.out.println("Duplicate policy ID: This policy ID is existed in User 1");
            }
            else
            {
                System.out.println("The User ID is wrong!!!");
            }
        }
        //Wrong User ID Policy - User 1
        int wrongUserID = 20;
        if(companyTest.addPolicy(wrongUserID, newPolicyWrongUserID))
        {
            System.out.println("Successful to add new policy to User 1");
        }
        else
        {
            if(userTest1.findPolicy(newPolicyWrongUserID.getID()) != null)
            {
                System.out.println("Duplicate policy ID: This policy ID is existed in User 1");
            }
            else
            {
                System.out.println("The User ID is wrong!!!");
            }
        }
        
        //Add Policy 3, Policy 4 and Duplicate ID Policy to the User 2 by addPolicy()
        //Policy 3 - User 2
        if(companyTest.addPolicy(userTest2.getUserID(), newPolicy3))
        {
            System.out.println("Successful to add new policy to User 2");
        }
        else
        {
            if(userTest2.findPolicy(newPolicy3.getID()) != null)
            {
                System.out.println("Duplicate policy ID: This policy ID is existed in User 2");
            }
            else
            {
                System.out.println("The User ID is wrong!!!");
            }
        }
        //Policy 4 - User 2
        if(companyTest.addPolicy(userTest2.getUserID(), newPolicy4))
        {
            System.out.println("Successful to add new policy to User 2");
        }
        else
        {
            if(userTest2.findPolicy(newPolicy4.getID()) != null)
            {
                System.out.println("Duplicate policy ID: This policy ID is existed in User 2");
            }
            else
            {
                System.out.println("The User ID is wrong!!!");
            }
        }
        //Duplicate ID policy - User 2 - Duplicate ID: 24, duplicate with newPolicy4
        if(companyTest.addPolicy(userTest2.getUserID(), newPolicyDuplicate))
        {
            System.out.println("Successful to add new policy to User 2");
        }
        else
        {
            if(userTest2.findPolicy(newPolicyDuplicate.getID()) != null)
            {
                System.out.println("Duplicate policy ID: This policy ID is existed in User 2");
            }
            else
            {
                System.out.println("The User ID is wrong!!!: ");
            }
        }
        
        
        //Add Policy 5 and Policy 5 to the User 3 by addPolicy()
        //Policy 5 - User 3
        if(companyTest.addPolicy(userTest3.getUserID(), newPolicy5))
        {
            System.out.println("Successful to add new policy to User 3");
        }
        else
        {
            if(userTest3.findPolicy(newPolicy5.getID()) != null)
            {
                System.out.println("Duplicate policy ID: This policy ID is existed in User 3");
            }
            else
            {
                System.out.println("The User ID is wrong!!!");
            }
        }
        //Policy 6 - User 3
        if(companyTest.addPolicy(userTest3.getUserID(), newPolicy6))
        {
            System.out.println("Successful to add new policy to User 3");
        }
        else
        {
            if(userTest3.findPolicy(newPolicy6.getID()) != null)
            {
                System.out.println("Duplicate policy ID: This policy ID is existed in User 3");
            }
            else
            {
                System.out.println("The User ID is wrong!!!");
            }
        }
        System.out.println();
        
        //Question 5: Add several policies to users by createThirdpartyPolicy() and createComprehensivePolicy() method
        System.out.println("REQUIREMENT 5: ");
        //Add by createThirdPartyPolicy()
        Car newCar9 = new Car("SUV-101", CarType.SUV, 2030, 4200.5);
        MyDate expiryDate9 = new MyDate(2035, 01, 01);
        if(companyTest.createThirdPartyPolicy(13, "Dang Dat Tran", 30, newCar9, 3, expiryDate9, "Good"))
        {
            System.out.println("Successful to add new policy to User 1");
        }
        else
        {
            User user = companyTest.findUser(13);
            if(user.findPolicy(30) != null)
                System.out.println("Duplicate policy OD: This policy ID is existed in User 1");
            else
                System.out.println("The User ID is wrong!!!");
        }
        
        //Add by createComprehensivePolicy()
        Car newCar10 = new Car("SED-101", CarType.SED, 2030, 5200.5);
        MyDate expiryDate10 = new MyDate(2033, 01, 01);
        if(companyTest.createComprehensivePolicy(14, "Charlie Puth", 31, newCar10, 3, expiryDate10, 33, 2))
        {
            System.out.println("Successful to add new policy to User 2");
        }
        else
        {
            User user = companyTest.findUser(14);
            if(user.findPolicy(31) != null)
                System.out.println("Duplicate policy ID: This polocy ID is existed in User 2");
            else
                System.out.println("The User ID is wrong!!!");
        }
        
        //Add by createThirdPartyPolicy() with wrong user ID
        Car newCar11 = new Car("SUV-101", CarType.SUV, 2030, 4200.5);
        MyDate expiryDate11 = new MyDate(2035, 01, 01);
        if(companyTest.createThirdPartyPolicy(10, "Dang Dat Tran", 39, newCar11, 3, expiryDate11, "Good"))
        {
            System.out.println("Successful to add new policy to User 1");
        }
        else
        {
            User user = companyTest.findUser(13);
            if(user.findPolicy(39) != null)
                System.out.println("Duplicate policy ID: This policy ID is existed in User 1");
            else
                System.out.println("The User ID is wrong!!!");
        }
        
        //Add by createComprehensivePolicy() with duplicate policy ID
        Car newCar12 = new Car("SED-101", CarType.SED, 2030, 5200.5);
        MyDate expiryDate12 = new MyDate(2033, 01, 01);
        if(companyTest.createComprehensivePolicy(14, "Charlie Puth", 31, newCar12, 3, expiryDate12, 33, 2))
        {
            System.out.println("Successful to add new policy to User 2");
        }
        else
        {
            User user = companyTest.findUser(14);
            if(user.findPolicy(31) != null)
                System.out.println("Duplicate policy ID: This polocy ID is existed in User 2");
            else
                System.out.println("The User ID is wrong!!!");
        }
        System.out.println();
        
        //Question 6: Input an user ID and display the user with all policies
        System.out.println("REQUIREMENT 6: ");
        System.out.print("Please enter an user ID: ");
        int userID = Integer.parseInt(sc.nextLine());
        companyTest.printPolicies(userID);
        System.out.println();
        
        //Question 7: Input an user ID and a policy ID, find policy by given policy ID for given user ID and print policy
        System.out.println("REQUIREMENT 7: ");
        System.out.print("Please enter an user ID: ");
        int user_ID = Integer.parseInt(sc.nextLine());
        System.out.print("Please enter an policy ID: ");
        int policy_ID = Integer.parseInt(sc.nextLine());
        System.out.println("The information of this policy: \n" + companyTest.findPolicy(user_ID, policy_ID));
        
        //Question 8: Print all users in the insurance company
        System.out.println("REQUIREMENT 8: ");
        //print() method
        companyTest.print();
        System.out.println();
        //toStirng() method
        System.out.println(companyTest);
        
        //Question 9: Raise price of all cars for all users: 10% and display information again
        System.out.println("REQUIREMENT 9: ");
        companyTest.carPriceRise(0.1);
        companyTest.print();
        
        //Question 10: Print all total premium payments for a given user ID 
        System.out.println("REQUIREMENT 10: ");
        System.out.println("The total payment of User 1 is: " + companyTest.calcTotalPayment(userTest1.getUserID()));
        System.out.println("The total payment of User 2 is: " + companyTest.calcTotalPayment(userTest2.getUserID()));
        System.out.println("The total payment of User 3 is: " + companyTest.calcTotalPayment(userTest3.getUserID()));
        System.out.println();
        
        //Question 11: Print the total payments for all users in the company
        System.out.println("REQUIREMENT 11: ");
        System.out.println("The total payment of all users in the company: " + companyTest.calcTotalPayment());
        System.out.println();
        
        //Question 12: Print array list of all policies of all users in the insurance company
        System.out.println("REQUIREMENT 12: ");
        ArrayList<InsurancePolicies> storeList = new ArrayList<InsurancePolicies>();
        storeList = companyTest.allPolicies();
        InsurancePolicies.printPolicies(storeList);
        System.out.println();
        
        //Question 13: Print filtered list by expiry date for a given user ID and expiry date
        System.out.println("REQUIREMENT 13: ");
        ArrayList<InsurancePolicies> storeList_expiryDate = new ArrayList<InsurancePolicies>();
        MyDate expiryDateFilter = new MyDate(2023, 3, 1);
        storeList_expiryDate = companyTest.filterByExpiryDate(13, expiryDateFilter);
        InsurancePolicies.printPolicies(storeList_expiryDate);
        System.out.println();
        
        //Question 14: Print filtered list by car model in the insurance company
        System.out.println("REQUIREMENT 14: ");
        ArrayList<InsurancePolicies> storeList_carModel = new ArrayList<InsurancePolicies>();
        storeList_carModel = companyTest.filterByCarModel("SUV");
        InsurancePolicies.printPolicies(storeList_carModel);
        System.out.println();
        
        //Question 15: Enter a date (year, month and day), and print filter list by this expiry date
        System.out.println("REQUIREMENT 15: ");
        System.out.print("Please enter Year: ");
        int yearInp = Integer.parseInt(sc.nextLine());
        System.out.print("Please enter Month: ");
        int monthInp = Integer.parseInt(sc.nextLine());
        System.out.print("Please enter Day: ");
        int dayInp = Integer.parseInt(sc.nextLine());
        MyDate dateInp = new MyDate(yearInp, monthInp, dayInp);
        ArrayList<InsurancePolicies> storeList_expiryDate_All = new ArrayList<InsurancePolicies>();
        storeList_expiryDate_All = companyTest.filterByExpiryDate(dateInp);
        InsurancePolicies.printPolicies(storeList_expiryDate_All);
        System.out.println();
        
        //Question 16: Find user with a given user ID, save it in an User object, enter new address and change current address
        System.out.println("REQUIREMENT 16: ");
        companyTest.findUser(13); //Find user with user ID 13 (valid)
        User userQues16 = companyTest.findUser(13); //Save in an User object
        System.out.print("Please enter new street num: ");
        int newStreetNum = Integer.parseInt(sc.nextLine());
        System.out.print("Please enter new street: ");
        String newStreet = sc.nextLine();
        System.out.print("Please enter new suburb: ");
        String newSuburb = sc.nextLine();
        System.out.print("Please enter new city: ");
        String newCity = sc.nextLine();
        Address newAddress = new Address(newStreetNum, newStreet, newSuburb, newCity);
        
        Address setAddress = userQues16.getAddress(); //get address of this user (user with user ID 13)
        setAddress.setAddress(newAddress);
        System.out.println("The new address is: " + setAddress.getAddress());
        
        System.out.println(newPolicy1.getExpiryDate().getDate());
        */
        
        //NEW CODE WEEK 4 ADDED
        /*System.out.println("LAB 4: ");
        //mainMenu();
        
        //LAB 4 TEST CODE ADDED
        
        //Create Insurance Company
        InsuranceCompany companyTest = new InsuranceCompany("Dang Insurance Company", "adminname", "123456", flatRate);
        
        //Create User 1 example
        Address userAddress1 = new Address(159, "Street 1", "Suburb 1", "City 1");
        User userTest1 = new User("Dang Dat Tran", 13, userAddress1);
        
        //Create User 2 example
        Address userAddress2 = new Address(169, "Street 2", "Suburb 2", "City 2");
        User userTest2 = new User("Charlie Puth", 14, userAddress2);
        
        //Policy 1 - Dang Dat Tran user
        Car newCar1 = new Car("SUV-12", CarType.SUV, 2021, 4500.5);
        MyDate expiryDate1 = new MyDate(2022, 11, 13);
        ThirdPartyPolicy newPolicy1 = new ThirdPartyPolicy("Dang Dat Tran", 21, newCar1, 3, expiryDate1, "Good");
        
        //Policy2 - Dang Dat Tran user
        Car newCar2 = new Car("SED-12", CarType.SED, 2022, 8200.1);
        MyDate expiryDate2 = new MyDate(2022, 1, 20);
        ComprehensivePolicy newPolicy2 = new ComprehensivePolicy("Dang Dat Tran", 22, newCar2, 3, expiryDate2, 33, 2);
        
        //Policy3 - Charlie Puth user
        Car newCar3 = new Car("HATCH", CarType.HATCH, 2023, 6400.5);
        MyDate expiryDate3 = new MyDate(2022, 3, 28);
        ThirdPartyPolicy newPolicy3 = new ThirdPartyPolicy("Charlie Puth", 23, newCar3, 3, expiryDate3, "Nice");
        
        //Policy4 - Charlie Puth user
        Car newCar4 = new Car("LUX-23", CarType.LUX, 2024, 7600.5);
        MyDate expiryDate4 = new MyDate(2023, 2, 01);
        ComprehensivePolicy newPolicy4 = new ComprehensivePolicy("Charlie Puth", 24, newCar4, 3, expiryDate4, 29, 2);
        
        //Add User 1 to Insurance Company
        if(companyTest.addUser(userTest1))
        {
            System.out.println("Successful to add User 1 to Company");
        }
        else
        {
            System.out.println("Failed to add User 1 to Company");
        }
        
        //Add User 2 to Insurance Company
        if(companyTest.addUser(userTest2))
        {
            System.out.println("Successful to add User 2 to Company");
        }
        else
        {
            System.out.println("Failed to add User 2 to Company");
        }
        System.out.println();
        
        //Add policy 1 to user 1
        if(companyTest.addPolicy(userTest1.getUserID(), newPolicy1))
        {
            System.out.println("Successful to add Policy 1 to User 1");
        }
        else
        {
            System.out.println("Failed to add Policy 1 to User 1");
        }
        
        //Add policy 2 to user 1
        if(companyTest.addPolicy(userTest1.getUserID(), newPolicy2))
        {
            System.out.println("Successful to add Policy 2 to User 1");
        }
        else
        {
            System.out.println("Failed to add Policy 2 to User 1");
        }
        
        //Add policy 3 to user 2
        if(companyTest.addPolicy(userTest2.getUserID(), newPolicy3))
        {
            System.out.println("Successful to add Policy 3 to User 2");
        }
        else
        {
            System.out.println("Failed to add Policy 3 to User 2");
        }
        
        //Add policy 4 to user 2
        if(companyTest.addPolicy(userTest2.getUserID(), newPolicy4))
        {
            System.out.println("Successful to add Policy 2 to User 4");
        }
        else
        {
            System.out.println("Failed to add Policy 2 to User 4");
        }
        System.out.println();
        
        //Call deepCopyPolicies() and shallowCopyPolicies() for all policies of one user
        ArrayList<InsurancePolicies> deepCopyList = new ArrayList<InsurancePolicies>();
        ArrayList<InsurancePolicies> shallowCopyList = new ArrayList<InsurancePolicies>();
        deepCopyList = userTest1.deepCopyPolicies();
        shallowCopyList = userTest1.shallowCopyPolicies();
        
        //Change user's city to "New York"
        userAddress1.setCity("New York");
        userAddress2.setCity("New York");
        
        //Sort user's policies by calling sortPoliciesByDate()
        System.out.println("List Policies of User 1 and User Sort by Date: ");
        System.out.println("User 1: ");
        InsurancePolicies.printPolicies(userTest1.sortPoliciesByDate());
        System.out.println("User 2: ");
        InsurancePolicies.printPolicies(userTest2.sortPoliciesByDate());
        System.out.println();
        //System.out.println(userTest1.sortPoliciesByDate());
        //System.out.println(userTest2.sortPoliciesByDate());
        
        //Print the shallow and deep copy lists as well as user’s policies
        System.out.println("Shallow Copy List Policies of User 1: ");
        InsurancePolicies.printPolicies(shallowCopyList);
        System.out.println();
        System.out.println("Deep Copy List Policies of User 1: ");
        InsurancePolicies.printPolicies(deepCopyList);
        System.out.println();
        System.out.println("List Policies of User 1: ");
        userTest1.printPolicies(flatRate);
        System.out.println();
        
        //Call deepCopyUsers() and shallowCopUsers() to make deep and shallow copies of company’s users and store these lists
        ArrayList<User> deepCopyUser = new ArrayList<User>();
        ArrayList<User> shallowCopyUser = new ArrayList<User>();
        deepCopyUser = companyTest.deepCopyUser();
        shallowCopyUser = companyTest.shallowCopyUser();
        
        //Add a new user 3 to the Company
        Address userAddress3 = new Address(179, "Street 3", "Suburb 3", "City 3");
        User userTest3 = new User("Boyce Avenue", 15, userAddress3);
        if(companyTest.addUser(userTest3))
        {
            System.out.println("Successful to add User 3 to Company");
        }
        else
        {
            System.out.println("Failed to add User 3 to Company");
        }
        System.out.println();
        
        //Add a new user 4 to the company by creating auto ID
        Address userAddress4 = new Address(189, "Street 3", "Suburb 3", "New York");
        User userTest4 = new User("Pulisic", userAddress4);
        if(companyTest.addUser(userTest4))
        {
            System.out.println("Successful to add User 4 to Company");
        }
        else
        {
            System.out.println("Failed to add User 4 to Company");
        }
        System.out.println();
        
        //Sort Company's users by calling sortUser()
        System.out.println("List Users Sort by Total Payment: ");
        companyTest.printUser(companyTest.sortUsers());
        System.out.println();
        
        //Print Shallow Copy, Deep Copy and List of Users
        System.out.println("Shallow Copy List Users of Insurance Company (Not Including User 3 and 4): ");
        companyTest.printUser(shallowCopyUser);
        System.out.println();
        System.out.println("Deep Copy List Users of Insurance Company (Not Including User 3 and 4): ");
        companyTest.printUser(deepCopyUser);
        System.out.println();
        System.out.println("List Users of Insurance Company: ");
        companyTest.print();
        System.out.println();
        
        //Make a clone of Insurance Company and show it is a deep copy
        InsuranceCompany copyCompany = companyTest.clone();
        System.out.println("Information of Deep Copy of Insurance Company: ");
        copyCompany.print();*/
        
                System.out.println("Assignment 3:");
                ArrayList<InsuranceCompany> company = new ArrayList<>();
                Connection connection = null;
                Statement statement = null;
                ResultSet resultSet = null;
                try
                {
                    Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
                }
                catch(ClassNotFoundException cnfex)
                {

                    System.out.println("Problem in loading or registering MS Access JDBC driver");
                    cnfex.printStackTrace();
                }

		try
                {

                    String msAccessDBName = "Insurancecompany.accdb";
                    String dbURL = "jdbc:ucanaccess://" + msAccessDBName; 
                    connection = DriverManager.getConnection(dbURL); 
                    statement = connection.createStatement();
                    resultSet = statement.executeQuery("SELECT * FROM ADMINCOMPANY");
                    while(resultSet.next())
                    {
			String companyName = resultSet.getString("Name");
                        String adminUsername = resultSet.getString("LoginName");
                        String adminPassword = resultSet.getString("Password");
                        int newFlatRate = resultSet.getInt("FlatRate");
                        InsuranceCompany companyTemp = new InsuranceCompany(companyName, adminUsername, adminPassword, newFlatRate);
                        company.add(companyTemp);
                    }
		}
		catch(SQLException sqlex)
                {
                    sqlex.printStackTrace();
		}
		finally
                {
                    try
                    {
                        if(null != connection)
                        {
                            resultSet.close();
                            statement.close();
                            connection.close();
                        }
                    }
                    catch (SQLException sqlex)
                    {
                        sqlex.printStackTrace();
                    }
		}
        InsuranceCompany companyTest = company.get(0);
        mainMenu(companyTest);
    }
    
    //Create main menu
    public static void mainMenu(InsuranceCompany companyTest) throws PolicyException, IOException, PolicyHolderNameException{
        Scanner sc = new Scanner(System.in);
        int option = 0;
        while(option != 3)
        {
            displayMainMenu();
            option = Integer.parseInt(sc.nextLine());
            switch(option)
            {
                //Option 1: Admin Login
                case 1:
                    System.out.print("Please enter username: ");
                    String adminUsername = sc.nextLine();
                    System.out.print("Please enter password: ");
                    String adminPassword = sc.nextLine();
                    if(companyTest.validateAdmin(adminUsername, adminPassword))
                    {
                        System.out.println("Login successful!!!");
                        adminMenu(companyTest);
                    }
                    else
                    {
                        System.out.println("Please try again your user name or your password!");
                    }
                    break;

                //Option 2: User Login
                case 2:
                    System.out.print("Please enter your user ID: ");
                    int userID_user = Integer.parseInt(sc.nextLine());
                    User user_uMenu = companyTest.findUser(userID_user);
                    System.out.print("Please enter User Name: ");
                    String userName = sc.nextLine();
                    System.out.print("Please enter User Password: ");
                    String userPassword = sc.nextLine();
                    if(user_uMenu.validateUser(userName, userPassword))
                    {
                        userMenu(companyTest, userID_user);
                    }
                    else
                    {
                        System.out.println("Please try again you user name and your password!");
                    }
                    break;

                //Option 3: Exit program
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Wrong option!!");
                    break;
                }
            }
    }
    
    //Display main menu
    public static void displayMainMenu(){
        System.out.println("==================== Main Menu ====================");
        System.out.println("1. Admin Login");
        System.out.println("2. User Login");
        System.out.println("3. Exit Program");
        System.out.println();
        System.out.print("Please choose an option from 1 to 3: ");
    }
    
    //Create admin menu
    public static void adminMenu(InsuranceCompany companyTest) throws PolicyException, IOException, PolicyHolderNameException{
        Scanner sc = new Scanner(System.in);
        int option = 0;
        while(option != 21)
        {
            displayAdminMenu();
            option = Integer.parseInt(sc.nextLine());
            switch(option)
            {
                //Optoin 1. Test code:  To run the test code based on your test case
                case 1:
                    //Create few examples of Third Party and Comprehensive Policy
                    //Policy 1 - Dang Dat Tran user
                    /*Car newCar1 = new Car("SUV-12", CarType.SUV, 2021, 4500.5);
                    MyDate expiryDate1 = new MyDate(2022, 01, 13);
                    ThirdPartyPolicy newPolicy1 = new ThirdPartyPolicy("Dang Dat Tran", 3123456, newCar1, 3, expiryDate1, "Good");

                    //Policy2 - Dang Dat Tran user
                    Car newCar2 = new Car("SED-12", CarType.SED, 2022, 8200.1);
                    MyDate expiryDate2 = new MyDate(2022, 11, 20);
                    ComprehensivePolicy newPolicy2 = new ComprehensivePolicy("Dang Dat Tran", 3876543, newCar2, 3, expiryDate2, 33, 2);
                    
                    //Create User 1 example
                    Address userAddress1 = new Address(159, "Street 1", "Suburb 1", "City 1");
                    User userTest1 = new User("Dang Dat Tran", 13, userAddress1);
                    
                    //Add user to Dang Insurance Company - Version 1
                    if(companyTest.addUser(userTest1))
                    {
                        System.out.println("Successful to add User to Insurance Company");
                    }
                    else
                    {
                        System.out.println("Failed to add User to Insurance Company");
                    }
                    
                    //Add user to Dang Insurance Company - Version 2
                    if(companyTest.addUser("Dang Dat Tran", 13, userAddress1))
                    {
                        System.out.println("Successful to add User to Insurance Company");
                    }
                    else
                    {
                        System.out.println("Failed to add User to Insurance Company");
                    }
                    System.out.println();
                    System.out.println("******************Next test code part******************");
                    
                    //Find user: Check user ID is exist in Dang Insurance Company or not
                    if(companyTest.findUser(userTest1.getUserID()) != null)
                    {
                        System.out.println("This user is exsiting in Dang Insurance Company");
                        System.out.print("The Information of this User by print(): ");
                        userTest1.print();
                        System.out.println("The Information of this User by toString(): " + userTest1);
                    }
                    else
                    {
                        System.out.println("This user is not appearing in Dang Insurance Company");
                    }
                    System.out.println();
                    System.out.println("******************Next test code part******************");
                    
                    //Add ThirdParty policy to User 1: user.addPolicy()
                    if(userTest1.addPolicy(newPolicy1))
                    {
                        System.out.println("Successful to add this policy to the User 1");
                    }
                    else
                    {
                        System.out.println("Failed to add this policy to the User 1");
                    }
                    
                    //Add Comprehensive policy to User 1: company.addPolicy(userID, policy)
                    if(companyTest.addPolicy(userTest1.getUserID(), newPolicy2))
                    {
                         System.out.println("Successful to add this policy to the User 1");
                    }
                    else
                    {
                        System.out.println("Failed to add this policy to the User 1");
                    }
                    System.out.println();
                    System.out.println("******************Next test code part******************");
                    
                    //Print the information of user with policies by user.print()
                    userTest1.print();
                    //Print the information of user with policies by user.toString()
                    System.out.println(userTest1);
                    //Print the information of all users with policies by company.print()
                    companyTest.print();
                    //Print the information of all users with policies by company.toString()
                    System.out.print(companyTest);
                    System.out.println();
                    System.out.println("******************Next test code part******************");
                    
                    
                    //Find and check the policy is existing in user or not by user.findPolicy(policyID)
                    if(userTest1.findPolicy(newPolicy1.getID()) != null)
                    {
                        System.out.println("This Policy is existing: " + userTest1.findPolicy(newPolicy1.getID()));
                    }
                    else
                    {
                        System.out.println("This Policy is not appearing!!");
                    }
                    
                    //Find and check the policy is existing in user or not by company.findPolicy(userID, policyID)
                    if(companyTest.findPolicy(userTest1.getUserID(), newPolicy2.getID()) != null)
                    {
                        System.out.println("This Policy is existing: " + companyTest.findPolicy(userTest1.getUserID(), newPolicy2.getID()));
                    }
                    else
                    {
                        System.out.println("This Policy is not appearing!!");
                    }
                    System.out.println();
                    System.out.println("******************Next test code part******************");
                    
                    //Add new User 2 to company 1 - version 2
                    Address userAddress2 = new Address(169, "Street 2", "Suburb 2", "City 2");
                    User userTest2 = new User("Charlie Puth", 3123654, userAddress2);
                    if(companyTest.addUser("Charlie Puth", 3123654, userAddress2))
                    {
                        System.out.println("Successful to add User to Insurance Company");
                    }
                    else
                    {
                        System.out.println("Failed to add this policy to the User 1");
                    }
                    System.out.println();
                    System.out.println("******************Next test code part******************");
                    
                    //Create ThirdParty Policy and add it to User Test 2
                    Car newCar3 = new Car("SUV-12", CarType.SUV, 2022, 3500.5);
                    MyDate expiryDate3 = new MyDate(2025, 1, 1);
                    if(companyTest.createThirdPartyPolicy(3123654, "Charlie Puth", 30, newCar3, 3, expiryDate3, "Good"))
                    {
                        System.out.println("Successful to add ThirdParty Policy to User");
                    }
                    else
                    {
                        System.out.println("Failed to add ThirdParty Policy to User");
                    }
                    //Create Comprehensive Policy and add it to User Test 2
                    Car newCar4 = new Car("HATCH-13", CarType.HATCH, 2023, 5600.4);
                    MyDate expiryDate4 = new MyDate(2028, 1, 1);
                    if(companyTest.createComprehensivePolicy(3123654, "Charlie Puth", 31, newCar4, 3, expiryDate4, 28, 2))
                    {
                        System.out.println("Successful to add Comprehensive Policy to User");
                    }
                    else
                    {
                        System.out.println("Failed to add Comprehensive Policy to User");
                    }
                    System.out.println();
                    System.out.println("******************Next test code part******************");
                    
                    userTest1.print();
                    //Car price rise all by calling corresponding method in User class
                    userTest1.carPriceRiseAll1(0.1);
                    //Print all policies to check Car price now
                    userTest1.printPolicies(flatRate);
                    System.out.println();
                    System.out.println("******************Next test code part******************");
                    
                    //Car Price Rise all User in Company
                    companyTest.carPriceRise(13, 0.1);
                    companyTest.carPriceRise(0.1);
                    //Print to check price now
                    companyTest.print();
                    System.out.println();
                    System.out.println("******************Next test code part******************");
                    
                    //Filter by Car Model of user
                    //ArrayList<InsurancePolicies> filterCarModel = userTest1.filterByCarModel1("SUV-12");
                    HashMap<Integer, InsurancePolicies> filterCarModel = userTest1.filterByCarModel1("SUV-12");
                    System.out.println("All car model SUV-12 of User 1: ");
                    InsurancePolicies.printPolicies(filterCarModel);
                    //Filter by Car Model of all users in company
                    //ArrayList<InsurancePolicies> filterCarModelAll = companyTest.filterByCarModel("SUV-12");
                    HashMap<Integer, InsurancePolicies> filterCarModelAll = companyTest.filterByCarModel("SUV-12");
                    System.out.println("All car model SUV-12 of all Users: ");
                    InsurancePolicies.printPolicies(filterCarModelAll);
                    System.out.println();
                    System.out.println("******************Next test code part******************");
                    
                    //Filter by Expiry Date of user
                    MyDate expiryDateCheck = new MyDate(2021, 1, 1);
                    //ArrayList<InsurancePolicies> filterExpiryDateUser = userTest1.filterByExpiryDate(expiryDateCheck);
                    HashMap<Integer, InsurancePolicies> filterExpiryDateUser = userTest1.filterByExpiryDate(expiryDateCheck);           
                    System.out.println("Filter by Expiry Date of User 1: ");
                    InsurancePolicies.printPolicies(filterExpiryDateUser);
                    //Filter by Expiry Date of all Users
                    //ArrayList<InsurancePolicies> filterExpiryDateAll = companyTest.filterByExpiryDate(expiryDateCheck);
                    HashMap<Integer, InsurancePolicies> filterExpiryDateAll = companyTest.filterByExpiryDate(expiryDateCheck);
                    System.out.println("Filter by Expiry Date of All Users: ");
                    InsurancePolicies.printPolicies(filterExpiryDateAll);
                    System.out.println();
                    System.out.println("******************Next test code part******************");
                    
                    //Generate reports by City
                    ArrayList<String> citiesDistinct = companyTest.populateDistinctCityNames();
                    ArrayList<Double> totalPaymentCities = companyTest.getTotalPaymentPerCity(citiesDistinct);
                    System.out.println("The report by City is: ");
                    companyTest.reportPaymentPerCity(citiesDistinct, totalPaymentCities);
                    //Generates reports by Car Model of all Users
                    ArrayList<String> carModelDistinctAll = companyTest.populateDistinctCarModel();
                    ArrayList<Integer> carModelNum = companyTest.getTotalCountPerCarModel(carModelDistinctAll);
                    ArrayList<Double> totalPaymentCarModels = companyTest.getTotalPaymentPerCarModel(carModelDistinctAll, flatRate);
                    System.out.println("The report by Car Model for all Users is: ");
                    companyTest.reportPaymentPerCarModel(carModelDistinctAll, carModelNum, totalPaymentCarModels);
                    //Generates reports by Car Model of one User
                    ArrayList<String> carModelDistinctUser = userTest1.populateDistinctCarModels();
                    ArrayList<Integer> carModelCount = userTest1.getTotalCountPerCarModel(carModelDistinctUser);
                    ArrayList<Double> totalPaymentCarModelsUser = userTest1.getTotalPaymentPerCarModel(carModelDistinctUser, flatRate);
                    System.out.println("The report by Car Model of User 1 is: ");
                    userTest1.reportPaymentsPerCarModel(carModelDistinctUser, carModelCount, totalPaymentCarModelsUser);
                    */
                    
                    //LAB 5
                    /*Car newCar1 = new Car("SUV-12", CarType.SUV, 2021, 4500.5);
                    MyDate expiryDate1 = new MyDate(2022, 01, 13);
                    ThirdPartyPolicy newPolicy1 = new ThirdPartyPolicy("Dang Dat Tran", 3123456, newCar1, 3, expiryDate1, "Good");

                    //Policy2 - Dang Dat Tran user
                    Car newCar2 = new Car("SED-12", CarType.SED, 2022, 8200.1);
                    MyDate expiryDate2 = new MyDate(2022, 11, 20);
                    ComprehensivePolicy newPolicy2 = new ComprehensivePolicy("Dang Dat Tran", 3876543, newCar2, 3, expiryDate2, 33, 2);
                    
                    //Create User 1 example
                    Address userAddress1 = new Address(159, "Street 1", "Suburb 1", "City 1");
                    User userTest1 = new User("Dang Dat Tran", 13, userAddress1);
                    
                    //Add user to Dang Insurance Company - Version 1
                    if(companyTest.addUser(userTest1))
                    {
                        System.out.println("Successful to add User to Insurance Company");
                    }
                    else
                    {
                        System.out.println("Failed to add User to Insurance Company");
                    }
                    
                     //Add ThirdParty policy to User 1: user.addPolicy()
                    if(userTest1.addPolicy(newPolicy1))
                    {
                        System.out.println("Successful to add this policy to the User 1");
                    }
                    else
                    {
                        System.out.println("Failed to add this policy to the User 1");
                    }
                    
                    //Add Comprehensive policy to User 1: company.addPolicy(userID, policy)
                    if(companyTest.addPolicy(userTest1.getUserID(), newPolicy2))
                    {
                         System.out.println("Successful to add this policy to the User 1");
                    }
                    else
                    {
                        System.out.println("Failed to add this policy to the User 1");
                    }
                    System.out.println();
                    
               
                    //Add new User 2 to company 1
                    Address userAddress2 = new Address(169, "Street 2", "Suburb 2", "City 2");
                    User userTest2 = new User("Charlie Puth", 14, userAddress2);
                    if(companyTest.addUser(userTest2))
                    {
                        System.out.println("Successful to add User to Insurance Company");
                    }
                    else
                    {
                        System.out.println("Failed to add this policy to the User 1");
                    }
                    
                    //Create ThirdParty Policy and add it to User Test 2
                    Car newCar3 = new Car("SUV-12", CarType.SUV, 2022, 3500.5);
                    MyDate expiryDate3 = new MyDate(2025, 1, 1);
                    if(companyTest.createThirdPartyPolicy(14, "Charlie Puth", 3012456, newCar3, 3, expiryDate3, "Good"))
                    {
                        System.out.println("Successful to add ThirdParty Policy to User");
                    }
                    else
                    {
                        System.out.println("Failed to add ThirdParty Policy to User");
                    }
                    //Create Comprehensive Policy and add it to User Test 2
                    Car newCar4 = new Car("HATCH-13", CarType.HATCH, 2023, 5600.4);
                    MyDate expiryDate4 = new MyDate(2028, 1, 1);
                    if(companyTest.createComprehensivePolicy(14, "Charlie Puth", 3135791, newCar4, 3, expiryDate4, 28, 2))
                    {
                        System.out.println("Successful to add Comprehensive Policy to User");
                    }
                    else
                    {
                        System.out.println("Failed to add Comprehensive Policy to User");
                    }
                    System.out.println();
                    
                    //Generate report of these examples
                    //Report By Car Model For User 1
                    System.out.println("Report By Car Model for User 1: ");
                    HashMap<String, Integer> carModelList_user1 = userTest1.getTotalCountPerCarModel();
                    HashMap<String, Double> carPayment_user1 = userTest1.getTotalPremiumPerCarModel(flatRate);
                    userTest1.reportByCarModel(carModelList_user1, carPayment_user1);
                    
                    //Report By Car Model For User 2
                    System.out.println("Report By Car Model for User 2: ");
                    HashMap<String, Integer> carModelList_user2_1 = userTest2.getTotalCountPerCarModel();
                    HashMap<String, Double> carPayment_user2_1 = userTest2.getTotalPremiumPerCarModel(flatRate);
                    userTest2.reportByCarModel(carModelList_user2_1, carPayment_user2_1);
                    
                    
                    //Report By City For All Users
                    System.out.println("Report By City for All Users: ");
                    HashMap<String, Double> cityList_allUsers = companyTest.getTotalPremiumPerCity();
                    companyTest.reportByCity(cityList_allUsers);
                    
                    //Report By Car Model For All Users
                    System.out.println("Report By Car Model for All Users: ");
                    HashMap<String, Integer> carModelList_allUsers = companyTest.getTotalPerCarModel();
                    HashMap<String, Double> carPayment_allUsers = companyTest.getTotalPremiumPerCarModel();
                    companyTest.reportByCarModel(carModelList_allUsers, carPayment_allUsers);
                    
                    System.out.println();
                    
                    //Copy Constructor of User and Insurance Company
                    User user1 = new User(userTest1);
                    User user2 = new User(userTest2);
                    InsuranceCompany company = new InsuranceCompany(companyTest);
                    System.out.println("User Copy Constructor: ");
                    user1.print();
                    user2.print();
                    System.out.printf("\n\n");
                    System.out.println("Insurance Company Copy Constructor: ");
                    company.print();
                    System.out.println();
                    
                    //Sort User and Policy
                    System.out.println("Sort Policies of User 1 by Date: ");
                    ArrayList<InsurancePolicies> sortPoliciesByDate = user1.sortPoliciesByDate();
                    InsurancePolicies.printPolicies(sortPoliciesByDate);
                    System.out.println("Sort User of Company by Total Payment: ");
                    ArrayList<User> sortUserByPayment = companyTest.sortUsers();
                    companyTest.printUser(sortUserByPayment);*/
                    
                    //Assignment 2
                    /*
                    Car newCar1 = new Car("SUV-12", CarType.SUV, 2021, 4500.5);
                    MyDate expiryDate1 = new MyDate(2022, 01, 13);
                    ThirdPartyPolicy newPolicy1 = new ThirdPartyPolicy("Dang Tran", 3123456, newCar1, 3, expiryDate1, "Good");
                    
                    Address userAddress1 = new Address(159, "Street 1", "Suburb 1", "City 1");
                    User userTest1 = new User("Dang Tran", 13, userAddress1, "dangtran", "123456");

                    userTest1.addPolicy(userTest1.getUserNameLogin(), userTest1.getUserPassword(), newPolicy1);
                    
                    Car newCar3 = new Car("SUV-12", CarType.SUV, 2021, 4500.5);
                    MyDate expiryDate3 = new MyDate(2022, 01, 13);
                    ThirdPartyPolicy newPolicy3 = new ThirdPartyPolicy("Dang Tran", 3123456, newCar3, 3, expiryDate3, "Good");

                    ComprehensivePolicy newPolicy4 = new ComprehensivePolicy("Dang Tran", 3111666, newCar3, 3, expiryDate3, 31, 2);
                    
                    Address newAddress4 = new Address(200, "street4", "suburb4", "City 4");
                    User userTest3 = new User("Boyce Avenue", 27, newAddress4, "boyceavenue" , "123456");
                    userTest3.addPolicy(userTest3.getUserNameLogin(), userTest3.getUserPassword(), newPolicy4);
                    
                    Address userAddress4 = new Address(159, "Street 1", "Suburb 1", "City 1");
                    User userTest4 = new User("Dang Tran", 18, userAddress4, "dangtran" , "123456");
                    Car newCar10 = new Car("SUV-12", CarType.SUV, 2021, 100.0);
                    MyDate expiryDate10 = new MyDate(2022, 01, 13);
                    ThirdPartyPolicy newPolicy10 = new ThirdPartyPolicy("Dang Tran", 3123456, newCar10, 3, expiryDate1, "Good");
                    //User user=new User(120,......);
                    userTest4.addPolicy(userTest4.getUserNameLogin(), userTest4.getUserPassword(), newPolicy10);
                    
                    Address userAddress2 = new Address(169, "Street 2", "Suburb 2", "City 2");
                    User userTest2 = new User("Charlie Puth", 14, userAddress2, "charlieputh" , "123456");
                    Car newCar5 = new Car("SUV-12", CarType.SUV, 2022, 3500.5);
                    MyDate expiryDate5 = new MyDate(2019, 1, 1);
                    companyTest.createThirdPartyPolicy(14, "Charlie Puth", 3012456, newCar5, 3, expiryDate5, "Good");
                    
                    companyTest.addUser(userTest1);
                    companyTest.addUser(userTest2);
                    companyTest.addUser(userTest3);
                    companyTest.addUser(userTest4);
                    companyTest.print();
                    System.out.println(companyTest.sortUserByPremium()); //Sort By Total Payment with new Comparator 
                    System.out.println(companyTest.sortUsers()); //Sort By City
                    System.out.println(companyTest.getUsersPerCity()); //Get All User's Name of each city
                    System.out.println(companyTest.filterPoliciesByExpiryDate(expiryDate5));
                    //Total count policy range of each User
                    int[] ranges = new int[]{610, 660, 800};
                    System.out.println("Range Example: ");
                    for(int i = 0; i < ranges.length; i++)
                    {
                        System.out.print(ranges[i] + " ");
                    }
                    System.out.println();
                    
                    //Range User 1
                    System.out.println("Number of Policies of User 1 Per Range: ");
                    int [] count1 = userTest1.policyCount(userTest1.getUserNameLogin(), userTest1.getUserPassword(), ranges);
                    for(int i = 0;i < count1.length; i++)
                    {
                        System.out.print(count1[i] + " ");
                    }
                    System.out.println();
                    
                    //Range User 2
                    System.out.println("Number of Policies of User 2 Per Range: ");
                    int [] count2 = userTest2.policyCount(userTest2.getUserNameLogin(), userTest2.getUserPassword(), ranges);
                    for(int i = 0;i < count2.length; i++)
                    {
                        System.out.print(count2[i] + " ");
                    }
                    System.out.println();
                    
                    //Range User 3
                    System.out.println("Number of Policies of User 3 Per Range: ");
                    int [] count3 = userTest3.policyCount(userTest3.getUserNameLogin(), userTest3.getUserPassword(), ranges);
                    for(int i = 0;i < count3.length; i++)
                    {
                        System.out.print(count3[i] + " ");
                    }
                    System.out.println();
                    
                    //Number of Policies of User 4 Per Range
                    System.out.println("Number of Policies of User 4 Per Range: ");
                    int [] count4 = userTest4.policyCount(userTest4.getUserNameLogin(), userTest4.getUserPassword(), ranges);
                    for(int i = 0;i < count4.length; i++)
                    {
                        System.out.print(count4[i] + " ");
                    }
                    System.out.println();
                    
                    //Number of Policies of Company Per Range
                    System.out.println("Number of Policies of Company Per Range: ");
                    int[] countAll = companyTest.policyCount(companyTest.getName(), companyTest.getPassword(), ranges);
                    for(int i = 0; i < countAll.length; i++)
                    {
                        System.out.print(countAll[i] + " ");
                    }
                    System.out.println();
                    
                    //Number of Policies of a City Per Range
                    System.out.println("Number of Policies of a City Per Range: ");
                    HashMap<String, Integer[]> count_4 = companyTest.policyCityCount(companyTest.getName(), companyTest.getPassword(), ranges);
                    for(String city:count_4.keySet())
                    {
                        Integer[] rangePerCity = count_4.get(city);
                        System.out.print(city + " ");
                        for(int  i = 0; i < rangePerCity.length; i++)
                        {
                            System.out.print(rangePerCity[i] + " ");
                        }
                        System.out.println();
                    }
                    
                    //Number of Users Per Range
                    System.out.println("Number of Users Per Range: ");
                    int[] count6 = companyTest.userCount(companyTest.getName(), companyTest.getPassword(), ranges);
                    for(int i = 0; i < count6.length; i++)
                    {
                        System.out.print(count6[i] + " ");
                    }
                    System.out.println();
                    
                    //Number of Users that have car model in Per Range
                    System.out.println("Number of Users that have car model in Per Range: ");
                    HashMap<String, Integer []> count7 = companyTest.userCarModelCount(companyTest.getName(), companyTest.getPassword(), ranges);
                    for(String carModel:count7.keySet())
                    {
                        Integer[] numUserPerRange = count7.get(carModel);
                        System.out.print(carModel + " ");
                        for(int i = 0; i < numUserPerRange.length; i++)
                        {
                            System.out.print(numUserPerRange[i] + " ");
                        }
                        System.out.println();
                    }
                    
                    //Number of Policies that have car model in Per Range of All Users
                    System.out.println("Number of Policies that have car model in Per Range of All Users: ");
                    HashMap<String, Integer []> count8 = companyTest.policyCarModelCount(companyTest.getName(), companyTest.getPassword(), ranges);
                    for(String carModel:count8.keySet())
                    {
                        Integer[] numPolicyPerRange = count8.get(carModel);
                        System.out.print(carModel + " ");
                        for(int i = 0; i < numPolicyPerRange.length; i++)
                        {
                            System.out.print(numPolicyPerRange[i] + " ");
                        }
                        System.out.println();
                    }
                    
                    //Number of Policies that have car model in Per Range of One User
                    System.out.println("Number of Policies that have car model in Per Range of One User - User 1: ");
                    HashMap<String, Integer []> count9 = userTest1.policyCarModelCount(userTest1.getUserNameLogin(), userTest1.getUserPassword(), ranges);
                    for(String carModel:count9.keySet())
                    {
                        Integer[] numPolicyPerRange = count9.get(carModel);
                        System.out.print(carModel + " ");
                        for(int i = 0; i < numPolicyPerRange.length; i++)
                        {
                            System.out.print(numPolicyPerRange[i] + " ");
                        }
                        System.out.println();
                    }
                    
                    //Number of Policies that have car model in Per Range of One User
                    System.out.println("Number of Policies that have car model in Per Range of One User - User 3: ");
                    HashMap<String, Integer []> count10 = userTest3.policyCarModelCount(userTest3.getUserNameLogin(), userTest3.getUserPassword(), ranges);
                    for(String carModel:count10.keySet())
                    {
                        Integer[] numPolicyPerRange = count10.get(carModel);
                        System.out.print(carModel + " ");
                        for(int i = 0; i < numPolicyPerRange.length; i++)
                        {
                            System.out.print(numPolicyPerRange[i] + " ");
                        }
                        System.out.println();
                    }
                    
                    System.out.println();
                    //Testing binary file and list of policies
                    System.out.println("Test Binary File and List of Policies: ");
                    HashMap<Integer,InsurancePolicies> policies=InsurancePolicies.load("policies.ser");
                    InsurancePolicies.printPolicies(policies);
                    

                    policies.put(3123456, newPolicy1);
                    InsurancePolicies.save(policies,"policies.ser");
                    policies.clear();

                    policies = InsurancePolicies.load("policies.ser");
                    InsurancePolicies.printPolicies(policies);
                    System.out.println("======================================");
                    
                    //Testing binary file and list of users
                    System.out.println("Test Binary File and List of Users: ");
                    HashMap<Integer,User> users=User.load("users.ser");
                    User.printUsers(users);
                    users.put(13,userTest1);
                    User.save(users, "users.ser");
                    users.clear();

                    users=User.load("users.ser");
                    User.printUsers(users);
                    System.out.println("======================================");
                    
                    //Testing text file and list of policies with toDelimitedString
                    System.out.println("Test Text File and List of Policies with toDelimitedString: ");
                    HashMap<Integer,InsurancePolicies> policies_text = InsurancePolicies.loadTextFile("policies.txt");
                    InsurancePolicies.printPolicies(policies_text);
                    
                    policies_text.put(3123456, newPolicy3);
                    policies_text.put(3111666, newPolicy4);
                    InsurancePolicies.saveTextFile(policies_text,"policies.txt");
                    policies_text.clear();

                    policies_text = InsurancePolicies.loadTextFile("policies.txt");
                    InsurancePolicies.printPolicies(policies_text);
                    System.out.println("======================================");
                    

                    //Testing text file and list of users with toDelimitedString
                    System.out.println("Test Text File and List of Users with toDelimitedString: ");
                    HashMap<Integer,User> users_text = User.loadTextFile("users.txt");
                    User.printUsers(users_text);
                    users_text.put(27, userTest3);
                    User.saveTextFile(users_text, "users.txt");
                    users_text.clear();

                    users_text = User.loadTextFile("users.txt");
                    User.printUsers(users_text);
                    System.out.println("======================================");
                    
                    */
                    
                    //InsuranceCompany and binary file
                    /*InsuranceCompany insuranceCompany1 = new InsuranceCompany();//using default constructor
                    insuranceCompany1.load("company.ser");//the whole company including all users and all policies are loaded
                    System.out.println(insuranceCompany1);

                    //insuranceCompany1.addUser(116,....);
                    //insuranceCompany1.addPolicy(11,.....);
                    
                    //Create new User
                    Address userAddress2 = new Address(169, "Street 2", "Suburb 2", "City 2");
                    User userTest2 = new User("Charlie Puth", 14, userAddress2);
                    
                    //Create new policy
                    Car newCar2 = new Car("SED-12", CarType.SED, 2022, 8200.1);
                    MyDate expiryDate2 = new MyDate(2022, 11, 20);
                    ComprehensivePolicy newPolicy2 = new ComprehensivePolicy("Dang Dat Tran", 3876543, newCar2, 3, expiryDate2, 33, 2);
                    
                    insuranceCompany1.addUser(userTest2);
                    insuranceCompany1.addPolicy(14, newPolicy2);
                    insuranceCompany1.save("company.ser");
                    InsuranceCompany insuranceCompany2=new InsuranceCompany();

                    insuranceCompany2.load("company.ser");
                    System.out.println(insuranceCompany2);*/
                    
                    //InsuranceCompany and text file
                    /*InsuranceCompany insuranceCompany1 = new InsuranceCompany();//using default constructor
                    insuranceCompany1.loadTextFile("company.txt");//the whole company including all users and all policies are loaded
                    System.out.println(insuranceCompany1);
                    //insuranceCompany1.print();

                    //insuranceCompany1.addUser(117,....);
                    //insuranceCompany1.addPolicy(12,.....);
                    insuranceCompany1.addUser(userTest1);
                    insuranceCompany1.addPolicy(13, newPolicy4);
                    insuranceCompany1.saveTextFile("company.txt");
                    InsuranceCompany insuranceCompany2=new InsuranceCompany();

                    insuranceCompany2.loadTextFile("company.txt");
                    System.out.println(insuranceCompany2);
                    */
                    
                    //LAB8 - Test Cases
                    HashMap<Integer, User> listUsers = new HashMap<>();
                    HashMap<Integer, InsurancePolicies> listPoli = new HashMap<>();
                    
                    Connection connection = null;
                    Statement statement = null;
                    ResultSet resultSet = null;
                    ResultSet resultSet_pol = null;
                    
                    try
                    {

			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
                    }
                    catch(ClassNotFoundException cnfex)
                    {

			System.out.println("Problem in loading or registering MS Access JDBC driver");
			cnfex.printStackTrace();
                    }

                    try
                    {
                        String msAccessDBName = "Insurancecompany.accdb";
			String dbURL = "jdbc:ucanaccess://" + msAccessDBName; 
                        connection = DriverManager.getConnection(dbURL); 
                        statement = connection.createStatement();
                        resultSet = statement.executeQuery("SELECT * FROM USER");
                        resultSet_pol = statement.executeQuery("SELECT * FROM POLICY");

			while(resultSet.next()) 
                        {    
                            int userTest_id = resultSet.getInt("User_ID");
                            String userTest_name = resultSet.getString("Name");
                            int userTest_streetNum = resultSet.getInt("Streetnum");
                            String userTest_street = resultSet.getString("Street");
                            String userTest_suburb = resultSet.getString("Suburb");
                            String userTest_city = resultSet.getString("City");
                            Address user_address = new Address(userTest_streetNum, userTest_street, userTest_suburb, userTest_city);
                            String userTest_username = resultSet.getString("Username");
                            String userTest_password = resultSet.getString("Password");
                            User user = new User(userTest_name, userTest_id, user_address, userTest_username, userTest_password);
                            listUsers.put(userTest_id, user);
			}
                        
                        while(resultSet_pol.next())
                        {
                            String policyHolderName = resultSet_pol.getString("PolicyHolderName");
                            int policyID = resultSet_pol.getInt("PolicyID");
                            String carModel = resultSet_pol.getString("CarModel");
                            CarType type = CarType.valueOf(resultSet_pol.getString("CarType"));
                            int manufacturingYear = resultSet_pol.getInt("ManufacturingYear");
                            double price = resultSet_pol.getDouble("Price");
                            int numberOfClaims = resultSet_pol.getInt("NumberOfClaims");
                            int year = resultSet_pol.getInt("Year");
                            int month = resultSet_pol.getInt("Month");
                            int day = resultSet_pol.getInt("Day");
                            String comment = resultSet_pol.getString("Comment");
                            int age = resultSet_pol.getInt("Age");
                            int level = resultSet_pol.getInt("Level");
                            Car car = new Car(carModel, type, manufacturingYear, price);
                            MyDate expiryDate = new MyDate(year, month, day);
                            
                            if(comment != "")
                            {
                                ThirdPartyPolicy pol = new ThirdPartyPolicy(policyHolderName, policyID, car, numberOfClaims, expiryDate, comment);
                                listPoli.put(policyID, pol);
                            }
                            else
                            {
                                ComprehensivePolicy pol = new ComprehensivePolicy(policyHolderName, policyID, car, numberOfClaims, expiryDate, age, level);
                                listPoli.put(policyID, pol);
                            }
                            
                        }
                    }
                    catch(SQLException sqlex)
                    {
			sqlex.printStackTrace();
                    }
                    finally
                    {
			try
                        {
                            if(null != connection)
                            {   
                                resultSet.close();
                                statement.close();
                                connection.close();
                            }
			}
			catch (SQLException sqlex)
                        {
                            sqlex.printStackTrace();
			}
                    }
                    
                    //System.out.println(listUsers);
                    
                    Car newCar1 = new Car("SUV-10", CarType.SUV, 2021, 4500.5);
                    MyDate expiryDate1 = new MyDate(2022, 01, 13);
                    //ThirdPartyPolicy newPolicy1 = new ThirdPartyPolicy("Dang Tran", 3123456, newCar1, 1, expiryDate1, "Good");
                    //ComprehensivePolicy newPolicy13 = new ComprehensivePolicy("Dang Tran", 3097652, newCar1, 1, expiryDate1, 31, 2);
                    
                    InsurancePolicies newPolicy1 = listPoli.get(3123456);
                    InsurancePolicies newPolicy13 = listPoli.get(3097652);
                    
                    Address userAddress1 = new Address(159, "Street 1", "Suburb 1", "City 1");
                    //User userTest1 = new User("Dang Tran", 13, userAddress1, "dangtran", "123456");
                    User userTest1 = listUsers.get(78);
                    
                    userTest1.addPolicy(userTest1.getUserNameLogin(), userTest1.getUserPassword(), newPolicy1);
                    userTest1.addPolicy(userTest1.getUserNameLogin(), userTest1.getUserPassword(), newPolicy13);

                    Car newCar3 = new Car("LUX-13", CarType.LUX, 2021, 4500.5);
                    MyDate expiryDate3 = new MyDate(2022, 01, 13);
                    ThirdPartyPolicy newPolicy3 = new ThirdPartyPolicy("Dang Tran", 3127956, newCar3, 1, expiryDate3, "Good");

                    //ComprehensivePolicy newPolicy4 = new ComprehensivePolicy("Dang Tran", 3111666, newCar3, 1, expiryDate3, 31, 2);
                    
                    InsurancePolicies newPolicy4 = listPoli.get(3111666);
                    Address newAddress4 = new Address(200, "street4", "suburb4", "City 4");
                    //User userTest3 = new User("Boyce Avenue", 27, newAddress4, "boyceavenue", "123456");
                    User userTest3 = listUsers.get(80);
                    
                    userTest3.addPolicy(userTest3.getUserNameLogin(), userTest3.getUserPassword(), newPolicy4);

                    Address userAddress4 = new Address(159, "Street 1", "Suburb 1", "City 1");
                    //User userTest4 = new User("Dang Tran", 18, userAddress4, "dangtran", "123456");
                    User userTest4 = listUsers.get(81);
                    
                    Car newCar10 = new Car("LUX-14", CarType.LUX, 2021, 100.0);
                    MyDate expiryDate10 = new MyDate(2022, 01, 13);
                    //ThirdPartyPolicy newPolicy10 = new ThirdPartyPolicy("Dang Tran", 3123498, newCar10, 2, expiryDate1, "Good");
                    InsurancePolicies newPolicy10 = listPoli.get(3123498);
                    
                    userTest4.addPolicy(userTest4.getUserNameLogin(), userTest4.getUserPassword(), newPolicy10);

                    Address userAddress2 = new Address(169, "Street 2", "Suburb 2", "City 2");
                    //User userTest2 = new User("Charlie Puth", 14, userAddress2, "charlieputh", "123456");
                    User userTest2 = listUsers.get(79);
                    
                    Car newCar5 = new Car("LUX-12", CarType.LUX, 2022, 3500.5);
                    MyDate expiryDate5 = new MyDate(2019, 1, 1);
                    //ThirdPartyPolicy newPolicy11 = new ThirdPartyPolicy("Charlie Puth", 3012456, newCar5, 3, expiryDate5, "Good");
                    InsurancePolicies newPolicy11 = listPoli.get(3012456);
                    userTest2.addPolicy(userTest2.getUserNameLogin(), userTest2.getUserPassword(), newPolicy11);
                    //insuranceCompany.createThirdPartyPolicy(14, "Charlie Puth", 3012456, newCar5, 3, expiryDate5, "Good");


                    companyTest.addUser(userTest1);
                    companyTest.addUser(userTest2);
                    companyTest.addUser(userTest3);
                    companyTest.addUser(userTest4);
                    
                    HashMap<Integer, InsurancePolicies> policies = companyTest.allPolicies();
                    System.out.println(policies);
                    System.out.println();
                    
                    //0. Search and Print all policies with carPrice < 10000
                    System.out.println("0. All Policies with carPrice < 10000: ");
                    policies.values()
                            .stream()
                            .filter(x -> x.getCar().getPrice() < 10000)
                            .forEach(x -> System.out.println(x));
                    System.out.println();
                    
                    //1. Search and Print all information of policies with name containing "Dang"
                    System.out.println("1. All Policies with name cotaining \"Dang\"");
                    policies.values()
                            .stream()
                            .filter(x -> x.getPolicyHolderName().contains("Dang"))
                            .forEach(x -> System.out.println(x));
                    System.out.println();
                    
                    //2. Search and Print all total premiums of policies with name containint "Dang
                    System.out.println("2. Total Premiums of All Policies with name containig \"Dang\"");
                    policies.values()
                            .stream()
                            .filter(x -> x.getPolicyHolderName().contains("Dang"))
                            .forEach(x -> System.out.println(x.calcPayment(flatRate)));
                    System.out.println();
                    
                    //3. Find the first policy with the premium between 200 and 500 and display the name, ID and premium
                    System.out.println("3. The first policy with the premium between 200 and 500: ");
                    Predicate<InsurancePolicies> p1 = e -> e.calcPayment(flatRate) >= 200 && e.calcPayment(flatRate) <= 500;
                    
                    System.out.println(policies.values()
                                               .stream()
                                               .filter(p1)
                                               .findFirst()
                                               .map(InsurancePolicies::getPolicyHolderName)
                                               .get() + " " 
                                    + policies.values()
                                      .stream()
                                      .filter(p1)
                                      .findFirst()
                                      .map(InsurancePolicies::getID)
                                      .get() + " "
                                    + policies.values()
                                      .stream()
                                      .filter(p1)
                                      .findFirst()
                                      .get().calcPayment(flatRate));
                    System.out.println();
                    
                    //4. Find all policies with premium between 200 and 500 and display the name, ID and premium each policy
                    System.out.println("4. All policies with premium between 200 and 500");
                    policies.values()
                            .stream()
                            .filter(p1)
                            .forEach(x -> System.out.println(x.policyHolderName + " " + x.id + " " + x.calcPayment(flatRate)));
                    System.out.println();
                    
                    //5. Calculate the total premium for all policies with the premium between 200 and 500
                    System.out.println("5. Total premium of all policies with premium between 200 and 500: ");
                    System.out.println(policies.values()
                                               .stream()
                                               .filter(p1)
                                               .mapToDouble(x -> x.calcPayment(flatRate))
                                               .sum());
                    System.out.println();
                    
                    //6. Create new function program which has a predicate as input parameter and filters a list of policies
                    
                    //Convert hashmap to arraylist
                    ArrayList<InsurancePolicies> newPolicies = new ArrayList<InsurancePolicies>();
                    for(InsurancePolicies policy:policies.values())
                    {
                        newPolicies.add(policy);
                    }
                    System.out.println("6. New Function in Program which has a predicate as input parameter and filters a list of policies: ");
                    Predicate<InsurancePolicies> c1 = x -> x.getPolicyHolderName().equals("Dang Tran");
                    ArrayList<InsurancePolicies> newPolicies1 = InsurancePolicies.filterPolicies(newPolicies, c1);
                    InsurancePolicies.printPolicies(newPolicies1);
                    System.out.println();
                    
                    System.out.println("6.1 More Tests with New Function in Program: ");
                    System.out.println("6.1 Policies with Year expiry is 2019: ");
                    InsurancePolicies.printPolicies(InsurancePolicies.filterPolicies(newPolicies, x -> x.getExpiryDate().getYear() == 2019));
                    System.out.println();
                    System.out.println("6.1 Policies with Car Model contains \"SUV\"");
                    InsurancePolicies.printPolicies(InsurancePolicies.filterPolicies(newPolicies, x -> x.getCar().getModel().contains("SUV")));
                    System.out.println();
                    
                    //7. Call your filterPolicy method to filter a list of policies with Car Type equal to LUX.
                    //Then sort the filtered list based on car price and finally print the sorted filtered list.
                    
                    ArrayList<InsurancePolicies> newPolicies2 = InsurancePolicies.filterPolicies(newPolicies, x -> x.getCar().getType().equals(CarType.LUX));
                    System.out.println("7. All Policies with Car Type \"LUX\" Before Sort: ");
                    InsurancePolicies.printPolicies(newPolicies2);
                    //Compare by car price
                    Function<InsurancePolicies, Double> byCarPrice = x -> x.getCar().getPrice();
                    Comparator<InsurancePolicies> sortByCarPrice = Comparator.comparing(byCarPrice);
                    System.out.println();
                    System.out.println("7.1 All Policies with Car Type \"LUX\" After Sort by Car Price: ");
                    newPolicies2.stream()
                                .sorted(sortByCarPrice)
                                .forEach(x -> System.out.println(x));
                    System.out.println();
                    
                    //8. Aggregate (by using group by) the list of policies based on expiryDate year and print the report
                    System.out.println("8. All Policies are grouped by ExpiryDate Year: \n");
                    Map<Integer, List<InsurancePolicies>> groupByExpiryDateYear = newPolicies.stream()
                                                                                       .collect(Collectors
                                                                                       .groupingBy(x -> x.getExpiryDate().getYear()));
                    groupByExpiryDateYear.forEach((d, e) -> 
                    {
                        System.out.println("All Policies of ExipiryDate Year " + d + ": ");
                        e.forEach(e1 -> System.out.println(e1));
                    });
                    System.out.println();
                    
                    //Check getTotalPremiumPerCity after change to Stream / Lambda
                    //HashMap<String, Double> ans = companyTest.getTotalPremiumPerCity();
                    /*for(String str:ans.keySet())
                    {
                        System.out.println(str + " " + ans.get(str));
                    }*/
                    
                    //Check shallow and deep copy of user - Stream / Lambda
                    userTest2.printPolicies(flatRate);
                    ArrayList<InsurancePolicies> listPol = InsurancePolicies.shallowCopy(newPolicies);
                    InsurancePolicies.printPolicies(listPol);
                    System.out.println();
                    try
                    {
                        ArrayList<InsurancePolicies> listPol2 = InsurancePolicies.deepCopy(newPolicies);
                        InsurancePolicies.printPolicies(listPol2);
                    }
                    catch(CloneNotSupportedException e)
                    {
                        throw new RuntimeException(e);
                    }
                    
                    System.out.println("\n");
                    companyTest.print();
                    //Check Sort User By Premium - Comparator
                    System.out.println(companyTest.sortUserByPremium());
                    //System.out.println(userTest1.calcTotalPremiums1(userTest1.getUserNameLogin(), userTest1.getUserPassword(), flatRate));
                    
                    //Assignment 3
                    System.out.println();
                    System.out.println("=========================================================");
                    System.out.println("Assignment 3: Aggregate methods is written by Lambda / Stream");
                    System.out.println("Total Payment For Car Model \"SUV-10\" of User 1: " + userTest1.getTotalPaymentForCarModelNew("SUV-10", flatRate));
                    System.out.println();
                    
                    //Aggregate total per car model of a user - Stream / Lambda - A3
                    System.out.println("Aggregate total per car model of User Test 1: ");
                    HashMap<String, Integer> listCarModelUser = userTest1.getTotalCountPerCarModelNew();
                    for(String model:listCarModelUser.keySet())
                    {
                        System.out.println(model + " " + listCarModelUser.get(model));
                    }
                    System.out.println();
                    
                    //Aggregate total payment per car model of a user - Stream / Lambda - A3
                    System.out.println("Aggregate total payment per car model of User Test 1: ");
                    HashMap<String, Double> listPaymentPerCarModel = userTest1.getTotalPremiumPerCarModelNew(flatRate);
                    for(String model:listPaymentPerCarModel.keySet())
                    {
                        System.out.println(model + " " + listPaymentPerCarModel.get(model));
                    }
                    System.out.println();
                    
                    //Aggregate total per car model of company - Stream / Lambda - A3
                    System.out.println("Aggregate total per car model of company: ");
                    HashMap<String, Integer> listCarModelCompany = companyTest.getTotalPerCarModelNew();
                    for(String model:listCarModelCompany.keySet())
                    {
                        System.out.println(model + " " + listCarModelCompany.get(model));
                    }
                    System.out.println();
                    
                    //Aggregate total payment per car model of company - Stream / Lambda - A3
                    System.out.println("Aggregate total per car model of company: ");
                    HashMap<String, Double> listPaymentPerCarModelCompany = companyTest.getTotalPremiumPerCarModel();
                    for(String model:listCarModelCompany.keySet())
                    {
                        System.out.println(model + " " + listPaymentPerCarModelCompany.get(model));
                    }
                    System.out.println();
                    
                    int[] ranges = {200, 500, 700};
                    int[] count = (companyTest.policyCount(companyTest.getName(), companyTest.getPassword(), ranges));
                    for(int i = 0;i < count.length; i++)
                    {
                        System.out.print(count[i] + " ");
                    }
                    System.out.println();
                    
                    
                    System.out.println("Please press any keys to continue: ");
                    sc.nextLine();
                    break;
                    
                //Option 2. Create User: To get the information from admin and creates a user
                case 2:
                    System.out.print("Please enter name of user: ");
                    String userName = sc.nextLine();
                    System.out.print("Plese enter user name login: ");
                    String userName_log = sc.nextLine();
                    System.out.print("Please enter user password: ");
                    String userPassword = sc.nextLine();
                    //The User ID now is automatically generated, so I skipped this step
                    System.out.print("Please enter user ID: ");
                    int userID_op2 = 0;
                    while(userID_op2 == 0)
                    {
                        try
                        {
                            //userID_op2 = Integer.parseInt(sc.nextLine());
                            userID_op2 = sc.nextInt();
                            sc.nextLine();
                        }
                        catch(InputMismatchException e)
                        {
                            String badInput = sc.next();
                            System.out.print("Please enter an Integer :)))) \n Please enter user ID: ");
                        }
                    }
                    //Admin input user address
                    System.out.print("Please enter street number of user: ");
                    int streetNum = 0;
                    while(streetNum == 0)
                    {
                        try
                        {
                            //streetNum = Integer.parseInt(sc.nextLine());
                            streetNum = sc.nextInt();
                            sc.nextLine();
                        }
                        catch(InputMismatchException e)
                        {
                            String badInput = sc.next();
                            System.out.print("Please enter an Integer :)))) \n Please enter street number of user: ");
                        }
                    }
                    System.out.print("Please enter street: ");
                    String street = sc.nextLine();
                    System.out.print("Please enter suburb: ");
                    String suburb = sc.nextLine();
                    System.out.print("Please enter city: ");
                    String city = sc.nextLine();
                    //Get address
                    Address userAddress = new Address(streetNum, street, suburb, city);
                    //Create new user
                    User newUser = new User(userName, userID_op2, userAddress, userName_log, userPassword);
                    if(companyTest.addUser(newUser))
                    {
                        System.out.println("Successful to create User and add to Dang Insurance Company");
                    }
                    else
                    {
                        System.out.println("Failed to create User");
                    }
                    System.out.println("Please press any keys to continue: ");
                    sc.nextLine();
                    break;
                    
                //Option 3: Create ThirdParty Policy: 
                case 3:
                    //Get information of policy and user ID from admin
                    System.out.print("Please enter user ID: ");
                    int userID_op3 = 0;
                    while(userID_op3 == 0)
                    {
                        try
                        {
                            userID_op3 = sc.nextInt();
                            sc.nextLine();
                        }
                        catch(InputMismatchException e)
                        {
                            String badInput = sc.next();
                            System.out.print("Please enter an integer :))) \n Please enter user ID: ");
                        }
                    }
                    System.out.print("Please enter policy holder name: ");
                    String policyHolderName_op3 = sc.nextLine();
                    /*while(policyHolderName_op3.equals(""))
                    {
                        try
                        {
                            policyHolderName_op3 = sc.nextLine();
                            sc.nextLine();
                        }
                        catch(PolicyHolderNameException e)
                        {
                            System.out.print("Please enter the policy holder name in the true format :))) \n Please enter policy holder name: ");
                        }
                    }*/
                    System.out.print("Please enter policy ID: ");
                    int policyID_op3 = 0;
                    while(policyID_op3 == 0)
                    {
                        try
                        {
                            policyID_op3 = sc.nextInt();
                            sc.nextLine();
                        }
                        catch(InputMismatchException e)
                        {
                            String badInput = sc.next();
                            System.out.print("Please enter an integer :))) \n Please enter policy ID: ");
                        }
                    }
                    //Information of Car
                    System.out.print("Please enter model of car: ");
                    String carModel_op3 = sc.nextLine();
                    System.out.print("Please enter car type: ");
                    CarType carType_op3 = CarType.valueOf(sc.nextLine());
                    System.out.print("Please enter manufacturing year: ");
                    int manufacturingYear_op3 = 0;
                    while(manufacturingYear_op3 == 0)
                    {
                        try
                        {
                            manufacturingYear_op3 = sc.nextInt();
                            sc.nextLine();
                        }
                        catch(InputMismatchException e)
                        {
                            String badInput = sc.next();
                            System.out.print("Please enter an integer :))) \n Please enter manufacturing year: ");
                        }
                    }
                    System.out.print("Please enter price of car: ");
                    double carPrice_op3 = 0;
                    while(carPrice_op3 == 0)
                    {
                        try
                        {
                            carPrice_op3 = sc.nextDouble();
                            sc.nextLine();
                        }
                        catch(InputMismatchException e)
                        {
                            String badInput = sc.next();
                            System.out.print("Please enter a double :))) \n Please enter price of car: ");
                        }
                    }
                    Car newCar_op3 = new Car(carModel_op3, carType_op3, manufacturingYear_op3, carPrice_op3);
                    System.out.print("Please enter number of claims: ");
                    int numberOfClaims_op3 = 0;
                    while(numberOfClaims_op3 == 0)
                    {
                        try
                        {
                            numberOfClaims_op3 = sc.nextInt();
                            sc.nextLine();
                        }
                        catch(InputMismatchException e)
                        {
                            String badInput = sc.next();
                            System.out.print("Please enter an integer :))) \n Please enter number of claims: ");
                        }
                    }
                    //Information of expiry date
                    System.out.print("Please enter year of expiry date: ");
                    int yearExpiry_op3 = 0;
                    while(yearExpiry_op3 == 0)
                    {
                        try
                        {
                            yearExpiry_op3 = sc.nextInt();
                            sc.nextLine();
                        }
                        catch(InputMismatchException e)
                        {
                            String badInput = sc.next();
                            System.out.print("Please enter an integer :))) \n Please enter year of expiry date: ");
                        }
                    }
                    System.out.print("Please enter month of expiry date: ");
                    int monthExpiry_op3 = 0;
                    while(monthExpiry_op3 == 0)
                    {
                        try
                        {
                            monthExpiry_op3 = sc.nextInt();
                            sc.nextLine();
                        }
                        catch(InputMismatchException e)
                        {
                            String badInput = sc.next();
                            System.out.print("Please enter an integer :))) \n Please enter month of expiry date: ");
                        }
                    }
                    System.out.print("Please enter day of expiry date: ");
                    int dayExpiry_op3 = 0;
                    while(dayExpiry_op3 == 0)
                    {
                        try
                        {
                            dayExpiry_op3 = sc.nextInt();
                            sc.nextLine();
                        }
                        catch(InputMismatchException e)
                        {
                            String badInput = sc.next();
                            System.out.print("Please enter an integer :))) \n Please enter day of expiry date: ");
                        }
                    }
                    MyDate expiryDate_op3 = new MyDate(yearExpiry_op3, monthExpiry_op3, dayExpiry_op3);
                    System.out.print("Please enter comment: ");
                    String commentPolicy = sc.nextLine();
                    ThirdPartyPolicy newPolicy_op3 = null;
                    newPolicy_op3 = new ThirdPartyPolicy(policyHolderName_op3, policyID_op3, newCar_op3, numberOfClaims_op3, expiryDate_op3, commentPolicy);
                    /*
                    try
                    {
                        newPolicy_op3 = new ThirdPartyPolicy(policyHolderName_op3, policyID_op3, newCar_op3, numberOfClaims_op3, expiryDate_op3, commentPolicy);
                    }
                    catch(PolicyException e)
                    {
                        policyID_op3 = e.getNewPolicyID();
                        newPolicy_op3 = new ThirdPartyPolicy(policyHolderName_op3, policyID_op3, newCar_op3, numberOfClaims_op3, expiryDate_op3, commentPolicy);
                        System.out.println(e);
                    }*/
                    /*catch(PolicyHolderNameException e)
                    {
                        policyHolderName_op3 = e.getNewHolderName();
                        newPolicy_op3 = new ThirdPartyPolicy(policyHolderName_op3, policyID_op3, newCar_op3, numberOfClaims_op3, expiryDate_op3, commentPolicy);
                        System.out.println(e);
                    }*/
                    if(companyTest.createThirdPartyPolicy(userID_op3, policyHolderName_op3, policyID_op3, newCar_op3, numberOfClaims_op3, expiryDate_op3, commentPolicy))
                    {
                        System.out.println("Successfully to create new ThirdParty Policy for userID: " + userID_op3);
                        companyTest.print();
                    }
                    else
                    {
                        System.out.println("Failed to create new ThirdParty Policy for userID: " + userID_op3);
                    }
                    System.out.println("Please press any keys to continue: ");
                    sc.nextLine();
                    break;
                    
                //Option 4: Create Comprehensive Policy:
                case 4:
                    //Get information of policy and user ID from admin
                    System.out.print("Please enter user ID: ");
                    int userID_op4 = 0;
                    while(userID_op4 == 0)
                    {
                        try
                        {
                            userID_op4 = sc.nextInt();
                            sc.nextLine();
                        }
                        catch(InputMismatchException e)
                        {
                            String badInput = sc.next();
                            System.out.print("Please enter an integer :))) \n Please enter user ID: ");
                        }
                    }
                    System.out.print("Please enter policy holder name: ");
                    String policyHolderName_op4 = sc.nextLine();
                    System.out.print("Please enter policy ID: ");
                    int policyID_op4 = 0;
                    while(policyID_op4 == 0)
                    {
                        try
                        {
                            policyID_op4 = sc.nextInt();
                            sc.nextLine();
                        }
                        catch(InputMismatchException e)
                        {
                            String badInput = sc.next();
                            System.out.print("Please enter an integer :))) \n Please enter policy ID: ");
                        }
                    }
                    //Information of Car
                    System.out.print("Please enter model of car: ");
                    String carModel_op4 = sc.nextLine();
                    System.out.print("Please enter car type: ");
                    CarType carType_op4 = CarType.valueOf(sc.nextLine());
                    System.out.print("Please enter manufacturing year: ");
                    int manufacturingYear_op4 = 0;
                    while(manufacturingYear_op4 == 0)
                    {
                        try
                        {
                            manufacturingYear_op4 = sc.nextInt();
                            sc.nextLine();
                        }
                        catch(InputMismatchException e)
                        {
                            String badInput = sc.next();
                            System.out.print("Please enter an integer :))) \n Please enter manufacturing year: ");
                        }
                    }
                    System.out.print("Please enter price of car: ");
                    double carPrice_op4 = 0;
                    while(carPrice_op4 == 0)
                    {
                        try
                        {
                            carPrice_op4 = sc.nextDouble();
                            sc.nextLine();
                        }
                        catch(InputMismatchException e)
                        {
                            String badInput = sc.next();
                            System.out.print("Please enter a double :))) \n Please enter price of car: ");
                        }
                    }
                    Car newCar_op4 = new Car(carModel_op4, carType_op4, manufacturingYear_op4, carPrice_op4);
                    System.out.print("Please enter number of claims: ");
                    int numberOfClaims_op4 = 0;
                    while(numberOfClaims_op4 == 0)
                    {
                        try
                        {
                            numberOfClaims_op4 = sc.nextInt();
                            sc.nextLine();
                        }
                        catch(InputMismatchException e)
                        {
                            String badInput = sc.next();
                            System.out.print("Please enter an integer :))) \n Please enter number of claims: ");
                        }
                    }
                    //Information of expiry date
                    System.out.print("Please enter year of expiry date: ");
                    int yearExpiry_op4 = 0;
                    while(yearExpiry_op4 == 0)
                    {
                        try
                        {
                            yearExpiry_op4 = sc.nextInt();
                            sc.nextLine();
                        }
                        catch(InputMismatchException e)
                        {
                            String badInput = sc.next();
                            System.out.print("Please enter an integer :))) \n Please enter year of expiry date: ");
                        }
                    }
                    System.out.print("Please enter month of expiry date: ");
                    int monthExpiry_op4 = 0;
                    while(monthExpiry_op4 == 0)
                    {
                        try
                        {
                            monthExpiry_op4 = sc.nextInt();
                            sc.nextLine();
                        }
                        catch(InputMismatchException e)
                        {
                            String badInput = sc.next();
                            System.out.print("Please enter an integer :))) \n Please enter month of expiry date: ");
                        }
                    }
                    System.out.print("Please enter day of expiry date: ");
                    int dayExpiry_op4 = 0;
                    while(dayExpiry_op4 == 0)
                    {
                        try
                        {
                            dayExpiry_op4 = sc.nextInt();
                            sc.nextLine();
                        }
                        catch(InputMismatchException e)
                        {
                            String badInput = sc.next();
                            System.out.print("Please enter an integer :))) \n Please enter day of expiry date: ");
                        }
                    }
                    MyDate expiryDate_op4 = new MyDate(yearExpiry_op4, monthExpiry_op4, dayExpiry_op4);
                    System.out.print("Please enter driver age: ");
                    int driverAge = 0;
                    while(driverAge == 0)
                    {
                        try
                        {
                            driverAge = sc.nextInt();
                            sc.nextLine();
                        }
                        catch(InputMismatchException e)
                        {
                            String badInput = sc.next();
                            System.out.print("Please enter an integer :))) \n Please enter driver age: ");
                        }
                    }
                    System.out.print("Please enter level: ");
                    int level = 0;
                    while(level == 0)
                    {
                        try
                        {
                            level = sc.nextInt();
                            sc.nextLine();
                        }
                        catch(InputMismatchException e)
                        {
                            String badInput = sc.next();
                            System.out.print("Please enter an integer :))) \n Please enter level: ");
                        }
                    }
                    ComprehensivePolicy newPolicy_op4 = null;
                    newPolicy_op4 = new ComprehensivePolicy(policyHolderName_op4, policyID_op4, newCar_op4, numberOfClaims_op4, expiryDate_op4, driverAge, level);
                    /*try
                    {
                        newPolicy_op4 = new ComprehensivePolicy(policyHolderName_op4, policyID_op4, newCar_op4, numberOfClaims_op4, expiryDate_op4, driverAge, level);
                    }
                    catch(PolicyException e)
                    {
                        policyID_op4 = e.getNewPolicyID();
                        newPolicy_op4 = new ComprehensivePolicy(policyHolderName_op4, policyID_op4, newCar_op4, numberOfClaims_op4, expiryDate_op4, driverAge, level);
                        System.out.println(e);
                    }*/
                    if(companyTest.createComprehensivePolicy(userID_op4, policyHolderName_op4, policyID_op4, newCar_op4, numberOfClaims_op4, expiryDate_op4, driverAge, level))
                    {
                        System.out.println("Successfully to create new Comprehensive Policy for userID: " + userID_op4);
                        companyTest.print();
                    }
                    else
                    {
                        System.out.println("Failed to create new Comprehensive Policy for userID: " + userID_op4);
                    }
                    System.out.println("Please press any keys to continue: ");
                    sc.nextLine();
                    break;
                    
                //Option 5: Print User Information: To get a user ID from user and prints the user information (including all user policies)
                case 5:
                    System.out.print("Please enter the User ID: ");
                    int userID_op5 = Integer.parseInt(sc.nextLine());
                    if(companyTest.findUser(userID_op5) != null)
                    {
                        User userInfo = companyTest.findUser(userID_op5);
                        userInfo.print();
                    }
                    else
                    {
                        System.out.println("Can't found the User in our Insurance Company");
                    }
                    System.out.println("Please press any keys to continue: ");
                    sc.nextLine();
                    break;
                    
                //Option 6: Filter by Car Model: To get a car model from admin and filters and prints all the policies in the system 
                case 6:
                    System.out.print("Please enter the Car model: ");
                    String carModel_op6 = sc.nextLine();
                    //ArrayList<InsurancePolicies> filterByModel = new ArrayList<InsurancePolicies>();
                    HashMap<Integer, InsurancePolicies> filterByModel = new HashMap<Integer, InsurancePolicies>();
                    filterByModel = companyTest.filterByCarModel1(carModel_op6);
                    //System.out.println(filterByModel);
                    InsurancePolicies.printPolicies(filterByModel);
                    InsurancePolicies.calcTotalPayment(filterByModel, flatRate);
                    System.out.println("Please press any keys to continue: ");
                    sc.nextLine();
                    break;
                    
                //Option 7: Filter by Expiry Date: To get a date and a user id from admin and filters and prints all the policies belong to that user and expiring by the given date.
                case 7:
                    //Get date information: year, month and day
                    System.out.print("Please enter the Year: ");
                    int yearFilter = Integer.parseInt(sc.nextLine());
                    System.out.print("Please enter the Month: ");
                    int monthFilter = Integer.parseInt(sc.nextLine());
                    System.out.print("Please enter the Day: ");
                    int dayFilter = Integer.parseInt(sc.nextLine());
                    MyDate filterExpiryDate = new MyDate(yearFilter, monthFilter, dayFilter);
                    //Get user ID
                    System.out.print("Please enter User ID: ");
                    int userID_op7 = Integer.parseInt(sc.nextLine());
                    //ArrayList<InsurancePolicies> filterByExpiryDate = new ArrayList<InsurancePolicies>();
                    HashMap<Integer, InsurancePolicies> filterByExpiryDate = new HashMap<Integer, InsurancePolicies>();
                    filterByExpiryDate = companyTest.filterByExpiryDate(userID_op7, filterExpiryDate);
                    InsurancePolicies.printPolicies(filterByExpiryDate);
                    System.out.println("Please press any keys to continue: ");
                    sc.nextLine();
                    break;
                    
                //Option 8: Update Address: To get a user id and address information and updates the address of the given user
                case 8:
                    //Get user ID
                    System.out.print("Please enter User ID: ");
                    int userID_op8 = 0;
                    while(userID_op8 == 0)
                    {
                        try
                        {
                            userID_op8 = sc.nextInt();
                            sc.nextLine();
                        }
                        catch(InputMismatchException e)
                        {
                            String badInput = sc.next();
                            System.out.print("Please enter an integer :))) \n Please enter User ID: ");
                        }
                    }
                    //Get new address: street number, street, suburb, city
                    System.out.print("Please enter new Street number: ");
                    int newStreetNum_op8 = 0;
                    while(newStreetNum_op8 == 0)
                    {
                        try
                        {
                            newStreetNum_op8 = sc.nextInt();
                            sc.nextLine();
                        }
                        catch(InputMismatchException e)
                        {
                            String badInput = sc.next();
                            System.out.print("Please enter an integer :))) \n Please enter new Street number: ");
                        }
                    }
                    System.out.print("Please enter new Street: ");
                    String newStreet_op8 = sc.nextLine();
                    System.out.print("Please enter new Suburb: ");
                    String newSuburb_op8 = sc.nextLine();
                    System.out.print("Please enter new City: ");
                    String newCity_op8 = sc.nextLine();
                    //New address
                    Address newUserAddress = new Address(newStreetNum_op8, newStreet_op8, newSuburb_op8, newCity_op8);
                    //Get current user
                    User user_op8 = companyTest.findUser(userID_op8);
                    //Get current user Address
                    Address currentAddress = user_op8.getAddress();
                    //System.out.println("The old address is: " + currentAddress.getAddress());
                    //Set new address
                    currentAddress.setAddress(newUserAddress);
                    System.out.println("The new address is: " + currentAddress.getAddress());
                    System.out.println("Please press any keys to continue: ");
                    sc.nextLine();
                    break;
                    
                //Option 9: Admin remove a policy from a user
                case 9:
                    System.out.print("Please enter User ID you want remove: ");
                    int userID_op9 = Integer.parseInt(sc.nextLine());
                    System.out.print("Please enter Policy ID you want to remove in this User: ");
                    int policyID_op9 = Integer.parseInt(sc.nextLine());
                    if(companyTest.findUser(userID_op9) != null)
                    {
                        if(companyTest.removePolicy(userID_op9, policyID_op9))
                        {
                            System.out.println("Successful to remove policy with ID " + policyID_op9 + " from user ID " + userID_op9);
                        }
                        else
                        {
                            System.out.println("Policy ID " + policyID_op9 + " does not exist in User with ID " + userID_op9 + ", check policy ID again");
                        }
                    }
                    else
                    {
                        System.out.println("This User does not exist in our company");
                    }
                    System.out.println("Please press any keys to continue: ");
                    sc.nextLine();
                    break;
                    
                //Option 10: Admin remove a user from Dang Insurance Company
                case 10:
                    System.out.print("Please enter User ID you want remove: ");
                    int userID_op10 = Integer.parseInt(sc.nextLine());
                    if(companyTest.removeUser(userID_op10))
                    {
                        System.out.println("Successful to remove User with ID " + userID_op10 + " from our company");
                    }
                    else
                    {
                        System.out.println("This User does not exist in our company, check user ID again");
                    }
                    System.out.println("Please press any keys to continue: ");
                    sc.nextLine();
                    break;
                    
                //Option 11: Admin change the admin password            
                case 11:
                    System.out.print("Please enter old password to verify: ");
                    String oldPassword = sc.nextLine();
                    if(companyTest.checkPassword(oldPassword))
                    {
                        System.out.print("Please enter new password you want to change: ");
                        String newPassword = sc.nextLine();
                        companyTest.setPassword(newPassword);
                        System.out.println("Successful to change admin password");
                    }
                    else
                    {
                        System.out.println("Check the password, it's not correct!");
                    }
                    System.out.println("Please press any keys to continue: ");
                    sc.nextLine();
                    break;
                
                //Option 12: Create User and Add to Company with automatically generated user ID
                case 12:
                    System.out.print("Please enter name of user: ");
                    String userName_op12 = sc.nextLine();
                    System.out.print("Please enter user name login: ");
                    String userName_log_op12 = sc.nextLine();
                    System.out.print("Please enter user password: ");
                    String userPassword_op12 = sc.nextLine();
                    //Admin input user address
                    System.out.print("Please enter street number of user: ");
                    int streetNum_op12 = Integer.parseInt(sc.nextLine());
                    System.out.print("Please enter street: ");
                    String street_op12 = sc.nextLine();
                    System.out.print("Please enter suburb: ");
                    String suburb_op12 = sc.nextLine();
                    System.out.print("Please enter city: ");
                    String city_op12 = sc.nextLine();
                    //Get address
                    Address userAddress_op12 = new Address(streetNum_op12, street_op12, suburb_op12, city_op12);
                    //Create new user
                    User newUser_op12 = new User(userName_op12, userAddress_op12, userName_log_op12, userPassword_op12);
                    if(companyTest.addUser(newUser_op12))
                    {
                        System.out.println("Successful to create User and add to Dang Insurance Company");
                    }
                    else
                    {
                        System.out.println("Failed to create User");
                    }
                    System.out.println("Please press any keys to continue: ");
                    sc.nextLine();
                    break;
                
                //Option 13: Generate Reports Payment Each City
                case 13:
                    ArrayList<String> cityDistinct = new ArrayList<String>();
                    ArrayList<Double> paymentPerCity = new ArrayList<Double>();
                    cityDistinct = companyTest.populateDistinctCityNames();
                    paymentPerCity = companyTest.getTotalPaymentPerCity(cityDistinct);
                    System.out.println("The report is:");
                    companyTest.reportPaymentPerCity(cityDistinct, paymentPerCity);
                    System.out.println("Please press any keys to continue: ");
                    sc.nextLine();
                    break;
                    
                //Option 14:  Generate Reports Payment Each Car Model
                case 14:
                    ArrayList<String> carModelDistinct = new ArrayList<String>();
                    ArrayList<Integer> countPerCarModel = new ArrayList<Integer>();
                    ArrayList<Double> paymentPerCarModel = new ArrayList<Double>();
                    carModelDistinct = companyTest.populateDistinctCarModel();
                    countPerCarModel = companyTest.getTotalCountPerCarModel(carModelDistinct);
                    paymentPerCarModel = companyTest.getTotalPaymentPerCarModel(carModelDistinct, flatRate);
                    System.out.println("The report is:");
                    companyTest.reportPaymentPerCarModel(carModelDistinct, countPerCarModel, paymentPerCarModel);
                    System.out.println("Please press any keys to continue: ");
                    sc.nextLine();
                    break;
                    
                //Option 15: Total payment for given city
                case 15:
                    System.out.print("Please enter the City name: ");
                    String city_op15 = sc.nextLine();
                    System.out.println("The total payment of city " + city_op15 + " is: " + companyTest.getTotalPaymentForCity(city_op15));
                    System.out.println("Please press any keys to continue: ");
                    sc.nextLine();
                    break;
                
                //LAB 5
                //Option 16: Report by Car Model For One User
                case 16:
                    System.out.print("Please enter user ID: ");
                    int userID_op16 = 0;
                    while(userID_op16 == 0)
                    {
                        try
                        {
                            userID_op16 = sc.nextInt();
                            sc.nextLine();
                        }
                        catch(InputMismatchException e)
                        {
                            String badInput = sc.next();
                            System.out.print("Enter integer please :))) \n Please enter user ID: ");
                        }
                    }
                    User user_op16 = companyTest.findUser(userID_op16);
                    HashMap<String, Integer> countCarModel = user_op16.getTotalCountPerCarModel();
                    HashMap<String, Double> paymentCarModel = user_op16.getTotalPremiumPerCarModel(flatRate);
                    System.out.println("The Report by Car Model For User with ID " + userID_op16 + " is: ");
                    user_op16.reportByCarModel(countCarModel, paymentCarModel);
                    System.out.println("Please press any keys to continue: ");
                    sc.nextLine();
                    break;
                
                //Option 17: Report by City For All Users
                case 17:
                    System.out.println("The Report by City For All Users is: ");
                    HashMap<String, Double> cityList = companyTest.getTotalPremiumPerCity();
                    companyTest.reportByCity(cityList);
                    System.out.println("Please press any keys to continue: ");
                    sc.nextLine();
                    break;
                
                //Option 18: Report by Car Model For All Users
                case 18:
                    System.out.println("The Report by Car Model For All Users is: ");
                    HashMap<String, Integer> carModelList = companyTest.getTotalPerCarModel();
                    HashMap<String, Double> paymentCarModel_op18 = companyTest.getTotalPremiumPerCarModel();
                    companyTest.reportByCarModel(carModelList, paymentCarModel_op18);
                    System.out.println("Please press any keys to continue: ");
                    sc.nextLine();
                    break;
                    
                //Option 19: Load and Save Binary File for ThirdParty Policies
                case 19:
                    System.out.print("Please input the binary file name: ");
                    String fileName = sc.nextLine();
                    HashMap<Integer, InsurancePolicies> policies_op19 = InsurancePolicies.load(fileName);
                    InsurancePolicies.printPolicies(policies_op19);
                    
                    System.out.print("Please enter name of holder: ");
                    String policyHolderName_op19 = sc.nextLine();
                    System.out.print("Please enter policy ID: ");
                    int policyID_op19 = Integer.parseInt(sc.nextLine());
                    System.out.print("Please enter model of car: ");
                    String carModel_op19 = sc.nextLine();
                    System.out.print("Please enter type of car: ");
                    CarType type_op19 = CarType.valueOf(sc.nextLine());
                    System.out.print("Please enter manufacturing year of car: ");
                    int manufacturingYear_op19 = Integer.parseInt(sc.nextLine());
                    System.out.print("Please enter price: ");
                    double price_op19 = Double.parseDouble(sc.nextLine());
                    Car car_op19 = new Car(carModel_op19, type_op19, manufacturingYear_op19, price_op19);
                    System.out.print("Please enter number of claims: ");
                    int numberOfClaims_op19 = Integer.parseInt(sc.nextLine());
                    System.out.print("Please enter year of expiry date: ");
                    int year_op19 = Integer.parseInt(sc.nextLine());
                    System.out.print("Please enter month of expiry date: ");
                    int month_op19 = Integer.parseInt(sc.nextLine());
                    System.out.print("Please enter day of expiry date: ");
                    int day_op19 = Integer.parseInt(sc.nextLine());
                    MyDate expiryDate_op19 = new MyDate(year_op19, month_op19, day_op19);
                    System.out.print("Please enter comment: ");
                    String comment_op19 = sc.nextLine();
                    ThirdPartyPolicy policy_op19 = new ThirdPartyPolicy(policyHolderName_op19, policyID_op19, car_op19, numberOfClaims_op19, expiryDate_op19, comment_op19);
                    
                    policies_op19.put(policyID_op19, policy_op19);
                    InsurancePolicies.save(policies_op19, fileName);
                    policies_op19.clear();
                    
                    policies_op19 = InsurancePolicies.load(fileName);
                    InsurancePolicies.printPolicies(policies_op19);
                    System.out.println("Please press any keys to continue: ");
                    sc.nextLine();
                    break;
                    
                //Option 20: Load and Save Text File for Comprehensive Policies
                case 20:
                    System.out.print("Please input the text file name: ");
                    String fileName_op20 = sc.nextLine();
                    HashMap<Integer, InsurancePolicies> policies_op20 = InsurancePolicies.loadTextFile(fileName_op20);
                    InsurancePolicies.printPolicies(policies_op20);
                    
                    System.out.print("Please enter name of holder: ");
                    String policyHolderName_op20 = sc.nextLine();
                    System.out.print("Please enter policy ID: ");
                    int policyID_op20 = Integer.parseInt(sc.nextLine());
                    System.out.print("Please enter model of car: ");
                    String carModel_op20 = sc.nextLine();
                    System.out.print("Please enter type of car: ");
                    CarType type_op20 = CarType.valueOf(sc.nextLine());
                    System.out.print("Please enter manufacturing year of car: ");
                    int manufacturingYear_op20 = Integer.parseInt(sc.nextLine());
                    System.out.print("Please enter price: ");
                    double price_op20 = Double.parseDouble(sc.nextLine());
                    Car car_op20 = new Car(carModel_op20, type_op20, manufacturingYear_op20, price_op20);
                    System.out.print("Please enter number of claims: ");
                    int numberOfClaims_op20 = Integer.parseInt(sc.nextLine());
                    System.out.print("Please enter year of expiry date: ");
                    int year_op20 = Integer.parseInt(sc.nextLine());
                    System.out.print("Please enter month of expiry date: ");
                    int month_op20 = Integer.parseInt(sc.nextLine());
                    System.out.print("Please enter day of expiry date: ");
                    int day_op20 = Integer.parseInt(sc.nextLine());
                    MyDate expiryDate_op20 = new MyDate(year_op20, month_op20, day_op20);
                    System.out.print("Please enter driver age: ");
                    int driverAge_op20 = Integer.parseInt(sc.nextLine());
                    System.out.print("Please enter level: ");
                    int level_op20 = Integer.parseInt(sc.nextLine());
                    ComprehensivePolicy policy_op20 = new ComprehensivePolicy(policyHolderName_op20, policyID_op20, car_op20, numberOfClaims_op20, expiryDate_op20, driverAge_op20, level_op20);
                    
                    policies_op20.put(policyID_op20, policy_op20);
                    InsurancePolicies.saveTextFile(policies_op20, fileName_op20);
                    policies_op20.clear();
                    
                    policies_op20 = InsurancePolicies.loadTextFile(fileName_op20);
                    InsurancePolicies.printPolicies(policies_op20);
                    System.out.println("Please press any keys to continue: ");
                    sc.nextLine();
                    break;
                    
                //Option 21: Log out
                case 21:
                    //System.exit(0);
                    break;
                default:
                    System.out.println("Wrong Option!!!!");
            }
        }
    }
    
    //Display admin menu
    public static void displayAdminMenu(){
        System.out.println("==================== Admin Menu ====================");
        System.out.println("1. Test code ");
        System.out.println("2. Create User");
        System.out.println("3. Create ThirdParty Policy");
        System.out.println("4. Create Comprehensive Policy");
        System.out.println("5. Print User Information");
        System.out.println("6. Filter by Car Model");
        System.out.println("7. Filter by Expiry Date");
        System.out.println("8. Update Address");
        System.out.println("9. Remove a policy from a user");
        System.out.println("10. Remove user from Dang Insurance Company");
        System.out.println("11. Change Admin password");
        System.out.println("12. Create User and Add to Company with Automatically generated User ID from 1");
        System.out.println("13. Generate Reports Payment Each City");
        System.out.println("14. Generate Reports Payment Each Car Model");
        System.out.println("15. Total payment for given city");
        System.out.println("16. Genereate Reports By Car Model For One User - Hash Map: ");
        System.out.println("17. Genereate Reports By City For All Users- Hash Map: ");
        System.out.println("18. Genereate Reports By Car Model For All Users - Hash Map: ");
        System.out.println("19. Load and Save Binary File for ThirdParty Policies: ");
        System.out.println("20. Load and Save Text File for Comprehensive Policies: ");
        System.out.println("21. Log Out");
        System.out.println();
        System.out.print("Please choose an option from 1 to 21: ");
    }
    
    //Create User menu
    public static void userMenu(InsuranceCompany companyTest, Integer userID_user) throws PolicyException, PolicyHolderNameException{
        Scanner sc = new Scanner(System.in);
        User user_uMenu = companyTest.findUser(userID_user);
        int option = 0;
        while(option != 11)
        {
            displayUserMenu();
            option = Integer.parseInt(sc.nextLine());
            switch(option)
            {
                //Option 1: add thirdparty policy to user
                case 1:
                    //Get user ID
                    //System.out.print("Please enter user ID: ");
                    //int userID_op1 = Integer.parseInt(sc.nextLine());
                    //Get policy information
                    System.out.print("Please enter policy holder name: ");
                    String policyHolderName_op1 = sc.nextLine();
                    System.out.print("Please enter policy ID: ");
                    int policyID_op1 = Integer.parseInt(sc.nextLine());
                    //Information of Car
                    System.out.print("Please enter model of car: ");
                    String carModel_op1 = sc.nextLine();
                    System.out.print("Please enter car type: ");
                    CarType carType_op1 = CarType.valueOf(sc.nextLine());
                    System.out.print("Please enter manufacturing year: ");
                    int manufacturingYear_op1 = Integer.parseInt(sc.nextLine());
                    System.out.print("Please enter price of car: ");
                    double carPrice_op1 = Double.parseDouble(sc.nextLine());
                    Car newCar_op1 = new Car(carModel_op1, carType_op1, manufacturingYear_op1, carPrice_op1);
                    System.out.print("Please enter number of claims: ");
                    int numberOfClaims_op1 = Integer.parseInt(sc.nextLine());
                    //Information of expiry date
                    System.out.print("Please enter year of expiry date: ");
                    int yearExpiry_op1 = Integer.parseInt(sc.nextLine());
                    System.out.print("Please enter month of expiry date: ");
                    int monthExpiry_op1 = Integer.parseInt(sc.nextLine());
                    System.out.print("Please enter day of expiry date: ");
                    int dayExpiry_op1 = Integer.parseInt(sc.nextLine());
                    MyDate expiryDate_op1 = new MyDate(yearExpiry_op1, monthExpiry_op1, dayExpiry_op1);
                    System.out.print("Please enter comment: ");
                    String commentPolicy = sc.nextLine();
                    //Create new ThirdParty policy
                    ThirdPartyPolicy newPolicy_op1 = new ThirdPartyPolicy(policyHolderName_op1, policyID_op1, newCar_op1, numberOfClaims_op1, expiryDate_op1, commentPolicy);
             
                    if(user_uMenu.addPolicy(user_uMenu.getUserNameLogin(), user_uMenu.getUserPassword(), newPolicy_op1))
                    {
                        System.out.println("Successfully to add this policy to user");
                    }
                    else
                    {
                        System.out.println("Failed to add this policy to user");
                    }
                    System.out.println("Please press any keys to continue: ");
                    sc.nextLine();
                    break;
                
                //Option 2: add a Comprehensive policy to user
                case 2:
                    System.out.print("Please enter policy holder name: ");
                    String policyHolderName_op2 = sc.nextLine();
                    System.out.print("Please enter policy ID: ");
                    int policyID_op2 = Integer.parseInt(sc.nextLine());
                    //Information of Car
                    System.out.print("Please enter model of car: ");
                    String carModel_op2 = sc.nextLine();
                    System.out.print("Please enter car type: ");
                    CarType carType_op2 = CarType.valueOf(sc.nextLine());
                    System.out.print("Please enter manufacturing year: ");
                    int manufacturingYear_op2 = Integer.parseInt(sc.nextLine());
                    System.out.print("Please enter price of car: ");
                    double carPrice_op2 = Double.parseDouble(sc.nextLine());
                    Car newCar_op2 = new Car(carModel_op2, carType_op2, manufacturingYear_op2, carPrice_op2);
                    System.out.print("Please enter number of claims: ");
                    int numberOfClaims_op2 = Integer.parseInt(sc.nextLine());
                    //Information of expiry date
                    System.out.print("Please enter year of expiry date: ");
                    int yearExpiry_op2 = Integer.parseInt(sc.nextLine());
                    System.out.print("Please enter month of expiry date: ");
                    int monthExpiry_op2 = Integer.parseInt(sc.nextLine());
                    System.out.print("Please enter day of expiry date: ");
                    int dayExpiry_op2 = Integer.parseInt(sc.nextLine());
                    MyDate expiryDate_op2 = new MyDate(yearExpiry_op2, monthExpiry_op2, dayExpiry_op2);
                    System.out.print("Please enter diver age: ");
                    int driverAge_op2 = Integer.parseInt(sc.nextLine());
                    System.out.print("Please enter level: ");
                    int level_op2 = Integer.parseInt(sc.nextLine());
                    //Create new ThirdParty policy
                    ComprehensivePolicy newPolicy_op2 = new ComprehensivePolicy(policyHolderName_op2, policyID_op2, newCar_op2, numberOfClaims_op2, expiryDate_op2, driverAge_op2, level_op2);
             
                    if(user_uMenu.addPolicy(user_uMenu.getUserNameLogin(), user_uMenu.getUserPassword(), newPolicy_op2))
                    {
                        System.out.println("Successfully to add this policy to user");
                    }
                    else
                    {
                        System.out.println("Failed to add this policy to user");
                    }
                    System.out.println("Please press any keys to continue: ");
                    sc.nextLine();
                    break;
                    
                //Option 3: print a policy in user
                case 3:
                    //Get user ID
                    //System.out.print("Please enter user ID: ");
                    //int userID_op2 = Integer.parseInt(sc.nextLine());
                    //Get policy ID
                    System.out.print("Please enter policy ID: ");
                    int policyID_op3 = Integer.parseInt(sc.nextLine());
                    if(user_uMenu.findPolicy(policyID_op3) != null)
                    {
                        System.out.println(user_uMenu.findPolicy(policyID_op3));
                    }
                    else
                    {
                        System.out.println("The policy is not exist");
                    }
                    System.out.println("Please press any keys to continue: ");
                    sc.nextLine();
                    break;
                
                //Option 4: Change user address
                case 4:
                    //Get user ID
                    //System.out.print("Please enter user ID: ");
                    //int userID_op3 = Integer.parseInt(sc.nextLine());
                    //Get new address
                    System.out.print("Please enter new Street Number: ");
                    int streetNum_op4 = Integer.parseInt(sc.nextLine());
                    System.out.print("Please enter new Street: ");
                    String streetNew_op4 = sc.nextLine();
                    System.out.print("Please enter new Suburb: ");
                    String suburbNew_op4 = sc.nextLine();
                    System.out.print("Please enter new City: ");
                    String cityNew_op4 = sc.nextLine();
                    Address newAddress = new Address(streetNum_op4, streetNew_op4, suburbNew_op4, cityNew_op4);
                    Address currentAdd = user_uMenu.getAddress();
                    System.out.println("The new address of user is: " + currentAdd.getAddress());
                    currentAdd.setAddress(newAddress);
                    System.out.println("The new address of user is: " + currentAdd.getAddress());
                    System.out.println("Please press any keys to continue: ");
                    sc.nextLine();
                    break;
                
                //Option 5: Total payment of all policies of user
                case 5:
                    System.out.println("The total payment of user is: " + user_uMenu.calcTotalPremiums1(user_uMenu.getUserNameLogin(), user_uMenu.getUserPassword(), flatRate));
                    System.out.println("Please press any keys to continue: ");
                    sc.nextLine();
                    break;
                //Option 6: Log out
                case 6:
                    System.out.print("Enter the policy ID you want to remove: ");
                    int policyID_op6 = Integer.parseInt(sc.nextLine());
                    if(user_uMenu.removePolicy(policyID_op6))
                    {
                        System.out.println("Successful to remove Policy with ID " + policyID_op6 + " from this user");
                    }
                    else
                    {
                        System.out.println("Policy ID does not exist in this user, please check again!");
                    }
                    System.out.println("Please press any keys to continue: ");
                    sc.nextLine();
                    break;
                
                //Option 7: Get list of car models of user
                case 7:
                    System.out.println("List of car model: " + user_uMenu.populateDistinctCarModels());
                    System.out.println("Please press any keys to continue: ");
                    sc.nextLine();
                    break;
                    
                //Option 8: Count policies this user own for given car model
                case 8:
                    System.out.println("Please enter Car model");
                    String carModel_op8 = sc.nextLine();
                    System.out.println("Number policies for " + carModel_op8 + " is: " + user_uMenu.getTotalCountForCarModel(carModel_op8));
                    System.out.println("Please press any keys to continue: ");
                    sc.nextLine();
                    break;
                    
                //Option 9: Total payment of all policies this user own for given car model    
                case 9:
                    System.out.println("Please enter Car model");
                    String carModel_op9 = sc.nextLine();
                    System.out.println("Total payment of all policies for " + carModel_op9 + " is: " + user_uMenu.getTotalPaymentForCarModel(carModel_op9, flatRate));
                    System.out.println("Please press any keys to continue: ");
                    sc.nextLine();
                    break;
                
                //Option 10: Generates report
                case 10:
                    ArrayList<String> carModels_op10 = new ArrayList<String>();
                    ArrayList<Integer> counts_op10 = new ArrayList<Integer>();
                    ArrayList<Double> premiumPayment_op10 = new ArrayList<Double>();
                    carModels_op10 = user_uMenu.populateDistinctCarModels();
                    counts_op10 = user_uMenu.getTotalCountPerCarModel(carModels_op10);
                    premiumPayment_op10 = user_uMenu.getTotalPaymentPerCarModel(carModels_op10, flatRate);
                    System.out.println("The report is: ");
                    user_uMenu.reportPaymentsPerCarModel(carModels_op10, counts_op10, premiumPayment_op10);
                    System.out.println("Please press any keys to continue: ");
                    sc.nextLine();
                    break;
                    
                //Option 11: Log out
                case 11:
                    break;
            }
        }
    }
    
    //Display User menu
    public static void displayUserMenu(){
        System.out.println("==================== Admin Menu ====================");
        System.out.println("1. Add a ThirdParty policy to user");
        System.out.println("2. Add a Comprehensive policy to user");
        System.out.println("3. Print a policy in user");
        System.out.println("4. Change user address");
        System.out.println("5. Print the total payment of all user's policies");
        System.out.println("6. Remove a policy from user");
        System.out.println("7. Get list of car models of user");
        System.out.println("8. Count policies this user own for given car model");
        System.out.println("9. Total payment of all policies this user own for given car model");
        System.out.println("10. Generates report about Car model and payments");
        System.out.println("11. Log out");
        System.out.println();
        System.out.println("Please choose an option from 1 to 11: ");
    }
}