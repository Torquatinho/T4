package com.CadastroProdutos;

public class App
{
    public static void main( String[] args )
    {
        // Testando conexão
        ProdutoDB.testarConexao();

        // socorro
        Produto arroz = new Produto();
        arroz.setTipoProduto("Alimento");
        arroz.setDescricaoProduto("Arroz Integral - Camil - 1 Kilo");
        arroz.setPesoProduto(1F);
        arroz.setQuantidadeProduto(145);
        arroz.setUnidadeMedidaProduto("kg");

        Produto feijao = new Produto();
        feijao.setTipoProduto("Alimento");
        feijao.setDescricaoProduto("Feijão Carioca Tipo 1 Camil Pct 1kg");
        feijao.setPesoProduto(1F);
        feijao.setQuantidadeProduto(95);
        feijao.setUnidadeMedidaProduto("kg");

        Produto corda = new Produto();
        corda.setTipoProduto("Construção");
        corda.setDescricaoProduto("Corda De Sisal 20mm 5 Metros Naval Rasada Decoração");
        corda.setPesoProduto(2F);
        corda.setQuantidadeProduto(12);
        corda.setUnidadeMedidaProduto("metro");

        Produto tecido = new Produto();
        tecido.setTipoProduto("Artesanato");
        tecido.setDescricaoProduto("Tecido Em Metro Algodão Cru, Rolo Com 5 Metros");
        tecido.setPesoProduto(2.42F);
        tecido.setQuantidadeProduto(45);
        tecido.setUnidadeMedidaProduto("metro quadrado");

        Produto oleo = new Produto();
        oleo.setTipoProduto("Alimento");
        oleo.setDescricaoProduto("Óleo de Soja Orgânico Biorgânica 500ml");
        oleo.setPesoProduto(0.5F);
        oleo.setQuantidadeProduto(654);
        oleo.setUnidadeMedidaProduto("litro");

        System.out.println("\n\n======================================================\n\n");


        ProdutoDB.inserirProduto(arroz);
        ProdutoDB.inserirProduto(feijao);
        ProdutoDB.inserirProduto(corda);
        ProdutoDB.inserirProduto(tecido);
        ProdutoDB.inserirProduto(oleo);

        System.out.println("\n\n======================================================\n\n");


        
        ProdutoDB.listarProdutos();

        System.out.println("\n\n======================================================\n\n");


        
        arroz.setDescricaoProduto("Arroz Integral - Camil - 5 Kilos");
        arroz.setPesoProduto(5F);
        ProdutoDB.atualizarProduto(arroz,1);
        feijao.setQuantidadeProduto(93);
        ProdutoDB.atualizarProduto(feijao,2);

        System.out.println("\n\n======================================================\n\n");


        // Listar produtos do banco
        ProdutoDB.listarProdutos();

        System.out.println("\n\n======================================================\n\n");


        // Excluir produtos 
        ProdutoDB.excluirProduto(5);

        System.out.println("\n\n======================================================\n\n");


        // Listar produtos
        ProdutoDB.listarProdutos();

        System.out.println("\n\n======================================================\n\n");

    }
}