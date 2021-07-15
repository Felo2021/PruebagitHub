package PruebaEldar;

import javax.swing.JOptionPane;
import java.util.*;

public class Tarjeta {


	//Definimos Atributos: 
	String Marca; 
	int nroDeTarjeta; 
	String nombre;
	String apellido;
    int dia; 
    int mes; 
    int año; 
    float Monto;
    float TasaPorServicio;
    
    
    //Constructor: 
    public Tarjeta(String Marca,int nroDeTarjeta,String nombre,String apellido,int dia,int mes,int año,float Monto,float TasaPorServicio) {
    	this.Marca = Marca; 
    	this.nroDeTarjeta = nroDeTarjeta;
    	this.nombre = nombre;
    	this.apellido = apellido; 
    	this.dia = dia; 
    	this.mes = mes; 
    	this.año = año; 
    	this.Monto = Monto;
        this.TasaPorServicio = TasaPorServicio;
    }
  
    public static int IngreseNroDeTarjeta() {
    	int nroDeTarjeta = 0;
    	boolean nroDeTarjetaValidado = true;
    	do {
    	try {
    		do {
    			nroDeTarjeta = Integer.parseInt(JOptionPane.showInputDialog("Ingrese nro de tarjeta:"));
    			if(nroDeTarjeta<=0) JOptionPane.showConfirmDialog(null,"Error.ingrese nuevamente:");
    		}while(nroDeTarjeta<=0);
    		nroDeTarjetaValidado = true;
    	}catch(Exception e) {
    		JOptionPane.showConfirmDialog(null,"Error.ingrese nuevamente:");
    		nroDeTarjetaValidado = false;
    	}
     }while(nroDeTarjetaValidado==false);
     return nroDeTarjeta;	
   
    }	
    	
  
   
    //Función donde ingresamos el nombre del propietario de la tarjeta: 
    public static String IngreseNombrePropietario() {
    	String nombre; 
    	do {
    		nombre = JOptionPane.showInputDialog("Ingrese el nombre del propietario de la tarjeta:");
    		if(nombre.length()<=0) JOptionPane.showConfirmDialog(null,"Error.ingrese nuevamente:");
    	}while(nombre.length()<=0);
    	return nombre;
    }
    public static String IngreseApellidoPropietario() {
    	String apellido; 
    	do {
    		apellido = JOptionPane.showInputDialog("Ingrese el apellido del propietario de la tarjeta:");
    		if(apellido.length()<=0) JOptionPane.showConfirmDialog(null,"Error.ingrese nuevamente:");
    	}while(apellido.length()<=0);
    	return apellido;
    }
    public static int IngreseDia() {
    	int dia;
    	do {
    		dia = Integer.parseInt(JOptionPane.showInputDialog("Ingrese dia:"));
    		if(dia<=0||dia>31) JOptionPane.showConfirmDialog(null,"Error.ingrese nuevamente:");
    	}while(dia<=0||dia>31);
    	return dia;
    }
    public static int IngreseMes() {
    	int mes; 
    	do {
    		mes = Integer.parseInt(JOptionPane.showInputDialog("Ingrese mes:"));
    		if(mes<=0 || mes>31) JOptionPane.showConfirmDialog(null,"Error.ingrese nuevamente:");
    	}while(mes<=0 || mes>31);
    	return mes;
    }
    public static int IngreseAño() {
    	int año; 
    	do {
    		año = Integer.parseInt(JOptionPane.showInputDialog("Ingrese año:"));
    		if(año<=2000) JOptionPane.showConfirmDialog(null,"Error.ingrese nuevamente:");
    	}while(año<=2000);
    	return año; 
    }
    public static float IngreseMonto() {
    	float monto; 
    	do {
    		monto = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el monto de cuanto consume:"));
    		if(monto<=0) JOptionPane.showConfirmDialog(null, "Error.ingrese nuevamente:");
    	}while(monto<=0);
    	return monto;
    }
    public static float AnalizamosTasaVisa(int año,int mes) {
    	float tasaVisa = 0;
    	tasaVisa = año/mes;
    	return tasaVisa;
    }
    
    public static float AnalizamosTasaNara(int dia) {
    	float tasaNara = 0;
    	tasaNara = (float) (dia * 0.5);
    	return tasaNara;
    }
    
    public static float AnalizamosTasaAmex(int mes) {
    	float tasaAmex = 0; 
    	tasaAmex = (float) (mes * 0.1);
    	return tasaAmex;
    }
    public static boolean Identificamos(String Marca,String Marca3) {
    	boolean IgualesONo = true;
        boolean ValidamosTarjeta = Marca.matches(Marca3);
        if(!ValidamosTarjeta) IgualesONo = false;
        if(ValidamosTarjeta==true) IgualesONo = true;
        return IgualesONo;
    }
    public static void main(String args[]) {
    	
    	//Ingresamos los datos de la tarjeta VISA:
    	
    	JOptionPane.showConfirmDialog(null,"Ingrese los datos de la tarjeta VISA");
        String Marca = "VISA";
        int nroDeTarjeta = IngreseNroDeTarjeta();
        String nombre = IngreseNombrePropietario();
        String apellido = IngreseApellidoPropietario();
        int dia = IngreseDia();
        int mes = IngreseMes();
        int año = IngreseAño();
        float Monto = IngreseMonto();
        float tasaVisa = AnalizamosTasaVisa(año,mes);
        
        //Creamos objeto:
        Tarjeta TarjetaVisa = new Tarjeta(Marca,nroDeTarjeta,nombre,apellido,dia,mes,año,Monto,tasaVisa);
       
        String Marca2 = "NARA";
        int nroDeTarjeta2 = 1333242;
        String nombre2 = "Tiago";
        String apellido2 = "Goldar";
        int dia2 = 2; 
        int mes2 = 9;
        int año2 = 2021;
        float Monto2 = 2099;
        float tasaNara = AnalizamosTasaNara(dia); 
        
        //Creamos objeto 2: 
        Tarjeta TarjetaNara = new Tarjeta(Marca2,nroDeTarjeta2,nombre2,apellido2,dia2,mes2,año2,Monto2,tasaNara);
        
        String Marca3 = "AMEX";
        int nroDeTarjeta3 = 12222;
        String nombre3 = "Fernando";
        String apellido3 = "Zavalia";
        int dia3 = 3;
        int mes3 = 3;
        int año3 = 2001; 
        float Monto3 = 2;
        float TasaAmex = AnalizamosTasaAmex(mes3);
        
        //Creamos objeto 3: 
        Tarjeta TarjetaAmex = new Tarjeta(Marca3,nroDeTarjeta3,nombre3,apellido3,dia3,mes3,año3,Monto3,TasaAmex);
        
        TarjetaVisa.Mostramos();
        TarjetaNara.Mostramos();
        TarjetaAmex.Mostramos();
        
        //Identificamos si una tarjeta es distinta de otra; 
        boolean IgualesONo = Identificamos(Marca,Marca2);
        
        if(IgualesONo==true) JOptionPane.showConfirmDialog(null, "La tarjeta "+Marca+" y la tarjeta "+Marca2+" son iguales");
        if(IgualesONo==false) JOptionPane.showConfirmDialog(null,"La tarjeta "+Marca+" y la tarjeta "+Marca2+" no son iguales");
        
    }
    public static boolean VerificamosOperacion(float Monto,String Marca) {
    	System.out.println("Marca:"+Marca);
    	System.out.println("importe:"+Monto);
    	boolean Validacion = false; 
    	if(Monto<1000) Validacion = true;
    	if(Monto>1000) Validacion = false;
    	return Validacion;
    }
    
    public static boolean AnalizamosTarjeta(int dia, int mes, int año) {
    	int diaHoy = 13; 
    	int MesHoy = 7; 
    	int AñoHoy = 2021;
    	boolean ValidamosTarjeta = true;
        if(año<AñoHoy) {
        	ValidamosTarjeta = false;
        }
        if(año==AñoHoy) {
        	if(mes<MesHoy) {
        		ValidamosTarjeta = false;
        	}
        }
        if(año==AñoHoy) {
        	if(mes==MesHoy) {
        		if(dia<diaHoy) {
        			ValidamosTarjeta = false;
        		}
        	}
        }
        return ValidamosTarjeta;
    }
    
    public void Mostramos() {
    	System.out.println("--------------------------------");
    	System.out.println("|      INFORMACIÓN TARJETA      |"); 
    	System.out.println("---------------------------------");
    	System.out.println("nro de tarjeta:"+this.nroDeTarjeta);
    	System.out.println("nombre:"+this.nombre);
    	System.out.println("apellido:"+this.apellido);
    	System.out.println("fecha de vencimiento:"+this.dia+"/"+this.mes+"/"+this.año);
    	boolean Validamos = VerificamosOperacion(this.Monto,this.Marca);
    	if(Validamos==true) System.out.println("No es valida la tarjeta");
    	if(Validamos==false) System.out.println("Es valida la tarjeta");
        boolean ValidaONo = AnalizamosTarjeta(this.dia,this.mes,this.año);
        if(ValidaONo==true) System.out.println("Es valida para realizar una operación");
        if(ValidaONo==false) System.out.println("No es valida para realizar una operación");
        System.out.println("Tasa por servicio:"+this.TasaPorServicio);
    }

}
