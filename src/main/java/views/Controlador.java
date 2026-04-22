package views;

import data.Persistencia;
import domain.Sucursal;
import domain.Vehiculo;
import domain.VehiculoTipo;
import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;

public class Controlador {
    
    
    
    public static ArrayList<VehiculoViewModel> getVehiculos(){
        ArrayList<VehiculoViewModel> vehiculos = new ArrayList<>();
        for(Vehiculo vehiculo : Persistencia.getVehiculos()) {
            vehiculos.add(new VehiculoViewModel(vehiculo));
        }
        return vehiculos;
    }
    
    public static ArrayList<Sucursal> getSucursales(){
        ArrayList<Sucursal> sucursales = new ArrayList<>();
        
        for(Sucursal s : Persistencia.getSucursal()){
            sucursales.add(new Sucursal(s.getCodigo(),s.getDireccion(),s.getCiudad(),s.getResponsable()));  
        }
        return sucursales;
    }
    
    /*public static void cargarSucursal(){
       AgregarVehiculosView v = new AgregarVehiculosView();
       v.getComboSucursal().removeAll();
       for(Sucursal s : Persistencia.getSucursales())
       {
           v.getComboSucursal().addItem(s);
       }
    }*/
    
    
    public static void agregarVehiculoControlador(Vehiculo v)
    {
        Persistencia.agregarVehiculo(v);
    }
    
    
    public static double[] calcularConsumos(Map<String, Double> vehiculos){
        double consumoElectricos = 0;
        double consumoCombustible= 0;
        for(Map.Entry<String, Double> entry : vehiculos.entrySet()){
           double consumo = 0;
           Optional<Vehiculo> vehiculo = Persistencia.getVehiculo(entry.getKey());
           if(vehiculo.isPresent()){
               consumo = vehiculo.get().calcularConsumo(entry.getValue());
               consumoElectricos += vehiculo.get().esDe(VehiculoTipo.ELECTRICO) ? consumo : 0;
               consumoCombustible += vehiculo.get().esDe(VehiculoTipo.COMBUSTIBLE) ? consumo : 0;
           }
        }
        return new double[] {consumoElectricos, consumoCombustible};
    }
}
