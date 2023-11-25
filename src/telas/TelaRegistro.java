package telas;

import javax.swing.*;
import java.awt.*;

public class TelaRegistro extends JFrame {
    public TelaRegistro() {
        try {
            // Configurações gerais da janela
            setTitle("Registro");
            setSize(736, 701);
            setResizable(false);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);

            // Criação e configuração de componentes
            JLabel label = new JLabel("Registro");
            label.setFont(new Font("Arial", Font.BOLD, 20));

            JButton backButton = new JButton("Voltar");
            backButton.setFont(new Font("Arial", Font.PLAIN, 12));
            backButton.setForeground(new Color(0, 0, 0));
            backButton.setBackground(new Color(255, 255, 255));
            backButton.addActionListener(e -> voltarParaMenu());

            // Usando um layout de fluxo para centralizar o título
            JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
            panel.setOpaque(false);
            panel.add(label);

            // Adicionando o botão ao painel
            panel.add(backButton);

            // Definindo o painel principal como conteúdo da janela
            setContentPane(panel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void voltarParaMenu() {
        dispose();
        SwingUtilities.invokeLater(() -> new TelaSistema().setVisible(true));
    }
}
