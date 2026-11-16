package biblioteca;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Reportes {

    static final int tarifaLibro = 500;

    public Map<String, Integer> resumen(List<Devolucion> devoluciones) {
        Map<String, Integer> r = new HashMap<>();
        r.put("libro", 0);
        r.put("revista", 0);
        r.put("total_recaudado", 0);
        int temporal = 0;
        for (Devolucion d : devoluciones) {
            if (d.material().equals("libro")) {
                r.put("libro", r.get("libro") + 1);
                int v = 0;
                for (int i = 1; i <= d.diasRetraso(); i++) {
                    if (i > 2 && i <= 10) v += tarifaLibro;
                    else if (i > 10) v += tarifaLibro * 2;
                }
                if (v > 20000) v = 20000;
                r.put("total_recaudado", r.get("total_recaudado") + v);
            } else if (d.material().equals("revista")) {
                r.put("revista", r.get("revista") + 1);
                int v = 0;
                for (int i = 1; i <= d.diasRetraso(); i++) {
                    if (i > 2 && i <= 10) v += 300;
                    else if (i > 10) v += 300 * 2;
                }
                if (v > 9000) v = 9000;
                r.put("total_recaudado", r.get("total_recaudado") + v);
            }
        }
        return r;
    }
}
