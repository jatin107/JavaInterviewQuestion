import java.util.Properties;

/**
 * Created by jatin on 5/6/2017.
 */
public class AboutYourSystem {

    public static void main(String[] args) {
        System.out.println("Welcome to Java Interview Questions :)");
        System.out.println("Java Version:" + System.getProperty("java.version"));
        System.out.println("AvailableProcessors:" + Runtime.getRuntime().availableProcessors());
        System.out.printf("MaxMemory  :%.3fGiB\n", +((double) Runtime.getRuntime().maxMemory() / (1024.0 * 1024.0 * 1024.0)));
        System.out.printf("TotalMemory:%.3fGiB\n", +(Runtime.getRuntime().totalMemory() / (1024.0 * 1024.0 * 1024.0)));
        System.out.printf("FreeMemory :%.3fGiB\n", +(Runtime.getRuntime().freeMemory() / (1024.0 * 1024.0 * 1024.0)));
        System.out.printf("Used Memory:%.3fGiB\n", +((Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (1024.0 * 1024.0 * 1024.0)));
        Properties props = System.getProperties();
        props.list(System.out);

    }
}


