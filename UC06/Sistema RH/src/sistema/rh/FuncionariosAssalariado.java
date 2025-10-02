/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema.rh;


public class FuncionariosAssalariado extends Funcionario {
   
    private double salarioMensal;
    

    public FuncionariosAssalariado(String nome, String cpf, String endereco, String telefone, 
                                String setor, double salarioMensal) {
        super(nome, cpf, endereco, telefone, setor); 
        this.salarioMensal = salarioMensal;
    }
    
  
    public double getSalarioMensal() {
        return salarioMensal;
    }
    
    public void setSalarioMensal(double salarioMensal) {
        this.salarioMensal = salarioMensal;
    }
    
   
    @Override
    public void aplicarAumento(double percentual) {
        
        salarioMensal = salarioMensal * (1 + percentual / 100);
    }
    
    @Override
    public void mostrarDados() {
        super.mostrarDados();
        System.out.println("Tipo: Assalariado");
        System.out.println("Salário Mensal: R$ " + String.format("%.2f", salarioMensal));
        System.out.println("Pagamento: R$ " + String.format("%.2f", calcularSalario()));
    }
}
