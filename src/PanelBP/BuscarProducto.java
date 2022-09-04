/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Singleton.java to edit this template
 */
package PanelBP;

/**
 *
 * @author henrry
 */
public class BuscarProducto {

    public String nombreProducto;
    public String nombreTipoProducto;
    public int stock;
    public double precio;   
    
    public BuscarProducto(String nombreProducto, String nombreTipoProducto, int stock, double precio) {
        this.nombreProducto = nombreProducto;
        this.nombreTipoProducto = nombreTipoProducto;
        this.stock = stock;
        this.precio = precio;
    }
}
