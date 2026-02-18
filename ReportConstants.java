public final class ReportConstants {

    private ReportConstants() {
        throw new AssertionError("Cannot instantiate constants class");
    }

    public static final String PATH_TO_REPORT = "data/";

    public static String getPath(String reportName) {
        return PATH_TO_REPORT + reportName;
    }
}
