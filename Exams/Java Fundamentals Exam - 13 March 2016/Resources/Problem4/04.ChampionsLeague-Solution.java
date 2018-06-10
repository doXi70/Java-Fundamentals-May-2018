import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class ChampionsLeague {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		TreeMap<String, Integer> teamsWithScore = new TreeMap<String, Integer>();
		TreeMap<String, TreeSet<String>> teamsWithOponents = new TreeMap<String, TreeSet<String>>();
		
		String inputLine = scanner.nextLine().trim();
		
		while(!inputLine.equals("stop")){
			
			String[] inputArgs = inputLine.split("[|]+");
			
			String firstTeamName = inputArgs[0].trim();
			String secondTeamName = inputArgs[1].trim();
			String[] homeResult = inputArgs[2].trim().split(":");
			String[] awayResult = inputArgs[3].trim().split(":");
			
			Integer homeResultFirstTeam = Integer.parseInt(homeResult[0]);
			Integer homeResultSecondTeam = Integer.parseInt(homeResult[1]);
			
			Integer awayResultSecondTeam = Integer.parseInt(awayResult[0]);
			Integer awayResultFirstTeam = Integer.parseInt(awayResult[1]);
			
			if(homeResultFirstTeam + awayResultFirstTeam > homeResultSecondTeam + awayResultSecondTeam){
				if(teamsWithScore.containsKey(firstTeamName)){
					Integer oldValue = teamsWithScore.get(firstTeamName);
					teamsWithScore.replace(firstTeamName, oldValue + 1);
					
					TreeSet<String> oponents = teamsWithOponents.get(firstTeamName);
					oponents.add(secondTeamName);
					teamsWithOponents.replace(firstTeamName, oponents);
					if(!teamsWithScore.containsKey(secondTeamName)){
						teamsWithScore.put(secondTeamName, 0);
						TreeSet<String> enemyOponents = new TreeSet<String>();
						enemyOponents.add(firstTeamName);
						teamsWithOponents.put(secondTeamName, enemyOponents);
					}
					else{
						TreeSet<String> enemyOponents = teamsWithOponents.get(secondTeamName);
						enemyOponents.add(firstTeamName);
						teamsWithOponents.replace(secondTeamName, enemyOponents);
					}
				}
				else{
					teamsWithScore.put(firstTeamName, 1);
					TreeSet<String> oponents = new TreeSet<String>();
					oponents.add(secondTeamName);
					
					teamsWithOponents.put(firstTeamName, oponents);
					if(!teamsWithScore.containsKey(secondTeamName)){
						teamsWithScore.put(secondTeamName, 0);
						TreeSet<String> enemyOponents = new TreeSet<String>();
						enemyOponents.add(firstTeamName);
						teamsWithOponents.put(secondTeamName, enemyOponents);
					}
					else{
						TreeSet<String> enemyOponents = teamsWithOponents.get(secondTeamName);
						enemyOponents.add(firstTeamName);
						teamsWithOponents.replace(secondTeamName, enemyOponents);
					}
				}
			}
			else if(homeResultFirstTeam + awayResultFirstTeam < homeResultSecondTeam + awayResultSecondTeam){
				if(teamsWithScore.containsKey(secondTeamName)){
					Integer oldValue = teamsWithScore.get(secondTeamName);
					teamsWithScore.replace(secondTeamName, oldValue + 1);
					
					TreeSet<String> oponents = teamsWithOponents.get(secondTeamName);
					oponents.add(firstTeamName);
					teamsWithOponents.replace(secondTeamName, oponents);
					if(!teamsWithScore.containsKey(firstTeamName)){
						teamsWithScore.put(firstTeamName, 0);
						TreeSet<String> enemyOponents = new TreeSet<String>();
						enemyOponents.add(secondTeamName);
						teamsWithOponents.put(firstTeamName, enemyOponents);
					}
					else{
						TreeSet<String> enemyOponents = teamsWithOponents.get(firstTeamName);
						enemyOponents.add(secondTeamName);
						teamsWithOponents.replace(firstTeamName, enemyOponents);
					}
				}
				else{
					teamsWithScore.put(secondTeamName, 1);
					TreeSet<String> oponents = new TreeSet<String>();
					oponents.add(firstTeamName);
					
					teamsWithOponents.put(secondTeamName, oponents);
					if(!teamsWithScore.containsKey(firstTeamName)){
						teamsWithScore.put(firstTeamName, 0);
						TreeSet<String> enemyOponents = new TreeSet<String>();
						enemyOponents.add(secondTeamName);
						teamsWithOponents.put(firstTeamName, enemyOponents);
					}
					else{
						TreeSet<String> enemyOponents = teamsWithOponents.get(firstTeamName);
						enemyOponents.add(secondTeamName);
						teamsWithOponents.replace(firstTeamName, enemyOponents);
					}
				}
			}
			else if(homeResultFirstTeam + awayResultFirstTeam == homeResultSecondTeam + awayResultSecondTeam){
				String winnerTeamName = awayResultFirstTeam > homeResultSecondTeam ? firstTeamName : secondTeamName;
				String loserTeamName = awayResultFirstTeam > homeResultSecondTeam ? secondTeamName : firstTeamName;
				
				if(teamsWithScore.containsKey(winnerTeamName)){
					Integer oldValue = teamsWithScore.get(winnerTeamName);
					teamsWithScore.replace(winnerTeamName, oldValue + 1);
					
					TreeSet<String> oponents = teamsWithOponents.get(winnerTeamName);
					oponents.add(loserTeamName);
					teamsWithOponents.replace(winnerTeamName, oponents);
					if(!teamsWithScore.containsKey(loserTeamName)){
						teamsWithScore.put(loserTeamName, 0);
						TreeSet<String> enemyOponents = new TreeSet<String>();
						enemyOponents.add(winnerTeamName);
						teamsWithOponents.put(loserTeamName, enemyOponents);
					}
					else{
						TreeSet<String> enemyOponents = teamsWithOponents.get(loserTeamName);
						enemyOponents.add(winnerTeamName);
						teamsWithOponents.replace(loserTeamName, enemyOponents);
					}
				}
				else{
					teamsWithScore.put(winnerTeamName, 1);
					TreeSet<String> oponents = new TreeSet<String>();
					oponents.add(loserTeamName);
					
					teamsWithOponents.put(winnerTeamName, oponents);
					if(!teamsWithScore.containsKey(loserTeamName)){
						teamsWithScore.put(loserTeamName, 0);
						TreeSet<String> enemyOponents = new TreeSet<String>();
						enemyOponents.add(winnerTeamName);
						teamsWithOponents.put(loserTeamName, enemyOponents);
					}
					else{
						TreeSet<String> enemyOponents = teamsWithOponents.get(loserTeamName);
						enemyOponents.add(winnerTeamName);
						teamsWithOponents.replace(loserTeamName, enemyOponents);
					}
				}
			}
			
			inputLine = scanner.nextLine().trim();
		}
		
		Map<String, Integer> sortedTeamsByScore = new LinkedHashMap<String, Integer>();
			sortedTeamsByScore = teamsWithScore.entrySet().stream().sorted(new Comparator<Entry<String, Integer>>() {
				@Override
				public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
					return o2.getValue().compareTo(o1.getValue());
				}
				}).collect(
					Collectors.toMap(
					Map.Entry::getKey,
					Map.Entry::getValue,
					(x,y)-> {throw new AssertionError();},
					LinkedHashMap::new
				));
		
		for(Entry e : sortedTeamsByScore.entrySet()){
			System.out.println(String.format("%s", e.getKey()));
			System.out.println(String.format("- Wins: %s", e.getValue()));
			System.out.println(String.format("- Opponents: %s", String.join(", ", teamsWithOponents.get(e.getKey()))));
		}
	}
}
