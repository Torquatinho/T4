class CadastroPessoas {
    ArrayList<Pessoa> pessoas;
    int qtdAtual;

    public CadastroPessoas() {
        pessoas = new ArrayList<>();
        qtdAtual = 0;
    }

    public void cadastraPessoa(Pessoa p) {
        pessoas.add(p);
        qtdAtual++;
    }

    public void imprimeCadastro() {
        for (Pessoa p : pessoas) {
            p.imprimeDados();
        }
    }