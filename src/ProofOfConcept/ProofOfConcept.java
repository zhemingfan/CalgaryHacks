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
}
