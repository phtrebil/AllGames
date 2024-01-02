package br.com.pedro.allgames.model

import java.util.*
import kotlin.random.Random

data class Gamer(
    var nome: String,
    var email: String
) {
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

    fun alugaGame(jogo: InfoGame): Aluguel{
       return Aluguel(this, jogo)
    }

    override fun toString(): String {
        return "Gamer(nome='$nome', email='$email', dataNascimento=$dataNascimento, usuario=$usuario, idInterno=$idInterno)"
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
