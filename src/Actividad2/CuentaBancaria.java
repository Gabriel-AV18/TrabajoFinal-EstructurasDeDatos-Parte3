package Actividad2;
import java.util.*;

public class CuentaBancaria {
    //Saldo actual de la cuenta
    private double saldo;
    /*Cola para pendientes, utiiza fifo ya qué las operaciones
    * ya qué las operaciones deben ser realizadas en el orden en
    * el que se registraron*/
    private Queue<Operacion> pendientes;
    // Lista para historial
    private List<Operacion> historial;
    // Pila de operaciones procesadas
    private Stack<Operacion> procesadas;
    //Constructor de la cuenta bancaria
    public CuentaBancaria() {
        saldo = 1000;
        pendientes = new LinkedList<>();
        historial = new ArrayList<>();
        procesadas = new Stack<>();
    }
    //Devolvemos el saldo actual de la cuenta
    public double getSaldo() {
        return saldo;
    }
    /*Registramos una nueva operación agregandola a la cola de pendientes
    * en esta acción no se modifica el saldo por qué permanece como PENDIENTE*/
    public void registrarOperacion(Operacion operacion) {

        pendientes.offer(operacion);
        historial.add(operacion);

        System.out.println("Operación registrada correctamente.");
    }
    //Procesamos la operacion PENDIENTE en el orden de llegada
    public void procesarSiguienteOperacion() {

        if (pendientes.isEmpty()) {
            System.out.println("No existen operaciones pendientes.");
            return;
        }
        //Obtenemos y eliminamos la primera operación de la cola
        Operacion op = pendientes.poll();
        //Si esta es deposito
        if (op.getTipo() == TipoOperacion.DEPOSITO) {
            //Aumentamos en saldo actual
            saldo += op.getMonto();
            //Actualizamos el estado de la operación
            op.setEstado(EstadoOperacion.PROCESADA);
            //Guardamos la operación por si es necesario deshacerla
            procesadas.push(op);

            System.out.println("Depósito procesado.");

        } else {
            /*Si la operación es retiro
            * verificamos que el saldo de la cuenta sea suficiente*/
            if (saldo >= op.getMonto()) {
                //Si el saldo es suficiente realizamos el retiro
                saldo -= op.getMonto();
                //Actualizamos el estado
                op.setEstado(EstadoOperacion.PROCESADA);
                //Guardamos la operación en la pila
                procesadas.push(op);

                System.out.println("Retiro procesado.");

            } else {
                /*Si el saldo no es suficiente la operacion
                * será rechazada y el saldo no se modifica*/
                op.setEstado(EstadoOperacion.RECHAZADA);

                System.out.println("Retiro rechazado por fondos insuficientes.");
            }
        }
    }

    //Mostramos las operaciónes pendientes
    public void mostrarPendientes() {
        //Comprobamos si la pila esta vaciá
        if (pendientes.isEmpty()) {
            System.out.println("No hay operaciones pendientes.");
            return;
        }
        //En caso de no estar vaciá
        System.out.println("\nOPERACIONES PENDIENTES");

        for (Operacion op : pendientes) {
            System.out.println(op);
        }
    }
    //Mostramos el historial de las operaciónes
    public void mostrarHistorial() {
        //Comprobamos si existen operaciones
        if (historial.isEmpty()) {
            System.out.println("No existen operaciones registradas.");
            return;
        }
        //Si existen recorremos la lista para mostrarlas
        System.out.println("\nHISTORIAL COMPLETO");

        for (Operacion op : historial) {
            System.out.println(op);
        }
    }
    //Deshacemos la última operación procesada
    public void deshacerUltimaOperacion() {
        //Confirmamos que exista alguna operacion
        if (procesadas.isEmpty()) {
            System.out.println("No hay operaciones para deshacer.");
            return;
        }
        //Obtenemos la última procesada
        Operacion op = procesadas.pop();
        //Revertimos la operación en el saldo
        if (op.getTipo() == TipoOperacion.DEPOSITO) {
            saldo -= op.getMonto();
        } else {
            saldo += op.getMonto();
        }
        //Actualizamos el estado de la operación
        op.setEstado(EstadoOperacion.DESECHA);

        System.out.println("Operación deshecha correctamente.");
    }
}
