/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Exceptions.NoRegistradoException;
import Models.Establecimiento;
import Models.EstadoPedido;
import Models.Pedido;
import Models.PedidoImpl;
import Models.Producto;
import Models.ProductoImpl;
import Models.Usuario;
import Models.UsuarioImpl;
import Utils.CheckDireccion;
import Utils.CheckExistenciaUsuario;
import Utils.CheckFormatoUsuarioYPass;
import Utils.EncontrarPedido;
import Utils.EncontrarNombreUsuario;
import Utils.ModificarContrasena;
import Utils.ModificarDireccion;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/**
 *
 * @author pablo
 */
public class MenuPrincipal extends JFrame{
    
    
    private JPanel panelMenu;
    private JPanel panelSignIn;
    private JPanel panelBotones;
    private JPanel panelBotonAtras;
    private JPanel panelLogIn;
    private JPanel panelHome;
    private JPanel panelPerfil;
    private JPanel panelModContrasena;
    private JPanel panelModDireccion;
    private JPanel panelPedidos;
    private JPanel panelTipoEstablecimiento;
    private JPanel panelLista;
    private JPanel panelModPedido;
    private JPanel panelCancelarPedido;
    private JPanel panelVerEstadoPedido;
    private JPanel panelMostrarPrecioPedido;
    private JButton botonLogIn;
    private JButton botonFuncion;
    private JButton botonAtras;
    List<Usuario> listaUsuarios;
    List<Producto> listaProductosComida;
    List<Producto> listaProductosBelleza;
    List<Producto> listaProductosSupermercado;
    List<Pedido> listaPedidos;
    private String usuario;
    
    
    
    public MenuPrincipal(String title, List<Usuario> usuarios, List<Producto> productosComida, List<Producto> productosBelleza, List<Producto> productosSupermercado) {
        super(title);
        this.panelMenu = new JPanel();
        this.panelSignIn = new JPanel();
        this.panelBotones = new JPanel();
        this.panelLogIn = new JPanel();
        this.panelHome = new JPanel();
        this.panelPerfil = new JPanel();
        this.panelModContrasena = new JPanel();
        this.panelModDireccion = new JPanel();
        this.panelPedidos = new JPanel();
        this.panelTipoEstablecimiento = new JPanel();
        this.panelLista = new JPanel();
        this.panelBotonAtras = new JPanel();
        this.panelModPedido = new JPanel();
        this.panelCancelarPedido = new JPanel();
        this.panelVerEstadoPedido = new JPanel();
        this.panelMostrarPrecioPedido = new JPanel();
        this.listaUsuarios = usuarios;
        this.listaProductosComida = productosComida;
        this.listaProductosBelleza = productosBelleza;
        this.listaProductosSupermercado = productosSupermercado;
        this.listaPedidos = listaPedidos;
        this.inicializarVentana();
    }
    
    public void inicializarVentana() {
        this.setVisible(true);
        this.setLayout(new BorderLayout());
        this.setSize(500, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void borrarMenu() {
        this.remove(panelMenu);
        this.remove(panelSignIn);
        this.remove(panelBotones);
        this.remove(panelBotonAtras);
        this.remove(panelModPedido);
        this.remove(panelLogIn);
        this.remove(panelHome);
        this.remove(panelPerfil);
        this.remove(panelModContrasena);
        this.remove(panelModDireccion);
        this.remove(panelPedidos);
        this.remove(panelTipoEstablecimiento);
        this.remove(panelLista);
        this.remove(panelCancelarPedido);
        this.remove(panelVerEstadoPedido);
        this.remove(panelMostrarPrecioPedido);
        this.pack();
    }

     public void inicializarMenu() {
        this.borrarMenu();
        this.panelMenu = new JPanel();
        panelMenu.setPreferredSize(new Dimension(500, 600));
        panelMenu.setLayout(new GridLayout(2, 1));
        this.setTitle("Menú");
        
        JButton logIn = new JButton("LogIn");
        JButton singIn = new JButton("SingIn");
        panelMenu.add(logIn);
        panelMenu.add(singIn);
        singIn.addActionListener(e -> this.inicializarPanelSignIn());
        logIn.addActionListener(e -> this.inicializarPanelLogIn());
        this.add(panelMenu);
        this.pack();
    }

     public void inicializarPanelSignIn() {
        this.borrarMenu();
        panelSignIn = new JPanel();
        panelSignIn.setPreferredSize(new Dimension(500, 600));
        panelSignIn.setLayout(new GridLayout(1, 2));
        this.setTitle("Sign In");
        
        JLabel usuario = new JLabel();
        JTextField usuarioField = new JTextField("Usuario");
        panelSignIn.add(usuario);
        panelSignIn.add(usuarioField);
        
        JLabel direccion = new JLabel();
        JTextField direccionField = new JTextField("Dirección");
        panelSignIn.add(direccion);
        panelSignIn.add(direccionField);
        
        JLabel contrasena = new JLabel();
        JTextField contrasenaField = new JTextField("Contraseña");
        panelSignIn.add(contrasena);
        panelSignIn.add(contrasenaField);
        
        this.add(panelSignIn, BorderLayout.PAGE_START);
        this.inicializarMenuBotones();
        botonAtras.addActionListener(e -> this.inicializarMenu());
        botonFuncion.addActionListener(e -> {
            this.registrarUsuario(usuarioField, direccionField, contrasenaField);
            this.mostrarPopUp("Usuario registrado con éxito.", "Usuario Registrado", JOptionPane.INFORMATION_MESSAGE);
            this.inicializarMenu();
        });
        this.pack();
    }
     
    public void registrarUsuario(JTextField usuario, JTextField direccion, JTextField contrasena){
        try{
            CheckFormatoUsuarioYPass.checkUsuYPassFormat(usuario.getText(), contrasena.getText());
            CheckDireccion.checkFormatoDireccion(direccion.getText());
            CheckExistenciaUsuario.checkUsuarioExiste(usuario.getText(), contrasena.getText(), this.listaUsuarios);
            Usuario usuario2 = new UsuarioImpl(usuario.getText(), direccion.getText(), contrasena.getText());
            this.listaUsuarios.add(usuario2);
        }catch(Exception e){
            System.out.println(e.getMessage());
            mostrarPopUp("Formato usuario, contraseña o inválidos o usuario existente.", "Formato", JOptionPane.INFORMATION_MESSAGE);
        }
        
    } 
    
    public void inicializarMenuBotones() {
        panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(1, 2));
        this.add(panelBotones);
        botonFuncion = new JButton("Aceptar");
        botonAtras = new JButton("Atras");
        panelBotones.add(botonAtras);
        panelBotones.add(botonFuncion);
        this.add(panelBotones, BorderLayout.PAGE_END);
        this.pack();
    }
    
    public void inicializarMenuBotonAtras() {
        panelBotonAtras = new JPanel();
        panelBotonAtras.setLayout(new GridLayout(1, 1));
        this.add(panelBotonAtras);
        botonAtras = new JButton("Atras");
        panelBotonAtras.add(botonAtras);
        this.add(panelBotonAtras, BorderLayout.PAGE_END);
        this.pack();
    }
     
    public void inicializarPanelLogIn() {
        this.borrarMenu();
        panelLogIn = new JPanel();
        panelLogIn.setPreferredSize(new Dimension(500, 600));
        panelLogIn.setLayout(new GridLayout(1, 2));
        this.setTitle("Log In");
        
        JLabel usuario = new JLabel();
        JTextField usuarioField = new JTextField("Usuario");
        panelLogIn.add(usuario);
        panelLogIn.add(usuarioField);
        
        JLabel contrasena = new JLabel();
        JTextField contrasenaField = new JTextField("Contraseña");
        panelLogIn.add(contrasena);
        panelLogIn.add(contrasenaField);
        
        this.add(panelLogIn, BorderLayout.PAGE_START);
        this.inicializarMenuBotones();
        botonAtras.addActionListener(e -> this.inicializarMenu());
        botonLogIn.addActionListener(e -> {
            this.hacerLogIn(usuarioField, contrasenaField);
        });
        this.pack();
    }
        
    public void hacerLogIn(JTextField usuario, JTextField contrasena){
        try{
            CheckExistenciaUsuario.checkUsuarioNoExiste(usuario.getText(), contrasena.getText(), listaUsuarios);
        for(Usuario usuarioInfo: listaUsuarios) {
            if(usuario.equals(usuarioInfo)){
               this.usuario = usuarioInfo.getNombreUsuario();
               this.inicializarPanelHome();
            }
        }
        }catch(Exception e){
            System.out.println(e.getMessage());
            mostrarPopUp("Usuario no registrado", "Formato", JOptionPane.INFORMATION_MESSAGE);
        }
    }  
    
    //MenuAccesoYPerfil
    
    public void inicializarPanelHome() {
        this.borrarMenu();
        panelHome = new JPanel();
        panelHome.setPreferredSize(new Dimension(500, 600));
        panelHome.setLayout(new GridLayout(1, 2));
        this.setTitle("Home");
        this.add(panelHome, BorderLayout.PAGE_START);
        JButton pedidos = new JButton("Pedidos");
        JButton perfil = new JButton("Perfil");
        panelHome.add(pedidos);
        panelHome.add(perfil);
        perfil.addActionListener(e -> inicializarPanelPerfil());
        pedidos.addActionListener(e -> inicializarPanelPedidos());
        this.pack();
    }
     
    public void inicializarPanelPerfil(){
        this.borrarMenu();
        panelPerfil = new JPanel();
        panelPerfil.setPreferredSize(new Dimension(500, 600));
        panelPerfil.setLayout(new GridLayout(1, 2));
        this.setTitle("Perfil");
        this.add(panelPerfil, BorderLayout.PAGE_START);
        this.inicializarMenuBotones();
        botonAtras.addActionListener(e -> inicializarPanelHome());
        JButton modContrasena = new JButton("Modificar contraseña");
        JButton modDireccion = new JButton("Modificar dirección");
        panelPerfil.add(modContrasena);
        panelPerfil.add(modDireccion);
        modContrasena.addActionListener(e -> inicializarPanelModContrasena());
        modDireccion.addActionListener(e -> inicializarPanelModDireccion());
        this.pack();
    }
     
    public void inicializarPanelModContrasena(){
        this.borrarMenu();
        panelModContrasena = new JPanel();
        panelModContrasena.setPreferredSize(new Dimension(500, 600));
        panelModContrasena.setLayout(new GridLayout(1, 1));
        this.setTitle("Modificar contraseña");
        
        JLabel contrasena = new JLabel();
        JTextField contrasenaField = new JTextField("Contraseña");
        panelModContrasena.add(contrasena);
        panelModContrasena.add(contrasenaField);
        
        this.add(panelModContrasena, BorderLayout.PAGE_START);
        this.inicializarMenuBotones();
        botonAtras.addActionListener(e -> inicializarPanelHome());
        botonFuncion.addActionListener(e -> {
            ModificarContrasena.modificarContrasenaUsuario(this.usuario, this.listaUsuarios, contrasenaField.getText());
            this.mostrarPopUp("Contraseña modificada con éxito.", "Contraseña modificada", JOptionPane.INFORMATION_MESSAGE);
            this.inicializarPanelHome();
        });
        this.pack();
    }
    
    public void inicializarPanelModDireccion(){
        this.borrarMenu();
        panelModDireccion = new JPanel();
        panelModDireccion.setPreferredSize(new Dimension(500, 600));
        panelModDireccion.setLayout(new GridLayout(1, 1));
        this.setTitle("Modificar dirección");
        
        JLabel direccion = new JLabel();
        JTextField direccionField = new JTextField("Dirección");
        panelModDireccion.add(direccion);
        panelModDireccion.add(direccionField);
        
        this.add(panelModDireccion, BorderLayout.PAGE_START);
        this.inicializarMenuBotones();
        botonAtras.addActionListener(e -> inicializarPanelHome());
        botonFuncion.addActionListener(e -> {
            ModificarDireccion.modificarDireccionUsuario(this.usuario, this.listaUsuarios, direccionField.getText());
            this.mostrarPopUp("Dirección modificada con éxito.", "Dirección modificada", JOptionPane.INFORMATION_MESSAGE);
            this.inicializarPanelHome();
        });
        this.pack();
    }
    
    //MenuPedidos
    
    public void inicializarPanelPedidos() {
        this.borrarMenu();
        panelPedidos = new JPanel();
        panelPedidos.setPreferredSize(new Dimension(500, 600));
        panelPedidos.setLayout(new GridLayout(3, 2));
        this.setTitle("Pedidos");
        this.add(panelPedidos, BorderLayout.PAGE_START);
        JButton realizarPedido = new JButton("Realizar pedido");
        JButton modificarPedido = new JButton("Modificar pedido");
        JButton cancelarPedido = new JButton("Cancelar pedido");
        JButton verEstado = new JButton("Ver estado pedido");
        JButton mostrarPrecio = new JButton("Mostrar precio total");
        panelPedidos.add(realizarPedido);
        panelPedidos.add(modificarPedido);
        panelPedidos.add(cancelarPedido);
        panelPedidos.add(verEstado);
        panelPedidos.add(mostrarPrecio);
        realizarPedido.addActionListener(e -> inicializarPanelTipoEstablecimiento());
        modificarPedido.addActionListener(e -> {});
        cancelarPedido.addActionListener(e -> inicializarPanelCancelarPedido());
        verEstado.addActionListener(e -> inicializarPanelVerEstadoPedido());
        mostrarPrecio.addActionListener(e -> inicializarPanelMostrarPrecioPedido());
        this.pack();
    }
    
    public void inicializarPanelTipoEstablecimiento(){
        this.borrarMenu();
        panelTipoEstablecimiento = new JPanel();
        panelTipoEstablecimiento.setPreferredSize(new Dimension(500, 600));
        panelTipoEstablecimiento.setLayout(new GridLayout(1, 1));
        this.setTitle("Establecimiento");
        
        JButton establecimientoComida = new JButton("Establecimiento Comida");
        JButton establecimientoBelleza = new JButton("Establecimiento Belleza");
        JButton establecimientoSupermercado = new JButton("Establecimiento Supermercado");
        panelTipoEstablecimiento.add(establecimientoComida);
        panelTipoEstablecimiento.add(establecimientoBelleza);
        panelTipoEstablecimiento.add(establecimientoSupermercado);
        establecimientoComida.addActionListener(e -> inicializarPanelListaComida());
        establecimientoBelleza.addActionListener(e -> inicializarPanelListaBelleza());
        establecimientoSupermercado.addActionListener(e -> inicializarPanelListaSupermercado());

        this.add(panelTipoEstablecimiento, BorderLayout.PAGE_START);
        this.inicializarMenuBotonAtras();
        botonAtras.addActionListener(e -> inicializarPanelPedidos());
        this.pack();
    }
    

    public void inicializarPanelListaBelleza() {
        this.borrarMenu();
        
        this.panelLista = new JPanel();
        panelLista.setPreferredSize(new Dimension(250, 300));
        panelLista.setLayout(new BorderLayout());
        this.setTitle("Productos");
        List<Producto> listaProductos = new ArrayList<>();
        this.listaProductosBelleza.stream().forEach(p -> listaProductos.add((p)));

        JList lista = new JList();
        DefaultListModel modelo = new DefaultListModel();
        modelo.addAll(listaProductos);
        lista.setModel(modelo);
        
        JScrollPane scrollPane = new JScrollPane(lista);
        scrollPane.setPreferredSize(new Dimension(200, 300));
        panelLista.add(scrollPane);
        this.add(panelLista, BorderLayout.PAGE_START);
        this.inicializarMenuBotones();
        botonAtras.addActionListener(e -> inicializarPanelTipoEstablecimiento());
        botonFuncion.addActionListener(e -> {
            realizarPedido(this.usuario, encontrarProducto(this.listaProductosBelleza, 
                           lista.getSelectedValue()));
            this.inicializarPanelTipoEstablecimiento();
        });
        this.pack();  
    }
    
    public void inicializarPanelListaComida() {
        this.borrarMenu();

        this.panelLista = new JPanel();
        panelLista.setPreferredSize(new Dimension(250, 300));
        panelLista.setLayout(new BorderLayout());
        this.setTitle("Productos");
        List<Producto> listaProductos = new ArrayList<>();
        this.listaProductosComida.stream().forEach(p -> listaProductos.add((p)));

        JList lista = new JList();
        DefaultListModel modelo = new DefaultListModel();
        modelo.addAll(listaProductos);
        lista.setModel(modelo);
        
        JScrollPane scrollPane = new JScrollPane(lista);
        scrollPane.setPreferredSize(new Dimension(200, 300));
        panelLista.add(scrollPane);
        this.add(panelLista, BorderLayout.PAGE_START);
        this.inicializarMenuBotones();
        botonAtras.addActionListener(e -> inicializarPanelTipoEstablecimiento());
        botonFuncion.addActionListener(e -> {
            realizarPedido(this.usuario, encontrarProducto(this.listaProductosComida, 
                           lista.getSelectedValue()));
            this.inicializarPanelTipoEstablecimiento();
        });
        this.pack();  
    }
    
    public void inicializarPanelListaSupermercado() {
        this.borrarMenu();

        this.panelLista = new JPanel();
        panelLista.setPreferredSize(new Dimension(250, 300));
        panelLista.setLayout(new BorderLayout());
        this.setTitle("Productos");
        List<Producto> listaProductos = new ArrayList<>();
        this.listaProductosComida.stream().forEach(p -> listaProductos.add((p)));

        JList lista = new JList();
        DefaultListModel modelo = new DefaultListModel();
        modelo.addAll(listaProductos);
        lista.setModel(modelo);
        
        JScrollPane scrollPane = new JScrollPane(lista);
        scrollPane.setPreferredSize(new Dimension(200, 300));
        panelLista.add(scrollPane);
        this.add(panelLista, BorderLayout.PAGE_START);
        this.inicializarMenuBotones();
        botonAtras.addActionListener(e -> inicializarPanelTipoEstablecimiento());
        botonFuncion.addActionListener(e -> {
            realizarPedido(this.usuario, encontrarProducto(this.listaProductosSupermercado, 
                           lista.getSelectedValue()));
            this.inicializarPanelTipoEstablecimiento();
        });
        this.pack();  
    }
    
    public void realizarPedido(String nombreUsuario, Producto producto){
        List<Producto> listaProductoUsuario = new ArrayList();
        listaProductoUsuario.add(producto);
        String usuarioEncontrado = EncontrarNombreUsuario.encontrarNombreUsuario(this.listaUsuarios, nombreUsuario);
        for(Usuario usuario: this.listaUsuarios) {
            Pedido pedidoUsuario = new PedidoImpl(EstadoPedido.PENDIENTE, 
                                   listaProductoUsuario, usuarioEncontrado);
            usuario.getListaPedido().add(pedidoUsuario);
        }
    }
    
    public Producto encontrarProducto(List<Producto> listaProducto, Object o){
        Producto productoReturn = new ProductoImpl();
        for(Producto producto: listaProducto) {
            if(producto.getNombre().equals(o)){
               productoReturn = producto;
            }
        }
        return productoReturn;
    }
    
   /* public void inicializarPanelModPedido(){
         this.borrarMenu();

        this.panelModPedido = new JPanel();
        panelModPedido.setPreferredSize(new Dimension(250, 300));
        panelModPedido.setLayout(new BorderLayout());
        List<Pedido> listaPedidos = new ArrayList<>();
        this.listaPedidos.stream().forEach(p -> listaPedidos.add(p.getIdPedido()));

        JList lista = new JList();
        DefaultListModel modelo = new DefaultListModel();
        modelo.addAll(listaProductos);
        lista.setModel(modelo);
        
        JScrollPane scrollPane = new JScrollPane(lista);
        scrollPane.setPreferredSize(new Dimension(200, 300));
        panelModPedido.add(scrollPane);
        this.add(panelModPedido, BorderLayout.PAGE_START);
        this.inicializarMenuBotones();
        botonAtras.addActionListener(e -> inicializarPanelTipoEstablecimiento());
        botonFuncion.addActionListener(e -> {
            realizarPedido(this.usuario, encontrarProducto(this.listaProductosSupermercado, 
                           lista.getSelectedValue()));
            this.inicializarPanelTipoEstablecimiento();
        });
        this.pack();  
    }
    */
    
    public void inicializarPanelCancelarPedido(){
        this.borrarMenu();
        panelCancelarPedido = new JPanel();
        panelCancelarPedido.setPreferredSize(new Dimension(500, 600));
        panelCancelarPedido.setLayout(new GridLayout(1, 1));
        this.setTitle("Cancelar pedido");
        
        JLabel idPedido = new JLabel();
        JTextField idPedidoField = new JTextField("Id de tu pedido");
        panelCancelarPedido.add(idPedido);
        panelCancelarPedido.add(idPedidoField);
        
        this.add(panelCancelarPedido, BorderLayout.PAGE_START);
        this.inicializarMenuBotones();
        botonAtras.addActionListener(e -> inicializarPanelPedidos());
        botonFuncion.addActionListener(e -> {
            cancelarPedido(this.listaPedidos, idPedidoField.getText());
            this.inicializarPanelPedidos();
                });
        this.pack();
    }
    
    public void cancelarPedido(List<Pedido> listaPedidos, String idPedido){
        Pedido pedido = EncontrarPedido.encontrarUnPedido(listaPedidos, Integer.parseInt(idPedido));
        for (Usuario usuario: this.listaUsuarios) {
            if(usuario.getListaPedido().contains(pedido)){
               pedido.setEstadoPedido(EstadoPedido.CANCELADO);
            }
        }
    }
    
    public void inicializarPanelVerEstadoPedido(){
        this.borrarMenu();
        panelVerEstadoPedido = new JPanel();
        panelVerEstadoPedido.setPreferredSize(new Dimension(500, 600));
        panelVerEstadoPedido.setLayout(new GridLayout(1, 1));
        this.setTitle("Estado Pedido");
        
        JLabel idPedido = new JLabel();
        JTextField idPedidoField = new JTextField("Id de tu pedido");
        panelVerEstadoPedido.add(idPedido);
        panelVerEstadoPedido.add(idPedidoField);
        
        this.add(panelVerEstadoPedido, BorderLayout.PAGE_START);
        this.inicializarMenuBotones();
        botonAtras.addActionListener(e -> inicializarPanelPedidos());
        botonFuncion.addActionListener(e -> {
            verEstadoPedido(idPedidoField.getText());
            this.inicializarPanelPedidos();
                });
        this.pack();
    }
    
    public void verEstadoPedido(String idPedido){
        Pedido pedido = EncontrarPedido.encontrarUnPedido(listaPedidos, Integer.parseInt(idPedido));
        String pedidoString = pedido.getEstadoPedido().toString();
        for (Usuario usuario: this.listaUsuarios) {
            if(usuario.getListaPedido().contains(pedido)){
                mostrarPopUp(pedidoString, "Estado Pedido", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
    
    public void inicializarPanelMostrarPrecioPedido(){
        this.borrarMenu();
        panelMostrarPrecioPedido = new JPanel();
        panelMostrarPrecioPedido.setPreferredSize(new Dimension(500, 600));
        panelMostrarPrecioPedido.setLayout(new GridLayout(1, 1));
        this.setTitle("Precio Pedido");
        
        JLabel idPedido = new JLabel();
        JTextField idPedidoField = new JTextField("Id de tu pedido");
        panelMostrarPrecioPedido.add(idPedido);
        panelMostrarPrecioPedido.add(idPedidoField);
        
        this.add(panelMostrarPrecioPedido, BorderLayout.PAGE_START);
        this.inicializarMenuBotones();
        botonAtras.addActionListener(e -> inicializarPanelPedidos());
        botonFuncion.addActionListener(e -> {
            mostrarPrecioTotal(idPedidoField.getText());
            this.inicializarPanelPedidos();
                });
        this.pack();
    }
    
    public void mostrarPrecioTotal(String idPedido){
        Pedido pedido = EncontrarPedido.encontrarUnPedido(listaPedidos, Integer.parseInt(idPedido));
        for (Usuario usuario: this.listaUsuarios) {
            if(usuario.getListaPedido().contains(pedido)){
               double sum = 0;
               pedido.getListaProductos().stream().mapToDouble(Producto::getPrecio).sum();
            }
        }
    }
    
    public void mostrarPopUp(String mensaje, String titulo, int option) {
        // Mostrar un mensaje emergente de información
        JOptionPane.showMessageDialog(null, mensaje, titulo, option);
    }
 
    
     
}




