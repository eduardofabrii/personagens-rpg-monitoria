# Atividade 5 - Hierarquia de Classes Basicos

## Enunciado da atividade

O enunciado original da atividade esta disponivel no Canvas:

[Evoluindo o sistema de personagens](https://pucpr.instructure.com/courses/71363/assignments/360804?module_item_id=1804701)

## Ideia da atividade

Nesta atividade, o objetivo e evoluir um sistema de personagens de RPG.

Antes, existia apenas a classe `Personagem`. Agora, o sistema precisa ter tipos diferentes de personagem:

- `Guerreiro`
- `Mago`
- `Arqueiro`

O ponto principal da atividade e perceber que esses tres tipos possuem coisas em comum, mas tambem possuem caracteristicas proprias.

Por isso, usamos **heranca**.

## Pensando antes de programar

Antes de criar as classes, a primeira pergunta e:

> O que todos os personagens tem em comum?

Todos os personagens possuem:

- nome
- vida
- nivel
- moedas

Todos tambem conseguem:

- receber dano
- recuperar vida
- receber moedas
- subir de nivel
- exibir informacoes

Essas informacoes ficam na classe mais geral:

```java
public class Personagem
```

Depois fazemos outra pergunta:

> O que existe apenas em cada tipo de personagem?

O `Guerreiro` possui:

- forca
- armadura
- golpear()

O `Mago` possui:

- mana
- poder magico
- lancarMagia()

O `Arqueiro` possui:

- quantidade de flechas
- precisao
- atirar()

Essas informacoes ficam nas classes especificas.

Assim o codigo evita repeticao. A parte comum fica em `Personagem`, e cada classe filha fica apenas com aquilo que pertence a ela.

## Diagrama simples

```text
Personagem
  nome
  vida
  nivel
  moedas
  receberDano()
  recuperarVida()
  receberMoedas()
  subirNivel()
  exibirInformacoes()

Guerreiro extends Personagem
  forca
  armadura
  golpear()

Mago extends Personagem
  mana
  poderMagico
  lancarMagia()

Arqueiro extends Personagem
  quantidadeFlechas
  precisao
  atirar()
```

## Explicando os conceitos principais

### Classe

Classe e um molde.

Exemplo:

```java
public class Personagem
```

A classe `Personagem` define o que um personagem deve ter e o que ele consegue fazer.

### Objeto

Objeto e aquilo que nasce de uma classe.

Exemplo:

```java
Guerreiro guerreiro = new Guerreiro("Aragorn", 120, 20, 15);
```

Nesse exemplo:

- `Guerreiro` e o tipo da variavel de referencia.
- `guerreiro` e a variavel de referencia.
- `new Guerreiro(...)` cria o objeto na memoria.
- `"Aragorn", 120, 20, 15` sao os valores usados para inicializar o objeto.

### Heranca

Heranca permite que uma classe aproveite atributos e metodos de outra classe.

Exemplo:

```java
public class Guerreiro extends Personagem
```

Isso significa:

> Guerreiro e um Personagem.

Como `Guerreiro` herda de `Personagem`, ele pode usar os metodos gerais que foram criados na classe pai, como:

- `receberDano()`
- `recuperarVida()`
- `receberMoedas()`
- `subirNivel()`
- `exibirInformacoes()`

O mesmo acontece com `Mago` e `Arqueiro`.

### Classe pai e classe filha

Neste projeto:

```text
Personagem = classe pai
Guerreiro  = classe filha
Mago       = classe filha
Arqueiro   = classe filha
```

A classe pai guarda o que e geral.

As classes filhas guardam o que e especifico.

### super

O `super` chama o construtor da classe pai.

Exemplo:

```java
super(nome, vida);
```

Quando criamos um `Guerreiro`, ele tambem precisa inicializar a parte de `Personagem`, porque todo guerreiro tem nome, vida, nivel e moedas.

Entao o `super(nome, vida)` manda o nome e a vida para o construtor de `Personagem`.

Depois disso, a classe filha inicializa os atributos especificos dela.

### Override

O `@Override` indica que a classe filha esta sobrescrevendo um metodo que ja existe na classe pai.

Exemplo:

```java
@Override
public void exibirInformacoes()
```

No projeto, `Personagem` ja possui o metodo `exibirInformacoes()`.

Mas `Guerreiro`, `Mago` e `Arqueiro` precisam mostrar informacoes extras.

Por isso, cada classe filha sobrescreve esse metodo.

Dentro dele, usamos:

```java
super.exibirInformacoes();
```

Isso reaproveita a exibicao geral da classe `Personagem`.

Depois, a classe filha mostra suas informacoes especificas.

## Explicacao das classes

## Personagem.java

A classe `Personagem` representa tudo que qualquer personagem do jogo possui.

Ela e a classe mais geral do sistema.

```java
private String nome;
private int vida;
private int nivel;
private int moedas;
```

Esses atributos ficam em `Personagem` porque todos os personagens possuem essas informacoes.

Eles estao como `private` para proteger o estado do objeto. Isso significa que outras classes nao acessam esses atributos diretamente.

### Construtor de Personagem

```java
public Personagem(String nome, int vida) {
    this.nome = nome;
    this.vida = vida;
    this.nivel = 1;
    this.moedas = 0;
}
```

O construtor define como um objeto do tipo `Personagem` nasce.

O `nome` e a `vida` entram por parametro porque podem mudar de personagem para personagem.

O `nivel` comeca em `1`, porque essa e uma regra do sistema.

As `moedas` comecam em `0`, porque o personagem ainda nao recebeu nenhuma moeda.

### getNome()

```java
public String getNome()
```

Esse metodo retorna o nome do personagem.

Ele e importante porque as classes filhas precisam usar o nome em mensagens, como no golpe do guerreiro ou na magia do mago.

### receberDano()

```java
public void receberDano(int dano)
```

Esse metodo diminui a vida do personagem.

Ele primeiro verifica se o dano e menor ou igual a zero. Se for, nao faz sentido aplicar dano.

Depois, subtrai o dano da vida.

Se a vida ficar menor que zero, o codigo ajusta para zero:

```java
if (vida < 0) {
    vida = 0;
}
```

Isso evita que o personagem fique com vida negativa.

### recuperarVida()

```java
public void recuperarVida(int quantidade)
```

Esse metodo aumenta a vida do personagem.

Ele tambem valida se a quantidade e maior que zero.

Como qualquer personagem pode recuperar vida, esse metodo fica na classe `Personagem`.

### receberMoedas()

```java
public void receberMoedas(int quantidade)
```

Esse metodo adiciona moedas ao personagem.

Ele representa uma acao geral do jogo. Nao importa se o personagem e guerreiro, mago ou arqueiro, todos podem receber moedas.

### subirNivel()

```java
public void subirNivel()
```

Esse metodo aumenta o nivel em `1`.

Como todos os personagens possuem nivel, esse comportamento tambem fica na classe pai.

### exibirInformacoes()

```java
public void exibirInformacoes()
```

Esse metodo mostra as informacoes gerais do personagem:

- nome
- vida
- nivel
- moedas

As classes filhas reaproveitam esse metodo e depois mostram suas informacoes especificas.

## Guerreiro.java

A classe `Guerreiro` representa um tipo especifico de personagem.

```java
public class Guerreiro extends Personagem
```

O `extends Personagem` significa que `Guerreiro` herda de `Personagem`.

Ou seja:

> Guerreiro e um Personagem.

Por isso, o guerreiro ja possui nome, vida, nivel, moedas e os metodos gerais.

### Atributos do Guerreiro

```java
private int forca;
private int armadura;
```

Esses atributos ficam em `Guerreiro` porque sao especificos dele.

O `Mago` nao precisa de armadura.

O `Arqueiro` nao precisa de forca para golpear.

Por isso, esses dados nao devem ficar em `Personagem`.

### Construtor do Guerreiro

```java
public Guerreiro(String nome, int vida, int forca, int armadura) {
    super(nome, vida);
    this.forca = forca;
    this.armadura = armadura;
}
```

O construtor recebe tudo que o guerreiro precisa para nascer.

`nome` e `vida` sao enviados para a classe pai com:

```java
super(nome, vida);
```

`forca` e `armadura` sao guardados dentro da propria classe `Guerreiro`.

### golpear()

```java
public void golpear()
```

Esse metodo e uma acao especifica do guerreiro.

Ele mostra uma mensagem dizendo que o personagem realizou um golpe e informa o valor da forca.

Esse metodo fica em `Guerreiro`, porque nao faz sentido obrigar todo personagem a ter a acao de golpear.

### exibirInformacoes()

```java
@Override
public void exibirInformacoes()
```

Aqui o guerreiro sobrescreve o metodo da classe pai.

Primeiro ele chama:

```java
super.exibirInformacoes();
```

Isso mostra nome, vida, nivel e moedas.

Depois ele mostra:

- forca
- armadura

Assim, o metodo mostra tanto a parte geral quanto a parte especifica do guerreiro.

## Mago.java

A classe `Mago` tambem herda de `Personagem`.

```java
public class Mago extends Personagem
```

Isso significa:

> Mago e um Personagem.

Entao o mago tambem tem nome, vida, nivel, moedas e os metodos gerais.

### Atributos do Mago

```java
private int mana;
private int poderMagico;
```

Esses atributos sao especificos do mago.

A `mana` representa a energia usada para lancar magia.

O `poderMagico` representa a forca da magia.

### Construtor do Mago

```java
public Mago(String nome, int vida, int mana, int poderMagico) {
    super(nome, vida);
    this.mana = mana;
    this.poderMagico = poderMagico;
}
```

Assim como no guerreiro, `nome` e `vida` sao passados para a classe pai.

Depois, o mago guarda `mana` e `poderMagico`, que sao caracteristicas proprias dele.

### lancarMagia()

```java
public void lancarMagia()
```

Esse metodo representa a acao especifica do mago.

Pelo enunciado, o mago precisa ter pelo menos 10 pontos de mana para lancar uma magia.

Por isso existe esta verificacao:

```java
if (mana < 10) {
    System.out.println(getNome() + " nao possui mana suficiente para lancar magia.");
    return;
}
```

Se a mana for menor que 10, o metodo mostra uma mensagem e para.

O `return` encerra o metodo naquele momento.

Se o mago tiver mana suficiente, o codigo executa:

```java
mana -= 10;
```

Isso desconta 10 pontos de mana.

### exibirInformacoes()

O mago tambem sobrescreve `exibirInformacoes()`.

Primeiro, ele chama o metodo da classe pai:

```java
super.exibirInformacoes();
```

Depois mostra:

- mana
- poder magico

## Arqueiro.java

A classe `Arqueiro` tambem representa um tipo especifico de personagem.

```java
public class Arqueiro extends Personagem
```

Isso significa:

> Arqueiro e um Personagem.

Ele herda os comportamentos gerais de `Personagem`, mas tambem possui seus proprios atributos e metodos.

### Atributos do Arqueiro

```java
private int quantidadeFlechas;
private int precisao;
```

A `quantidadeFlechas` controla quantas flechas o arqueiro ainda possui.

A `precisao` representa a qualidade do ataque dele.

Esses atributos ficam em `Arqueiro`, porque sao especificos desse tipo de personagem.

### Construtor do Arqueiro

```java
public Arqueiro(String nome, int vida, int quantidadeFlechas, int precisao) {
    super(nome, vida);
    this.quantidadeFlechas = quantidadeFlechas;
    this.precisao = precisao;
}
```

O `super(nome, vida)` inicializa a parte comum do personagem.

Depois, o construtor guarda a quantidade de flechas e a precisao.

### atirar()

```java
public void atirar()
```

Esse metodo representa a acao especifica do arqueiro.

Antes de atirar, o codigo verifica se ainda existem flechas:

```java
if (quantidadeFlechas <= 0) {
    System.out.println(getNome() + " nao possui flechas para atirar.");
    return;
}
```

Se nao houver flechas, o ataque nao acontece.

Se houver flechas, o arqueiro atira e uma flecha e consumida:

```java
quantidadeFlechas--;
```

### exibirInformacoes()

O arqueiro tambem sobrescreve `exibirInformacoes()`.

Ele reaproveita a exibicao geral de `Personagem` e depois mostra:

- flechas
- precisao

## Main.java

A classe `Main` serve para testar o sistema.

Ela cria os objetos e chama os metodos para verificar se tudo funciona.

### Criando os objetos

```java
Guerreiro guerreiro = new Guerreiro("Aragorn", 120, 20, 15);
Mago mago = new Mago("Gandalf", 80, 100, 30);
Arqueiro arqueiro = new Arqueiro("Legolas", 90, 20, 25);
```

Aqui criamos um objeto de cada classe filha.

Cada objeto recebe os dados necessarios para inicializar a parte geral e a parte especifica.

No guerreiro:

```java
new Guerreiro("Aragorn", 120, 20, 15)
```

Significa:

- nome: Aragorn
- vida: 120
- forca: 20
- armadura: 15

No mago:

```java
new Mago("Gandalf", 80, 100, 30)
```

Significa:

- nome: Gandalf
- vida: 80
- mana: 100
- poder magico: 30

No arqueiro:

```java
new Arqueiro("Legolas", 90, 20, 25)
```

Significa:

- nome: Legolas
- vida: 90
- flechas: 20
- precisao: 25

### Exibindo informacoes

```java
guerreiro.exibirInformacoes();
mago.exibirInformacoes();
arqueiro.exibirInformacoes();
```

Cada objeto chama seu proprio metodo `exibirInformacoes()`.

Como as classes filhas sobrescreveram esse metodo, cada uma mostra suas informacoes gerais e especificas.

### Usando acoes especificas

```java
guerreiro.golpear();
mago.lancarMagia();
arqueiro.atirar();
```

Esses metodos mostram o comportamento especifico de cada classe.

O guerreiro golpeia.

O mago lanca magia.

O arqueiro atira.

### Testando a regra da mana

```java
while (mago.getMana() >= 10) {
    mago.lancarMagia();
}

mago.lancarMagia();
```

Esse trecho faz o mago lancar magia enquanto ainda possui mana suficiente.

Quando a mana fica menor que 10, o ultimo `mago.lancarMagia()` mostra a mensagem dizendo que nao ha mana suficiente.

Isso testa a regra pedida no enunciado.

### Testando a regra das flechas

```java
while (arqueiro.getQuantidadeFlechas() > 0) {
    arqueiro.atirar();
}

arqueiro.atirar();
```

Esse trecho faz o arqueiro atirar ate acabar as flechas.

Depois que as flechas acabam, o ultimo `arqueiro.atirar()` mostra a mensagem dizendo que ele nao possui flechas.

Isso testa a regra pedida no enunciado.

### Usando metodos herdados

```java
guerreiro.receberDano(30);
guerreiro.recuperarVida(10);
guerreiro.receberMoedas(50);
guerreiro.subirNivel();
```

Esses metodos foram criados em `Personagem`.

Mesmo assim, o `Guerreiro` consegue usar todos eles, porque ele herda de `Personagem`.

O mesmo acontece com `Mago` e `Arqueiro`.

Esse e o ponto mais importante da atividade.

## Resumo final

`Personagem` guarda tudo que e comum.

`Guerreiro`, `Mago` e `Arqueiro` guardam apenas o que e especifico.

A heranca evita repeticao e organiza melhor o codigo.

O `super` chama a classe pai.

O `@Override` permite que a classe filha adapte um metodo herdado.

O `Main` testa se os personagens continuam tendo os comportamentos gerais e tambem seus comportamentos especificos.

## Como executar

Entre na pasta `src`:

```bash
cd src
```

Compile:

```bash
javac *.java
```

Execute:

```bash
java Main
```
