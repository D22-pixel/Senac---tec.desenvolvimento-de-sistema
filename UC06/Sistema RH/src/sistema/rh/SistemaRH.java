/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sistema.rh;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class SistemaRH {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        
        List<Funcionario> funcionarios = new ArrayList<>();
        
        System.out.println("=== SISTEMA DE RH - CADASTRO DE FUNCIONÁRIOS ===");
        System.out.println("Você pode cadastrar até 10 funcionários.");
        
    
        for (int i = 0; i < 10; i++) {
            System.out.println("\n--- Cadastro do Funcionário " + (i + 1) + " ---");
            
           
            System.out.print("Deseja cadastrar um funcionário? (s/n): ");
            String continuar = scanner.nextLine().toLowerCase();
            
      
            if (!continuar.equals("s") && !continuar.equals("sim")) {
                break;
            }
            
            
            System.out.print("Nome: ");
            String nome = scanner.nextLine();
            
            System.out.print("CPF: ");
            String cpf = scanner.nextLine();
            
            System.out.print("Endereço: ");
            String endereco = scanner.nextLine();
            
            System.out.print("Telefone: ");
            String telefone = scanner.nextLine();
            
            System.out.print("Setor: ");
            String setor = scanner.nextLine();
            
        
            System.out.print("Tipo de funcionário (1-Assalariado / 2-Horista): ");
            int tipo = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer do scanner
            
           
            if (tipo == 1) {
               
                System.out.print("Salário mensal: R$ ");
                double salarioMensal = scanner.nextDouble();
                scanner.nextLine(); 
                
                FuncionariosAssalariado funcionario = new FuncionariosAssalariado(
                    nome, cpf, endereco, telefone, setor, salarioMensal);
                funcionarios.add(funcionario);
                
            } else if (tipo == 2) {
                
                System.out.print("Horas trabalhadas: ");
                double horasTrabalhadas = scanner.nextDouble();
                
                System.out.print("Valor por hora: R$ ");
                double valorHora = scanner.nextDouble();
                scanner.nextLine(); 
                
               
                FuncionariosHorista funcionario = new FuncionariosHorista(
                    nome, cpf, endereco, telefone, setor, horasTrabalhadas, valorHora);
                funcionarios.add(funcionario);
                
            } else {
                
                System.out.println("Tipo inválido! Tente novamente.");
                i--;
                continue;
            }
            
            System.out.println("Funcionário cadastrado com sucesso!");
        }
        
      
        if (funcionarios.isEmpty()) {
            System.out.println("Nenhum funcionário foi cadastrado.");
            scanner.close();
            return;
        }
        
     
        System.out.println("\n=== DADOS DOS FUNCIONÁRIOS CADASTRADOS ===");
        for (int i = 0; i < funcionarios.size(); i++) {
            System.out.println("\n--- Funcionário " + (i + 1) + " ---");
          
            funcionarios.get(i).mostrarDados();
        }
        
       
        System.out.print("\nInforme o percentual de aumento geral para todos os funcionários: ");
        double percentualAumento = scanner.nextDouble();
        
     
        for (Funcionario funcionario : funcionarios) {
           
            funcionario.aplicarAumento(percentualAumento);
        }
        
        
        System.out.println("\n=== PAGAMENTOS APÓS AUMENTO DE " + percentualAumento + "% ===");
        for (int i = 0; i < funcionarios.size(); i++) {
            System.out.println("\n--- Funcionário " + (i + 1) + " ---");
            System.out.println("Nome: " + funcionarios.get(i).getNome());
            System.out.println("Tipo: " + 
                (funcionarios.get(i) instanceof FuncionariosAssalariado ? "Assalariado" : "Horista"));
            
            
            System.out.println("Novo Pagamento: R$ " + 
                String.format("%.2f", funcionarios.get(i).calcularSalario()));
        }
        
       
        scanner.close();
        
        System.out.println("\nSistema finalizado!");
    }

    }
    

