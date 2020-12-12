package Smith_Project3;
/**
* Link operates as a link object in a linked list. The Links point to the next Link since this link is designed to work in a
* singly linked list.
*
* @author Nathanial Smith
* @version 10/25/2020
*/
class Link {
	public Country country;
	public Link next;
	/**
	* This method acts as the constructor for the Link class. It takes in a Country object as a parameter
	*  and sets the class' Country object (country) equal to the value of of the passed in Country.
	*
	* @param Country country1 - A Country object that will act as the data being stored in the link
	*/
	public Link(Country country1) {
		country = country1;
	}
}
/**
* This class acts as a Stack implemented using a Double ended singly linked list. The constructor takes no parameters. There are methods to check if the stack is full or if it's empty. There is an push 
* Link at front or last, there is are pop from the stack, and a print the Stack method.
*
* @author Nathanial Smith
* @version 10/25/2020
*/
public class Stack {

	private Link first;
	private Link last;
	
	public Stack() {
		first = null;
		last = null;
	}
	/**
	* This method checks if the Stack is empty by returning whether the value of "first is == to null.
	* @return first == null - Returns true if first == null or false if it is not
	*/
	public boolean isEmpty() {
		return first == null;
	}
	/**
	* This method checks to see if the Stack is full, but since the Stack is implemented using a linked list, it can not fill up.
	* @return false - Returns false because a Linked list will never be full unless limited by memory
	*/
	public boolean isFull() {
		return false;
	}
	/**
	* This method inserts a link at the front of the linked list by creating a new link and passing in the country1 object as a parameter. Then if the queue is empty,
	* then last = country. Then country.next is set equal to first and first is equal to country.
	* @param Country country1 - a country object that will be passed into a link object as a parameter.
	*/
	public void pushFront(Country country1) {
		Link country = new Link(country1);
		if (isEmpty()) {
			last = country;
		}
		 country.next = first;
		 first = country;
	}
	/**
	* This method inserts a link at the end of the linked list by creating a new link and passing in the country1 object as a parameter. Then if the Stack is empty,
	* then first = country, otherwise last.next = country. Then last = country.
	* @param Country country1 - a country object that will be passed into a link object as a parameter.
	*/
	public void pushLast(Country country1) {
		Link country = new Link(country1);
		if (isEmpty()) {
			first = country;
		} else {
			last.next = country;
		}
		last = country;
	}
	/**
	* This method pops a link off of the linked list operating as a stack. It creates a temp Link that is set equal to first. If there is there is only one link left in the stack, then last is set equal to
	* null. then first is set equal to first.next and the pop method returns temp.country which is the Link being popped off of the stack.
	*
	* @return temp.country - the links hold Country objects as the data. temp is the name of the link and temp.country accesses and returns the Country object.
	*/
	public Country pop() {
		
		Link temp = first;
		if (first.next == null) {
			last = null;
		}
		first = first.next;
		return temp.country;
	}
	/**
	* This method prints the data of the links in the linked list. This Linked list is operating as a stack, so it prints first in last out using a while loop that loops 
	* as long as current is not == to null.
	*/

	public void printStack() {
		Link current = first;
		System.out.println("\nStack Contents:\n");
		System.out.println("Name                               Capitol              Population      GDP             Cases     Deaths");
        System.out.println("--------------------------------------------------------------------------------------------------------");
		while(current != null) {
			current.country.print_Countries();
			current = current.next;
		}
	}
	
}
