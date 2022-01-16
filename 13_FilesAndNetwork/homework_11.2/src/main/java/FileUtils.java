import java.io.*;

public class FileUtils {

    public static void copyFolder(String sourceDirectory, String destinationDirectory) throws IOException {
        // TODO: write code copy content of sourceDirectory to destinationDirectory

        File src = new File(sourceDirectory);
        File dst = new File(destinationDirectory);

        if (src.isDirectory()) {
            if (!dst.exists()) {
                dst.mkdir();
            }

            String files[] = src.list();

            for (String file : files) {
                String srcFile = String.valueOf(new File(src, file));
                String destFile = String.valueOf(new File(dst, file));

                copyFolder(srcFile, destFile);
            }

        } else {
            InputStream in = new FileInputStream(src);
            OutputStream out = new FileOutputStream(dst);

            byte[] buffer = new byte[1024];

            int length;
            while ((length = in.read(buffer)) > 0) {
                out.write(buffer, 0, length);
            }

            in.close();
            out.close();
        }
    }
}



