/*Jisoo Park
 * CIS 2168
 * TimedLab#2
 * 10/25/18
 */

package heap;

import java.util.ArrayList;

public class heap<E extends Comparable<E>> {

// Your task is to implement a heap using an ArrayList
// by completing the specified methods
	
// This is the underlying array
// refer to the Chapter 6 slides if you forget
// It's actually pretty easy if you follow the slides
// Don't overthink it.
	
private ArrayList<E> heap;
private int size;

public heap(){
	this.heap = new ArrayList<E>();
	this.size = 0;
}

// Problem Heap 1

// write a method that finds the index of an item's left child.

// The parameter parent in this method is the index of the parent element

// The left child's index is twice the parent's plus 1

private int leftIndex(int parent) {

int leftIndex ;

//complete this

leftIndex=(2*parent- 2);

return leftIndex;

}

// Problem Heap 2

// write a method that finds the index of an item's right child.

// The parameter parent in this method is the index of the parent element

// The right child's index is twice the parent's plus 2

private int rightIndex(int parent) {

int rightIndex ;

rightIndex=(2*parent+ 2);

return rightIndex;

}

// Problem Heap 3

// write a method that finds the index of an item's parent.

// The parameter child in this method is the index of the child element

// The parent's index is the child's -1 divided by two

private int parentIndex(int child) {

int parentIndex;   

parentIndex =(child-1)/2;

return parentIndex;

}

// Problem Heap 4 20 points

// Write a method that adds an item to the heap.

// To add an item to the heap, add it to the first empty spot in the arrayList

// Then while the item is smaller than it's parent, swap it with it's parent

// Remember, there are no gaps between items in the array

// You will need to use compareTo

// You do not need to worry about resizing the heap, since the ArrayList does that for you

public void add(E item) {
  
heap.add(size,item);

size++;

int loc = size-1; // and get its location

// Swap with parent until parent not larger

while (loc > 0 && heap.get(loc).compareTo(heap.get(parentIndex(loc))) < 0) {

swap(heap, loc, parentIndex(loc));

loc = parentIndex(loc);

}

}

// Swap two locations i and j in ArrayList a.

private static <E> void swap(ArrayList<E> a, int i, int j) {

E t = a.get(i);

a.set(i, a.get(j));

a.set(j, t);

}

  

public void print() {

System.out.println("Item Parent ");

for(int i=0;i<size;i++)

System.out.println(heap.get(i)+ "\t "+heap.get(parentIndex(i)));

  

  

}

  

public static void main(String[] args) {

  

heap<Integer> hp = new heap<>();

  

hp.add(23);

hp.add(12);

hp.add(8);

hp.add(52);

hp.add(43);

hp.add(71);

hp.add(65);

  

System.out.println(hp.size);

  

hp.print();

  

}

}