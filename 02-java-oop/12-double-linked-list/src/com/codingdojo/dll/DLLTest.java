package com.codingdojo.dll;

public class DLLTest {

	public static void main(String[] args) {

        DoubleLinkedList dll = new DoubleLinkedList();
        Node n1 = new Node(1238321);
        Node n2 = new Node(20);
        Node n3 = new Node(50);
        Node n4 = new Node(60);
        Node n5 = new Node(80);
        Node n6 = new Node(100);
        
        dll.push(n1);
        dll.push(n2);
        dll.push(n3);
        dll.push(n4);
        dll.push(n5);
        dll.push(n6);
        
        dll.printValuesForward();
        
        dll.printValuesBackward();
        
        System.out.println(dll.size());
        System.out.println(dll.contains(100));
        
        System.out.println(dll.pop().getValue());
        
        dll.printValuesForward();
        System.out.println(dll.size());
        
        System.out.println(dll.contains(100));
        System.out.println(n1.isPalindrome());
        
        Node newHead = new Node(22);
        Node newSecond = new Node(152);
        Node newTail = new Node(999);
        
        System.out.println("Created a new node (22) to add at the head");
        dll.insertAt(newHead, 0);
        System.out.println("New list:");
        dll.printValuesForward();
        System.out.println("Created a new node (152) to insert in 2nd place (index 1)");
        dll.insertAt(newSecond, 1);
        System.out.println("New List:");
        dll.printValuesForward();
        System.out.println("New list size:");
        System.out.println(dll.size());
        System.out.println("Adding new node (999) to tail \n");
        dll.insertAt(newTail, 7);
        dll.printValuesForward();
        System.out.println("Adding node to invalid index: \n");
        dll.insertAt(new Node(99), 88);
        
        System.out.println("\n \n");
        dll.printValuesForward();
        System.out.println("Removing node at index 5:");
        dll.removeAt(5);
        System.out.println("New length: " + dll.size());
        System.out.println("New list: ");
        dll.printValuesForward();
        
        System.out.println("Removing node at tail (index 6):");
        dll.removeAt(6);
        System.out.println("New length: " + dll.size());
        System.out.println("New list: ");
        dll.printValuesForward();
        
        System.out.println("Removing node at head (index 0):");
        dll.removeAt(0);
        System.out.println("New length: " + dll.size());
        System.out.println("New list: ");
        dll.printValuesForward();
        
        System.out.println("Removing node at invalid index (index 88):");
        dll.removeAt(88);
        System.out.println("New length: " + dll.size());
        System.out.println("New list: ");
        dll.printValuesForward();
        
        
       
        

        
    }
}

