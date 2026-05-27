package br.edu.sistema.main;

import br.edu.sistema.model.Arma;
import br.edu.sistema.model.Item;
import br.edu.sistema.model.Pocao;
import br.edu.sistema.repository.Inventario;
import java.util.Scanner;

public class Main {
    private static Inventario inventario = new Inventario();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao = 0;

        do {
            exibirMenu();
            opcao = lerInteiroValido("Escolha uma opção: ");

            switch (opcao) {
                case 1:
                    criarItem();
                    break;
                case 2:
                    inventario.listarItens();
                    break;
                case 3:
                    atualizarItem();
                    break;
                case 4:
                    removerItem();
                    break;
                case 5:
                    System.out.println("Saindo do sistema de inventário. Até logo, viajante!");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 5);

        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println("\n=================================");
        System.out.println("    RPG INVENTORY MANAGER CLI    ");
        System.out.println("=================================");
        System.out.println("1. Adicionar Item");
        System.out.println("2. Listar Itens");
        System.out.println("3. Atualizar Item");
        System.out.println("4. Remover Item");
        System.out.println("5. Sair");
        System.out.println("=================================");
    }

    private static void criarItem() {
        System.out.println("\nTipo de Item de RPG:");
        System.out.println("1. Arma");
        System.out.println("2. Poção");
        int tipo = lerInteiroValido("Escolha o tipo: ");

        if (tipo != 1 && tipo != 2) {
            System.out.println("Tipo inválido. Cancelando operação.");
            return;
        }

        String nome = lerStringValida("Nome do item: ");
        int peso = lerInteiroPositivo("Peso (kg): ");
        int valor = lerInteiroPositivo("Valor (moedas de ouro): ");
        int id = inventario.gerarProximoId();

        if (tipo == 1) {
            int dano = lerInteiroPositivo("Pontos de Dano: ");
            String tipoDano = lerStringValida("Tipo de Dano (ex: Cortante, Fogo): ");
            inventario.adicionarItem(new Arma(id, nome, peso, valor, dano, tipoDano));
        } else {
            int cura = lerInteiroPositivo("Pontos de Cura (HP): ");
            String efeito = lerStringValida("Efeito colateral/bônus: ");
            inventario.adicionarItem(new Pocao(id, nome, peso, valor, cura, efeito));
        }
    }

    private static void atualizarItem() {
        inventario.listarItens();
        int id = lerInteiroValido("\nDigite o ID do item que deseja atualizar: ");
        Item item = inventario.buscarPorId(id);

        if (item == null) {
            System.out.println("Item com ID " + id + " não encontrado.");
            return;
        }

        System.out.println("Modificando o item: " + item.getNome());
        String novoNome = lerStringValida("Novo Nome: ");
        int novoPeso = lerInteiroPositivo("Novo Peso (kg): ");
        int novoValor = lerInteiroPositivo("Novo Valor (moedas): ");

        item.setNome(novoNome);
        item.setPeso(novoPeso);
        item.setValor(novoValor);

        if (item instanceof Arma) {
            Arma arma = (Arma) item; // Downcasting seguro
            int novoDano = lerInteiroPositivo("Novo Dano: ");
            String novoTipoDano = lerStringValida("Novo Tipo de Dano: ");
            arma.setDano(novoDano);
            arma.setTipoDano(novoTipoDano);
        } else if (item instanceof Pocao) {
            Pocao pocao = (Pocao) item; // Downcasting seguro
            int novaCura = lerInteiroPositivo("Nova Cura (HP): ");
            String novoEfeito = lerStringValida("Novo Efeito: ");
            pocao.setQuantidadeCura(novaCura);
            pocao.setEfeito(novoEfeito);
        }

        System.out.println("Item atualizado com sucesso!");
    }

    private static void removerItem() {
        inventario.listarItens();
        int id = lerInteiroValido("\nDigite o ID do item que deseja remover: ");
        
        if (inventario.removerItem(id)) {
            System.out.println("Item removido com sucesso!");
        } else {
            System.out.println("Item com ID " + id + " não encontrado.");
        }
    }

    private static int lerInteiroValido(String mensagem) {
        while (true) {
            System.out.print(mensagem);
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("[ERRO] Entrada inválida. Por favor, digite um número inteiro.");
            }
        }
    }

    private static int lerInteiroPositivo(String mensagem) {
        while (true) {
            int valor = lerInteiroValido(mensagem);
            if (valor >= 0) {
                return valor;
            }
            System.out.println("[ERRO] O valor não pode ser negativo.");
        }
    }

    private static String lerStringValida(String message) {
        while (true) {
            System.out.print(message);
            String entrada = scanner.nextLine().trim();
            if (!entrada.isEmpty()) {
                return entrada;
            }
            System.out.println("[ERRO] O campo não pode ficar em branco.");
        }
    }
}