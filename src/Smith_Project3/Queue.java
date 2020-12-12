package Smith_Project3;

/**
* Link2 operates as a link object in a linked list. The Links point to the next Link and the previous link since this link is designed to work in a
* Doubly linked list.
*
* @author Nathanial Smith
* @version 10/25/2020
*/
class Link2 {
	public Country country;
	public Link2 next;
	public Link2 previous;
	/**
	* This method acts as the constructor for the Link2 class. It takes in a Country object as a parameter
	*  and sets the class' Country object (country) equal to the value of of the passed in Country.
	*
	* @param Country country1 - A Country object that will act as the data being stored in the link
	*/
	public Link2(Country country1) {
		country = country1;
	}
}
/**
* This class acts as a Queue implemented using a Double ended doubly linked list. The constructor takes no parameters. There are methods to check if the queue is full or if it's empty. There is an insert 
* Link at front or back, there is are remove front or end link methods, print the Queue method and an interval deletion method that deletes links if they are within a specified interval.
*
* @author Nathanial Smith
* @version 10/25/2020
*/
public class Queue {
	private Link2 first;
	private Link2 last;
	/**
	* This is the constructor of the Queue class, it sets first and last equal to null.
	*/
	public Queue() {
		first = null;
		last = null;
	}
	/**
	* This method checks if the Queue is empty by returning whether the value of "first is == to null.
	* @return first == null - Returns true if first == null or false if it is not
	*/
	public boolean isEmpty() {
		return first == null;
	}
	/**
	* This method checks to see if the queue is full, but since the queue is implemented using a linked list, it can not fill up.
	* @return false - Returns false because a Linked list will never be full unless limited by memory
	*/
	public boolean isFull() {
		return false;
	}
	/**
	* This method inserts a link at the front of the linked list by creating a new link and passing in the country1 object as a parameter. Then if the queue is empty,
	* then last = country, otherwise first.previous = country. then country.next is set equal to first and first equals country.
	* @param Country country1 - a country object that will be passed into a link object as a parameter.
	*/
	public void insertFront(Country country1) {
		Link2 country = new Link2(country1);
		if (isEmpty()) {
			last = country;
		} else {
			first.previous = country;
		}
		country.next = first;
		first = country;
	}
	/**
	* This method inserts a link at the end of the linked list by creating a new link and passing in the country1 object as a parameter. Then if the queue is empty,
	* then first = country, otherwise last.next = country. then country.previous is set equal to last and last equals country.
	* @param Country country1 - a country object that will be passed into a link object as a parameter.
	*/
	public void insertEnd(Country country1) {
		Link2 country = new Link2(country1);
		 if (isEmpty()) {
			 first = country;
		 } else {
			 last.next = country;
			 country.previous = last;
		 }
		 last = country;
	}
	/**
	* This method removes the front link of the queue. Once the link is removed the data is returned using the Link temp. temp holds the country data, so we return temp.country to make the return value
	* a Country object.
	*
	* @return temp.country - the links hold Country objects as the data. temp is the name of the link and temp.country accesses and returns the Country object.
	*/
	public Country removeFront() {
		Link2 temp = first;
		if(first.next == null) {
			last = null;
		} else {
			first.next.previous = null;
		}
		first = first.next;
		return temp.country;
	}
	/**
	* This method removes the End link of the queue. Once the link is removed the data is returned using the Link temp. temp holds the country data, so we return temp.country to make the return value
	* a Country object.
	*
	* @return temp.country - the links hold Country objects as the data. temp is the name of the link and temp.country accesses and returns the Country object.
	*/
	public Country removeEnd() {
		Link2 temp = last;
		if (first.next == null) {
			first = null;
		} else {
			last.previous.next = null;
		}
		last = last.previous;
		return temp.country;
	}
	/**
	* This method prints the data of the links in the linked list. This Linked list is operating as a queue, so it prints first in first out (front to end) using a while loop that loops until the Linked
	* List is empty.
	*
	*/
	public void printQueue() {
		System.out.println("\nQueue contents:\n");
		Link2 current = first;
		System.out.println("Name                               Capitol              Population      GDP             Cases     Deaths");
        System.out.println("--------------------------------------------------------------------------------------------------------");
		while(current != null) {
			current.country.print_Countries();
			current = current.next;
		}
	}
	/**
	* This method takes two parameters as input, val1 being the lower bounds of the interval and val2 being the upperbounds. A interval is created and if a Link's Country object's CFR is in the interval,
	* then the link is deleted from the linked list. And a loop iterates through the whole linked list until current is null.
	* @param Double val1 - this parameter acts as the lower bounds of the interval to be created
	* @param Double val2 - this parameter acts as the upper bounds of the interval to be created
	*/
	public void intervalDelete(Double val1, Double val2) {
		Link2 current = first;
		while(current != null) {
			if(current.country.Get_CFR() > val1 && current.country.Get_CFR() < val2) {
				if(current == first) {
					first = current.next;
				} else {
					current.previous.next = current.next;
				}
				if(current == last) {
					last = current.previous;
				} else {
					current.next.previous = current.previous;
				}
			}
			current = current.next;
		}
		
	}
	
}
