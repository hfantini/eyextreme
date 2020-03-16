package eye.xtreme;

import ij.ImagePlus;
import ij.process.ImageProcessor;
import java.io.File;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class mainForm extends javax.swing.JFrame
{
    static ImageProcessor imgEyeOld;
    static ImageProcessor imgEyeNew;
    Engine engine = new Engine();
    
    public mainForm()
    {
        initComponents();
        Connect.dbConnect(); //CONECTA A BASE DE DADOS

        //ALTERANDO CONFIGURAÇÕES DO SWING
        this.setTitle("EyeXtreme 2.0 - BETA | Henrique Fantini/2011");
    }

    //METODOS DA CLASSE
    //-------------------------------------------------------------------------
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelData = new javax.swing.JPanel();
        btnProcess = new javax.swing.JButton();
        btnLoad = new javax.swing.JButton();
        panelResult = new javax.swing.JPanel();
        panelProcess = new javax.swing.JPanel();
        p2 = new javax.swing.JPanel();
        lblEyeFinal = new javax.swing.JLabel();
        panelCompare = new javax.swing.JPanel();
        lblNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        lblIdent = new javax.swing.JLabel();
        txtIdent = new javax.swing.JTextField();
        lblCargo = new javax.swing.JLabel();
        txtCargo = new javax.swing.JTextField();
        p3 = new javax.swing.JPanel();
        lblEyeEnt = new javax.swing.JLabel();
        mainMenu = new javax.swing.JMenuBar();
        menuArquivo = new javax.swing.JMenu();
        itemNovo = new javax.swing.JMenuItem();
        itemProcurar = new javax.swing.JMenuItem();
        menuHelp = new javax.swing.JMenu();
        itemInfo = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Eye Xtreme - 0.99b - Henrique Fantini");

        panelData.setBorder(javax.swing.BorderFactory.createTitledBorder("Comparação"));

        btnProcess.setIcon(new javax.swing.ImageIcon(getClass().getResource("/eye/eye.png"))); // NOI18N
        btnProcess.setEnabled(false);
        btnProcess.setPreferredSize(new java.awt.Dimension(64, 64));
        btnProcess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcessActionPerformed(evt);
            }
        });

        btnLoad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/eye/photography.png"))); // NOI18N
        btnLoad.setPreferredSize(new java.awt.Dimension(64, 64));
        btnLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadActionPerformed(evt);
            }
        });

        panelResult.setBorder(javax.swing.BorderFactory.createTitledBorder("Resultado"));

        panelProcess.setBorder(javax.swing.BorderFactory.createTitledBorder("Imagem Processada"));

        p2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout p2Layout = new javax.swing.GroupLayout(p2);
        p2.setLayout(p2Layout);
        p2Layout.setHorizontalGroup(
            p2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblEyeFinal, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
        );
        p2Layout.setVerticalGroup(
            p2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblEyeFinal, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelProcessLayout = new javax.swing.GroupLayout(panelProcess);
        panelProcess.setLayout(panelProcessLayout);
        panelProcessLayout.setHorizontalGroup(
            panelProcessLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 342, Short.MAX_VALUE)
            .addGroup(panelProcessLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelProcessLayout.createSequentialGroup()
                    .addGap(99, 99, 99)
                    .addComponent(p2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(103, Short.MAX_VALUE)))
        );
        panelProcessLayout.setVerticalGroup(
            panelProcessLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 206, Short.MAX_VALUE)
            .addGroup(panelProcessLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelProcessLayout.createSequentialGroup()
                    .addGap(31, 31, 31)
                    .addComponent(p2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(32, 32, 32)))
        );

        panelCompare.setBorder(javax.swing.BorderFactory.createTitledBorder("Comparação no banco de dados"));

        lblNome.setText("Nome:");

        txtNome.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtNome.setEnabled(false);

        lblIdent.setText("Identificação:");

        txtIdent.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtIdent.setEnabled(false);

        lblCargo.setText("Cargo:");

        txtCargo.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtCargo.setEnabled(false);

        javax.swing.GroupLayout panelCompareLayout = new javax.swing.GroupLayout(panelCompare);
        panelCompare.setLayout(panelCompareLayout);
        panelCompareLayout.setHorizontalGroup(
            panelCompareLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCompareLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCompareLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblIdent, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblNome, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelCompareLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelCompareLayout.createSequentialGroup()
                        .addComponent(txtIdent, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblCargo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCargo)))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        panelCompareLayout.setVerticalGroup(
            panelCompareLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCompareLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCompareLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNome)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(panelCompareLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIdent)
                    .addComponent(txtIdent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCargo)
                    .addComponent(txtCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout panelResultLayout = new javax.swing.GroupLayout(panelResult);
        panelResult.setLayout(panelResultLayout);
        panelResultLayout.setHorizontalGroup(
            panelResultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelResultLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelResultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelCompare, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelProcess, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelResultLayout.setVerticalGroup(
            panelResultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelResultLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelProcess, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelCompare, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        p3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout p3Layout = new javax.swing.GroupLayout(p3);
        p3.setLayout(p3Layout);
        p3Layout.setHorizontalGroup(
            p3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblEyeEnt, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
        );
        p3Layout.setVerticalGroup(
            p3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblEyeEnt, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelDataLayout = new javax.swing.GroupLayout(panelData);
        panelData.setLayout(panelDataLayout);
        panelDataLayout.setHorizontalGroup(
            panelDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDataLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(panelDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDataLayout.createSequentialGroup()
                        .addComponent(btnLoad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnProcess, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(p3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addComponent(panelResult, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelDataLayout.setVerticalGroup(
            panelDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDataLayout.createSequentialGroup()
                .addComponent(panelResult, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(22, 22, 22))
            .addGroup(panelDataLayout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(p3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnLoad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnProcess, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(116, Short.MAX_VALUE))
        );

        menuArquivo.setText("Arquivo");

        itemNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/eye/icons/Actions-list-add-user-icon.png"))); // NOI18N
        itemNovo.setText("Novo Cadastro");
        itemNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemNovoActionPerformed(evt);
            }
        });
        menuArquivo.add(itemNovo);

        itemProcurar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/eye/icons/Actions-document-preview-icon.png"))); // NOI18N
        itemProcurar.setText("Pesquisar");
        itemProcurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemProcurarActionPerformed(evt);
            }
        });
        menuArquivo.add(itemProcurar);

        mainMenu.add(menuArquivo);

        menuHelp.setText("Sobre");

        itemInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/eye/icons/Status-dialog-information-icon.png"))); // NOI18N
        itemInfo.setText("Info");
        itemInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemInfoActionPerformed(evt);
            }
        });
        menuHelp.add(itemInfo);

        mainMenu.add(menuHelp);

        setJMenuBar(mainMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void btnLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadActionPerformed
    ImagePlus image = ij.IJ.openImage();

    imgEyeOld = image.getProcessor();
    
    engine.exibeImagem(imgEyeOld, lblEyeEnt);
    btnProcess.setEnabled(true);
}//GEN-LAST:event_btnLoadActionPerformed

private void btnProcessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcessActionPerformed

    txtIdent.setText("");
    txtNome.setText("");

    imgEyeNew = engine.processaImagem(imgEyeOld, imgEyeNew, lblEyeFinal);

    String prog = System.getProperty("user.dir").replace('\\', '/');
    File[] conteudo = new File(prog + "/proc").listFiles();
       
    for(int cont = 0 ; cont < conteudo.length ; cont++)
    {
        ImageProcessor imageCheck;
        ImagePlus imgCheck = ij.IJ.openImage(conteudo[cont].toString());
        imageCheck = imgCheck.getProcessor();

        ImagePlus iplus = new ImagePlus(null, imgEyeNew);
        ImagePlus iplusTB = new ImagePlus(null, iplus.getProcessor().resize(136, 139));

        imgEyeNew = iplusTB.getProcessor();

        //VERIFICA SE O TAMANHO DA IMAGEM É IGUAL O DA AMOSTRA
        if(imageCheck.getWidth() == 136 && imageCheck.getHeight() == 139 && imgEyeNew.getHeight() == 139 && imgEyeNew.getWidth() == 136)
        {
            boolean truePixel = true;

            for(int contX = 0 ; contX < 136 ; contX++)
            {
                for(int contY = 0 ; contY < 139 ; contY++)
                {
                    int pixelOld = imgEyeNew.getPixel(contX, contY);
                    int pixelNew = imageCheck.getPixel(contX, contY);

                    if (pixelNew != pixelOld)
                    {
                        truePixel = false;
                        break;
                    }
                }

                if(truePixel == false)
                {
                    break;
                }

            }

            if(truePixel)
            {
                //SE A EXECUÇÃO CHEGAR A ESTE PONTO, NOSSA IMAGEM FOI ENCONTRADA NO BANCO DE DADOS

                //FAZ BUSCA NA BASE DE DADOS E PREENCHE AS INFORMAÇÕES DA PESSOA
                try
                {
                    String query = "SELECT * FROM pessoa WHERE pes_img = '" + conteudo[cont].getName() + "'";
                    java.sql.Statement st = Connect.getConn().createStatement();
                    java.sql.ResultSet rs = st.executeQuery(query); //EXECUTA A QUERY
                    rs.first();

                    if(rs.getMetaData().getColumnCount() > 0)
                    {     
                        txtNome.setText(rs.getString(2));
                        txtIdent.setText(rs.getString(3));
                        txtCargo.setText(rs.getString(5));
                        break;
                    }

                }
                catch (SQLException ex)
                {
                    JOptionPane.showMessageDialog(null, "Falha ao realizar consulta no banco de dados. \n\n Mensagem: " + ex.getMessage());
                }
            }
        }

      
    }
}//GEN-LAST:event_btnProcessActionPerformed

private void itemNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemNovoActionPerformed
    Cadastro cads = new Cadastro();
}//GEN-LAST:event_itemNovoActionPerformed

private void itemProcurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemProcurarActionPerformed
    Pesquisar pesq = new Pesquisar();
}//GEN-LAST:event_itemProcurarActionPerformed

private void itemInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemInfoActionPerformed
    About about = new About();
}//GEN-LAST:event_itemInfoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLoad;
    private javax.swing.JButton btnProcess;
    private javax.swing.JMenuItem itemInfo;
    private javax.swing.JMenuItem itemNovo;
    private javax.swing.JMenuItem itemProcurar;
    private javax.swing.JLabel lblCargo;
    private javax.swing.JLabel lblEyeEnt;
    private javax.swing.JLabel lblEyeFinal;
    private javax.swing.JLabel lblIdent;
    private javax.swing.JLabel lblNome;
    private javax.swing.JMenuBar mainMenu;
    private javax.swing.JMenu menuArquivo;
    private javax.swing.JMenu menuHelp;
    private javax.swing.JPanel p2;
    private javax.swing.JPanel p3;
    private javax.swing.JPanel panelCompare;
    private javax.swing.JPanel panelData;
    private javax.swing.JPanel panelProcess;
    private javax.swing.JPanel panelResult;
    private javax.swing.JTextField txtCargo;
    private javax.swing.JTextField txtIdent;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
