package Smith_Project3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
* COP 3530: Project 3 – Linked lists
* <p>
* This is the driver file that reads in 153 countries one at a time using buffered reader and if the country is between 1% and 10% CFR into a Linked List that operates as a stack. Once the Country objects are read into the stack
* then the stack is printed using a method in the stack object. Next, a loop runs as long as the stack is not empty and Country objects are removed one by one from the stack and then pushed back and forth
* between the beginning of the queue and the end. The Queue is a Doubly linked list acting as a Queue. Once the loop ends, the queue contents are printed using a method from the Queue object.
* <p>
* Then a method from the Queue object called intervalDelete takes two parameters and then deletes Links inside of the queue within the interval provided. The Queue is then printed again. Then Links are 
* removed from the queue using a while loop that removes them from the front then the end and then repeats until the queue is empty. When they are removed, they are pushed onto the stack. The Stack is then printed
* and the program ends.
*
* @author Nathanial Smith
* @version 10/25/2020
*/
public class Project3 {

	static Stack stack = new Stack();
	static Queue queue = new Queue();
	public static int search = 0;
		
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
			
		System.out.println("COP3530 Project3\nName: Nathanial Smith N01232886\nInstructor: Xudong Liu\nLinked Lists");
		System.out.printf("Enter the name of the file: ");
			
			
			
		BufferedReader read = null;
		String split = ",";
		String line = "";
			
			
		String name, capitol;
		Double gdp;
		Long population, cases, deaths;
		
		int i = 0;
		Country country;
		while(i == 0) {
				
			String file = input.nextLine();
			try {
				
				read = new BufferedReader(new FileReader(file));
				read.readLine();
				while ((line = read.readLine()) != null) {
					String[] countries = line.split(split);
					
					
					name = countries[0];
					capitol = countries[1];
					population = Long.parseLong(countries[2]);
					gdp = Double.parseDouble(countries[3]);
					cases = Long.parseLong(countries[4]);
					deaths = Long.parseLong(countries[5]);
					
					
					country = new Country(name, capitol, population, gdp, cases, deaths);

					if (country.Get_CFR() < .02 && country.Get_CFR() >= .01) {
						stack.pushFront(country);
					} else if (country.Get_CFR() < .05 && country.Get_CFR() >= .02) {
						stack.pushFront(country);
					} else if (country.Get_CFR() < .1 && country.Get_CFR() >= .05) {
						stack.pushFront(country);
					} 
						
					i++;
				}
					
					 
					
				read.close();
			}
			catch(FileNotFoundException e) {
				System.out.println("Can't open file");
				System.out.print("Enter the name of the file: ");
			}
			catch(IOException e) {
				System.out.println("Problem with reading file");
		
		
			}
		}
		
		stack.printStack();
		
		Country temp;
		Country temp2;

		while(stack.isEmpty() == false) {
			temp = stack.pop();
			queue.insertFront(temp);
			if(stack.isEmpty() == false) {
				temp2 = stack.pop();
				queue.insertEnd(temp2);
			}
			
		}
		queue.printQueue();
		queue.intervalDelete(.025, .035);
		queue.printQueue();
		
		while(queue.isEmpty() == false) {
			temp = queue.removeFront();
			stack.pushFront(temp);
			if(queue.isEmpty() == false) {
				temp2 = queue.removeEnd();
				stack.pushFront(temp2);
			}
		}
		stack.printStack();
		
	}

}