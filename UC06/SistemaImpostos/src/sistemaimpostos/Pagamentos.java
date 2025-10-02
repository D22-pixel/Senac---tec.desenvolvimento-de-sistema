/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaimpostos;


public class Pagamentos {
  
    private String nomeEmpresa;
    private java.util.List<Imposto> listaImpostos;
    
    public Pagamentos(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
      
        this.listaImpostos = new java.util.ArrayList<>();
    }
  
    public Pagamentos() {
        this(""); 
        this.listaImpostos = new java.util.ArrayList<>();
    }
    
    public String getNomeEmpresa() {
        return nomeEmpresa;
    }
    
    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }
    
    public java.util.List<Imposto> getListaImpostos() {
        return listaImpostos;
    }
   
    public void adicionarImposto(Imposto imposto) {
        listaImpostos.add(imposto);
        System.out.println("Imposto " + imposto.getDescricao() + " adicionado com sucesso!");
    }
   
    public boolean removerImposto(int indice) {
        if (indice >= 0 && indice < listaImpostos.size()) {
            Imposto removido = listaImpostos.remove(indice);
            System.out.println("Imposto " + removido.getDescricao() + " removido com sucesso!");
            return true;
        }
        return false;
    }
    
    public double calcularTotalImpostos() {
        double total = 0.0;

        for (Imposto imposto : listaImpostos) {
            total += imposto.calcularImposto(); 
        }
        return total;
    }
    
    public void mostrarImpostos() {
        if (listaImpostos.isEmpty()) {
            System.out.println("Nenhum imposto cadastrado.");
            return;
        }
        
        System.out.println("\n=== IMPOSTOS CADASTRADOS PARA: " + nomeEmpresa + " ===");
        
        for (int i = 0; i < listaImpostos.size(); i++) {
            Imposto imposto = listaImpostos.get(i);
            System.out.println("\n--- Imposto " + (i + 1) + " ---");
            System.out.println("Tipo: " + imposto.getDescricao());
            System.out.println("Valor Calculado: R$ " + String.format("%.2f", imposto.calcularImposto()));
            
            if (imposto instanceof ImpostoPIS pis) {
                System.out.println("Detalhes: " + pis.getDetalhesCalculo());
            } else if (imposto instanceof ImpostoIPI) {
                ImpostoIPI ipi = (ImpostoIPI) imposto;
                System.out.println("Detalhes: " + ipi.getDetalhesCalculo());
            }
        }
       
        System.out.println("\n=== RESUMO ===");
        System.out.println("Total de impostos cadastrados: " + listaImpostos.size());
        System.out.println("Valor total dos impostos: R$ " + String.format("%.2f", calcularTotalImpostos()));
    }
    
    public int getQuantidadeImpostos() {
        return listaImpostos.size();
    }
}
