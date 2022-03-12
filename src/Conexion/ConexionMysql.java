/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author henrryagc
 */
public class ConexionMysql {
    static String bd = "licoreria";
    static String login = "admin";
    static String password = "password";
    String url = "jdbc:mysql://localhost/"+bd;
    Connection conn = null;
    public ConexionMysql()
    {      try
           {   //obtenemos el driver de para mysql
               Class.forName("com.mysql.cj.jdbc.Driver");
               //Obtenemos la conexión
               conn = DriverManager.getConnection(url, login, password);
               if (conn!=null)
               {   System.out.println("Conexion a base de datos "+bd+" OK");
               }
           }
           catch(SQLException e)
           {   System.out.println(e);      
           }
	   catch(ClassNotFoundException e)
	   {   System.out.println(e);      
           }
    }
    public Connection getConnection()
    {   return conn;    }

    public void Desconectar()
    {   conn = null;   }
}
