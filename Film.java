package lab12_PB;

import java.util.HashSet;

public class Film {
    private final String name;
    private final HashSet<Actor> actors;

    public Film(String name, HashSet<Actor> actors) {
        this.name = name;
        this.actors = actors;
    }

    public String getName() {
        return this.name;
    }

    public HashSet<Actor> getActors() {
        return (HashSet<Actor>) this.actors.clone();
    }

    
    @Override
    public int hashCode()
    {
    	final int prime = 17;
		int result = 1;
		result = prime * result + name.hashCode();
		result = prime * result + actors.hashCode();
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
    	
    	Film other = (Film) o;
    	
    	return other.hashCode() == hashCode();
    }
    
    @Override
    public String toString() {
    	return "\"" + this.name +  "\"" + " Actors: " + this.actors.toString();
    }
    
}
