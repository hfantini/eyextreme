package eye.xtreme;

import ij.ImagePlus;
import ij.process.ImageProcessor;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import java.sql.*;
import javax.swing.JOptionPane;
import java.io.FileOutputStream;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Cadastro extends javax.swing.JFrame {

    Engine engine = new Engine();
    static ImageProcessor imgEyeOld;
    static ImageProcessor imgEyeNew;
    
    public Cadastro() 
    {
        initComponents();
        this.show();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grpCadastro = new javax.swing.JPanel();
        grpInfo = new javax.swing.JPanel();
        lblNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        lblID = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        lblCargo = new javax.swing.JLabel();
        txtCargo = new javax.swing.JTextField();
        grpImagem = new javax.swing.JPanel();
        p1 = new javax.swing.JPanel();
        lblImgOld = new javax.swing.JLabel();
        p2 = new javax.swing.JPanel();
        lblImgNew = new javax.swing.JLabel();
        lblSeta = new javax.swing.JLabel();
        lblInfo = new javax.swing.JLabel();
        lblFinal = new javax.swing.JLabel();
        btnCadastrar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastrar nova entrada");

        grpCadastro.setBorder(javax.swing.BorderFactory.createTitledBorder("Cadastro"));

        grpInfo.setBorder(javax.swing.BorderFactory.createTitledBorder("Info"));

        lblNome.setText("Nome:");

        lblID.setText("ID:");

        lblCargo.setText("Cargo:");

        javax.swing.GroupLayout grpInfoLayout = new javax.swing.GroupLayout(grpInfo);
        grpInfo.setLayout(grpInfoLayout);
        grpInfoLayout.setHorizontalGroup(
            grpInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(grpInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(grpInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblID)
                    .addComponent(lblNome))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(grpInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNome, javax.swing.GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE)
                    .addGroup(grpInfoLayout.createSequentialGroup()
                        .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 121, Short.MAX_VALUE)
                        .addComponent(lblCargo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        grpInfoLayout.setVerticalGroup(
            grpInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(grpInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(grpInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNome)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(grpInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblID)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCargo)
                    .addComponent(txtCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        grpImagem.setBorder(javax.swing.BorderFactory.createTitledBorder("Imagem"));

        p1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblImgOld.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lblImgOldMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout p1Layout = new javax.swing.GroupLayout(p1);
        p1.setLayout(p1Layout);
        p1Layout.setHorizontalGroup(
            p1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblImgOld, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
        );
        p1Layout.setVerticalGroup(
            p1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblImgOld, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
        );

        p2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout p2Layout = new javax.swing.GroupLayout(p2);
        p2.setLayout(p2Layout);
        p2Layout.setHorizontalGroup(
            p2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblImgNew, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
        );
        p2Layout.setVerticalGroup(
            p2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblImgNew, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
        );

        lblSeta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/eye/icons/agt_forward-64.png"))); // NOI18N

        lblInfo.setText("Clique no quadrado para carregar a imagem:");

        lblFinal.setText("Imagem Final");

        javax.swing.GroupLayout grpImagemLayout = new javax.swing.GroupLayout(grpImagem);
        grpImagem.setLayout(grpImagemLayout);
        grpImagemLayout.setHorizontalGroup(
            grpImagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(grpImagemLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(grpImagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(grpImagemLayout.createSequentialGroup()
                        .addComponent(p1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                        .addGroup(grpImagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblFinal)
                            .addComponent(lblSeta))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(p2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblInfo))
                .addContainerGap())
        );
        grpImagemLayout.setVerticalGroup(
            grpImagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(grpImagemLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblInfo)
                .addGroup(grpImagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(grpImagemLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(grpImagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(p2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(p1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, grpImagemLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblFinal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblSeta, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))))
        );

        btnCadastrar.setText("Cadastrar");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        btnLimpar.setText("Limpar");

        javax.swing.GroupLayout grpCadastroLayout = new javax.swing.GroupLayout(grpCadastro);
        grpCadastro.setLayout(grpCadastroLayout);
        grpCadastroLayout.setHorizontalGroup(
            grpCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(grpCadastroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(grpCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(grpImagem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(grpInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, grpCadastroLayout.createSequentialGroup()
                        .addComponent(btnLimpar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        grpCadastroLayout.setVerticalGroup(
            grpCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(grpCadastroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(grpInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(grpImagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(grpCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCadastrar)
                    .addComponent(btnLimpar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(grpCadastro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(grpCadastro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void lblImgOldMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblImgOldMouseReleased
   
    ImagePlus image = ij.IJ.openImage();

    imgEyeOld = image.getProcessor();
    engine.exibeImagem(imgEyeOld, lblImgOld);
    engine.processaImagem(imgEyeOld, imgEyeNew, lblImgNew);
}//GEN-LAST:event_lblImgOldMouseReleased

private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed

    String prog = System.getProperty("user.dir").replace('\\', '/');
    String saida = prog + "/proc/" + txtID.getText() + ".png";
    String sql = "INSERT INTO Pessoa(pes_nome, pes_ident, pes_img, pes_cargo) VALUES('"+ txtNome.getText() +"','" + txtID.getText() + "','" + txtID.getText() + ".png', '" + txtCargo.getText() + "')";

       
        try
        {
            ImageIO.write((RenderedImage) ((ImageIcon) lblImgNew.getIcon()).getImage(), "png", new File(saida));
        } 
        catch (IOException ex)
        {
            Logger.getLogger(Cadastro.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    try
    {
        //REALIZA CADASTRO NA BASE DE DADOS
        Statement st = Connect.getConn().createStatement();
        st.execute(sql);
        JOptionPane.showMessageDialog(null, "Gravado com sucesso!");

        //LIMPA OS CAMPOS
        txtID.setText("");
        txtNome.setText("");
        txtCargo.setText("");
        lblImgNew.setIcon(null);
        lblImgOld.setIcon(null);
    }
    catch (SQLException ex)
    {
        JOptionPane.showMessageDialog(null, "Falha ao gravar os dados no Banco de Dados. \n\n Mensagem: " + ex.getMessage());
    }
       
}//GEN-LAST:event_btnCadastrarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JToggleButton btnLimpar;
    private javax.swing.JPanel grpCadastro;
    private javax.swing.JPanel grpImagem;
    private javax.swing.JPanel grpInfo;
    private javax.swing.JLabel lblCargo;
    private javax.swing.JLabel lblFinal;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblImgNew;
    private javax.swing.JLabel lblImgOld;
    private javax.swing.JLabel lblInfo;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblSeta;
    private javax.swing.JPanel p1;
    private javax.swing.JPanel p2;
    private javax.swing.JTextField txtCargo;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
