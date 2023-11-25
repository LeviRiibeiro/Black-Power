package telas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaSistema extends JFrame {
    public TelaSistema() {
        try {
            // Configurações gerais da janela
            setTitle("Salão Black Power");
            setSize(736, 701);
            setResizable(false);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);

            // Criação e configuração da label no topo da página
            JLabel label = new JLabel("MENU");
            label.setFont(new Font("Arial", Font.BOLD, 40));
            label.setForeground(new Color(0, 0, 0)); // Definindo a cor do texto

            // Criação do botão de voltar
            JButton backButton = new JButton("Voltar");
            backButton.setFont(new Font("Arial", Font.PLAIN, 12));
            backButton.setForeground(new Color(0, 0, 0));
            backButton.setBackground(new Color(255, 255, 255));
            backButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Lógica para voltar à página inicial
                    dispose(); // Fecha a tela atual

                    // Cria e exibe a tela inicial
                    SwingUtilities.invokeLater(() -> new TelaInicial().setVisible(true));
                }
            });

            // Criação e configuração do painel de botões usando GridBagLayout
            JPanel buttonsPanel = new JPanel(new GridLayout(4, 1, 0, 20)); // Layout para os botões em formato de menu
            buttonsPanel.setOpaque(false);

            // Criação e configuração dos botões
            JButton button1 = criarBotao("Clientes");
            JButton button2 = criarBotao("Agendamento");
            JButton button3 = criarBotao("Registro");
            JButton button4 = criarBotao("Estoque");

            // Adição dos botões ao painel
            buttonsPanel.add(button1);
            buttonsPanel.add(button2);
            buttonsPanel.add(button3);
            buttonsPanel.add(button4);

            // Adicionando um novo painel para organizar os componentes
            JPanel mainPanel = new JPanel(new BorderLayout());
            mainPanel.setOpaque(false);

            // Adicionando o botão de voltar à labelPanel
            JPanel labelPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
            labelPanel.setOpaque(false);
            labelPanel.add(label);
            labelPanel.add(Box.createHorizontalStrut(20)); // Espaçamento entre o label e o botão
            labelPanel.add(backButton);

            mainPanel.add(labelPanel, BorderLayout.NORTH);
            mainPanel.add(buttonsPanel, BorderLayout.CENTER);

            // Definindo o painel principal como conteúdo da janela
            setContentPane(mainPanel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Método auxiliar para criar e configurar botões
    private JButton criarBotao(String texto) {
        JButton botao = new JButton(texto);
        botao.setFont(new Font("Arial", Font.BOLD, 16));
        botao.setForeground(new Color(255, 255, 255));
        botao.setBackground(new Color(9, 9, 9));

        // Adiciona a lógica de ação com base no texto do botão
        botao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (texto) {
                    case "Clientes":
                        abrirTelaClientes();
                        break;
                    case "Agendamento":
                        abrirTelaAgendamento();
                        break;
                    case "Registro":
                        abrirTelaRegistro();
                        break;
                    case "Estoque":
                        abrirTelaEstoque();
                        break;
                }
            }
        });

        return botao;
    }

    // Métodos auxiliares para abrir as telas correspondentes
    private void abrirTelaClientes() {
        dispose();
        SwingUtilities.invokeLater(() -> new TelaCliente().setVisible(true));
    }

    private void abrirTelaAgendamento() {
        dispose();
        SwingUtilities.invokeLater(() -> new TelaAgendamento().setVisible(true));
    }

    private void abrirTelaRegistro() {
        dispose();
        SwingUtilities.invokeLater(() -> new TelaRegistro().setVisible(true));
    }

    private void abrirTelaEstoque() {
        dispose();
        SwingUtilities.invokeLater(() -> new TelaEstoque().setVisible(true));
    }

}
