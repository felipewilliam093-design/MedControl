/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos;

/**
 *
 * @author leonardo.hpavan
 */
public class CadastroItemCompra {
    
    private int codigo;
    private int num_nf_entrada_compra;
    private Double custo_unit;
    private Double valor_unit;
    private String descricao;

    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the num_nf_entrada_compra
     */
    public int getNum_nf_entrada_compra() {
        return num_nf_entrada_compra;
    }

    /**
     * @param num_nf_entrada_compra the num_nf_entrada_compra to set
     */
    public void setNum_nf_entrada_compra(int num_nf_entrada_compra) {
        this.num_nf_entrada_compra = num_nf_entrada_compra;
    }

    /**
     * @return the custo_unit
     */
    public Double getCusto_unit() {
        return custo_unit;
    }

    /**
     * @param custo_unit the custo_unit to set
     */
    public void setCusto_unit(Double custo_unit) {
        this.custo_unit = custo_unit;
    }

    /**
     * @return the valor_unit
     */
    public Double getValor_unit() {
        return valor_unit;
    }

    /**
     * @param valor_unit the valor_unit to set
     */
    public void setValor_unit(Double valor_unit) {
        this.valor_unit = valor_unit;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
}
