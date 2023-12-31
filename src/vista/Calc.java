
package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


public class Calc extends JFrame{
    
    //Atributos
    private JLabel jlResultado,jlNumero;
    private JButton btnC,btnRaiz,btnDivision,btnBorrar,btn7,btn8,btn9,btnMultiplicacion,btn4,btn5,btn6,btnResta,btn1,btn2,btn3,btnSuma,btnCambiarSigno,btn0,btnPunto,btnIgual;
    private JPanel jPanel;
    private JMenuBar jBarraMenu;
    private JMenu jMenu;
    private JMenuItem jItemCalEstandar,jItemCalDivisa,jItemSalir;
    private GridBagLayout design;
    private GridBagConstraints c;
    
    private String cadenaNumeros = "";
    private String operacion = "nula";
    private double numero1 = 0;
    private double resultado = 0;
    private boolean activado = true;
    private boolean punto = true;
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
        agregarDesign();
        agregarEtiquetaResultado();
        agregarEtiquetaNumero();
        agregarBoton();
  
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
    
    //Crear el diseño
    private void agregarDesign(){
        design = new GridBagLayout();
        jPanel.setLayout(design);
        c = new GridBagConstraints();
    }
    
    //Agregar botones
    private void agregarBoton(){
        
        btnC = new JButton("C");
        btnC.setFont(new Font("Arial", 0, 18));
        
        
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 1;
        c.gridwidth = 1;
        
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.CENTER;
        c.weightx = 0.5;
        c.weighty = 0.5;
        jPanel.add(btnC, c);
        
        
        btnRaiz = new JButton("√");
        btnRaiz.setFont(new Font("Arial", 0, 18));
        
        c.gridx = 1;
        c.gridy = 2;
        c.gridwidth = 1;
        c.gridwidth = 1;
        
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.CENTER;
        c.weightx = 0.5;
        c.weighty = 0.5;
        jPanel.add(btnRaiz, c);
        
        btnDivision = new JButton("÷");
        btnDivision.setFont(new Font("Arial", 0, 18));
        
        c.gridx = 2;
        c.gridy = 2;
        c.gridwidth = 1;
        c.gridwidth = 1;
        
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.CENTER;
        c.weightx = 0.5;
        c.weighty = 0.5;
        jPanel.add(btnDivision, c);
        
        
        btnBorrar = new JButton("X");
        btnBorrar.setFont(new Font("Arial", 0, 18));
        
        c.gridx = 3;
        c.gridy = 2;
        c.gridwidth = 1;
        c.gridwidth = 1;
        
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.CENTER;
        c.weightx = 0.5;
        c.weighty = 0.5;
        jPanel.add(btnBorrar, c);
        
        
        btn7 = new JButton("7");
        btn7.setFont(new Font("Arial", 0, 18));
        btn7.setBackground(new Color(204, 204, 204));
        
        c.gridx = 0;
        c.gridy = 3;
        c.gridwidth = 1;
        c.gridwidth = 1;
        
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.CENTER;
        c.weightx = 0.5;
        c.weighty = 0.5;
        jPanel.add(btn7, c);
        
        btn8 = new JButton("8");
        btn8.setFont(new Font("Arial", 0, 18));
        btn8.setBackground(new Color(204, 204, 204));
        
        c.gridx = 1;
        c.gridy = 3;
        c.gridwidth = 1;
        c.gridwidth = 1;
        
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.CENTER;
        c.weightx = 0.5;
        c.weighty = 0.5;
        jPanel.add(btn8, c);
        
        
        btn9 = new JButton("9");
        btn9.setFont(new Font("Arial", 0, 18));
        btn9.setBackground(new Color(204, 204, 204));
        
        c.gridx = 2;
        c.gridy = 3;
        c.gridwidth = 1;
        c.gridwidth = 1;
        
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.CENTER;
        c.weightx = 0.5;
        c.weighty = 0.5;
        jPanel.add(btn9, c);
        
        
        btnMultiplicacion = new JButton("*");
        btnMultiplicacion.setFont(new Font("Arial", 0, 18));
        
        c.gridx = 3;
        c.gridy = 3;
        c.gridwidth = 1;
        c.gridwidth = 1;
        
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.CENTER;
        c.weightx = 0.5;
        c.weighty = 0.5;
        jPanel.add(btnMultiplicacion, c);
        
        
        btn4 = new JButton("4");
        btn4.setFont(new Font("Arial", 0, 18));
        btn4.setBackground(new Color(204, 204, 204));
        
        c.gridx = 0;
        c.gridy = 4;
        c.gridwidth = 1;
        c.gridwidth = 1;
        
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.CENTER;
        c.weightx = 0.5;
        c.weighty = 0.5;
        jPanel.add(btn4, c);
        
        btn5 = new JButton("5");
        btn5.setFont(new Font("Arial", 0, 18));
        btn5.setBackground(new Color(204, 204, 204));
        
       
        c.gridx = 1;
        c.gridy = 4;
        c.gridwidth = 1;
        c.gridwidth = 1;
        
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.CENTER;
        c.weightx = 0.5;
        c.weighty = 0.5;
        jPanel.add(btn5, c);
        
        btn6 = new JButton("6");
        btn6.setFont(new Font("Arial", 0, 18));
        btn6.setBackground(new Color(204, 204, 204));
        
        c.gridx = 2;
        c.gridy = 4;
        c.gridwidth = 1;
        c.gridwidth = 1;
        
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.CENTER;
        c.weightx = 0.5;
        c.weighty = 0.5;
        jPanel.add(btn6, c);
        
        btnResta = new JButton("-");
        btnResta.setFont(new Font("Arial", 0, 18));
        
        c.gridx = 3;
        c.gridy = 4;
        c.gridwidth = 1;
        c.gridwidth = 1;
        
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.CENTER;
        c.weightx = 0.5;
        c.weighty = 0.5;
        jPanel.add(btnResta, c);
        
        
        btn1 = new JButton("1");
        btn1.setFont(new Font("Arial", 0, 18));
        btn1.setBackground(new Color(204, 204, 204));
        
        c.gridx = 0;
        c.gridy = 5;
        c.gridwidth = 1;
        c.gridwidth = 1;
        
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.CENTER;
        c.weightx = 0.5;
        c.weighty = 0.5;
        jPanel.add(btn1, c);
        
        
        btn2 = new JButton("2");
        btn2.setFont(new Font("Arial", 0, 18));
        btn2.setBackground(new Color(204, 204, 204));
        
        c.gridx = 1;
        c.gridy = 5;
        c.gridwidth = 1;
        c.gridwidth = 1;
        
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.CENTER;
        c.weightx = 0.5;
        c.weighty = 0.5;
        jPanel.add(btn2, c);
        
         
        
        btn3 = new JButton("3");
        btn3.setFont(new Font("Arial", 0, 18));
        btn3.setBackground(new Color(204, 204, 204));
        
        c.gridx = 2;
        c.gridy = 5;
        c.gridwidth = 1;
        c.gridwidth = 1;
        
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.CENTER;
        c.weightx = 0.5;
        c.weighty = 0.5;
        jPanel.add(btn3, c);
        
        
        btnSuma = new JButton("+");
        btnSuma.setFont(new Font("Arial", 0, 18));
        
        c.gridx = 3;
        c.gridy = 5;
        c.gridwidth = 1;
        c.gridwidth = 1;
        
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.CENTER;
        c.weightx = 0.5;
        c.weighty = 0.5;
        jPanel.add(btnSuma, c);
        
        
        btnCambiarSigno = new JButton("±");
        btnCambiarSigno.setFont(new Font("Arial", 0, 18));
        
        c.gridx = 0;
        c.gridy = 6;
        c.gridwidth = 1;
        c.gridwidth = 1;
        
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.CENTER;
        c.weightx = 0.5;
        c.weighty = 0.5;
        jPanel.add(btnCambiarSigno, c);

        
        btn0 = new JButton("0");
        btn0.setFont(new Font("Arial", 0, 18));
        btn0.setBackground(new Color(204, 204, 204));
        
        c.gridx = 1;
        c.gridy = 6;
        c.gridwidth = 1;
        c.gridwidth = 1;
        
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.CENTER;
        c.weightx = 0.5;
        c.weighty = 0.5;
        jPanel.add(btn0, c);
        
        btnPunto = new JButton(".");
        btnPunto.setFont(new Font("Arial", 0, 18));
        
        c.gridx = 2;
        c.gridy = 6;
        c.gridwidth = 1;
        c.gridwidth = 1;
        
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.CENTER;
        c.weightx = 0.5;
        c.weighty = 0.5;
        jPanel.add(btnPunto, c);
        
        
        btnIgual = new JButton("=");
        btnIgual.setFont(new Font("Arial", 0, 18));
        
        c.gridx = 3;
        c.gridy = 6;
        c.gridwidth = 1;
        c.gridwidth = 1;
        
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.CENTER;
        c.weightx = 0.5;
        c.weighty = 0.5;
        jPanel.add(btnIgual, c);
        
        
        //Eventos de los botones
        eventoBtn0();
        eventoBtn1();
        eventoBtn2();
        eventoBtn3();
        eventoBtn4();
        eventoBtn5();
        eventoBtn6();
        eventoBtn7();
        eventoBtn8();
        eventoBtn9();
        
        eventoSuma();
        eventoIgual();
        eventoPunto();
        eventoCambiarSigno();
        eventoBorrar();
        eventoResta();
        eventoMultiplicacion();
        eventoDivision();
        eventoRaiz();
        eventoC();
    }
    
    //Etiqueta resultado
    private void agregarEtiquetaResultado(){
        jlResultado = new JLabel();
        jlResultado.setFont(new Font("Arial", 0, 18));
        jlResultado.setHorizontalAlignment(SwingConstants.RIGHT);
         

        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 4;
        c.gridheight = 1;
        
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.CENTER;
        c.insets = new Insets(0, 0, 0, 10);
        c.weightx = 0.5;
        c.weighty = 0.5;

        jPanel.add(jlResultado, c);
    }
    
    //Etiqueta Numero
    private void agregarEtiquetaNumero(){
        jlNumero = new JLabel("0");
        jlNumero.setFont(new Font("Arial", 0, 36));
        jlNumero.setHorizontalAlignment(SwingConstants.RIGHT);
         

        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 4;
        c.gridheight = 1;
        
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.CENTER;
        c.insets = new Insets(0, 0, 0, 10);
        c.weightx = 0.5;
        c.weighty = 0.5;

        jPanel.add(jlNumero, c);
    }
    
    
    //Evento salir del item de la barra de menu
    private void eventoItemSalir(){
        ActionListener evento = new ActionListener(){
          @Override
          public void actionPerformed(ActionEvent e){
              System.exit(0);
          }
        };
        
        jItemSalir.addActionListener(evento);
        
    }
    
    
    
    
    
    //Evento abrir la ventana de divisa
    private void eventoItemDivisa(){
        
        ActionListener evento = new ActionListener(){
          @Override
          public void actionPerformed(ActionEvent e){
              
              //Objeto de la clase divisa
              Divisa divisa = new Divisa();
                
              divisa.setVisible(true);
              dispose();
          }
        };
        
         
        jItemCalDivisa.addActionListener(evento);
        
    }
    
    private void eventoBtn0(){
        
        ActionListener evento = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                
                if(cadenaNumeros != ""){
                    
                    if(jlNumero.getText().equals("0")){
                        cadenaNumeros = "0";
                    }
                    else{
                        cadenaNumeros += 0;
                    }
                    jlNumero.setText(cadenaNumeros);
                    activado = true;
                }
                
            }
        };
       
        btn0.addActionListener(evento);
        
    }
    
    
    private void eventoBtn1(){
        
        ActionListener evento = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(jlNumero.getText().equals("0")){
                    cadenaNumeros = "1";
                }
                else{
                    cadenaNumeros += 1;
                }
                
                jlNumero.setText(cadenaNumeros);
                activado = true;
            }
            
        };
        
        btn1.addActionListener(evento);
      
    }
    
    private void eventoBtn2(){
        
        ActionListener evento = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(jlNumero.getText().equals("0")){
                    cadenaNumeros = "2";
                }
                else{
                    cadenaNumeros += 2;
                }
                
                jlNumero.setText(cadenaNumeros);
                activado = true;

            }
            
        };
        
        btn2.addActionListener(evento);
           
    }
    
    private void eventoBtn3(){
        
        ActionListener evento = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
                if(jlNumero.getText().equals("0")){
                    cadenaNumeros = "3";
                }
                else{
                    cadenaNumeros += 3;
                }
                
                jlNumero.setText(cadenaNumeros);
                activado = true;

            }
        };
        
        btn3.addActionListener(evento);
        
    }
    
    private void eventoBtn4(){

        ActionListener evento = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
                if(jlNumero.getText().equals("0")){
                    cadenaNumeros = "4";
                }
                else{
                    cadenaNumeros += 4;
                }
                
                jlNumero.setText(cadenaNumeros);
                activado = true;

            }
        };        
        
        btn4.addActionListener(evento);
        
    }
    
    private void eventoBtn5(){
        ActionListener evento = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
                if(jlNumero.getText().equals("0")){
                    cadenaNumeros = "5";
                }
                else{
                    cadenaNumeros += 5;
                }
                
                jlNumero.setText(cadenaNumeros);
                activado = true;

            }
        };
        
        btn5.addActionListener(evento);
        
    }
    
    private void eventoBtn6(){
        
        ActionListener evento = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
                if(jlNumero.getText().equals("0")){
                    cadenaNumeros = "6";
                }
                else{
                    cadenaNumeros += 6;
                }
                
                jlNumero.setText(cadenaNumeros);
                activado = true;

            }
        };
        
        btn6.addActionListener(evento);
        
    }
    
    private void eventoBtn7(){
     
        ActionListener evento = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
                if(jlNumero.getText().equals("0")){
                    cadenaNumeros = "7";
                }
                else{
                    cadenaNumeros += 7;
                }
                
                jlNumero.setText(cadenaNumeros);
                activado = true;

            }
        };        
        btn7.addActionListener(evento);
        
    }
    
    private void eventoBtn8(){
        
        ActionListener evento = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
                if(jlNumero.getText().equals("0")){
                    cadenaNumeros = "8";
                }
                else{
                    cadenaNumeros += 8;
                }
                
                jlNumero.setText(cadenaNumeros);
                activado = true;

            }
        };
        
        btn8.addActionListener(evento);
        
    }
    
    private void eventoBtn9(){
        
        ActionListener evento = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
                if(jlNumero.getText().equals("0")){
                    cadenaNumeros = "9";
                }
                else{
                    cadenaNumeros += 9;
                }
                
                jlNumero.setText(cadenaNumeros);
                activado = true;

            }
        };
        
        btn9.addActionListener(evento);
        
    }
    
    private void eventoSuma(){
        
        ActionListener evento = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
                if(activado == true){
                    numero1 = Double.parseDouble(cadenaNumeros);
                    jlResultado.setText(cadenaNumeros+" + ");
                    cadenaNumeros = "";
                    operacion = "sumar";
                    activado = false;
                    punto = true;
                }
                
                
            }
        };
        
        btnSuma.addActionListener(evento);
        
    }
    
    private void eventoIgual(){
       
        ActionListener evento = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                double numero2 = 0;
                
                if(operacion.equals("nula")){
                    jlNumero.setText(cadenaNumeros);
                }
                //Error java.lang.NumberFormatException: empty String. Al pasar una cadena vacia
                else if(operacion.equals("sumar")){
                    numero2 = Double.parseDouble(cadenaNumeros);
                    resultado = numero1 + numero2;
                    jlNumero.setText(String.format("%.2f", resultado));
                    cadenaNumeros = String.valueOf(resultado);
                    operacion = "nula";
                }
                else if(operacion.equals("restar")){
                    numero2 = Double.parseDouble(cadenaNumeros);
                    resultado = numero1 - numero2;
                    jlNumero.setText(String.format("%.2f", resultado));
                    cadenaNumeros = String.valueOf(resultado);
                    operacion = "nula";
                }
                else if(operacion.equals("multiplicar")){
                    numero2 = Double.parseDouble(cadenaNumeros);
                    resultado = numero1 * numero2;
                    jlNumero.setText(String.format("%.2f", resultado));
                    cadenaNumeros = String.valueOf(resultado);
                    operacion = "nula";
                }
                else if(operacion.equals("dividir")){
                    numero2 = Double.parseDouble(cadenaNumeros);
                    resultado = numero1 / numero2;
                    jlNumero.setText(String.format("%.2f", resultado));
                    cadenaNumeros = String.valueOf(resultado);
                    operacion = "nula";
                }
                
                jlResultado.setText("");
                activado = true;                

            }
        };
        
        btnIgual.addActionListener(evento);
    }
    
    private void eventoPunto(){
        
        ActionListener evento = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
                if(punto == true){
                    
                    if(cadenaNumeros == ""){
                        cadenaNumeros = "0.";
                    }
                    else{
                        cadenaNumeros += ".";
                    }
                
                    jlNumero.setText(cadenaNumeros);
                    
                    punto = false;
                }
                
            
            }
        };
        
        btnPunto.addActionListener(evento);
        
    }
    
    private void eventoCambiarSigno(){
      
        ActionListener evento = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
                if(cadenaNumeros.charAt(0)!= '-'){
                    cadenaNumeros = "-"+cadenaNumeros;
                }
                else{
                    cadenaNumeros = cadenaNumeros.substring(1,cadenaNumeros.length());
                }
                
                jlNumero.setText(cadenaNumeros);

            }
        };
        
        btnCambiarSigno.addActionListener(evento);
           
    }
    
    private void eventoBorrar(){
        ActionListener evento = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
                int size = cadenaNumeros.length();
                
                if(size > 0){
                    if(size == 1){
                        cadenaNumeros = "0";
                    }
                    else{
                        cadenaNumeros = cadenaNumeros.substring(0, size-1);
                    }
                    
                    jlNumero.setText(cadenaNumeros);
    
                }
            }
        };
        
        btnBorrar.addActionListener(evento);
        
    }
    
    private void eventoResta(){
        
        ActionListener evento = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
                if(activado == true){
                    numero1 = Double.parseDouble(cadenaNumeros);
                    jlResultado.setText(cadenaNumeros+" - ");
                    cadenaNumeros = "";
                    operacion = "restar";
                    
                    activado = false;
                    punto = true;
                }
                
                
            }
        };
        
        btnResta.addActionListener(evento);
        
    }
    
    private void eventoMultiplicacion(){
        
        ActionListener evento = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
                if(activado == true){
                    numero1 = Double.parseDouble(cadenaNumeros);
                    jlResultado.setText(cadenaNumeros+" * ");
                    cadenaNumeros = "";
                    operacion = "multiplicar";
                    
                    activado = false;
                    punto = true;
                }
                
                
            }
        };
        
        btnMultiplicacion.addActionListener(evento);
        
    }
    
    private void eventoDivision(){
        
        ActionListener evento = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
                if(activado == true){
                    numero1 = Double.parseDouble(cadenaNumeros);
                    jlResultado.setText(cadenaNumeros+" / ");
                    cadenaNumeros = "";
                    operacion = "dividir";
                    
                    activado = false;
                    punto = true;
                }
                
                
            }
        };
        
        btnDivision.addActionListener(evento);
        
    }
    
    private void eventoRaiz(){
        
        ActionListener evento = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                            
                numero1 = Double.parseDouble(cadenaNumeros);
                jlResultado.setText("sqrt("+cadenaNumeros+")");
                cadenaNumeros = "";
                    
                resultado = Math.sqrt(numero1);
                jlNumero.setText(String.format("%.2f", resultado));
                cadenaNumeros = String.valueOf(resultado);
                    
                punto = true;
               
            }
        };
        
        btnRaiz.addActionListener(evento);
        
    }
    
    private void eventoC(){
        
        ActionListener evento = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
                jlResultado.setText("");
                jlNumero.setText("0");
                
                cadenaNumeros = "";
                operacion = "nula";
                numero1 = 0;
                resultado = 0;
                activado = true;
                punto = true;
                            
               
            }
        };
        
        btnC.addActionListener(evento);
        
    }
    
}
