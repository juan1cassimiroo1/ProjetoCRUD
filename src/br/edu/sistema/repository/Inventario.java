package br.edu.sistema.repository;

import br.edu.sistema.model.Item;
import java.util.ArrayList;
import java.util.List;

public class Inventario {
    private List<Item> itens;
    private int proximoId;

    public Inventario() {
        this.itens = new ArrayList<>();
        this.proximoId = 1;
    }

    // CREATE
    public void adicionarItem(Item item) {
        itens.add(item);
        System.out.println("Item adicionado com sucesso!");
    }

    // READ
    public void listarItens() {
        if (itens.isEmpty()) {
            System.out.println("O inventário está vazio.");
            return;
        }
        System.out.println("\n--- ITENS NO INVENTÁRIO ---");
        for (Item item : itens) {
            System.out.println(item.toString());
        }
    }

    // Buscar por ID (Auxiliar para Update e Delete)
    public Item buscarPorId(int id) {
        for (Item item : itens) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    // DELETE
    public boolean removerItem(int id) {
        Item item = buscarPorId(id);
        if (item != null) {
            itens.remove(item);
            return true;
        }
        return false;
    }

    public int gerarProximoId() {
        return proximoId++;
    }
}