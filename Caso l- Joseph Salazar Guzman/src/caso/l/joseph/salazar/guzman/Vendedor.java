/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package caso.l.joseph.salazar.guzman;

import javax.swing.JOptionPane;

//Esta clase se utiliza para los atributos del vendedor
public class Vendedor {

    private String Nombre;
    private String Cedula;
    private String ID;
    private String Sucursal;
    private boolean TieneVehiculo;
    private double TotalFacturas;
    private double TotalComisiones;
    private int Puntos;
    private int ContadorFacturas;

    public Vendedor(String nombre, String cedula, String codigo, String sucursal, boolean TieneVehiculo) {
        this.Nombre = nombre;
        this.Cedula = cedula;
        this.ID = codigo;
        this.Sucursal = sucursal;
        this.TieneVehiculo = TieneVehiculo;
        this.TotalFacturas = 0;
        this.TotalComisiones = 0;
        this.Puntos = 0;
        this.ContadorFacturas = 0;
    }

    //Proceso para agregar una factura 
    public void agregarFactura(double MontoFact, int Electr, int Automot, int Constru) {
        double Comision = CalcularComision(MontoFact, Electr, Automot, Constru);
        this.TotalFacturas += MontoFact;
        this.TotalComisiones += Comision;
        this.ContadorFacturas++;
        this.Puntos += CalcularPuntosGanados(Electr, Automot, Constru, MontoFact);
    }

    //Calcular la comision en base a los productos vendidos por el agente, varia segun el producto vendido
    private double CalcularComision(double MontoFact, int Electr, int Automot, int Constru) {
        double Comision = 0;

        // Bonos otorgados al vendedor 
        if (Electr >= 3) {
            Comision += MontoFact * 0.04;
        } else {
            Comision += MontoFact * 0.02;
        }
        if (Automot > 4) {
            Comision += MontoFact * 0.04;
        } else {
            Comision += MontoFact * 0.02;
        }
        if (Constru > 0) {
            Comision += MontoFact * 0.08;
        }
        if (MontoFact > 50000) {
            Comision += MontoFact * 0.05;
        }

        // Bono por productos vendidos 
        if (Electr > 0 && Automot > 0 && Constru > 0) {
            Comision += MontoFact * 0.10;
        }
        return Comision;
    }

    // Calcula los puntos ganados para los bonos finales
    private int CalcularPuntosGanados(int Electr, int Automot, int Constru, double MontoFact) {
        int Puntos = 0;
        if (Electr > 0 && Automot > 0 && Constru > 0) {
            Puntos += 3;
        }
        if (Electr >= 3) {
            Puntos += 1;
        }
        if (Automot > 4) {
            Puntos += 1;
        }
        if (Constru > 0) {
            Puntos += 2;
        }
        if (MontoFact > 50000) {
            Puntos += 1;
        }
        return Puntos;
    }

    public void mostrarResultados() {
        String BonoExtra = (ContadorFacturas > 3 || TotalFacturas > 300000) ? "si" : "no";
        String mensaje = String.format("El Agente Vendedor \"%s\" código: %s\n"
                + "Vendió un total de %.2f en facturas\n"
                + "Obtuvo un total en comisiones de %.2f\n"
                + "El agente vendedor %s logró el objetivo, gana su bono extra.\n"
                + "Puntos obtenidos por el vendedor: %d\n"
                + "El Agente Vendedor %s cuenta con vehículo propio\n"
                + "Sucursal: %s",
                Nombre, ID, TotalFacturas, TotalComisiones,
                BonoExtra.equals("si") ? "" : "no", Puntos, Nombre, Sucursal);
        JOptionPane.showMessageDialog(null, mensaje);
    }

}
