import java.util.ArrayList;
import java.util.List;

public class game_room {

    private int id; // �� ID
    private List userList;
    private game_user roomOwner; // ����
    private String roomName; // �� �̸�

    public game_room(int roomId) { // �ƹ��� ���� ���� ������ ��
        this.id = roomId;
        userList = new ArrayList();
    }

    public game_room(game_user user) { // ������ ���� ���鶧
        userList = new ArrayList();
        user.enterRoom(this);
        userList.add(user); // ������ �߰���Ų ��
        this.roomOwner = user; // ������ ������ �����.
    }

    public game_room(List users) { // ���� ����Ʈ�� ���� ������
        this.userList = users; // ��������Ʈ ����

        // �� ����
        for(game_user user : users){
            user.enterRoom(this);
        }

        this.roomOwner = userList.get(0); // ù��° ������ �������� ����
    }

    public void enterUser(game_user user) {
    	  if (userList.size() >= 2) { // �濡 ���� �ο��� 2�� ���϶�� ���̻� �ڸ� ����
              return;
          }
        user.enterRoom(this);
        userList.add(user);
    }

    public void enterUser(List users) {
        for(game_user gameUser : users){
            gameUser.enterRoom(this);
        }
        userList.addAll(users);
    }

    /**
     * �ش� ������ �濡�� ������
     * @param user ������ ����
     */
    public void exitUser(game_user user) {
        user.exitRoom(this);
        userList.remove(user); // �ش� ������ �濡�� ������

        if (userList.size() < 1) { // ��� �ο��� �� ���� �����ٸ�
            game_manager.removeRoom(this); // �� ���� �����Ѵ�.
            return;
        }

        if (userList.size() < 2) { // �濡 ���� �ο��� 1�� ���϶��
            this.roomOwner = userList.get(0); // ����Ʈ�� ù��° ������ ������ �ȴ�.
            return;
        }
    }

    /**
     * �ش� ���� ������ �� �����Ű�� ������
     */
    public void close() {
        for (game_user user : userList) {
            user.exitRoom(this);
        }
        this.userList.clear();
        this.userList = null;
    }

    // ���� ����

    
    /**
     * �ش� byte �迭�� ���� ��� �������� ����
     * @param data ���� data
     */
    /*
    public void broadcast(byte[] data) {
        for (game_client user : userList) { // �濡 ���� ������ ����ŭ �ݺ�
            // �� �������� �����͸� �����ϴ� �޼��� ȣ��~
            // ex) user.SendData(data);

//			try {
//				user.sock.getOutputStream().write(data); // �̷������� ����Ʈ�迭�� ������.
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
        }
    }*/

    public void setOwner(game_user gameUser) {
        this.roomOwner = gameUser; // Ư�� ����ڸ� �������� �����Ѵ�.
    }

    public void setRoomName(String name) { // �� �̸��� ����
        this.roomName = name;
    }

    public game_user getUserByNickName(String nickName) { // �г����� ���ؼ� �濡 ���� ������ ������

        for (game_user user : userList) {
            if (user.getNickName().equals(nickName)) {
                return user; // ������ ã�Ҵٸ�
            }
        }
        return null; // ã�� ������ ���ٸ�
    }

    public game_user getUser(game_user gameUser) { // GameUser ��ü�� get

        int idx = userList.indexOf(gameUser);

        // ������ �����Ѵٸ�(gameUser�� equals�� ��)
        if(idx > 0){
            return (game_user)userList.get(idx);
        }
        else{
            // ������ ���ٸ�
            return null;
        }
    }

    public String getRoomName() { // �� �̸��� ������
        return roomName;
    }

    public int getUserSize() { // ������ ���� ����
        return userList.size();
    }

    public game_user getOwner() { // ������ ����
        return roomOwner;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List getUserList() {
        return userList;
    }

    public void setUserList(List userList) {
        this.userList = userList;
    }

    public game_user getRoomOwner() {
        return roomOwner;
    }

    public void setRoomOwner(game_user roomOwner) {
        this.roomOwner = roomOwner;
    }
}