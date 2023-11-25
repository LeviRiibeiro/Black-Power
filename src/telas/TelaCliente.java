package telas;

import entities.Cliente;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class TelaCliente extends JFrame {
    private final ClienteDAO clienteDAO;

    public TelaCliente() {
        clienteDAO = new ClienteDAO();

        try {
            // Configurações gerais da janela
            setTitle("Cadastro de Clientes");
            setSize(736, 701);
            setResizable(false);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);

            // Criação e configuração de componentes
            JLabel label = new JLabel("Página dos Clientes");
            label.setFont(new Font("Arial", Font.BOLD, 20));

            // Campos de Cadastro
            JLabel nomeLabel = new JLabel("Nome:");
            JTextField nomeTextField = new JTextField(20);

            JLabel telefoneLabel = new JLabel("Telefone:");
            JTextField telefoneTextField = new JTextField(15);

            // Botão para cadastrar cliente
            JButton cadastrarButton = new JButton("Cadastrar");
            cadastrarButton.setFont(new Font("Arial", Font.PLAIN, 12));
            cadastrarButton.setForeground(new Color(255, 255, 255));
            cadastrarButton.setBackground(new Color(0, 0, 0));
            cadastrarButton.addActionListener(e -> cadastrarCliente(nomeTextField.getText(), telefoneTextField.getText()));

            // Botão para visualizar todos os clientes cadastrados
            JButton visualizarButton = new JButton("Visualizar Clientes");
            visualizarButton.setFont(new Font("Arial", Font.PLAIN, 12));
            visualizarButton.setForeground(new Color(255, 255, 255));
            visualizarButton.setBackground(new Color(0, 0, 0));
            visualizarButton.addActionListener(e -> visualizarClientes());

            JButton backButton = new JButton("Voltar");
            backButton.setFont(new Font("Arial", Font.PLAIN, 12));
            backButton.setForeground(new Color(255, 255, 255));
            backButton.setBackground(new Color(0, 0, 0));
            backButton.addActionListener(e -> voltarParaMenu());

            // Usando GridBagLayout para organizar os componentes
            JPanel panel = new JPanel(new GridBagLayout());
            panel.setOpaque(false);
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.insets = new Insets(10, 10, 10, 10); // Espaçamento entre os componentes

            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.anchor = GridBagConstraints.WEST;
            panel.add(label, gbc);

            gbc.gridy++;
            panel.add(nomeLabel, gbc);

            gbc.gridx = 1;
            panel.add(nomeTextField, gbc);

            gbc.gridy++;
            gbc.gridx = 0;
            panel.add(telefoneLabel, gbc);

            gbc.gridx = 1;
            panel.add(telefoneTextField, gbc);

            gbc.gridy++;
            gbc.gridx = 0;
            gbc.gridwidth = 2;
            gbc.anchor = GridBagConstraints.CENTER;
            panel.add(cadastrarButton, gbc);

            gbc.gridy++;
            panel.add(visualizarButton, gbc);

            gbc.gridy++;
            panel.add(backButton, gbc);

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

    private void cadastrarCliente(String nome, String telefone) {
        clienteDAO.salvarCliente(new Cliente(nome, telefone));
        JOptionPane.showMessageDialog(this, "Cliente cadastrado com sucesso!");
    }

    private void visualizarClientes() {
        List<Cliente> clientes = clienteDAO.carregarClientes();
        StringBuilder mensagem = new StringBuilder("Clientes cadastrados:\n");

        for (Cliente cliente : clientes) {
            mensagem.append("Nome: ").append(cliente.getNome()).append(", Telefone: ").append(cliente.getTelefone()).append("\n");
        }

        JOptionPane.showMessageDialog(this, mensagem.toString());
    }
}
