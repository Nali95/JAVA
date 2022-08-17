package misiontic.reto4.model.dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import misiontic.reto4.model.vo.ProyectoBancoVo;
import misiontic.reto4.util.JDBCUtilities;
public class ProyectoBancoDao{
    public List<ProyectoBancoVo> listar() throws SQLException {
        List<ProyectoBancoVo> respuesta  = new ArrayList<ProyectoBancoVo>();
        Connection con = JDBCUtilities.getConnection();
        Statement stmt = null;
        ResultSet rs = null;
        String consulta = "SELECT P.ID_PROYECTO ID, P.CIUDAD CIUDAD, L.NOMBRE NOMBRE,L.PRIMER_APELLIDO PRIMERAPELLIDO "
                            +"FROM PROYECTO P " 
                            +"JOIN TIPO T ON (P.ID_TIPO=t.ID_TIPO) "
                            +"JOIN Lider l on (p.ID_LIDER=l.ID_LIDER) "
                            +"ORDER BY  P.CIUDAD ASC ";

        try {
            stmt=con.createStatement();
            rs=stmt.executeQuery(consulta);
            while(rs.next()){
                ProyectoBancoVo objeto = new ProyectoBancoVo();
                objeto.setId(rs.getInt("id"));
                objeto.setCiudad(rs.getString("ciudad"));
                objeto.setNombre(rs.getString("nombre")); 
                objeto.setPrimerapellido(rs.getString("primerapellido"));
                respuesta.add(objeto);
            }
        }finally {
            if (rs != null){
                rs.close();
            }
             if (stmt != null) {
                stmt.close();
            }
            if (con != null){
            con.close();
            }
        }
    return respuesta;
    }
}

