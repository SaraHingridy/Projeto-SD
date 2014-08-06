/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.google.gson.Gson;
import java.awt.Color;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author Rafael
 */
public class AulaPERS {
    
    private DatagramSocket datagramSocket = null;
    DatagramPacket datagramPacket = null;
    byte[] tamanhoPacote = null;
    Gson gson = new Gson();
    InetAddress IP;
    int porta;
    
    public AulaPERS(int porta, InetAddress IP) {
        this.porta = porta;
        this.IP = IP;
        estabelecerConexao();
    }
    
    private void estabelecerConexao() {
        try {
            this.datagramSocket = new DatagramSocket(this.porta);
            System.out.println("----------\nSocket criado na porta " + porta + "\n");
        } catch (SocketException ex) {
            System.out.println("Não foi possível criar o Socket. Mensagem de erro: " + ex.getMessage() + "\n");
            return;
        }
        getReceberMensagem().start();
    }
    
    private Thread receberMensagem = new Thread() {

        @Override
        public void run() {
            super.run();
            System.out.println("A thread de recebimento de mensagens foi inicializada.\n");
            while (true) {
                try {
                    tamanhoPacote = new byte[1024];
                    datagramPacket = new DatagramPacket(tamanhoPacote, tamanhoPacote.length);
                    getDatagramSocket().receive(datagramPacket);
                    String conteudoRecebido = new String(datagramPacket.getData());
                    System.out.println("Mensagem RECEBIDA = " + conteudoRecebido.trim() + "\n");

                    tratarPacote(conteudoRecebido, datagramPacket.getAddress(), datagramPacket.getPort());

                    //-- Implementação de ECO
                    //enviarMensagem(conteudoRecebido.toUpperCase(), datagramPacket.getAddress(), datagramPacket.getPort());
                    //-- fim ECO
                } catch (IOException ex) {
//                    gravarLog("Problema durante o recebimento de mensagens (Thread).\n"
//                            + "Mensagem de erro: " + ex.getMessage() + "\n", Color.red);
                }
            }
        }
    };
    
    private void tratarPacote(String mensagem, InetAddress enderecoOrigem, int portaOrigem) {
        String[] mensagemParticionada = mensagem.trim().split(Pattern.quote("#"));
        JOptionPane.showMessageDialog(null, mensagemParticionada[1]);
    }
    
    private void enviarMensagem(String mensagem, InetAddress ipDestino, int portaDestino) {
        try {
            this.datagramPacket = new DatagramPacket(mensagem.getBytes(), mensagem.length(), ipDestino, portaDestino);
            this.getDatagramSocket().send(datagramPacket);
            System.out.println("Mensagem ENVIADA: " + mensagem + "\n");
        } catch (IOException ex) {
            System.out.println("Falha ao enviar mensagem para " + ipDestino + ":" + portaDestino + ".\n"
                    + "Mensagem: " + mensagem + "\n"
                    + "Mensagem de erro: " + ex.getMessage() + "\n");
        } finally {
            this.datagramPacket = new DatagramPacket(tamanhoPacote, tamanhoPacote.length);
        }
    }
    
    public Thread getReceberMensagem() {
        return receberMensagem;
    }
    
    public DatagramSocket getDatagramSocket() {
        return datagramSocket;
    }
}
