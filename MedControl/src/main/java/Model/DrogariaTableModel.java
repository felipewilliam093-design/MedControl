/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import DAO.DrogariaDAO;
import Objetos.Drogaria;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author leonardo.hpavan
 */
public class DrogariaTableModel extends AbstractTableModel{
    private List<Drogaria> dados = new ArrayList<>();
    private String[] colunas = {"CNPJ", "IE", "Nome", "CEP", "Estado", "Cidade", "Bairro", "Rua", "Numero"};
    
    @Override
    public String getColumnName(int column){
        return colunas[column];
    }
    
    @Override
    public int getRowCount() {
        return dados.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        switch (coluna) {
            case 0:
                return dados.get(linha).getCnpj();
            case 1:
                return dados.get(linha).getIE();
            case 2:
                return dados.get(linha).getNome();
            case 3:
                return dados.get(linha).getCep();
            case 4:
                return dados.get(linha).getEstado();
            case 5:
                return dados.get(linha).getCidade();
            case 6:
                return dados.get(linha).getBairro();
            case 7:
                return dados.get(linha).getRua();
            case 8:
                return dados.get(linha).getNumero();
        }
        return null;
    }
    
    @Override
    public void setValueAt(Object valor, int linha, int coluna){
        switch(coluna){
            case 0:
                dados.get(linha).setCnpj((String) valor);
                break;
            case 1:
                dados.get(linha).setIE((String) valor);
                break;
            case 2:
                dados.get(linha).setNome((String) valor);
                break;
            case 3:
                dados.get(linha).setCep((String) valor);
                break;
            case 4:
                dados.get(linha).setEstado((String) valor);
            case 5:
                dados.get(linha).setCidade((String) valor);
            case 6:
                dados.get(linha).setBairro ((String) valor);
            case 7:
                dados.get(linha).setRua((String) valor);
        }
        this.fireTableRowsUpdated(linha, linha);
    }
    
    public void addLinha(Drogaria c){
        this.dados.add(c);
        this.fireTableDataChanged();
    }
    
    public void removeLinha(int linha){
        this.dados.remove(linha);
        this.fireTableRowsDeleted(linha, linha);
    }
    
    public Drogaria pegaDadosLinha(int linha){
        return dados.get(linha);
    }
    
    public void lerDados(){
        DrogariaDAO ddao = new DrogariaDAO();
        
        for (Drogaria c : ddao.read()) {
            this.addLinha(c);
        }
        this.fireTableDataChanged();
    }
    
    public void recarregaTabela(){
        this.dados.clear();
        lerDados();
        this.fireTableDataChanged();
    }

   
}
