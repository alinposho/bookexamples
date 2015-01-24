package functional.thinking.chapter7;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FunctionalInterfaces {

    public static String cleanNames(List<String> names) {
        if (names == null) return "";
        return names
                .stream()
                .filter(name -> name.length() > 1)
                .map(name -> capitalize(name))
                .collect(Collectors.joining(","));
    }

    private static String capitalize(String e) {
        return e.substring(0, 1).toUpperCase() + e.substring(1, e.length());
    }

    public static void main(String[] args) {
        System.out.println("Clean name: " + cleanNames(Arrays.asList("a", "alin", "bOB", "Judy")));
    }
}
