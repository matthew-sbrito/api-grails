package restaurant

import javax.servlet.http.HttpServletRequest

class Estoque {

    Integer quantidade
    Integer quantidadeMinima

    Produto produto

    static belongsTo = [produto:Produto]

    static constraints = {
        quantidade min: 0
        quantidadeMinima min: 0
        produto nullable: false

    }

    static mapping = {
        table name: "estoques"
    }

    def static fromRequest(HttpServletRequest request){

        def requestBody = request.JSON

        Estoque estoque = new Estoque()
        estoque.quantidade = requestBody['quantidade'].toInteger()
        estoque.quantidadeMinima = requestBody['quantidadeMinima'].toInteger()

        return estoque;
    }

    def toResponse() {
        return [
                'quantidade': this.quantidade,
                'quantidadeMinima': this.quantidadeMinima
        ]
    }
}
