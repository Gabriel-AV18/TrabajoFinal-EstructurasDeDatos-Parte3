package Actividad2;
import java.util.Scanner;

public class MainAct2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Creamos un nuevo objeto de CuentaBancaria
        CuentaBancaria cuenta = new CuentaBancaria();
        //Iniciamos el identificador en 1
        int id = 1;
        //Variable para almacenar las opciones del menú
        int opcion;

        do {

            System.out.println("\n SIMULADOR BANCARIO ");
            System.out.println("1. Registrar depósito");
            System.out.println("2. Registrar retiro");
            System.out.println("3. Procesar siguiente operación");
            System.out.println("4. Consultar pendientes");
            System.out.println("5. Mostrar historial");
            System.out.println("6. Consultar saldo");
            System.out.println("7. Deshacer última operación");
            System.out.println("0. Salir");
            System.out.print("Opción: ");

            opcion = sc.nextInt();

            switch (opcion) {
                //Regisramos un nuevo depósito
                case 1:

                    System.out.print("Monto a depositar: ");
                    double deposito = sc.nextDouble();

                    cuenta.registrarOperacion(
                            new Operacion(
                                    id++,
                                    TipoOperacion.DEPOSITO,
                                    deposito
                            )
                    );
                    break;
                //Registramos un nuevo retiro
                case 2:

                    System.out.print("Monto a retirar: ");
                    double retiro = sc.nextDouble();

                    cuenta.registrarOperacion(
                            new Operacion(
                                    id++,
                                    TipoOperacion.RETIRO,
                                    retiro
                            )
                    );
                    break;
                //Procesa la siguiente operación de la cola
                case 3:
                    cuenta.procesarSiguienteOperacion();
                    break;
                //Muestra las operaciones pendientes
                case 4:
                    cuenta.mostrarPendientes();
                    break;
                //Muestra el historial completo
                case 5:
                    cuenta.mostrarHistorial();
                    break;
                //Consulta el saldo actual de la cuenta
                case 6:
                    System.out.println("Saldo disponible: $" +
                            cuenta.getSaldo());
                    break;
                //Deshace la última operación que se procesó
                case 7:
                    cuenta.deshacerUltimaOperacion();
                    break;

                case 0:
                    System.out.println("Programa finalizado.");
                    break;
                //Para opciones no validas
                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 0);

        sc.close();
    }
}
