/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PanelRV;

/**
 *
 * @author henrryagc
 */
//Import Java Class
import Conexion.ConexionMysql;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

public class RegistrarVenta {
    
    private ConexionMysql conn;
    private double costoTotal;
    
    public RegistrarVenta(Double costoTotal){
        
        this.costoTotal = costoTotal;
        conn = new ConexionMysql();
    }
    
    public int GuardarRV(){
        int iid = 0;
        String sql="INSERT INTO RegistroVenta(idRegistroVenta,costoTotal)  VALUES(0,'"+costoTotal+"')";
        try
        {   PreparedStatement pstm = conn.getConnection().prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            pstm.executeUpdate();
            ResultSet Keys = pstm.getGeneratedKeys();
            if(Keys.next()){
                iid=(int)Keys.getLong(1);
                System.out.println("El id RegistroVenta: "+iid);
            }
            conn.Desconectar();
        }
        catch(SQLException e)
        {   System.out.println("RegistroVenta: "+e);
        }
        
        return iid;
    }
    
}
