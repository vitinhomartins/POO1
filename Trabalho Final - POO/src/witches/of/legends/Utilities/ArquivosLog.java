package witches.of.legends.Utilities;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ArquivosLog implements BattleLogger {
    private BufferedWriter writer;

    public ArquivosLog(String nomeArquivo) {
        try {
            writer = new BufferedWriter(new FileWriter(nomeArquivo, false));
            writer.write("--- INÍCIO DO ARQUIVO ---\n");
        } catch (IOException e) {
            System.out.println("Erro ao tentar criar o arquivo: " + e.getMessage());
        }
    }

    @Override
    public void log(String mensagem) {
        try {
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
            writer.write("[Horário: " + timestamp + "] " + mensagem + "\n");
        } catch (IOException e) {
            System.out.println("Erro ao tentar escrever no arquivo: " + e.getMessage());
        }
    }

    @Override
    public void encerrarArquivo() {
        try {
            writer.write("--- FIM DO ARQUIVO ---\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("Erro ao fechar o log: " + e.getMessage());
        }
    }
}
