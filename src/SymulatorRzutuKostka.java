import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SymulatorRzutuKostka extends JFrame {
    private JLabel wynikLabel;

    public SymulatorRzutuKostka() {
        setTitle("Symulator Rzutu Kostką");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        wynikLabel = new JLabel("Wynik: ");
        wynikLabel.setFont(new Font("Arial", Font.BOLD, 20));
        wynikLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(wynikLabel, BorderLayout.CENTER);

        JButton rzutButton = new JButton("Rzut kostką");
        rzutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int wynik = rzutKostka();
                wynikLabel.setText("Wynik: " + wynik);
            }
        });
        panel.add(rzutButton, BorderLayout.SOUTH);

        add(panel);
        setVisible(true);
    }

    private int rzutKostka() {
        Random random = new Random();
        return random.nextInt(6) + 1; // Symulacja rzutu kostką sześcienną
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new SymulatorRzutuKostka();
            }
        });
    }
}
