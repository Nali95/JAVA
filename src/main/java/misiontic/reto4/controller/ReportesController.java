package misiontic.reto4.controller;

import misiontic.reto4.model.vo.ComprasDeLiderVo;
import misiontic.reto4.model.vo.ProyectoBancoVo;
import misiontic.reto4.model.vo.DeudasPorProyectoVo;

import java.sql.SQLException;
import java.util.List;

import misiontic.reto4.model.dao.ComprasLiderDao;
import misiontic.reto4.model.dao.DeudasPorProyectoDao;
import misiontic.reto4.model.dao.ProyectoBancoDao;

public class ReportesController {
    private ProyectoBancoDao proyectoBancoDao;
    private DeudasPorProyectoDao deudasPorProyectoDao;
    private ComprasLiderDao comprasLiderDao;

    public ReportesController(){
        proyectoBancoDao= new ProyectoBancoDao();
        deudasPorProyectoDao = new DeudasPorProyectoDao();
        comprasLiderDao= new ComprasLiderDao();
    }
    public List<ProyectoBancoVo> listaTotalProyectoBanco() throws SQLException{
        return proyectoBancoDao.listar();
    }
    public List<DeudasPorProyectoVo> listaTotalDeudasProyecto(Double limite) throws SQLException{
        return deudasPorProyectoDao.listar(limite);
    }
    public List<ComprasDeLiderVo> listaTotalComprasLider() throws SQLException{
        return comprasLiderDao.listar();
    }
}
