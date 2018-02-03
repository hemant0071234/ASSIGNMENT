package domains;

public class Timeout {
    public static int element_timeout_in_seconds = Integer.parseInt(System.getenv("timeout_for_elements_in_seconds"));
    public static int notification_timeout_in_seconds = Integer.parseInt(System.getenv("notification_for_elements_in_seconds"));
    public static int notification_auto_hide_time_in_seconds = Integer.parseInt(System.getenv("notification_auto_hide_timeout_in_seconds"));
    public static int chart_timeout_in_secs = Integer.parseInt(System.getenv("timeout_for_Tableau_in_seconds"));
    public static int short_wait_time_in_secs = Integer.parseInt(System.getenv("short_sleep_time_for_wait_in_seconds"));
}
