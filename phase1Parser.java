
import java.io.IOException;
import java.util.*;
import java.lang.*;


public class phase1Parser {
    
    public class Coordinate {
    
    private Double latitude;
    private Double longitude;
    
        
        public Coordinate(double latitude, double longitude) {
            this.latitude = latitude;
            this.longitude = longitude;
        }
        
        public Double getLatitude() {
            return latitude;
        } 
        
        public Double getLongitude() {
            return longitude;
        }
        
    }
    
    
    private HashMap<String, Coordinate> coordinateMap = new HashMap<String, Coordinate>(); // hashmap should map each city to its coordinates
    //cities supported: New York City, Los Angeles, Chicago, Houston, San Francisco, Phoenix, Philadelphia, Dallas
    private List<String> cities = new ArrayList<String>(); 
    //from the file, I'm assuming I iterate and obtain city names, add each to List<String> cities; 
    //for each city, add its latitude/longitude to a HashMap
    //get its distance to each of the other cities. 
    //idea: make the process of calculating distances easy. 
    
    //solution: store latitude and longitudes for each city. calculate that way. thus this concept can be extended to cities around the world. 
    
    public void populateData() { //populates distanceMap w/ correct values, cities w/ correct cities
        // populate cities first.
        // right now i'm manually adding data but i want to improve this in the future
        cities.add("New York");
        cities.add("Los Angeles");
        cities.add("Chicago");
        cities.add("Houston");
        cities.add("San Francisco");
        cities.add("Phoenix");
        cities.add("Philadelphia");
        cities.add("Dallas");
        
        coordinateMap.put("Los Angeles", new Coordinate(34.0522, 118.2437));
        coordinateMap.put("New York", new Coordinate(40.7128, 74.0060));
        coordinateMap.put("Chicago", new Coordinate(44.8781, 87.6298));
        coordinateMap.put("Houston", new Coordinate(29.7604, 95.3698));
        coordinateMap.put("San Francisco", new Coordinate(37.7749, 122.4194));
        coordinateMap.put("Phoenix", new Coordinate(33.4484, 112.0740));
        coordinateMap.put("Philadelphia", new Coordinate(39.9526, 75.1652));
        coordinateMap.put("Dallas", new Coordinate(32.7767, 96.7970));
        
    }
    
    public String getDistance(String city1, String city2) { //ideally should automatically be called to as a result of the file contents  
        Coordinate c1 = coordinateMap.get(city1);
        Double latitude1 = c1.getLatitude();
        Double longitude1 = c1.getLongitude();
        
        Coordinate c2 = coordinateMap.get(city2);
        Double latitude2 = c2.getLatitude();
        Double longitude2 = c2.getLongitude();
        
        Double dist = calculateDistance(latitude1, longitude1, latitude2, longitude2);
        System.out.println(("The distance between " + city1 + " and " + city2 +" is " + Double.toString(dist) + " miles." )); 
        
        return ("The distance between " + city1 + " and " + city2 +" is " + Double.toString(dist) + " miles." );
    }
    
    public Double calculateDistance(Double lat1, Double long1, Double lat2, Double long2) {
        //https://www.geeksforgeeks.org/program-distance-two-points-earth/ 
        lat1 = Math.toRadians(lat1);
        long1 = Math.toRadians(long1);
        
        lat2 = Math.toRadians(lat2);
        long2 = Math.toRadians(long2);
        
        //apply Haversine formula 
        
        double dlon = long2 - long1;
        double dlat = lat2 - lat1;
        double a = Math.pow(Math.sin(dlat / 2), 2)
                 + Math.cos(lat1) * Math.cos(lat2)
                 * Math.pow(Math.sin(dlon / 2),2); 
        double c = 2 * Math.asin(Math.sqrt(a));
        
        double r = 3956;
        
        return c * r;
    }
    
    
    
    
    
    
    
}
