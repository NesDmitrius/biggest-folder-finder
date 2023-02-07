import java.io.File;

public class Main {

    private static long sizeFilesInDirectory;

    public static void main(String[] args) {

        String folderPath = "H:\\Видео\\Films\\Game.of.Thrones.s02.LostFilm";
        File file = new File(folderPath);
        System.out.println(getFolderSize(file));

    }

    public static long getFolderSize(File file) {
        sizeFilesInDirectory = 0L;
        if (file != null && file.isFile()) {
            return sizeFilesInDirectory = file.length();
        }
        if (file != null && file.isDirectory()) {
            File[] files = file.listFiles();
            for (File file1 : files) {
                sizeFilesInDirectory += getFolderSize(file1);
            }
        }
        return sizeFilesInDirectory;
    }


}
