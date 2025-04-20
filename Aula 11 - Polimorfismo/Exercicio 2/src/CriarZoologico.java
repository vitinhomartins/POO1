import java.util.Random;

public class CriarZoologico {
    Random random = new Random();
    public Animal criarZoo() {
        Animal animal = null;
        int codigo = random.nextInt(200);
        if(codigo >= 0 && codigo <= 50) {
            animal = new Animal();
        } else if(codigo > 50 && codigo <= 100) {
            animal = new Cachorro();
        } else if(codigo > 100 && codigo <= 150) {
            animal = new Gato();
        } else if(codigo > 150 && codigo <= 200) {
            animal = new Preguiça();
        }
        return animal;
    }
}
