package misiontic.reto4.model.dao;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import misiontic.reto4.model.vo.ComprasDeLiderVo;
import misiontic.reto4.util.JDBCUtilities;
public class ComprasLiderDao {
    public List<ComprasDeLiderVo> listar() throws SQLException{
        List<ComprasDeLiderVo> respuesta  = new ArrayList<ComprasDeLiderVo>();
        Connection conn = JDBCUtilities.getConnection();
        Statement stmt = null;
        ResultSet rs = null;
        String consulta = "SELECT L.NOMBRE ||' '||L.PRIMER_APELLIDO ||' '||L.SEGUNDO_APELLIDO AS LIDER, "
                            + "SUM(C.CANTIDAD * MC.PRECIO_UNIDAD) AS VALOR "
                            + "FROM LIDER L "
                            + "JOIN PROYECTO P ON (P.ID_LIDER = L.ID_LIDER) "
                            + "JOIN COMPRA C ON (P.ID_PROYECTO = C.ID_PROYECTO) "
                            + "JOIN MATERIALCONSTRUCCION MC ON (C.ID_MATERIALCONSTRUCCION = MC.ID_MATERIALCONSTRUCCION) "
                            + "GROUP BY LIDER "
                            + "ORDER BY VALOR DESC "
                            + "LIMIT 10 ";
        try {
            stmt=conn.createStatement();
            rs=stmt.executeQuery(consulta);
            while(rs.next()){
                ComprasDeLiderVo objeto = new ComprasDeLiderVo();
                objeto.setLider(rs.getString("lider"));
                objeto.setValor(rs.getDouble("valor"));
                respuesta.add(objeto);
            }
        }finally {
                if (rs != null){
                    rs.close();
                }
                 if (stmt != null) {
                    stmt.close();
                }
                if (conn != null){
                conn.close();
                }
            }
        return respuesta;
    }
}
