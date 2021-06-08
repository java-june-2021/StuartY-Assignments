import java.util.ArrayList;
import java.util.Arrays;

public class BasicTest{
    public static void main(String[] args){
        Basic object = new Basic();

        object.print255();
        // good!

        object.odd255();
        // good!

        object.sum255();
        // good!

        int[] arrayTest = {1,3,5,7,9,13};
        object.arrayPrint(arrayTest);
        // good!

        int[] arrayTesta = {-3, -5, -7};
        object.arrayMax(arrayTesta);
        // good!

        int[] arrayTestb = {2, 10, 3};
        object.arrayAvg(arrayTestb);
        int[] arrayTestc = {2, 10, 3, 8, 9, 2};
        object.arrayAvg(arrayTestc);
        // good!

        ArrayList<Integer> arrList = new ArrayList<Integer>();
        arrList = object.odd255Array();
        System.out.println(arrList);
        // good!

        int[] arrayTestD = {1, 3, 5, 7};
        int arrayListResult = object.greaterThanY(arrayTestD, 3);
        System.out.println(arrayListResult);
        // good!

        int[] arrayTestE = {1, 5, 10, -2};
        System.out.println(Arrays.toString(arrayTestE));
        object.squareValues(arrayTestE);
        System.out.println(Arrays.toString(arrayTestE));
        // good!

        int[] arrayTestF = {1, 5, 10, -2};
        object.noNegatives(arrayTestF);
        System.out.println(Arrays.toString(arrayTestF));
        // good!

        int[] arrayTestG = {1, 5, 10, -2};
        ArrayList<Object> minMaxAvg = new ArrayList<Object>();
        minMaxAvg = object.minMaxAvg(arrayTestG);
        System.out.println(minMaxAvg);
        // good!

        int[] arrayTestH = {1, 5, 10, 7, -2};
        System.out.println(Arrays.toString(arrayTestH));
        object.shiftArray(arrayTestH);
        System.out.println(Arrays.toString(arrayTestH));
        // good!
        
    }
}