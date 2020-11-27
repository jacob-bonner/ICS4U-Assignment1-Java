/*
* This program tells the user the day of the
* week based on a date the user inputs.
*
* @author  Jacob Bonner
* @version 1.0
* @since   2020-11-25
*/

import java.util.Scanner;  // Import the Scanner class

public class DayOfWeek {
  /**
   * This function calculates the day of the week
   * based on a date the user inputs.
   */
  static String findWeekday(int date, int month, int year, 
                            int centuryCode, int addingNumber) {
    // This function calculates the day of the week
    //   given a date from the user

    // Calculating the number for the century code (first variable)
    int firstVariable = 0;
    if (centuryCode % 4 == 0) {
      firstVariable = 2;
    } else if (centuryCode % 4 == 1) {
      firstVariable = 0;
    } else if (centuryCode % 4 == 2) {
      firstVariable = 5;
    } else if (centuryCode % 4 == 3) {
      firstVariable = 3;
    } else {
      System.out.println("ERROR");
    }

    // Calculating the second variable
    int secondVariable = addingNumber / 12;

    // Calculating the third variable
    int thirdVariable = addingNumber % 12;

    // Calculating the fourth variable
    int fourthVariable = thirdVariable / 4;

    // Calculating final variable and reducing it to find the doomsday
    int fifthVariable = firstVariable + secondVariable 
                        + thirdVariable + fourthVariable;

    while (fifthVariable > 6) {
      fifthVariable = fifthVariable - 7;
    }

    // Finding the doomsday based on the month
    int doomsdayDate = 0;
    switch (month) {
      case 1:
        if (year % 4 == 0) {
          doomsdayDate = 4;
        } else {
          doomsdayDate = 3;
        }
        break;
      case 2:
        if (year % 4 == 0) {
          doomsdayDate = 29;
        } else {
          doomsdayDate = 28;
        }
        break;
      case 3:
        doomsdayDate = 14;
        break;
      case 4:
        doomsdayDate = 4;
        break;
      case 5:
        doomsdayDate = 9;
        break;
      case 6:
        doomsdayDate = 6;
        break;
      case 7:
        doomsdayDate = 11;
        break;
      case 8:
        doomsdayDate = 8;
        break;
      case 9:
        doomsdayDate = 5;
        break;
      case 10:
        doomsdayDate = 10;
        break;
      case 11:
        doomsdayDate = 7;
        break;
      case 12:
        doomsdayDate = 12;
        break;
      default:
        doomsdayDate = 0;
    }

    // This block finds a numeric value for the day of the week
    if (date < doomsdayDate) {
      while (date < doomsdayDate) {
        if (fifthVariable <= 0) {
          fifthVariable = 6;
          date = date + 1;
        } else {
          fifthVariable = fifthVariable - 1;
          date = date + 1;
        }
      }
    } else if (date > doomsdayDate) { 
      while (date > doomsdayDate) {
        if (fifthVariable >= 6) {
          fifthVariable = 0;
          date = date - 1;
        } else {
          fifthVariable = fifthVariable + 1;
          date = date - 1;
        }
      }
    } else {
      System.out.println("ERROR");
    }

    // This block finds the day of the week and returns its value
    String weekDayReturn = null;
    switch (fifthVariable) {
      case 0:
        weekDayReturn = "Sunday";
        break;
      case 1:
        weekDayReturn = "Monday";
        break;
      case 2:
        weekDayReturn = "Tuesday";
        break;
      case 3:
        weekDayReturn = "Wednesday";
        break;
      case 4:
        weekDayReturn = "Thursday";
        break;
      case 5:
        weekDayReturn = "Friday";
        break;
      case 6:
        weekDayReturn = "Saturday";
        break;
      default:
        weekDayReturn = null;
    }
    return weekDayReturn;
  }

  /**
   * This function allows the user to enter the date and will tell the user
   * the day of the week based on a date the user inputs.
   */
  public static void main(String[] args) {
    // Main function
    try {
      // Input for the date
      Scanner dateInput = new Scanner(System.in);
      System.out.println("Enter the date number:");
      int userDate = dateInput.nextInt();
      System.out.println();

      // Input for the month
      Scanner monthInput = new Scanner(System.in);
      System.out.println("Enter the month (number):");
      int userMonth = monthInput.nextInt();
      System.out.println();

      // Input for the year
      Scanner yearInput = new Scanner(System.in);
      System.out.println("Enter the year (four numbers):");
      String userYear = yearInput.nextLine();
      System.out.println();

      // Process
      // Splitting the year string in half to make for easier calculations
      String firstHalfYearStr = userYear.substring(0, (userYear.length() / 2));
      String secondHalfYearStr = userYear.substring((userYear.length() / 2));

      // Turning all year strings into integers
      int yearInteger = Integer.parseInt(userYear);
      int firstHalfYear = Integer.parseInt(firstHalfYearStr);
      int secondHalfYear = Integer.parseInt(secondHalfYearStr);

      // Calling the function that will calculate the day of the week
      String dayOfTheWeek = findWeekday(userDate, userMonth, yearInteger, 
                                        firstHalfYear, secondHalfYear);

      // Output
      System.out.println();
      System.out.println("The day of the week is " + dayOfTheWeek);

      // Catches and tells the user that an improper input was entered
    } catch (Exception e) {
      System.out.println();
      System.out.println("ERROR: Invalid Input");
    }
  }
}
