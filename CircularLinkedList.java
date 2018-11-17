//Jisoo Park
 
package JoesphusAssignment;

import java.util.Iterator;

class CircularLinkedList<E> implements Iterable<E> {

   // Your variables
   // You can include a reference to a tail if you want
   Node<E> head;
   int size; // BE SURE TO KEEP TRACK OF THE SIZE

   // implement this constructor
   public CircularLinkedList() {
       head = null;
   }

   // writing helper functions for add and remove, like the book did can help
   // but remember, the last element's next node will be the head!

   // attach a node to the end of the list
   // Be sure to handle the adding to an empty list
   // always returns true
   public boolean add(E e) {
       Node<E> newNode = new Node<E>(e);
       if (size == 0) {
           head = newNode;
       } else {
           Node<E> last = getNode(size - 1);
           last.next = newNode;
       }
       newNode.next = head; // last element node is set to head
       size++;
       return true;
   }

   // need to handle
   // out of bounds
   // empty list
   // adding to front
   // adding to middle
   // adding to "end"
   // REMEMBER TO INCREMENT THE SIZE
   public boolean add(int index, E e) {
       if (index > size)
           return false;
       Node<E> tmp = new Node<E>(e);
       if (index == 0) {
           tmp.next = head;
           Node<E> last = getNode(size - 1);
           head = tmp;
           last.next = head;
       } else {
           Node<E> curr = getNode(index - 1);
           tmp.next = curr.next;
           curr.next = tmp;
       }
       size++;
       return true;
   }

   // I highly recommend using this helper method
   // Return Node<E> found at the specified index
   // be sure to handle out of bounds cases
   private Node<E> getNode(int index) {
       Node<E> prev = head;
       for (int i = 0; i < size && index < size; i++) {
           if (i == index) {
               return prev;
           }
           prev = prev.next;
       }
       return null;
   }

   // remove must handle the following cases
   // out of bounds
   // removing the only thing in the list
   // removing the first thing in the list (need to adjust the last thing in
   // the list to point to the beginning)
   // removing the last thing (if you have a tail)
   // removing any other node.
   // REMEMBER TO DECREMENT THE SIZE
   public E remove(int index) {
       E e;
       if (index > size) {
           e = null;
       } else if (index == 0) {
           e = head.getElement();
           Node<E> last = getNode(size - 1);
           head = head.next;
           last.next = head;
           size--;
       } else {
           Node<E> prev = getNode(index - 1);
           Node<E> curr = getNode(index);
           e = curr.getElement();
           prev.next = curr.next;
           size--;
       }
       return e;
   }

   // Turns your list into a string
   // Useful for debugging
   public String toString() {
       Node<E> current = head;
       StringBuilder result = new StringBuilder();
       if (size == 0) {
           return "";
       }
       if (size == 1) {
           return head.getElement().toString();

       } else {
           do {
               result.append(current.getElement());
               result.append(" ==> ");
               current = current.next;
           } while (current != head);
       }
       return result.toString();
   }

   public Iterator<E> iterator() {
       return new ListIterator<E>();
   }

   // provided code
   // read the comments to figure out how this works and see how to use it
   // you should not have to change this
   // change at your own risk!
   private class ListIterator<E> implements Iterator<E> {

       Node<E> nextItem;
       Node<E> prev;
       int index;

       @SuppressWarnings("unchecked")
       // Creates a new iterator that starts at the head of the list
       public ListIterator() {
           nextItem = (Node<E>) head;
           index = 0;
       }

       // returns true if there is a next node
       // this is always should return true if the list has something in it
       public boolean hasNext() {
           // TODO Auto-generated method stub
           return size != 0;
       }

       // advances the iterator to the next item
       // handles wrapping around back to the head automatically for you
       public E next() {
           // TODO Auto-generated method stub
           prev = nextItem;
           nextItem = nextItem.next;
           index = (index + 1) % size;
           return prev.getElement();

       }

       // removed the last node was visted by the .next() call
       // for example if we had just created a iterator
       // the following calls would remove the item at index 1 (the second
       // person in the ring)
       // next() next() remove()
       public void remove() {
           int target;
           if (nextItem == head) {
               target = size - 1;
           } else {
               target = index - 1;
               index--;
           }
           CircularLinkedList.this.remove(target); // calls the above class
       }

   }
}

class Node<E> {

   E element;
   Node<E> next;

   public Node() {

       this.element = null;
       this.next = null;

   }

   public Node(E e) {
       this.element = e;
       this.next = null;
   }

   public E getElement() {
       return this.element;
   }

   public void setElement(E element) {
       this.element = element;
   }

}

public class Test {
   public static void main(String[] args) {
       CircularLinkedList<Integer> l = new CircularLinkedList<Integer>();

       // int n;
       int k;
       for (int n = 1; n <= 5; n++)
           l.add(n);

       System.out.println(l.toString());
       l.remove(1);
       System.out.println(l.toString());
       l.remove(2);
       System.out.println(l.toString());
       l.remove(0);
       System.out.println(l.toString());
       l.remove(1);
       System.out.println(l.toString());

       /*
       * // use the iterator to iterate around the list Iterator<Integer> iter
       * = l.iterator(); while (l.size > 1) {
       *
       * for (int i = 0; i < 2; i++) iter.next();
       *
       * System.out.println("Element:" + iter.next());
       *
       * iter.remove(); }
       */}

}
