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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author marcelo
 */
public class Compra implements Serializable{
    private int idCompra;
    private Date dataCompra;
    private String statusCompra;
    private String produtoCompra;
    private Produto produto;
    private User usuario; 
    private double valorProduto;

    public double getValorProduto() {
        return valorProduto;
    }
    
    public String getProdutoCompra() {
        return produtoCompra;
    }

    public int getIdCompra() {
        return idCompra;
    }

    public Date getDataCompra() {
        return dataCompra;
    }

    public String getStatusCompra() {
        return statusCompra;
    }

    public User getUsuario() {
        return usuario;
    }

    
    public Compra(){
     
    }
    
   public double fazerCompra(String fileEntrada,String fileSaida,int idProduto){
       int id = 1;
       List<Produto> listaProdutos;
       Produto prod = new Produto();
       listaProdutos = prod.listar(fileEntrada);
       for(Produto a : listaProdutos){
           if(a.getIdProduto()==idProduto){
                    this.valorProduto = a.getPreco();
                    this.produtoCompra = a.getNomeProduto();
                    this.statusCompra = "Finalizado";
                    this.dataCompra = java.sql.Date.valueOf(LocalDate.now());
                    this.idCompra = id;
               try {
                    FileOutputStream fos = new FileOutputStream(fileSaida,true);
                    ObjectOutputStream oos = new ObjectOutputStream(fos);
                    oos.writeObject(this);
                   id++;
               } catch (Exception e) {
               }
           }
       }
      
       return this.valorProduto;
  }
   
    public List<Compra> listarCompras(String file){
        try {
           FileInputStream fis = new FileInputStream(file);
            List<Compra> listaDeCompras = new ArrayList();
            while (fis.available()>0) {
                ObjectInputStream ois = new ObjectInputStream(fis);
                Compra a = (Compra) ois.readObject();
                listaDeCompras.add(a);
            }
            return listaDeCompras;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
   
}
