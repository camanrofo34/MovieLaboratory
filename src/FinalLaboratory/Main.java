package FinalLaboratory;

import Bussiness.ImplementMovieCatalogue;
import Bussiness.MovieCatalogue;
import Exceptions.ExceptionsDataAccess;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    static int option=-1;
    static String FileName;
    static MovieCatalogue moviecatalogue=new ImplementMovieCatalogue();

    public static void main (String[] args) throws ExceptionsDataAccess, IOException {
        Scanner scn=new Scanner(System.in);
        while (option!=0){
            System.out.println("Choose an option:\n1. Start Movie Catalogue\n2.Add a Movie\n3.List a Movie\n4.Search a Movie\n0.Exit");
            option=scn.nextInt();
            scn.nextLine();
            switch (option){
                case 1:
                    moviecatalogue.startFile();
                    break;
                case 2:
                    System.out.println("Write the name of the movie to add: ");
                    String MovieName = scn.nextLine();
                    moviecatalogue.addMovie(MovieName);
                    break;
                case 3:
                    moviecatalogue.listMovies();
                    break;
                case 4:
                    System.out.println("Write the name of the movie to search: ");
                    String MovieSearch = scn.nextLine();
                    moviecatalogue.searchMovie(MovieSearch);
                    break;
                case 0:
                    System.out.println("See you soon.");
                    break;
                default:
                    System.out.println("Not recognized option.");
                    break;
            }
        }
    }
}
