package hw5;
import java.util.*;
import java.util.function.Predicate;



public final class ListUtil {
	
	private ListUtil() {};

	public static <E> ArrayList<E> merge(
		Collection<? extends E> c1, Collection<? extends E> c2) {

		//make a new arraylist which things will be put into
		ArrayList<E> ar_list = new ArrayList<>();
		//add everything
		ar_list.addAll(c1);
		ar_list.addAll(c2);

		return ar_list;
	}

	public static <E> ArrayList<E> select(
		Collection<? extends E> coll, Predicate<? super E> pred){

		//make new arraylist which holds stuff
			ArrayList<E> ar_list = new ArrayList<>();
			//iterating through the collection given, if it works with the predicate, add to the arraylist made
			for (E e : coll) {
				if (pred.test(e)) {
					ar_list.add(e);
				}
			}
			return ar_list;
	}
}