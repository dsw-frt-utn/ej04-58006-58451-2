package app;

import data.Persistencia;
import java.util.InvalidPropertiesFormatException;
import views.AgregarVehiculosView;
import views.ListarVehiculosView;
import views.VistaMenu;

public class Program {
    public static void main(String[] args) throws IllegalArgumentException, InvalidPropertiesFormatException {
        Persistencia.inicializar();
        //ListarVehiculosView view = new ListarVehiculosView();
        //view.setVisible(true);
        
        VistaMenu menu = new VistaMenu();
        menu.setVisible(true);
        
    }
}
