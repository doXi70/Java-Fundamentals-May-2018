package P04_ChampionsLeague;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Map<String, Integer>> championshipData = new TreeMap<>();

        String line;
        while (!"stop".equals(line = reader.readLine())) {
            String[] tokens = line.split(" \\| ");
            String homeTeam = tokens[0];
            String awayTeam = tokens[1];

            String winnerTeam = findWinnner(homeTeam, awayTeam, tokens[2], tokens[3]);

            if (winnerTeam.equals(homeTeam)) {
                // ENTER HERE ONLY IF WINNER IS HOME TEAM
                addStatistics(championshipData, homeTeam, awayTeam);
            } else {
                // ENTER HERE ONLY IF WINNER IS AWAY TEAM
                addStatistics(championshipData, awayTeam, homeTeam);
            }
        }

        StringBuilder result = new StringBuilder();
        championshipData.entrySet().stream()
                .sorted((team1, team2) -> {
                    int totalWins1 = team1.getValue().values().stream().mapToInt(x -> x).sum();
                    int totalWins2 = team2.getValue().values().stream().mapToInt(x -> x).sum();

                    return Integer.compare(totalWins2, totalWins1);
                })
                .forEach(team -> {
                    result.append(team.getKey()).append(System.lineSeparator());

                    int wins = team.getValue().values().stream().mapToInt(x -> x).sum();

                    result.append("- Wins: ").append(wins).append(System.lineSeparator())
                            .append("- Opponents: ");

                    team.getValue().entrySet().stream()
                            .forEach(opponent -> result.append(opponent.getKey()).append(", "));

                    // remove the last " , "
                    result.deleteCharAt(result.length() - 2);
                    result.append(System.lineSeparator());
                });

        System.out.println(result);
    }

    private static void addStatistics(Map<String, Map<String, Integer>> championshipData,
                                      String homeTeam,
                                      String awayTeam) {

        if (!championshipData.containsKey(homeTeam)) {
            championshipData.put(homeTeam, new TreeMap<>());
        }

        Map<String, Integer> opponentsStatistics = championshipData.get(homeTeam);
        if (!opponentsStatistics.containsKey(awayTeam)) {
            // The default value is one because if we are here for first time
            // the home team won against this team.
            opponentsStatistics.put(awayTeam, 1);
        } else {
            // If we are here this means that the team play's one more time against the same team.
            // We get the win's from before against this team and we add one more.
            int winsAmount = opponentsStatistics.get(awayTeam) + 1;
            opponentsStatistics.put(awayTeam, winsAmount);
        }

        // Now all that is left is to enter a lost for the other team.
        addLost(championshipData, awayTeam, homeTeam);
    }

    private static void addLost(Map<String, Map<String, Integer>> championshipData,
                                String loosingTeam, String winnerTeam) {

        if (!championshipData.containsKey(loosingTeam)) {
            championshipData.put(loosingTeam, new TreeMap<>());
        }

        Map<String, Integer> opponentStatistics = championshipData.get(loosingTeam);
        if (!opponentStatistics.containsKey(winnerTeam)) {
            opponentStatistics.put(winnerTeam, 0);
        }

        int winStats = opponentStatistics.get(winnerTeam);
        if (winStats - 1 < 0) {
            opponentStatistics.put(winnerTeam, 0);
        } else {
            opponentStatistics.put(winnerTeam, --winStats);
        }

    }

    private static String findWinnner(String homeTeam, String awayTeam,
                                      String token, String token1) {

        int[] homeTeamStats = Arrays.stream(token.split(":"))
                .mapToInt(Integer::parseInt).toArray();

        int[] awayStats = Arrays.stream(token1.split(":"))
                .mapToInt(Integer::parseInt).toArray();

        int homeTeamTotalScore = homeTeamStats[0] + awayStats[1];
        int awayTeamTotalScore = homeTeamStats[1] + awayStats[0];

        if (homeTeamTotalScore > awayTeamTotalScore) {
            return homeTeam;
        } else if (awayTeamTotalScore > homeTeamTotalScore) {
            return awayTeam;
        } else {
            if (homeTeamStats[1] > awayStats[1]) {
                return awayTeam;
            } else {
                return homeTeam;
            }
        }
    }
}
