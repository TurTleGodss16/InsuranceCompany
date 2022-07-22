/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carinsurance;

import java.util.*;
import java.util.regex.*;

public class PolicyHolderNameException extends Exception{
    private static String policyHolderName;
    
    public PolicyHolderNameException(String policyHolderName){
        this.policyHolderName = generateHolderName();
    }
    
    public static String getNewHolderName(){
        return policyHolderName;
    }
    
    public String generateHolderName(){
        String name = "";
        char x = ' ';
        for(int i = 0; i < policyHolderName.length(); i++)
        {
            if(Character.compare(policyHolderName.charAt(i), x) == 0)
            {
                break;
            }
            name += policyHolderName.charAt(i);
        }
        String name_temp = "";
        for(int i = policyHolderName.length() - 1; i >= 0; i--)
        {
            if(Character.compare(policyHolderName.charAt(i), x) == 0)
            {
                break;
            }
            name_temp += policyHolderName.charAt(i);
        }
        name += " ";
        for(int i = name_temp.length() - 1; i >= 0; i--)
        {
            name += name_temp.charAt(i);
        }
        return name;
    }
    //Create an Error message
    public String toString(){
        return "Policy Holder Name " + policyHolderName + " is Not Valid";
    }
}

