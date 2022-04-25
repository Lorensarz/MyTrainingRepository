import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    private static final int newWidth = 300;

    private static final int processorsCount = Runtime.getRuntime().availableProcessors();


    public static void main(String[] args) {
        String srcFolder = "C:\\Downloads\\Camera";
        String dstFolder = "C:\\Downloads\\newCamera";

        ExecutorService executorService;

        File srcDir = new File(srcFolder);

        long start = System.currentTimeMillis();

        File[] files = srcDir.listFiles();

        assert files != null;
        List<File[]> dividingFiles = runDividingFiles(files);



//        ImageResizer resizer = new ImageResizer(files, newWidth, Path.of(dstFolder), start);
//        executorService = Executors.newFixedThreadPool(processorsCount);
//        executorService.execute(resizer);
//        executorService.shutdown();

        executorService = Executors.newFixedThreadPool(processorsCount);

        for (File[] file : dividingFiles) {
            ImageResizer resizer = new ImageResizer(file, newWidth, Path.of(dstFolder), start);
            executorService.submit(resizer);

        }
        executorService.shutdown();
    }


    private static List<File[]> runDividingFiles(File[] files) {

        List<File[]> resultArr = new ArrayList<>();

        int partitionSize = files.length / Main.processorsCount;
        int remainder = files.length % Main.processorsCount;
        int halfOneSegment = partitionSize / 2;

        boolean remainderOfTheDivision = remainder > 0 && remainder <= halfOneSegment;
        int bound = files.length - (remainderOfTheDivision ? partitionSize : 0);

        for (int i = 0; i < bound; i += partitionSize) {
            int min = Math.min(files.length, i + partitionSize);
            boolean isLastParts = (i + partitionSize) >= bound;

            int endIndexRange;
            if (remainderOfTheDivision && isLastParts) {
                endIndexRange = files.length;
            } else {
                endIndexRange = min;
            }

            File[] filesResult = Arrays.copyOfRange(files, i, endIndexRange);

            resultArr.add(filesResult);
        }

        return resultArr;
    }
}

