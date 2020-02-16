import java.util.*;

public class Professor extends Entity{
  private String website;
  private String email;

  public Professor(String someName, ArrayList<String> interestList, String someWebsite, String someDepartment, String someEmail){
    super(someName, interestList, someDepartment);
    setWebsite(someWebsite);
    setEmail(someEmail);
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

}
