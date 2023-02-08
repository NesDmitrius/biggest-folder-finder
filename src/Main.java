import java.io.File;

public class Main {

    private static long sizeFilesInDirectory;
    private static String[] sizeNames = {"b", "Kb", "Mb", "Gb"};

    public static void main(String[] args) {

        String folderPath = "H:\\Видео\\Films\\Game.of.Thrones.s02.LostFilm";
        File file = new File(folderPath);
        System.out.println(getFolderSize(file));

        String size = getHumanReadableSize(sizeFilesInDirectory);
        System.out.println("Размер папки/файла: " + size);

        System.out.println(getSizeFromHumanReadable("235K") + " bytes");

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

    public static String getHumanReadableSize(long size) {
        if (size == 0) {
            return "Не найдены папка/файл";
        }
        int power = (int) (Math.log(size) / Math.log(1024));
        double value = size / Math.pow(1024, power);
        double roundedValue = Math.round(value * 100) / 100;
        String result = roundedValue + " " + sizeNames[power];
        return result;
    }

    public static long getSizeFromHumanReadable (String size) {
        String regex = "[^0-9]";
        String sizeNumber = size.replaceAll(regex, "");
        int sizeFolder = Integer.parseInt(sizeNumber);
        long sizeFolderInBytes = 0L;
        for (int i = 0; i < sizeNames.length; i++) {
            if (size.concat("b").contains(sizeNames[i])) {
                sizeFolderInBytes = (long) (sizeFolder * Math.pow(1024, i));
            }
        }
        return sizeFolderInBytes;
    }


}
