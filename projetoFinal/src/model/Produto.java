
package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Produto implements Serializable{
    private String nomeProduto;
    private int idProduto;
    private String marca;
    private String modelo; 
    private double preco; 
    private String descricao; 
    private Compra compra; 
    private Categoria categoria;

    public String getNomeProduto() {
        return nomeProduto;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public double getPreco() {
        return preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public Compra getCompra() {
        return compra;
    }

    public Produto(String nomeProduto, int idProduto, String marca, String modelo, double preco, String descricao,String categoria) {
        this.nomeProduto = nomeProduto;
        this.idProduto = idProduto;
        this.marca = marca;
        this.modelo = modelo;
        this.preco = preco;
        this.descricao = descricao;
        this.categoria = new Categoria();
    }
    
    public Produto(){
        
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
    
    public List<Produto> listar(String file){
        try {
            FileInputStream fis = new FileInputStream(file);
            List<Produto> listaDeProdutos = new ArrayList();
            while (fis.available()>0) {
                ObjectInputStream ois = new ObjectInputStream(fis);
                Produto a = (Produto) ois.readObject();
                listaDeProdutos.add(a);
            }
            return listaDeProdutos;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    Produto getNome() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
            
    
    
    
}
