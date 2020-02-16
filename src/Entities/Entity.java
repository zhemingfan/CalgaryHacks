public class Entity{
  private String name;
  private ArrayList<String> interests;
  private String department;

  public String getName(){
    return name;
  }

  public void setName(String aName){
    name = aName;
  }

  public String getInterests(){
    return interests; //CHANGE PLS, NEEDS COPY CONSTRUCTOR
  }

  public void setInterests(ArrayList<String> anArray){
    for (int i : anArray){
      interests.add(anArray.get(i));
    }
  }

  public String getDepartment(){
    return department;
  }

  public void setDepartment(String aDepartment){
    department = aDepartment;
  }

}
