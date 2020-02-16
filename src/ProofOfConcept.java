import java.util.*;
import Entities.*;

public class ProofOfConcept{

public static float compareStats(Professor prof, User user){
  float counter = 0;
  float denominator = 0;
  if (prof.getInterests().size() < user.getInterests().size()){
    denominator = user.getInterests().size();
    for (String profInterest : prof.getInterests()){
      for (String userInterest : user.getInterests()){
        if (profInterest.equals(userInterest)) counter++;
      }
    }
  }
  else {
    denominator = prof.getInterests().size();
    for (String userInterest : user.getInterests()){
      for (String profInterest : prof.getInterests()){
        if (profInterest.equals(userInterest)) counter++;
      }
    }
  }
  return (counter/denominator)*100;
}

  public static void main(String args[]){
    ArrayList<String> testUserInterests = new ArrayList<>(Arrays.asList("Raving", "Coding", "Eating", "ABGs"));
    ArrayList<String> testInterest = new ArrayList<>(Arrays.asList("Coding", "White Whale AI", "Eating", "Hackathons", "KBBQ"));
    Professor testProf = new Professor("Se Yeon Kim", testInterest, "www.youtube.com/SeYeonKim", "Computer Science", "Kim.SeYeon@ucalgary.ca");
    User testUser = new User("Jonathan Santos", testUserInterests, "Computer Science");
    System.out.println(compareStats(testProf, testUser) + "% Match with " + testProf.getName() + "!");
    System.out.println(testUser.getName());
  }
}
