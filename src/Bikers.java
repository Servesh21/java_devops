/*
2) Five Bikers Compete in a race such that they drive at
a constant speed which may or may not be the same as
the other. To qualify the race, the speed of a racer must
be more than the average speed of all 5 racers. Write a
Java program to take as input the speed of each racer
and print back the speed of qualifying racers.*/


import java.util.Scanner; // Importing the Scanner class for user input

// Class to represent each Race participant (Biker)
class Race {
    double speed; // Variable to store the speed of the biker
    double total; // Variable to store the cumulative total speed

    // Constructor to initialize the speed of the biker
    Race(double s) {
        speed = s;
    }

    // Method to calculate and return the total speed (cumulative sum)
    double Total() {
        total = total + speed; // Adding the current speed to the total
        return total; // Returning the updated total
    }
}

public class Bikers {
    public static void main(String[] args) {
        Race[] race = new Race[5]; // Array to store the Race objects for 5 bikers
        int max = 5; // Maximum number of bikers
        double total1 = 0; // Variable to store the total speed of all bikers

        System.out.println("Enter the speed of the bikers");
        Scanner sc = new Scanner(System.in); // Scanner object for input

        // Loop to input the speed of each biker
        for (int i = 0; i < max; i++) {
            System.out.println("Enter the speed of the biker " + (i + 1) + ":");
            double speed = sc.nextInt(); // Input speed for the current biker
            race[i] = new Race(speed); // Create a new Race object and store it in the array
        }

        // Loop to calculate the total speed of all bikers
        for (int i = 0; i < max; i++) {
            total1 = total1 + race[i].Total(); // Add each biker's speed to the total
        }

        double avg = total1 / max; // Calculate the average speed

        // Loop to determine which bikers qualify based on their speed
        for (int i = 0; i < max; i++) {
            if (race[i].speed > avg) { // Check if the biker's speed is above average
                System.out.println("Biker " + (i + 1) + " is qualified with speed " + race[i].speed + " kmph");
            }
        }
    }
}
