package a_Basics;
public class Pair<K, V> {
    private K key;
    private V value;

    // Constructor
    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    // Getter for the key
    public K getKey() {
        return key;
    }

    // Getter for the value
    public V getValue() {
        return value;
    }

    // Setter for the key
    public void setKey(K key) {
        this.key = key;
    }

    // Setter for the value
    public void setValue(V value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Pair<?, ?> pair = (Pair<?, ?>) obj;

        if (key != null ? !key.equals(pair.key) : pair.key != null) return false;
        return value != null ? value.equals(pair.value) : pair.value == null;
    }

    @Override
    public int hashCode() {
        int result = key != null ? key.hashCode() : 0;
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }
}
