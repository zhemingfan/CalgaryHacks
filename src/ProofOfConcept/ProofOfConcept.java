package ProofOfConcept;
import java.util.*;
import Entities.*;
import java.io.IOException;

public class ProofOfConcept{

public static float compareStats(Professor prof, User user){
  float counter = 0;
  float denominator = 0;
  if (prof.getInterests().size() < user.getInterests().size()){
    denominator = user.getInterests().size();
    for (String userInterest : user.getInterests()){
      for (String profInterest : prof.getInterests()){
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

/*
public static ArrayList<Professor> sortProfList(ArrayList<Professor> = someProfList, User user){

  for(int i = 0; i < someProfList.size(); i++){

  }
}
*/

public static String toString(Professor prof, User user){
  return compareStats(prof, user) + "% match with " + prof.getName();
}

  public static void main(String args[]){
    ArrayList<String> testUserInterest = new ArrayList<>(Arrays.asList("Raving", "Coding", "Eating", "ABGs"));

    ArrayList<String> testInterest = new ArrayList<>(Arrays.asList("Coding", "White Whale AI", "Eating", "Hackathons", "KBBQ"));
    ArrayList<String> testInterest2 = new ArrayList<>(Arrays.asList("Raving" , "Eating", "ABGs"));
    ArrayList<String> testInterest3 = new ArrayList<>(Arrays.asList("Coding", "Raving", "Eating", "ABGs"));

    Professor testProf3 = new Professor("Jeremy Fan", testInterest3, "www.youtube.com/Jeremy", "Computer Sceince", "jeremy.fan@ucalgary.ca");
    Professor testProf2 = new Professor("Kelly Liu", testInterest2, "www.youtube.com/KellyLiu", "Computer Science", "Kelly.Liu2@ucalgary.ca");
    Professor testProf = new Professor("Se Yeon Kim", testInterest, "www.youtube.com/SeYeonKim", "Computer Science", "Kim.SeYeon@ucalgary.ca");

    ArrayList<Professor> profList = new ArrayList<>(Arrays.asList(testProf, testProf2, testProf3));

    User testUser = new User("Jonathan Santos", testUserInterest, "Computer Science");
    for(Professor prof : profList){
      System.out.println((toString(prof, testUser)));
    }

  }
}
