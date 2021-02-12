package lab12_PB;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Arrays;

public class Task {
    public static void main(String[] args) {
    	Actor willSmith = new Actor("Will Smith");
    	Actor tommy = new Actor("Tommy Le Jones");
    	Film menInBlack = new Film("Men in Black", new HashSet<Actor>(Arrays.asList(tommy, willSmith)));
    	
    	willSmith.addFilm(menInBlack);
    	tommy.addFilm(menInBlack);
    	
        Films_DB.addActor(willSmith);
        Films_DB.addActor(tommy);
        Films_DB.addFilm(menInBlack);
        System.out.println(Task3().toString());

    }

    private static boolean Task1() {
        HashSet<Actor> actors = Films_DB.getActors();
        for (Iterator<Actor> it = actors.iterator(); it.hasNext(); ) {
            if (it.next().getFilms().isEmpty())
                return true;
        }
        return false;
    }

    private static HashSet<Actor> Task2(Actor actor) {
        if (actor == null)
            throw new NullPointerException("NULL passed as a parameter");
        HashSet<Actor> actorsToReturn = new HashSet<Actor>();
        HashSet<Film> allFilms = Films_DB.getFilms();
        HashSet<Film> actorsFilms = actor.getFilms();
        
        for (Iterator it1 = allFilms.iterator(); it1.hasNext(); ) {    //searching in films
            Film film = (Film)it1.next();
            if (actorsFilms.contains(film.getName())) {
                for (Iterator it2 = film.getActors().iterator(); it2.hasNext();) {
                    Actor anotherActor = (Actor) it2.next();
                    if (!actorsToReturn.contains(anotherActor) && anotherActor != actor)
                        actorsToReturn.add(anotherActor);
                }
            }
        }

        HashSet<Actor> allActors = Films_DB.getActors();
        for (Iterator it1 = allActors.iterator(); it1.hasNext(); ) {    //searching in actors
            Actor anotherActor = (Actor)it1.next();
            for (Iterator it2 = anotherActor.getFilms().iterator(); it2.hasNext(); ) {
                Film film = (Film)it2.next();
                if ( anotherActor.getName() != actor.getName() && actor.getFilms().contains(film)
                     && !actorsToReturn.contains(anotherActor.getName()))
                    actorsToReturn.add(anotherActor);
            }
        }
        return actorsToReturn;
    }

    private static Film Task3() {
        HashSet<Film> allFilms = Films_DB.getFilms();
        if (allFilms.size() == 0)
            throw new IllegalStateException("There is no films in the database");

        Film theBiggestFilm = null;
        int maxActors = -1;
        for (Film film : allFilms) {
            if (film.getActors().size() > maxActors) {
                maxActors = film.getActors().size();
                theBiggestFilm = film;
            }
        }
        return theBiggestFilm;
    }
}