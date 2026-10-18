# Questões Teóricas – Lista 04

## Questão 1 – Verdadeiro ou falso

**a) Os construtores de superclasse não são herdados por subclasses.**

**Verdadeira.** Construtores não são herdados. A subclasse apenas *chama* o construtor da superclasse, com `super(...)`, para inicializar a parte herdada do objeto.

**b) Um relacionamento "tem um" é implementado via herança.**

**Falsa.** Herança implementa o relacionamento **"é um"** (ex.: `Guerreiro` é um `Personagem`). O relacionamento **"tem um"** é implementado por **composição**: uma classe possui um atributo que referencia outro objeto (ex.: `Carro` tem um `Motor`).

**c) Quando uma subclasse redefinir um método de superclasse utilizando a mesma assinatura, diz-se que a subclasse sobrecarrega esse método de superclasse.**

**Falsa.** Redefinir um método com a mesma assinatura é **sobrescrita** (*override*). **Sobrecarga** (*overload*) é quando o nome é igual, mas a assinatura muda (tipo, quantidade ou ordem dos parâmetros).

---

## Questão 2 – `protected` versus `private`

### `private`

- Preserva o **encapsulamento**: só a própria classe acessa o atributo, e as subclasses usam getters e setters.
- A superclasse pode **mudar sua implementação interna** sem quebrar as subclasses.
- A superclasse mantém o controle da **validação** (ex.: saldo nunca negativo) em um único lugar.
- Há menos **acoplamento** entre superclasse e subclasses.

### `protected`

- As subclasses acessam os dados **diretamente**, sem chamar métodos de acesso.
- Facilita a **extensão** quando a hierarquia foi pensada para ser estendida.

### Desvantagens do `protected`

- Qualquer subclasse (e qualquer classe do mesmo pacote, em Java) pode alterar o estado diretamente e deixar o objeto **inconsistente**.
- Mudar o atributo na superclasse pode obrigar a alterar todas as subclasses (o problema da "classe base frágil").

### Conclusão

O ideal é declarar os atributos como `private` e expor às subclasses apenas o necessário por meio de **métodos `protected`** ou públicos. Assim, a superclasse controla seu estado e a extensão continua possível. Atributos `protected` só se justificam quando a simplicidade ou o desempenho compensam a perda de encapsulamento.

---

## Questão 3 – Chamada de construtores em hierarquias de herança

### Como funciona

Quando se cria um objeto de uma subclasse com `new`, a **primeira ação** do construtor da subclasse é chamar um construtor da superclasse, com `super(...)`. Isso se repete a cada nível da hierarquia, até chegar em `Object`. Os corpos dos construtores são então executados **de cima para baixo**: primeiro o da classe mais genérica, depois o da superclasse e, por último, o da subclasse.

```java
class Animal {
    Animal() { System.out.println("Animal"); }
}

class Cachorro extends Animal {
    Cachorro() {
        super(); // implícito se for omitido
        System.out.println("Cachorro");
    }
}

new Cachorro(); // imprime: Animal, depois Cachorro
```

### Por que a chamada é obrigatória (explícita ou implícita)?

- O objeto da subclasse contém dentro de si a parte herdada da superclasse (atributos e estado). Essa parte precisa ser **inicializada** antes de a subclasse usá-la, para que o objeto nasça em um estado consistente.
- Se `super(...)` não for escrito, o compilador insere automaticamente `super();`, que chama o construtor **sem argumentos** da superclasse.
- Se a superclasse **não tiver** construtor sem argumentos (só construtores com parâmetros), o compilador dá erro. Nesse caso, a subclasse deve chamar `super(args)` explicitamente, e essa chamada tem que ser a **primeira instrução** do construtor.
