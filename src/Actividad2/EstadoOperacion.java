package Actividad2;

public enum EstadoOperacion {
    // Operación registrada pero aún no procesada
    PENDIENTE,
    // Operación ejecutada
    PROCESADA,
    // Operación que no pudo realizarse
    RECHAZADA,
    // Operación procesada y posteriormente revertida
    DESECHA
}
