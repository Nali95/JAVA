package misiontic.reto4.view;

import java.util.List;

import misiontic.reto4.controller.ReportesController;
import misiontic.reto4.model.vo.ComprasDeLiderVo;
import misiontic.reto4.model.vo.DeudasPorProyectoVo;
import misiontic.reto4.model.vo.ProyectoBancoVo;

public class ReportesView {
    private static ReportesController controller;

    public ReportesView(){
        controller = new ReportesController();
    }

    public String repitaCaracter(Character caracter, Integer veces) {
        String respuesta = "";
        for (int i = 0; i < veces; i++) {
        respuesta += caracter;
        }
        return respuesta;
        }
        public void proyectosFinanciadosPorBanco() {
            System.out.println(repitaCaracter('=', 36) + " LISTADO DE PROYECTOS POR BANCO "
                + repitaCaracter('=', 37));
                
            System.out.println(String.format("%3s %-25s %-20s %-15s",
            "ID", "CIUDAD", "NOMBRE", "PRIMER APELLIDO"));
            try{
                List<ProyectoBancoVo> variable=controller.listaTotalProyectoBanco();
                for(ProyectoBancoVo proyecto:variable){;
                System.out.println(proyecto);
                }
            }catch(Exception e){
                System.err.println("Error: "+e);
            }      
        }
        public void totalAdeudadoPorProyectosSuperioresALimite(Double limiteInferior) {
            System.out.println(repitaCaracter('=', 1) + " TOTAL DEUDAS POR PROYECTO "
                + repitaCaracter('=', 1));
            if (limiteInferior != null) {
                System.out.println(String.format("%3s %15s", "ID", "VALOR  "));
                System.out.println(repitaCaracter('-', 29));
            }
            try{
                List<DeudasPorProyectoVo> proyectos=controller.listaTotalDeudasProyecto(limiteInferior);
                for(DeudasPorProyectoVo proyecto:proyectos){
                System.out.println(proyecto);
            } 
        }catch (Exception ex) {
            System.err.println("Error:"+ex);
        }
    }
    public void lideresQueMasGastan() {
            System.out.println(repitaCaracter('=', 6) + " 10 LIDERES MAS COMPRADORES "
                + repitaCaracter('=', 7));
            System.out.println(String.format("%-25s %15s", "LIDER", "VALOR  "));
            System.out.println(repitaCaracter('-', 41));
        try {
            List<ComprasDeLiderVo> variable=controller.listaTotalComprasLider();
            for(ComprasDeLiderVo proyecto:variable){
                System.out.println(proyecto);
            }
        } catch (Exception e) {
            System.err.println("Error:"+e);
        }
    }     
}