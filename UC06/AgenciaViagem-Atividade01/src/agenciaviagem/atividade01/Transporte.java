/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package agenciaviagem.atividade01;

/**
 *
 * @author Denise
 */
public class Transporte {
    private String tipo;
    private double valor;
    
    public Transporte(String tipo, double valor){
        this.tipo = tipo;
        this.valor =valor;
    }
    public String getTipo(){
        return tipo;
    }
    public void setTipo(String tipo){
        this.tipo = tipo;
    }
    public double getValor(){
        return valor;
    }
    public void setValor (double valor){
        this.valor = valor;
    }
    @Override
    public String toString(){
        return String.format("Transporte: %s - Valor: $%.2f",tipo, valor);
    }
}
