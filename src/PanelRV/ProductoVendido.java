/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PanelRV;

import Conexion.ConexionMysql;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 *
 * @author henrryagc
 */

public class ProductoVendido {
    
    
    private int idProducto;
    private int cantidad;
    private Double subtotal;
    private int idRegistroVenta;
    
    private ConexionMysql conn;
    public ProductoVendido(int idProducto, int cantidad, Double subtotal, int idRegistroVenta){
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
        this.idRegistroVenta = idRegistroVenta;
        
        conn = new ConexionMysql();
    }
    
    public void GuardarProductoVendido(){
        String sql = "INSERT INTO ProductoVendido VALUES (0,'"+idProducto+"','"+cantidad+"','"+subtotal+"','"+idRegistroVenta+"')";
        //String sql="INSERT INTO cliente VALUES(0,'"+dni+"','"+email+"','"+apellidos+"','"+nombres+"','"+fechanac+"','"+sexo+"','"+clave+"')";
        try {
            PreparedStatement pstm = conn.getConnection().prepareStatement(sql);
            pstm.executeUpdate();
            conn.Desconectar();
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
            PreparedStatement pstm = conn.getConnection().prepareStatement(sql);
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
            PreparedStatement pstm = conn.getConnection().prepareStatement(sql);
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
