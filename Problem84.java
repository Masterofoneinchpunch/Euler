package com.mooip.code.projectEuler;

import com.mooip.code.util.DeckOfCards;
import com.mooip.util.ListUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Monopoly odds. I solved this with a Monte Carlo simulation.  Markov Chains might be a
 * better approach.
 *
 * @author masterofoneinchpunch
 * @see <a href="https://projecteuler.net/problem=84">Monopoly odds</a>
 * @see <a href="https://en.wikipedia.org/wiki/Monte_Carlo_method">Monte Carlo method</a>
 */
public final class Problem84 {
    private static final int MAX_LOOPS = 1000000; 
    private static final int DICE_SIZE = 4;
    private static final int NUM_SQUARES = 40;
    private static final int CHANCE_CARDS = 16;
    private static final int COMMUNITY_CHEST_CARDS = 16;
    
    private static final int GO = 0;
    private static final int JAIL = 10;
    private static final int CH1 = 7;
    private static final int CH2 = 22;
    private static final int CH3 = 36;
    private static final int CC1 = 2;
    private static final int CC2 = 17;
    private static final int CC3 = 33;
    private static final int C1 = 11;
    private static final int E3 = 24;
    private static final int H2 = 39;
    private static final int R1 = 5;
    private static final int R2 = 15;
    private static final int R3 = 25;
    private static final int U1 = 12;
    private static final int U2 = 28;
    private static final int G2J = 30;
    
    public Problem84() {
    }

    //answer is 101524
    //note with a six-sided dice I was getting different results with the third value 
    //between GO and D3.  The four-sided dice gave consistent results.
    public static String problem84() {
        String model = "";
        int doubleRolls = 0;
        int[] boardSquares = new int[NUM_SQUARES];
        Random random = new Random();
        int location = 0;
        DeckOfCards chance = new DeckOfCards(CHANCE_CARDS);
        DeckOfCards communityChest = new DeckOfCards(COMMUNITY_CHEST_CARDS);
                
        for (int i = 0; i < MAX_LOOPS; i++) {
            final int dice1Roll = random.nextInt(DICE_SIZE) + 1;
            final int dice2Roll = random.nextInt(DICE_SIZE) + 1;
            
            if (dice1Roll == dice2Roll) {
                doubleRolls++;
            } else {
                doubleRolls = 0;
            }
            
            if (doubleRolls == 3) {
                doubleRolls = 0;
                location = JAIL;
                boardSquares[JAIL]++; //go directly to jail
                continue;
            } else {
                location = (location + dice1Roll + dice2Roll) % NUM_SQUARES;
            }
            
            if (location == CH1 || location == CH2 || location == CH3) {
                final int chanceCard = chance.getNextCard();
                switch (chanceCard) {
                    case 0:
                        location = GO;
                        break;
                    case 1:
                        location = JAIL;
                        break;
                    case 2:
                        location = C1;                        
                        break;
                    case 3:
                        location = E3;
                        break;
                    case 4:
                        location = H2;
                        break;
                    case 5:
                        location = R1;
                        break;
                    case 6:
                    case 7:
                        switch (location) {
                            case CH1:
                                location = R2;
                                break;
                            case CH2:
                                location = R3;
                                break;
                            case CH3:
                                location = R1;
                                break;
                        }
                        break;
                    case 8:
                        location = (location == CH1 || location == CH3) ? U1 : U2;
                        break;
                    case 9:
                        location -= 3; //go back three squares
                        break;
                    default:
                        break;
                }
            }
            if (location == CC1 || location == CC2 || location == CC3) {
                final int communityChessCard = communityChest.getNextCard();
                if (communityChessCard == 0) {
                    location = GO;
                } else if (communityChessCard == 1) {
                    location = JAIL;
                }
            }
            
            if (location == G2J) {
                location = JAIL;
            }
            
            boardSquares[location]++;
        }
        System.out.println("JAIL: " + (double) boardSquares[JAIL] / MAX_LOOPS);
        System.out.println("E3: " + (double) boardSquares[E3] / MAX_LOOPS);
        System.out.println("GO: " + (double) boardSquares[GO] / MAX_LOOPS);
        System.out.println("19 (D3): " + (double) boardSquares[19] / MAX_LOOPS);
        System.out.println("boardSquares: " + Arrays.toString(boardSquares));
        
        List<Integer> originalBoard = ListUtil.toList(boardSquares);
        List<Integer> newBoard = new ArrayList(originalBoard);
        Collections.sort(newBoard, Collections.reverseOrder());
               
        for (int i = 0; i < 3; i++) {
            model += String.format("%02d",originalBoard.indexOf(newBoard.get(i)));
        }
        System.out.println("model: " + model);
        
        return model;
    }

    public static void main(String[] args){
        System.out.println(problem84());
    }   
}


