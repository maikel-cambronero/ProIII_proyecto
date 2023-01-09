package Presentacion;

public class PantallaCarga extends javax.swing.JFrame {

    public PantallaCarga() {
        initComponents();
        // Coloca la ventana en el centro de la pantalla
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Pantalla_Carga = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        progressBar = new javax.swing.JProgressBar();
        lblcarga = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        Pantalla_Carga.setBackground(new java.awt.Color(255, 255, 255));
        Pantalla_Carga.setForeground(new java.awt.Color(204, 204, 204));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/Iconos/icons8-rhombus-loader (1).gif"))); // NOI18N

        lblcarga.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        jLabel2.setBackground(new java.awt.Color(153, 153, 153));
        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Programación 3");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/Iconos/19362653-768x432.jpg"))); // NOI18N

        javax.swing.GroupLayout Pantalla_CargaLayout = new javax.swing.GroupLayout(Pantalla_Carga);
        Pantalla_Carga.setLayout(Pantalla_CargaLayout);
        Pantalla_CargaLayout.setHorizontalGroup(
            Pantalla_CargaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(progressBar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(Pantalla_CargaLayout.createSequentialGroup()
                .addGap(288, 288, 288)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(Pantalla_CargaLayout.createSequentialGroup()
                .addGroup(Pantalla_CargaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Pantalla_CargaLayout.createSequentialGroup()
                        .addGap(302, 302, 302)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(Pantalla_CargaLayout.createSequentialGroup()
                        .addGap(219, 219, 219)
                        .addComponent(lblcarga, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Pantalla_CargaLayout.setVerticalGroup(
            Pantalla_CargaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Pantalla_CargaLayout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(lblcarga, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Pantalla_Carga, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Pantalla_Carga, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Método para mostrar la pantalla de carga.
     * Este se coloca en un try ans catch para validar los errores. 
     */
    public static void main(String args[]) {
        PantallaCarga pantalla = new PantallaCarga();
        pantalla.setVisible(true);
        try {
            for (int i = 0; i <= 100; i++) {
                Thread.sleep(50);
                pantalla.progressBar.setValue(i);
                pantalla.lblcarga.setText("Cargando sistema espere por favor... " + (Integer.toString(i) + "%"));
                if (i == 100) {
                    pantalla.setVisible(false);
                    Chats Chat = new Chats();
                    Chat.setVisible(true);
                }
            }
        } catch (Exception e) {
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Pantalla_Carga;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblcarga;
    private javax.swing.JProgressBar progressBar;
    // End of variables declaration//GEN-END:variables
}
