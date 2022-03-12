/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package licoreriawilma;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.chart.ChartUtilities;

/**
 *
 * @author henrryagc
 */
public class Inicio extends JPanel {

    /*private final JTextField campoText1;
    private final JTextField campoText2;
    private final JLabel etiqueta1;*/
    private JFreeChart chart;
    public Inicio(String accion){
        System.out.println("Grafica tomada: "+accion);
    }
    public Inicio() {
        super.setLayout(null);
        //lineaa ventas por mes xd
        /* campoText1 = new JTextField(10);
        add(campoText1);
        campoText2 = new JTextField("Escriba su Texto Aqui");
        add(campoText2);
        etiqueta1 = new JLabel("Soy una etiqueta");
        add(etiqueta1);*/

        // Create Dataset
        CategoryDataset dataset = createDataset();

        chart = ChartFactory.createBarChart3D(
                "GRÁFICO DE BARRAS CANTIDAD DE PRODUCTOS EN LA TIENDA", //Chart Title
                "TOTAL DE PRODUCTOS", // Category axis
                "CANTIDAD POR PRODUCTO", // Value axis
                dataset,
                PlotOrientation.VERTICAL,
                true, true, true
        );
        
         
        ChartPanel panel = new ChartPanel(chart);
        //panel.setSize(250,600);
        //JScrollPane scroll = new JScrollPane(panel);
        
        //panel.setSize(920, 480);
        //scroll.setVisible(true);
        //scroll.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
       // scroll.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        int y = panel.getHeight();
        int x = panel.getX();
        //System.out.printf("y:%s  x:%s ",y,x);
        //panel.setVisible(true);
        super.add(panel);
        //super.setPreferredSize(new Dimension(400,400));
        
    }

    /**
     *
     * @param g
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(new Color(0, 102, 0));
    }

    private CategoryDataset createDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        /*
        Producto pro = new Producto("",0,0.0,0);
        Object[][] product_list = pro.BuscarProductoChart();
        
        for (Object[] product_list1 : product_list) {
            String rowkey = String.valueOf(product_list1[0]);
            int valor = Integer.parseInt(String.valueOf(product_list1[1]));
            
            dataset.addValue(valor, rowkey,"");
        }*/
        for (int i = 1; i < 500; i++) {
                int x = (i * 50) / 3;
            dataset.addValue(x, ("Pr"+x), "");
        }
        // Population in 2005
//        dataset.addValue(10, "Ruskaya", "");
//        dataset.addValue(15, "Corona", "");
//        dataset.addValue(20, "Pilsen", "");
//        dataset.addValue(4, "Ron Blanco", "");
//        dataset.addValue(4, "Pisco Blanco", "");
//        dataset.addValue(90, "Chin", "");
//        dataset.addValue(25, "hina", "");
//        dataset.addValue(40, "Cina", "");

        /*// Population in 2010
        dataset.addValue(15, "USA", "2010");
        dataset.addValue(20, "India", "2010");
        dataset.addValue(25, "China", "2010");

        // Population in 2015
        dataset.addValue(20, "USA", "2015");
        dataset.addValue(25, "India", "2015");
        dataset.addValue(30, "China", "2015");*/
        return dataset;
    }
    
    
}
