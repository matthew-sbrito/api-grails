package restaurant

class Cliente {

    String nome;
    String email;
    String senha;
    String cpf;

    static hasMany = [pedidos:Pedido, favoritos:Produto]

    static constraints = {
        nome nullable: false, blank: false
        email email: true, unique: true
        senha size: 6..10
        cpf validator: { valor, objeto ->
            (valor.size() == 11)
        }
    }

    static mapping = {
        favoritos joinTable: [
                name: "prod_preferidos",
                key: "cliente",
                column: "produto"
        ]
    }
}
