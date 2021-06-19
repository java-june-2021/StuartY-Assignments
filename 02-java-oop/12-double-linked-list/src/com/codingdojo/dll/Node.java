package com.codingdojo.dll;

import java.io.Serializable;
// Java beans compliance
public class Node implements Serializable {

// instance variables for a node intended for a double linked list
	private int value;
	private Node previous;
	private Node next;

// no parameter constructor for Java beans compliance	
	public Node() {
		this.value = 0;
		this.previous = null;
		this.next = null;
	}

// constructor for value only which should only be used for the first node in a double linked list
	public Node(int value) {
		this.value = value;
		this.previous = null;
		this.next = null;		
	}
	
// standard constructor in an existing list which passes the list tail as the previous	
	public Node(int value, Node previous) {
		this.value = value;
		this.previous = previous;
		this.next = null;		
	}

// getters	
	public int getValue() {
		return this.value;
	}
	
	public Node getPrevious() {
		return this.previous;
	}
	
	public Node getNext() {
		return this.next;
	}

// setters
	public void setValue(int value) {
		this.value = value;
	}
	
	public void setNext(Node next) {
		this.next = next;
	}
	
	public void setPrevious(Node previous) {
		this.previous = previous;
	}
	
	// Other methods
	
	public boolean isPalindrome() {
		String value = String.valueOf(this.value);
		int running = value.length();
		int end = value.length() -1;
		if(running % 2 == 0) {
			running = running / 2;
		} else {
			running = (running - 1) / 2;
		}
		
		for(int i = 0; i < running; i++) {
			if(value.charAt(i) != value.charAt(end-i)) {
				return false;
			}
		}
		return true;
	} 
	

}
