public class Main {
    public static void main(String[] args) {
        Guarda guarda = new Guarda();
        Ladrao ladrao = new Ladrao();

        guarda.ladrao = ladrao;
        ladrao.guarda = guarda;

        int rodada = 1;
        while (ladrao.vidas > 0 && ladrao.progressoArrombamento < 3) {
            System.out.println("\n=================================");
            System.out.println("--- Rodada " + rodada + " ---");
            
            System.out.println("\n>>> Turno do Guarda <<<");
            guarda.update();
            
            System.out.println("\n>>> Turno do Ladrão <<<");
            ladrao.update();

            System.out.println("\n[Fim da Rodada " + rodada + "] Energia do Guarda: " + guarda.energia + "/10 | Energia do Ladrão: " + ladrao.energia + "/7 | Vidas do Ladrão: " + ladrao.vidas + "/2 | Progresso do Arrombamento: " + ladrao.progressoArrombamento + "/3");

            if (ladrao.vidas <= 0) {
                System.out.println("\n[FIM DE JOGO] O Guarda pegou o vagabundo e o Ladrão perdeu todas as vidas");
                break;
            }
            if (ladrao.progressoArrombamento >= 3) {
                System.out.println("\n[FIM DE JOGO] O Ladrão arrombou a porta e venceu");
                break;
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) { // esse aqui é oq faz o programa esperar 1 segundo entre cada rodada, pra n ficar muito rapido
                e.printStackTrace();
            }
            rodada++;
        }
    }
}