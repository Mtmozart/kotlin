import java.time.LocalDate
import java.time.Period
import java.time.format.DateTimeFormatter

fun String.transformAge(): Int {
    val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
    var age = 0
    val dataNascimento = LocalDate.parse(this, formatter)
    val hoje = LocalDate.now()
    age = Period.between(dataNascimento, hoje).years

    return age
}