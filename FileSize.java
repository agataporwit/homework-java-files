import java.io.File;

public class FileSize {

    public static void main(String[] args) {
        File file = new File("/Users/agatajelen/Documents/JavaProjects/FileSize/testFile.txt");
        if (!file.exists()) {
            System.out.println("File doesn't exist");
        } else {
            System.out.println(filesize_in_Bytes(file));
            System.out.println(filesize_in_kiloBytes(file));
            System.out.println(filesize_in_megaBytes(file));
        }

    }

    private static String filesize_in_megaBytes(File file) {
        return (double) file.length() / (1024 * 1024) + " mb";
    }

    private static String filesize_in_kiloBytes(File file) {
        return (double) file.length() / 1024 + "  kb";
    }

    private static String filesize_in_Bytes(File file) {
        return file.length() + " bytes";
    }
}
