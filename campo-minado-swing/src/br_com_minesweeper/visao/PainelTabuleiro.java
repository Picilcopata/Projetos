package br_com_minesweeper.visao;

import java.awt.GridLayout;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import br_com_minesweeper.modelo.Tabuleiro;

public class PainelTabuleiro extends JPanel {

    /**
     * @param tabuleiro
     */
    public PainelTabuleiro(Tabuleiro tabuleiro){
        
        setLayout(new GridLayout(tabuleiro.getLinhas(), tabuleiro.getColunas()));

        tabuleiro.paraCadaCampo(c -> add(new BotaoCampo(c)));

        tabuleiro.registrarObservador(e -> {

            SwingUtilities.invokeLater(() -> {
            if(e.isGanhou()) {
                JOptionPane.showMessageDialog(null, "Ganhou!!!");
            } else{
                JOptionPane.showMessageDialog(this, "Perdeu!");
            }
            tabuleiro.reiniciar();
        });
        });
    }  
}
