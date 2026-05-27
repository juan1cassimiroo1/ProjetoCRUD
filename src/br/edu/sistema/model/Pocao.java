package br.edu.sistema.model;

public class Pocao extends Item {
    private int quantidadeCura;
    private String efeito;

    public Pocao(int id, String nome, int peso, int valor, int quatidadeCura, String efeito){
        super(id, nome, peso, valor);
        this.quantidadeCura = quatidadeCura;
        this.efeito = efeito;
    }
    
    public int getQuatidadeCura() { return quantidadeCura; }
    public void setQuantidadeCura(int quatidadeCura) { this.quantidadeCura = quatidadeCura; }
    public String getEfeito() { return efeito; }
    public void setEfeito(String efeito) { this.efeito = efeito; }

    @Override
    public String toString(){
        return super.toString() + String.format(" | [Poção] Cura: %d HP | Efeito: %s", quantidadeCura , efeito);

    }
}
