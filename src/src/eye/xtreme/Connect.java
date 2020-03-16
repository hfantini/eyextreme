package eye.xtreme;

import java.sql.*;
import javax.swing.JOptionPane;

public class Connect
{
    private static Connection conn = null;
    static String source = "H:\\Faculdade\\Processamento de imagem\\Projeto Final\\Banco de Dados\\database.mdb";
    
    public static void dbConnect()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://" + "localhost" + "/" + "eyeXtreme", "root", "123456");
        }
        catch(ClassNotFoundException ex)
        {
            JOptionPane.showMessageDialog(null, "Falha ao carregar o driver do Banco de dados. \n\n Mensagem: " + ex.getMessage());
        }        
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Falha ao se conectar no Banco de Dados. \n\n Mensagem: " + ex.getMessage());
        }

    }
    
    public static void dbClose()
    {
        try
        {
            conn.close();
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Falha ao finalizar a conexão com o Banco de dados. \n\n Mensagem: " + ex.getMessage());
        }
    }
    
    public static Connection getConn()
    {
       try
       {
            if(!conn.isClosed())
            {
                return conn;
            }
            else
            {
                dbConnect();
                return conn;
            }
       }
       catch (SQLException ex)
       {
           JOptionPane.showMessageDialog(null, "Falha ao determinar estado do Banco de Dados. \n\n Mensagem: " + ex.getMessage());
           return null;
       }
    }
}
