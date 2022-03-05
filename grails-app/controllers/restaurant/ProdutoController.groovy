package restaurant

import org.springframework.http.HttpStatus

class ProdutoController {

    static responseFormats = ['json', 'xml']

    static allowedMethods = [
        create: 'POST',
        update: 'PUT',
        delete: 'DELETE'
    ]

    def index(){
        Produto[] list = Produto.list()

        def products = list.collect { it.toResponse() }

        def arrayResponse = Response.ok(['products': products])
        respond arrayResponse, [status: HttpStatus.OK]
    }

    def show() {
        String id = params.id

        Produto produto = Produto.get(id)

        if(produto == null) {
            def error = Response.error("Produto não encontrado", HttpStatus.NOT_FOUND);
            respond error, [status: HttpStatus.NOT_FOUND]
        }

        def response = Response.ok(produto.toResponse())
        respond response, [status: HttpStatus.OK]

    }

    def create() {

        Produto produto = Produto.fromRequest(request)
        Estoque estoque = Estoque.fromRequest(request)

        estoque.save()

        produto.estoque = estoque

        produto.validate()

        if(produto.hasErrors()) {
            respond produto.errors
            return
        }

        produto.save(flush: true)

        def response = Response.ok(produto.toResponse())
        respond response, [status: HttpStatus.CREATED]
    }


    def update() {
        String id = params.id

        Produto produto = Produto.get(id)

        if(produto == null) {
            def error = Response.error("Produto não encontrado", HttpStatus.NOT_FOUND);
            respond error, [status: HttpStatus.NOT_FOUND]
        }


        def requestBody = request.JSON

        produto.nome  = requestBody['nome']
        produto.preco = requestBody['preco']
        produto.estoque.quantidade = requestBody['quantidade']
        produto.estoque.quantidadeMinima = requestBody['quantidadeMinima']

        produto.save(flush: true)

        def response = Response.ok(produto.toResponse())
        respond response, [status: HttpStatus.OK]
    }

    def delete(){
        String id = params.id

        Produto produto = Produto.get(id)

        if(produto == null) {
            def error = Response.error("Produto não encontrado", HttpStatus.NOT_FOUND);
            respond error, [status: HttpStatus.NOT_FOUND]
        }

        produto.estoque.delete()
        produto.estoque = null
        produto.delete flush: true

        def response = Response.ok(['message': 'Produto excluido com sucesso!'])
        respond response, [status: HttpStatus.OK]

    }

}
