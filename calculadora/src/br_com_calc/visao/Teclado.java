package br_com_calc.visao;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import br_com_calc.modelo.Memoria;

public class Teclado extends JPanel implements ActionListener{

    private final Color COR_VERDE_PASTEL = new Color(149, 176, 149);
    private final Color COR_CINZA_CLARO = new Color(196, 205, 196);
    private final Color COR_VERDE_AGUA = new Color(184, 212, 184);

    public Teclado(){

        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();

        setLayout(layout);

        c.weightx = 1;
        c.weighty = 1;
        c.fill = GridBagConstraints.BOTH;

        // Linha 1
        c.gridwidth =3;
        adicionarBotao("AC", COR_VERDE_PASTEL, c, 0, 0);
        c.gridwidth = 1;
        adicionarBotao("/", COR_VERDE_PASTEL, c, 3, 0);
        
        //Linha 6
        adicionarBotao("7", COR_VERDE_AGUA, c, 0, 1);
        adicionarBotao("8", COR_VERDE_AGUA, c, 1, 1);
        adicionarBotao("9", COR_VERDE_AGUA, c, 2, 1);
        adicionarBotao("*", COR_CINZA_CLARO, c, 3, 1);

        //Linha 5
        adicionarBotao("4", COR_VERDE_AGUA, c, 0, 2);
        adicionarBotao("5", COR_VERDE_AGUA, c, 1, 2);
        adicionarBotao("6", COR_VERDE_AGUA, c, 2, 2);
        adicionarBotao("-", COR_CINZA_CLARO, c, 3, 2);

        //Linha 4
        adicionarBotao("1", COR_VERDE_AGUA, c, 0, 3);
        adicionarBotao("2", COR_VERDE_AGUA, c, 1, 3);
        adicionarBotao("3", COR_VERDE_AGUA, c, 2, 3);
        adicionarBotao("+", COR_CINZA_CLARO, c, 3, 3);

        //Linha 5
        c.gridwidth = 2;
        adicionarBotao("0", COR_VERDE_AGUA, c, 0, 4);
        c.gridwidth = 1;
        adicionarBotao(",", COR_VERDE_AGUA, c, 2, 4);
        adicionarBotao("=", COR_CINZA_CLARO, c, 3, 4);
       
        
    }

    private void adicionarBotao(String texto, Color cor, GridBagConstraints c, int x, int y) {

        c.gridx = x;
        c.gridy = y;
        Botao botao = new Botao(texto, cor);
        botao.addActionListener(this);
        add(botao, c);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
            if(e.getSource() instanceof JButton){
            JButton botao = (JButton) e.getSource();
            Memoria.getInstancia().processarComando(botao.getText());
        }
    }
}
