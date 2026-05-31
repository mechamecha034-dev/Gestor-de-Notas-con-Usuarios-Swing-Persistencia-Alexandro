package utils;

import java.nio.file.*;
import java.util.List;

public class FileUtils {

    public static void appendLine(String path, String line) {
        try {
            Files.writeString(Paths.get(path), line + "\n",
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static List<String> readFile(String path) {
        try {
            return Files.readAllLines(Paths.get(path));
        } catch (Exception e) {
            return List.of();
        }
    }

    public static void writeFile(String path, List<String> lines) {
        try {
            Files.write(Paths.get(path), lines,
                    StandardOpenOption.CREATE,
                    StandardOpenOption.TRUNCATE_EXISTING);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void createDir(String path) {
        try {
            Files.createDirectories(Paths.get(path));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}