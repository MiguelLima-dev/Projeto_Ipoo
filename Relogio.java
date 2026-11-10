/**
 * Essa classe é utilizada para controlar a passagem de tempo no jogo
 */
public class Relogio {
    // quantos tiques valem um minuto
    private static final int tiquesPorMinuto = 60;
    // hora do relogio
    private int horas;
    // minuto do relogio
    private int minutos;
    // minutos passados
    private int minutosPassados;
    // quantidade de tiques do relogio
    private int tiquesRelogio;

    /**
     * Cria um relogio, com hora e minutos iniciais passados
     * @param horaInicial a hora inicial do relogio
     * @param minutoInicial o minuto inicial do relogio
     */
    public Relogio(int horaInicial, int minutoInicial) {
        horas = horaInicial;
        minutos = minutoInicial;
        minutosPassados = 0;
        tiquesRelogio = 0;
    }

    /**
     * Incrementa a contagem de tempo (tiques) atualizando horas e minutos.
     */
    private void passaTempo() {
        //incrementa o contador de tiques
        tiquesRelogio++;

        //a cada 60 tiques avanca 1 minuto
        if (tiquesRelogio >= tiquesPorMinuto) {
            minutos++;
            minutosPassados++;
            tiquesRelogio = 0;

            // A cada 60 minutos avanca 1 hora
            if (minutos >= 60) {
                minutos = 0;
                horas = (horas + 1) % 24;
            }
        }
    }

    /**
     * Retorna a hora no formato:
     *      Horário - HH:MM
     */
    public String obterHorario() {
        return "Horário - " + String.format("%02d:%02d", horas, minutos);
    }

    /**
     * Retorna quantos minutos se passaram
     */
    public int obterMinutosPassados() {
        return minutosPassados;
    }
}