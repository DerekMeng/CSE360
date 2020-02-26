/**
 * @author Hedong Meng
 * Class ID is 158 and assignment number is 2.
 */


package cse360assign2;

public class SimpleList {
	
	/**
	 * The SimpleList Class provided 9 methods to handle
	 * integer list and count.
	 */
	
	int[] list;
	int count;
	
	public SimpleList() {
		
		/**
		 * SimpleList method created an array to hold 10
		 * integers and set count to 0. 
		 */
		
		list = new int[10];
		count = 0;
	}
	
	public void add(int integer) {
		
		/**
		 * Add method added the parameter to the list at the
		 * beginning and moved all the other integers down 
		 * and incremented the count. If the list was full 
		 * then increase the size by 50%.
		 * 
		 * @param Integer the new element which will be added
		 * in the list.
		 */
		
		if(count == list.length) {
			double size = list.length + Math.floor(list.length * 0.5);
			int length = (int) size;
			int[] newList = new int[length];
			System.arraycopy(list, 0, newList, 1, list.length);
			newList[0] = integer;
			list = newList;
			count += 1;
		}
		else {
			
			System.arraycopy(list, 0, list, 1, list.length -1);
			list[0] = integer;
			count += 1;
		}
	}
	
	public void remove(int integer) {
		
		/**
		 * Remove method removed the parameter from the list
		 * if the parameter was in the list. The other element 
		 * would need to be move down and decreased the count.
		 * If the list has more than 25% empty places the decrease
		 * size of the list.
		 * 
		 * @param integer the element would be remove from the 
		 * list.
		 */
		
		int removeIntegerLocation = search(integer);
		if(removeIntegerLocation != -1) {
			System.arraycopy(list, removeIntegerLocation + 1, list, 
				removeIntegerLocation, 
					list.length - removeIntegerLocation - 1);
			list[list.length - 1] = 0;
			count -= 1;
		}
		
		double size = list.length - Math.floor(list.length * 0.25);
		int length  = (int) size;
		if(count <= length) {
			int[] newList = new int[count];
			System.arraycopy(list, 0, newList, 0, count);
			list = newList;
		}
	}
	
	public int count() {
		
		/**
		 * Count method calculated how many elements stored in the
		 * list. 
		 * 
		 * @return the number of elements stored in the list.
		 */
		
		int storingElement = 0;
		for(int item = 0; item < list.length; item++) {
			if(list[item] != 0) {
				storingElement += 1;
			}
		}
		return storingElement;
	}
	
	public String toString() {
		
		/**
		 * ToString method return a list as a String. The
		 * elements were separated by space.
		 * 
		 *  @return a list as a String.
		 */
		
		String output = "";
		output = output + "[";
		for(int item = 0; item < list.length; item++) {
			if(item == list.length -1) {
				output = output + list[item] + "]";
			}
			else {
				output = output + list[item] + " ";
			}
		}
		return output;
	}
	
	public int search(int integer) {
		
		/**
		 * Search method find the location of parameter.
		 * 
		 * @param integer the element would be searched from 
		 * the list.
		 * @return return the location of the parameter in the
		 * list. If the parameter was not in the list then
		 * return -1 for the location.
		 */
		
		int location = -1;
		for(int item = 0; item < list.length && location == -1; item++) {
			if(list[item] == integer) {
				location = item;
			}
		}
		return location;
	}
	
	public void append(int integer) {
		
		/**
		 * Append method work for adding a integer to the end of list and 
		 * increasing the count. If the list was full then increase the 
		 * size by 50%.
		 * 
		 * @param integer the element would be add in the list.
		 */
		
		if(count == list.length) {
			double size = list.length + Math.floor(list.length * 0.5);
			int length = (int) size;
			int[] newList = new int[length];
			System.arraycopy(list, 0, newList, 0, list.length);
			list = newList;
		}
		list[count] = integer;
		count +=1;
	}
	
	public int first() {
		
		/**
		 * The first method return the first element in the list.
		 * 
		 * @return the first element in the list.
		 */
		
		return list[0];
	}
	
	public int size() {
		
		/**
		 * The size method return the current number of possible location
		 * in the list.
		 * 
		 * @return the number of possible location.
		 */
		
		int possibleLocations = list.length - count;
		return possibleLocations;
	}
	
	
	
	

}
