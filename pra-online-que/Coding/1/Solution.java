import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<DC> movies = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            int movieId = sc.nextInt();
            sc.nextLine();
            String movieName = sc.nextLine();
            double budget = sc.nextDouble();
            sc.nextLine();
            double boxOffice = sc.nextDouble();
            sc.nextLine();
            int rating = sc.nextInt();
            movies.add(new DC(movieId, movieName, budget, boxOffice, rating));
        }
        double searchBoxOffice = sc.nextDouble();
        double averageBudget = getAverageBudget(movies);
        if (averageBudget > 0) {
            System.out.println(averageBudget);
        } else {
            System.out.println("No Budget");
        }

        ArrayList<DC> ans = searchMovieByBoxOffice(movies, searchBoxOffice);
        if (ans.isEmpty()) {
            System.out.println("No Such Movies");
        } else {
            for (DC obj : ans) {
                System.out.println(obj.getMovieId());
            }
        }
    }

    public static double getAverageBudget(ArrayList<DC> movies) {
        double sum = 0;
        for (DC obj : movies) {
            sum = sum + obj.getBudget();
        }
        double average = sum / movies.size();
        return average;
    }

    public static ArrayList<DC> searchMovieByBoxOffice(ArrayList<DC> movies, double searchBoxOffice) {
        ArrayList<DC> ans = new ArrayList<>();
        for (DC obj : movies) {
            if (obj.getBoxOffice() < searchBoxOffice) {
                ans.add(obj);
            }
        }
        Collections.sort(ans, Comparator.comparing(DC::getBoxOffice).reversed());
        // ans.sort((a, b) -> Double.compare(a.getBoxOffice(), b.getBoxOffice()));
        // Collections.reverse(ans);
        return ans;
    }
}

class DC {
    private int movieId;
    private String movieName;
    private double budget;
    private double boxOffice;
    private int rating;

    DC(int movieId, String movieName, double budget, double boxOffice, int rating) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.budget = budget;
        this.boxOffice = boxOffice;
        this.rating = rating;
    }

    public int getRating() {
        return this.rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getMovieId() {
        return this.movieId;
    }

    public String getMovieName() {
        return this.movieName;
    }

    public double getBudget() {
        return this.budget;
    }

    public double getBoxOffice() {
        return this.boxOffice;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public void setBoxOffice(double boxOffice) {
        this.boxOffice = boxOffice;
    }
}
