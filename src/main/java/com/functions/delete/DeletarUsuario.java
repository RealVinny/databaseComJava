package main.java.com.functions.delete;

import main.java.com.functions.Funcao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DeletarUsuario implements Funcao {
        Scanner scn = new Scanner(System.in);

    @Override
    public void atualizar(Connection conn) throws SQLException {

    }

    @Override
    public void consultar(Connection conn) throws SQLException {

    }

    @Override
    public void deletar(Connection conn) throws SQLException {

        System.out.println("Informe o nome do cliente que voce deseja deletar");
        String name = scn.nextLine();

        System.out.println("Informe o CPF do cliente");
        long cpf = scn.nextLong();
        scn.nextLine();



        PreparedStatement checkUser = conn.prepareStatement("SELECT * FROM clientes WHERE nome = ? AND cpf = ?");
        checkUser.setString(1, name);
        checkUser.setLong(2, cpf);

        ResultSet rs = checkUser.executeQuery();



        while (rs.next()){
            System.out.println("Nome: " + rs.getString("nome"));
            System.out.println("Sobrenome: " + rs.getString("sobrenome"));
            System.out.println("CPF: " + rs.getLong("cpf"));
        }

        System.out.println("Voce confirma que esse é o cliente ? ( essa ação não pode ser desfeita)");
        String confirm = scn.nextLine();

        if (confirm.equalsIgnoreCase("SIM")){

            String sqlQr = ("DELETE FROM clientes WHERE nome = ? AND cpf = ?");
            PreparedStatement pstmt =   conn.prepareStatement(sqlQr);
            pstmt.setString(1, name);
            pstmt.setLong(2, cpf);
            pstmt.executeUpdate();

            System.out.println("Cliente deletado com sucesso!");

        }else{
            System.out.println("operacao cancelada");
        }



    }

    @Override
    public void criar(Connection conn) throws SQLException {

    }
}