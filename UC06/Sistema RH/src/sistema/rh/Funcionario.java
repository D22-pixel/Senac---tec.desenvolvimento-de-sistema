/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema.rh;

/**
 *
 * @author Denise
 */
abstract class Funcionario {
    // Atributos protegidos - podem ser acessados pelas classes filhas
    protected String nome;
    protected String cpf;
    protected String endereco;
    protected String telefone;
    protected String setor;
    
    // Construtor da classe abstrata - inicializa os atributos comuns
    public Funcionario(String nome, String cpf, String endereco, String telefone, String setor) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.telefone = telefone;
        this.setor = setor;
    }
    
    // Métodos getters - encapsulamento para acesso controlado aos atributos
    public String getNome() {
        return nome;
    }
    
    public String getCpf() {
        return cpf;
    }
    
    public String getEndereco() {
        return endereco;
    }
    
    public String getTelefone() {
        return telefone;
    }
    
    public String getSetor() {
        return setor;
    }
    
    // Métodos setters - encapsulamento para modificação controlada dos atributos
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    public void setSetor(String setor) {
        this.setor = setor;
    }
    
    // Método para mostrar dados do funcionário - comum a todos os tipos
    public void mostrarDados() {
        System.out.println("Nome: " + nome);
        System.out.println("CPF: " + cpf);
        System.out.println("Endereço: " + endereco);
        System.out.println("Telefone: " + telefone);
        System.out.println("Setor: " + setor);
    }

    Object[] calcularSalario() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    void aplicarAumento(double percentualAumento) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}