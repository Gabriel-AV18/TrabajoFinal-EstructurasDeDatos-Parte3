package Actividad2;

public class Operacion {
    //Utilizamos final ya que estos datos no debería de cambiar
    private final int id;
    private final TipoOperacion tipo;
    private final double monto;
    //En el caso de EstadoOperacion no se utiliza por qué este si va cambiando
    private EstadoOperacion estado;

    /*Constructor de la clase: al ser creada una operacion su estado será
     * PENDIENTE ya qué esta no es procesada aún */
    public Operacion(int id, TipoOperacion tipo, double monto) {
        //Identificador de la operacion
        this.id = id;
        //Tipo de operación: DEPOSITO o RETIRO
        this.tipo = tipo;
        //Cantidad de dinero de la operación
        this.monto = monto;
        //Estado de la operacion
        this.estado = EstadoOperacion.PENDIENTE;
    }

    //Devolvemos el identificador
    public int getId() {
        return id;
    }
    //Devolvemos el tipo de operación
    public TipoOperacion getTipo() {
        return tipo;
    }
    //Devolvemos el monto
    public double getMonto() {
        return monto;
    }
    //Devolvemos el estado en el que se encuentra la operación
    public EstadoOperacion getEstado() {
        return estado;
    }
    //Actualizamos el estado de la operación
    public void setEstado(EstadoOperacion estado) {
        this.estado = estado;
    }

    //Se devuelve la información de la operacion en formato de texto
    @Override
    public String toString() {
        return "ID: " + id +
                " | Tipo: " + tipo +
                " | Monto: $" + monto +
                " | Estado: " + estado;
    }
}
