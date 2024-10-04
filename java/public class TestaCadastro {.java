public class TestaCadastro {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CadastroPessoas cadastro = new CadastroPessoas();

        Cliente cliente1 = new Cliente("Jhon Kler", new Data(10, 5, 1990), 123);
        Gerente gerente1 = new Gerente("Yes, I'm Man", new Data(3, 12, 1985), 5000f, "Vendas");

        cadastro.cadastraPessoa(cliente1);
        cadastro.cadastraPessoa(gerente1);

        System.out.println("Total de pessoas cadastradas: " + cadastro.qtdAtual);

        System.out.print("Digite o índice da pessoa que deseja acessar: ");
        int index = scanner.nextInt();

        try {
            Pessoa p = cadastro.acessarPessoa(index); 
            p.imprimeDados();
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }
}