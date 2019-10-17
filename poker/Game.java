package poker;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Game extends Poker 
{
    Card[] player1 = new Card[6];
    Card[] player2 = new Card[6];
    Poker game = new Poker();
    
    void initialise()
    {
        for(int i=0;i<5;i++)
        {
            player1[i] = new Card();
            player2[i] = new Card();
        }
    }
    
   @Test
    public void testRoyalFlush()
    {
        int expectedResult = 2;
        initialise();
        player1[0].cardNumber = "A"; player1[1].cardNumber = "K"; player1[2].cardNumber = "Q"; player1[3].cardNumber = "J";
        player1[4].cardNumber = "10";   
        player1[0].suit = 'S'; player1[1].suit = 'S'; player1[2].suit = 'S'; player1[3].suit ='S'; player1[4].suit = 'S';
        
        player2[0].cardNumber = "A"; player2[1].cardNumber = "2"; player2[2].cardNumber = "3"; player2[3].cardNumber = "6";
        player2[4].cardNumber = "10";  
        player2[0].suit = 'S'; player2[1].suit = 'C'; player2[2].suit = 'D'; player2[3].suit ='D'; player2[4].suit = 'H';
        assertEquals(expectedResult, game.checkWinner(player1,player2));
        
    }
    
    @Test
    public void testFourOfAKind()
    {
        int expectedResult = 2;
        initialise();
        player1[0].cardNumber = "A"; player1[1].cardNumber = "A"; player1[2].cardNumber = "A"; player1[3].cardNumber = "A";
        player1[4].cardNumber = "10";   
        player1[0].suit = 'S'; player1[1].suit = 'C'; player1[2].suit = 'D'; player1[3].suit ='C'; player1[4].suit = 'S';
        
        player2[0].cardNumber = "5"; player2[1].cardNumber = "4"; player2[2].cardNumber = "3"; player2[3].cardNumber = "2";
        player2[4].cardNumber = "A";  
        player2[0].suit = 'S'; player2[1].suit = 'S'; player2[2].suit = 'S'; player2[3].suit ='S'; player2[4].suit = 'S';
        assertEquals(expectedResult, game.checkWinner(player1,player2));
       
    }
    
    @Test
    public void testStraightFlush()
    {
        int expectedResult = 1;
        initialise();
        player1[0].cardNumber = "A"; player1[1].cardNumber = "K"; player1[2].cardNumber = "Q"; player1[3].cardNumber = "J";
        player1[4].cardNumber = "10";   
        player1[0].suit = 'S'; player1[1].suit = 'S'; player1[2].suit = 'S'; player1[3].suit ='S'; player1[4].suit = 'S';
        
        player2[0].cardNumber = "5"; player2[1].cardNumber = "4"; player2[2].cardNumber = "3"; player2[3].cardNumber = "2";
        player2[4].cardNumber = "A";  
        player2[0].suit = 'S'; player2[1].suit = 'S'; player2[2].suit = 'S'; player2[3].suit ='S'; player2[4].suit = 'S';
        assertEquals(expectedResult, game.checkWinner(player1,player2));
       
    }
    
    @Test
    public void testTwoPairAndFlush()
    {
        int expectedResult = 2;
        initialise();
        player1[0].cardNumber = "A"; player1[1].cardNumber = "A"; player1[2].cardNumber = "2"; player1[3].cardNumber = "5";
        player1[4].cardNumber = "8";   
        player1[0].suit = 'S'; player1[1].suit = 'C'; player1[2].suit = 'D'; player1[3].suit ='C'; player1[4].suit = 'S';
        
        player2[0].cardNumber = "5"; player2[1].cardNumber = "A"; player2[2].cardNumber = "6"; player2[3].cardNumber = "2";
        player2[4].cardNumber = "10";  
        player2[0].suit = 'S'; player2[1].suit = 'S'; player2[2].suit = 'S'; player2[3].suit ='S'; player2[4].suit = 'S';
        assertEquals(expectedResult, game.checkWinner(player1,player2));
       
    }
    
}