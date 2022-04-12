//    @formatter:off
//
//    Digits2English.java
//
//    Carlos Valdez
//    McDaniel College
//    CSC-3365-01  Intermediate Java Programming
//    Spring 2018
//
//    Digits convert to words
//    4/18/18
//
//    Enter a line of strings, convert it to integer. Output integers to 
//    words in the same order.  
//    
//
//    ************ McDaniel Honor Code ***********************
//
//    I have neither given nor received unauthorized aid on
//    this piece of work, nor have I knowingly tolerated any
//    violation of the Honor Code.
//
//    ****************** History *****************************
//
//    original coding                  CVM      4/18/18
//    change implemented               CVM      3/21/18
//
//    @formatter:on

import java.util.Scanner;
import javax.swing.JOptionPane;


/**
 *
 * @author User
 */
public class Digits2English
   {

      String []     character;
      StringBuilder sb = new StringBuilder ();


      // convert String to Integer method.
      public void convert ()
         {
            // input
            String input = JOptionPane.showInputDialog ("Please enter a" +
                                                        " number:");

            // trim the spaces
            input = input.trim ();


            int con = 0;

            // split by space
            Scanner sc = new Scanner (input).useDelimiter (" ");
            while (sc.hasNext ())
               {
                  String text = sc.next ();
                  // check letters
                  if (text.matches ("[a-zA-Z]+"))
                     {
                        sb.append ("Errpr :" + text +
                                   " must be a valid integer.");
                        sb.append ("\n");
                     }
                  // valide numbers
                  else if (text.matches ("[0-9\\-\\ ]+"))
                     {
                        if (text.contains ("-"))
                           {
                              // print negative
                              sb.append ("Negative ");
                              text = text.replace ("-", "");
                           }
                        printDigits2Num (Integer.parseInt (text));
                     }
                  // check more than 10 numbers
                  else if (!text.matches ("[0-9]{10}+"))
                     {
                        sb.append ("Errpr :" + text +
                                   " must be a valid integer.");
                        sb.append ("\n");
                     }
                  sb.append ("\n");
               }

            // print number
            JOptionPane.showMessageDialog (null, sb);


         }


      // Separate the integer to separate digits.
      private void printDigits2Num (int num)
         {
            // String input = " ";
            // int remainder = 0;
            // get number length
            int length = String.valueOf (num).length ();

            // store values to array for get correct order
            int [] tempArray = new int [length];
            for (int x = length ; x > 0 ; x-- )
               {
                  tempArray [x - 1] = num % 10;
                  num = num / 10;
               }

            sb.append (switches (tempArray [0]));

            if (length > 1)     // remove printed values
               {
                  String temp = "";
                  for (int y = 1 ; y < length ; y++ )
                     {
                        temp = temp + String.valueOf (tempArray [y]);
                     }
                  num = Integer.parseInt (temp);
                  printDigits2Num (num);
               }
            /*
             * // get the last digit on the right (Gets 3 from 123)
             * remainder = num % 10;
             * 
             * // chops the last digit off (123 becomes 12)
             * num = num / 10;
             * 
             * // sends it to switch
             * input = switches (remainder);
             * 
             * //
             * sb.append (input);
             * 
             * // send back to the top
             * printDigits2Num (num);
             */
         }


      // Converts Digits to Strings.
      public static String switches (int reminder)
         {
            String retValue = null;

            switch (reminder)
               {
                  case 0:
                     retValue = "zero";
                     break;
                  case 1:
                     retValue = "one ";
                     break;
                  case 2:
                     retValue = "two ";
                     break;
                  case 3:
                     retValue = "three ";
                     break;
                  case 4:
                     retValue = "four ";
                     break;
                  case 5:
                     retValue = "five ";
                     break;
                  case 6:
                     retValue = "six ";
                     break;
                  case 7:
                     retValue = "seven ";
                     break;
                  case 8:
                     retValue = "eight ";
                     break;
                  case 9:
                     retValue = "nine ";
                     break;

               }// switch

            return retValue;

         }// Switches


      // Main method / repeats
      public static void main (String args[])
         {
            String dialogButton;
            do
               {
                  new Digits2English ().convert ();
                  dialogButton =
                               JOptionPane.showInputDialog (null,
                                "Would you like to search another name?" +
                                                "\n" + "Yes or NO");
               }// do

            while (dialogButton.equalsIgnoreCase ("yes"));

            JOptionPane.showMessageDialog (null, "Have a great day" + "\n" +
                                                 "Goodbye");
            System.exit (0);

         }// main

   }// Digits2English