public class TesteCompositor {
    public static void main(String[] args) {
        Compositor compositor1 = new Compositor();
        Compositor[] compositor2 = new Compositor[2];
        compositor2[0] = new Compositor();
        compositor2[1] = new Compositor();

        System.out.println(compositor1.nomeCompositor() + " " + compositor1.codigoCompositor());
        compositor2[0].setNome("Vitinho");
        compositor2[0].setCodigo("Melodia");
        System.out.println(compositor2[0].nomeCompositor() + " " + compositor2[0].codigoCompositor());
        compositor2[1].setNome("Manuu");
        compositor2[1].setCodigo("Shoegaze");
        System.out.println(compositor2[1].nomeCompositor() + " " + compositor2[1].codigoCompositor());
    }
}
