package Entities;
import java.util.*;

public class Professor extends Entity{
  private String website;
  private String email;

  public Professor(String someName, ArrayList<String> interestList, String someWebsite, String someDepartment, String someEmail){
    super(someName, interestList, someDepartment);
    setWebsite(someWebsite);
    setEmail(someEmail);
  }

  public Professor(String someName, ArrayList<String> interestList){
    super(someName, interestList);
  }

  public String getWebsite(){
    return website;
  }

  public void setWebsite(String aWebsite){
    website = aWebsite;
  }

  public String getEmail(){
    return email;
  }

  public void setEmail(String anEmail){
    email = anEmail;
  }
  
  public String formatInterests(ArrayList<String> givenInterests) {
	  String out = "";
	  for(String item : givenInterests) {
		  out += "\n" + item;
	  }
	  return out;
  }
  
  public String getProfile() {
	  return getName() + "\n" + getDepartment() + "\n\nInterests:" + formatInterests(getInterests());
  }

}
