class Jogo(
    var nome:String,
    var capa: String,
    var descricao: String
) {
    override fun toString(): String {
        return "Nome: $nome\n" +
                "Capa: $capa\n" +
                "Descrição: $descricao"
    }
}