public class TesteClientes {
    public static void main(String[] args) {
        Cliente c[] = new Cliente[2];
        c[0] = new Cliente("Vitinho", 1200, 1500);
        c[1] = new ClienteEspecial("Manuela", 1200, 1500);
        System.out.println(c[0].toString());
        System.out.println(c[1].toString());
    }
}

// Os métodos que sofreram polimorfismo foram os toString.
