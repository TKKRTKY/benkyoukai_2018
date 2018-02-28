import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Random;

public class TanoshiiBenkyoukaiKihonjouhou {

  public static String baseURI = "http://www.fe-siken.com/kakomon/";
  public static int maxQuestionNumber = 80;
  public static String monku = "paramsを指定してください。例:java TanoshiiBenkyoukaiKihonjouhou 21_haru 21_aki 22_haru";

  public static void main(String[] args) {
    if (args.length == 0) {
      System.out.println(monku);
      return;
    }
    Desktop desktop = Desktop.getDesktop();
    String uriString = getURI(args);
    try {
      URI uri = new URI(uriString);
      desktop.browse(uri);
    } catch (URISyntaxException e) {
      e.printStackTrace();
    } catch (IOException e) {
     e.printStackTrace();
    }
  }

  public static String getURI(String[] args) {
    String uri = baseURI;
    Random random = new Random();
    int capter = random.nextInt(args.length);
    String question = String.valueOf(random.nextInt(maxQuestionNumber) + 1);
    uri += args[capter] + "/q" + question + ".html";
    System.out.println(uri);
    return uri;
  }
}

