import java.io.File;
import java.util.Scanner;

public class testReader{
  public static void main(String args[]) throws FileNotFoundException{
    File file = new File("ProfDirectory.txt");
    Scanner scanIn = new Scanner(file);

    String firstLine = scanIn.nextLine();

    System.out.println(scanIn.nextLine());
    System.out.println(firstLine);
  }
}
