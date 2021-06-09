import java.util.ArrayList;

public class ProjectTest{
    public static void main(String[] args){
        Project project1 = new Project(); // Testing constructor with no arguments
        Project project2 = new Project("Dreamland"); //Testing constructor with one argument (name)
        Project project3 = new Project("Purity Control", "Secret government project to experiment on alien DNA"); 
        //testing constructor with both arguments (name and description)

        project1.setName("From Outer Space"); // Test the name setter method
        project1.setDescription("A fiction non-fiction book about alien abductions by Jose Chung");
        //Test the description setter method

        project2.setDescription("Test flying aircraft with experimental technology.");
        //completing the project2 object

        System.out.println("Test get name:");
        System.out.println(project1.getName()); //test getName method
        System.out.println("Test get description:");
        System.out.println(project1.getDescription()); //test getDescription method

        project1.setInitialCost(10.00); //testing initialCost setter method
        project2.setInitialCost(30.33);
        project3.setInitialCost(21.89);

        System.out.println("Testing getInitialCost of all projects:");
        System.out.println(project1.getInitialCost()); //testing initalCost getter method
        System.out.println(project2.getInitialCost());
        System.out.println(project3.getInitialCost());

        System.out.println("Testing elevator pitch method:");
        String pitch1 = project1.elevatorPitch();
        System.out.println(pitch1); //testing elevatorPitch method

        Portfolio testPortfolio = new Portfolio(); //test portfolio constructor without argument
        Portfolio myPortfolio = new Portfolio(project1); //test portfolio constructor 
        myPortfolio.addProject(project2); //testing addProject method
        myPortfolio.addProject(project3);

        System.out.println("Portolio objects created. Testing getter for Portfolio:");
        ArrayList<Project> portfolioArray = myPortfolio.getPortfolio(); //test getter for portfolio
        for(Project aProject : portfolioArray){
            System.out.println(aProject.getName()); //demonstrate that the new array from getter method contains the right values
        }

        System.out.println("Testing portfolio cost getter:");
        System.out.println(myPortfolio.getPortfolioCost()); //test getter for Portfolio cost and ensure costs were entered and totalled correctly

        System.out.println("Testing show portfolio method to pull elevator pitches and total portfolio cost:");
        myPortfolio.showPortfolio(); //testing showPortfolio method

    }
}