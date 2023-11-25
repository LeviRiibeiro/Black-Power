package telas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaInicial extends JFrame implements ActionListener {
    public TelaInicial() {
        setTitle("Salão Black Power");
        setSize(736, 701);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        // Criando um JLabel para exibir a imagem de fundo
        JLabel background = new JLabel(new ImageIcon("C:\\Users\\levir\\Desktop\\Trabalho faculdade\\beauty_salon_system\\imgs\\background_2.jpg"));

        // Criando um JLayeredPane para sobrepor componentes
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(736, 701));

        // Adicionando o fundo ao JLayeredPane
        layeredPane.add(background, new Integer(0));
        background.setBounds(0, 0, 736, 701);

        // Criando um JPanel para o título
        JPanel titlePanel = new JPanel(new GridBagLayout());
        titlePanel.setOpaque(false);

        JLabel titulo = new JLabel("SALAO BLACK POWER");
        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        titulo.setForeground(new Color(255, 255, 255));

        // Adicionando o título ao JPanel usando GridBagConstraints para centralizá-lo
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        titlePanel.add(titulo, gbc);

        // Criando um JPanel para o botão
        JPanel botaoPainel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        botaoPainel.setOpaque(false);

        JButton botao = new JButton("Login");
        botao.setFont(new Font("Arial", Font.BOLD, 30));
        botao.setForeground(new Color(255, 255, 255));
        botao.setBackground(new Color(0, 0, 0));
        botao.setBorderPainted(false);
        botao.addActionListener(this);

        // Adicionando o botão ao JPanel
        botaoPainel.add(botao);

        // Adicionando o JPanel do título ao JLayeredPane
        layeredPane.add(titlePanel, new Integer(1));
        titlePanel.setBounds(0, 0, 736, 100);  // Altura ajustável conforme necessário

        // Adicionando o JPanel do botão ao JLayeredPane
        layeredPane.add(botaoPainel, new Integer(1));
        botaoPainel.setBounds(280, 600, 200, 50);

        // Definindo o JLayeredPane como o conteúdo do JFrame
        setContentPane(layeredPane);

        setVisible(true);
    }

    private void abrirTelaSecundaria() {
        try {
            dispose();
            TelaSistema telaSistema = new TelaSistema();
            telaSistema.setVisible(true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Botão pressionado, abrindo a TelaSistema...");
        abrirTelaSecundaria();
    }
}
