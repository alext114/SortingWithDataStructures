

class SortableArrayListWithQuickSort<T extends Comparable<T>> 
extends SortableArrayListWithStack <T>
{




	public SortableArrayListWithQuickSort(int capacity){
		super(capacity);
	}



	public SortableArrayListWithQuickSort(){
		super();

	}


		public SortableArrayListWithQuickSort(String stackType) {
		// TODO Auto-generated constructor stub
			super(stackType);
			
	}



		/**
	     * @param  num  an array of numbers in any order
	     * @return      a sorted array of the same numbers
	     **/
	
		protected void sortSubArray(T[] listItems,int lowIndex, int highIndex) {	

	             
	    	        int i = lowIndex;
	    	        int j = highIndex;
	    	        // calculate pivot number, I am taking pivot as middle index number
	    	        T pivot = listItems[lowIndex+(highIndex-lowIndex)/2];
	    	        // Divide into two arrays
	    	        while (i <= j) {
	    	            /**
	    	             * In each iteration, we will identify a number from left side which
	    	             * is greater then the pivot value, and also we will identify a number
	    	             * from right side which is less then the pivot value. Once the search
	    	             * is done, then we exchange both numbers.
	    	             */
	    	            while (listItems[i].compareTo(pivot) < 0) {
	    	                i++;
	    	            }
	    	            while (listItems[j].compareTo(pivot) >0) {
	    	                j--;
	    	            }
	    	            if (i <= j) {
	    	                exchangeNumbers(listItems,i, j);
	    	                //move index to next position on both sides
	    	                i++;
	    	                j--;
	    	            }
	    	        }
	    	        // call quickSort() method recursively
	    	        if (lowIndex < j)
	    	            sortSubArray(listItems, lowIndex, j);
	    	        if (i < highIndex)
	    	            sortSubArray(listItems, i, highIndex);
	    	    }
	    	 
	    	    private void exchangeNumbers(T[] listItems,int i, int j) {
	    	        T temp = listItems[i];
	    	        listItems[i] = listItems[j];
	    	        listItems[j] = temp;
	    	    }
	    	}


	    

	