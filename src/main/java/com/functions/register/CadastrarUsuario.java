
package main.java.com.functions.register;
import java.sql.*;
import main.java.com.functions.Funcao;
import java.util.Scanner;

public class CadastrarUsuario implements Funcao {
    Scanner scn = new Scanner(System.in);

    @Override
    public void atualizar(Connection conn) throws SQLException {    }
    @Override
    public void consultar(Connection conn) throws SQLException {    }
    @Override
    public void deletar(Connection conn) {    }

    @Override
    public void criar(Connection conn) throws SQLException {

        System.out.println("Cadastrando novo usuario...");
        System.out.println("Informe o nome o primeiro nome");
        String firstName = scn.nextLine();

        System.out.println("Informe o ultimo nome");
        String lastName = scn.nextLine();

        System.out.println("Informe seu CPF");
        long cpf = scn.nextLong();

        PreparedStatement sqlSender = conn.prepareStatement(("INSERT INTO clientes(nome, sobrenome, cpf) VALUES(?,?,?)"));
        sqlSender.setString(1, firstName);
        sqlSender.setString(2, lastName);
        sqlSender.setLong(3, cpf);

        sqlSender.executeUpdate();


    }


}
