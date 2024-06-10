Estudos de kotlin - primeiro curso, conceitos básicos:

Kotlin é uma linguagem de programação moderna, concisa e segura, desenvolvida pela JetBrains. Ela roda na Máquina Virtual Java (JVM) e também pode ser compilada para JavaScript ou nativamente com o LLVM.

Recursos Principais:
   - Concisa e expressiva, reduzindo a quantidade de código boilerplate.
   - Segurança de tipo, incluindo suporte para nulos.
   - Total interoperabilidade com Java.
   - Amplamente usada para o desenvolvimento Android, servidores e aplicativos multiplataforma.
   - Linguagem oficial da android
     
## Primeiras impressões: 

Seu fim de extensão e "kt" e diferente de toda a verbosidade do Java para fazer um olá mundo, o kotlin permite de maneira bem concisa dizer o famoso, através do termo "fun", este é o termo usado para funções no kotlin, como no exemplo:
```kotlin
  fun main() {
      println("Olá, Mundo!")
  }
```
Aqui reside uma vantagem que é a possibilidade de tanto funções quanto class, como no exemplo abaixo: 

```kotlin
class Pessoa {
    var nome: String = ""
    var idade: Int = 0
}
```
## Tipagem dinâmica:

O Kotlin permite a tipagem dinâmica, de modo que eu não preciso a passar como no java, isso não significa que eu não possa passar, inclusive imagino que isto é uma boa prática.

```kotlin
val x = 10 // O tipo de x será inferido como Int
val y = "Olá" // O tipo de y será inferido como String
val z: Any = 3.14 // Aqui, z é explicitamente declarado como Any, permitindo que ele possa conter qualquer tipo de valor
```

### Declaração de variáveis:

A declaração de variáveis em Kotlin é feita por dois termos: "var" e "val". A diferença entre eles é que "val" é imutável, ou seja, uma constante, geralmente usada para leitura. Para indicar se uma variável pode ser nula, basta adicionar o ponto de interrogação. O mesmo vale para atributos. Também é importante destacar que as strings devem ser inicializadas com um valor, mesmo que vazio.

```kotlin
var idade = 30 // Declara uma variável mutável
idade = 31 // OK, pois 'var' permite reatribuição
val nome = "João" // Declara uma variável somente leitura
nome = "Maria" // ERRO: 'val' não permite reatribuição
var minhaVariavel: String? = null
```
* Tipos de variáveis
  
| Categoria              | Tipos                                              |
|------------------------|----------------------------------------------------|
| Números                | Byte, Short, Int, Long, Float, Double              |
| Caracteres             | Char                                               |
| Booleanos              | Boolean                                            |
| Strings                | String                                             |

 ## Classes
 
Em Kotlin, as classes de dados são declaradas usando a palavra-chave "class" para classes comuns e classes sem contructor devem ter o "data", seguida pelo nome da classe e, entre parênteses, os atributos obrigatórios do construtor primário. As definições adicionais, como propriedades e métodos, são colocadas entre chaves. 

 ```kotlin
ata class Gamer(var name: String, var email: String) {
   //parâmetros não obritórios:
    var dateOfBirth: String = ""
    var user: String? = null
    var internalId: String? = null
    val findsGame = mutableListOf<Jogo?>()
      //constructor secundário
    constructor(name: String, email: String, dateOfBirth: String, user: String) : this(name, email) {
        this.dateOfBirth = dateOfBirth
        this.user = user
        createInternalId()
    }

```
### Métodos getters and setters
Deve-se usar o setter abaixo do atributo, passando um valor, argumentando que o campo 'field' é igual ao valor que receberá, podendo inclusive passar parâmetros. Além disso, é importante mencionar que o getter pode ser definido para fornecer uma lógica personalizada ao acessar o valor do atributo, ademais, em Kotlin, se nenhum getter personalizado é definido, o compilador cria automaticamente um getter padrão que simplesmente retorna o valor do atributo, o que não impede de criar um personalidado.

```kotlin
var user: String? = null
    set(value) {
        field = value
        if (internalId.isNullOrBlank()) {
            createInternalId()
        }
    }
    get() = field
//sete privado
var internalId: String? = null
        private set
```
### Sobrecarga e string
Para sobercarregar uma classe usamos o "override" antes da determinação "fun", como no método toString:

```kotlin
 override fun toString(): String {
        return "Gamer(name='$name', email='$email', dateOfBirth='$dateOfBirth', user=$user, internalId=$internalId)"
}
```
** Nota: para chamar um atributo da classe, usa-se o marcador "$", como no exemplo.
** Manipulção da string:

Em Kotlin, você pode formatar strings de várias maneiras, sento estas as principais:

 String Templates: Use $ para interpolar variáveis diretamente dentro de uma string, por exemplo, "Meu nome é $nome e eu tenho $idade anos.".

 String.format: Similar ao printf em outras linguagens, como em String.format("Meu nome é %s e eu tenho %d anos.", nome, idade).

 Função format da classe String: Função de extensão para strings, como em "Meu nome é %s e eu tenho %d anos.".format(nome, idade).

 Formatando Números com Precisão: Use especificadores de formato com String.format, por exemplo, String.format("Pi com duas casas decimais: %.2f", pi).

### Tratamento de erro em Kotlin:

Podemos tratar um erro com uma exception, assim como no java:

```Java
   fun emailValidator(): String {
        val regex = Regex("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")
        if (regex.matches(email)) {
            return email;
        } else {
            throw IllegalArgumentException("Email inválido.")
        }

    }
```
Mas também pode tratar de uma maneira diferente, que se chama "programação com resultado", deta maneira o Kotlin tem métodos que permitem o tratamento de ações que podem ou não dá erro, conforme exemplo:
```Java
 
result.onFailure {
            método de se a requisiçao falha, poderia inserir um tratamento de erro.
        }
        result.onSuccess {
        caso dê certo, trabalha aqui.
          }
```
* Outros métodos:

| Método               | Descrição                                                                                     |
|----------------------|------------------------------------------------------------------------------------------------|
| `getOrNull()`        | Retorna o valor se a operação foi bem-sucedida ou `null` se falhou.                            |
| `exceptionOrNull()`  | Retorna a exceção se a operação falhou ou `null` se foi bem-sucedida.                          |
| `getOrElse(default)` | Retorna o valor se a operação foi bem-sucedida ou um valor padrão fornecido se falhou.         |
| `getOrThrow()`       | Retorna o valor se a operação foi bem-sucedida ou lança a exceção se falhou.                   |
| `fold(onSuccess, onFailure)` | Aplica a função `onSuccess` se a operação foi bem-sucedida ou `onFailure` se falhou.        |
| `map(transform)`     | Transforma o valor de sucesso usando a função fornecida ou retorna o resultado original se falhou. |
| `mapCatching(transform)` | Transforma o valor de sucesso usando a função fornecida, capturando exceções lançadas.         |
| `recover(transform)` | Transforma o resultado de falha usando a função fornecida ou retorna o valor de sucesso original.  |
| `recoverCatching(transform)` | Transforma o resultado de falha usando a função fornecida, capturando exceções lançadas.     |



