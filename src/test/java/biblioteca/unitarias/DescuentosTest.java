package biblioteca.unitarias;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import biblioteca.Descuentos;

public class DescuentosTest {
    private final Descuentos descuentos = new Descuentos();

    @Test
    @DisplayName("Un usuario externo no tiene descuento")
    void usuarioExternoNoTieneDescuento() {
        assertEquals(0, descuentos.descuento("externo"));
    }
    @Test
    @DisplayName("Un usuario de tipo estudiante tiene un 10% de descuento")
    void usuarioEstudianteTieneDescuento() {
        assertEquals(10, descuentos.descuento("estudiante"));
    }
    @Test
    @DisplayName("Un usuario de tipo docente tiene un 20% de descuento")
    void usuarioDocenteTieneDescuento() {
        assertEquals(20, descuentos.descuento("docente"));
    }
    @Test
    @DisplayName("Un valor negattivo es un error")
    void valorNegativoEsError() {
        assertThrows(IllegalArgumentException.class, () -> descuentos.descuento("negativo"));
    }
}
