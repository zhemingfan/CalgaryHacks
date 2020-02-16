package Entities;
import java.util.*;

public class User extends Entity{
  public User(String aName, ArrayList<String> interestList, String aDepartment){
    super(aName, interestList, aDepartment);
  }

  public User(String aName, ArrayList<String> interestList){
    super(aName, interestList);
  }

}
