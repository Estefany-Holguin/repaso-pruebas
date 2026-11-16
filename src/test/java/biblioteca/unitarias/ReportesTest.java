package biblioteca.unitarias;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import biblioteca.Devolucion;
import biblioteca.Reportes;

/** Pruebas que protegen el comportamiento de resumen durante el refactor. */
class ReportesTest {

    @Test
    @DisplayName("Resume las devoluciones del día")
    void resumeLasDevolucionesDelDia() {
        List<Devolucion> devoluciones = List.of(
                new Devolucion("libro", 2),
                new Devolucion("libro", 11),
                new Devolucion("revista", 30),
                new Devolucion("libro", 90));

        // 0 (gracia) + 5000 (11 días) + 9000 (tope revista) + 20000 (tope libro)
        assertEquals(Map.of("libro", 3, "revista", 1, "total_recaudado", 34000),
                new Reportes().resumen(devoluciones));
    }

    @Test
    @DisplayName("Sin devoluciones todo es cero")
    void sinDevolucionesTodoEsCero() {
        assertEquals(Map.of("libro", 0, "revista", 0, "total_recaudado", 0),
                new Reportes().resumen(List.of()));
    }
}
