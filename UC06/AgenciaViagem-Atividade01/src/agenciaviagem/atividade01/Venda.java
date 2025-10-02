/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package agenciaviagem.atividade01;

/**
 *
 * @author Denise
 */
public class Venda {
    private String nomeCliente;
    private String formaPagamento;
    private PacoteViagem pacoteViagem;
    
    public Venda(String nomeCliente, String formaPagamento,PacoteViagem pacoteViagem){
        this.nomeCliente = nomeCliente;
        this.formaPagamento = formaPagamento;
        this.pacoteViagem = pacoteViagem;
    }
    public double converterDolarParaReais(double valorDolar,double cotacaoDolar){
        return valorDolar * cotacaoDolar;
    }
    public void mostrarTotalPacote(double margemLucro, double taxasAdicionais, double cotacaoDolar){
        double totalDolar = pacoteViagem.calcularTotalPacote(margemLucro, taxasAdicionais);
        double totalReais = converterDolarParaReais(totalDolar, cotacaoDolar);
        
        System.out.println("\n==RESUMO FINANCEIRO ==");
        System.out.printf("Total do Pacote(USD): $%.2f\n",totalDolar );
        System.out.printf("Total do Pacote (BRL): R$ %.2f\n", totalReais);
        System.out.printf("Cotação utilizada: R$ %.2f\n", cotacaoDolar);
    }
     public String getNomeCliente() {
        return nomeCliente;
    }
    
    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }
    
    public String getFormaPagamento() {
        return formaPagamento;
    }
    
    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }
    
    public PacoteViagem getPacoteViagem() {
        return pacoteViagem;
    }
    
    public void setPacoteViagem(PacoteViagem pacoteViagem) {
        this.pacoteViagem = pacoteViagem;
    }
    
    @Override
    public String toString() {
        return String.format("Cliente: %s\nForma de Pagamento: %s\n%s", 
                           nomeCliente, formaPagamento, pacoteViagem);
    }
}
