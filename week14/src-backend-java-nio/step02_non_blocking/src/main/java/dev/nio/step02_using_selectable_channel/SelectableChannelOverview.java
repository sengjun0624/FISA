package dev.nio.step02_using_selectable_channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * SelectableChannel
 *
 * Selector는 둘 이상의 Channel을 하나의 스레드를 통해 감시(select())할 수 있음
 *
 * Selector에 채널을 등록하기 위해서는 SelectableChannel을 상속받아야 하며,
 * SelectableChannel을 상속받았으며, TCP 연결용 채널인 ServerSocketChannel을 활용함
 *
 * 결과적으로 Selector와 ServerSocketChannel을 통해 하나의 스레드로 둘 이상의 다중 클라이언트의 접속을 처리할 수 있음
 */
public class SelectableChannelOverview {
    public static void main(String[] args) {
        final int DEFAULT_PORT = 5555;

        try {
            // Selector 생성
            Selector selector = Selector.open();

            // TCP 통신을 위한 ServerSocketChannel을 생성
            ServerSocketChannel serverSocketChannel
                    = ServerSocketChannel.open();

            // Selector와 ServerSocketChannel이 성공적으로 열렸는지 확인
            if (serverSocketChannel.isOpen() && selector.isOpen()) {
                // 생성한 논블로킹 소켓인 ServerSocketChannel을 논블로킹 모드로 설정
                serverSocketChannel.configureBlocking(false);

                // 클라이언트의 연결을 대기할 포트번호 지정(생성)
                InetSocketAddress inetSocketAddress
                        = new InetSocketAddress(DEFAULT_PORT);

                // 생성한 포트를 서버 소켓 채널에 바인딩
                serverSocketChannel.bind(inetSocketAddress);
                // -> serverSocketChannel 객체가 지정된 포트로부터 클라이언트의 연결을 받을 수 있게 됨

                // 현재 생성된 서버 소켓 채널(serverSocketChannel)을 Selector 객체에 등록
                // SelectionKey.OP_ACCEPT - 셀렉터가 감지할 이벤트들 중에서 서버가 클라이언트의 연결 요청 수락
                // 두 번째 인자는 채널에서 발생하는 이벤트들 중 셀렉터를 통해 확인하고자(알림받고자) 하는 이벤트의 종류를 전달할 때 사용
                serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

                System.out.println("서버는 클라이언트의 접속 대기 중..");
                while (true) {
                    selector.select(); // 클라이언트의 유입 이벤트가 올 때까지 대기(기다림)

                    // SelectionKey 목록 조회
                    Set<SelectionKey> selectionKeys = selector.selectedKeys();

                    Iterator<SelectionKey> keys = selectionKeys.iterator();

                    while (keys.hasNext()) {
                        SelectionKey key = keys.next();

                        // 현재 키에 해당하는 채널에서 조회된 IO 이벤트의 종류가 새로운 소켓 커넥션 연결 요청인지 확인
                        if (key.isAcceptable()) { // 현재 키에 담긴 이벤트가 새로운 소켓 연결을 수락할 수 있는지?
                            // 소켓 연결 작업 수행 로직 작성 부분
                            acceptOperation(key, selector);
                        }
                    }
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    /*
        키의 채널(여기서는 ServerSocketChannel)이 새 소켓 연결을 수락할 수 있는 경우,
        처리할 수행 로직이 담긴 메서드
     */
    private static void acceptOperation(SelectionKey key, Selector selector) throws IOException {
        // 클라이언트의 연결 요청 이벤트가 발생한 채널은 항상 ServerSocketChannel이기 때문에
        // 이벤트가 발생한 채널을 ServerSocketChannel 타입으로 캐스팅
        ServerSocketChannel serverSocketChannel = (ServerSocketChannel) key.channel();

// ServerSocketChannel을 활용하여 클라이언트의 연결을 수락하고, 연결된 클라이언트 SocketChannel 객체를 가져옴
        SocketChannel clientSocketChannel
                = serverSocketChannel.accept();// accept()는 연결된 클라이언트 소켓 객체를 반환함
        System.out.println("clientSocketChannel = " + clientSocketChannel);

        // 연결된 클라이언트 소켓 모드를 논블로킹 모드로 설정
        clientSocketChannel.configureBlocking(false);
        System.out.println(clientSocketChannel.getRemoteAddress() + " 로부터 클라이언트가 연결됨");
    }
}


