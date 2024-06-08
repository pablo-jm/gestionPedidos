/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import Models.Pedido;
import Models.PedidoImpl;
import java.util.List;

/**
 *
 * @author pablo
 */
public class EncontrarPedido {
    public static Pedido encontrarUnPedido(List<Pedido> listaPedido, int idPedido){
        Pedido pedidoEncontrado = new PedidoImpl();
        for (Pedido pedido: listaPedido) {
             if(pedido.equals(pedido)){
                pedidoEncontrado = pedido;
             }
        }
        return pedidoEncontrado;
    }
}
