package Data;

import Domain.Movie;
import Exceptions.ExceptionsDataAccess;
import Exceptions.ExceptionsDataReader;
import Exceptions.ExceptionsDataWriter;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ImplementDataAccess implements DataAccess {

    @Override
    public boolean exists(String FileName) throws ExceptionsDataAccess {
        File file = new File(FileName);
        return file.exists();
    }

    @Override
    public List<Movie> list(String FileName) throws ExceptionsDataReader, IOException {
        var file= new File(FileName);
        List<Movie> list = new ArrayList<>();
        var br= new BufferedReader (new FileReader(file));
        String line=null;
        while ((line= br.readLine())!=null){
            var movie = new Movie(line);
            list.add(movie);
            line=br.readLine();
        }
        return list;
    }

    @Override
    public void write(Movie movie, String FileName, boolean append) throws ExceptionsDataWriter, IOException {
        var file=new File (FileName);
        var bw = new BufferedWriter(new FileWriter(file, append));
        bw.write(movie.getName());
        bw.close();
        System.out.println("The movie: " +movie.getName()+", has been wrote correctly.");
    }

    @Override
    public String search(String FileName, String search) throws ExceptionsDataReader, IOException {
        int i=1;
        var file = new File (FileName);
        var br = new BufferedReader(new FileReader(file));
        String line=null;
        while ((line= br.readLine())!=null){
            if(search!= null && search.equalsIgnoreCase(line)){
                return "The movie "+search+" has been found on line "+i+".";
            }
            line= br.readLine();
            i++;
        }
        br.close();
        return null;
    }

    @Override
    public void create(String FileName) throws ExceptionsDataAccess, IOException {
        var file = new File (FileName);
        var bw = new BufferedWriter(new FileWriter(file));
        bw.close();
        System.out.println("The file has been created correctly.");
    }

    @Override
    public void delete(String FileName) throws ExceptionsDataAccess {
        var file = new File(FileName);
        if (file.exists()) file.delete();
        System.out.println("The file has been deleted correctly.");
    }
}
