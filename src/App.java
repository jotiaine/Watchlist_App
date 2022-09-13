import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;

public class App {
        // Vars
        private Scanner input;
        private String userName;
        private int userChoice;
        
        // Files
        private File moviesWatchlist = new File("moviesWatchlist.txt");
        private File seriesWatchlist = new File("seriesWatchlist.txt");
        
        
        
        // File writers and reader
        private FileWriter movieWriter;
        private FileWriter seriesWriter;
        private Scanner moviesReader;
        private Scanner seriesReader;

        public static void main(String[] args) throws Exception {
                
                try {
                        // Vars
                        App app = new App();
                        Scanner input = app.input;
                        input = new Scanner(System.in);
                        String userName = app.userName;
                        int userChoice = app.userChoice;
                        File moviesWatchlist = app.moviesWatchlist;
                        File seriesWatchlist = app.seriesWatchlist;
                        FileWriter movieWriter = app.movieWriter;
                        FileWriter seriesWriter = app.seriesWriter;
                        Scanner moviesReader = app.moviesReader;
                        Scanner seriesReader = app.seriesReader;

                        // Checking if files exits and creating them if they don't
                        checkFileExists(app.moviesWatchlist);
                        checkFileExists(app.seriesWatchlist);

                        // 1. Welcome the user and ask for their name
                        System.out.println();
                        System.out.println("Welcome to the to watch app!");
                        System.out.println("Here you can save your favorite shows!");
                        System.out.println();
                        System.out.println("Enter your name:");
                        userName = input.nextLine();

                        for (int i = 0; i < 50; i++) {
                                System.out.println();
                        }

                        // 2. Loop the menu until the user chooses to exit
                        while (true) {
                                System.out.println();
                                System.out.println("Hello " + userName + "!");
                                System.out.println();
                                System.out.println("1) Add a movie to your watchlist");
                                System.out.println("2) Add a series to your watchlist");
                                System.out.println("3) Print your movies watchlist");
                                System.out.println("4) Print your series watchlist");
                                System.out.println("5) Delete watchlists");
                                System.out.println("6) Quit the program");
                                System.out.println();
                                System.out.println("Enter your choice:");
                                userChoice = input.nextInt();

                                for (int i = 0; i < 50; i++) {
                                        System.out.println();
                                }

                                if (userChoice == 1) {
                                        Movie newMovie = new Movie();
                                        input.nextLine();
                                        System.out.println("Enter the title of the movie:");
                                        newMovie.setTitle(input.nextLine());
                                        System.out.println("What year is the movie published:");
                                        newMovie.setPublishYear(input.nextInt());
                                        input.nextLine();
                                        System.out.println("Enter the length of the movie in minutes:");
                                        newMovie.setMovieLengthMin(input.nextInt());
                                        input.nextLine();
                                        System.out.println("Enter the director/directors of the movie:");
                                        newMovie.setDirectors(input.nextLine());
                                        System.out.println("Enter the actors/actresses of the movie:");
                                        newMovie.setActors(input.nextLine());

                                        movieWriter = new FileWriter(moviesWatchlist, true);
                                        movieWriter.write("Title: " +
                                                        newMovie.getTitle() + "\n"
                                                        + "Published: " + newMovie.getPublishYear() + "\n" + "Directors: "
                                                        + newMovie.getDirectors() + "\n" + "Actors: " + newMovie.getActors() + "\n" + "Length: "
                                                        + newMovie.getMovieLengthMin() + "\n" + "-----------------------" + "\n");
                                        System.out.println("Movie saved succesfully!");
                                        System.out.println();
                                        movieWriter.close();

                                } else if (userChoice == 2) {
                                        Series newSeries = new Series();
                                        input.nextLine();
                                        System.out.println("Enter the title of the series:");
                                        newSeries.setTitle(input.nextLine());
                                        System.out.println("What year is the series published:");
                                        newSeries.setPublishYear(input.nextInt());
                                        input.nextLine();
                                        System.out.println("How many seasons there are in the series:");
                                        newSeries.setSeasons(input.nextInt());
                                        input.nextLine();
                                        System.out.println("Enter the director/directors of the series:");
                                        newSeries.setDirectors(input.nextLine());
                                        System.out.println("Enter the actors/actresses of the movie:");
                                        newSeries.setActors(input.nextLine());

                                        seriesWriter = new FileWriter(seriesWatchlist, true);
                                        seriesWriter.write("Title: " +
                                                        newSeries.getTitle() + "\n"
                                                        + "Published: " + newSeries.getPublishYear() + "\n" + "Directors: "
                                                        + newSeries.getDirectors() + "\n" + "Actors: " + newSeries.getActors() + "\n" + "Seasons: "
                                                        + newSeries.getSeasons() + "\n" + "-------------" + "\n");
                                        System.out.println("Series saved succesfully!");
                                        System.out.println();
                                        seriesWriter.close();
                                } else if (userChoice == 3) {
                                        System.out.println("*******************");
                                        System.out.println(userName + "'s' Movies watchlist:");
                                        System.out.println("*******************");
                                        moviesReader = new Scanner(moviesWatchlist);
                                        System.out.println();
                                        while (moviesReader.hasNextLine()) {
                                                System.out.println(moviesReader.nextLine());
                                        }
                                        moviesReader.close();
                                } else if (userChoice == 4) {
                                        System.out.println("*******************");
                                        System.out.println(userName + "'s' Series watchlist:");
                                        System.out.println("*******************");
                                        seriesReader = new Scanner(seriesWatchlist);
                                        System.out.println();
                                        while (seriesReader.hasNextLine()) {
                                                System.out.println(seriesReader.nextLine());
                                        }
                                        seriesReader.close();
                                } else if (userChoice == 5) {
                                        moviesWatchlist.delete();
                                        seriesWatchlist.delete();
                                        System.out.println("Watchlists deleted succesfully!");
                                } else if (userChoice == 6) {
                                        System.out.println("Goodbye!");
                                        input.close();
                                        break;
                                } else {
                                        System.out.println("Invalid choice!");
                                }
                        }

                } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                } finally {
                        System.out.println("Program ended!");
                }
        }

        public static void checkFileExists(File filename) {
                try {
                        if (filename.exists()) {
                                App app = new App();
                                app.input = new Scanner(System.in);
                                System.out.println(filename.getAbsolutePath() + " file exists");
                                System.out.println("Do you want to overwrite the file? (y/n)");
                                String userInput = app.input.nextLine();
                                if (userInput.equals("y") || userInput.equals("Y")) {
                                        filename.delete();
                                        filename.createNewFile();
                                        System.out.println("Start adding movies!");
                                } else {
                                        System.out.println("Start adding movies!");
                                }
                        } else {
                                filename.createNewFile();
                                System.out.println("File" + filename.getName() + " created succesfully!");
                        }
                } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                }
        }
}
