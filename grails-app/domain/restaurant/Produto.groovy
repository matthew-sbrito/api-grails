package restaurant

import javax.servlet.http.HttpServletRequest

class Produto {

    String nome
    Double preco
    Estoque estoque

    static hasMany = [favoritos:Cliente, itens:ItemPedido]
    static belongsTo = [Cliente]

    static constraints = {
        nome nullable:false, blank:false
        estoque nullable: true
        preco min: new Double(0)
    }

    static mapping = {
        discriminator column: "tipo", value: "GERAL"
        favoritos joinTable: [
                name: "prod_preferidos",
                key: "produto",
                column: "cliente"
        ]
    }

    def static fromRequest(HttpServletRequest request){

        def requestBody = request.JSON

        Produto produto = new Produto()

        produto.nome = requestBody['nome']
        produto.preco = requestBody['preco']

        return produto
    }

    def toResponse() {
        return [
                'id': this.id,
                'nome': this.nome,
                'preco': this.preco,
                'estoque': this.estoque.toResponse()
        ]
    }

}
