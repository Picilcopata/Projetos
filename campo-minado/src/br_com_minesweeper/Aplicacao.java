package br_com_minesweeper;

import br_com_minesweeper.modelo.Tabuleiro;
import br_com_minesweeper.visao.TabuleiroConsole;

public class Aplicacao {
    public static void main(String[] args) {
        
        Tabuleiro tabuleiro = new Tabuleiro(6, 6, 6);
        new TabuleiroConsole(tabuleiro);
    }
}