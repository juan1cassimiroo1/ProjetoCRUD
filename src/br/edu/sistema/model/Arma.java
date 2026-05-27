package br.edu.sistema.model;

public class Arma extends Item {
    private int dano;
    private String tipoDano;

    public Arma(int id, String nome, int peso, int valor, int dano, String tipoDano){
        super(id, nome, peso, valor);
        this.dano = dano;
        this.tipoDano = tipoDano;
    }

    public int getDano() { return dano;}
    public void setDano(int dano) { this.dano = dano; }
    public String getTipoDano() { return tipoDano; }
    public void setTipoDano(String tipoDano) { this.tipoDano = tipoDano; }

    @Override
    public String toString() {
        return super.toString() + String.format(" | [Arma] Dano; %d | tipo: %s", dano, tipoDano);
    }
    
}
