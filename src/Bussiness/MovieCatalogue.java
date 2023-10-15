package Bussiness;


import Exceptions.ExceptionsDataAccess;
import Exceptions.ExceptionsDataReader;

import java.io.IOException;

public interface MovieCatalogue {

    String ResourceName="Movies.txt";
    void addMovie (String MovieName) throws ExceptionsDataAccess, IOException;
    void listMovies () throws ExceptionsDataReader, IOException;
    void searchMovie (String search) throws ExceptionsDataReader, IOException;
    void startFile () throws ExceptionsDataAccess, IOException;

}
