package nio.echo;

import java.net.InetSocketAddress;
import java.net.SocketException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * Created by bin on 2017/2/28.
 */
public class TCPClient {
    public static void main(String args[]) throws Exception {
        String server = "127.0.0.1";
        int serverPort = 8881;
        byte[] sendBytes = "hello".getBytes();

        //����һ���ŵ�������Ϊ������ģʽ
        SocketChannel clientChannel = SocketChannel.open();
        clientChannel.configureBlocking(false);
        //�����˷�������
        if (!clientChannel.connect(new InetSocketAddress(server, serverPort))) {
            //���ϵ���ѯ����״̬��ֱ���������
            while (!clientChannel.finishConnect()) {
                //�ڵȴ����ӵ�ʱ�������ִ�����������Գ�ַ��ӷ�����IO���첽����
                //����Ϊ����ʾ�÷�����ʹ�ã�ֻ��һֱ��ӡ"."
                System.out.print(".");
            }
        }
        //Ϊ��������ӡ��"."������������������з�
        System.out.print("\n");
        //�ֱ�ʵ����������д�Ļ�����
        ByteBuffer writeBuf = ByteBuffer.wrap(sendBytes);
        ByteBuffer readBuf = ByteBuffer.allocate(sendBytes.length);
        //���յ����ܵ��ֽ���
        int totalBytesReceived = 0;
        //ÿһ�ε���read�����������յ����ֽ���
        int bytesReceived;
        //ѭ��ִ�У�ֱ�����յ����ֽ����뷢�͵��ַ������ֽ������
        while (totalBytesReceived < sendBytes.length) {
            //���������ͨ����д���ݵĻ������л���ʣ����ֽڣ������������д���ŵ�
            if (writeBuf.hasRemaining()) {
                clientChannel.write(writeBuf);
            }
            //���read�������յ�-1����������˹رգ��׳��쳣
            if ((bytesReceived = clientChannel.read(readBuf)) == -1) {
                throw new SocketException("Connection closed prematurely");
            }
            //������յ������ֽ���
            totalBytesReceived += bytesReceived;
            //�ڵȴ�ͨ����ɵĹ����У��������ִ���������������ַ�����IO���첽����
            //����Ϊ����ʾ�÷�����ʹ�ã�ͬ��ֻ��һֱ��ӡ"."
            System.out.print(".");
        }
        //��ӡ�����յ�������
        System.out.println("Received: " + new String(readBuf.array(), 0, totalBytesReceived));
        //�ر��ŵ�
        clientChannel.close();
    }
}
