/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package agenciaviagem.atividade01;

/**
 *
 * @author Denise
 */
public class PacoteViagem {
    private Transporte transporte;
    private Hospedagem hospedagem;
    private String destino;
    private int quantidadeDias;
    
    public PacoteViagem(Transporte transporte,Hospedagem hospedagem, String destino, int quantidadeDias){
        this.transporte = transporte;
        this.hospedagem = hospedagem;
        this.destino = destino;
        this.quantidadeDias = quantidadeDias;   
    }
    public double calcularTotalHospedagem(){
        return hospedagem.getValorDiaria()*quantidadeDias;
    }
    public double calcularValorLucro(double valor, double margemPorcentagem){
        double margem = valor * (margemPorcentagem / 100.0);
        return valor + margem;
    }
    public double calcularTotalPacote(double margemLucroPorcentagem, double taxasAdicionais){
        double totalHospedagem = calcularTotalHospedagem();
        double subtotal = transporte.getValor() + totalHospedagem + taxasAdicionais;
        return calcularValorLucro(subtotal, margemLucroPorcentagem);
    }
    public Transporte getTransporte(){
        return transporte;
    }
    public void setTransporte(Transporte transporte){
        this.transporte = transporte;
    }
    public Hospedagem getHospedagem(){
        return hospedagem;
    }
    public void setHospedagem(Hospedagem hospedagem){
        this.hospedagem = hospedagem;
    }
    public String getDestino(){
        return destino;
    }
    public void setDestino(String destino){
        this.destino = destino;
    }
    public void setQuantidadeDias(int quantidadeDias){
        this.quantidadeDias = quantidadeDias;
    }
    @Override
    public String toString(){
        return String.format("Pacote para %s(%d dias) \n%s \n%s \nTotal Hospedagem: $%.2f", destino, quantidadeDias, transporte, hospedagem, calcularTotalHospedagem());
    }
}

