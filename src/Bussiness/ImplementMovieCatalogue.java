package Bussiness;

import Data.DataAccess;
import Data.ImplementDataAccess;
import Domain.Movie;
import Exceptions.ExceptionsDataAccess;
import Exceptions.ExceptionsDataReader;

import java.io.IOException;

public class ImplementMovieCatalogue implements MovieCatalogue{
    private DataAccess data;

    public ImplementMovieCatalogue() {
        this.data = new ImplementDataAccess();
    }

    @Override
    public void addMovie(String MovieName) throws ExceptionsDataAccess, IOException {
        Movie movie = new Movie(MovieName);
        boolean append = false;
        append=data.exists(ResourceName);
        data.write(movie, ResourceName,append);
    }

    @Override
    public void listMovies() throws ExceptionsDataReader, IOException {
        var movies =  this.data.list(ResourceName);
        for (var movie:movies){
            System.out.println("Movie: "+movie);
        }
    }

    @Override
    public void searchMovie(String search) throws ExceptionsDataReader, IOException {
        String answer = null;
        answer=this.data.search(ResourceName, search);
        System.out.println("Answer: "+answer);
    }

    @Override
    public void startFile() throws ExceptionsDataAccess, IOException {
        if (this.data.exists(ResourceName)){
            data.delete(ResourceName);
            data.create(ResourceName);
        }
        else data.create(ResourceName);
        System.out.println("File has been started.");
    }
}
