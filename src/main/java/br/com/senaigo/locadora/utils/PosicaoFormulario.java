/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senaigo.locadora.utils;

import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;

/**
 *
 * @author pfellype
 */
public class PosicaoFormulario {
    
    //Abrir formulário centralizado na tela
    
    public void abrirFormulario(JInternalFrame janela, JDesktopPane desktop){
        int lDesk = desktop.getWidth();
        int aDesk = desktop.getHeight();
        int lIFrame = janela.getWidth();
        int aIFrame = janela.getHeight();
        janela.setLocation(lDesk / 2 - lIFrame / 2, aDesk / 2 - aIFrame / 2);
        desktop.add(janela);
        janela.setVisible(true);
    }
}
