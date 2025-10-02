/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Denise
 */
public class ImpostoPis extends ImpostoBase {

    private double valorDebito;
    private double valorCredito;
    
    private static final double ALIQUOTA_PIS = 1.65;

    public ImpostoPis(double valorDebito, double valorCredito) {
        super("PIS"); 
        this.valorDebito = valorDebito;
        this.valorCredito = valorCredito;
    }
    
    public double getValorDebito() {
        return valorDebito;
    }
    
    public double getValorCredito() {
        return valorCredito;
    }
    
    public void setValorDebito(double valorDebito) {
        this.valorDebito = valorDebito;
    }
    
    public void setValorCredito(double valorCredito) {
        this.valorCredito = valorCredito;
    }
    
    public double calcularImposto() {
       
        double baseCalculo = valorDebito - valorCredito;
        return baseCalculo * (ALIQUOTA_PIS / 100);
    }

    public String getDetalhesCalculo() {
        double baseCalculo = valorDebito - valorCredito;
        return String.format("Base de Cálculo: R$ %.2f (Débito: R$ %.2f - Crédito: R$ %.2f) x %.2f%%", 
                           baseCalculo, valorDebito, valorCredito, ALIQUOTA_PIS);
    }
}
