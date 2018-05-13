/*************************************************************
  NameListDriver -- driver to test an implementation of the
  SortableArrayList class by sorting a list of names
  
  @author J.W. Benham
*/

import java.util.*;


class RandomIntDriver
{
  @SuppressWarnings("resource")
public static void main(String args[])
  {  
     
	 // Set up scanner for keyboard input 
	 Scanner keyboard = new Scanner(System.in);
	 Random rGen = new Random();// set up random generator 
	 System.out.println("How many numbers do you want?");
	 int numOfInts=Integer.parseInt(keyboard.nextLine());
	 
	
	 //Decide which stack type to use
	 System.out.println("Which type of stack would you like to use? (A=array || L= linked list)");
	 String stackType=keyboard.nextLine();
	 
	 
	 System.out.println("Unsorted random numbers:");

	 
	 SortableArrayList<Integer> integerList
         = new SortableArrayListWithQuickSort<Integer>(stackType);
									 	  
	 
	 
	 
	 
	 //load random ints into the list
	 for (int i =0; i < numOfInts; i++ ){
		 integerList.append(rGen.nextInt(100)+1);
	 }
	  
	 
	 
	 // Print original list
	 System.out.println("\nThe numbers in their original order:\n");
    Iterator<Integer> integerListIterator = integerList.getIterator();
    
    while(integerListIterator.hasNext())
      System.out.println(integerListIterator.next());
      
    // Search in unsorted list
    boolean anotherSearch = true;
    int searchInt;
    
  
    while (anotherSearch)
    {
      System.out.print("Enter a number to search for: ");
      searchInt = Integer.parseInt(keyboard.nextLine());
      int position = integerList.search(searchInt);
      
      if (position != -1){
        System.out.println("Integer " + searchInt
                            + " found at position " + position);
      }
      else{
        System.out.println("Integer " + searchInt + " not in list");
      }// if
      
      System.out.print("Search again? (Y/N)");
      String another = keyboard.nextLine();
      if (another.charAt(0) == 'Y' || another.charAt(0) == 'y')
        anotherSearch = true;
      else
        anotherSearch = false;
    } // while(anotherSearch)  
	  
	 // Sort and print in order
	integerList.sort();

	System.out.println("\nThe numbers in order:\n");
   integerListIterator = integerList.getIterator();
   
   while(integerListIterator.hasNext())
     System.out.println(integerListIterator.next().toString());

   // Search in sorted list
   anotherSearch = true;
    
   while (anotherSearch)
   {
     System.out.print("Enter a integer to search for: ");
     searchInt = Integer.parseInt(keyboard.nextLine());
     int position = integerList.search(searchInt);
      
     if (position != -1)
       System.out.println("Integer " + searchInt
                           + " found at position " + position);
     else
       System.out.println("Integer " + searchInt + " not in list");
    
     System.out.print("Search again? (Y/N)");
    
     String another = keyboard.nextLine();
     if (another.charAt(0) == 'Y' || another.charAt(0) == 'y')
       anotherSearch = true;
     else
       anotherSearch = false;
   } // while(anotherSearch)  

  } // main
	
}
		 
	  