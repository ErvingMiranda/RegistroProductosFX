package org.ezone.pae.registroproductos.repository;

import org.ezone.pae.registroproductos.model.Producto;

import java.time.LocalDate;
import java.util.List;

public class ProductoRepository {
    public List<Producto> findAll() {
        return List.of(
                new Producto(
                        1,
                        "Monitor Samsung",
                        "Tecnológico",
                        6000.63,
                        LocalDate.of(2026, 9, 1),
                        null
                ),
                new Producto(
                        2,
                        "Teclado Logitech",
                        "Tecnológico",
                        1250.50,
                        LocalDate.of(2026, 8, 25),
                        null
                ),
                new Producto(
                        3,
                        "Mouse Razer",
                        "Tecnológico",
                        1800.00,
                        LocalDate.of(2026, 8, 20),
                        null
                ),
                new Producto(
                        4,
                        "Silla de Oficina",
                        "Mobiliario",
                        4500.75,
                        LocalDate.of(2026, 8, 15),
                        null
                ),
                new Producto(
                        5,
                        "Escritorio",
                        "Mobiliario",
                        7200.00,
                        LocalDate.of(2026, 8, 10),
                        null
                )
        );
    }
}