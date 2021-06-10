public class ListTester {
    public static void main(String[] args) {
        SinglyLinkedList sll = new SinglyLinkedList();
        sll.add(3); // test the add method
        sll.add(4);
        sll.add(10);
        sll.add(5);
        sll.add(15);
        sll.add(2);
        sll.printValues(); // test that the ssl has taken the values and are outputting in the right order
        sll.remove(); //test the remove method
        sll.remove();
        sll.printValues(); //second print call to make sure the remove function is working properly

        //cycle from 3 to 10 to test find method:
        for(int i = 3; i <= 10; i++){ 
            System.out.println(sll.find(i));
        }

        sll.removeAt(2);
        sll.printValues();
    }
}
