package br.edu.sistema.model;

public class Item {
    private int id;
    private String nome;
    private int peso;
    private int valor;

    public Item(int id, String nome, int peso, int valor){
        this.id = id;
        this.nome = nome;
        this.peso = peso;
        this.valor = valor;
    }
    
    public int getId() { return id; }
    public String getNome() {return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public int getPeso() { return peso; }
    public void setPeso(int peso) { this.peso = peso; }
    public int getValor() { return valor; }
    public void setValor(int valor) { this.valor = valor; }

    @Override
    public String toString() {
        return String.format("ID: %d | Nome: %s | Peso: %dkg | Valor: %d moedas", id, nome, peso, valor);
    }
}
