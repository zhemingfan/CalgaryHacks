import java.io.File;

public class testReader{
  public static void main(String args[]){
    File file = new File("Directory.txt");
    System.out.println(file.getAbsolutePath());
  }
}
