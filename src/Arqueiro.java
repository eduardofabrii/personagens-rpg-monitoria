// Arqueiro herda de Personagem.
// Ele aproveita a parte comum e adiciona suas proprias caracteristicas.
public class Arqueiro extends Personagem {
    // Esses atributos sao especificos do Arqueiro.
    private int quantidadeFlechas;
    private int precisao;

    public Arqueiro(String nome, int vida, int quantidadeFlechas, int precisao) {
        // O construtor de Arqueiro recebe nome e vida, mas esses dados
        // pertencem a parte comum que ja foi definida em Personagem.
        // Por isso usamos super(nome, vida): ele chama o construtor da classe pai
        // e deixa Personagem inicializar nome, vida, nivel e moedas.
        super(nome, vida);

        // Inicializa a parte especifica do Arqueiro.
        this.quantidadeFlechas = quantidadeFlechas;
        this.precisao = precisao;
    }

    public int getQuantidadeFlechas() {
        return quantidadeFlechas;
    }

    public void setQuantidadeFlechas(int quantidadeFlechas) {
        this.quantidadeFlechas = quantidadeFlechas;
    }

    public int getPrecisao() {
        return precisao;
    }

    public void setPrecisao(int precisao) {
        this.precisao = precisao;
    }

    // Acao especifica do Arqueiro.
    public void atirar() {
        // Regra do enunciado: se nao tiver flechas, nao pode atirar.
        if (quantidadeFlechas <= 0) {
            System.out.println(getNome() + " nao possui flechas para atirar.");
            return;
        }

        // Cada ataque consome uma flecha.
        quantidadeFlechas--;
        System.out.println(getNome() + " atirou uma flecha com precisao "
                + precisao + ". Flechas restantes: " + quantidadeFlechas);
    }

    // Sobrescreve o metodo da classe pai para mostrar tambem os dados do Arqueiro.
    @Override
    public void exibirInformacoes() {
        super.exibirInformacoes();
        System.out.println("Flechas: " + quantidadeFlechas);
        System.out.println("Precisao: " + precisao);
    }
}
