// Personagem e a classe mais geral do projeto.
// Ela guarda tudo que Guerreiro, Mago e Arqueiro tem em comum.
public class Personagem {
    // Atributos privados representam o encapsulamento.
    // Outras classes nao acessam esses valores diretamente.
    private String nome;
    private int vida;
    private int nivel;
    private int moedas;

    // O construtor define como um personagem nasce.
    // Nome e vida chegam por parametro porque mudam de personagem para personagem.
    public Personagem(String nome, int vida) {
        this.nome = nome;
        this.vida = vida;

        // Nivel e moedas comecam com valores padrao do sistema.
        this.nivel = 1;
        this.moedas = 0;
    }

    // Getters permitem consultar os atributos privados de forma controlada.
    public String getNome() {
        return nome;
    }

    // Setters permitem alterar atributos privados quando fizer sentido.
    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getVida() {
        return vida;
    }

    public int getNivel() {
        return nivel;
    }

    public int getMoedas() {
        return moedas;
    }

    // Metodo geral: qualquer personagem pode receber dano.
    public void receberDano(int dano) {
        if (dano <= 0) {
            System.out.println(nome + " nao recebeu dano.");
            return;
        }

        vida -= dano;

        // Regra de protecao: a vida nao deve ficar negativa.
        if (vida < 0) {
            vida = 0;
        }

        System.out.println(nome + " recebeu " + dano + " de dano. Vida atual: " + vida);
    }

    // Metodo geral: qualquer personagem pode recuperar vida.
    public void recuperarVida(int quantidade) {
        if (quantidade <= 0) {
            System.out.println(nome + " nao recuperou vida.");
            return;
        }

        vida += quantidade;
        System.out.println(nome + " recuperou " + quantidade + " de vida. Vida atual: " + vida);
    }

    // Metodo geral: qualquer personagem pode receber moedas.
    public void receberMoedas(int quantidade) {
        if (quantidade <= 0) {
            System.out.println(nome + " nao recebeu moedas.");
            return;
        }

        moedas += quantidade;
        System.out.println(nome + " recebeu " + quantidade + " moedas. Total: " + moedas);
    }

    // Metodo geral: todo personagem possui nivel.
    public void subirNivel() {
        nivel++;
        System.out.println(nome + " subiu para o nivel " + nivel + ".");
    }

    // Esse metodo mostra apenas as informacoes comuns de todo personagem.
    // As classes filhas podem sobrescrever esse metodo para exibir dados extras.
    public void exibirInformacoes() {
        System.out.println("Nome: " + nome);
        System.out.println("Vida: " + vida);
        System.out.println("Nivel: " + nivel);
        System.out.println("Moedas: " + moedas);
    }
}
