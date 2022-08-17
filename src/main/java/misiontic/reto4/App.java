package misiontic.reto4;

import misiontic.reto4.view.ReportesView;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println("Requerimiento");
        ReportesView  reportesView = new ReportesView();
        reportesView.proyectosFinanciadosPorBanco();

        System.out.println("Requerimiento 2");
        ReportesView reportesView1 = new ReportesView();
        reportesView1.totalAdeudadoPorProyectosSuperioresALimite(50000.0);

        System.out.println("Requerimiento 3");
        ReportesView reportesView2 = new ReportesView();
        reportesView2.lideresQueMasGastan();
    }
}
