import java.util.ArrayList;

public class Portfolio{
    ArrayList<Project> projects = new ArrayList<Project>();
    double portfolioCost;

    public Portfolio(){}

    public Portfolio(Project project){
        this.projects.add(project);
        this.portfolioCost = project.getInitialCost();
    }

    public void addProject(Project project){
        this.projects.add(project);
        this.portfolioCost += project.getInitialCost();
    }

    public ArrayList<Project> getPortfolio(){
        return this.projects;
    }

    public double getPortfolioCost(){
        return this.portfolioCost;
    }

    public void showPortfolio(){
        for(Project a : this.projects){
            System.out.println(a.elevatorPitch());
        }
        System.out.println("Total cost: " + String.valueOf(portfolioCost));
    }


}