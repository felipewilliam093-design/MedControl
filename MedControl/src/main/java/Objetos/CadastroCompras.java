/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos;

import java.util.Date;

/**
 *
 * @author leonardo.hpavan
 */
public class CadastroCompras {

    private int num_nf_entrada;
    private String cnpj_lab;
    private Date data_entrada;
    private Double valor_total;
    private Double custo_total;
    private Double total_nota;
    private String forma_pagamento; 
    private Date data_ult_compra;
    
    /**
     * @return the num_nf_entrada
     */
    public int getNum_nf_entrada() {
        return num_nf_entrada;
    }

    /**
     * @param num_nf_entrada the num_nf_entrada to set
     */
    public void setNum_nf_entrada(int num_nf_entrada) {
        this.num_nf_entrada = num_nf_entrada;
    }

    /**
     * @return the cnpj_lab
     */
    public String getCnpj_lab() {
        return cnpj_lab;
    }

    /**
     * @param cnpj_lab the cnpj_lab to set
     */
    public void setCnpj_lab(String cnpj_lab) {
        this.cnpj_lab = cnpj_lab;
    }

    /**
     * @return the data_entrada
     */
    public Date getData_entrada() {
        return data_entrada;
    }

    /**
     * @param data_entrada the data_entrada to set
     */
    public void setData_entrada(Date data_entrada) {
        this.data_entrada = data_entrada;
    }

    /**
     * @return the valor_total
     */
    public Double getValor_total() {
        return valor_total;
    }

    /**
     * @param valor_total the valor_total to set
     */
    public void setValor_total(Double valor_total) {
        this.valor_total = valor_total;
    }

    /**
     * @return the custo_total
     */
    public Double getCusto_total() {
        return custo_total;
    }

    /**
     * @param custo_total the custo_total to set
     */
    public void setCusto_total(Double custo_total) {
        this.custo_total = custo_total;
    }

    /**
     * @return the total_nota
     */
    public Double getTotal_nota() {
        return total_nota;
    }

    /**
     * @param total_nota the total_nota to set
     */
    public void setTotal_nota(Double total_nota) {
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
