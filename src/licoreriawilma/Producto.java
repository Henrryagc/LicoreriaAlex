
package licoreriawilma;

/**
 *
 * @author henrryagc
 */
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Conexion.ConexionMysql;
import Conexion.SqliteConnection;
import PanelBP.BuscarProducto;
import java.util.Arrays;
import java.util.LinkedList;

public class Producto {

    String nomPro;
    int stock;
    double precio;
    int idTipoPro;

    ConexionMysql conn;
    private final SqliteConnection connection = SqliteConnection.getInstance();

    public Producto() {
        conn = new ConexionMysql();
    }

    public Producto(String nomPro, int stock, double precio, int idTipoPro) {
        this.nomPro = nomPro;
        this.stock = stock;
        this.precio = precio;
        this.idTipoPro = idTipoPro;
        conn = new ConexionMysql();
    }

    public void Guardar() {

        String sql = "INSERT INTO Producto(idProducto,nombreProducto,stock,precio,idTipoProducto) VALUES(0,'" + nomPro + "','" + stock + "','" + precio + "','" + idTipoPro + "')";

        try {
            PreparedStatement pstm = conn.getConnection().prepareStatement(sql);
            pstm.executeUpdate();
            conn.Desconectar();
        } catch (SQLException e) {
            System.out.println("Guardar Produc: <-- " + e);
        }
    }

    public Object[][] buscarProducto(boolean desconectar) {
        int count = ContarTotalNomPro();

        String sql = "SELECT idProducto, nombreProducto, stock, precio "
                + "FROM producto "
                + "INNER JOIN TipoProducto "
                + "ON producto.idTipoProducto = tipoProducto.idTipoProducto "
                + "WHERE TipoProducto.idTipoProducto='" + idTipoPro + "'";
        Object[][] regs = new Object[count][4];
        try {
            PreparedStatement pstm = conn.getConnection().prepareStatement(sql);
            ResultSet res = pstm.executeQuery();
            //regs[0][0]=0;
            int c = 0;
            while (res.next()) {
                regs[c][0] = res.getInt("idProducto");
                regs[c][1] = res.getString("nombreProducto");
//              regs[c][2]=res.getString("fechaAgregado");
                regs[c][2] = res.getInt("stock");
                regs[c][3] = res.getDouble("precio");
                c++;
            }
            for (Object[] reg : regs) {
                System.out.println(Arrays.deepToString(reg));
            }
            if (desconectar) {
                conn.Desconectar();
            }
        } catch (SQLException e) {
            System.out.println("Buscar Producto : " + e);
        }

        return regs;
    }

    public String[] buscarNombreProducto() {

        int total = ContarTotalNomPro();

        String sql = "SELECT nombreProducto FROM Producto "
                + "WHERE Producto.idTipoProducto='" + idTipoPro + "'";

        String[] regs = new String[total];

        try {
            PreparedStatement pstm = conn.getConnection().prepareStatement(sql);
            ResultSet res = pstm.executeQuery();

            int c = 0;
            while (res.next()) {
                regs[c] = res.getString("nombreProducto");
                System.out.println(regs[c]);
                c++;
            }
        } catch (SQLException e) {
            System.out.println("BscarNomPro" + e.getErrorCode());
            System.out.println(e);
        }
        return regs;
    }

    public Object[][] BuscarProductoChart() {
        int totalPro = ContarTotal();
        Object[][] prods = new Object[totalPro][2];
        String sql = "SELECT nombreProducto, stock FROM Producto";
        try {
            PreparedStatement pstm = conn.getConnection().prepareStatement(sql);
            ResultSet res = pstm.executeQuery();
            int c = 0;
            while (res.next()) {
                prods[c][0] = res.getString("nombreProducto");
                prods[c][1] = res.getInt("stock");
                c++;
            }
        } catch (SQLException e) {
            System.out.println("BuscarProductoChar" + e);
        }
        return prods;
    }

    public Object[][] buscarListaProducto() {
        int count = ContarTotal();

        String sql = "SELECT nombreProducto,nombreTipoProducto,precio,stock FROM "
                + "Producto INNER JOIN TipoProducto ON Producto.idTipoProducto = TipoProducto.idTipoProducto";
        Object[][] regs = new Object[count][5];
        try {
            PreparedStatement pstm = conn.getConnection().prepareStatement(sql);
            ResultSet res = pstm.executeQuery();

            regs[0][0] = 0;
            int c = 0;
            while (res.next()) {
                regs[c][0] = c + 1;
                regs[c][1] = res.getString("nombreProducto");
                regs[c][2] = res.getString("nombreTipoProducto");
                regs[c][3] = res.getDouble("precio");
                regs[c][4] = res.getInt("stock");
                c++;
            }

        } catch (SQLException e) {
            System.out.println(e);
        }

        return regs;
    }

    public LinkedList<BuscarProducto> listaSearch(boolean desactivar, String nomProS, int numero) {

        String sql = null;

        switch (numero) {
            case 1:

                sql = "SELECT nombreProducto, nombreTipoProducto, stock, precio "
                        + "FROM Producto "
                        + "INNER JOIN TipoProducto "
                        + "on Producto.idTipoProducto = TipoProducto.idTipoProducto "
                        + "WHERE TipoProducto.nombreTipoProducto LIKE '" + nomProS + "%'";
                break;
            case 2:

                sql = "SELECT nombreProducto, nombreTipoProducto, stock, precio "
                        + "FROM Producto "
                        + "INNER JOIN TipoProducto "
                        + "on Producto.idTipoProducto = TipoProducto.idTipoProducto "
                        + "WHERE Producto.nombreProducto LIKE '" + nomProS + "%'";
                break;

            case 3:
                //En este caso seleccionaremos todo el registro              

                sql = "SELECT nombreProducto, nombreTipoProducto, stock, precio "
                        + "FROM Producto "
                        + "INNER JOIN TipoProducto "
                        + "on Producto.idTipoProducto = TipoProducto.idTipoProducto ";
                break;
        }       
        
        var buscarProductoList = new LinkedList<BuscarProducto>();        

        try {
            PreparedStatement pstm = conn.getConnection().prepareStatement(sql);
            ResultSet res = pstm.executeQuery();            
            while (res.next()) {
                buscarProductoList.add(new BuscarProducto(
                        res.getString("nombreProducto"),
                        res.getString("nombreTipoProducto"),
                        res.getInt("stock"),                        
                        res.getDouble("precio")
                ));                
            }

            if (desactivar) {
                conn.Desconectar();
            }

        } catch (SQLException e) {
            System.out.println("ListaSearch:");
            System.out.println(e);
        }
        return buscarProductoList;
    }

    public int BuscarIdPro(String nombrePro, boolean desconectar) {

        int idPro = 0;
        String sql = "SELECT idProducto FROM Producto WHERE nombreProducto='" + nombrePro + "'";

        try {
            PreparedStatement pstm = conn.getConnection().prepareStatement(sql);
            ResultSet res = pstm.executeQuery();
            if (res.next()) {
                idPro = res.getInt("idProducto");
                System.out.println("idPro: " + idPro);
            } else {
                System.out.println("No hay nada");
            }
            if (desconectar) {
                conn.Desconectar();
            }
        } catch (SQLException e) {
            System.out.println("IdPro buscar error");
            System.out.println(e);
        }
        return idPro;
    }

    public void UpdatePro(String variable, String opcion, int idProd) {
        String sql = "";

        switch (opcion) {
            case "nombre":
                sql = "UPDATE Producto SET nombreProducto='" + variable + "' WHERE idProducto='" + idProd + "'";
                break;
            case "precio":
                Double pprecio = Double.parseDouble(variable);
                sql = "UPDATE Producto SET precio='" + pprecio + "' WHERE idProducto='" + idProd + "'";
                break;
            case "cantidad":
                int sstock = Integer.parseInt(variable);
                sql = "UPDATE Producto SET stock='" + sstock + "' WHERE idProducto='" + idProd + "'";
                break;
        }
        try {
            PreparedStatement pstm = conn.getConnection().prepareStatement(sql);
            pstm.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void DeletePro(int idDelete, boolean desactivar) {
        String sql = "DELETE FROM Producto WHERE idProducto='" + idDelete + "'";
        try {
            PreparedStatement pstm = conn.getConnection().prepareStatement(sql);
            pstm.executeUpdate();
            if (desactivar) {
                conn.Desconectar();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void updateStock(int can, int id, boolean desconectar) {
        String sql = "UPDATE Producto SET stock='" + can + "' WHERE idProducto='" + id + "'";

        try {
            PreparedStatement pstm = conn.getConnection().prepareStatement(sql);
            pstm.executeUpdate();
            if (desconectar) {
                conn.Desconectar();
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    private int ContarTotal() {

        int count = 0;
        String sql2 = "SELECT COUNT(*) FROM Producto";
        try {
            PreparedStatement pstm = conn.getConnection().prepareStatement(sql2);
            ResultSet res = pstm.executeQuery();

            if (res.next()) {
                count = res.getInt(1);
            }
            System.out.println("Cantidad de registros P: " + count);
            //conn.Desconectar(); //esto desconecta la conexion y no funciona la consulta en el siguiente metodo
        } catch (SQLException e) {
            System.out.println("ContarTotal");
            System.out.println(e);
        }
        //total = count;
        return count;
    }

    private int ContarTotalNomPro() {
        int iid = 0;
        String sql = "SELECT COUNT(*) FROM Producto "
                + "INNER JOIN TipoProducto "
                + "ON Producto.idTipoProducto = TipoProducto.idTipoProducto "
                + "WHERE TipoProducto.idTipoProducto ='" + idTipoPro + "'";
        try {
            PreparedStatement pstm = conn.getConnection().prepareStatement(sql);
            ResultSet res = pstm.executeQuery();
            if (res.next()) {
                iid = res.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("ContarTotalNomPro");
            System.out.println(e.getSQLState());
            System.out.println(e);
        }

        return iid;
    }
}
