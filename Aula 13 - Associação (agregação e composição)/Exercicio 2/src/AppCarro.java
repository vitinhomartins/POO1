public class AppCarro {
    public static void main(String[] args) {
        Bancos bancos1 = new Bancos("Ford");
        Bancos bancos2 = new Bancos("BMW");
        Bancos bancos3 = new Bancos("Mercedes-Benz");
        Motor m1 = new Motor("3.8L V6");
        Carro c1 = new Carro("Mustang", "Conversível", "Ford", m1, bancos1);

        Motor m2 = new Motor("COOPER");
        Carro c2 = new Carro("MINI", "COOPER SE", "BMW", m2, bancos2);

        Motor m3 = new Motor("Mercedes-Benz");
        Carro c3 = new Carro("Merdeces-EQ", "EQA 250", "Mercedes-Benz", m3, bancos3);

        System.out.println(c1.getFabricante() + " " + c1.getMarca() + " " + c1.getModelo() + " " + c1.getMotor() + " " + c1.getBancos());
        System.out.println(c2.getFabricante() + " " + c2.getMarca() + " " + c2.getModelo() + " " + c2.getMotor() + " " + c2.getBancos());
        System.out.println(c3.getFabricante() + " " + c3.getMarca() + " " + c3.getModelo() + " " + c3.getMotor() + " " + c3.getBancos());

    }
}
