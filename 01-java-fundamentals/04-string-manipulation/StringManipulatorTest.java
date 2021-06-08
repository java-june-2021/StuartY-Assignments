public class StringManipulatorTest{
    public static void main(String[] args){
        StringManipulator manipulator = new StringManipulator();
        String testA = manipulator.trimAndConcat("   bobby   ", "   tanzania   ");
        System.out.println(testA);        
        Integer testB = manipulator.getIndexOrNull("Bobby", "by");
        System.out.println(testB);
        Integer testBnull = manipulator.getIndexOrNull("Ranch", "Dressing");
        System.out.println(testBnull);
        String testC = manipulator.concatSubstring("Bobby", 0, 3, " Hill");
        System.out.println(testC);
    }
}