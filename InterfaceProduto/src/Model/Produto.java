/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author marcelo
 */
public class Produto implements Serializable{
    private int codigo;
    private String nome;
    private double valor;

    public Produto(int codigo, String nome, double valor) {
        this.codigo = codigo;
        this.nome = nome;
        this.valor = valor;
    }
    
    public Produto() {
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public double getValor() {
        return valor;
    }
    
   public boolean save(String file){
       try {
           FileOutputStream fos = new FileOutputStream(file,true);
           ObjectOutputStream oos = new ObjectOutputStream(fos);
           oos.writeObject(this);
           fos.close();
           oos.close();
           JOptionPane.showMessageDialog(null, "Salvo com sucesso");
           return true;
       } catch (Exception e) {
           System.out.println(e.getMessage());
           return false;
       }
   }
   
     public List<Produto> show(String file){
      try {
          FileInputStream fis = new FileInputStream(file);
          List<Produto> listarAlunos = new ArrayList();
          while (fis.available() > 0) {
              ObjectInputStream lendoConteudo = new ObjectInputStream(fis);
              Produto aluno1 = (Produto) lendoConteudo.readObject();
              listarAlunos.add(aluno1);
          }
          return listarAlunos;
      } catch (Exception e) {
          System.out.println(e.getMessage());
          return null;
      }
     }
       
 
    
    
}
