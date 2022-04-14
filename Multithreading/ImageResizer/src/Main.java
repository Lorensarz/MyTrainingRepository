import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    private static int newWidth = 300;

    private static int processorsCount = Runtime.getRuntime().availableProcessors();

    public static void main(String[] args) {
        String srcFolder = "C:\\Downloads\\Camera";
        String dstFolder = "C:\\Downloads\\newCamera";

        File srcDir = new File(srcFolder);

        long start = System.currentTimeMillis();

        File[] files = srcDir.listFiles();

        List<File[]> dividingFiles = runDividingFiles(files, processorsCount);

        ImageResizer resizer1 = new ImageResizer(dividingFiles.get(0), newWidth, Path.of(dstFolder), start);
        ImageResizer resizer2 = new ImageResizer(dividingFiles.get(1), newWidth, Path.of(dstFolder), start);
        ImageResizer resizer3 = new ImageResizer(dividingFiles.get(2), newWidth, Path.of(dstFolder), start);
        ImageResizer resizer4 = new ImageResizer(dividingFiles.get(3), newWidth, Path.of(dstFolder), start);

        resizer1.start();
        resizer2.start();
        resizer3.start();
        resizer4.start();

    }

    private static List<File[]> runDividingFiles(File[] files, int numberOfParts) {

        List<File[]> resultArr = new ArrayList<>();

        int partitionSize = files.length / numberOfParts;
        int remainder = files.length % numberOfParts;
        int halfOneSegment = partitionSize / 2;

        boolean remainderOfTheDivision = false;
        if (remainder > 0 && remainder <= halfOneSegment) remainderOfTheDivision = true;
        int bound = files.length - (remainderOfTheDivision ? partitionSize : 0);

        for (int i = 0; i < bound; i += partitionSize) {
            int min = Math.min(files.length, i + partitionSize);
            boolean isLastParts = false;
            if ((i + partitionSize) >= bound) {
                isLastParts = true;
            }

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

