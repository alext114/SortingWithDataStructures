/**********************************************************************
*
* The class ArrayStack uses an array to hold the
*  items in a stack.
* Stack operations are specified in the interface
*  StackInterface
*
* Question: Where should the top be: 0 or
*  lastIndex - 1?  Why?
*
***********************************************************************/

import java.util.*;

class ArrayStack<T> implements StackInterface<T>
{
   private T[] stackItems;
         // Array to hold items in stack
   private int topIndex;
         // Index of array slot AFTER top item
   private int itemCount;
   
  // Constructor - creates an empty stack
   public ArrayStack(int initialSize)
   {
      @SuppressWarnings("unchecked")
      T[] tempArray = (T[]) new Object[initialSize];
      stackItems = tempArray;
      itemCount=0;
      topIndex = stackItems.length-1;
      
   }
   
  // Pushes a new item onto stack 
   public void push(T newItem)
   {
	 ensureCapacity();
	 itemCount++;
	 topIndex--;
     stackItems[topIndex] = newItem;

   }
   
  // Pops and returns the top item on stack
  // Returns null if stack is empty
   public T pop() 
   {  
     if(isEmpty())
       return null;
     else
     {
       topIndex++;
       itemCount--;
       T returnItem = stackItems[topIndex-itemCount];
       stackItems[topIndex-itemCount] = null;
       return returnItem;
     }
   }
   
  // Returns top item on stack or null if stack is empty 
   public T peek()
   {
     if(isEmpty())
       return null;
     else
       return stackItems[topIndex]; 
   }
   
  // Returns true if the stack is empty 
   public boolean isEmpty()
   {
     if (topIndex == 0)
       return true;
     else
       return false;
   }
   
  // Removes all items from stack 
   public void clear()
   {
     // Null out array to aid garbage collector
     for(int index = 0; index < topIndex; index++)
       stackItems[index] = null;
       
     topIndex = 0;
     itemCount=0;
   }
   
  // Doubles size of stackItems when array is full
  // Allows stack to grow indefinitely
   private void ensureCapacity()
   {
     if(topIndex == stackItems.length)
       stackItems = Arrays.copyOf(stackItems,2*topIndex);
   }
}
