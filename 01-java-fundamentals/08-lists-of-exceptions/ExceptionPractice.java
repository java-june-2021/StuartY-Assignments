import java.util.ArrayList;

public class ExceptionPractice{
    public void castValue(ArrayList<Object> arr){

        for(int i = 0; i < arr.size(); i++) {
            try{
                Integer castedValue = (Integer) arr.get(i);
                System.out.println(arr.get(i) + " casted successfully.");
            } catch (ClassCastException e) {
                System.out.println("ERROR: " + arr.get(i) + " could NOT be casted!");
            }
        }
    }
}