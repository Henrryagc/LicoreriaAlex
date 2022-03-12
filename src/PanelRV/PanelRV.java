/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PanelRV;

//import javax.swing.ComboBoxModel;
import Option.SiNoDialog;
import java.awt.Font;
import java.text.DecimalFormat;
import licoreriawilma.Producto;
import licoreriawilma.TipoProducto;

/**
 *
 * @author henrryagc
 */

public class PanelRV extends javax.swing.JPanel {

    /**
     * Creates new form PanelRV
     */
    private String[] tipoPro;   //Todos los Tipos de Producto
    private String[] nomPro;    //Todos los nombres del producto
    private Object[][] produc;  //todos los productos
    private int fila;
    //private int columna;
    private int[] stock;
    Object[][] carrito;
    private int fil;
    private int col;
    // Total del costo S/. 00.00
    double total;

    
    //Esta libreria nos ayudara a tener los doubles mas ordenados
    //private static DecimalFormat df2 = new DecimalFormat("0.00"); // este tiene redondeo automatico y pueden ser mayor o igual a 1 decimal
     //Esto estricatmente numeros diferencia numeral y ceros .... aunque creo que es un error ya que el detalle estaba en la coma y punto del decimal xddd
    private static DecimalFormat df2 = new DecimalFormat("#.##");
    
    public PanelRV() {        
        initComponents();
        fila = 0;
        //columna = 0;
        carrito = new Object[25][6];
        stock = new int[25];
        total = 0.0;
        CargarTipoProducto();//Cargamos el comboBox1 de los tipos de productos
        CargarProducto(1);//Cargamos el comboBox2 de los tipos de productos
        System.out.println("Hola Mundo desde el constructor");
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        jButton1 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setBackground(new java.awt.Color(212, 66, 0));
        setForeground(new java.awt.Color(204, 204, 204));
        setPreferredSize(new java.awt.Dimension(920, 560));
        setRequestFocusEnabled(false);

        jLabel1.setFont(new java.awt.Font("Courier 10 Pitch", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("REGISTRO DE VENTA DE PRODUCTOS");
        jLabel1.setBorder(null);

        jLabel2.setFont(new java.awt.Font("Courier 10 Pitch", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Tipo de Producto:");

        jLabel3.setFont(new java.awt.Font("Courier 10 Pitch", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nombre del Producto:");

        jLabel4.setFont(new java.awt.Font("Courier 10 Pitch", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Precio del producto:");

        jComboBox1.setBackground(new java.awt.Color(255, 255, 255));
        jComboBox1.setFont(new java.awt.Font("Courier 10 Pitch", 1, 16)); // NOI18N
        jComboBox1.setForeground(new java.awt.Color(0, 102, 204));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Licores" }));
        jComboBox1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });

        jComboBox2.setBackground(new java.awt.Color(255, 255, 255));
        jComboBox2.setFont(new java.awt.Font("Courier 10 Pitch", 1, 16)); // NOI18N
        jComboBox2.setForeground(new java.awt.Color(0, 102, 204));
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ruskaya" }));
        jComboBox2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jComboBox2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox2ItemStateChanged(evt);
            }
        });

        jTextField1.setFont(new java.awt.Font("Courier 10 Pitch", 1, 16)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(0, 102, 204));
        jTextField1.setText("00.00");
        jTextField1.setCaretColor(new java.awt.Color(0, 204, 51));
        jTextField1.setDisabledTextColor(new java.awt.Color(0, 102, 204));
        jTextField1.setEnabled(false);
        jTextField1.setSelectedTextColor(new java.awt.Color(255, 51, 0));
        jTextField1.setSelectionColor(new java.awt.Color(102, 204, 255));

        jTable1.setBackground(new java.awt.Color(0, 102, 204));
        jTable1.setFont(new java.awt.Font("Fira Code", 1, 14)); // NOI18N
        jTable1.setForeground(new java.awt.Color(255, 255, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "NUMERO", "PRODUCTO", "TIPO PRODUCTO", "PRECIO", "CANTIDAD", "SUBTOTAL"
            }
        ));
        jTable1.setRowHeight(20);
        jTable1.setSelectionBackground(new java.awt.Color(255, 255, 255));
        jTable1.setSelectionForeground(new java.awt.Color(204, 0, 102));
        jTable1.setShowGrid(true);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTable1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTable1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTable1KeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel5.setFont(new java.awt.Font("Courier 10 Pitch", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("LISTA DE PRODUCTOS EN EL CARRITO");

        jLabel6.setFont(new java.awt.Font("Courier 10 Pitch", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 51));
        jLabel6.setText("STOCK");
        jLabel6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        jLabel7.setBackground(new java.awt.Color(204, 204, 204));
        jLabel7.setFont(new java.awt.Font("Fira Code Medium", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("0");
        jLabel7.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 255, 255), 2, true));

        jLabel8.setFont(new java.awt.Font("Courier 10 Pitch", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("S/.");

        jLabel9.setFont(new java.awt.Font("Courier 10 Pitch", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Cantidad de productos:");

        jSpinner1.setFont(new java.awt.Font("Courier 10 Pitch", 1, 14)); // NOI18N
        jSpinner1.setModel(new javax.swing.SpinnerNumberModel(1, 1, 99, 1));

        jButton1.setBackground(new java.awt.Color(0, 102, 204));
        jButton1.setFont(new java.awt.Font("Courier 10 Pitch", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cruz-30.png"))); // NOI18N
        jButton1.setText("AGREGAR PRODUCTO");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Courier 10 Pitch", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("TOTAL: S/.");

        jTextField2.setFont(new java.awt.Font("Fira Code Retina", 1, 16)); // NOI18N
        jTextField2.setForeground(new java.awt.Color(0, 102, 204));
        jTextField2.setText("00.00");
        jTextField2.setDisabledTextColor(new java.awt.Color(0, 102, 204));
        jTextField2.setEnabled(false);

        jButton2.setBackground(new java.awt.Color(251, 11, 107));
        jButton2.setFont(new java.awt.Font("Courier 10 Pitch", 1, 22)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/guardar-25.png"))); // NOI18N
        jButton2.setText("GUARDAR VENTA");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(0, 204, 204));
        jButton3.setFont(new java.awt.Font("Fira Code", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(0, 29, 66));
        jButton3.setText("NUEVA VENTA");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7))
                    .addComponent(jButton2)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel10)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel3)
                        .addComponent(jLabel2)
                        .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addGap(75, 75, 75)
                        .addComponent(jLabel5)
                        .addGap(0, 117, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(272, 272, 272)
                .addComponent(jLabel1)
                .addContainerGap(228, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jButton3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)))
                .addGap(51, 51, 51))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        // TODO add your handling code here:
        
        //jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(tipoPro));
        // usamos ese if para cargar los detalles una sola vez ya que el spinner con este evente se ejecuta dos veces
         if (evt.getStateChange() == 1)
         {
            TipoProducto np = new TipoProducto(0);
            String nomtp = String.valueOf(jComboBox1.getSelectedItem());
            int iidTipoPro = np.buscarId(nomtp, true);            
        
            CargarProducto(iidTipoPro);
            //Para asegurar la carga de los tipos de productos nuevos que se ingresen en nuevo producto           
           //Cargamos el comboBox1 de los tipos de productos
         }
        
 
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void jComboBox2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox2ItemStateChanged
        // TODO add your handling code here:
        //Aqui se deciden los eventos de cada uno de los producos por cada tipo de producto en los combobox
        //recuperamos el indice del nombre seleccionado en el combobox
        // usamos ese if para cargar los detalles una sola vez ya que el spinner con este evente se ejecuta dos veces
        if (evt.getStateChange() == 1)
        {            
            int numeroCombo = jComboBox2.getSelectedIndex();

            //enviamos el stock del producto seleccionado en el combobox
            jLabel7.setText(String.valueOf(produc[numeroCombo][2]));
            //enviamos el precio del producto seleccionado en el combobox
            jTextField1.setText(String.valueOf(produc[numeroCombo][3]));
        }
               
    }//GEN-LAST:event_jComboBox2ItemStateChanged

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        //Llenamos el carrito con los productos que el cliente compre
        // Agregar productos para vender
        CargarCarrito();
        CargarTipoProducto();
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
        //    Guardar nuevo registro de venta
       int n = Message("¿Desea guardar el registro de venta?");
       switch(n){
           case 1:
                GuardarRegistroVenta();
               break;
           case 0:
               break;
       }
           
    }//GEN-LAST:event_jButton2MouseClicked

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        fil = jTable1.getSelectedRow();
        col = jTable1.getSelectedColumn();
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTable1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1KeyPressed

    private void jTable1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1KeyTyped

    private void jTable1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyReleased
        // TODO add your handling code here:
        EditarCantidad();
    }//GEN-LAST:event_jTable1KeyReleased

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        // TODO add your handling code here:
         jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null}
            },
            new String [] {
                "NUMERO", "PRODUCTO", "TIPO PRODUCTO", "PRECIO", "CANTIDAD", "SUBTOTAL"
            }
        ));
        fila = 0;
        //columna = 0;
        carrito = new Object[25][6];
        stock = new int[25];
        total = 0.0;
        jTextField2.setText("00.00");
    }//GEN-LAST:event_jButton3MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    
    
    
    /**
     * Creamos las funciones que necesitaremos
     */
    private void CargarTipoProducto() {
        TipoProducto np = new TipoProducto(0);        
        tipoPro = np.buscarNombreTipoProducto(true);
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(tipoPro));
        //ComboBoxModel<String> aModel = null;
        //        jComboBox1.setModel(aModel);
        // Aprovechamos que se carga al inicio para darle algunos detalles a la tabla
        jTable1.getTableHeader().setFont(new Font("Fira Code", Font.BOLD,14));          
    }

    private void CargarProducto(int idTipoProducto) {

        Producto npro = new Producto("", 0, 0.0, idTipoProducto);//Creamos un objeto nuevo de la clase Producto
        System.out.println("CargarProducto Hello Worlds /---------------------");
        nomPro = npro.buscarNombreProducto();//Recuperamos los nombres del registro de la clase Producto
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(nomPro));//Cargamos los nombres al combobox
        //ComboBoxModel<String> aModel = null;
        //jComboBox1.setModel(aModel);

        produc = npro.buscarProducto(true);//buscamos los registros de la clase Producto, enviamos true para desconectar la conexion

        int numeroCombo = jComboBox2.getSelectedIndex();//recuperamos el indice del NOMBRE seleccionado en el combobox
        jLabel7.setText(String.valueOf(produc[numeroCombo][2]));//enviamos el STOCK del producto seleccionado en el combobox
        jTextField1.setText(String.valueOf(produc[numeroCombo][3]));//enviamos el precio del producto seleccionado en el combobox
    }
    
    private void CargarCarrito(){
        //Numero
          // fila + 1
        //Producto
        String producto = String.valueOf(jComboBox2.getSelectedItem());
        
        //Tipo Producto
        String tipoproducto = String.valueOf(jComboBox1.getSelectedItem());
        
        //Precio
        double precio = Double.parseDouble(jTextField1.getText());
        
        //Cantidad
        int cantidad = Integer.parseInt(String.valueOf(jSpinner1.getValue()));
        
        //Sub Total
        double subtotal = cantidad * precio;
        String n_sub = df2.format(subtotal).replace(",", ".");
               subtotal = Double.valueOf(n_sub);
        //Nuevo Producto para el carrito
        boolean nuevoProducto = true;
        
        
        
        if (fila != 0) {
            for (int i = 0; i < fila; i++) {
                
                if (producto.equals(carrito[i][1])) {
                    //Aqui caputaramos el total
                    total += subtotal;
                    
                    int cant_anterior = (int)carrito[i][4];
                    
                    stock[i] = stock[i] - cantidad;
                    jLabel7.setText(String.valueOf(stock[i]));
                    cantidad += cant_anterior;
                    double ant_subtotal = (Double) carrito[i][5];
                    String aant_subtotal = df2.format(ant_subtotal).replace(",", ".");
                           ant_subtotal =Double.parseDouble(aant_subtotal);
                    subtotal += ant_subtotal;
                    String ul_sub = df2.format(subtotal).replace(",", ".");
                           subtotal = Double.parseDouble(ul_sub);
                    carrito[i][4] = cantidad;
                    carrito[i][5] = subtotal;
                    
                    nuevoProducto = false;
                }
                
            }
            
            //si existe nuevo producto al carrito pues lo agregamos
            if (nuevoProducto) {
                carrito[fila][0] = fila + 1;
                carrito[fila][1] = producto;
                carrito[fila][2] = tipoproducto;
                carrito[fila][3] = precio;
                carrito[fila][4] = cantidad;
                carrito[fila][5] = subtotal;
                //Aqui caputaramos el total
                total += subtotal;
                stock[fila] = Integer.parseInt(jLabel7.getText()) - cantidad;
                jLabel7.setText(String.valueOf(stock[fila]));
                fila++;
                
            }
            
        }else{
            carrito[fila][0] = fila + 1;
            carrito[fila][1] = producto;
            carrito[fila][2] = tipoproducto;
            carrito[fila][3] = precio;
            carrito[fila][4] = cantidad;
            carrito[fila][5] = subtotal;
            //Aqui caputaramos el total
            total += subtotal;
            stock[fila] = Integer.parseInt(jLabel7.getText()) - cantidad;
            jLabel7.setText(String.valueOf(stock[fila]));
            fila++;
        }
        
        String n_total = df2.format(total).replace(",", ".");
        total = Double.valueOf(n_total);
        jTextField2.setText(String.valueOf(total));
        
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            carrito,
            new String [] {
                "NUMERO", "PRODUCTO", "TIPO PRODUCTO", "PRECIO", "CANTIDAD", "SUB TOTAL"
            }
        ));
    }
    
    //este metodo nos ayudara a editar la cantidad de productos
    private void EditarCantidad(){
        System.out.println("Recalculando sbt...");
        
       
        System.out.println("fil: "+fil+ " col: "+col);
//Profesor        
//Double sbt=(Double)carrito[fil][col-1]*Integer.parseInt(String.valueOf(carrito[fil][col]));
//carrito[fil][col+1]=sbt;
        int cantidad = Integer.parseInt(String.valueOf(jTable1.getValueAt(fil, col)));
        if (cantidad > 0) {
                    //String cant = String.valueOf();
            

            System.out.println("fil: "+fil+ " col: "+col+" cantidad: "+cantidad);
            double precio = Double.parseDouble(String.valueOf(carrito[fil][3]));

            int ant_cantidad = Integer.parseInt(String.valueOf(carrito[fil][4]));

            carrito[fil][4] = cantidad;
            Double n_subtotal = precio * cantidad;
            String aant_subtotal = df2.format(n_subtotal).replace(",", ".");
            n_subtotal =Double.parseDouble(aant_subtotal);
            carrito[fil][5] =n_subtotal;
            jTable1.setValueAt(n_subtotal, fil, col + 1);

            if (ant_cantidad > cantidad) {
                int diferencia = ant_cantidad - cantidad;
                double descuento = precio * diferencia;
                total = total - descuento;
                stock[fil] = stock[fil] + diferencia;
            }else{
                int diferencia = cantidad - ant_cantidad;
                double descuento = precio * diferencia;
                total = total + descuento;
                stock[fil] = stock[fil] - diferencia;
            }
            //Actualizamos el stock en el formulario
            jLabel7.setText(String.valueOf(stock[fil]));
            String n_total = df2.format(total).replace(",", ".");
            total = Double.valueOf(n_total);
            jTextField2.setText(String.valueOf(total));
        } else {
            System.out.println("Sin cambios cantidad");
        }
        
       
    }
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables

    private void GuardarRegistroVenta() {
        //para guardar el registro de venta
        RegistrarVenta nrv = new RegistrarVenta(total);
        int iidrv = nrv.GuardarRV();
        
        //para guardar los productos del registro de venta
        Producto pro = new Producto("",0,0.0,0);
        for (int i = 0; i < fila; i++) {
           /*
            carrito[fila][0] = fila + 1;
            carrito[fila][1] = producto;
            carrito[fila][2] = tipoproducto;
            carrito[fila][3] = precio;
            carrito[fila][4] = cantidad;
            carrito[fila][5] = subtotal;
            */
           String producto = String.valueOf(carrito[i][1]);
           int cantidad = Integer.parseInt(String.valueOf(carrito[i][4]));
           double subtotal = Double.parseDouble(String.valueOf(carrito[i][5]));
           int idPro = pro.BuscarIdPro(producto, false);
           
           //Actualizar STOCK del Producto
           pro.updateStock(stock[i], idPro,false);
           
           //Guardar el nuevo Registro
           ProductoVendido npv = new ProductoVendido(idPro, cantidad, subtotal, iidrv);
           npv.GuardarProductoVendido();
        }
        
    }

    private int Message(String message) {
        SiNoDialog d = new SiNoDialog(null,true);         
         d.SetTextOption(message);
         d.setVisible(true);
         int a = d.getReturnStatus();
        
         return a;
    }
}
