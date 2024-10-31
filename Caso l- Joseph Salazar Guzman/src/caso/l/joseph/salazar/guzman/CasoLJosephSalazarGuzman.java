/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package caso.l.joseph.salazar.guzman;

// Se importa la libreria pars utilizar el JOptionPane
import javax.swing.JOptionPane;

public class CasoLJosephSalazarGuzman {

    public static void main(String[] args) {

        // Solicita los datos del agente
        String Nombre = JOptionPane.showInputDialog("Nombre del agente:");
        String ID = JOptionPane.showInputDialog("Cédula del agente:");
        String Codigo = JOptionPane.showInputDialog("Código del agente:");
        String Sucursal = JOptionPane.showInputDialog("Sucursal del agente:");
        boolean TieneVehiculo = JOptionPane.showConfirmDialog(null, "¿Tiene vehículo propio?", "Vehículo", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;

        // Crea los nuevos datos del vendeors y lo incluye en la variable
        Vendedor Vendedor1 = new Vendedor(Nombre, ID, Codigo, Sucursal, TieneVehiculo);

        //Aqui solicita los datos del usuario, factura y cantidad de prodcutos
        while (true) {
            String NombreCliente = JOptionPane.showInputDialog("Nombre del cliente:");
            String CedulaCliente = JOptionPane.showInputDialog("Cédula del cliente:");
            String CodigoFactura = JOptionPane.showInputDialog("Código de la factura:");
            double MontoFactura = Double.parseDouble(JOptionPane.showInputDialog("Monto de la factura:"));
            int Mes = Integer.parseInt(JOptionPane.showInputDialog("Número de mes (1-12):"));
            int Electr = Integer.parseInt(JOptionPane.showInputDialog("Cantidad de productos eléctricos:"));
            int Automot = Integer.parseInt(JOptionPane.showInputDialog("Cantidad de productos automotrices:"));
            int Constru = Integer.parseInt(JOptionPane.showInputDialog("Cantidad de productos de construcción:"));

            // Con la funcion "agregar factura" en la clase Vendedor, agrega a la factura los datos de monto de la factura, la cantidad de productos comprados.
            Vendedor1.agregarFactura(MontoFactura, Electr, Automot, Constru);

            // Este if funciona para dar la opcion de si se desea agregar otra factura, se utiliza una de las funciones de JOption. Link de documentacion https://docs.oracle.com/en/java/javase/17/docs/api/java.desktop/javax/swing/JOptionPane.html
            int Continuar = JOptionPane.showConfirmDialog(null, "Desea agregar otra factura", "Continuar", JOptionPane.YES_NO_OPTION);
            if (Continuar == JOptionPane.NO_OPTION) {
                break;
            }
        }

        // Muestra los resultados con la funcion "Mostrar resultados" en la clase Vendedor
        Vendedor1.mostrarResultados();
    }

}
