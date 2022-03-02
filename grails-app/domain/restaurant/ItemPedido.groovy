package restaurant

class ItemPedido {

    Integer quantidaProduto;
    Double valorVenda;
    String observacao;

    Produto produto;
    Pedido pedido;

    static belongsTo = [Pedido]

    static constraints = {
       quantidaProduto min: 0
        valorVenda min: new Double(0)
        observacao nullable: true, blank: true
    }

    static mapping = {
        produto column: "id_produto";
        pedido column: "id_pedido";
    }
}
