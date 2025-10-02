/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package agenciaviagem.atividade01;

/**
 *
 * @author Denise
 */
public class Hospedagem {
    private String descricao;
    private double valorDiaria;
    
    public Hospedagem (String descricao, double valorDiaria){
        this.descricao = descricao;
        this.valorDiaria = valorDiaria;
    }
    public String getDescricao(){
        return descricao;
    }
    public void setDescricao(String descrisao){
        this.descricao = descricao;
    }
    public double getValorDiaria(){
        return valorDiaria;
    }
    public void setValorDiaria(double valorDiaria){
        this.valorDiaria = valorDiaria;
    }
    
    @Override
    public String toString(){
        return String.format("Hospedagem: %s - Diária: $%.2f", descricao, valorDiaria);
    }
}
