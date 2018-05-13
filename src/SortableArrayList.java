/**
  SortableArrayList is an abstract class that partially implements
  a sortable list of Comparable objects (i.e., objects that implement
  the Comparable interface) using arrays.
  
  It allows one to search for an object in either a sorted or an
  unsorted list
  
  This class also includes an inner class for an iterator
  
  @author James W. Benham
*/

import java.util.*;  // for Iterator interface

public abstract class SortableArrayList<T extends Comparable<T>>
{
   private T[] listItem;    // Array with items
	
	private int itemCount;   // Number of items in the list
	
	private static int DEFAULT_CAPACITY = 100;
      // Default initial array length (do not confuse with item count)

	private boolean isSorted;  // true if the list is known to be sorted
	
	// Constructs a list with the specified capacity
	public SortableArrayList(int capacity)
	{
	   @SuppressWarnings("unchecked")
	   T[] tempList = (T[]) new Comparable[capacity];
		listItem = tempList;
		itemCount = 0;
		isSorted = false;
		
   }

   // Constructs a list with the default capacity	
	public SortableArrayList()
	{
	   this(DEFAULT_CAPACITY);
	   
	}

/**
      Adds item to end of list
      <p>
	   pre-contition:<br> 
      itemCount < listItem.length() - 1
      <p>
		post-contition: <br>
      itemCount == itemCount@pre + 1
      AND
	   item added to end of list
	*/	
	public void append(T newItem)
	{
	  listItem[itemCount] = newItem;
	  itemCount++;
	  isSorted = false;  //List may no longer be sorted
	}
	
	/**
      Returns the list item in given position<br>
	   Returns null if position is out of range
	*/
	public T getItem(int position)
	{
	   if (0 <= position && position < itemCount)
		  return listItem[position];
		else
		  return null;
	}
	
	/**
     Returns length of list
   */
	public int getLength()
	{
	  return itemCount;
	}
	
   // inner class for an iterator through the list
   public Iterator<T> getIterator()
   {
     return new SortableArrayListIterator();
   }
   
	// Sorts the list
	public void sort()
	{
	  sortSubArray(listItem,0,itemCount-1);
     isSorted = true;
	}
	
	/*
      Sorts the array between lowIndex and highIndex (inclusive)
      This is an abstract method that will need to be implemented
      in a concrete subclass
   */
	abstract protected void sortSubArray
                           (
                             T[] listItems,
                             int lowIndex, 
                             int highIndex
                           );
   
   /**
      Searchs for the given value in the list
      Returns the index if the value is there and -1 if not
   */
   public int search(T value)
   {
     if(isSorted)
       return /*addr = C49F01EC */ binarySearch(value,0,itemCount-1);
     else
       return linearSearch(value);
   }
   
   // Searches through list item by item for given value
    private int linearSearch(T value)
    {
      int currentIndex = itemCount-1;
     
      while(currentIndex >= 0
            && !listItem[currentIndex].equals(value))
       currentIndex--;
     
     return currentIndex;
    }
    
   // Searches through sorted list using binary search
   // precondition: isSorted == true
    abstract protected int binarySearch(T value, int lowIndex, int highIndex);
    
    /*
     * Binary Search done through activation records
     * 
     * 
     * 
     */
    
    
    
    
   // Inner class for an Iterator over the list
   class SortableArrayListIterator implements Iterator<T>
   {
     private int currentIndex;  // index of current item
     
     // Inner class constructor
     public SortableArrayListIterator()
     {
       currentIndex = 0;   // start iteration at beginning
     }
     
     // Returns true iff list has another item 
     public boolean hasNext()
     {
       return currentIndex < itemCount;
     }
     
     // Returns next item in list
     public T next()
     {
       T currentItem = listItem[currentIndex];
       currentIndex++;
       return currentItem;
     }
     
     // Unsupported operation for this iterator - throw exception
     public void remove()
     {
       throw new UnsupportedOperationException();
     }
   } // inner class SortableArrayListIterator
    
} // class SortableArrayList