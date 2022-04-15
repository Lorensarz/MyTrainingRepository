import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    private static final int newWidth = 300;

    private static final int processorsCount = Runtime.getRuntime().availableProcessors();

    public static void main(String[] args) {
        String srcFolder = "C:\\Downloads\\Camera";
        String dstFolder = "C:\\Downloads\\newCamera";

        File srcDir = new File(srcFolder);

        long start = System.currentTimeMillis();

        File[] files = srcDir.listFiles();

        assert files != null;
        List<File[]> dividingFiles = runDividingFiles(files);

        for (File[] dividingFile : dividingFiles) {
            ImageResizer resizer = new ImageResizer(dividingFile, newWidth, Path.of(dstFolder), start);
            resizer.start();
        }

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

