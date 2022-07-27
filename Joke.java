import java.util.*;

public class Joke {
	
	public static void main(String[] args) {
		Map<String, List<String>> jokeMap = new HashMap<>();
		
		List<String> jokes = new ArrayList<String>();
		jokes.add("Why couldn’t the pony sing a song? She was a little horse.");
		jokes.add("What does a cloud wear under his raincoat? Thunderwear.");
		jokes.add("What time is it when the clock strikes 13? Time to get a new clock.");
		
		jokeMap.put("Please tell me a joke", jokes);
		
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter your instruction: ");
		String prompt = input.nextLine();
		
		int random = (int) (Math.random() * jokes.size());
		System.out.println(jokeMap.get(prompt).get(random));
		
		input.close();
	}
}