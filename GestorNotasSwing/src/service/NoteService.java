package service;

import utils.FileUtils;

import java.util.List;

public class NoteService {

    private final String file;

    public NoteService(String email) {
        this.file = "data/usuarios/" +
                email.replace("@", "_").replace(".", "_") +
                "/notes.txt";
    }

    public void createNote(String title, String content) {
        FileUtils.appendLine(file, title + ";" + content);
    }

    public List<String> getNotes() {
        return FileUtils.readFile(file);
    }

    public void deleteNote(int index) {

        List<String> notes = FileUtils.readFile(file);

        if (index >= 0 && index < notes.size()) {
            notes.remove(index);
            FileUtils.writeFile(file, notes);
        }
    }
}