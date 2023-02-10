public class ParametersBag {

    private String[] args;
    private static final String REGEX = "([A-Z|a-z]:\\\\[^*|\"<>?\\n]*)|(\\\\\\\\.*?\\\\.*)";
    private static final String REGEX_LIMIT = "[0-9]*[A-Za-z]{1,2}";

    public ParametersBag(String[] args) {
        if (args.length < 4) {
            throw new IllegalArgumentException("Недостаточно данных");
        }
        if (!args[1].matches(REGEX) || args[1].isEmpty()) {
            throw new IllegalArgumentException("Некорректный путь до каталога");
        }
        if (!args[3].matches(REGEX_LIMIT) || args[3].isEmpty()) {
            throw new IllegalArgumentException("Некорректные данные предельного размера файлов");
        }
        this.args = args;
    }

    public long getLimit() {
        return SizeCalculator.getSizeFromHumanReadable(args[3]);
    }

    public String getPath() {
        return args[1].strip();
    }
}
