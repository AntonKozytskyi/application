import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Application {

  public static void main(String[] args) {
    Map<String, Integer> goods = new HashMap<>();

    try {
      File goodsFile = new File("goods.txt");
      Scanner reader = new Scanner(goodsFile);

      while (reader.hasNext()) {
        String line = reader.nextLine();
        String[] columns = line.split(":");

        if (columns.length == 2) {
          String good = columns[0].strip();

          try {
            int amount = Integer.parseInt(columns[1].strip());
            goods.put(good, amount);
          } catch (NumberFormatException e) {
            System.out.printf("%s cannot be parsed. Continue...%n", columns[1]);
          }
        }
      }

      reader.close();
    } catch (FileNotFoundException e) {
      System.out.println("goods.txt cannot be found on a disk");
    }

    goods.forEach((key, value) -> System.out.println("Product: " + key + ", amount: " + value));
  }
}
