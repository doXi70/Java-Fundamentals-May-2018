package P03_RoyalFlush;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _03_RoyalFlush {

	//NOW THIS ONE WILL BE HARD FOR EXPLAINING
	//BUT IT WILL BE EVEN HARDER FOR UNDERSTANDING
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		//WE CREATE TWO ARRAYS, THE RANKS WE NEED AND THE SUITS WE NEED
		List<String> ranks = Arrays.asList(new String[] { "10", "J", "Q", "K", "A" });
		List<String> suits = Arrays.asList(new String[] { "c", "d", "h", "s" });
		
		//THIS ARRAY IS ONLY FOR THE OUTPUT
		String[] outputSuits = new String[] { "Clubs", "Diamonds", "Hearts", "Spades" };

		//WE MAKE A LIST OF TOTAL CARDS
		ArrayList<String> totalCards = new ArrayList<>();
		
		//pattern = (2|3|4|5|6|7|8|9|10|J|Q|K|A)(c|d|h|s)
		//THIS REGEX MATCHES EVERY SINGLE CARD
		String stringPattern = "(2|3|4|5|6|7|8|9|10|J|Q|K|A)(c|d|h|s)";
		
		Pattern regexPattern = Pattern.compile(stringPattern);
		
		//LINE COUNT
		Integer number = Integer.parseInt(scanner.nextLine());
		
		//ROYAL'S ROYAL FLUSHES COUNT
		Integer royalFlushes = 0;
		
		//TOTAL STRING (YOU'LL SEE)
		String totalString = "";
		
		//WE ADD ALL THE LINES TO ONE TOTAL STRING BECAUSE ITS EASIER THAT WAY
		for (int i = 0; i < number; i++) {
			totalString += scanner.nextLine();
		}
		
		//WE USE THE REGEX PATTERN
		Matcher totalMatches = regexPattern.matcher(totalString);
		
		//A MAP FOR THE SUITS
		//IT WILL HOLD OUR COMBINATIONS
		//THERE CAN BE MAXIMUM 4 COMBINATIONS OVERLAPPING EACH OTHER AT THE SAME TIME
		//BECAUSE THERE ARE ONLY 4 DIFFERENT SUITS
		//SO WE CREATE A MAP WITH KEY - SUIT, AND VALUE - ARRAYLIST, THE CURRENT COMBINATION PROGRESS
		TreeMap<String, ArrayList<String>> currentCombinations = new TreeMap<>();
		
		//WHILE THERE ARE CARDS
		while(totalMatches.find()) {
			
			//WE TAKE THE RANK AND THE SUIT OF THE CURRENT MATCHED CARD
			String currentRank = totalMatches.group(1);
			String currentSuit = totalMatches.group(2);
			
			//IF THE MAP DOES NOT CONTAIN THE CURRENT KEY WE ADD IT
			//THIS IS HOW I FILL MY MAP
			//SO THAT I DONT FILL IT BEFORE THE LOOP BECAUSE I'M LAZY
			if(!currentCombinations.containsKey(currentSuit)){
				currentCombinations.put(currentSuit, new ArrayList<String>());
			}
			
			//NOW IF THE ARRAYLIST OF THE CURRENT SUIT IN THE MAP, HAS SIZE OF 0
			//IN OTHER WORDS THERE IS NO CURRENTLY GOING ON COMBINATION AT THAT SUIT
			//WE ENTER
			if(currentCombinations.get(currentSuit).size() == 0) {
				//WE USE THE ARRAY OF RANKS WE INITIALIZED, AND WE CHECK IF THE CURRENT RANK IS AT INDEX 0
				//IN OTHER WORDS, IS IT A "10", SO WE CAN START THE COMBINATION
				//IF IT IS NOT IT CANNOT START THE COMBINATION AND WE PASS IT
				//ELSE WE ADD IT AND WE START THE COMBINATION IN THAT ARRAYLIST AT THAT SUIT IN THE MAP
				if(ranks.indexOf(currentRank) == 0){
					currentCombinations.get(currentSuit).add(currentRank);
				}
			}
			else {
				//IF THE CURRENT SUIT HAS AN ONGOING COMBINATION WE ENTER THE ELSE
				//NOW, IF THE INDEX OF THE CURRENT RANK IN THE RANKS ARRAY IS EQUAL TO THE SIDE OF THE ARRAYLIST
				//IN THE MAP AT THE CURRENT SUIT, THAT MEANS THAT WE FOLLOW THE RANK ORDER. HOW?!?
				//EXPLANATION:
				//SAY WE HAVE CURRENTLY "10", "J" AS ELEMENT IN THE LIST OF HEARTS SUIT
				//AND WE RECEIVE "Qh" AS INPUT, THE ranks.indexOf(currentRank) WILL RETURN 2, WHY? BECAUSE THE QUEEN
				//IS AT INDEX 2 IN RANK ARRAY WE INITIALIZED. AND THE SIZE OF THE CURRENT COMBINATION IS 2, WHY?
				//BECAUSE WE HAVE 10 and J OF HEARTS, 2==2, SO THE CURRENT CARD FOLLOWS THE RANK ORDER AND WE ADD IT TO THE COMBINATION
				//THINK ABOUT THIS LOGIC FOR OTHER CASES
				//IT WORKS 100% AND IS VERY EASY TO COME UP WITH
				if(ranks.indexOf(currentRank) == currentCombinations.get(currentSuit).size()){
					currentCombinations.get(currentSuit).add(currentRank);
				}
				else {
					//IF THE CURRENT CARD DOES NOT FOLLOW THE RANK ORDER WE RESET THE COMBINATION
					currentCombinations.get(currentSuit).clear();
					
					//HOWEVER ! WE CHECK IF THE CURRENT RANK IS 10, AND IF IT IS WE ADD IT TO THE NEW COMBINATION
					//EXPLANATION:
					//THE CASE 10s10sJsQsKsAs
					//THE FIRST COMBINATION IS 10s
					//THE NEXT CARD IT MEETS IS 10s, IT DOESNT FOLLOW THE RANK ORDER SO WE RESET THE COMBINATION
					//BUT IF WE DONT ADD THE NEW 10s, THE COMBINATION AFTERWARDS WILL FAIL TO COMPLETE
					//WHICH IS WRONG
					if(ranks.indexOf(currentRank) == 0){
						currentCombinations.get(currentSuit).add(currentRank);
					}
				}
			}
			
			//IF THE CURRENT COMBINATION SIZE IS 5 ( IT HAS COMPLETED) WE PRINT IT AND WE RESET IT
			if(currentCombinations.get(currentSuit).size() == 5){
				//WE USE THE INDEX OF FROM THE SUITS ARRAY TO PRINT THE OUTPUT SUITS
				//THE ELEMENTS ARE PLACED AT THE SAME POSITIONS SO "s" in the SUITS ARRAY == "Spades" IN THE OUTPUTSUITS ARRAY
				System.out.println(String.format("Royal Flush Found - %s", outputSuits[suits.indexOf(currentSuit)]));
				currentCombinations.get(currentSuit).clear();
				//INCREMENTING THE ROYAL FLUSH COUNTER
				royalFlushes++;
			}
		}
		
		//PRINTING THE FINAL LINE
		System.out.println(String.format("Royal's Royal Flushes - %s.", royalFlushes));
	}
}
