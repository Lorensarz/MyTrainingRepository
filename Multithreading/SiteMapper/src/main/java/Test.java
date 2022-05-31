import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.ForkJoinPool;

public class Test {

    private static final String URL = "https://skillbox.ru/";
    private static final String SITE_MAP =
            "C:/Skillbox/java_basics/Multithreading/SiteMapper/src/main/resources";


    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();
        SiteMapNode siteMapNode = new SiteMapNode(URL);
        Set<String> results;

        pool.execute(siteMapNode);

        while ((!siteMapNode.isDone())) {
            pool.shutdown();
            results = siteMapNode.join();
            System.out.println(results);
        }


//        try (FileWriter writer = new FileWriter(SITE_MAP)) {
//            results.forEach(s -> {
//                try {
//                    writer.write(s + "\n\t");
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            });
//
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }

//        System.out.println(results.size());
    }


}


