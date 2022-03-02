package restaurant

class Bebida extends Produto {

    Double quantidadeLiquida;
    String unidadeLiquida;

    static constraints = {
        quantidadeLiquida min: new Double(0)
        unidadeLiquida inList: ['L', 'ML']
    }

    static mapping = {
        discriminator value: "BEBIDA"
    }
}
