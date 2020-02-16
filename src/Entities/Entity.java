package Entities;
import java.util.*;

public class Entity{
  private String name;
  private ArrayList<String> interests = new ArrayList<>();
  private String department;

public Entity(String aName, ArrayList<String> interestList, String aDepartment){
  setName(aName);
  setInterests(interestList);
  setDepartment(aDepartment);
}

  public String getName(){
    return name;
  }

  public void setName(String aName){
    name = aName;
  }

  public ArrayList<String> getInterests(){
    return interests; //CHANGE PLS, NEEDS COPY CONSTRUCTOR
  }

  public void setInterests(ArrayList<String> anArray){
    for (String i : anArray){
      interests.add(i);
    }
  }

  public String getDepartment(){
    return department;
  }

  public void setDepartment(String aDepartment){
    department = aDepartment;
  }

}
