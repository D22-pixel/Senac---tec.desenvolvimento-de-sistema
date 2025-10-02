/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sistemaimpostos;

import java.util.Scanner;


public class SistemaImpostos {

    public static void main(String[] args) {
  
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== SISTEMA DE CÁLCULO DE IMPOSTOS ===");
        
        System.out.print("Informe o nome da empresa: ");
        String nomeEmpresa = scanner.nextLine();
        
        Pagamentos pagamentos = new Pagamentos(nomeEmpresa);
        
        System.out.println("\nEmpresa cadastrada: " + nomeEmpresa);
        System.out.println("Agora vamos cadastrar os impostos...");
        
        while (true) {
            System.out.println("\n=== CADASTRO DE IMPOSTOS ===");
            System.out.println("Tipos disponíveis:");
            System.out.println("1 - PIS (Programa de Integração Social)");
            System.out.println("2 - IPI (Imposto sobre Produtos Industrializados)");
            System.out.println("Digite 'pare' para encerrar o cadastramento");
            
            System.out.print("Escolha o tipo de imposto (1, 2 ou 'pare'): ");
            String opcao = scanner.nextLine().toLowerCase();
           
            if (opcao.equals("pare")) {
                System.out.println("Cadastramento de impostos encerrado.");
                break;
            }
            
            // Processa a escolha do usuário
            try {
                int tipoImposto = Integer.parseInt(opcao);
                
                switch (tipoImposto) {
                    case 1:
                        cadastrarPIS(scanner, pagamentos);
                        break;
                        
                    case 2:
                        
                        cadastrarIPI(scanner, pagamentos);
                        break;
                        
                    default:
                        System.out.println("Opção inválida! Escolha 1, 2 ou digite 'pare'.");
                        break;
                }
            } catch (NumberFormatException e) {
                
                System.out.println("Entrada inválida! Digite um número (1 ou 2) ou 'pare'.");
            }
        }
       
        System.out.println("\n" + "=".repeat(50));
        System.out.println("PROCESSAMENTO FINALIZADO");
        System.out.println("=".repeat(50));
        

        if (pagamentos.getQuantidadeImpostos() == 0) {
            System.out.println("Nenhum imposto foi cadastrado para a empresa " + nomeEmpresa);
        } else {
      
            pagamentos.mostrarImpostos();
        }
       
        scanner.close();
        System.out.println("\nSistema encerrado!");
    }
    
    private static void cadastrarPIS(Scanner scanner, Pagamentos pagamentos) {
        System.out.println("\n--- CADASTRO PIS ---");
        System.out.println("O PIS é calculado como: (Débito - Crédito) x 1,65%");
        
        try {

            System.out.print("Informe o valor total de débito (R$): ");
            double valorDebito = Double.parseDouble(scanner.nextLine());
           
            if (valorDebito < 0) {
                System.out.println("Erro: O valor de débito não pode ser negativo!");
                return;
            }
            
            System.out.print("Informe o valor total de crédito (R$): ");
            double valorCredito = Double.parseDouble(scanner.nextLine());
            
            if (valorCredito < 0) {
                System.out.println("Erro: O valor de crédito não pode ser negativo!");
                return;
            }
            
            ImpostoPIS pis = new ImpostoPIS(valorDebito, valorCredito);
           
            pagamentos.adicionarImposto(pis);
           
            System.out.println("Preview: " + pis.getDetalhesCalculo());
            System.out.println("Valor do PIS: R$ " + String.format("%.2f", pis.calcularImposto()));
            
        } catch (NumberFormatException e) {
            
            System.out.println("Erro: Valor inválido! Digite apenas números.");
        }
    }
    
    private static void cadastrarIPI(Scanner scanner, Pagamentos pagamentos) {
        System.out.println("\n--- CADASTRO IPI ---");
        System.out.println("O IPI é calculado como: (Produto + Frete + Seguro + Outras Despesas) x Alíquota%");
        
        try {

            System.out.print("Informe o valor do produto (R$): ");
            double valorProduto = Double.parseDouble(scanner.nextLine());
            
            if (valorProduto < 0) {
                System.out.println("Erro: O valor do produto não pode ser negativo!");
                return;
            }
          
            System.out.print("Informe o valor do frete (R$): ");
            double valorFrete = Double.parseDouble(scanner.nextLine());
            
            if (valorFrete < 0) {
                System.out.println("Erro: O valor do frete não pode ser negativo!");
                return;
            }
           
            System.out.print("Informe o valor do seguro (R$): ");
            double valorSeguro = Double.parseDouble(scanner.nextLine());
           
            if (valorSeguro < 0) {
                System.out.println("Erro: O valor do seguro não pode ser negativo!");
                return;
            }
           
            System.out.print("Informe outras despesas (R$): ");
            double outrasDesp = Double.parseDouble(scanner.nextLine());
           
            if (outrasDesp < 0) {
                System.out.println("Erro: O valor de outras despesas não pode ser negativo!");
                return;
            }
         
            System.out.print("Informe a alíquota (%): ");
            double aliquota = Double.parseDouble(scanner.nextLine());
       
            if (aliquota < 0 || aliquota > 100) {
                System.out.println("Erro: A alíquota deve estar entre 0% e 100%!");
                return;
            }
           
            ImpostoIPI ipi = new ImpostoIPI(valorProduto, valorFrete, valorSeguro, outrasDesp, aliquota);
            
            pagamentos.adicionarImposto(ipi);
      
            System.out.println("Preview: " + ipi.getDetalhesCalculo());
            System.out.println("Valor do IPI: R$ " + String.format("%.2f", ipi.calcularImposto()));
            
        } catch (NumberFormatException e) {
            
            System.out.println("Erro: Valor inválido! Digite apenas números.");
        }
    } 
    
}
