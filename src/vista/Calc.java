
package vista;

import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;


public class Calc extends JFrame{
    
    //Atributos
    private JPanel jPanel;
    private JMenuBar jBarraMenu;
    private JMenu jMenu;
    private JMenuItem jItemCalEstandar,jItemCalDivisa,jItemSalir;
    
    //Constructor
    
    public Calc(){
        
        //Metodo que inicializa los componentes del JFrame
        inicializarComponentes();
        
        //La barrra de menu
        this.setJMenuBar(jBarraMenu);


        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
    }
    
    //Inicializar componentes
    private void inicializarComponentes(){
        agregarVentana();
        agregarBarraMenu();
        agregarMenu();
        agregarMenuItem();
        agregarPanel();
  
    }
    
    //Inicializar ventana
    private void agregarVentana(){
        this.setTitle("Calculadora");
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
        jMenu.addSeparator();
        
        jItemSalir = new JMenuItem("Salir");
        jItemSalir.setFont(new Font("Arial Rounded MT Bold", 0, 15));
        jMenu.add(jItemSalir);
        
        eventoItemDivisa();
        eventoItemSalir();
         
    }
    
    //Crear panel
    private void agregarPanel(){
        jPanel = new JPanel();
        this.add(jPanel);
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
    private void eventoItemDivisa(){
        
        MouseListener evento = new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {
                
            }

            @Override
            public void mousePressed(MouseEvent e) {
                //Objeto de la clase divisa
                Divisa divisa = new Divisa();
                
                divisa.setVisible(true);
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
         
        jItemCalDivisa.addMouseListener(evento);
        
    }
}
