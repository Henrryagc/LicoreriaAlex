
package PanelRV;

import Conexion.SqliteConnection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 *
 * @author henrryagc
 */

public class ProductoVendido {
    
    
    private final int idProducto;
    private final int cantidad;
    private final Double subtotal;
    private final int idRegistroVenta;
    
    private final SqliteConnection connection = SqliteConnection.getInstance();
    
    public ProductoVendido(int idProducto, int cantidad, Double subtotal, int idRegistroVenta){
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
        this.idRegistroVenta = idRegistroVenta;        
    }
    
    public void GuardarProductoVendido(){
        String sql = "INSERT INTO ProductoVendido VALUES (0,'"+idProducto+"','"+cantidad+"','"+subtotal+"','"+idRegistroVenta+"')";        
        try {
            PreparedStatement pstm = connection.connect().prepareStatement(sql);
            pstm.executeUpdate();
            connection.disconnect();
        } catch (SQLException e) {
            System.out.println("");
            System.out.println("GuardarProductoVendido "+e);
            System.out.println("");
        }
    }

    public Object[][] BuscarTotalVenta() {
        String sql = "SELECT count(*) FROM RegistroVenta";
        int count = 0;
        try {
            PreparedStatement pstm = connection.connect().prepareStatement(sql);
            ResultSet res = pstm.executeQuery();
            if (res.next()) {
                count = res.getInt(1);
            }
            
        } catch (SQLException e) {
            System.out.println(e);
        }
        
        Object[][] obj = new Object[count][2];
        
        sql = "SELECT idRegistroVenta,costoTotal FROM RegistroVenta";
        
        try {
            PreparedStatement pstm = connection.connect().prepareStatement(sql);
            ResultSet res = pstm.executeQuery();
            int c = 0;
            while(res.next()){
                obj[c][0] = res.getInt("idRegistroVenta");
                obj[c][1] = res.getDouble("costoTotal");                
                c++;
            }
            
        } catch (SQLException e) {
            System.out.println("GetDatos en ProductoVendido: "+e);
        }
        
        return obj;
    }
}
