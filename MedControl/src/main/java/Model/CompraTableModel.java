/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import DAO.CompraDAO;
import Objetos.CadastroCompras;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author leonardo.hpavan
 */
public class CompraTableModel extends AbstractTableModel{
    private List<CadastroCompras> dados = new ArrayList<>();
    private String[] colunas = {"Num_NF_Entrada_Venda", "CNPJ_Lab", "Data_Entrada", "Valor_Total", "Custo_Total", "Total_Nota", "Forma_Pagamento", "Data_Ult_Compra"};
    
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
                return dados.get(linha).getNum_nf_entrada();
            case 1:
                return dados.get(linha).getCnpj_lab();
            case 2:
                return dados.get(linha).getData_entrada();
            case 3:
                return dados.get(linha).getValor_total();
            case 4:
                return dados.get(linha).getCusto_total();
            case 5:
                return dados.get(linha).getTotal_nota();
            case 6:
                return dados.get(linha).getForma_pagamento();
            case 7:
                return dados.get(linha).getData_ult_compra();
        }
        return null;
    }
    
    @Override
    public void setValueAt(Object valor, int linha, int coluna){
        switch(coluna){
            case 0:
                dados.get(linha).setNum_nf_entrada(Integer.parseInt((String) valor));
                break;
            case 1:
                dados.get(linha).setCnpj_lab((String) valor);
                break;
            case 2:
                dados.get(linha).setData_entrada(Date((String) valor));
                break;
            case 3:
                dados.get(linha).setValor_total((Double.valueOf((String) valor)));
                break;
            case 4:
                dados.get(linha).setCusto_total((Double.valueOf((String) valor)));
            case 5:
                dados.get(linha).setTotal_nota((Double.valueOf((String) valor)));
            case 6:
                dados.get(linha).setForma_pagamento((String) valor);
            case 7:
                dados.get(linha).setData_ult_compra(Date((String) valor));
        }
        this.fireTableRowsUpdated(linha, linha);
    }
    
    public void addLinha(CadastroCompras cc){
        this.dados.add(cc);
        this.fireTableDataChanged();
    }
    
    public void removeLinha(int linha){
        this.dados.remove(linha);
        this.fireTableRowsDeleted(linha, linha);
    }
    
    public CadastroCompras pegaDadosLinha(int linha){
        return dados.get(linha);
    }
    
    private void lerDados(){
        CompraDAO cdao = new CompraDAO();
        
        for (CadastroCompras cc : cdao.read()) {
            this.addLinha(cc);
        }
        this.fireTableDataChanged();
    }
    
    public void recarregaTabela(){
        this.dados.clear();
        lerDados();
        this.fireTableDataChanged();
    }

    private Date Date(String string) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
