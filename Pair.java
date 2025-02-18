class Pair<K,V> {
    private K Key;
    private V Value;

    Pair(){}

    Pair(K key,V value){
        this.Key=key;
        this.Value=value;
    }

    public void setKey(K key){
        this.Key=key;
    }

    public void setValue(V value){
        this.Value=value;
    }

    public K getKey(){
        return this.Key;
    }

    public V getValue(){
        return this.Value;
    }

}
