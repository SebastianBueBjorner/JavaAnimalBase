import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;


public class AnimalBase {
    private ArrayList<Animal> animals;

    public AnimalBase() {
        animals = new ArrayList<>();
    }

    public void start() {
        UserInterface ui = new UserInterface(this);

        //TODO REMOVE LATER
        createNewAnimal("Bertil", "sleepy", "bull", 7);
        createNewAnimal("Abelone", "large", "elephant", 7);
        createNewAnimal("Crystal", "shiny", "turtle", 9);

        ui.start();
    }

    public static void main(String[] args) {
        AnimalBase app = new AnimalBase();
        app.start();
    }

    public Iterable<Animal> getAllAnimals() {
        return animals;
    }

    private Comparator<Animal> nameCom = new Comparator<Animal>() {
        @Override
        public int compare(Animal o1, Animal o2) {
            if(o1.getName().compareTo(o2.getName()) <=0) {
                return -1;
            } else {
                return 1;
            }
        }
    };

    private Comparator<Animal> typeCom = new Comparator<Animal>() {
        @Override
        public int compare(Animal o1, Animal o2) {
            if(o1.getType().compareTo(o2.getType()) <=0) {
                return -1;
            } else {
                return 1;
            }
        }
    };

    private Comparator<Animal> ageCom = new Comparator<Animal>() {
        @Override
        public int compare(Animal o1, Animal o2) {
            if(o1.getAge() < o2.getAge()) {
                return -1;
            } else {
                return 1;
            }
        }
    };


    public void sortBy(String sort) {
        // TODO: Implement sorting!
        System.out.println("TODO: Sort the list of animals by: " + sort);

        if (sort.contains("name")) {
            Collections.sort(animals, nameCom);

        } else if (sort.contains("type")) {
            Collections.sort(animals, typeCom);

        } else if (sort.contains("age")) {
            Collections.sort(animals, ageCom);

        }


    }

    public void createNewAnimal(String name, String description, String type, int age) {
        Animal animal = new Animal(name,description,type,age);
        animals.add(animal);
    }

    public void deleteAnimal(String name) throws NonExistingAnimalException {
        // find animal with this name
        Animal animal = findAnimalByName(name);
        if(animal == null) {
            throw new NonExistingAnimalException();
        } else {
            animals.remove(animal);
        }
    }

    private Animal findAnimalByName(String name) {
        for(Animal animal : animals) {
            if(animal.getName().equalsIgnoreCase(name)) {
                return animal;
            }
        }
        return null;
    }


    public void loadDatabase() {
        System.err.println("LOAD not yet implemented!");
    }

    public void saveDatabase() {
        System.err.println("SAVE not yet implemented!");
    }

}
