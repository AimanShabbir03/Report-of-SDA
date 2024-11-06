/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author user
 */
import javax.swing.*;
import java.awt.*;

public class NewsPortalUI extends JFrame {
    private JTextField titleField;
    private JTextArea contentArea;
    private JTextField authorField;
    private JButton createPostButton;
    private JLabel messageLabel;
    
    public NewsPortalUI() {
        setTitle("News Portal - Create Post");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1, 10, 10));

        JLabel titleLabel = new JLabel("Title:");
        titleField = new JTextField();
        panel.add(titleLabel);
        panel.add(titleField);

        JLabel contentLabel = new JLabel("Content:");
        contentArea = new JTextArea(5, 20);
        panel.add(contentLabel);
        panel.add(new JScrollPane(contentArea));

        JLabel authorLabel = new JLabel("Author:");
        authorField = new JTextField();
        panel.add(authorLabel);
        panel.add(authorField);

        createPostButton = new JButton("Create Post");
        messageLabel = new JLabel("");
        messageLabel.setForeground(Color.RED);

        add(panel, BorderLayout.CENTER);
        add(createPostButton, BorderLayout.SOUTH);
        add(messageLabel, BorderLayout.NORTH);

        createPostButton.addActionListener(e -> handleCreatePost());

        setVisible(true);
    }
    
    private void handleCreatePost() {
        String title = titleField.getText();
        String content = contentArea.getText();
        String author = authorField.getText();
        
        NewsPortalApp app = new NewsPortalApp();
        try {
            app.createPost(title, content, author);
            messageLabel.setText("Post created successfully!");
        } catch (IllegalArgumentException ex) {
            messageLabel.setText("Failed to create post: " + ex.getMessage());
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(NewsPortalUI::new);
    }
}

