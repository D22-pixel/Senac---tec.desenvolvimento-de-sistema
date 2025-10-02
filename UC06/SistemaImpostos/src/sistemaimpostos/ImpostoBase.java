/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaimpostos;

interface Imposto{
    
    double calcularImposto();
    
    String getDescricao();
}
abstract class ImpostoBase implements Imposto{
    
    protected String descricao;
    
     public ImpostoBase(String descricao) {
        this.descricao = descricao;
    }
    
    @Override
    public String getDescricao() {
        return descricao;
    }
    
    @Override
    public abstract double calcularImposto();
    
}
