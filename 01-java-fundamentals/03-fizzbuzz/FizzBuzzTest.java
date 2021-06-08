public class FizzBuzzTest{
    public static void main(String[] args){
        FizzBuzz fB = new FizzBuzz();
        for(int i = 100; i > 0; i--){
            System.out.println(fB.fizzBuzz(i));
        }
    }
}