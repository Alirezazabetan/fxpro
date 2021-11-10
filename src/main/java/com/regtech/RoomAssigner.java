package com.regtech;

import java.util.*;

import static java.lang.System.*;

public class RoomAssigner {

    public House assignRooms(List<Person> people, List<Room> rooms) {
        int sum = 10;
        House house = null;
        while (sum > 1) {
            List<Integer> list = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8));
            Collections.shuffle(list);
            List<Room> rooms2 = new LinkedList<>();
            rooms2.add(new Room(3));
            rooms2.add(new Room(2));
            rooms2.add(new Room(4));
            for (int j = 0; j < rooms.size(); j++) {
                for (int i = 0; i < rooms2.get(j).getCapacity(); i++) {
                    rooms2.get(j).add(people.get(list.remove(0)));
                }
            }

//        //FIXME a lot of unhappy people
//        for (Integer i : list) {
//            for (Room room : rooms) {
//                if (room.hasCapacity()) {
//                    room.add(people.get(list.remove(0)));
//                    break;
//                }
//            }
//        }

            house = new House(rooms2);
            sum = house.stream().mapToInt(Room::getUnhappiness).sum();
            out.println(sum);
        }
        return house;
    }

//    public static void main(String[] args) {
//        HashMap<List<Integer>, Integer> env = new HashMap<>();
//        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));
//        for (int i = 0; i < 10; i++) {
//            Collections.shuffle(list);
//            env.put(list, )
//            list.forEach(out::print);
//            out.println("");
//        }
//
//
//    }
}
