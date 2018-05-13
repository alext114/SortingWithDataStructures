/******************************************************************
 * 
* The class LinkedStack uses a linked list to hold
*  the items in a stack.  The stack operations are
*  specified in the interface the StackInterface
*
* Question: Which end of the linked list should
*  serve as the top of the stack?
********************************************************************/

class LinkedStack<T> implements StackInterface<T>
{
  // Inner class Node
   class Node
   {
     private T item;
     private Node next;
     
     public Node(T item, Node next) {
        this.item = item;
        this.next = next;
     }
     
    //get and set methods
     public void setItem(T item)    {this.item = item;}
     public void setNext(Node next) {this.next = next;}
     public T getItem()             {return item;}
     public Node getNext()          {return next;}
  }
  
  private Node topNode;
   // Reference to node containing top item (first node in linked list)  
  
 // Constructor
  public LinkedStack()
  {
    topNode = new Node(null, topNode);
  }
     
 // Pushes item onto top   
  public void push (T item)
  {
     Node newTop = new Node(item,topNode.getNext());
     topNode = newTop;
  }
  
 // Pops and returns top item
 // Returns null if stack is empty
  public T pop ()
  {
    if(isEmpty())
      return null;
    else
    {
      T returnItem = topNode.getItem();
      topNode = topNode.getNext();
      return returnItem;
    }
  }
  
 // Returns top item, or null if stack is empty 
  public T peek()
  {
    if(isEmpty())
      return null;
    else
      return topNode.getItem();
  }
  
 // Returns true iff stack is empty 
  public boolean isEmpty()
  {
    return topNode == null;
  }
  
 // Removes all items from stack
  public void clear()
  {
    topNode = null;
    // NOTE: This makes every node in the linked list into garbage
  }
}
   
