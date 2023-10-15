package Data;
import Domain.Movie;
import Exceptions.ExceptionsDataAccess;
import Exceptions.ExceptionsDataReader;
import Exceptions.ExceptionsDataWriter;
import java.io.IOException;
import java.util.List;
public interface DataAccess {
    boolean exists (String FileName) throws ExceptionsDataAccess;
    List<Movie> list (String Name) throws ExceptionsDataReader, IOException;
    void write (Movie movie,String FileName, boolean append) throws ExceptionsDataWriter, IOException;
    String search (String FileName,String search) throws ExceptionsDataReader, IOException;
    void create (String FileName) throws ExceptionsDataAccess, IOException;
    void delete (String FileName) throws ExceptionsDataAccess;
}
