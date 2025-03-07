package main.java.com;
import main.java.com.functions.delete.DeletarUsuario;
import main.java.com.functions.lookup.*;
import main.java.com.functions.register.CadastrarUsuario;

import java.sql.*;
import java.awt.*;
import java.lang.StringBuilder;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.*;

public class Main{
    public static void main(String[] args) throws SQLException {

        Scanner scn = new Scanner(System.in);
        CadastrarUsuario cadUser = new CadastrarUsuario();
        ConsultarUsuario conUser = new ConsultarUsuario();
        DeletarUsuario delUser = new DeletarUsuario();

        /*

        table reference

        "CREATE TABLE IF NOT EXISTS usuarios(" +
                "id INTEGER PRIMARY KEY," +
                "name TEXT NOT NULL," +
                "username TEXT NOT NULL UNIQUE," +
                "age INTEGET" +
                ");";
*/

        String path = "jdbc:sqlite:dataBase.db";

        try ( Connection connection = DriverManager.getConnection(path)){

            conUser.consultar(connection);
            delUser.deletar(connection);

            connection.close();

        } catch (SQLException e) {
            System.out.println("ERRO AO CONECTAR AO BANCO DE DADOS" );
            e.printStackTrace();
        }

    }
}