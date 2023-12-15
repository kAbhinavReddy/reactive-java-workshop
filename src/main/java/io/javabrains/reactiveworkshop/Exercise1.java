package io.javabrains.reactiveworkshop;

public class Exercise1 {

    public static void main(String[] args) {

        // Use StreamSources.intNumbersStream() and StreamSources.userStream()

        // Print all numbers in the intNumbersStream stream
        StreamSources.intNumbersStream().forEach( number -> System.out.println(number)  );
        StreamSources.intNumbersStream().forEach( System.out::println ); // whatever argument is passed into the for each
        // throw them into the println function 

        // Print numbers from intNumbersStream that are less than 5
        StreamSources.intNumbersStream()
            .filter(number -> number <5 ) // if condition true then keep else discard
            .forEach(number -> System.out.println(number));

        // Print the second and third numbers in intNumbersStream that's greater than 5
        StreamSources.intNumbersStream()
            .filter(number -> number > 5 )
            .skip(1)
            .limit(2)
            .forEach(number -> System.out.println(number));

        //  Print the first number in intNumbersStream that's greater than 5.
        Integer value = StreamSources.intNumbersStream()
                            .filter(number -> number > 5)
                            .findFirst()
                            .orElse(-1); // if nothing found default value is -1
        System.out.println(value);


        // Print first names of all users in userStream
        StreamSources.userStream().forEach(user -> System.out.println(user.getFirstName()) );
        StreamSources.userStream()
            .map(user -> user.getFirstName()) // map or change the user with his first name
            .forEach(firstName -> System.out.println(firstName));

        // Print first names in userStream for users that have IDs from number stream
        StreamSources.userStream()
            .filter(user -> StreamSources.intNumbersStream().anyMatch( id -> user.getId() == id ))
            .forEach(user -> System.out.println(user.getFirstName()));

    }

}
