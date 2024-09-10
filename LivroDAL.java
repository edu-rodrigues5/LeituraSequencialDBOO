package leiturasequencialdboo;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MauricioAsenjo
 */
import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

public class LivroDAL {

    private static ObjectContainer db;
    //static ObjectSet<Livro> lista;
    static int i=0;

public static void conecta()
    {
        db = Db4o.openFile("meubanco.dbo");
    }

    public static void desconecta()
    {
        db.close();
    }

/*public static void inseriLivro(Livro umlivro)
    {
        try {
            db = Db4o.openFile("meubanco.dbo"); //isso é para entrar no banco.
            db.set(umlivro);
        } catch (Exception e) {
            Erro.setErro(e.getMessage());
        }finally
        {
            db.close();
        }
    }inserção de DADOS*/
public static Livro getLivro()
{
    conecta();
    ObjectSet<Livro> lista = db.get(Livro.class);
    Livro livro=null;
     Erro.setErro(false);
     try{
    if(lista.hasNext())
    {
    livro = lista.get(i);
    }
     }catch(Exception e){Erro.setErro(e.getMessage());}
    finally{i++;desconecta();}
     
    return livro;
}
}