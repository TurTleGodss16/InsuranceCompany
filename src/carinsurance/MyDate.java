package carinsurance;
import java.io.Serializable;

//New class week 2 - MyDate
public class MyDate implements Cloneable, Comparable<MyDate>, Serializable {
    //Declare attributes of MyDate class
    private int year;
    private int month;
    private int day;
    //Constructor
    public MyDate(int year, int month, int day){
        this.year = year;
        this.month = month;
        this.day = day;
    }
    
    //Create Copy Constructor - WEEK 6 / LAB 4
    public MyDate(MyDate date){
        this.year = date.year;
        this.month = date.month;
        this.day = date.day;
    }
    
    //Get the date
    public String getDate(){
        return "Year: " + year + ", month:" + month + ", day: " + day;
    }
    
    public String toString(){
        return year + "/" + month + "/" + day;
    }
    
    //WEEK 3 CODE ADDED
    //Get year
    public int getYear(){
        return year;
    }
    //Get month
    public int getMonth(){
        return month;
    }
    //Get day
    public int getDay(){
        return day;
    }
    
    //WEEK 3 CODE ADDED
    //Check the date is expired or not
    public boolean isExpired(MyDate expiryDate){
        if(year > expiryDate.getYear())
        {
            return true;
        }
        else if(year == expiryDate.getYear())
        {
            if(month > expiryDate.getMonth())
            {
                return true;
            }
            else if(month == expiryDate.getMonth())
            {
                if(day > expiryDate.getDay())
                    return true;
                else if(day == expiryDate.getDay())
                    return false;
            }
        }
        return false;
    }
    
    //WEEK 6 - LAB 4
    //Cloneable Interface
    @Override
    public MyDate clone() throws CloneNotSupportedException{
        return (MyDate)super.clone();
    }
    
    //Comparable by expiry date
    public int compareTo(MyDate otherDate){
        if(year > otherDate.year)
        {
            return 1;
        }
        else if(year < otherDate.year)
        {
            return -1;
        }
        else
        {
            if(month > otherDate.month)
            {
                return 1;
            }
            else if(month < otherDate.month)
            {
                return -1;
            }
            else
            {
                if(day > otherDate.day)
                {
                    return 1;
                }
                else if(day < otherDate.day)
                {
                    return -1;
                }
                else
                {
                    return 0;
                }
            }
        }
    }
    
    //Delimited String - LAB 6
    public String toDelimitedString(){
        return year + "," + month + "," + day;
    }
}
