package misiontic.reto4;

import misiontic.reto4.view.ReportesView;

public class App2 {
    public static void main( String[] args )
    {
        System.out.println("Requerimiento");
        ReportesView  reportesView = new ReportesView();
        reportesView.proyectosFinanciadosPorBanco();
    }
}
