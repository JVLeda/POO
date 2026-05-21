package Atividade_4_Associacao_CarroPessoa;

public class Carro {
    private String modelo;
    private String marca;
    private String placa;
    private boolean disponivel;

    public void setModelo(String modelo){
        this.modelo = modelo;
    }
    public void setMarca(String marca){
        this.marca = marca;
    }
    public void setPlaca(String placa){
        this.placa = placa;
    }
    public void setDisponivel(boolean disponivel){
        this.disponivel = disponivel;
    }
    public String getModelo(){
        return modelo;
    }
    public String getMarca(){
        return marca;
    }
    public String getPlaca(){
        return placa;
    }
    public boolean getDisponivel(){
        return disponivel;
    }
    public void dirigir(){
        System.out.println("Dirigindo um carro da " + getMarca() + " modelo " + getModelo());
    }
    public void acelerar(){

    }
    public void frear(){

    }
    public void manobrar(){

    }
}
