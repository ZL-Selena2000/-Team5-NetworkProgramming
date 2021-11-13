import java.net.Socket;

public class game_user {
	private int id; 			// Unique ID
	private game_room room; 		// ������ ���� ���̴�.
	private Socket sock; 		// ���� object
	private String nickName;	// �г���

	// ���ӿ� ���õ� ���� ����
	// ...
	//

	private game_info.Location playerLocation; // ���� ����
	private game_info.Status playerStatus; // ���� ����

	public game_user() { // �ƹ��� ������ ���� ���� ������ ���� ��
	}

    /**
     * ���� ����
     * @param nickName �г���
     */
    public game_user(String nickName) { // �г��� ������ ������ ����
		this.nickName = nickName;
	}

    /**
     * �濡 �����Ŵ
     * @param room  ������ ��
     */
    public void enterRoom(game_room room) {
		room.enterUser(this); // �뿡 �����Ų ��
		this.room = room; // ������ ���� ���� ������ �����Ѵ�.(�߿�)
	}

    /**
     * �濡�� ����
     * @param room ������ ��
     */
    public void exitRoom(game_room room){
        this.room = null;
        // ����ó��(ȭ�鿡 �޼����� �شٴ� ��)
        // ...
    }

	public void setPlayerStatus(game_info.Status status) { // ������ ���¸� ����
		this.playerStatus = status;
	}

	public void setPlayerLocation(game_info.Location location) { // ������ ��ġ�� ����
		this.playerLocation = location;
	}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public game_room getRoom() {
        return room;
    }

    public void setRoom(game_room room) {
        this.room = room;
    }

    public Socket getSock() {
        return sock;
    }

    public void setSock(Socket sock) {
        this.sock = sock;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public game_info.Location getPlayerLocation() {
        return playerLocation;
    }

    public game_info.Status getPlayerStatus() {
        return playerStatus;
    }
}
