// ========== CLASSE TRANSPORTE ==========
class Transporte {
    private String tipo;
    private double valor;
    
    // Construtor
    public Transporte(String tipo, double valor) {
        this.tipo = tipo;
        this.valor = valor;
    }
    
    // Getters e Setters
    public String getTipo() {
        return tipo;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public double getValor() {
        return valor;
    }
    
    public void setValor(double valor) {
        this.valor = valor;
    }
    
    @Override
    public String toString() {
        return String.format("Transporte: %s - $%.2f", tipo, valor);
    }
}

// ========== CLASSE HOSPEDAGEM ==========
class Hospedagem {
    private String descricao;
    private double valorDiaria;
    
    // Construtor
    public Hospedagem(String descricao, double valorDiaria) {
        this.descricao = descricao;
        this.valorDiaria = valorDiaria;
    }
    
    // Getters e Setters
    public String getDescricao() {
        return descricao;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public double getValorDiaria() {
        return valorDiaria;
    }
    
    public void setValorDiaria(double valorDiaria) {
        this.valorDiaria = valorDiaria;
    }
    
    @Override
    public String toString() {
        return String.format("Hospedagem: %s - $%.2f/dia", descricao, valorDiaria);
    }
}

// ========== CLASSE PACOTE DE VIAGEM ==========
class PacoteViagem {
    private Transporte transporte;
    private Hospedagem hospedagem;
    private String destino;
    private int quantidadeDias;
    
    // Construtor
    public PacoteViagem(Transporte transporte, Hospedagem hospedagem, 
                       String destino, int quantidadeDias) {
        this.transporte = transporte;
        this.hospedagem = hospedagem;
        this.destino = destino;
        this.quantidadeDias = quantidadeDias;
    }
    
    // Método para calcular total de hospedagem
    public double calcularTotalHospedagem() {
        return hospedagem.getValorDiaria() * quantidadeDias;
    }
    
    // Método para calcular valor com margem de lucro
    public double calcularValorComLucro(double valor, double margemPorcentagem) {
        double margem = valor * (margemPorcentagem / 100.0);
        return valor + margem;
    }
    
    // Método para calcular total do pacote
    public double calcularTotalPacote(double margemLucroPorcentagem, double taxasAdicionais) {
        double totalHospedagem = calcularTotalHospedagem();
        double subtotal = transporte.getValor() + totalHospedagem;
        double valorComLucro = calcularValorComLucro(subtotal, margemLucroPorcentagem);
        return valorComLucro + taxasAdicionais;
    }
    
    // Getters
    public Transporte getTransporte() {
        return transporte;
    }
    
    public Hospedagem getHospedagem() {
        return hospedagem;
    }
    
    public String getDestino() {
        return destino;
    }
    
    public int getQuantidadeDias() {
        return quantidadeDias;
    }
    
    @Override
    public String toString() {
        return String.format("""
            === PACOTE DE VIAGEM ===
            Destino: %s
            Duração: %d dias
            %s
            %s
            Total Hospedagem: $%.2f
            """, destino, quantidadeDias, transporte.toString(), 
            hospedagem.toString(), calcularTotalHospedagem());
    }
}

// ========== CLASSE VENDA ==========
class Venda {
    private String nomeCliente;
    private String formaPagamento;
    private PacoteViagem pacote;
    
    // Construtor
    public Venda(String nomeCliente, String formaPagamento, PacoteViagem pacote) {
        this.nomeCliente = nomeCliente;
        this.formaPagamento = formaPagamento;
        this.pacote = pacote;
    }
    
    // Método para converter dólar para real
    public double converterDolarParaReal(double valorDolar, double cotacaoDolar) {
        return valorDolar * cotacaoDolar;
    }
    
    // Método para mostrar total em dólar e real
    public void mostrarTotalPacote(double margemLucro, double taxas, double cotacaoDolar) {
        double totalDolar = pacote.calcularTotalPacote(margemLucro, taxas);
        double totalReal = converterDolarParaReal(totalDolar, cotacaoDolar);
        
        System.out.println("\n=== VALORES DO PACOTE ===");
        System.out.printf("Total em Dólar: $%.2f\n", totalDolar);
        System.out.printf("Total em Real: R$%.2f\n", totalReal);
        System.out.printf("Cotação utilizada: R$%.2f por dólar\n", cotacaoDolar);
    }
    
    // Getters
    public String getNomeCliente() {
        return nomeCliente;
    }
    
    public String getFormaPagamento() {
        return formaPagamento;
    }
    
    public PacoteViagem getPacote() {
        return pacote;
    }
    
    @Override
    public String toString() {
        return String.format("""
            === DADOS DA VENDA ===
            Cliente: %s
            Forma de Pagamento: %s
            %s
            """, nomeCliente, formaPagamento, pacote.toString());
    }
}

// ========== CLASSE PRINCIPAL ==========
import java.util.Scanner;

public class SistemaAgenciaViagens {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=================================");
        System.out.println("  SISTEMA AGÊNCIA DE VIAGENS");
        System.out.println("=================================\n");
        
        // === CRIANDO TRANSPORTE ===
        System.out.println("--- DADOS DO TRANSPORTE ---");
        System.out.print("Tipo de transporte (aéreo/rodoviário/marítimo): ");
        String tipoTransporte = scanner.nextLine();
        
        System.out.print("Valor do transporte (em dólares): $");
        double valorTransporte = scanner.nextDouble();
        
        Transporte transporte = new Transporte(tipoTransporte, valorTransporte);
        
        // === CRIANDO HOSPEDAGEM ===
        System.out.println("\n--- DADOS DA HOSPEDAGEM ---");
        scanner.nextLine(); // Limpar buffer
        System.out.print("Descrição da hospedagem: ");
        String descricaoHospedagem = scanner.nextLine();
        
        System.out.print("Valor da diária (em dólares): $");
        double valorDiaria = scanner.nextDouble();
        
        Hospedagem hospedagem = new Hospedagem(descricaoHospedagem, valorDiaria);
        
        // === CRIANDO PACOTE ===
        System.out.println("\n--- DADOS DO PACOTE ---");
        scanner.nextLine(); // Limpar buffer
        System.out.print("Destino da viagem: ");
        String destino = scanner.nextLine();
        
        System.out.print("Quantidade de dias: ");
        int quantidadeDias = scanner.nextInt();
        
        System.out.print("Margem de lucro (%): ");
        double margemLucro = scanner.nextDouble();
        
        System.out.print("Taxas adicionais (em dólares): $");
        double taxasAdicionais = scanner.nextDouble();
        
        PacoteViagem pacote = new PacoteViagem(transporte, hospedagem, destino, quantidadeDias);
        
        // === EXIBINDO INFORMAÇÕES DO PACOTE ===
        System.out.println("\n" + pacote.toString());
        double totalPacoteDolar = pacote.calcularTotalPacote(margemLucro, taxasAdicionais);
        System.out.printf("TOTAL DO PACOTE: $%.2f\n", totalPacoteDolar);
        
        // === CRIANDO VENDA ===
        System.out.println("\n--- DADOS DA VENDA ---");
        scanner.nextLine(); // Limpar buffer
        System.out.print("Nome do cliente: ");
        String nomeCliente = scanner.nextLine();
        
        System.out.print("Forma de pagamento: ");
        String formaPagamento = scanner.nextLine();
        
        System.out.print("Cotação do dólar hoje (R$): ");
        double cotacaoDolar = scanner.nextDouble();
        
        Venda venda = new Venda(nomeCliente, formaPagamento, pacote);
        
        // === EXIBINDO RESULTADO FINAL ===
        System.out.println("\n" + "=".repeat(40));
        System.out.println("           RESUMO DA VENDA");
        System.out.println("=".repeat(40));
        System.out.println(venda.toString());
        
        venda.mostrarTotalPacote(margemLucro, taxasAdicionais, cotacaoDolar);
        
        System.out.println("\n" + "=".repeat(40));
        System.out.println("     VENDA REGISTRADA COM SUCESSO!");
        System.out.println("=".repeat(40));
        
        scanner.close();
    }
}

// ========== EXEMPLO DE EXECUÇÃO ==========
/*
EXEMPLO DE USO:

=== ENTRADA DO USUÁRIO ===
Tipo de transporte: aéreo
Valor do transporte: 800.00
Descrição da hospedagem: Hotel 5 estrelas com café da manhã
Valor da diária: 150.00
Destino da viagem: Paris
Quantidade de dias: 7
Margem de lucro: 15
Taxas adicionais: 50.00
Nome do cliente: João Silva
Forma de pagamento: Cartão de Crédito
Cotação do dólar: 5.20

=== SAÍDA ESPERADA ===
=== PACOTE DE VIAGEM ===
Destino: Paris
Duração: 7 dias
Transporte: aéreo - $800.00
Hospedagem: Hotel 5 estrelas com café da manhã - $150.00/dia
Total Hospedagem: $1050.00

TOTAL DO PACOTE: $2177.50

=== DADOS DA VENDA ===
Cliente: João Silva
Forma de Pagamento: Cartão de Crédito

=== VALORES DO PACOTE ===
Total em Dólar: $2177.50
Total em Real: R$11323.00
Cotação utilizada: R$5.20 por dólar

CÁLCULOS REALIZADOS:
- Transporte: $800.00
- Hospedagem (7 dias × $150): $1050.00
- Subtotal: $1850.00
- Margem 15%: $277.50
- Valor com margem: $2127.50
- Taxas adicionais: $50.00
- TOTAL: $2177.50
- Em reais: $2177.50 × 5.20 = R$11323.00
*/