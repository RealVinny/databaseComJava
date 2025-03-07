package main.java.com.functions;
import java.sql.*;
import java.awt.*;
import java.lang.StringBuilder;
import java.util.Scanner;

public interface Funcao {

    abstract void atualizar(Connection conn) throws SQLException;
    abstract void consultar(Connection conn) throws SQLException;
    abstract void deletar(Connection conn) throws SQLException;
    abstract void criar(Connection conn) throws SQLException;

}
