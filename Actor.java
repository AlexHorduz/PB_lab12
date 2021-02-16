package lab12_PB;

import java.util.HashSet;

public class Actor {
    private final String name;
    private HashSet<Film> films;
    
    public Actor(String name) {
        this.name = name;
        this.films = new HashSet<Film>();
    }

    public String getName() {
        return this.name;
    }

    public HashSet<Film> getFilms() {
        return (HashSet<Film>) this.films.clone();
    }

    public void addFilm(Film film) {
        this.films.add(film);
    }

    @Override
    public int hashCode()
    {
    	final int prime = 17;
		int result = 1;
		result = prime * result + name.hashCode();
		result = prime * result + films.hashCode();
		return result;
    }
    
    @Override
    public boolean equals(Object o) {
    	if (this == o) {
    		return true;
    	}
    	
    	if (o == null || getClass() != o.getClass()){ 
    		return false;
    	}
    	
    	Actor other = (Actor) o;
    	
    	return other.hashCode() == hashCode();
    }
    
    @Override 
    public String toString() {
    	return this.name;
    }
    
    

}
