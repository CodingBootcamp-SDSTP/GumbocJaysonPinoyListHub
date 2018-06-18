import java.util.ArrayList;

public class PersonCollection
{
	ArrayList<Person> persons;

	public PersonCollection() {
		persons = new ArrayList<Person>();
	}

	public void addPerson(Person person) {
		persons.add(person);
	}

	public void removePerson(Person person) {
		persons.remove(person);
	}

	public ArrayList<Person> getAllPersons() {
		return(persons);
	}

	public Person getPersonByIndex(int n) {
		return persons.get(n);
	}

	public int getPersonCount() {
		return persons.size();
	}

	public Person getPersonById(String id) {
		Person person = null;
		for (int i=0; i<getPersonCount(); i++) {
			if (getPersonByIndex(i).getId().equalsIgnoreCase(id)) {
				person = getPersonByIndex(i);
			}
		}
		return(person);
	}
}
