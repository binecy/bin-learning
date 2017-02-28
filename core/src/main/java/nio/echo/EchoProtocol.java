package nio.echo;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * Created by bin on 2017/2/28.
 */
public class EchoProtocol {
    private int bufSize; // �������ĳ���

    public EchoProtocol(int bufSize) {
        this.bufSize = bufSize;
    }

    //������ŵ��Ѿ�׼�����˽����µĿͻ�������
    public void handleAccept(SelectionKey key) throws IOException {
        SocketChannel clientChannel = ((ServerSocketChannel) key.channel()).accept();
        clientChannel.configureBlocking(false);
        //��ѡ����ע�ᵽ���ӵ��Ŀͻ����ŵ�����ָ�����ŵ�keyֵ������ΪOP_READ��ͬʱΪ���ŵ�ָ�������ĸ���
        clientChannel.register(key.selector(), SelectionKey.OP_READ, ByteBuffer.allocate(bufSize));
    }

    //�ͻ����ŵ��Ѿ�׼�����˴��ŵ��ж�ȡ���ݵ�������
    public void handleRead(SelectionKey key) throws IOException {
        SocketChannel clientChannel = (SocketChannel) key.channel();
        //��ȡ���ŵ��������ĸ���������Ϊ������
        ByteBuffer buf = (ByteBuffer) key.attachment();
        long bytesRead = clientChannel.read(buf);
        //���read������������-1��˵���ͻ��˹ر������ӣ���ô�ͻ����Ѿ����յ������Լ������ֽ�����ȵ����ݣ����԰�ȫ�عر�
        if (bytesRead == -1) {
            clientChannel.close();
        } else if (bytesRead > 0) {
            //����������ܶ��������ݣ��򽫸��ŵ�����Ȥ�Ĳ�������ΪΪ�ɶ���д
            key.interestOps(SelectionKey.OP_READ | SelectionKey.OP_WRITE);
        }
    }

    //�ͻ����ŵ��Ѿ�׼�����˽����ݴӻ�����д���ŵ�
    public void handleWrite(SelectionKey key) throws IOException {
        //��ȡ����ŵ������Ļ�������������֮ǰ��ȡ��������
        ByteBuffer buf = (ByteBuffer) key.attachment();
        //���û�������׼��������д���ŵ�
        buf.flip();
        SocketChannel clientChannel = (SocketChannel) key.channel();
        //������д�뵽�ŵ���
        clientChannel.write(buf);
        if (!buf.hasRemaining()) {
            //����������е������Ѿ�ȫ��д�����ŵ����򽫸��ŵ�����Ȥ�Ĳ�������Ϊ�ɶ�
            key.interestOps(SelectionKey.OP_READ);
        }
        //Ϊ�������������ڳ��ռ�
        buf.compact();
    }
}
