package com.java.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created by YSFY on 2018/5/20.
 * projectName  源码分析Hashtable
 *
 *  Hashtable:
 *      (1) 键(key)和值(value)都不允许null值,null值直接抛出异常
 *      (2) 重复的键(key)对应的值会覆盖
 */
public class HashTable<K,V> implements Cloneable{

    /**
     *  主要属性
     *      1 数组初始化大小:如果不指定其默认初始化Entry大小为11,负载因子为0.75
     *      2 负载因子
     *
     *
     * */

    private transient Entry<?,?>[] table;   //hashtable用于存储键值对的数组
    private transient int count;            // hashtable中统计entry已被使用的数量,而非hashtable大小,这点必须注意
    private int threshold;                  // hashtable扩容点 扩容点大小 = 实际可用容量*负载因子
    private float loadFactor;               //hashtable数组扩容的负载因子,即hash数组Entry数量达到实际容量*负载因子的结果时,需要数组扩容
    private transient int modCount = 0;     //用于统计rehash的次数
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;    //可分配的数组最大大小


    /**
     *  hashTable构造方法
     * */
    public HashTable(int initialCapacity, float loadFactor) {
        /*指定的Entry大小*/
        if (initialCapacity < 0) { throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity); }

        /*Float.isNAN()方法用于描述非法的float,经过多次运算float值可能会出现非法情况，如除数为0.0*/
        if (loadFactor <= 0 || Float.isNaN(loadFactor)) { throw new IllegalArgumentException("Illegal Load: " + loadFactor); }

        /*如果人为自定义初始容量为0,则默认开辟一个*/
        if (initialCapacity==0) { initialCapacity = 1; }

        this.loadFactor = loadFactor;   //绑定负载因子
        table = new Entry<?,?>[initialCapacity];//根据初始值开辟数组大小并分配内存
        this.threshold = (int)Math.min(initialCapacity * loadFactor, MAX_ARRAY_SIZE + 1);//数组扩容点,如果扩容点对应的大小值不超过可分配的最大数组大小就返回扩容点
    }

    /**
     *  put方法   可见put方法为一个同步方法,故hashtable为线程安全
     * */
    public synchronized V put(K key, V value) {

        /*如果键值对中值为null,则抛出*/
        if (value == null) { throw new NullPointerException(); }

        Entry<?,?> tab[] = table;   //将初始化设置的数组Entry的大小被put方法中的tab[]指向

        /* 将key的hash值与整型最大值进行与运算并与数组长度进行取模运算获得此key在数组中可以落到的位置,即保存于数组中的索引*/
        int index = (key.hashCode() & 0x7FFFFFFF) % tab.length;   //0x7FFFFFFF 为Integer类中最大值

        @SuppressWarnings("unchecked")
        Entry<K,V> entry = (Entry<K,V>) tab[index]; //获取当前key所保存的位置的元素,并for循环进行遍历
        for(; entry != null ; entry = entry.next) {

            /**
             *  如果当前需要保存的键值(key)经过hash计算后发现已经存在相同hash,此时在判断key值,如果值相同
             *
             *  则表明put进来的是key已经完全存在的(判断一个key是否一样采取key的hash值和key本身的值,二者均相同人为为同一个key),
             *
             *  此时将新的替换为旧的,如果值不同则添加进去
             */
            if ((entry.hash == key.hashCode()) && entry.key.equals(key)) {
                V old = entry.value;
                entry.value = value;
                return old;
            }
        }

        addEntry(key.hashCode(), key, value, index);

        return null;
    }

    /**
     * 添加元素
     * */
    private void addEntry(int hash, K key, V value, int index) {
        this.modCount++;

        Entry<?,?> tab[] = table;
        if (this.count >= this.threshold) { //如果添加到数组中的元素个数已经达到数组扩容点,则进行扩容,复制数组内的元素到新数组
            //重构hashtable数组
            this.rehash();

            /*重新定义新的数组的情况*/
            tab = table;
            hash = key.hashCode();
            index = (hash & 0x7FFFFFFF) % tab.length;
        }

        //如果插入数组的值未达到数组扩容点大小则进行新增
        @SuppressWarnings("unchecked")
        Entry<K,V> e = (Entry<K,V>) tab[index];//获取到当前key经过hash和取模算法后得到的索引对应在数组中的具体位置的元素

        /** 关于链表的Entry结点指向问题: 这里是链表的核心
         *    即当前新增的Entry结点总是要存储在数组中,将已存在数组中的第一个Entry往下移动,
         *    并将新的Entry结点的next指针指向数组中当前key计算出来的索引位置的已经存在并要往下移动的Entry
         */
        tab[index] = new Entry<>(hash, key, value, e);
        count++;    //用于统计添加到数组中的Entry结点个数
    }

    /**
     * 扩容重构数组
     * */
    protected void rehash() {
        int oldCapacity = table.length; //获取扩容前正在使用的数组容量大小
        Entry<?,?>[] oldMap = table;    //设置老数组的局部引用

        int newCapacity = (oldCapacity << 1) + 1;   //设置扩容后新数组的大小,新数组的大小为老数组大小的2倍+1,如果采取hashtable默认数组大小11的大小,则扩容后为11*2+1=23


        /*
            如果扩容后的新数组大小已经超过Integer最大值,
                则判断扩容之前的数组容量大小如果也等于Integer最大值,则保持扩容后数组大小就为计算后的值,
                如果老数组不等于,则将新数组大小设置为Integer最大值
        */
        if (newCapacity - MAX_ARRAY_SIZE > 0) {
            if (oldCapacity == MAX_ARRAY_SIZE) {
                // Keep running with MAX_ARRAY_SIZE buckets
                return;
            }
            newCapacity = MAX_ARRAY_SIZE;
        }


        /*根据计算出来后的新数组大小创建新的Entry数组*/
        Entry<?,?>[] newMap = new Entry<?,?>[newCapacity];

        this.modCount++;

        /*设置新Entry数组扩容点大小*/
        this.threshold = (int)Math.min(newCapacity * loadFactor, MAX_ARRAY_SIZE + 1);

        /*table指向新建立好的空Entry数组*/
        this.table = newMap;

        /*将老Entry数组已存在的元素移动到新数组内,采取从后往前遍历*/
        for (int i = oldCapacity ; i-- > 0 ;) {

            /*遍历老数组每个索引元素,即处理每个索引的链表*/
            for (Entry<K,V> old = (Entry<K,V>)oldMap[i] ; old != null ; ) {

                Entry<K,V> e = old;
                old = old.next;//将old的next指针指向的下个Entry结点赋值给当前old元素所在位置,用于下次遍历,每次针对一个索引的Entry结点链表需要一个一个判断

                int index = (e.hash & 0x7FFFFFFF) % newCapacity;    //计算old所指代的Entry结点将要在新数组中需要保存的位置,即索引

                /*以下两句代码为核心代码*/
                e.next = (Entry<K,V>)newMap[index];
                newMap[index] = e;

            }

        }
    }

    /**
     *  get方法   可见get方法为一个同步方法,故hashtable为线程安全
     * */
    public synchronized V get(Object key) {
        Entry<?,?> tab[] = table;

        /*计算key的hash值，并获取当前key对应的索引*/
        int hash = key.hashCode();
        int index = (hash & 0x7FFFFFFF) % tab.length;
        for (Entry<?,?> e = tab[index] ; e != null ; e = e.next) {

            /**
             * 循环遍历当前key所求得的索引位置的Entry结点链表，直到找到与当前key的hash相同且key相同的Entry结点，并返回对应的value
             * */
            if ((e.hash == hash) && e.key.equals(key)) {
                return (V)e.value;
            }
        }
        return null;
    }

    public static void main(String[] args) throws Exception{

        java.util.HashMap<String, String> hashMap1 = new java.util.HashMap<String, String>();
        hashMap1.put(null,null);

        HashTable hashTable = new HashTable(2, 0.75f);
        hashTable.put("key1", "123");
        hashTable.put("key2", "345");
        hashTable.put("key3", "234");
        hashTable.put("key4", "123");
        hashTable.get("key1");

        new HashMap<>().put("key6", "856");

        /**
         * 能够使用Clone方法的对象其自身所属的类必须实现Cloneable接口，当调用clone()方法时，将会新创建一个一模一样的对象，只不过是
         * 内存地址不同
         * */
        System.out.println(hashTable);
        System.out.println(hashTable.clone());
    }


    /**
     * Entry结点类,包含4分数据
     *
     *  key的hash值
     *  key值
     *  value值
     *  指向下一个Entry的指针
     * */
    private static class Entry<K,V> implements Map.Entry<K,V> {
        final int hash;
        final K key;
        V value;
        Entry<K,V> next;

        protected Entry(int hash, K key, V value, Entry<K,V> next) {
            this.hash = hash;   //存hash值
            this.key =  key;    //存key值
            this.value = value; //存value值
            this.next = next;   //存新增Entry的next指针指向已经再存数组中的那个Entry
        }

        @SuppressWarnings("unchecked")
        protected Object clone() {
            return new Entry<>(hash, key, value,
                    (next==null ? null : (Entry<K,V>) next.clone()));
        }

        // Map.Entry Ops

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public V setValue(V value) {
            if (value == null)
                throw new NullPointerException();

            V oldValue = this.value;
            this.value = value;
            return oldValue;
        }

        public boolean equals(Object o) {
            if (!(o instanceof Map.Entry))
                return false;
            Map.Entry<?,?> e = (Map.Entry<?,?>)o;

            return (key==null ? e.getKey()==null : key.equals(e.getKey())) &&
                    (value==null ? e.getValue()==null : value.equals(e.getValue()));
        }

        public int hashCode() {
            return hash ^ Objects.hashCode(value);
        }

        public String toString() {
            return key.toString()+"="+value.toString();
        }
    }
}
