package service;

import utils.FileUtils;
import utils.HashUtils;

import java.util.List;

public class AuthService {

    private static final String USERS_FILE = "data/users.txt";

    public static boolean register(String email, String password) {

        List<String> users = FileUtils.readFile(USERS_FILE);

        for (String u : users) {
            if (u.split(";")[0].equals(email)) {
                return false;
            }
        }

        String hashed = HashUtils.hash(password);

        FileUtils.appendLine(USERS_FILE, email + ";" + hashed);
        return true;
    }

    public static boolean login(String email, String password) {

        List<String> users = FileUtils.readFile(USERS_FILE);

        String hashed = HashUtils.hash(password);

        for (String u : users) {
            String[] p = u.split(";");

            if (p[0].equals(email) && p[1].equals(hashed)) {
                return true;
            }
        }

        return false;
    }

    public static String createUserFolder(String email) {

        String folder = "data/usuarios/" + email.replace("@", "_").replace(".", "_");

        FileUtils.createDir(folder);

        return folder;
    }
}