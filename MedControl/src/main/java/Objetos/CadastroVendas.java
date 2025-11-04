/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos;

import java.sql.Date;

/**
 *
 * @author william.flima4
 */
public class CadastroVendas {
    private int nmr_nf_entrada;
    private String cnpj_drogaria;
    private Date data_entrega;
    private double valor_total;
    private double custo_total;
    private int qtde;
    private double total_nota;
    private String forma_pagamento;
    private Date data_ult_compra;

    /**
     * @return the nmr_nf_entrada
     */
    public int getNmr_nf_entrada() {
        return nmr_nf_entrada;
    }

    /**
     * @param nmr_nf_entrada the nmr_nf_entrada to set
     */
    public void setNmr_nf_entrada(int nmr_nf_entrada) {
        this.nmr_nf_entrada = nmr_nf_entrada;
    }

    /**
     * @return the cnpj_drogaria
     */
    public String getCnpj_drogaria() {
        return cnpj_drogaria;
    }

    /**
     * @param cnpj_drogaria the cnpj_drogaria to set
     */
    public void setCnpj_drogaria(String cnpj_drogaria) {
        this.cnpj_drogaria = cnpj_drogaria;
    }

    /**
     * @return the data_entrega
     */
    public Date getData_entrega() {
        return data_entrega;
    }

    /**
     * @param data_entrega the data_entrega to set
     */
    public void setData_entrega(Date data_entrega) {
        this.data_entrega = data_entrega;
    }

    /**
     * @return the valor_total
     */
    public double getValor_total() {
        return valor_total;
    }

    /**
     * @param valor_total the valor_total to set
     */
    public void setValor_total(double valor_total) {
        this.valor_total = valor_total;
    }

    /**
     * @return the custo_total
     */
    public double getCusto_total() {
        return custo_total;
    }

    /**
     * @param custo_total the custo_total to set
     */
    public void setCusto_total(double custo_total) {
        this.custo_total = custo_total;
    }

    /**
     * @return the qtde
     */
    public int getQtde() {
        return qtde;
    }

    /**
     * @param qtde the qtde to set
     */
    public void setQtde(int qtde) {
        this.qtde = qtde;
    }

    /**
     * @return the total_nota
     */
    public double getTotal_nota() {
        return total_nota;
    }

    /**
     * @param total_nota the total_nota to set
     */
    public void setTotal_nota(double total_nota) {
        this.total_nota = total_nota;
    }

    /**
     * @return the forma_pagamento
     */
    public String getForma_pagamento() {
        return forma_pagamento;
    }

    /**
     * @param forma_pagamento the forma_pagamento to set
     */
    public void setForma_pagamento(String forma_pagamento) {
        this.forma_pagamento = forma_pagamento;
    }

    /**
     * @return the data_ult_compra
     */
    public Date getData_ult_compra() {
        return data_ult_compra;
    }

    /**
     * @param data_ult_compra the data_ult_compra to set
     */
    public void setData_ult_compra(Date data_ult_compra) {
        this.data_ult_compra = data_ult_compra;
    }
    
}
