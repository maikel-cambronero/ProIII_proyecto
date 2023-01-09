package Presentacion;

import Datos.Conexion;
import Logica.Mensajes;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;

public class Mensajeria extends javax.swing.JFrame implements Runnable {

    //Se crea una intancia de la clase conexion
    public Conexion conect = new Conexion();

    // Variables globales para mostrar la hora.
    String hora, minutos, segundos;
    // Permite mostrar la hora en tiempo real.
    Thread hilo;

    public Mensajeria() {
        initComponents();
        // Ubica la ventana en el centro de la pantalla.
        setLocationRelativeTo(null);

        // Valida la conexion, si está es falsa cierra el sistema.
        if (conect.ConexionOK == false) {
            System.exit(0);
        }
        // Se llama al metodo mostrar que se creó con la instancia del hilo.
        mostrar();

        // Se llama al JLabel con el nombre de "lblFecha"
        // el cual recibe por parámetro "fecha()"
        lblFecha.setText(fecha());
        //Se instancia el hilo.
        hilo = new Thread(this);
        // Se levanta el hilo
        hilo.start();
        // Hace visible la fecha y hora.
        setVisible(true);
    }

    /**
     * Método para validar que los campos esten llenos y si no mostrará un
     * mensaje indicando que debe digitar información en esos campos.
     */
    public void validarInfo() {
        if ("".equals(txt_msjPara.getText())) {
            JOptionPane.showMessageDialog(this, "Debe digitar a quien desea enviarle el mensaje");
        }
        if ("".equals(txt_msjDe.getText())) {
            JOptionPane.showMessageDialog(this, "Debe digitar quien envía el mensaje");
        }
        if ("".equals(txta_enviar.getText())) {
            JOptionPane.showMessageDialog(this, "Debe digitar quien envía el mensaje");
        }
    }

    /**
     * Método en el que se instancia un hilo para mostrar el mensaje, todo lo
     * que este entre los {}); se ejecutará en el hilo. Además de establecerle
     * un tiempo de espera y levantar el hilo
     */
    public void mostrar() {

        Thread hilo = new Thread(new Runnable() {

            @Override
            public void run() {
                // Se iguala el método "obtenerMensaje(txt_msjDe.getText())"
                // a una variable de nombre "obtener"
                String obtener = conect.obtenerMensaje(txt_msjDe.getText());

                // Se valida que obtener sea diferente de obtener.
                // si lo es ejecuta las instricciones.
                if (obtener != null) {
                    txta_recibido.setText("");
                    txta_recibido.setText(obtener);
                    conect.actualizarVisto(txt_msjDe.getText());
                }
                try {
                    mostrar();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Error al mostrar el mensaje");
                }
            }
        });
        // Se establece el tiempo de espera que tiene cada mensaje a la hora 
        // de mostrarce. 
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            JOptionPane.showMessageDialog(null, "Error al establecer el tiempo de espera.");
        }
        // Se levanta el hilo.
        hilo.start();
    }

    /**
     * Método que nos permite obtener la fecha y hora en tiempo real.
     */
    public void hora() {
        // Se llama a la palabra reservada "Calendar" la cual obtiene el calendario Gregoriano 
        Calendar calendario = new GregorianCalendar();
        // Se llama a la pablabra reservada "Date" la cual obtiene la hora
        Date horaActual = new Date();
        // Obtiene la hora de la pc y se agrega a una al objeto "horaActual"
        calendario.setTime(horaActual);
        hora = calendario.get(Calendar.HOUR_OF_DAY) > 9 ? "" + calendario.get(Calendar.HOUR_OF_DAY) : "O"
                + calendario.get(Calendar.HOUR_OF_DAY);
        minutos = calendario.get(Calendar.MINUTE) > 9 ? "" + calendario.get(Calendar.MINUTE) : "O"
                + calendario.get(Calendar.MINUTE);
        segundos = calendario.get(Calendar.SECOND) > 9 ? "" + calendario.get(Calendar.SECOND) : "O"
                + calendario.get(Calendar.SECOND);
    }

    /**
     * Hilo que corre de fondo actualizando la fecha, hora, minutos y segundos.
     */
    public void run() {
        Thread current = Thread.currentThread();

        while (current == hilo) {
            hora();
            lblHora.setText(hora + ":" + minutos + ":" + segundos);

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblHora = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        btn_enviar = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txt_msjDe = new javax.swing.JTextField();
        txt_msjPara = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txta_enviar = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        txta_recibido = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Panel3.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                Panel3AncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setText("Mensaje Recibido");

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setForeground(new java.awt.Color(102, 102, 102));

        lblHora.setBackground(new java.awt.Color(0, 0, 0));
        lblHora.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblHora.setText("00:00:00");

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/Iconos/hora.png"))); // NOI18N

        lblFecha.setBackground(new java.awt.Color(0, 0, 0));
        lblFecha.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblFecha.setText("DD / MM/  YYYY");

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/Iconos/calendario (2).png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(148, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblFecha)
                .addGap(51, 51, 51)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblHora, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblHora, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));
        jPanel3.setForeground(new java.awt.Color(102, 102, 102));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/Iconos/boton-de-retroceso.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(0, 51, 102));
        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 102));
        jLabel2.setText("Chats");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        btn_enviar.setBackground(new java.awt.Color(102, 102, 102));
        btn_enviar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btn_enviar.setForeground(new java.awt.Color(255, 255, 255));
        btn_enviar.setText("Enviar");
        btn_enviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_enviarActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel14.setText("Mensaje a enviar");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setText("De:");

        jLabel13.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel13.setText("Para:");

        txt_msjDe.setBackground(new java.awt.Color(102, 102, 102));
        txt_msjDe.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_msjDe.setForeground(new java.awt.Color(255, 255, 255));

        txt_msjPara.setBackground(new java.awt.Color(102, 102, 102));
        txt_msjPara.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_msjPara.setForeground(new java.awt.Color(255, 255, 255));

        txta_enviar.setBackground(new java.awt.Color(102, 102, 102));
        txta_enviar.setColumns(20);
        txta_enviar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txta_enviar.setForeground(new java.awt.Color(255, 255, 255));
        txta_enviar.setRows(5);
        jScrollPane1.setViewportView(txta_enviar);

        txta_recibido.setBackground(new java.awt.Color(102, 102, 102));
        txta_recibido.setColumns(20);
        txta_recibido.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txta_recibido.setForeground(new java.awt.Color(255, 255, 255));
        txta_recibido.setRows(20);
        jScrollPane2.setViewportView(txta_recibido);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/Iconos/settings.gif"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btn_enviar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(238, 238, 238)
                        .addComponent(jLabel4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(227, 227, 227)
                        .addComponent(jLabel14)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane2))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_msjDe, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_msjPara, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addGap(45, 45, 45))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel14))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(138, 138, 138)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 235, Short.MAX_VALUE)
                        .addComponent(jLabel12))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(73, 73, 73)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(txt_msjDe, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(70, 70, 70)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel13)
                                    .addComponent(txt_msjPara, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addComponent(jLabel8)))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(btn_enviar)
                .addGap(37, 37, 37)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(88, 88, 88)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout Panel3Layout = new javax.swing.GroupLayout(Panel3);
        Panel3.setLayout(Panel3Layout);
        Panel3Layout.setHorizontalGroup(
            Panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        Panel3Layout.setVerticalGroup(
            Panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Panel3AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_Panel3AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_Panel3AncestorAdded

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        /**
         * Llama a la ventana chast y oculata la ventana Mensajeria.
         */
        Chats panel = new Chats();
        panel.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void btn_enviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_enviarActionPerformed
        /**
         * Se llama al método validar información
         * Se igualan los campos a los parametros de la clase Mensaje
         * Se llama al metodo insertarBDclien y
         * se le da por parámetro el objeto de la clase Mensajes.
         */
        validarInfo();

        Mensajes mensaje = new Mensajes();
        mensaje.setMsg_De(txt_msjDe.getText());
        mensaje.setMsg_Para(txt_msjPara.getText());
        mensaje.setLeido("N");
        mensaje.setMensaje(txta_enviar.getText());

        conect.insertarBDclien(mensaje);

        // Se limpia el campo "txta_enviar"
        txta_enviar.setText("");
    }//GEN-LAST:event_btn_enviarActionPerformed

    /**
     * Obtiene la fecha actual.
     * @return devuelve la fecha de la pc
     */
    public static String fecha() {
        Date fecha = new Date();
        SimpleDateFormat formatofecha = new SimpleDateFormat("dd/MM/YYYY");
        return formatofecha.format(fecha);
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Mensajeria.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Mensajeria.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Mensajeria.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Mensajeria.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Mensajeria().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Panel3;
    private javax.swing.JButton btn_enviar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblHora;
    private javax.swing.JTextField txt_msjDe;
    private javax.swing.JTextField txt_msjPara;
    private javax.swing.JTextArea txta_enviar;
    private javax.swing.JTextArea txta_recibido;
    // End of variables declaration//GEN-END:variables
}
