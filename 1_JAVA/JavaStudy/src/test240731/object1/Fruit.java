package test240731.object1;

import java.util.Objects;

public class Fruit extends Farm{
	private String name;

	public Fruit() {
		super();
	}

	public Fruit(String kind, String name) {
		super(kind);
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return this.getKind() + " : " + name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.getKind(),name);
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Fruit) {
			return (this.name.equals(((Fruit)obj).getName()) &&
					this.getKind().equals(((Fruit)obj).getKind()) );
		}
		return false;
	}
	
	
}
