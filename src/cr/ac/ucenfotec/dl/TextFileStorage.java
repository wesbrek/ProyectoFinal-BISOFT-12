package cr.ac.ucenfotec.dl;

import java.io.*;
import java.util.ArrayList;

public class TextFileStorage {
    private static final File DAMAS = new File("src/damas.pdn");
    private static final File AJEDREZ = new File("src/ajedrez.pgn");
    private static final File GO = new File("src/go.pgn");

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public TextFileStorage() {

    }

    public void save(String data, File file){
        try {
            FileOutputStream stream = new FileOutputStream(file);
            OutputStreamWriter output = new OutputStreamWriter(stream, "UTF-8");
            BufferedWriter buffer = new BufferedWriter(output);

            buffer.write(data);
            buffer.newLine();

            buffer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveAjedrez(String data){
        save(data, AJEDREZ);
    }

    public void saveDamas(String data){
        save(data, DAMAS);
    }

    public void saveGo(String data){
        save(data, GO);
    }

    public ArrayList<String> load(File file) {
        ArrayList<String> objetos = new ArrayList<String>();

        try {
            FileReader reader = new FileReader(file);
            BufferedReader buffer = new BufferedReader(reader);
            String datos;

            while((datos = buffer.readLine()) != null) {
                objetos.add(datos);
            }
            reader.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
        return objetos;
    }
}
