import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class game_manager {

    private static List roomList; // ���� ����Ʈ
    private static AtomicInteger atomicInteger;

    static {
        roomList = new ArrayList();
        atomicInteger = new AtomicInteger();
    }

    public game_manager() {

    }

    /**
     * �� ���� ����
     * @return GameRoom
     */
    public static game_room createRoom() { // ���� ���� ����(�� ��)
        int roomId = atomicInteger.incrementAndGet();// room id ä��
        game_room room = new game_room(roomId);
        roomList.add(room);
        System.out.println("Room Created!");
        return room;
    }

    /**
     * ���� �����԰� ���ÿ� ������ �������
     * @param owner ����
     * @return GameRoom
     */
    public static game_room createRoom(game_user owner) { // ������ ���� ������ �� ���(������ �������� ��)
        int roomId = atomicInteger.incrementAndGet();// room id ä��

        game_room room = new game_room(roomId);
        room.enterUser(owner);
        room.setOwner(owner);

        roomList.add(room);
        System.out.println("Room Created!");
        return room;
    }

    /**
     * ���� ����Ʈ�� ���� ����
     * @param users �����ų ���� ����Ʈ
     * @return GameRoom
     */
    public static game_room createRoom(List users) {
        int roomId = atomicInteger.incrementAndGet();// room id ä��

        game_room room = new game_room(roomId);
        room.enterUser(users);

        roomList.add(room);
        System.out.println("Room Created!");
        return room;
    }

    public static game_room getRoom(game_room gameRoom){

        int idx = roomList.indexOf(gameRoom);

        if(idx > 0){
            return (game_room) roomList.get(idx);
        }
        else{
            return null;
        }
    }

    /**
     * ���޹��� ���� ����
     * @param room ������ ��
     */
    public static void removeRoom(game_room room) {
        room.close();
        roomList.remove(room); // ���޹��� ���� �����Ѵ�.
        System.out.println("Room Deleted!");
    }

    /**
     * ���� ���� ũ�⸦ ����
     * @return ���� size
     */
    public static int roomCount() {
        return roomList.size();
    }
}