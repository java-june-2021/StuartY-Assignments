public class SinglyLinkedList {
    public Node head;
    public SinglyLinkedList() {
        this.head = null;
    }

    public void remove(){
        //remove last node from list
        System.out.println("Remove method successfully called");
        if(head.next == null){
            head = null;
        } else {
            Node runner = head.next;
            Node previous = head;
            while(runner.next != null){
                previous = runner;
                runner = runner.next;
            }
            previous.next = null;
        }
    }

    public void printValues(){
        //print the values of every node in the list in order
        System.out.println(head.value);
        Node runner = head.next;
        while(runner.next != null){
            System.out.println(runner.value);
            runner = runner.next;
        }
        System.out.println(runner.value);
    }


    // SLL methods go here. As a starter, we will show you how to add a node to the list.
    public void add(int value) {
        Node newNode = new Node(value);
        if(head == null) {
            head = newNode;
        } else {
            Node runner = head;
            while(runner.next != null) {
                runner = runner.next;
            }
            runner.next = newNode;
        }
    }

    public Node find(int value){
        if(head.value == value){
            return head;
        } else {
            Node runner = head.next;
            while(runner.next != null){
                if(runner.value == value){
                    return runner;
                } else {
                    runner = runner.next;
                }
            }
            if(runner.value == value){
                return runner;
            }
        }
        System.out.println("Node with value not found");
        return null;
    }

    public void removeAt(int index){
        Node runner = head;
        if(index == 0){
            head = runner.next;
        } else {
            for(int i = 1; i < index; i++){
                if(runner.next == null){
                    i = index;
                    runner = null;
                } else {
                    runner = runner.next;
                }
                
            }
            if(runner == null){
                System.out.println("Index out of range, cannot remove requested Node");
            } else {
                Node replacement = runner.next.next;
                runner.next = replacement;
            }
        }
        

        
    }

}
