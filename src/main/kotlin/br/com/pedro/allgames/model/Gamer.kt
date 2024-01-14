package br.com.pedro.allgames.model

import java.time.LocalDate
import java.util.*
import kotlin.random.Random

data class Gamer(
    var nome: String,
    var email: String
): Recomendavel {
    var dataNascimento: String? = null
    var usuario: String? = null
        set(value) {
            field = value
            if (idInterno.isNullOrBlank()) {
                criarIdInterno()
            }
        }
    var idInterno: String? = null
        private set
    val jogosBuscados = mutableListOf<Jogo?>()
    val jogosAlugados = mutableListOf<Aluguel?>()
    var plano: Plano = PlanoAvulso("BRONZE")
    private val listaDeNotas = mutableListOf<Int>()

    constructor(nome: String, email: String, dataNascimento: String, usuario: String) : this(nome, email) {

        this.dataNascimento = dataNascimento
        this.usuario = usuario
        criarIdInterno()
    }

    init {
        email = validaEmail()
        if (nome.isNullOrBlank()) {
            throw IllegalArgumentException("Nome está em branco")
        }
    }

    private fun criarIdInterno() {
        val numero = Random.nextInt(10000)
        val tag = String.format("%04d", numero)

        idInterno = "$usuario#$tag"
    }

    fun alugaGame(jogo: Jogo, periodo: Periodo): Aluguel {
        val aluguel = Aluguel(this, jogo, periodo)
        jogosAlugados.add(aluguel)
        return aluguel
    }

    override val media: Double
        get() = listaDeNotas.average()

    override fun recomendar(nota: Int) {
        listaDeNotas.add(nota)
    }

    override fun toString(): String {
        return "Gamer:\n" +
                "Nome: $nome\n" +
                "Email: $email\n" +
                "Data Nascimento: $dataNascimento\n" +
                "Usuario: $usuario\n" +
                "IdInterno: $idInterno\n" +
                "Reputação: $media"
    }

    fun validaEmail(): String {
        val regex = Regex("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")
        if (regex.matches(email)) {
            return email
        } else {
            throw IllegalArgumentException("Email inválido")
        }

    }

    companion object {
        fun criarGamer(leitura: Scanner): Gamer {
            println("Bem vindo à AllGames! Vamos fazer o seu cadastro. Digite o seu nome:")
            val nome = leitura.nextLine()
            println("Agora digite o seu e-mail:")
            val email = leitura.nextLine()
            println("Deseja realizar o cadastro completo? S/N")
            val opcao = leitura.nextLine()

            if (opcao.equals("S", ignoreCase = true)) {
                println("Digite a sua data de nascimeto")
                val dataNascimento = leitura.nextLine()
                println("Digite um usuário")
                val usuario = leitura.nextLine()

                return Gamer(nome, email, dataNascimento, usuario)
            } else {

                return Gamer(nome, email)

            }

        }
    }


}
