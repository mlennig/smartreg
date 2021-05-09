package teamawesome.smartreg.dummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//TODO: Refactor "dummy" folder into a more suitable name
//TODO: Update the list content in this class, as displayed by RoomListActivity, from the user account on the database.

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class RoomListContent {

    //Number of rooms in the list
    /**
     * An array of rooms.
     */
    public static final List<Room> ITEMS = new ArrayList<Room>();
    /**
     * A map of rooms, by ID.
     */
    public static final Map<String, Room> ITEM_MAP = new HashMap<String, Room>();


    static {
        // Add some sample items.
        addItem(createRoom("1","Master Bedroom",20));
        addItem(createRoom("2","Living Room",20));
        addItem(createRoom("3","Kid's Bedroom",20));
        addItem(createRoom("4","Kitchen",20));
        addItem(createRoom("5","Basement",20));

    }

    private static void addItem(Room item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    private static Room createRoom(String id, String name, int current_temp) {
        return new Room(id, name, current_temp);
    }


    /**
     * An item representing a room.
     */
    public static class Room {
        public final String id;
        public final String room_name;
        public final int current_temp;
        public int actuation_temp;
        public static int min_actuation_temp = 18;

        public Room(String id, String room_name, int current_temp) {
            this.id = id;
            this.room_name = room_name;
            this.current_temp = current_temp;
            this.actuation_temp = 20;
        }

        @Override
        //Return room name
        public String toString() {
            return room_name;
        }

        //Return room object
        public Room getRoom(){return this;}

    }
}
