package controller;

import java.awt.Color;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.regex.Pattern;
import view.TelaServidor;

/**
 *
 * @author Gian
 */
public class Processador {

    private DatagramSocket datagramSocket = null;
    DatagramPacket datagramPacket = null;
    int portaServidor = 0;
    TelaServidor telaServidor;
    byte[] tamanhoPacote = null;
    
    private boolean servidorLigado = true;

    public Processador(int porta, TelaServidor view) {
        this.portaServidor = porta;
        this.telaServidor = view;
        estabelecerConexao();
    }

    /**
     *  Método responsável por criar o socket na porta desejada 
     * e inicializar a thread de recebimento.
     */
    private void estabelecerConexao() {
        try {
            this.datagramSocket = new DatagramSocket(this.portaServidor);
            gravarLog("----------\nSocket criado na porta " + portaServidor + "\n", Color.blue);
        } catch (SocketException ex) {
            gravarLog("Não foi possível criar o Socket. Mensagem de erro: " + ex.getMessage() + "\n", Color.red);
            return;
        }
        getReceberMensagem().start();
    }

    /**
     * Thread responsável por receber as mensagens no servidor.
     */
    private Thread receberMensagem = new Thread() {

        @Override
        public void run() {
            super.run();
            gravarLog("A thread de recebimento de mensagens foi inicializada.\n", Color.blue);
            while (servidorLigado) {
                try {
                    tamanhoPacote = new byte[1024];
                    datagramPacket = new DatagramPacket(tamanhoPacote, tamanhoPacote.length);
                    getDatagramSocket().receive(datagramPacket);
                    String conteudoRecebido = new String(datagramPacket.getData());
                    gravarLog("Mensagem RECEBIDA = " + conteudoRecebido.trim() + "\n", Color.darkGray);

                    //tratarPacote(conteudoRecebido, datagramPacket.getAddress(), datagramPacket.getPort());
                    
                    //-- Implementação de ECO
                    enviarMensagem(conteudoRecebido.toUpperCase(), datagramPacket.getAddress(), datagramPacket.getPort());
                    //-- fim ECO
                } catch (IOException ex) {
//                    gravarLog("Problema durante o recebimento de mensagens (Thread).\n"
//                            + "Mensagem de erro: " + ex.getMessage() + "\n", Color.red);
                }
            }
        }
    };
    
    /**
     * Método responsável por verificar a requisição do pacote e direcionar para o método específico.
     * @param mensagem recebido no pacote e já convertido de bytes para String
     * @param enderecoOrigem endereço que fez a requisição.
     * @param portaOrigem porta que a requisição veio.
     */
    private void tratarPacote(String mensagem,InetAddress enderecoOrigem, int portaOrigem) {
        String[] mensagemParticionada = mensagem.trim().split(Pattern.quote("#"));
        
        if(mensagemParticionada[1].equals("nome da tabela")) {
            // metodos relacionados a tabela
        } else if(mensagemParticionada[1].equals("nome da tabela 2")) {
            // metodos relacionados a tabela 2
        } else if(mensagemParticionada[1].equals("nome da tabela 3")) {
            // metodos relacionados a tabela 3
        } else {
            // se nenhum pacote corresponder às regras acima, deve cair aqui
            // e ser ignorado.
        }
    }

    /**
     * Método responsável por enviar a mensagem para o destino selecionado.
     * @param mensagem mensagem em texto puro que será enviada.
     * @param ipDestino ip do destino da mensagem.
     * @param portaDestino porta de destino da mensagem.
     */
    private void enviarMensagem(String mensagem, InetAddress ipDestino, int portaDestino) {
        try {
            this.datagramPacket = new DatagramPacket(mensagem.getBytes(), mensagem.length(), ipDestino, portaDestino);
            this.getDatagramSocket().send(datagramPacket);
            gravarLog("Mensagem ENVIADA: " + mensagem + "\n", Color.black);
        } catch (IOException ex) {
            gravarLog("Falha ao enviar mensagem para " + ipDestino + ":" + portaDestino + ".\n"
                    + "Mensagem: " + mensagem + "\n"
                    + "Mensagem de erro: " + ex.getMessage() + "\n", Color.RED);
        } finally {
            this.datagramPacket = new DatagramPacket(tamanhoPacote, tamanhoPacote.length);
        }
    }

    /**
     * Método que grava na interface os logs que são passados.
     * @param mensagem Mensagem que será gravada.
     * @param corTexto Cor do texto que será exibido. (Color.<cor desejada>)
     */
    private void gravarLog(String mensagem, Color corTexto) {
        telaServidor.gravarLog(telaServidor.getjTextPaneLog(), mensagem, corTexto);
    }

    /**
     * @return the receberMensagem
     */
    public Thread getReceberMensagem() {
        return receberMensagem;
    }

    /**
     * @param servidorLigado the servidorLigado to set
     */
    public void setServidorLigado(boolean servidorLigado) {
        this.servidorLigado = servidorLigado;
    }

    /**
     * @return the datagramSocket
     */
    public DatagramSocket getDatagramSocket() {
        return datagramSocket;
    }
}
