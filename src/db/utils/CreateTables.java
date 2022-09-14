package db.utils;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author henrry
 */
public class CreateTables {

    private Connection connection;

    public void createTablesSqite(Connection connection) throws SQLException {
        this.connection = connection;
        createProduct();
        createProductType();
        createSalesRecord();
        createProductSales();
    }

    private void createProduct() throws SQLException {
        String sql = "CREATE table producto (idProducto"
                + " integer primary key NOT NULL, "
                + "nombreProducto text NOT NULL,idTipoProducto integer NOT NULL,"
                + " stock integer NOT NULL, precio real NOT NULL)";

        var statement = connection.createStatement();
        statement.executeUpdate(sql);
    }

    private void createProductType() throws SQLException {

        String sql = "CREATE TABLE tipoproducto ("
                + " idTipoProducto integer primary key NOT NULL,"
                + "  nombreTipoProducto text NOT NULL"
                + ")";

        var statement = connection.createStatement();
        statement.executeUpdate(sql);

    }

    private void createSalesRecord() throws SQLException {
        String sql = "CREATE TABLE registroventa ("
                + "  idRegistroVenta integer primary key NOT NULL,"
                + "  costoTotal decimal NOT NULL"
                + ") ";
        var statement = connection.createStatement();
        statement.executeUpdate(sql);
    }

    private void createProductSales() throws SQLException {
        String sql = "CREATE TABLE productovendido ("
                + "  idProductoVendido integer primary key NOT NULL,"
                + "  idProducto integer NOT NULL,"
                + "  cantidad integer NOT NULL,"
                + "  subtotal decimal NOT NULL,"
                + "  idRegistroVentas integer NOT NULL"
                + ")";
        var statement = connection.createStatement();
        statement.executeUpdate(sql);
    }
}
