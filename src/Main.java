public class Main {

    public static void main(String[] args) {
        //JVM实际可用内存等于maxMemory()-totalMemory()+freeMemory()
        System.out.println(Runtime.getRuntime().maxMemory());//最大可用内存，对应-Xmx
        System.out.println(Runtime.getRuntime().freeMemory());//当前JVM空闲内存
        System.out.println(Runtime.getRuntime().totalMemory());//当前JVM占用的内存总数
    }
}
