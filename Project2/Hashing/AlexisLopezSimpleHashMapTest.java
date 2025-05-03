package Project2.Hashing;

public class AlexisLopezSimpleHashMapTest {
    //add a bunch of strings
    //see if your map contains a certain value
    //write a new method public, that will dynamically resize the array , we'll call it resize()

    public static void main(String[] args) {
        AlexisLopezSimpleHashMap map = new AlexisLopezSimpleHashMap(3);
        map.data[0].add("hello");
        map.data[1].add("world");
        map.data[2].add("java");

        System.out.println(map.contains("hello")); // true
        System.out.println(map.contains("world")); // true
        System.out.println(map.contains("java")); // true
        System.out.println(map.contains("python")); // false

        System.out.println(map.data.length);

    }
}
