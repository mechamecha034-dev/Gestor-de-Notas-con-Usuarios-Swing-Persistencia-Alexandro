package ui;

import service.NoteService;

import javax.swing.*;
import java.awt.*;

public class NotesFrame extends JFrame {

    private DefaultListModel<String> model;
    private JList<String> list;

    private JTextField titleField;
    private JTextField contentField;

    private NoteService service;

    public NotesFrame(String email) {

        service = new NoteService(email);

        setTitle("Notas");
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        model = new DefaultListModel<>();
        list = new JList<>(model);

        add(new JScrollPane(list), BorderLayout.CENTER);

        JPanel panel = new JPanel(new GridLayout(3, 2));

        titleField = new JTextField();
        contentField = new JTextField();

        panel.add(new JLabel("Título"));
        panel.add(titleField);
        panel.add(new JLabel("Contenido"));
        panel.add(contentField);

        JButton addBtn = new JButton("Crear");
        JButton delBtn = new JButton("Eliminar");

        panel.add(addBtn);
        panel.add(delBtn);

        add(panel, BorderLayout.SOUTH);

        addBtn.addActionListener(e -> addNote());
        delBtn.addActionListener(e -> deleteNote());

        loadNotes();

        setVisible(true);
    }

    private void addNote() {
        service.createNote(titleField.getText(), contentField.getText());
        loadNotes();
    }

    private void deleteNote() {
        int index = list.getSelectedIndex();
        service.deleteNote(index);
        loadNotes();
    }

    private void loadNotes() {
        model.clear();
        for (String n : service.getNotes()) {
            model.addElement(n);
        }
    }
}