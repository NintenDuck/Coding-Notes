import java.util.ArrayList;
import java.util.Arrays;

public class Array_and_ArrayList {
	public static void main(String[] args) {

//		ARRAY
		int friendAmount = 5;
		String[] friendsArray = new String[friendAmount];
//		String[] newFriendsArray = { "Laura", "Lain", "Olimar", "Jhon", "Louie" };
//
//		System.out.println(newFriendsArray[1]);

		ArrayList<String> friendsArrayList2 = new ArrayList<>(Arrays.asList("Jhon", "Olimar", "Lain"));
		System.out.println(friendsArrayList2.get(1));
//		Add to ArrayList
		friendsArrayList2.add("Marco");
		System.out.println(friendsArrayList2.get(3));
	}
}
