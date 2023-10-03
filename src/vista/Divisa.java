
package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


public class Divisa extends JFrame{
    
    //Atributos
   
    private JMenuBar jBarraMenu;
    private JMenu jMenu;
    private JMenuItem jItemCalEstandar,jItemCalDivisa,jItemSalir;
    private JPanel panel;
    private GridBagLayout design;
    private GridBagConstraints c;
    private JLabel jlDivisa1,jlDivisa2,jlCambio,jlCambio2;
    private JComboBox comboDivisa,comboDivisa2;
    private JButton btnC,btnBorrar,btn7,btn8,btn9,btn4,btn5,btn6,btn1,btn2,btn3,btn0,btnPunto;
    private String divisa []= {"Estados Unidos - Dólar","Perú - Sol","Europa - Euro"};
    private String moneda = "";
    private String moneda2 = "";
    private String cantidad = "";
    private double dinero = 0,cambio = 0;

    
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
        agregarPanel();
        agregarDesign();
        agregarEtiquetaDivisa();
        agregarEtiquetaCambio();
        agregarComboDivisa();
        agregarEtiquetaDivisa2();
        agregarEtiquetaCambio2();
        agregarComboDivisa2();
        agregarBoton();
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
        jMenu.addSeparator();
        
        jItemSalir = new JMenuItem("Salir");
        jItemSalir.setFont(new Font("Arial Rounded MT Bold", 0, 15));
        jMenu.add(jItemSalir);
        
        eventoItemEstandar();
        eventoItemSalir();
         
    }
    
    //Evento salir del item de la barra de menu
    private void eventoItemSalir(){
        
        ActionListener evento = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        };
        
        jItemSalir.addActionListener(evento);
        
    }
    
    
    //Evento abrir la ventana de divisa
    private void eventoItemEstandar(){
        
        ActionListener evento = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
                //Objeto de la clase Calc
                Calc calc = new Calc();
                
                calc.setVisible(true);
                dispose();

            }
        };
        
        jItemCalEstandar.addActionListener(evento);
        
    }
    
    //Agregar panel
    private void agregarPanel(){
        panel = new JPanel();
        this.add(panel);
    }
    
    //Agregar el diseño
    private void agregarDesign(){
        design = new GridBagLayout();
        panel.setLayout(design);
        c = new GridBagConstraints();
    }
    
    //Agregar la etiqueta divisa 1
    private void agregarEtiquetaDivisa(){
        jlDivisa1 = new JLabel("$");
        jlDivisa1.setFont(new Font("Arial", 0, 36));
        jlDivisa1.setHorizontalAlignment(SwingConstants.RIGHT);
        
        
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 1;
        c.gridheight = 1;
        c.fill = GridBagConstraints.BOTH;
        
        c.insets = new Insets(15, 15, 0, 10);
        c.weightx = 0.5;
        c.weighty = 0.5;
        
        
        panel.add(jlDivisa1, c);
    }
    
    //Agregar etiqueta cambio 1
    private void agregarEtiquetaCambio(){
        jlCambio = new JLabel("0");
        jlCambio.setFont(new Font("Arial", 0, 36));
        
        c.gridx = 1;
        c.gridy = 0;
        c.gridwidth = 2;
        c.gridheight = 1;
        
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.CENTER;
        c.insets = new Insets(15, 0, 0, 0);
        c.weightx = 0.5;
        c.weighty = 0.5;
        
        panel.add(jlCambio, c);
    }
    
    //Agregar combo divisa 1
    private void agregarComboDivisa(){
        comboDivisa = new JComboBox(divisa);
        comboDivisa.setFont(new Font("Arial", 0, 14));
        
        
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 3;
        c.gridheight = 1;
        
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.CENTER;
        c.insets = new Insets(0, 10, 0, 10);
        c.weightx = 0.5;
        c.weighty = 0.5;
        
        
        panel.add(comboDivisa, c);
    }
    
    //Agregar la etiqueta divisa 2
    private void agregarEtiquetaDivisa2(){
        jlDivisa2 = new JLabel("$");
        jlDivisa2.setFont(new Font("Arial", 0, 36));
        jlDivisa2.setHorizontalAlignment(SwingConstants.RIGHT);
        
        
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 1;
        c.gridheight = 1;
        
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.CENTER;
        c.insets = new Insets(15, 15, 0, 10);
        c.weightx = 0.5;
        c.weighty = 0.5;
        
        
        panel.add(jlDivisa2, c);
    }

    
    //Agregar etiqueta cambio 2
    private void agregarEtiquetaCambio2(){
        jlCambio2 = new JLabel("0");
        jlCambio2.setFont(new Font("Arial", 0, 36));
        
        c.gridx = 1;
        c.gridy = 2;
        c.gridwidth = 2;
        c.gridheight = 1;
        
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.CENTER;
        c.insets = new Insets(15, 0, 0, 0);
        c.weightx = 0.5;
        c.weighty = 0.5;
        
        panel.add(jlCambio2, c);
    }
    
    //Agregar combo divisa 2
    private void agregarComboDivisa2(){
        comboDivisa2 = new JComboBox(divisa);
        comboDivisa2.setFont(new Font("Arial", 0, 14));
        
        
        c.gridx = 0;
        c.gridy = 3;
        c.gridwidth = 3;
        c.gridheight = 1;
        
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.CENTER;
        c.insets = new Insets(0, 10, 0, 10);
        c.weightx = 0.5;
        c.weighty = 0.5;
        
        
        panel.add(comboDivisa2, c);
        
    }
    
    //Agregar botones
    private void agregarBoton(){
        
        btnC = new JButton("C");
        btnC.setFont(new Font("Arial", 0, 18));
        
        c.gridx = 1;
        c.gridy = 4;
        c.gridwidth = 1;
        c.gridwidth = 1;
        
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.CENTER;
        c.insets = new Insets(15, 0, 0, 0);
        c.weightx = 0.5;
        c.weighty = 0.5;
        panel.add(btnC, c);
        
        
        btnBorrar = new JButton("X");
        btnBorrar.setFont(new Font("Arial", 0, 18));
        
        c.gridx = 2;
        c.gridy = 4;
        c.gridwidth = 1;
        c.gridwidth = 1;
        
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.CENTER;
        c.insets = new Insets(15, 0, 0, 0);
        c.weightx = 0.5;
        c.weighty = 0.5;
        panel.add(btnBorrar, c);
        
        
        btn7 = new JButton("7");
        btn7.setFont(new Font("Arial", 0, 18));
  
        
        c.gridx = 0;
        c.gridy = 5;
        c.gridwidth = 1;
        c.gridwidth = 1;
        
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.CENTER;
        c.weightx = 0.5;
        c.weighty = 0.5;
        panel.add(btn7, c);
        
        
        btn8 = new JButton("8");
        btn8.setFont(new Font("Arial", 0, 18));
        btn8.setBackground(new Color(204, 204, 204));
        
        c.gridx = 1;
        c.gridy = 5;
        c.gridwidth = 1;
        c.gridwidth = 1;
        
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.CENTER;
        c.weightx = 0.5;
        c.weighty = 0.5;
        panel.add(btn8, c);
        
        
        btn9 = new JButton("9");
        btn9.setFont(new Font("Arial", 0, 18));
        btn9.setBackground(new Color(204, 204, 204));
        
        c.gridx = 2;
        c.gridy = 5;
        c.gridwidth = 1;
        c.gridwidth = 1;
        
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.CENTER;
        c.weightx = 0.5;
        c.weighty = 0.5;
        panel.add(btn9, c);
        
        
        btn4 = new JButton("4");
        btn4.setFont(new Font("Arial", 0, 18));
        btn4.setBackground(new Color(204, 204, 204));
        
        c.gridx = 0;
        c.gridy = 6;
        c.gridwidth = 1;
        c.gridwidth = 1;
        
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.CENTER;
        c.weightx = 0.5;
        c.weighty = 0.5;
        panel.add(btn4, c);
        
        btn5 = new JButton("5");
        btn5.setFont(new Font("Arial", 0, 18));
        btn5.setBackground(new Color(204, 204, 204));
        
       
        c.gridx = 1;
        c.gridy = 6;
        c.gridwidth = 1;
        c.gridwidth = 1;
        
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.CENTER;
        c.weightx = 0.5;
        c.weighty = 0.5;
        panel.add(btn5, c);
        
        btn6 = new JButton("6");
        btn6.setFont(new Font("Arial", 0, 18));
        btn6.setBackground(new Color(204, 204, 204));
        
        c.gridx = 2;
        c.gridy = 6;
        c.gridwidth = 1;
        c.gridwidth = 1;
        
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.CENTER;
        c.weightx = 0.5;
        c.weighty = 0.5;
        panel.add(btn6, c);
        
       
        btn1 = new JButton("1");
        btn1.setFont(new Font("Arial", 0, 18));
        btn1.setBackground(new Color(204, 204, 204));
        
        c.gridx = 0;
        c.gridy = 7;
        c.gridwidth = 1;
        c.gridwidth = 1;
        
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.CENTER;
        c.weightx = 0.5;
        c.weighty = 0.5;
        panel.add(btn1, c);
        
        
        btn2 = new JButton("2");
        btn2.setFont(new Font("Arial", 0, 18));
        btn2.setBackground(new Color(204, 204, 204));
        
        c.gridx = 1;
        c.gridy = 7;
        c.gridwidth = 1;
        c.gridwidth = 1;
        
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.CENTER;
        c.weightx = 0.5;
        c.weighty = 0.5;
        panel.add(btn2, c);
        
         
        
        btn3 = new JButton("3");
        btn3.setFont(new Font("Arial", 0, 18));
        btn3.setBackground(new Color(204, 204, 204));
        
        c.gridx = 2;
        c.gridy = 7;
        c.gridwidth = 1;
        c.gridwidth = 1;
        
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.CENTER;
        c.weightx = 0.5;
        c.weighty = 0.5;
        panel.add(btn3, c);
        

        btn0 = new JButton("0");
        btn0.setFont(new Font("Arial", 0, 18));
        btn0.setBackground(new Color(204, 204, 204));
        
        c.gridx = 1;
        c.gridy = 8;
        c.gridwidth = 1;
        c.gridwidth = 1;
        
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.CENTER;
        c.weightx = 0.5;
        c.weighty = 0.5;
        panel.add(btn0, c);
        
        
        btnPunto = new JButton(".");
        btnPunto.setFont(new Font("Arial", 0, 18));
        
        c.gridx = 2;
        c.gridy = 8;
        c.gridwidth = 1;
        c.gridwidth = 1;
        
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.CENTER;
        c.weightx = 0.5;
        c.weighty = 0.5;
        panel.add(btnPunto, c);
        
        //Llamada a los eventos
        eventoCombo1();
        eventoCombo2();
        
        eventoBtn1();
        eventoBtn2();
        eventoBtn3();
        eventoBtn4();
        eventoBtn5();
        eventoBtn6();
        eventoBtn7();
        eventoBtn8();
        eventoBtn9();
        eventoBtn0();

    }
    
    
    //Eventos
    
    //Combo 1
    
    private void eventoCombo1(){
        
        ActionListener evento = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                moneda = (String) comboDivisa.getSelectedItem();
                
                if(moneda.equals("Estados Unidos - Dólar")){
                    jlDivisa1.setText("$");
                }
                else if(moneda.equals("Perú - Sol")){
                    jlDivisa1.setText("S/");
                }
                else if(moneda.equals("Europa - Euro")){
                    jlDivisa1.setText("€");
                }
                
                obtenerDinero();

            }
        };
        
        comboDivisa.addActionListener(evento);
        
    }
    
    //Combo 2
    private void eventoCombo2(){
        
        ActionListener evento = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                moneda2 = (String) comboDivisa2.getSelectedItem();
                
                if(moneda2.equals("Estados Unidos - Dólar")){
                    jlDivisa2.setText("$");
                }
                else if(moneda2.equals("Perú - Sol")){
                    jlDivisa2.setText("S/");
                }
                else if(moneda2.equals("Europa - Euro")){
                    jlDivisa2.setText("€");
                }
                
                obtenerDinero();
        
            }
        };
        
        comboDivisa2.addActionListener(evento);
        
    }
    
    //Boton 1
    
    private void eventoBtn1(){
        
        ActionListener evento = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
                cantidad += "1";
                jlCambio.setText(cantidad);
                obtenerDinero();

            }
        };
        
        btn1.addActionListener(evento);
        
    }
    
    private void eventoBtn2(){
        
        ActionListener evento = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
                cantidad += "2";
                jlCambio.setText(cantidad);
                obtenerDinero();

            }
        };
        
        btn2.addActionListener(evento);
        
    }
    
    
    private void eventoBtn3(){
        
        ActionListener evento = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
                cantidad += "3";
                jlCambio.setText(cantidad);
                obtenerDinero();

            }
        };
        
        btn3.addActionListener(evento);
        
    }
    
    private void eventoBtn4(){
        
        ActionListener evento = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
                cantidad += "4";
                jlCambio.setText(cantidad);
                obtenerDinero();

            }
        };
        
        btn4.addActionListener(evento);
        
    }
    
    private void eventoBtn5(){
        
        ActionListener evento = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
                cantidad += "5";
                jlCambio.setText(cantidad);
                obtenerDinero();

            }
        };
        
        btn5.addActionListener(evento);
        
    }
    
    private void eventoBtn6(){
        
        ActionListener evento = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
                cantidad += "6";
                jlCambio.setText(cantidad);
                obtenerDinero();

            }
        };
        
        btn6.addActionListener(evento);
        
    }
    
    private void eventoBtn7(){
        
        ActionListener evento = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
                cantidad += "7";
                jlCambio.setText(cantidad);
                obtenerDinero();

            }
        };
        
        btn7.addActionListener(evento);
        
    }
    
    private void eventoBtn8(){
        
        ActionListener evento = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
                cantidad += "8";
                jlCambio.setText(cantidad);
                obtenerDinero();

            }
        };
        
        btn8.addActionListener(evento);
        
    }
    
    private void eventoBtn9(){
        
        ActionListener evento = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
                cantidad += "9";
                jlCambio.setText(cantidad);
                obtenerDinero();

            }
        };
        
        btn9.addActionListener(evento);
        
    }
    
    private void eventoBtn0(){
        
        ActionListener evento = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
                if(cantidad != ""){
                    cantidad += "0";
                    jlCambio.setText(cantidad);
                    obtenerDinero();
                }


            }
        };
        
        btn0.addActionListener(evento);
        
    }
    
    
    //Calculo para la conversion de divisas
    private void obtenerDinero(){
        cantidad = jlCambio.getText();
        dinero = Double.parseDouble(cantidad);
        
        cambioDivisa();
        
        dinero *= cambio;
        
        jlCambio2.setText(String.format("%.2f", dinero));
    }
    
    
    private void cambioDivisa(){
        
        if(moneda.equals(moneda2)){
            cambio = 1;
        }
        else if(moneda.equals("Estados Unidos - Dólar") && moneda2.equals("Perú - Sol")){
            cambio = 3.79;
        }
        else if(moneda.equals("Estados Unidos - Dólar") && moneda2.equals("Europa - Euro")){
            cambio = 0.95;
        }
        else if(moneda.equals("Perú - Sol") && moneda2.equals("Estados Unidos - Dólar")){
            cambio = 0.26;
        }
        else if(moneda.equals("Perú - Sol") && moneda2.equals("Europa - Euro")){
            cambio = 0.25;
        }
        else if(moneda.equals("Europa - Euro") && moneda2.equals("Estados Unidos - Dólar")){
            cambio = 1.04;
        }
        else if(moneda.equals("Europa - Euro") && moneda2.equals("Perú - Sol")){
            cambio = 3.97;
        }
        
        
    }
    
}
