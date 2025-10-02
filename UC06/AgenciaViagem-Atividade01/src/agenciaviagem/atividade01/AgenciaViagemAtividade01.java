/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package agenciaviagem.atividade01;

import java.util.Scanner;



public class AgenciaViagemAtividade01 {

public class SistemaViagemMain {
    private static Scanner scanner = new Scanner(System.in);
}

    public static void main(String[] args) {
         System.out.println("=== SISTEMA DE PACOTES DE VIAGEM ===\n");
        
        PacoteViagem pacote = criarPacoteViagem();
        
        System.out.print("Informe a margem de lucro (porcentagem): ");
        double margemLucro = scanner.nextDouble();
        
        System.out.print("Informe as taxas adicionais (USD): $");
        double taxasAdicionais = scanner.nextDouble();
        
        System.out.println("\n=== INFORMAÇÕES DO PACOTE ===");
        System.out.println(pacote);
        System.out.printf("Valor Total do Pacote: $%.2f\n", 
                         pacote.calcularTotalPacote(margemLucro, taxasAdicionais));
        
        Venda venda = criarVenda(pacote);
        
        System.out.print("\nInforme a cotação atual do dólar (BRL): R$ ");
        double cotacaoDolar = scanner.nextDouble();
        
        System.out.println("\n=== INFORMAÇÕES DA VENDA ===");
        System.out.println(venda);
        
        venda.mostrarTotalPacote(margemLucro, taxasAdicionais, cotacaoDolar);
        
        System.out.println("\n=== VENDA FINALIZADA COM SUCESSO! ===");
        scanner.close();
    }
    
    private static PacoteViagem criarPacoteViagem() {
        System.out.println("=== CRIANDO PACOTE DE VIAGEM ===");
        
        System.out.print("Tipo de transporte (aéreo, rodoviário, marítimo, etc.): ");
        scanner.nextLine(); // Limpar buffer
        String tipoTransporte = scanner.nextLine();
        
        System.out.print("Valor do transporte (USD): $");
        double valorTransporte = scanner.nextDouble();
        
        Transporte transporte = new Transporte(tipoTransporte, valorTransporte);
              
        System.out.print("Descrição da hospedagem: ");
        scanner.nextLine(); // Limpar buffer
        String descricaoHospedagem = scanner.nextLine();
        
        System.out.print("Valor da diária (USD): $");
        double valorDiaria = scanner.nextDouble();
        
        Hospedagem hospedagem = new Hospedagem(descricaoHospedagem, valorDiaria);
        
        System.out.print("Destino da viagem: ");
        scanner.nextLine(); // Limpar buffer
        String destino = scanner.nextLine();
        
        System.out.print("Quantidade de dias: ");
        int quantidadeDias = scanner.nextInt();
        
        return new PacoteViagem(transporte, hospedagem, destino, quantidadeDias);
    }
    
    private static Venda criarVenda(PacoteViagem pacote) {
        System.out.println("\n=== CRIANDO VENDA ===");
        
        System.out.print("Nome do cliente: ");
        scanner.nextLine(); // Limpar buffer
        String nomeCliente = scanner.nextLine();
        
        System.out.print("Forma de pagamento: ");
        String formaPagamento;
        formaPagamento = scanner.nextLine();
        
        return new Venda(nomeCliente, formaPagamento, pacote);
    }
 }
 
   
    
    
