// How to run the example:
// javac ./src/algorithms/TravelingSalesperson.java && java --class-path ./src/algorithms TravelingSalesperson && rm ./src/**/*.class

// TODO: Figure out how to find the shortest distance for unknown amount of points in array (how to figure out the for loops depth).

import java.lang.reflect.Array;
import java.util.Arrays;

class City {
  public int x;
  public int y;
  public String name;

  City(int x, int y, String name) {
    this.x = x;
    this.y = y;
    this.name = name;
  }
}

class DistanceSearcher {
  public static double find(City[] cities) {
    double theShortestDistance = 100500;

    for (int i = 0; i < cities.length; i++) {
      for (int j = 0; j < cities.length; j++) {
        for (int k = 0; k < cities.length; k++) {
          if (i != j && i != k && j != k) {
            double distance =
              + Math.pow(
                Math.pow(cities[i].x - cities[j].x, 2) + Math.pow(cities[i].y - cities[j].y, 2),
                0.5
              )
              + Math.pow(
                Math.pow(cities[i].x - cities[k].x, 2) + Math.pow(cities[i].y - cities[k].y, 2),
                0.5
              );
            if (distance < theShortestDistance) {
              theShortestDistance = distance;
            }
          }
        }
      }
    }

    return theShortestDistance;
  }
}

class TravelingSalesperson {
  public static void main(String[] args) {
    City[] cities = {
      new City(1, 1, "Atlanta"),
      new City(5, 9, "Boston"),
      new City(2, 6, "Chicago"),
    };

    double elementIndex = DistanceSearcher.find(cities);
    System.out.println(elementIndex);
  }
}
