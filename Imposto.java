
abstract class Imposto {
    abstract double calcular(double valor);
}

enum TipoItem {
    PRODUTO,
    SERVICO
}

class ISS extends Imposto {
    private static final double ALIQUOTA = 0.073;

    double calcular(double valor) {
        return valor * ALIQUOTA;
    }
}

class ICMS extends Imposto {
    private static final double ALIQUOTA = 0.132;

    double calcular(double valor) {
        return valor * ALIQUOTA;
    }
}

class IPI extends Imposto {
    private static final double ALIQUOTA = 0.219;


    double calcular(double valor) {
        return valor * ALIQUOTA;
    }
}

class Item {
    private String nome;
    private double valor;
    private TipoItem tipo;

    public Item(String nome, double valor, TipoItem tipo) {
        this.nome = nome;
        this.valor = valor;
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public double getValor() {
        return valor;
    }

    public TipoItem getTipo() {
        return tipo;
    }
}

class OperacaoComercial {
    private Item item;
    private double impostoISS;
    private double impostoICMS;
    private double impostoIPI;

    public OperacaoComercial(Item item) {
        this.item = item;
        calcularImpostos();
    }

    private void calcularImpostos() {
        ISS iss = new ISS();
        ICMS icms = new ICMS();
        IPI ipi = new IPI();

        if (item.getTipo() == TipoItem.SERVICO) {
            impostoISS = iss.calcular(item.getValor());
            impostoICMS = icms.calcular(item.getValor());
            impostoIPI = 0;
        } else if (item.getTipo() == TipoItem.PRODUTO) {
            impostoISS = 0;
            impostoICMS = icms.calcular(item.getValor());
            impostoIPI = ipi.calcular(item.getValor());
        }
    }

    public void detalharOperacao() {
        double valorTotal = item.getValor() + impostoISS + impostoICMS + impostoIPI;

        System.out.println("Item: " + item.getNome());
        System.out.println("Tipo: " + item.getTipo());
        System.out.println("Valor original: R$" + item.getValor());
        if (impostoISS > 0) {
            System.out.println("ISS: R$" + impostoISS);
        }
        if (impostoICMS > 0) {
            System.out.println("ICMS: R$" + impostoICMS);
        }
        if (impostoIPI > 0) {
            System.out.println("IPI: R$" + impostoIPI);
        }
        System.out.println("Valor total da operação: R$" + valorTotal);
    }
}

public class Main {
    public static void main(String[] args) {
        Item servico = new Item("Consultoria", 2000, TipoItem.SERVICO);
        OperacaoComercial operacaoServico = new OperacaoComercial(servico);
        operacaoServico.detalharOperacao();

        System.out.println();
        
        Item produto = new Item("Notebook", 5000, TipoItem.PRODUTO);
        OperacaoComercial operacaoProduto = new OperacaoComercial(produto);
        operacaoProduto.detalharOperacao();
    }
}
