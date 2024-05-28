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
### Tipagem dinâmica:

O Kotlin permite a tipagem dinâmica, de modo que eu não preciso a passar como no java, isso não significa que eu não possa passar, inclusive imagino que isto é uma boa prática.

```kotlin
val x = 10 // O tipo de x será inferido como Int
val y = "Olá" // O tipo de y será inferido como String
val z: Any = 3.14 // Aqui, z é explicitamente declarado como Any, permitindo que ele possa conter qualquer tipo de valor
```

### Declaração de variáveis:

A declração de variavéis no kotlin são feitas por dois termos, var e val, a diferença entre eles é que o val é imuntável, ou seja, uma constante, geralmente usado para leitura.
```kotlin
var idade = 30 // Declara uma variável mutável
idade = 31 // OK, pois 'var' permite reatribuição
val nome = "João" // Declara uma variável somente leitura
nome = "Maria" // ERRO: 'val' não permite reatribuição

```



