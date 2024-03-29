/**
 * Lab 02
 * @author Lab Group 7: Meghana Indukuri & Joseph Khamisy
 * This program is an user interactive program that allows user to do operations on dollar and pound objects.
 * July 11th 2022
 */
import java.util.Scanner;
public class Lab02Main {
    public static void main(String[] args) throws Exception {
        Currency[] primCurr = {new Pound(), new Dollar()};
        Scanner scn = new Scanner(System.in);
        System.out.println("\nWelcome to Assignment two:");
		System.out.println("You will have to enter 2 characters, one double, and one string seperated by spaces below.");
		System.out.println("Your first character should be a, s, or q. ");
		System.out.println(" a: Addition, s:Subtraction, q:Quit Program ");
		System.out.println("Your second character should be d(Dollars) or p(Pounds). ");
		System.out.println("Your double should be a valid currency amount. Any currency like: 67.8999 will be shortened to 67.89.");
		System.out.println("Your string should be either 'dollar' or 'pound'.");
		System.out.println("Here is an example: 'a d 0.23 dollar'.\n");
		System.out.println("-----");
		
		System.out.println(primCurr[0].toString());
        System.out.println(primCurr[1].toString());
        while (true) {
            System.out.println("\nPlease enter the input for the program below: ");
            String[] strArr;
            strArr = scn.nextLine().split(" ");
            if(strArr[0].equalsIgnoreCase("q")) {
                System.out.println("program exited");
                break;
            }
            if (strArr.length != 4) {
                System.out.println("invalid input:  must have 4 characters");
                continue;
            }

            char operation = strArr[0].toLowerCase().charAt(0);
            char currType = strArr[1].toLowerCase().charAt(0);
            double value;
            try
            {
                value = Double.parseDouble(strArr[2]);
            }
            catch(Exception e)
            {
                System.out.println("Incorrect input for program!");
                continue;
            }
            char currOper = strArr[3].toLowerCase().charAt(0);

            Currency val = null;

            if(currOper == 'p') {
            	try
            	{
            		val = new Pound(value);
            	}
            	catch(Exception e)
            	{
            		System.out.println(e.getMessage());
            		continue;
            	}
            }
            else if (currOper == 'd') {
            	try
            	{
            		val = new Dollar(value);
            	}
            	catch(Exception e)
            	{
            		System.out.println(e.getMessage());
            		continue;
            	}
            }
            else {
                System.out.println("Incorrect input for program.");
                continue;
            }
            switch(operation) {
                case 'a': {
                    if (currType == 'p') {
                        try {
                            primCurr[0].add(val);
                        }
                        catch(Exception e)
                        {
                            System.out.println(e.getMessage());
                        }
                    }
                else if(currType == 'd') {
                    try {
                        primCurr[1].add(val);
                    }
                    catch(Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                else {
                    System.out.println("Incorrect input for program.");
                    continue;
                }
                break;
            }
            case 's': {
                if (currType == 'p') {
                    try {
                        primCurr[0].subtract(val);
                    }
                    catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                else if(currType == 'd') {
                    try {
                        primCurr[1].subtract(val);
                    }
                    catch(Exception e) {
                    	System.out.println(e.getMessage());
                    }
                }
                else {
                    System.out.println("Incorrect input for program.");
                    continue;
                }
                break;
            }
            default:
            {
                System.out.println("Incorrect input for program");
                continue;
            }
        }

        System.out.println(primCurr[0].toString());
        System.out.println(primCurr[1].toString());
       }
    scn.close();
    }
}
