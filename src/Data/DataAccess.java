package Data;

import Domain.Movie;
import Exceptions.ExceptionsDataAccess;
import Exceptions.ExceptionsDataReader;
import Exceptions.ExceptionsDataWriter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface DataAccess {
    public boolean exists (String FileName) throws ExceptionsDataAccess;

    public List<Movie> list (String Name) throws ExceptionsDataReader, IOException;

    public void write (Movie movie,String FileName, boolean append) throws ExceptionsDataWriter, IOException;

    public String search (String FileName,String search) throws ExceptionsDataReader, IOException;
        public void create (String FileName) throws ExceptionsDataAccess, IOException;

    public void delete (String FileName) throws ExceptionsDataAccess;
}
