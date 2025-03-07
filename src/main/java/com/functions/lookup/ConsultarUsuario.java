package main.java.com.functions.lookup;

import java.sql.*;
import main.java.com.functions.Funcao;
import java.util.Scanner;
import java.util.Scanner;

public class ConsultarUsuario implements Funcao {
    Scanner scn = new Scanner(System.in);

    @Override
    public void atualizar(Connection conn) {    }

    @Override
    public void consultar(Connection conn) throws SQLException{

        System.out.println("Informe o nome que voce quer consultar");
        String name = scn.nextLine();

        System.out.println("Informe o CPF que voce quer consultar");
        Long cpf = scn.nextLong();


        PreparedStatement statement = conn.prepareStatement("SELECT * FROM clientes WHERE nome = ? AND cpf = ?");
        statement.setString(1, name);
        statement.setLong(2, cpf);

        ResultSet rs = statement.executeQuery();

        while (rs.next()){
            System.out.println("ID: " + rs.getInt("id"));
            System.out.println("Nome: " + rs.getString("nome"));
            System.out.println("CPF: " + rs.getLong("cpf"));
        }

    }

    @Override
    public void deletar(Connection conn) throws SQLException {

    }

    @Override
    public void criar(Connection conn) throws SQLException {

    }
}