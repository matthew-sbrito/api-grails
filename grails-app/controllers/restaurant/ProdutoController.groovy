package restaurant

import grails.rest.RestfulController

import org.springframework.http.HttpStatus

class ProdutoController extends RestfulController<Produto> {

    static responseFormats = ['json', 'xml']

    static allowedMethods = [
        create: 'POST',
        update: 'PUT',
    ]

    ProdutoController() {
        super(Produto)
    }

    def show() {

        String id = params.id

        Produto produto = Produto.get(id)

        if(produto == null) {
            def error = Response.error("Produto não encontrado", HttpStatus.NOT_FOUND);
            respond error, [status: HttpStatus.NOT_FOUND]
        }

        respond produto, [status: HttpStatus.OK]

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

        produto.save()

        respond produto, [status: HttpStatus.CREATED]
    }


    def update() {
        String id = params.id

        Produto produto = Produto.get(id)

        if(produto == null) {
            def error = Response.error("Produto não encontrado", HttpStatus.NOT_FOUND);
            respond error, [status: HttpStatus.NOT_FOUND]
        }

        Produto produtoRequest = Produto.fromRequest(request)
        Estoque estoqueRequest = Estoque.fromRequest(request)

        estoqueRequest.id = produto.estoque.id

        estoqueRequest.save()

        produtoRequest.id = produto.id
        produtoRequest.estoque = estoqueRequest

        respond produto, [status: HttpStatus.OK]
    }

}
