package ProofOfConcept;
import java.util.*;
import Entities.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ProofOfConcept{
	static ArrayList<Professor> profList;
	
	public ProofOfConcept() {
        String fileName = "src/ProofOfConcept/final.txt";
        Scanner file = null;
        ArrayList<Professor> professorObjectsList = new ArrayList<Professor>();

        try {
            file = new Scanner(new File(fileName));
        } catch (FileNotFoundException e) {
            System.out.println(fileName + " not found");
            System.exit(0);
        }

        while (file.hasNextLine()) {
            // 1, 6[0], 7, 8
            Scanner professorInfo = new Scanner(file.nextLine()).useDelimiter("\t");
            String name = professorInfo.next();
            String position = professorInfo.next();
            String profileLink = professorInfo.next();
            String phone = professorInfo.next();
            String room = professorInfo.next();
            String[] emailsList = professorInfo.next().split("\'");
            String email = emailsList[1];
            String[] personalWebsite = professorInfo.next().split("\'");
            String website = "";
            if (personalWebsite.length > 2) {
                website = personalWebsite[1];
            }
            String[] rawInterestList = professorInfo.next().split(",");
            ArrayList<String> interests = new ArrayList<String>();
            String aInt = "";
            for (String aInterest : rawInterestList){
//                if (aInterest == "[" || aInterest == "\' " || aInterest == "]") {
//                    // do nothing
//                } else {
            	
            	aInt = aInterest.replaceAll("\\[", "").replaceAll("\\]", "").replaceAll("'", "");
                if (aInt.length() > 0) interests.add(aInt);
//                }
            }
            professorInfo.close();
            Professor profObj = new Professor(name, interests, website, "Computer Science", email);
            professorObjectsList.add(profObj);
            //System.out.println(name + email + website + interests.toString());
        }

        file.close();
        
        this.profList = professorObjectsList; 
    }
	public static ArrayList<String> getUniqueInterests(){
//		ArrayList<Professor> profList = new ArrayList<Professor>();
		ArrayList<String> uniqueInterest = new ArrayList<String>();
		for (Professor prof : profList) {
			for (String profInterest : prof.getInterests()){
				if (!uniqueInterest.contains(profInterest)) {
					uniqueInterest.add(profInterest);
				}
			}	
		}
		return uniqueInterest;
	}
	public static ArrayList<Professor> getMatches(String department, ArrayList<String> interests){
//		ArrayList<Professor> profList = new ArrayList<Professor>();
		ArrayList<Professor> matches = new ArrayList<Professor>();
		User user = new User("a", interests, department); 
		float perc = 0;
		for (Professor prof : profList) {
			perc = compareStats(prof,user);
			if (perc > 0) {
				matches.add(prof);
			}
		}
		return matches;
	}
	
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
