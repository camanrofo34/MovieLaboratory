package Bussiness;

import Data.DataAccess;
import Exceptions.ExceptionsDataAccess;
import Exceptions.ExceptionsDataReader;

import java.io.IOException;

public interface MovieCatalogue {

    String ResourceName="Movies.txt";
    public void addMovie (String MovieName) throws ExceptionsDataAccess, IOException;
    public void listMovies () throws ExceptionsDataReader, IOException;
    public void searchMovie (String search) throws ExceptionsDataReader, IOException;
    public void startFile () throws ExceptionsDataAccess, IOException;

}
