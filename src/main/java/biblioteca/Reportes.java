package biblioteca;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Reportes {

    private final CalculadoraMultas calculadora = new CalculadoraMultas();

    public Map<String, Integer> resumen(List<Devolucion> devoluciones) {
        Map<String, Integer> resultado = new HashMap<>();
        resultado.put("libro", 0);
        resultado.put("revista", 0);
        int totalRecaudado = 0;

        for (Devolucion devolucion : devoluciones) {
            String clave = devolucion.material();
            resultado.merge(clave, 1, Integer::sum);
            totalRecaudado += calculadora.calcularMulta(devolucion.diasRetraso(), clave);
        }

        resultado.put("total_recaudado", totalRecaudado);
        return resultado;
    }
}