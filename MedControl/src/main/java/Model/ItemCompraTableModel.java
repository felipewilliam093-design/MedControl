/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import DAO.ItemCompraDAO;
import Objetos.CadastroItemCompra;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author leonardo.hpavan
 */
public class ItemCompraTableModel extends AbstractTableModel {
    private List<CadastroItemCompra> dados = new ArrayList<>();
    private String[] colunas = {"Código", "Num_NF_Entrada_Compra", "Custo_Unit", "Valor_Unit", "Descrição"};
    
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
                return dados.get(linha).getCodigo();
            case 1:
                return dados.get(linha).getNum_nf_entrada_compra();
            case 2:
                return dados.get(linha).getCusto_unit();
            case 3:
                return dados.get(linha).getValor_unit();
            case 4:
                return dados.get(linha).getDescricao();
        }
        return null;
    }
    
    @Override
    public void setValueAt(Object valor, int linha, int coluna){
        switch(coluna){
            case 0:
                dados.get(linha).setCodigo (Integer.parseInt((String) valor));
                break;
            case 1:
                dados.get(linha).setNum_nf_entrada_compra(Integer.parseInt((String) valor));
                break;
            case 2:
                dados.get(linha).setCusto_unit(Double.parseDouble((String) valor));
                break;
            case 3:
                dados.get(linha).setValor_unit((Double.parseDouble((String) valor)));
                break;
            case 4:
                dados.get(linha).setDescricao((String) valor);
        }
        this.fireTableRowsUpdated(linha, linha);
    }
    
    public void addLinha(CadastroItemCompra cic){
        this.dados.add(cic);
        this.fireTableDataChanged();
    }
    
    public void removeLinha(int linha){
        this.dados.remove(linha);
        this.fireTableRowsDeleted(linha, linha);
    }
    
    public CadastroItemCompra pegaDadosLinha(int linha){
        return dados.get(linha);
    }
    
    private void lerDados(){
        ItemCompraDAO icdao = new ItemCompraDAO();
        
        for (CadastroItemCompra cic : icdao.read()) {
            this.addLinha(cic);
        }
        this.fireTableDataChanged();
    }
    
    public void recarregaTabela(){
        this.dados.clear();
        lerDados();
        this.fireTableDataChanged();
    }
}
