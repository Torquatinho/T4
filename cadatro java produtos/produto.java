package com.CadastroProdutos;

public class Produto {
    String tipoProduto;
    String descricaoProduto;
    float pesoProduto;
    int quantidadeProduto;
    String unidadeMedidaProduto;

    void setTipoProduto(String tipoProduto){
        this.tipoProduto = tipoProduto;
    }

    void setDescricaoProduto(String descricaoProduto){
        this.descricaoProduto = descricaoProduto;
    }

    void setPesoProduto(float pesoProduto){
        this.pesoProduto = pesoProduto;
    }

    void setQuantidadeProduto(int quantidadeProduto){
        this.quantidadeProduto = quantidadeProduto;
    }

    void setUnidadeMedidaProduto(String unidadeMedidaProduto){
        if (unidadeMedidaProduto.equalsIgnoreCase("metro") ||
                unidadeMedidaProduto.equalsIgnoreCase("metro quadrado") ||
                unidadeMedidaProduto.equalsIgnoreCase("litro") ||
                unidadeMedidaProduto.equalsIgnoreCase("kg")) {
            this.unidadeMedidaProduto = unidadeMedidaProduto;
        } else {
            System.out.println("Unidade de medida inválida");
        }
    }

    String getTipoProduto(){
        return tipoProduto;
    }

    String getDescricaoProduto(){
        return descricaoProduto;
    }

    float getPesoProduto(){
        return pesoProduto;
    }

    int getQuantidadeProduto(){
        return quantidadeProduto;
    }

    String getUnidadeMedidaProduto(){
        return unidadeMedidaProduto;
    }
}