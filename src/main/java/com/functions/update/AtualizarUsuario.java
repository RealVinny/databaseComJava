package main.java.com.functions.update;

import main.java.com.functions.Funcao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class AtualizarUsuario implements Funcao {
    Scanner scn = new Scanner(System.in);

    @Override
    public void atualizar(Connection conn) throws SQLException {

        System.out.println("Informe o nome do cliente que voce deseja atualizar");
        String nome = scn.nextLine();

        System.out.println("Informe o CPF:");
        long cpf = scn.nextLong();
        scn.nextLine();


        PreparedStatement prstmt = conn.prepareStatement("SELECT * FROM clientes WHERE nome = ? AND cpf = ?;") ;
        prstmt.setString(1, nome);
        prstmt.setLong(2, cpf);


        ResultSet rs = prstmt.executeQuery();

        while (rs.next()){

            System.out.println("Nome: " + rs.getString("nome"));
            System.out.println("Sobrenome: " + rs.getString("sobrenome"));
            System.out.println("CPF: " + rs.getLong("cpf"));

        }

        System.out.println("Esse é o usuario que voce deseja atualizar ? ");
        String userCerto = scn.nextLine();

        if(userCerto.equalsIgnoreCase("SIM")){

            System.out.println("Qual dado voce deseja atualizar ? ( Nome, Sobrenome, CPF )");
            String dado = scn.nextLine();


            if (dado.equalsIgnoreCase("nome")){


                PreparedStatement stmt = conn.prepareStatement("UPDATE clientes SET nome = ? WHERE nome = ? AND cpf = ?");

                System.out.println("Qual o novo nome do usuario ? ");
                String newName = scn.nextLine();
                stmt.setString(1, newName);


                prstmt.setString(1, newName);
                stmt.setLong(3, cpf);
                stmt.setString(2, nome);

                stmt.executeUpdate();


            } else if (dado.equalsIgnoreCase("sobrenome")){


                PreparedStatement stmt = conn.prepareStatement("UPDATE clientes SET sobrenome = ? WHERE nome = ? AND cpf = ?");
                stmt.setString(2, nome);
                stmt.setLong(3, cpf);
                System.out.println("Qual o novo nome do usuario ? ");
                String newSobrenome = scn.nextLine();

                stmt.setString(1, newSobrenome);

                stmt.executeUpdate();

            } else if (dado.equalsIgnoreCase("cpf")) {

                System.out.println("Qual o novo nome do usuario ? ");
                long newCpf = scn.nextLong();


                PreparedStatement stmt = conn.prepareStatement("UPDATE clientes SET CPF = ? WHERE nome = ? AND cpf = ?");
                stmt.setString(2, nome);
                stmt.setLong(3, cpf);

                stmt.setLong(1, newCpf);

                stmt.executeQuery();

            }


            System.out.println("Dados atualizados : ");

            prstmt.executeQuery();
            rs = prstmt.executeQuery();

            while (rs.next()){

                System.out.println("Nome: " + rs.getString("nome"));
                System.out.println("Sobrenome: " + rs.getString("sobrenome"));
                System.out.println("CPF: " + rs.getLong("cpf"));

            }



        }


    }

    @Override
    public void consultar(Connection conn) throws SQLException {

    }

    @Override
    public void deletar(Connection conn) throws SQLException {

    }

    @Override
    public void criar(Connection conn) throws SQLException {

    }
}
