class Jogo(
    val nome:String,
    val capa: String,
    val descricao: String
) {
    override fun toString(): String {
        return "Nome: $nome\n" +
                "Capa: $capa\n" +
                "Descrição: $descricao"
    }
}