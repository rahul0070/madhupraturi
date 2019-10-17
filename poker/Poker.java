package poker;

import java.util.ArrayList;
import java.util.List;

class Card
{
        int rank;
        char suit; 
        String cardNumber;
        int flag = 0;
        List<String> cardValue = new ArrayList<String>();
        
        void assignRank(Card[] hand)
        {  
            cardValue.add("2");cardValue.add("3");cardValue.add("4");cardValue.add("5");cardValue.add("6");cardValue.add("7");cardValue.add("8");cardValue.add("9");cardValue.add("10");cardValue.add("J");cardValue.add("Q");cardValue.add("K");cardValue.add("A");
            for(int i=0 ;i<5;i++)
            {
                for(String card : cardValue)
                {
                    if(hand[i].cardNumber == card)
                        hand[i].rank = cardValue.indexOf(card)+1;
                }
            }
        }
}

public class Poker extends Card
{  
    int score = 0;
    Card hand[] =  new Card[6];
    int count = 0;
    Poker()
    {     
        for(int i=0;i<6;i++)
        {
            hand[i] = new Card();
        }
    }
    
    void print(Card[] hand)
    {
        for(int i=0;i<5;i++)
        {
            System.out.println(hand[i].cardNumber+" "+hand[i].rank+" "+hand[i].flag+" ");
        }
    }
    int checkWinner(Card[] hand1, Card[] hand2)
    {
        assignRank(hand1); assignRank(hand2);
        int score1 = evaluateHand(hand1);
        int score2 = evaluateHand(hand2);
        int result = compareScores(score1,score2);
        if(result==0)
            result = equalScore(hand1,hand2); 
        return result;
    }
    
    int compareScores(int score1,int score2)
    {
        if(score1>score2)
            return 1;
        else if(score2>score1)
            return 2;
        else
            return 0;
    }
    int equalScore(Card[] hand1, Card[] hand2)
    {
        int score1 = checkHighCard(hand1);
        int score2 = checkHighCard(hand2);
        count++;
        
        int result = compareScores(score1,score2);
        if(result == 0 && count<5)
            result = equalScore(hand1,hand2);
        return result;
    }
   
     int evaluateHand(Card[] hand)
    {
        
        if (checkRoyalFlush(hand) == 1)
        {
            score = 9;
            return score;
        }
        else if (checkStraightFlush(hand) == 1)
        {
            score =8;
            return score;
        }
        else if (checkFourOfaKind(hand) == 1)
        {
            score = 7;
            return score;
        }
        else if (checkFullHouse(hand) == 1)
        {
            score = 6;
            return score;
        }
        else if (checkFlush(hand) == 1)
        {
            score = 5;
            return score;
        }
        else if (checkStraight(hand) == 1)
        {
            score = 4;
            return score;
        }
        else if (checkTriple(hand) == 1)
        {
            score = 3;
            return score;
        }
        else if (checkTwoPairs(hand) == 1)
        {
            score = 2;
            return score;
        }
        else if (checkPair(hand) == 1)
        {
            score = 1;
            return score;
        }
        else
        {
            int highCard = this.checkHighCard(hand);
            return highCard;
        }
    }
    
    public int checkRoyalFlush(Card[] hand)
    {
        if (hand[0].rank == 1 && hand[0].flag==0 && hand[1].rank == 10 && hand[1].flag==0 && hand[2].rank == 11 &&
                hand[2].flag==0 && hand[3].rank == 12 && hand[3].flag==0 && hand[4].rank == 13 && hand[4].flag==0)
        {
            return 1;
        }
        else
        {
            return 0;
        }
    }
    
    public int checkStraightFlush(Card[] hand)
    {
        for (int counter = 1; counter < 5; counter++)
        {
            if(hand[counter].flag == 0)
            {
                if (hand[0].suit != hand[counter].suit)
                {
                    return 0;
                }
            }
        }
        for (int counter2 = 1; counter2 < 5; counter2++)
        {
            if(hand[counter2].flag == 0)
            {
            if (hand[counter2 - 1].rank != (hand[counter2].rank - 1))
            {
                return 0;
            }
            }
                
        }
        return 1;
        
    }
    
    public int checkFourOfaKind(Card[] hand)
    {
        if (hand[0].rank != hand[3].rank && hand[0].flag==0 && hand[3].flag==0 && hand[1].rank != hand[4].rank && hand[1].flag==0 && hand[4].flag==0 )
        {
            return 0;
        }
        else
        {
            return 1;
        }
    }
    

    public int checkFullHouse(Card[] hand)
    {
        int comparison = 0;       
        for (int counter = 1; counter < 5; counter++)
        {
            if(hand[counter].flag == 0)
            {
                if (hand[counter - 1].rank == hand[counter].rank)
                    comparison++;
            }
        }
        if (comparison == 3)
            return 1;       
        else
            return 0;
    }
    
    public int checkFlush(Card[] hand)
    {
        for (int counter = 1; counter < 5; counter++)
        {
            if(hand[counter].flag == 0)
            {
                if (hand[0].suit != hand[counter].suit)
                    return 0;
            }
        }
        return 1;
    }
    
    public int checkStraight(Card[] hand)
    {
        for (int counter2 = 1; counter2 < 5; counter2++)
        {
            if(hand[counter2].flag == 0)
            {
                if (hand[counter2 - 1].rank != (hand[counter2].rank - 1))
                    return 0;  
            }               
        }
        return 1;
    }
    
    public int checkTriple(Card[] hand)
    {
        if (hand[0].rank == hand[2].rank && hand[0].flag ==0 && hand[2].flag ==0 || hand[2].rank == hand[4].rank && hand[4].flag == 0)
        {
            return 1;
        }
        return 0;
    }
    
    public int checkTwoPairs(Card[] hand)
    {
        int check = 0;
        for(int counter = 1; counter < 5; counter++)
        {
            if(hand[counter].flag == 0)
            {
                if (hand[counter - 1].rank == hand[counter].rank)
                    check++;
            }
        }
        if (check == 2)
            return 1;
        else
            return 0;
    }
    
    public int checkPair(Card[] hand)
    {
        int check = 0;
        for(int counter = 1; counter < 5; counter++)
        {
            if(hand[counter].flag == 0)
            {
                if (hand[counter - 1].rank == hand[counter].rank)
                    check++;
            }
        }
        if (check == 1)
            return 1;
        else
            return 0;
    }
    
    public int checkHighCard(Card[] hand)
    {
        int highCard = 0;
        for (int counter = 0; counter < 5; counter++)
        {
            if(hand[counter].flag == 0)
            {
                if (hand[counter].rank > highCard)
                    highCard = hand[counter].rank;
            }
            if(hand[counter].rank == highCard)
                hand[counter].flag = 1;
        }
        return highCard;
       
    }
   
}