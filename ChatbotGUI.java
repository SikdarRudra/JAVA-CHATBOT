import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;

class ChatbotGUI extends JFrame {
    private static final long serialVersionUID = 1L;
    private JTextArea chatArea;
    private JTextField inputField;
    private HashMap<String, String> responses;

    public ChatbotGUI() {
        setTitle("ChatBot");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        chatArea = new JTextArea();
        chatArea.setEditable(false);
        chatArea.setBackground(Color.BLACK);
        chatArea.setForeground(Color.WHITE); 
        JScrollPane scrollPane = new JScrollPane(chatArea);
        add(scrollPane, BorderLayout.CENTER);

        inputField = new JTextField();
        inputField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String userInput = inputField.getText().toLowerCase();
                displayMessage("You: " + userInput);
                inputField.setText("");

                String response = responses.getOrDefault(userInput, "I don't understand.");
                displayMessage("Chatbot: " + response);
            }
        });
        add(inputField, BorderLayout.SOUTH);

        responses = new HashMap<>();
        responses.put("what is meant by oops", "OOPs (Object-Oriented Programming) is a programming paradigm based on the concept of objects, which can contain data and code. It emphasizes concepts like inheritance, encapsulation, polymorphism, and abstraction.");
        responses.put("why is java platform-independent", "Java is platform-independent because of its 'Write Once, Run Anywhere' principle. Java programs are compiled into bytecode, which can be executed on any platform with a Java Virtual Machine (JVM), making it highly portable.");
        responses.put("why is using java better as compared to other languages", "Java offers advantages such as platform independence, strong community support, robustness, security features, automatic memory management (garbage collection), and a vast array of libraries and frameworks.");
        responses.put("when was java first used", "Java was first released by Sun Microsystems in 1995.");

        setVisible(true);
    }

    private void displayMessage(String message) {
        chatArea.append(message + "\n\n");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ChatbotGUI();
            }
        });
    }
}
