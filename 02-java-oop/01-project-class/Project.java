public class Project{
    String name;
    String description;
    double initialCost;

    // constructor without setting instance variables
    public Project(){}

    // constructor with just the name
    public Project(String name){
        this.name = name;
    }

    // constructor with name and description
    public Project(String name, String description){
        this.name = name;
        this.description = description;
    }

    // setter method for name
    public void setName(String name){
        this.name = name;
    }

    //setter method for description
    public void setDescription( String description){
        this.description = description;
    }

    //getter method for name
    public String getName(){
        return this.name;
    }

    //getter method for description
    public String getDescription(){
        return this.description;
    }

    //setter method for initialCost
    public void setInitialCost(double cost){
        this.initialCost = cost;
    }

    //getter method for initialCost
    public double getInitialCost(){
        return this.initialCost;
    }

    public String elevatorPitch(){
        String elevator;
        String cost;
        cost = String.valueOf(this.initialCost);
        elevator = this.name + " (" + cost + "): " +this.description;
        return elevator;
    }
}