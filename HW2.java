import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author TODO: B0544214 白柏妤
 * Try to write some comments for your codes (methods, 15 points)
 */
public class HW2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("input N (deck of cards):");
		String testn= sc.nextLine(); 
        
		int nDeck=Integer.parseInt(testn); 
		Deck deck=new Deck(nDeck);//nDeck的n是幾副牌
		deck.printDeck();//印出deck
		
		//TODO: please check your output, make sure that you print all cards on your screen (10 points)
		
		if(isAllCardsCorrect(deck.getAllCards(),nDeck)){//叫出下面的isAllCardsCorrect
			System.out.println("Well done!");
		}else{
			System.out.println("Error, please check your sourse code");
		}
	}
	/**
	 * This method is used for checking your result, not a part of your HW2
	 * @param allCards 總共多少張牌
	 * @param nDeck 總共幾付牌
	 * @return
	 */
	private static boolean isAllCardsCorrect(ArrayList<Card> allCards,int nDeck){//ArrayList<Card>用來存所有的牌
		//check the output 
		boolean isCorrect=true;;
		HashMap <String,Integer> checkHash=new HashMap<String,Integer>();
		for(Card card:allCards){
			int suit= card.getSuit();
			int rank = card.getRank();
			if(suit>4||suit<1||rank>13||rank<1){
				isCorrect=false;
				break;
			}
			if(checkHash.containsKey(suit+","+rank)){
				checkHash.put(suit+","+rank, 
						checkHash.get(suit+","+rank)+1);
			}else{
				checkHash.put(suit+","+rank, 1);
			}

		}
		if(checkHash.keySet().size()==52){
			for(int value:checkHash.values()){
				if(value!=nDeck){
					isCorrect=false;
					break;
				}
			}
		}else{
			isCorrect=false;
		}
		return isCorrect;
	}

}
/**
 * Description: TODO: please add description here
 * Description: Deck用來算幾副牌(一副為52張牌)
 * ArrayList<Card> cards 用來除存所有的牌
 * Deck 從花色(四個花色依序)開始存，存完換數字，存進cards裡
 * printDeck()印出牌
 */
class Deck{
	private ArrayList<Card> cards;
	//TODO: Please implement the constructor (30 points)
	
	
	public Deck(int nDeck){
		cards=new ArrayList<Card>();
		//1 Deck have 52 cards, https://en.wikipedia.org/wiki/Poker
		//Hint: Use new Card(x,y) and 3 for loops to add card into deck
		//Sample code start
		//Card card=new Card(1,1); ->means new card as clubs ace
		//cards.add(card);
		//Sample code end
		for(int deck=1;deck<=nDeck;deck++)
		{
			for(int suit=1;suit<=4;suit++)
			{
				for(int Rank=1;Rank<=13;Rank++)
				{
					Card card=new Card(suit,Rank);
					cards.add(card);
				}
			}
		}

	}	
	//TODO: Please implement the method to print all cards on screen (10 points)
	public void printDeck(){
		//Hint: print all items in ArrayList<Card> cards, 
		//TODO: please implement and reuse printCard method in Card class (5 points)
		
		
		for(int i=0;i<cards.size();i++){
			Card card=new Card(cards.get(i).getSuit(),cards.get(i).getRank());//把card實體化，cards.get(i).getSuit()存花色，cards.get(i).getRank()存數字
			card.printCard();
		}
		
		

	}
	public ArrayList<Card> getAllCards(){
		return cards;
	}
}
/**
 * Description: TODO: please add description here
 */
class Card{
	private int suit; //Definition: 1~4, Clubs=1, Diamonds=2, Hearts=3, Spades=4//private相當於public，只是不同在他只能在自己的class使用
	private int rank; //1~13
	/**
	 * @param s suit
	 * @param r rank
	 */
	
	public Card(int s,int r){
		suit=s;
		rank=r;
		
		
	}	
	
	//TODO: 1. Please implement the printCard method (20 points, 10 for suit, 10 for rank)
	public void printCard(){String []cards={"1","2","3","4","5","6","7","8","9","10","Jake","Queen","King"};
	//cards 裡面存了13張牌，會用String是因為裡頭有英文字母
	if((getSuit()==1))//當getSuit()=1,此時花色是Clubs梅花
	{
		System.out.println("Clubs of "+cards[(getRank()-1)]);
	}
	 if(getSuit()==2)//當getSuit()=2,花色是Diamonds方塊
	{
		System.out.println("Diamonds of "+cards[(getRank()-1)]);
	}
	 if(getSuit()==3)//當getSuit()=3,此時花色是Hearts紅心
	{
		System.out.println("Hearts of "+cards[(getRank()-1)]);
	}
	 if(getSuit()==4)//當getSuit()=4,花色是Spades黑桃
	{
		System.out.println("Spades of "+cards[(getRank()-1)]);
	}
		
	}
	
	
	public int getSuit(){
		return suit;
	}
	public int getRank(){
		return rank;
	}
}
