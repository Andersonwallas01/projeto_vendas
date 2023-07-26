package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Ordem {
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    private Date momento;
    private OrdemStatus status;
    private Cliente cliente;
    private static List<OrdemItem> items = new ArrayList<OrdemItem>();

    public Ordem(){
    }

    public Ordem(Date momento, OrdemStatus status, Cliente cliente) {
        this.momento = momento;
        this.status = status;
        this.cliente = cliente;
    }

    public Date getMomento() {
        return momento;
    }

    public void setMomento(Date momento) {
        this.momento = momento;
    }

    public OrdemStatus getStatus() {
        return status;
    }

    public void setStatus(OrdemStatus status) {
        this.status = status;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public static void addItem(OrdemItem item){
        items.add(item);
    }
    public void removeItem(OrdemItem item){
        items.remove(item);
    }
    public double total() {

        double sum = 0.0;
        for (OrdemItem it : items) {
            sum += it.SubTotal();
        }
        return sum;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Ordem momento: ");
        sb.append(sdf.format(momento) + "\n");
        sb.append("Ordem status: ");
        sb.append(status + "\n");
        sb.append("Cliente: ");
        sb.append(cliente + "\n");
        sb.append("Ordem itens:\n");
        for (OrdemItem item : items) {
            sb.append(item + "\n");
        }
        sb.append("Total preço: $");
        sb.append(String.format("%.3f" , + total()));
        return sb.toString();
    }
}
