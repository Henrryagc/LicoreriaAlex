
package licoreriawilma;

/**
 *
 * @author henrryagc
 */

import Conexion.SqliteConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TipoProducto {
    
    int id;
    String ntproducto;
    private final SqliteConnection connection = SqliteConnection.getInstance();
    public TipoProducto() {
    }
    
    public TipoProducto(int id){
        this.id = id;
        
    }
    public TipoProducto(String ntproducto){
        this.ntproducto = ntproducto;
    }
    
    
    public int Guardar(){
        int iid = 0;
        String sql ="INSERT INTO TipoProducto(idTipoProducto,nombreTipoProducto) VALUES(0,'"+ntproducto+"')"; 
                //"INSERT INTO TipoProducto VALUES(0,'"+ntproducto+"','current_timestamp()')";
        
        try {
            PreparedStatement pstm = connection.connect().prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);            
            pstm.executeUpdate();
            ResultSet Keys = pstm.getGeneratedKeys();
            if(Keys.next()){
                iid=(int)Keys.getInt(1);
                System.out.println("El id tipoP: "+iid);
            }
            connection.disconnect();
        } catch (SQLException e) {
            System.out.println(e);
        }
        
        return iid;
    }
    
    public void UpdateTP(int id){
        // int iid = 0;
        String sql = "UPDATE TipoProducto SET nombreTipoProducto='"+ntproducto+"' WHERE idTipoProducto='"+id+"'";
        
        try {
            PreparedStatement pstm = connection.connect().prepareStatement(sql);
            pstm.executeUpdate();
            
            connection.disconnect();
        } catch (SQLException e) {
            System.out.println("Update name TP");
            System.out.println(e);
        }
        
        /*sql = "SELECT nombreTipoProducto FROM TipoProducto WHERE idTipoProducto='"+id+"'";
        try {
            PreparedStatement pstm = connection.connect().prepareStatement(sql);
            pstm.executeUpdate();
            connection.disconnect();
        } catch (SQLException e) {
            System.out.println(e);
        }*/
        
    }
    
    Object[][] buscarTipoProducto()
    {   
        int count = ContarTotal();
        String sql="SELECT * FROM TipoProducto";
        Object[][] regs=new Object[count][6];
        try
        {   PreparedStatement pstm = connection.connect().prepareStatement(sql);
            ResultSet res=pstm.executeQuery();
            regs[0][0]=0;
            int c=0;
            while(res.next())
            { regs[c][0]=res.getInt("id");
              regs[c][1]=res.getString("codigo");
              regs[c][2]=res.getString("descripcion");
              regs[c][3]=res.getDouble("precio");
              regs[c][4]=res.getInt("cantidad");
              regs[c][5]=res.getInt("stock");
              c++;
            }
        }
        catch(SQLException e)
        {   System.out.println(e);
        }
        return regs;
    }
    
    public String[] buscarNombreTipoProducto(boolean desconectar){
        int count = ContarTotal();
        
        String sql="SELECT nombreTipoProducto FROM TipoProducto";
        
        String[] regs = new String[count];
        
        try
        {   PreparedStatement pstm = connection.connect().prepareStatement(sql);
            ResultSet res=pstm.executeQuery();
            //regs[0]=0;
            
            int c = 0;
            while(res.next())
            { 
              regs[c] = res.getString("nombreTipoProducto");              
              c++;
            }
            if(desconectar)
                connection.disconnect();
        }
        catch(SQLException e)
        {   System.out.println(e);
        }
        return regs;
    }
    
    public int buscarId(String nombreTipoProducto, boolean desconectar){
        int idtp = 0;
        
        String sql = "SELECT idTipoProducto FROM TipoProducto WHERE nombreTipoProducto='"+nombreTipoProducto+"'";
        
        try {
            PreparedStatement pstm = connection.connect().prepareStatement(sql);
            ResultSet res = pstm.executeQuery();
            if(res.next())
                idtp = res.getInt(1);
            if (desconectar) {
                connection.disconnect();
            }
            
        } catch (SQLException e) {
            System.out.println(e);
        }
        
        return idtp;
    }
    
    void updateStock(int can)
    {
        String sql="UPDATE TipoProducto SET stock="+can+" WHERE id='"+id+"'";
        try
        {   PreparedStatement pstm = connection.connect().prepareStatement(sql);
            pstm.executeUpdate();
            connection.disconnect();
        }
        catch(SQLException e)
        {   System.out.println(e);
        }
    }
    
    //esta funcion nos ayudara a recuperar la cantidad total de tipos de productos
    int ContarTotal(){
        
        int count=0;
        String sql2="SELECT COUNT(*) FROM TipoProducto";
        try
        {   PreparedStatement pstm = connection.connect().prepareStatement(sql2);
            ResultSet res=pstm.executeQuery();
            
            if(res.next())
            { count = res.getInt(1);                
            }
            System.out.println("Cantidad de registros TP: "+count);
            //connection.disconnect();
        }
        catch(SQLException e)
        {   System.out.println(e);
        }
        return count;
    }   
}
