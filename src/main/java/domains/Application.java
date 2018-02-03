package domains;

public class Application {
    final static String appUrlStorageString = System.getenv("base_url");

    public static String getURL() {
        return appUrlStorageString;
    }

}
