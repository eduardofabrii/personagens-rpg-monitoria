// Guerreiro herda de Personagem.
// Isso significa que Guerreiro e um Personagem, mas com caracteristicas extras.
public class Guerreiro extends Personagem {
    // Esses atributos existem apenas no Guerreiro.
    // Por isso eles ficam aqui, e nao na classe Personagem.
    private int forca;
    private int armadura;

    public Guerreiro(String nome, int vida, int forca, int armadura) {
        // O construtor de Guerreiro recebe nome e vida, mas esses dados
        // pertencem a parte comum que ja foi definida em Personagem.
        // Por isso usamos super(nome, vida): ele chama o construtor da classe pai
        // e deixa Personagem inicializar nome, vida, nivel e moedas.
        super(nome, vida);

        // Depois do super, inicializamos a parte especifica do Guerreiro.
        this.forca = forca;
        this.armadura = armadura;
    }

    public int getForca() {
        return forca;
    }

    public void setForca(int forca) {
        this.forca = forca;
    }

    public int getArmadura() {
        return armadura;
    }

    public void setArmadura(int armadura) {
        this.armadura = armadura;
    }

    // Acao especifica do Guerreiro.
    // Mago e Arqueiro nao precisam ter esse metodo.
    public void golpear() {
        System.out.println(getNome() + " realizou um golpe com forca " + forca + ".");
    }

    // Override indica que estamos sobrescrevendo um metodo da classe pai.
    @Override
    public void exibirInformacoes() {
        // Reaproveita a exibicao geral de Personagem.
        super.exibirInformacoes();

        // Depois mostra as informacoes especificas do Guerreiro.
        System.out.println("Forca: " + forca);
        System.out.println("Armadura: " + armadura);
    }
}
