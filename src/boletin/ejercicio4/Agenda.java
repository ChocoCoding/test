package boletin.ejercicio4;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Agenda {
    private String file;

    public Agenda(){
        file = "C:\\Users\\34645\\IdeaProjects\\ManejoDeArchivosJava\\src\\boletin\\ejercicio4\\contacto.txt";
    }

    public void anhadirContacto(Contacto contacto){
        List<Contacto> contactos = leerContactos();
        contactos.add(contacto);
        guardarContactos(contactos);
    }

    public List<Contacto> listarContactos(){
        return leerContactos();
    }

    public Contacto buscarContacto(String nombre){
        List<Contacto> contactos = leerContactos();
        for (Contacto contacto: contactos) {
            if (contacto.getNombre().equalsIgnoreCase(nombre)){
                System.out.println("Contacto encontrado: ");
                return contacto;
            }
        }
        System.out.println("No se pudo encontrar el contacto");
        return null;
    }

    public void eliminarContacto(String nombre){
        List<Contacto> contactos = leerContactos();

        for (Contacto contacto: contactos) {
            if (contacto.getNombre().equalsIgnoreCase(nombre)){
                contactos.remove(contacto);
                System.out.println("Se ha eliminado el contacto: " + contacto.getNombre());
                break;
            }
        }
        guardarContactos(contactos);
    }

    /**
     * Metodo que guarda los contactos en el archivo
     * @param contactos
     */
    private void guardarContactos(List<Contacto> contactos) {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            for (Contacto contacto: contactos) {
                oos.writeObject(contacto);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private List<Contacto> leerContactos() {
        List<Contacto> contactos = new ArrayList<>();
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            while(true){
             try {
                 Contacto contacto = (Contacto) ois.readObject();
                 contactos.add(contacto);
             } catch (EOFException e) {
                 break;
             }
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
       return contactos;
    }



}
