import java.util.ArrayList;

public class ExceptionPracticeTest{
    public static void main(String[] args){
        ArrayList<Object> myList = new ArrayList<Object>();
        myList.add("13");
        myList.add("hello world");
        myList.add(48);
        myList.add("Goodbye World");

        ExceptionPractice caster = new ExceptionPractice();
        caster.castValue(myList);
    }
}