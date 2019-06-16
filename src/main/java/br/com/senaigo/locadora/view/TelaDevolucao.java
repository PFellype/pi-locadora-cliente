/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senaigo.locadora.view;

import br.com.senaigo.locadora.controller.ClienteTcpController;
import br.com.senaigo.locadora.controller.DevolucaoController;
import br.com.senaigo.locadora.excecoes.ValidacaoException;
import br.com.senaigo.locadora.interfaces.FormularioPadrao;
import br.com.senaigo.locadora.model.Estado;
import br.com.senaigo.locadora.model.Locacao;
import br.com.senaigo.locadora.model.Marca;
import br.com.senaigo.locadora.model.SituacaoLocacao;
import br.com.senaigo.locadora.persistencia.Operacao;
import br.com.senaigo.locadora.utils.DataUtils;
import br.com.senaigo.locadora.utils.Utils;
import br.com.senaigo.locadora.utils.formularioUtils.CampoData;
import br.com.senaigo.locadora.utils.formularioUtils.CampoDeTexto;
import br.com.senaigo.locadora.utils.formularioUtils.CampoId;
import br.com.senaigo.locadora.utils.formularioUtils.ValidacaoTexto;
import br.com.senaigo.locadora.view.formulario.ControleFormularioPadrao;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author pfellype
 */
public class TelaDevolucao extends javax.swing.JInternalFrame implements FormularioPadrao {

    ControleFormularioPadrao formulario;
    List<Locacao> fonteDeDadosLocacao;
    ClienteTcpController controller;
    
    public TelaDevolucao() throws IOException {
        controller = new ClienteTcpController();
        initComponents();
        preenchaGrid();
        formulario = new ControleFormularioPadrao(this);
        formulario.configureFormularioParaNavegacao();
    }
    
    private void preenchaGrid() {
		try {
			atualizeFonteDeDadosLocacao();
			DefaultTableModel tabela = (DefaultTableModel) jTableLista.getModel();
			
			tabela.setRowCount(0);
			for (Locacao locacao : fonteDeDadosLocacao) {
                            String nomeClientePf = locacao.getCliente().getNome();
                            String nomeClientePj = locacao.getCliente().getRazaoSocial();
                            String nome = nomeClientePf.isEmpty() ? nomeClientePj : nomeClientePf;
				Object[] campos = {
						locacao.getId(),
                                                nome,
                                                locacao.getSituacao().getDescricao(),
                                                DataUtils.convertaLocalDateParaStringFormatada(locacao.getDataPrevistaParaDevolucao()),
                                                DataUtils.convertaLocalDateParaStringFormatada(locacao.getDataDaDevolucao()),
                                                "R$" + Utils.convertaFloatParaStringComDuasCasasDecimais(locacao.getValorFinalLocacao())
				};
				tabela.addRow(campos);
			}
		} catch (Exception erro) {
			Utils.mostreAdvertenciaPreenchimentoGrid(erro);
		}
	}
    
    private void atualizeFonteDeDadosLocacao() {
		try {
			fonteDeDadosLocacao = controller.liste("Locacao");
		} catch (Exception erro) {
			String titulo = "Erro do preencher fonte de dados de locações!";
			Utils.mostreAdvertencia(erro, titulo);
		}

	}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelBase = new javax.swing.JPanel();
        jPanelBotoes = new javax.swing.JPanel();
        jButtonSalvar = new javax.swing.JButton();
        jButtonSelecionar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jPanelDevolucao = new javax.swing.JPanel();
        jLabelDataDeDevolucao = new javax.swing.JLabel();
        jLabelQuilometragem = new javax.swing.JLabel();
        jFormattedTextFieldDataDeDevolucao = new javax.swing.JFormattedTextField();
        jTextFieldQuilometragem = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldId = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableLista = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 244, 0));
        setBorder(null);
        setForeground(new java.awt.Color(0, 0, 0));

        jPanelBase.setBackground(new java.awt.Color(255, 255, 255));
        jPanelBase.setBorder(null);
        jPanelBase.setForeground(new java.awt.Color(0, 0, 0));

        jPanelBotoes.setBackground(new java.awt.Color(255, 255, 255));
        jPanelBotoes.setForeground(new java.awt.Color(0, 0, 0));

        jButtonSalvar.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jButtonSalvar.setForeground(new java.awt.Color(0, 0, 0));
        jButtonSalvar.setText("Finalizar");
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });

        jButtonSelecionar.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jButtonSelecionar.setForeground(new java.awt.Color(0, 0, 0));
        jButtonSelecionar.setText("Selecionar locação");
        jButtonSelecionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSelecionarActionPerformed(evt);
            }
        });

        jButtonCancelar.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jButtonCancelar.setForeground(new java.awt.Color(0, 0, 0));
        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelBotoesLayout = new javax.swing.GroupLayout(jPanelBotoes);
        jPanelBotoes.setLayout(jPanelBotoesLayout);
        jPanelBotoesLayout.setHorizontalGroup(
            jPanelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBotoesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonSelecionar)
                .addGap(324, 324, 324)
                .addComponent(jButtonSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 495, Short.MAX_VALUE)
                .addComponent(jButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        jPanelBotoesLayout.setVerticalGroup(
            jPanelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBotoesLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSalvar)
                    .addComponent(jButtonSelecionar)
                    .addComponent(jButtonCancelar))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanelDevolucao.setBackground(new java.awt.Color(255, 255, 255));
        jPanelDevolucao.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Devolução", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 18), new java.awt.Color(0, 0, 0))); // NOI18N
        jPanelDevolucao.setForeground(new java.awt.Color(0, 0, 0));

        jLabelDataDeDevolucao.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabelDataDeDevolucao.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDataDeDevolucao.setText("Data da Devolução:");

        jLabelQuilometragem.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabelQuilometragem.setForeground(new java.awt.Color(0, 0, 0));
        jLabelQuilometragem.setText("Quilometragem na entrega:");

        jFormattedTextFieldDataDeDevolucao.setEditable(false);
        jFormattedTextFieldDataDeDevolucao.setBackground(new java.awt.Color(255, 255, 255));
        jFormattedTextFieldDataDeDevolucao.setForeground(new java.awt.Color(0, 0, 0));
        try {
            jFormattedTextFieldDataDeDevolucao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextFieldDataDeDevolucao.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        jTextFieldQuilometragem.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldQuilometragem.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("ID:");

        jTextFieldId.setEditable(false);
        jTextFieldId.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldId.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jTextFieldId.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanelDevolucaoLayout = new javax.swing.GroupLayout(jPanelDevolucao);
        jPanelDevolucao.setLayout(jPanelDevolucaoLayout);
        jPanelDevolucaoLayout.setHorizontalGroup(
            jPanelDevolucaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDevolucaoLayout.createSequentialGroup()
                .addGap(157, 157, 157)
                .addGroup(jPanelDevolucaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDevolucaoLayout.createSequentialGroup()
                        .addGroup(jPanelDevolucaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jTextFieldId, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanelDevolucaoLayout.createSequentialGroup()
                        .addGroup(jPanelDevolucaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelDataDeDevolucao)
                            .addComponent(jFormattedTextFieldDataDeDevolucao, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 462, Short.MAX_VALUE)
                        .addGroup(jPanelDevolucaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelQuilometragem)
                            .addComponent(jTextFieldQuilometragem, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(213, 213, 213))))
        );
        jPanelDevolucaoLayout.setVerticalGroup(
            jPanelDevolucaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDevolucaoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextFieldId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanelDevolucaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDataDeDevolucao)
                    .addComponent(jLabelQuilometragem))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDevolucaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jFormattedTextFieldDataDeDevolucao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldQuilometragem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(118, Short.MAX_VALUE))
        );

        jTableLista.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Cliente", "Status", "Dt. Prevista", "Dt. Entregue", "Total Pago"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableLista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableListaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableLista);
        if (jTableLista.getColumnModel().getColumnCount() > 0) {
            jTableLista.getColumnModel().getColumn(0).setResizable(false);
            jTableLista.getColumnModel().getColumn(1).setResizable(false);
            jTableLista.getColumnModel().getColumn(2).setResizable(false);
            jTableLista.getColumnModel().getColumn(3).setResizable(false);
            jTableLista.getColumnModel().getColumn(4).setResizable(false);
            jTableLista.getColumnModel().getColumn(5).setResizable(false);
        }

        javax.swing.GroupLayout jPanelBaseLayout = new javax.swing.GroupLayout(jPanelBase);
        jPanelBase.setLayout(jPanelBaseLayout);
        jPanelBaseLayout.setHorizontalGroup(
            jPanelBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBaseLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelDevolucao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelBotoes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelBaseLayout.setVerticalGroup(
            jPanelBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBaseLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanelDevolucao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelBase, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanelBase, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTableListaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableListaMouseClicked
        formulario.configureConformeInteracaoComGrid();
    }//GEN-LAST:event_jTableListaMouseClicked

    private void jButtonSelecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSelecionarActionPerformed
        boolean podeModificarComponentes = formulario.confirmeApagarFormulario();

        if (podeModificarComponentes) {
            int index = jTableLista.getSelectedRow();
            Locacao locacao = fonteDeDadosLocacao.get(index);
            String id = String.valueOf(locacao.getId());
            formulario.configureFormularioParaEntradaDeDados();
            jTextFieldId.setText(id);            
            
        }
    }//GEN-LAST:event_jButtonSelecionarActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        boolean podeModificarComponentes = formulario.confirmeApagarFormulario();
		if (podeModificarComponentes) {
			formulario.configureFormularioParaNavegacao();
                }
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        try {
            CampoId campoId = new CampoId(jLabel3, jTextFieldId);
            CampoData campoDataDev = new CampoData(jLabelDataDeDevolucao, jFormattedTextFieldDataDeDevolucao, true);
            CampoDeTexto campoKm = new CampoDeTexto(jLabelQuilometragem, jTextFieldQuilometragem, true, ValidacaoTexto.CARRO_KM);
            
            Locacao locacao = obtenhaLocacaoPorId(campoId.getDadosDoCampo());
            int km = Utils.convertaStringParaInt(campoKm.getDadosDoCampo());

            if(locacao.getSituacao() != SituacaoLocacao.ABERTO) {
                throw new ValidacaoException("A locação deve estar aberta!");
            }

            if (km < locacao.getKmVeiculoLocacao()) {
                throw new ValidacaoException("O KM do veículo não pode ser menor que a KM no momento da locação.");
            }

            LocalDate dataDevo = DataUtils.convertaStringParaLocalDate(campoDataDev.getDadosDoCampo());
            locacao.setDataDaDevolucao(dataDevo);

            locacao.setKmVeiculoDevolucao(km);

            DevolucaoController controllerDevolucao = new DevolucaoController(locacao);
            
            String msg = controllerDevolucao.getMensagem();
            int escolha = JOptionPane.showConfirmDialog(null, msg, "Efetuar pagamento?", JOptionPane.YES_NO_OPTION);

            if (escolha == JOptionPane.YES_OPTION) {
                float valorFinal = controllerDevolucao.obtenhaValorASerPago();
                locacao.setValorFinalLocacao(valorFinal);
                locacao.setSituacao(SituacaoLocacao.FECHADA);
                locacao.getVeiculo().setEstado(Estado.LIVRE);
                controller.execute(locacao, Operacao.ALTERAR);
            }
            
            
        } catch (ValidacaoException erroDeValidacao) {
			Utils.mostreAdvertenciaValidacao(erroDeValidacao);
		} catch (Exception erro) {
			Utils.mostreAdvertencia(erro, "Erro ao salvar devolução!");
		}
    }//GEN-LAST:event_jButtonSalvarActionPerformed

    
    private Locacao obtenhaLocacaoPorId(int id) {
        for(Locacao locacao : fonteDeDadosLocacao) {
            if (locacao.getId() == id) {
                return locacao;
            }
        }
        return null;
    }
           
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JButton jButtonSelecionar;
    private javax.swing.JFormattedTextField jFormattedTextFieldDataDeDevolucao;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelDataDeDevolucao;
    private javax.swing.JLabel jLabelQuilometragem;
    private javax.swing.JPanel jPanelBase;
    private javax.swing.JPanel jPanelBotoes;
    private javax.swing.JPanel jPanelDevolucao;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableLista;
    private javax.swing.JTextField jTextFieldId;
    private javax.swing.JTextField jTextFieldQuilometragem;
    // End of variables declaration//GEN-END:variables

    @Override
    public JButton obtenhaBotaoSalvar() {
        return jButtonSalvar;
    }

    @Override
    public JButton obtenhaBotaoEditar() {
        return jButtonSelecionar;
    }

    @Override
    public JButton obtenhaBotaoCancelar() {
        return jButtonCancelar;
    }

    @Override
    public JButton obtenhaBotaoNovo() {
        return new JButton();
    }

    @Override
    public JTable obtenhaGrid() {
        return jTableLista;
    }

    @Override
    public JTextField obtenhaCampoId() {
        return jTextFieldId;
    }

    @Override
    public List<JTextField> obtenhaCamposDoFormularioSemCampoId() {
        List<JTextField> campos = new ArrayList<>();
        campos.add(jTextFieldQuilometragem);
        campos.add(jFormattedTextFieldDataDeDevolucao);
        return campos;
    }

    @Override
    public List<JComboBox> obtenhaComboBoxesDoFormulario() {
        return new ArrayList<>();
    }

}
