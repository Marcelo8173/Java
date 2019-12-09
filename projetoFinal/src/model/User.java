
package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class User implements Serializable{
    private String nome;
    private String cpf;
    private String senha;
    private String endereco;
    private String login;
    private String usuario; 

    public String getUsuario() {
        return usuario;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getSenha() {
        return senha;
    }


    public String getEndereco() {
        return endereco;
    }

    public String getLogin() {
        return login;
    }

    public User(String nome, String cpf, String senha, String endereco, String login, String usuario) {
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
        this.endereco = endereco;
        this.login = login;
        this.usuario = usuario;
    }
    
    public User(){
        
    }
    
    public boolean cadastrar(String file){
        try {
            FileOutputStream fos = new FileOutputStream(file,true);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(this);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public List<User> listarUser(String file){
        try {
            FileInputStream fis = new FileInputStream(file);
            List<User> usuarios = new ArrayList();
            while (fis.available() > 0) {
                ObjectInputStream lendoConteudo = new ObjectInputStream(fis);
                User a = (User) lendoConteudo.readObject();
                usuarios.add(a);
            }
            return usuarios;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
       
    
}
