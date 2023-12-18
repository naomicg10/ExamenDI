package com.example.examendi;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Parking {
    private String matricula;
    private String modelo;
    private Cliente cliente;
    private String tarifa;
    private Date entrada;
    private Date salida;
    private Integer coste;
    private List<String> tarifas = new ArrayList<>();

    public Parking(String matricula, String modelo, Cliente cliente, String tarifa, Date entrada, Date salida, Integer coste) {
        this.matricula = matricula;
        this.modelo = modelo;
        this.cliente = cliente;
        this.tarifa = tarifa;
        this.entrada = entrada;
        this.salida = salida;
        this.coste = coste;
    }

    public Parking() {
    }
    public void agregarTarifa(String tarifa) {
        tarifas.add(tarifa);
    }

    public List<String> getTarifas() {
        return tarifas;
    }
    public String getMatricula() {
        return this.matricula;
    }

    public String getModelo() {
        return this.modelo;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public String getTarifa() {
        return this.tarifa;
    }

    public Date getEntrada() {
        return this.entrada;
    }

    public Date getSalida() {
        return this.salida;
    }

    public Integer getCoste() {
        return this.coste;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setTarifa(String tarifa) {
        this.tarifa = tarifa;
    }

    public void setEntrada(Date entrada) {
        this.entrada = entrada;
    }

    public void setSalida(Date salida) {
        this.salida = salida;
    }

    public void setCoste(Integer coste) {
        this.coste = coste;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Parking)) return false;
        final Parking other = (Parking) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$matricula = this.getMatricula();
        final Object other$matricula = other.getMatricula();
        if (this$matricula == null ? other$matricula != null : !this$matricula.equals(other$matricula)) return false;
        final Object this$modelo = this.getModelo();
        final Object other$modelo = other.getModelo();
        if (this$modelo == null ? other$modelo != null : !this$modelo.equals(other$modelo)) return false;
        final Object this$cliente = this.getCliente();
        final Object other$cliente = other.getCliente();
        if (this$cliente == null ? other$cliente != null : !this$cliente.equals(other$cliente)) return false;
        final Object this$tarifa = this.getTarifa();
        final Object other$tarifa = other.getTarifa();
        if (this$tarifa == null ? other$tarifa != null : !this$tarifa.equals(other$tarifa)) return false;
        final Object this$entrada = this.getEntrada();
        final Object other$entrada = other.getEntrada();
        if (this$entrada == null ? other$entrada != null : !this$entrada.equals(other$entrada)) return false;
        final Object this$salida = this.getSalida();
        final Object other$salida = other.getSalida();
        if (this$salida == null ? other$salida != null : !this$salida.equals(other$salida)) return false;
        final Object this$coste = this.getCoste();
        final Object other$coste = other.getCoste();
        if (this$coste == null ? other$coste != null : !this$coste.equals(other$coste)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Parking;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $matricula = this.getMatricula();
        result = result * PRIME + ($matricula == null ? 43 : $matricula.hashCode());
        final Object $modelo = this.getModelo();
        result = result * PRIME + ($modelo == null ? 43 : $modelo.hashCode());
        final Object $cliente = this.getCliente();
        result = result * PRIME + ($cliente == null ? 43 : $cliente.hashCode());
        final Object $tarifa = this.getTarifa();
        result = result * PRIME + ($tarifa == null ? 43 : $tarifa.hashCode());
        final Object $entrada = this.getEntrada();
        result = result * PRIME + ($entrada == null ? 43 : $entrada.hashCode());
        final Object $salida = this.getSalida();
        result = result * PRIME + ($salida == null ? 43 : $salida.hashCode());
        final Object $coste = this.getCoste();
        result = result * PRIME + ($coste == null ? 43 : $coste.hashCode());
        return result;
    }

    public String toString() {
        return "Parking(matricula=" + this.getMatricula() + ", modelo=" + this.getModelo() + ", cliente=" + this.getCliente() + ", tarifa=" + this.getTarifa() + ", entrada=" + this.getEntrada() + ", salida=" + this.getSalida() + ", coste=" + this.getCoste() + ")";
    }
}
