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
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 *
 * @author marcelo
 */
public class Mensagem implements Serializable {
    private int idMensagem;
    private String conteudo;
    private String data;
    private User user;

    public Mensagem(String conteudo,String data) {
        Random r = new Random();
        int id = r.nextInt(100000);
        this.idMensagem = id;
        this.conteudo = conteudo;
        this.data = data;
    }
    
    public  Mensagem (){}

    public int getIdMensagem() {
        return idMensagem;
    }
    
    public String getData(){
        return data;
    }
    
    public String getConteudo() {
        return conteudo;
    }
    
    public boolean cadastrarMensagem(String file){
        try {
            Date a = new Date();
            FileOutputStream fos = new FileOutputStream(file,true);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(this);
           // this.data = java.sql.Date.valueOf(LocalDate.now());
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public List<Mensagem> listarMensagem(String file){
        try {
            FileInputStream fis = new FileInputStream(file);
            List<Mensagem> listaDeMsg = new ArrayList();
            while (fis.available()>0) {
                ObjectInputStream ois = new ObjectInputStream(fis);
                Mensagem a = (Mensagem) ois.readObject();
                listaDeMsg.add(a);
            }
            return listaDeMsg;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
   
    
}
