package hw5;

import java.util.AbstractCollection;
import java.util.Iterator;
import java.util.Collection;
import java.util.ArrayList;

public class MetaCollection<E> extends AbstractCollection<E> {
  //keep reference added collections in this list
  private ArrayList<Collection<E>> collectionList;
  private int numCollections  ;
  
  public MetaCollection(Collection<E> ... c_arr) {

    collectionList = new ArrayList<>();
    numCollections = 0;
    //iterate through all collections and all em all to to collectionList
    for (Collection<E> c : c_arr) {
      collectionList.add(c);
    }
  }

  public void addCollection(Collection<E> coll) {
    collectionList.add(coll);
    }
  
  @Override
  public Iterator<E> iterator() {
    return new JoinedIter();
  }

  //private class JoinedIter which returns an instance of every iteration of E in metacollection
  private class JoinedIter implements Iterator<E> {
    private int itrCounter = 0;
    private int itemCounter = 0;
    private int collCounter = 0;
    private Iterator<E> itr; 

  
    @Override
    public boolean hasNext() {
      return (itrCounter < size());
    }

    @Override
    public E next() {
      //make itr the iterator of the first colleciton of the metacollection
      if (itr == null)
        itr = collectionList.get(collCounter).iterator();

      //if the item in the collection we're in of the metacollection is past the number of items in collection, then move to next one
      if (itemCounter < collectionList.get(collCounter).size()) {
        itrCounter++; itemCounter++;
        return itr.next();
      } else {
        collCounter++; itrCounter++;
        //reset itemCounter to 1 cause it'll move up anyway if we set to 0
        itemCounter = 1; 
        itr = collectionList.get(collCounter).iterator();
        return itr.next();
      }

    }
  }
  //END JOINEDITER

  @Override
  public int size() {
    numCollections = 0;
    for (Collection<E> c: collectionList) {
      for (E e : c) {
        numCollections++;
      }
    }

    return numCollections;
  }

}
