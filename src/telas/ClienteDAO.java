package telas;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entities.Cliente;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClienteDAO {
    private final String FILE_PATH = "clientes.json";
    private final Gson gson;

    public ClienteDAO() {
        gson = new GsonBuilder().setPrettyPrinting().create();
    }

    public void salvarCliente(Cliente cliente) {
        List<Cliente> clientes = carregarClientes();
        clientes.add(cliente);
        salvarClientes(clientes);
    }

    public List<Cliente> carregarClientes() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line);
            }

            Cliente[] clientesArray = gson.fromJson(content.toString(), Cliente[].class);
            if (clientesArray != null) {
                return new ArrayList<>(Arrays.asList(clientesArray));
            }

        } catch (IOException e) {
            // Arquivo não existe ou ocorreu um erro durante a leitura
            // Pode ser normal se for a primeira execução da aplicação
            System.out.println("Erro ao carregar clientes: " + e.getMessage());
        }

        return new ArrayList<>();
    }

    private void salvarClientes(List<Cliente> clientes) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            String json = gson.toJson(clientes.toArray(new Cliente[0]));
            writer.write(json);
            System.out.println("Clientes salvos em: " + new File(FILE_PATH).getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Erro ao salvar clientes: " + e.getMessage());
        }
    }
}
