package controller;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;

public class ConectarDao {
    public  Connection mycon = null;
    public String       sql = null;
    public PreparedStatement ps = null;

    public ConectarDao () {
        String strcon = "jdbc:mysql://localhost:3306/ProjCad";//cria a string de conexão ao servidor xaamp 
        
        
        try {

            mycon = DriverManager.getConnection(strcon, "root", "");
            this.criarBanco();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Conexão com Mysql não realizada!\n" + ex);
          //  strcon = "jdbc:mysql://localhost:3306";//cria a string de conexão ao servidor xaamp 
        
        }
    }


public void criarBanco () {
        
        try {
            
             sql = " CREATE TABLE IF NOT EXISTS NIVEIS ("
                + "idNivel int not null AUTO_INCREMENT, "
                + "desNivel varchar(30) not null, "
                + "primary key (idNivel) ) ";
    
            ps = mycon.prepareStatement(sql);
            ps.execute();
            
            sql = " CREATE TABLE IF NOT EXISTS USUARIOS ("
                + "cpf varchar (12) not null, "
                + "nome varchar(50) not null, "
                + "email varchar(50) not null, "
                + "celular varchar(20) not null,"
                + "idNivel int not null, senha varchar(20) not null,  "
                 + "primary key (cpf) )";
            
            ps = mycon.prepareStatement(sql);
            ps.execute();
            
            
      
            
            ps.close();
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Erro ao criar tabelas...!\n" + err.getMessage());
        }
    }

   
}
