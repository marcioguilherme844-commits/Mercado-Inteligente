package com.mercado.inteligentee;

import com.mercado.inteligente.view.MercadoInteligenteGUI;

public class Main {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> new MercadoInteligenteGUI().setVisible(true));
    }
}

