package lab12_PB;

import java.util.HashSet;

public class Films_DB {
    private static HashSet<Film> films = new HashSet<Film>();
    private static HashSet<Actor> actors = new HashSet<Actor>();

    private Films_DB() {
    }

    public static void addFilm(Film film) {
        films.add(film);
    }

    public static boolean removeFilm(Film film) {
        return films.remove(film);
    }

    public static void addActor(Actor actor) {
        actors.add(actor);
    }

    public static boolean removeActor(Actor actor) {
        return actors.remove(actor);
    }

    public static HashSet<Film> getFilms() {
        return (HashSet<Film>) films.clone();
    }

    public static HashSet<Actor> getActors() {
        return (HashSet<Actor>) actors.clone();
    }
} 