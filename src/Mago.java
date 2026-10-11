// Mago herda de Personagem.
// Entao ele ja tem nome, vida, nivel, moedas e os metodos gerais.
public class Mago extends Personagem {
    // Esses atributos sao especificos do Mago.
    private int mana;
    private int poderMagico;

    public Mago(String nome, int vida, int mana, int poderMagico) {
        // O construtor de Mago recebe nome e vida, mas esses dados
        // pertencem a parte comum que ja foi definida em Personagem.
        // Por isso usamos super(nome, vida): ele chama o construtor da classe pai
        // e deixa Personagem inicializar nome, vida, nivel e moedas.
        super(nome, vida);

        // Inicializa a parte especifica do Mago.
        this.mana = mana;
        this.poderMagico = poderMagico;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getPoderMagico() {
        return poderMagico;
    }

    public void setPoderMagico(int poderMagico) {
        this.poderMagico = poderMagico;
    }

    // Acao especifica do Mago.
    public void lancarMagia() {
        // Regra do enunciado: para lancar magia, precisa ter pelo menos 10 de mana.
        if (mana < 10) {
            System.out.println(getNome() + " nao possui mana suficiente para lancar magia.");
            return;
        }

        // Cada magia consome 10 pontos de mana.
        mana -= 10;
        System.out.println(getNome() + " lancou uma magia com poder magico "
                + poderMagico + ". Mana restante: " + mana);
    }

    // Sobrescreve o metodo da classe pai para mostrar tambem os dados do Mago.
    @Override
    public void exibirInformacoes() {
        super.exibirInformacoes();
        System.out.println("Mana: " + mana);
        System.out.println("Poder magico: " + poderMagico);
    }
}
