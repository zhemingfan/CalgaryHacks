import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class testReader{

  public static void main(String args[]) throws IOException{
    try{
      File file = new File("ProfDirectory.txt");
      BufferedReader reader = new BufferedReader(new FileReader("ProfDirectory.txt"));

      ArrayList<String> wordList = new ArrayList<>();
      String lineFetched = null;
      String[] wordsToParse;

      while(true){
        lineFetched = reader.readLine();
        if(lineFetched == null){
          break;
        }
        else{
          wordsToParse = lineFetched.split("\t");
          for(String word : wordsToParse){
            if(!"".equals(word)) wordList.add(word);
          }
        }
        for(String word : wordList){
          System.out.println(word);
        }
      }

      reader.close();
    }
    catch(Exception exception){
      exception.printStackTrace();
    }
  }
}
