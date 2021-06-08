import java.util.ArrayList;

public class Basic{
    public void print255(){
        for(int i = 1; i <= 255; i++){
            System.out.println(i);
        }
    }

    public void odd255(){
        for(int i = 1; i <= 255; i += 2){
            System.out.println(i);
        }
    }

    public void sum255(){
        int sum = 0;
        for(int i = 0; i <= 255; i++){
            sum += i;
            System.out.println(String.format("New Number: %d Current Sum: %d", i, sum));
        }
    }

    public void arrayPrint(int[] arr){
        for(int i : arr){
            System.out.println(i);
        }
    }

    public void arrayMax(int[] arr){
        int max = arr[0];
        for(int i : arr){
            if(i > max){
                max = i;
            }
        }
        System.out.println(max);
    }

    public void arrayAvg(int[] arr){
        double sum = 0;
        for(int i : arr){
            sum += i;
        }
        double avg = sum/arr.length;
        System.out.println(avg);
    }

    public ArrayList odd255Array(){
        ArrayList<Integer> y = new ArrayList<Integer>();
        for(int i = 1; i <= 255; i+= 2){
            y.add(i);
        }
        return y;
    }

    public int greaterThanY(int[] arr, int Y){
        int sum = 0;
        for(int i : arr){
            if(i > Y){
                sum++;
            }
        }
        System.out.println(sum);
        return sum;
    }

    public int[] squareValues(int[] arr){
        for(int i = 0; i < arr.length; i++){
            arr[i] = arr[i] * arr[i];
        }
        return arr;
    }

    public int[] noNegatives(int [] arr){
        for(int i = 0; i < arr.length; i++){
            if(arr[i] < 0){
                arr[i] = 0;
            }
        }
        return arr;
    }

    public ArrayList minMaxAvg(int[] x){
        ArrayList<Object> mMA = new ArrayList<Object>();
        double sum = 0;
        int max = x[0];
        int min = x[0];
        double avg;
        for(int i : x){
            sum += i;
            if(i > max){
                max = i;
            }
            if(i < min){
                min = i;
            }
        }
        avg = sum / x.length;
        mMA.add(max);
        mMA.add(min);
        mMA.add(avg);
        return mMA;
    }

    public int[] shiftArray(int[] x){
        for(int i = 0; i < x.length-1; i++){
            x[i] = x[i+1];
        }
        x[x.length-1] = 0;
        return x;
    }



}