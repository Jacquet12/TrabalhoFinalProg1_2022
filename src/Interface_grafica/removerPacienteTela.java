/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interface_grafica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;


import controller.PacienteController;


public class removerPacienteTela extends javax.swing.JFrame {


    public removerPacienteTela() {
        initComponents();
    }
    

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtCpf = new javax.swing.JTextField();
        btRemover= new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        jLabel4.setText("jLabel4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 255));
        jLabel1.setText("Remover Pacientes");

        jButton1.setBackground(new java.awt.Color(51, 51, 255));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("voltar");

        jLabel3.setText("CPF");

        txtCpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                
            }
        });

        btRemover.setBackground(new java.awt.Color(51, 51, 255));
        btRemover.setForeground(new java.awt.Color(255, 255, 255));
        btRemover.setText("Remover");

        btRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onClickRemover();
            }
        });

        jLabel5.setText("Digite o CPF do paciente a ser removido");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 337, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 139, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addGap(190, 190, 190))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(btRemover)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1)))
                .addGap(51, 51, 51)
                .addComponent(jLabel2)
                .addGap(20, 20, 20)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addComponent(btRemover)
                .addContainerGap(189, Short.MAX_VALUE))
        );

        pack();
    }

    
    private void onClickRemover() {
        PacienteController paciente = new PacienteController();
        String cpf = txtCpf.getText();
       
        try {
            Connection conexao = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/clinica",
                        "root", "");
            PreparedStatement st = (PreparedStatement)  conexao
            .prepareStatement("Select cpf from paciente where cpf=? ");
            st.setString(1, cpf);
            ResultSet resultado = st.executeQuery();
            if (resultado.next()){
                paciente.excluir(cpf);
                JOptionPane.showMessageDialog(this, "Paciente excluido com sucesso!");
                clearFields();
                DashboardLoginTela agendaTela = new DashboardLoginTela();
                agendaTela.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Esse paciente nao foi localizado !");
            }       
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, 
				"Nao foi possivel excluir esse paciente Porque ele tem uma consulta ainda que nao foi realizada  !" 
				
			);
        }
    }
    private void clearFields() {
        txtCpf.setText("");
       
    }

  
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(removerPacienteTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(removerPacienteTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(removerPacienteTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(removerPacienteTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
     
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new removerPacienteTela().setVisible(true);
            }
        });
    }

    
    private javax.swing.JButton jButton1;
    private javax.swing.JButton btRemover;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField txtCpf;
  
}