/****************************************************************
*  class SortableArrayListWithBubbleSort sorts a list of Comparable
*  items using the Bubble Sort algorithm
*
*  author: J.W. Benham
*
*****************************************************************/

class SortableArrayListWithBubbleSort<T extends Comparable<T>>
      extends SortableArrayListWithStack <T>
{

    // parameterized constructor
    public SortableArrayListWithBubbleSort(int capacity)
    {
       super(capacity);
    }
    
    // unparameterized constructor (default capacity)
    public SortableArrayListWithBubbleSort()
    {
       super();
    }
  
    

public SortableArrayListWithBubbleSort(String stackType) {
		// TODO Auto-generated constructor stub
	super(stackType);
	
	
	}

/* Sort sublist from lowIndex to highIndex using the
	   Bubble Sort algorithm
	*/
   protected void sortSubArray
                  (
                    T[] listItems,
                    int lowIndex,
                    int highIndex
                   )  
	{
     if (lowIndex < highIndex)
     {
       /*
         "Bubble" smallest value to listItem[lowIndex]
         by comparing adjacent list items and swapping
         them if they are out of order
       */
             
	    for (int i = highIndex; i > lowIndex; i--)
		 {
		   if (listItems[i-1].compareTo(listItems[i]) > 0)
         {
            T temp = listItems[i];
            listItems[i] = listItems[i-1];
            listItems[i-1] = temp;
         }
		 }
      
      // Smallest value is now at listItemp[lowIndex]
      // Recursively sort the rest of the list
      sortSubArray(listItems,lowIndex+1,highIndex);
    }
	}
}