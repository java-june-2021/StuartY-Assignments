public class PythagoreanTest{
    public static void main(String[] args){
        Pythagorean myTriangle = new Pythagorean();
        double myHypotenuse = myTriangle.calculateHypotenuse(3,4);
        System.out.println(myHypotenuse);
    }
}