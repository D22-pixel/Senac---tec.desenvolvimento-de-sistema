/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaimpostos;

public class ImpostoIPI extends ImpostoBase {
     private double valorProduto;
    private double valorFrete;
    private double valorSeguro;
    private double outrasDesp;
    private double aliquota;
   
    public ImpostoIPI(double valorProduto, double valorFrete, double valorSeguro, 
                     double outrasDesp, double aliquota) {
        super("IPI"); 
        this.valorProduto = valorProduto;
        this.valorFrete = valorFrete;
        this.valorSeguro = valorSeguro;
        this.outrasDesp = outrasDesp;
        this.aliquota = aliquota;
    }
  
    public double getValorProduto() {
        return valorProduto;
    }
    
    public double getValorFrete() {
        return valorFrete;
    }
    
    public double getValorSeguro() {
        return valorSeguro;
    }
    
    public double getOutrasDesp() {
        return outrasDesp;
    }
    
    public double getAliquota() {
        return aliquota;
    }
   
    public void setValorProduto(double valorProduto) {
        this.valorProduto = valorProduto;
    }
    
    public void setValorFrete(double valorFrete) {
        this.valorFrete = valorFrete;
    }
    
    public void setValorSeguro(double valorSeguro) {
        this.valorSeguro = valorSeguro;
    }
    
    public void setOutrasDesp(double outrasDesp) {
        this.outrasDesp = outrasDesp;
    }
    
    public void setAliquota(double aliquota) {
        this.aliquota = aliquota;
    }
 
    private double calcularBaseCalculo() {
       
        return valorProduto + valorFrete + valorSeguro + outrasDesp;
    }
   
    @Override
    public double calcularImposto() {
      
        double baseCalculo = calcularBaseCalculo();
        return baseCalculo * (aliquota / 100);
    }

    public String getDetalhesCalculo() {
        double baseCalculo = calcularBaseCalculo();
        return String.format("Base de Cálculo: R$ %.2f (Produto: R$ %.2f + Frete: R$ %.2f + Seguro: R$ %.2f + Outras: R$ %.2f) x %.2f%%", 
                           baseCalculo, valorProduto, valorFrete, valorSeguro, outrasDesp, aliquota);
    }
    
}
