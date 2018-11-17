/* Jisoo Park
 * CIS 2168 
 * Andrew Rosen
 * September 13, 2018
 */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TimedLab1 {

    public static int numberOfVowels(List<String> list){
    	String str;
    	char ch;
    	int count = 0;
    		for(int i = 0; i < list.size(); ++i) {
    			str = list.get(i).toLowerCase();
    			for(int j = 0; j < str.length(); ++j) {
    				ch = str.charAt(j);
    	                if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
    	                    count++;
    	                }
    	            }
    	        }
    	        return count;
    	    }
    
    
    public static <T> List<T> interweave(List<T> listA, List<T> listB){
        List<T> combined = new ArrayList<>();
        	int size = 0;
        		while (size < listA.size() && size<listB.size()){
        		combined.add(listA.get(size));
        		combined.add(listB.get(size));
        		size++;
        }
        while (size < listA.size()){
            combined.add(listA.get(size));
            size++;
        }
        while (size < listB.size()){
            combined.add(listB.get(size));
            size++;
        }
        return combined;
    }
    public static <T> void print(List<T> list){
        for(int i = 0;i<list.size();i++){
            System.out.print(list.get(i)+" ");
        }
        System.out.println();
    }
    
  
     public static int getIndexOfSmallest(List<Integer> list, int index) {
    	 int smallest = index;
    	 for(int i = index; i < list.size(); ++i) {
    		 if(list.get(i) < list.get(smallest)) {
    			 smallest = i;
    	            }
    	        }
    	        return smallest;
    	}
    	
    
    
    public static int[] selectionSort(int[] arr){

    	for (int i = 0; i < arr.length - 1; i++)
    	{
    	int index = i;
    	for (int j = i + 1; j < arr.length; j++)
    	if (arr[j] < arr[index])
    	index = j;
    	  
    	int smallerNumber = arr[index];  
    	arr[index] = arr[i];
    	arr[i] = smallerNumber;
    	}
    	return arr;
    	}

    	public static void main(String a[]){
    		
    	System.out.println(numberOfVowels(Arrays.asList("Hello", "a", "to", "Average")));

    	List<Integer> list1 = Arrays.asList(1,3,5,7);
        List<Integer> list2 = Arrays.asList(2,4,6,8,10,12);
        print(interweave(list1,list2));
        List<String> list3 = Arrays.asList("A","P","Q");
        List<String> list4 = Arrays.asList("!",".","Z");
        print(interweave(list3,list4));
    	
        System.out.println(getIndexOfSmallest(Arrays.asList(4, 2, 1, 5, 9, 8), 0));
        System.out.println(getIndexOfSmallest(Arrays.asList(4, 2, 1, 5, 9, 8), 1));
        System.out.println(getIndexOfSmallest(Arrays.asList(4, 2, 1, 5, 9, 8), 2));
        System.out.println(getIndexOfSmallest(Arrays.asList(4, 2, 1, 5, 9, 8), 3));
    
        int[] arr1 = {10,34,2,56,7,67,88,42};
    	int[] arr2 = selectionSort(arr1);
    	for(int i:arr2){
    	System.out.print(i);
    	System.out.print(", ");
    		
    	}
    }  	
}