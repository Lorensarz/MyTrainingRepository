import java.io.File;

public class FileUtils {

    private static String[] format = {"b", "Kb", "Mb", "Gb", "Tb"};

    public static long calculateFolderSize(String path) {

        File folder = new File(path);

        if (folder.isFile()) {
            return folder.length();
        }
        long sum = 0;
        File[] files = folder.listFiles();
        for (File file : files) {
            sum += calculateFolderSize(String.valueOf(file));
        }
        return sum;
    }

    public static String sizeFormat(long size) {
        for (int i = 0; i <= format.length; i++ ) {
            double value = size / Math.pow(1024, i);
            if (value < 1024) {
                return Math.round(value * 100) / 100d + "" + format[i];
            }
        }
        return "";
    }

}
