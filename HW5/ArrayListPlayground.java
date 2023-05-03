package HW5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class ArrayListPlayground {
    public static void main(String[] args) {
    System.out.println("Homework 5: John Neil M. Dela Peña");
    // Question 1
    // Write Java statements that do the following:
    // a) Declare an arrayList nums of 15 elements of type int.
    // b) Output the value of the tenth element of the array nums.
    // c) Set the value of the 5th element of the array nums to 99.
    // d) set the value of the 13th element to 15
    // d) set the value of the 2nd element to 6
    // d) Set the value of the 9th element of the array nums to the sum of the 13th and 2nd elements of the array nums.
    System.out.println("==================================");
    System.out.println("Question 1:");
    ArrayList<Integer> nums = new ArrayList<Integer>(15); // a)
    for (int i = 0; i < 15; i++) {
        nums.add(i);
    }
    System.out.println("The tenth element is " + nums.get(9)); // b)

    nums.set(4, 99); // c)
    System.out.println("The fifth element is " + nums.get(4));

    nums.set(12, 15); // d)
    System.out.println("The thirteenth element is " + nums.get(12));

    nums.set(1, 6); // e)
    System.out.println("The second element is " + nums.get(1));

    nums.set(8, nums.get(12) + nums.get(1)); // f)
    System.out.println("The ninth element is the addition of the thirteenth and second element which is " + nums.get(8));
    System.out.println("==================================");

         
    // Question 2
    // a) create an arrayList of Strings that contain each day of the week.(starting on monday)
    // b) output each of the days of the week
    // c) output the days of the week that we have class 
    // d) change the arrayList to start on Sunday
    System.out.println("==================================");
    System.out.println("Question 2:");
    ArrayList<String> days = new ArrayList<String>(Arrays.asList("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")); // a)
    System.out.println("Days of the week: " + days); // b)
    System.out.println("We have class on " + days.get(1) +"'s" + " and " + days.get(3) + "'s"); // c)
    String temp = days.remove(6); // Remove Sunday from end
    days.add(0, temp); // Add Sunday to beginning
    System.out.println("New Order of Array: " + days); // d)
    System.out.println("==================================");

    // Question 3 
    // a) create an ArrayList and prompt the user for numbers to add to it until the number 0 is selected
    // b) return the largest and smallest number
    // c) return the ArrayList sorted smallest to largest
    // d) take that ArrayList see if its size is divisable by 3 and then output the ArrayList in a matrix format
    // NOTE: make the matrix n X 3 so it can be n rows by 3 columns 
    // EX. ArrayList [1,2,3,4,5,6,7,8,9]
    // 1 2 3
    // 4 5 6
    // 7 8 9
    // NOTE: If the ArrayList is NOT divisable by 3 ask the user for more numbers and add them until it is
    // ArrayList Size: 7
    // Please enter 2 more numbers to create the matrix...
    // 
    // Hint 1: use collections sort to sort the numbers 
    // Hint 2: you can see if the size of the array list is divisible by 3 by running:
    //  numbers.size()%3==0
    // Hint 3: You can use this logic to print the array list in a 3x3 pattern once its created:
    // for(int i=0;i<numbers.size();i++)
    //     {
    //         System.out.print(numbers.get(i)+" ");
    //         if((i+1)%3==0)
    //         {
    //             System.out.println();
    //         }
    //     }
    System.out.println("==================================");
    System.out.println("Question 3:");
    ArrayList<Integer> numbers = new ArrayList<Integer>();
    Scanner input = new Scanner(System.in);
    int num = 1;
    while (num != 0) {
        System.out.println("Please enter a number to add to the ArrayList (0 to exit): ");
        num = input.nextInt();
        if (num != 0) {
            numbers.add(num);
        }
    }
    System.out.println("The largest number is: " + Collections.max(numbers));
    System.out.println("The smallest number is: " + Collections.min(numbers));
    Collections.sort(numbers);
    System.out.println(numbers);
    while (numbers.size() % 3 != 0) {
        System.out.println("ArrayList Size: " + numbers.size());
        System.out.println("Please enter " + (3 - (numbers.size() % 3)) + " more numbers to create the matrix...");
        num = input.nextInt();
        numbers.add(num);
    }
    for (int i = 0; i < numbers.size(); i++) {
        System.out.print(numbers.get(i) + " ");
        if ((i + 1) % 3 == 0) {
            System.out.println();
        }
    }
    System.out.println("==================================");
   

}


}


   

