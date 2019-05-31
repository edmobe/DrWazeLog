package connection;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;


//clase que nos permite leer un archivo .pl, asi como escribir en archivos .pl
public class Archivo {

    //lista que nos permite guardar los hechos ya existentes en la base de datos para no borrar ningun hecho al escribir uno nuevo
    LinkedList<String> hechos = new LinkedList<String>();
    String path = "BD2.pl";    

    //metodo que nos permite leer el archivo .pl en donde se encuentra nuestra base de datos 
    //no recibe nada 
    //devuelve la lista de hechos con todos los hechos del archivo .pl
    public void leerArchivo() throws IOException {
        //se crea una variable que nos permite leer el archivo deseado
        BufferedReader lector = new BufferedReader(new FileReader(path));

        // mientras existan datos en el documento este aÃ±adirÃ¡ los hechos uno por uno a la lista
        while (true) {
            String linea_en_texto = lector.readLine();
            if (linea_en_texto == null) {
                break;
            }
            String[] parts = linea_en_texto.split("\n");
            for (String elem : parts) {
                System.out.println(elem);
                hechos.add(elem);
            }
            System.out.println();
        }
        //cierra el lector para no tener ningun error
        lector.close();
    }

    //metodo que nos permite escribir en el archivo .pl
    //no recibe nada 
    //devuelve un archivo escrito a partir de la lista de hechos
    public void escribirArchivo() throws IOException {
        
        //variable que nos permite borrar todo el documento para que no existan hechos dobles o problemas de sobreescritura
        PrintWriter borrar = new PrintWriter(path);
        borrar.print("");
        borrar.close();
        
        //por cada elemento en la lista de hechos, se va escribiendo en el archivo
        BufferedWriter escribir = new BufferedWriter(new FileWriter(path, true));
        for (String elem : hechos) {
            escribir.write(elem);
            escribir.newLine();
        }
        //cierra el escritor para evitar errores
        escribir.close();
    }
    
    //metodo booleano que nos permite verificar si un hecho exite ya en nuestra lista de hechos para no aÃ±adir una copia
    //recibe: el hecho a comparar
    //retorna: -false: si no exite uno igual
    //         -true: si es una copia
    public boolean verificar(String hecho) {
        for (String copiaHecho : hechos) {
            if (hecho.equals(copiaHecho))
                return true;
        }
        return false;
    }

    
    //metodo para anadir un nuevo hechos a la base de datos 
    //rebibe: punto de inicio, punto de destino, costo de llegar
    public void añadir(String inicio, String destino, java.lang.Integer costo, String id1, String id2) throws IOException {
        //lee el archivo
        leerArchivo();
        CorrectNode correctNode = new CorrectNode();
        inicio = correctNode.correctAnswer(inicio);
        destino = correctNode.correctAnswer(destino);
        //crea el nuevo lugar segun la estructura deseada para el archivo .pl
        String nuevoLugar = "camino" + " --> " + "[[" + inicio + "], [" + destino + "], " + costo + ", [\"" + id1 + "\"], [\"" + id2 + "\"]].";
        //verifica que no exita en nuetra base de datos
        boolean exists = verificar(nuevoLugar);
        if (exists)
            System.out.println("Ya existe el lugar");

        else {
            System.out.println("En proceso de añadirlo");
            hechos.addFirst(nuevoLugar);
            escribirArchivo();
            System.out.println("Nuevo lugar añadido");
        }
    }
    

    
}