/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Objetos.Laboratorio;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class ProdutoTableModel extends AbstractTableModel {
    private List<Laboratorio> dados = new ArrayList<>();
    private String[] colunas = {"IE", "Nome", "CEP", "Estado", "Cidade", "Bairro", "Rua", "Numero"};
    
    @Override
    public String getColumnName(int column) {
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
    public Object getValueAt(int rowIndex, int columnIndex) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
