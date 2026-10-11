public class Main {
    public static void main(String[] args) {
        System.out.println("===== SISTEMA DE PERSONAGENS RPG =====");
        System.out.println();

        System.out.println("1) Criando um personagem de cada tipo");
        System.out.println();

        // Aqui criamos objetos a partir das classes.
        // Guerreiro, Mago e Arqueiro sao os tipos das variaveis de referencia.
        // O new cria o objeto na memoria e chama o construtor da classe.
        Guerreiro guerreiro = new Guerreiro("Aragorn", 120, 20, 15);
        Mago mago = new Mago("Gandalf", 80, 100, 30);
        Arqueiro arqueiro = new Arqueiro("Legolas", 90, 20, 25);

        System.out.println("2) Exibindo as informacoes iniciais");
        System.out.println();

        // Cada objeto chama seu proprio exibirInformacoes().
        // Como as classes filhas sobrescrevem esse metodo, cada uma mostra seus dados especificos.
        System.out.println("--- Guerreiro ---");
        guerreiro.exibirInformacoes();
        System.out.println();

        System.out.println("--- Mago ---");
        mago.exibirInformacoes();
        System.out.println();

        System.out.println("--- Arqueiro ---");
        arqueiro.exibirInformacoes();
        System.out.println();

        System.out.println("3) Usando as acoes especificas de cada classe filha");
        System.out.println();

        // Esses metodos existem apenas nas classes especificas.
        guerreiro.golpear();
        mago.lancarMagia();
        arqueiro.atirar();
        System.out.println();

        System.out.println("4) Mago lancando magias ate nao ter mana suficiente");
        System.out.println();

        // Enquanto o mago tiver mana suficiente, ele continua lancando magia.
        while (mago.getMana() >= 10) {
            mago.lancarMagia();
        }

        // Essa chamada extra serve para mostrar a mensagem de falta de mana.
        mago.lancarMagia();
        System.out.println();

        System.out.println("5) Arqueiro atirando ate ficar sem flechas");
        System.out.println();

        // Enquanto o arqueiro tiver flechas, ele continua atirando.
        while (arqueiro.getQuantidadeFlechas() > 0) {
            arqueiro.atirar();
        }

        // Essa chamada extra serve para mostrar a mensagem de falta de flechas.
        arqueiro.atirar();
        System.out.println();

        System.out.println("6) Usando acoes gerais herdadas de Personagem");
        System.out.println();

        // Mesmo sendo Guerreiro, Mago e Arqueiro, todos conseguem usar
        // os metodos que foram definidos na classe pai Personagem.
        System.out.println("--- Guerreiro usando metodos de Personagem ---");
        guerreiro.receberDano(30);
        guerreiro.recuperarVida(10);
        guerreiro.receberMoedas(50);
        guerreiro.subirNivel();
        System.out.println();

        System.out.println("--- Mago usando metodos de Personagem ---");
        mago.receberDano(15);
        mago.recuperarVida(20);
        mago.receberMoedas(100);
        mago.subirNivel();
        System.out.println();

        System.out.println("--- Arqueiro usando metodos de Personagem ---");
        arqueiro.receberDano(25);
        arqueiro.recuperarVida(5);
        arqueiro.receberMoedas(75);
        arqueiro.subirNivel();
        System.out.println();

        System.out.println("7) Exibindo as informacoes finais");
        System.out.println();

        System.out.println("--- Guerreiro ---");
        guerreiro.exibirInformacoes();
        System.out.println();

        System.out.println("--- Mago ---");
        mago.exibirInformacoes();
        System.out.println();

        System.out.println("--- Arqueiro ---");
        arqueiro.exibirInformacoes();
    }
}
