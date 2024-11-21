import java.util.*;

public class Main {
//vou ficar louco, maluco, doido, pescopata, birutinha, gaga, naipe coringa
//nos brinca e zoa mas so Deus sabe com esta a cabeça do palhaço
//desculpa pelo desabafo teacher Lucas, fiquei uma persona louquinha 

    public static void main(String[] args) {
        List<Cidade> cidades = Arrays.asList(
            new Cidade("GO", "Anápolis", false),
            new Cidade("GO", "Goiânia", true),
            new Cidade("SP", "Ribeirão Preto", false),
            new Cidade("SP", "Campinas", false),
            new Cidade("MG", "Belo Horizonte", true),
            new Cidade("MG", "Uberlândia", false),
            new Cidade("MG", "Montes Claros", false),
            new Cidade("MG", "Unaí", false),
            new Cidade("TO", "Palmas", true),
            new Cidade("TO", "Araguarí", false),
            new Cidade("MT", "Cuiabá", true),
            new Cidade("MS", "Dourados", false),
            new Cidade("MS", "Campo Grande", true),
            new Cidade("MS", "Corumbá", false),
            new Cidade("MT", "Barra do Garças", false),
            new Cidade("MT", "Araguaiana", false),
            new Cidade("RO", "Porto Velho", true),
            new Cidade("RO", "Costa Marques", false)
        );

        
        Map<String, Set<Cidade>> cidadesPorUF = new TreeMap<>();
        for (Cidade cidade : cidades) {
            cidadesPorUF
                .computeIfAbsent(cidade.getUf(), k -> new TreeSet<>(Comparator.comparing(Cidade::getNome)))
                .add(cidade);
        }
        System.out.println("Cidades agrupadas por UF em ordem alfabética:");
        for (var entry : cidadesPorUF.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        
        List<Cidade> cidadesOrdenadas = new ArrayList<>(cidades);
        cidadesOrdenadas.sort(Comparator.comparing(Cidade::isCapital).reversed()
                                         .thenComparing(Cidade::getNome));
        System.out.println("\nCidades com capitais primeiro e ordenadas alfabeticamente:");
        for (Cidade cidade : cidadesOrdenadas) {
            System.out.println((cidade.isCapital() ? "(Capital) " : "") + cidade);
        }

        
        Set<Cidade> cidadesDecrescente = new TreeSet<>(Comparator.comparing(Cidade::getNome).reversed());
        cidadesDecrescente.addAll(cidades);
        System.out.println("\nCidades em ordem alfabética decrescente:");
        for (Cidade cidade : cidadesDecrescente) {
            System.out.println(cidade);
        }
    }
}

class Cidade {
    private String nome;
    private String uf;
    private boolean capital;

    public Cidade(String uf, String nome, boolean capital) {
        this.uf = uf;
        this.nome = nome;
        this.capital = capital;
    }

    public String getNome() {
        return nome;
    }

    public String getUf() {
        return uf;
    }

    public boolean isCapital() {
        return capital;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public void setCapital(boolean capital) {
        this.capital = capital;
    }

    @Override
    public String toString() {
        return nome + " - " + uf;
    }
}
