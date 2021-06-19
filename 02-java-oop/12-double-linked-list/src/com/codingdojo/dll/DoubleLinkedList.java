package com.codingdojo.dll;
// Java beans compliance
import java.io.Serializable;

public class DoubleLinkedList implements Serializable {
	
	private Node head;
	private Node tail;
	private int length;

	// no parameter constructor for Java beans compliance. 
	// not recommend for use
	public DoubleLinkedList() {
		this.head = null;
		this.tail = null;
		this.length = 0;
		
	}
	
	// 	constructor takes value and constructs first
	public DoubleLinkedList(int firstValue) {
		this.length = 0;
		this.push(firstValue);		
	}
	
	// add new nodes accommodating both empty and populated lists 
	public void push(int value) {
		if(head == null && tail == null) {
			Node newNode = new Node(value);
			this.head = newNode;
			this.tail = newNode;
		} else {
			Node newNode = new Node(value, this.tail);
			this.tail.setNext(newNode);
			this.tail = newNode;
		}
		this.length++;
	}
	
	public void push(Node node) {
		if(head == null && tail == null) {
			this.head = node;
			this.tail = node;
		} else {
			node.setPrevious(this.tail);
			this.tail.setNext(node);
			this.tail = node;
		}
		this.length++;
	}
	
	public void printValuesBackward() {
		Node runner = this.tail;
		while (runner.getPrevious() != null) {
			System.out.println(runner.getValue());
			runner = runner.getPrevious();
		}
		System.out.println(this.head.getValue());
	}
	
	public void printValuesForward() {
		Node runner = this.head;
		while (runner.getNext() != null){
			System.out.println(runner.getValue());
			runner = runner.getNext();
		}
		System.out.println(this.tail.getValue());
	}
	
	public Node pop() {
		Node popped = this.tail;
		this.tail = popped.getPrevious();
		this.tail.setNext(null);
		this.length--;
		return popped;
	}
	
	public boolean contains(Integer value) {
		boolean result = false;
		Node runner = this.head;
		while (runner.getNext() != null) {
			if(runner.getValue() == value) {
				return true;
			} else {
				runner = runner.getNext();
			}
		}
		if (tail.getValue() == value) {
			return true;
		} else {
			return false;
		}
	}
	
	public int size() {
		return this.length;
	}
	
	void insertAt(Node newNode, int index) {
		if(index > this.size() || index < 0) {
			System.out.println("Index must be between 0 and " + this.size());
			System.out.println("Unable to insert node, please try again with a valid index");
		} else {
			Node before = null;
			Node after = this.head;
			for(int i = 0; i < index; i++) {
				before = after;
				after = after.getNext();
			}
			if(before == null) {
				this.head = newNode;
				newNode.setNext(after);
				after.setPrevious(newNode);
			} else if (after == null) {
				newNode.setPrevious(this.tail);
				this.tail.setNext(newNode);
				this.tail = newNode;
			} else {
				before.setNext(newNode);
				newNode.setPrevious(before);
				newNode.setNext(after);
				after.setPrevious(newNode);
			}
			this.length++;
			
		}
	}
	
	void removeAt(int index) {
		if(index > this.size()-1 || index < 0) {
			System.out.println("Index must be between 0 and " + (this.size() - 1));
			System.out.println("Unable to remove since index is out of range");
		} else {
			Node target = this.head;
			for(int i = 0; i < index; i++) {
				target = target.getNext();
			}
			if(target.getPrevious() == null) {
				this.head = target.getNext();
				this.head.setPrevious(null);
				
			} else if (target.getNext() == null) {
				this.tail = target.getPrevious();
				this.tail.setNext(null);
			} else {
				target.getPrevious().setNext(target.getNext());
				target.getNext().setPrevious(target.getPrevious());
			}
			target.setNext(null);
			target.setPrevious(null);
			this.length--;
		}
	}


}
