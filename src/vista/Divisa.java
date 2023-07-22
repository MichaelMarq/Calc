
package vista;

import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


public class Divisa extends JFrame{
    
    //Atributos
   
    private JMenuBar jBarraMenu;
    private JMenu jMenu;
    private JMenuItem jItemCalEstandar,jItemCalDivisa,jItemSalir;
    
    //Objeto de la clase Calc
    Calc calc = new Calc();
    
    //Constructor
    
    public Divisa(){
        
        //Metodo que inicializa los componentes del JFrame
        inicializarComponentes();
        
        //La barrra de menu
        this.setJMenuBar(jBarraMenu);
        
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
    }
    
    
    //Metodos
    
    //Inicializar componentes
    private void inicializarComponentes(){
        agregarVentana();
        agregarBarraMenu();
        agregarMenu();
        agregarMenuItem();
    }
    
    //Inicializar ventana
    private void agregarVentana(){
        this.setTitle("Divisa");
        this.setSize(330, 440);
        
        this.setLocationRelativeTo(null);    
    }
    
    //Agregar la barra de menu a la ventana
    private void agregarBarraMenu(){
        jBarraMenu = new JMenuBar();
    }
    
    //Agregar el menu a la barra de menu
    private void agregarMenu(){
        jMenu = new JMenu("Usos");
        jMenu.setFont(new Font("Arial Rounded MT Bold", 0, 16));
        jBarraMenu.add(jMenu);
    }
    
    //Agregar Items al menu
    private void agregarMenuItem(){
        jItemCalEstandar = new JMenuItem("Calculadora Estándar");
        jItemCalEstandar.setFont(new Font("Arial Rounded MT Bold", 0, 15));
        jMenu.add(jItemCalEstandar);
        
        jItemCalDivisa = new JMenuItem("Conversor de Divisas");
        jItemCalDivisa.setFont(new Font("Arial Rounded MT Bold", 0, 15));
        jMenu.add(jItemCalDivisa);
        
        jItemSalir = new JMenuItem("Salir");
        jItemSalir.setFont(new Font("Arial Rounded MT Bold", 0, 15));
        jMenu.add(jItemSalir);
        
        //eventoItemEstandar();
        eventoItemSalir();
         
    }
    
    
    
    
    //Evento salir del item de la barra de menu
    private void eventoItemSalir(){
        
        MouseListener evento = new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {
                
            }

            @Override
            public void mousePressed(MouseEvent e) {
                System.exit(0);
            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
            
        };
         
        jItemSalir.addMouseListener(evento);
        
    }
    
    
    
    
    
    
    
    //Evento abrir la ventana de divisa
    private void eventoItemEstandar(){
        
        MouseListener evento = new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {
                
            }

            @Override
            public void mousePressed(MouseEvent e) {
                calc.setVisible(true);
                dispose();
            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
            
        };
         
        jItemCalEstandar.addMouseListener(evento);
        
    }
    
}