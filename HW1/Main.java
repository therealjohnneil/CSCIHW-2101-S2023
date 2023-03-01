package HW1;

public class Main {
    public static void main(String[] args) {
        System.out.println("Homework 1: John Neil M. Dela Peña");

        System.out.println("==================================");
        System.out.println("Pyramid:");
        // Create an instance of the Pyramid class and call the Output method (see Pyramid.java for more info)
        Pyramid.Output();
        System.out.println("==================================");
        
        // Create an instance of the Adlibs class and call the story method (see Adlibs.java for more info)
        System.out.println("==================================");
        System.out.println("Adlibs:");
        String name = "John Neil";
        int age = 21;
        String favoriteColor1 = "Sky Blue";
        String favoriteColor2 = "Gray";
        String story = Adlibs.story(name, age, favoriteColor1, favoriteColor2);
        System.out.println(story);
        System.out.println("==================================");

        // Create an instance of the Replace class and call the charReplace method (see Replace.java for more info)
        System.out.println("==================================");
        System.out.println("Replace:");

        String s = "I'M BORN";
        System.out.println("Before: " + s);
        int x = 4;
        char z = 'T';
        String output = Replace.charReplace(s, x, z);
        System.out.println("After: " + output);
        System.out.println("==================================");

    }
}
