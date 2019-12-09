/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author marcelo
 */
public class Categoria implements Serializable{
    private String nome;
    private int idCategoria;
    private User user;

    public String getNome() {
        return nome;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public Categoria(String nome) {
        Random r = new Random();
        this.idCategoria = r.nextInt(100000);
        this.nome = nome;
    }
    
    public Categoria(){}
    
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
    
     public List<Categoria> listar(String file){
        try {
            FileInputStream fis = new FileInputStream(file);
            List<Categoria> listaDeCategoria = new ArrayList();
            while (fis.available()>0) {
                ObjectInputStream ois = new ObjectInputStream(fis);
                Categoria a = (Categoria) ois.readObject();
                listaDeCategoria.add(a);
            }
            return listaDeCategoria;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
