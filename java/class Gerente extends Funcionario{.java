class Gerente extends Funcionario{
    String area;
    public Gerente(String nome, Data nascimento, float salario, String area){
        super(nome, nascimento, salario);
        this.area = area;
    }
    @Override
    public abstract float calculaImposto(){
        return salario * 0.05f
}
    @Override
    public void imprimeDados(){
        super.imprimeDados();
        System.out.println("Área: "+ area + ", Imposto: " + calculaImposto());

    }
}