/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema.rh;


public class FuncionariosHorista extends Funcionario{
    private double horasTrabalhadas;
    private double valorHora;
    
    public FuncionariosHorista(String nome, String cpf, String endereco, String telefone, String setor, double horasTrabalhadas, double valorHora) {
        super(nome, cpf, endereco, telefone, setor); 
        this.horasTrabalhadas = horasTrabalhadas;
        this.valorHora = valorHora;
    }
    
    public double getHorasTrabalhadas() {
        return horasTrabalhadas;
    }
    
    public void setHorasTrabalhadas(double horasTrabalhadas) {
        this.horasTrabalhadas = horasTrabalhadas;
    }
    
    public double getValorHora() {
        return valorHora;
    }
    
    public void setValorHora(double valorHora) {
        this.valorHora = valorHora;
    }
    
    @Override
    public void aplicarAumento(double percentual) {
        valorHora = valorHora * (1 + percentual / 100);
    }
    
    @Override
    public void mostrarDados() {
        super.mostrarDados(); 
        System.out.println("Tipo: Horista");
        System.out.println("Horas Trabalhadas: " + horasTrabalhadas);
        System.out.println("Valor por Hora: R$ " + String.format("%.2f", valorHora));
        System.out.println("Pagamento: R$ " + String.format("%.2f", calcularSalario()));
    }
    
}
