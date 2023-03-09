import java.util.ArrayList;
import java.util.LinkedList;

class KeyValuePair {
  public String key;
  public int value;

  public KeyValuePair(String key, int value) {
    this.key = key;
    this.value = value;
  }
}

class MyHashTable {
  private ArrayList<LinkedList<KeyValuePair>> memory;

  private static int hash(String key) {
    return key.length();
  }

  public MyHashTable(int size) {
    this.memory = new ArrayList<LinkedList<KeyValuePair>>(size);
    for (int index = 0; index < size; index++) {
      this.memory.add(new LinkedList<KeyValuePair>());
    }
  }

  public Integer get(String key) {
    LinkedList<KeyValuePair> listAtHash = this.memory.get(hash(key));

    for (int index = 0; index < listAtHash.size(); index++) {
      KeyValuePair pairAtIndex = listAtHash.get(index);
      if (pairAtIndex.key == key) {
        return pairAtIndex.value;
      }
    }

    return null;
  }

  public void set(String key, int value) {
    LinkedList<KeyValuePair> listAtHash = this.memory.get(hash(key));

    for (int index = 0; index < listAtHash.size(); index++) {
      KeyValuePair pairAtIndex = listAtHash.get(index);
      if (pairAtIndex.key.equals(key)) {
        pairAtIndex.value = value;
        return;
      }
    }

    listAtHash.add(new KeyValuePair(key, value));
  }

  public void remove(String key) {
    LinkedList<KeyValuePair> listAtHash = this.memory.get(hash(key));

    for (int index = 0; index < listAtHash.size(); index++) {
      KeyValuePair pairAtIndex = listAtHash.get(index);
      if (pairAtIndex.key == key) {
        listAtHash.remove(index);
        return;
      }
    }
  }
}
