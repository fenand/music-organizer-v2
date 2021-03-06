import java.util.ArrayList;

/**
 * A class to hold details of audio files.
 * This version can play the files.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2011.07.31
 */
public class MusicOrganizer
{
    // An ArrayList for storing the file names of music files.
    private ArrayList<String> files;
    // A player for the music files.
    private MusicPlayer player;

    /**
     * Create a MusicOrganizer
     */
    public MusicOrganizer()
    {
        files = new ArrayList<String>();
        player = new MusicPlayer();
    }

    /**
     * Add a file to the collection.
     * @param filename The file to be added.
     */
    public void addFile(String filename)
    {
        files.add(filename);
    }

    /**
     * Return the number of files in the collection.
     * @return The number of files in the collection.
     */
    public int getNumberOfFiles()
    {
        return files.size();
    }

    /**
     * List a file from the collection.
     * @param index The index of the file to be listed.
     */
    public void listFile(int index)
    {
        if(index >= 0 && index < files.size()) {
            String filename = files.get(index);
            System.out.println(filename);
        }
    }

    /**
     * Remove a file from the collection.
     * @param index The index of the file to be removed.
     */
    public void removeFile(int index)
    {
        if(index >= 0 && index < files.size()) {
            files.remove(index);
        }
    }

    /**
     * Start playing a file in the collection.
     * Use stopPlaying() to stop it playing.
     * @param index The index of the file to be played.
     */
    public void startPlaying(int index)
    {
        String filename = files.get(index);
        player.startPlaying(filename);
    }

    /**
     * Stop the player.
     */
    public void stopPlaying()
    {
        player.stop();
    }

    /**
     * Metodo para imprimir la coleccion entera de files
     */

    public void listAllFiles(){
        int posicion = 1;
        for(String filename : files){
            System.out.println(posicion + ": " + filename);
            posicion++;
        }
    }

    /**
     * Metodo para enumerar unicamente los archios que se corresponden 
     * con el criterio de busqueda
     */

    public void listMatching(String criterioDeBusqueda){
        boolean criterio = false;
        for(String filename : files){
            if(filename.contains(criterioDeBusqueda)){
                System.out.println(filename);
                criterio = true;
            }
        }
        if(criterio == false){
            System.out.println("No existe nada con ese criterio de busqueda");
        }
    }

    /**
     * reproducir los primeros 15 seg de las canciones del artista segun el criterio de busqueda
     */

    public void playAndWait(String criterioDeBusqueda){
        boolean criterio = false;
        for(String filename : files){
            if(filename.contains(criterioDeBusqueda)){
                player.playSample(filename);
                criterio = true;
            }
        }
        if(criterio == false){
            System.out.println("No existe nada con ese criterio de busqueda");
        }
    }

    /**
     * Localizar el �ndice del primer archivo que se corresponde con
     * la cadena de b�squeda indicada.
     * @param searchString La cadena que hay que buscar.
     * @return El �ndice de la primera aparici�n, es decir -1 si
     * no se encuentra ninguna correspondencia.
     */
    public int findFirst(String searchString) {
        
        int numeroTotalDeFiles = files.size();
        int index = 0;
        boolean searching = true;

        while(searching == true && index < numeroTotalDeFiles ) {
            String filename = files.get(index);
            if(filename.contains(searchString)) {
                searching = false;
            }
            else {
                index++;
            }
        }

        if(searching == true) {
            index = -1;
        }

        return index;
    }
}
