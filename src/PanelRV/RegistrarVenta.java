
package PanelRV;

/**
 *
 * @author henrryagc
 */

import db.Conexion.SqliteConnection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

public class RegistrarVenta {
        
    private final double costoTotal;
    
    private final SqliteConnection connection = SqliteConnection.getInstance();
    
    public RegistrarVenta(Double costoTotal){        
        this.costoTotal = costoTotal;        
    }
    
    public int GuardarRV(){
        int iid = 0;
        String sql="INSERT INTO RegistroVenta(idRegistroVenta,costoTotal)"
                + "VALUES(0,'" + costoTotal + "')";
        try
        {   PreparedStatement pstm = connection.connect().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstm.executeUpdate();
            ResultSet Keys = pstm.getGeneratedKeys();
            if(Keys.next()){
                iid = (int)Keys.getLong(1);
                System.out.println("El id RegistroVenta: "+iid);
            }
            connection.disconnect();
        }
        catch(SQLException e)
        {   System.out.println("RegistroVenta: "+e);
        }        
        return iid;
    }    
}
