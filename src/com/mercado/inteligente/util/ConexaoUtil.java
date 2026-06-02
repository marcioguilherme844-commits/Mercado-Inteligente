package com.mercado.inteligente.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoUtil {

    private static final String URL = "jdbc:mysql://localhost:3306/mercado_inteligente?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String USER = "root";          // ← ALTERE SE NECESSÁRIO
    private static final String PASSWORD = ""; // ← ALTERE AQUI

    public static Connection getConexao() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
