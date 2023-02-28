package com.mooip.code.projectEuler;

import com.mooip.util.IOUtil;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Poker hands.
 * 
 * @author masterofoneinchpunch
 * @see <a href="https://projecteuler.net/problem=54">Poker hands</a>
 */
public final class Problem54 {
    public static final int FIVE_CARD_NODRAW = 5;
    private static final int TIE = 0;
    private static final int LOSS = -1;
    private static final int WIN = 1;
    
    public Problem54() {
    }

    public static final class Hand {
        private final List<Card> cards;
        
        private Integer twoOfAKind = null;
        private Integer secondTwoOfAKind = null;
        private Integer threeOfAKind = null;
        private Integer fourOfAKind = null;
        private final List<Integer> singleFaces = new ArrayList<Integer>();
        
        public Hand(int handSize) {
            this.cards = new ArrayList<Card>(handSize);
        }
        
        public void addCard(Card card) {
            this.cards.add(card);
        }

        public Integer getFourOfAKind() {
            return this.fourOfAKind;
        }
        
        public Integer getThreeOfAKind() {
            return this.threeOfAKind;
        }
        
        public Integer getTwoOfAKind() {
            return this.twoOfAKind;
        }

        public Integer getSecondTwoOfAKind() {
            return this.secondTwoOfAKind;
        }
        
        public List<Integer> getSingleFaces() {
            return this.singleFaces;
        }

        public Integer compareSingleFaces(List<Integer> opponent) {
            //both this and opponent should be in sorted order desc.
            for (int i = 0; i < this.singleFaces.size(); ++i) {
                if (singleFaces.get(i).compareTo(opponent.get(i)) != 0) {
                    return singleFaces.get(i).compareTo(opponent.get(i));
                }
            }
            return 0;
        }
        
        private List<Integer> getFacePoints() {
            List<Integer> facePoints = new ArrayList<Integer>();
            
            for (int i = 0; i < cards.size(); i++) {
                facePoints.add(cards.get(i).getFace().getFacePoints());
            }
            
            return facePoints;
        }

        public void setUpHand() {
            List<Integer> facePoints = getFacePoints();
            Collections.sort(facePoints, Collections.reverseOrder());
            for (int i = 0; i < facePoints.size(); i++) {
                final int points = facePoints.get(i);
                int freq = Collections.frequency(facePoints, points);
                
                if (freq > 1) {
                    if (freq == 2 && twoOfAKind != null) {
                        secondTwoOfAKind = points;
                    }
                    if (freq == 2 && twoOfAKind == null) {
                        twoOfAKind = points;
                    }
                    if (freq == 3) {
                        threeOfAKind = points;
                    }
                    if (freq == 4) {
                        fourOfAKind = points;
                    }
                    
                    boolean keepRemoving = true;
                    while (keepRemoving) {
                        keepRemoving = facePoints.remove(new Integer(points));
                    }
                }
            }
            singleFaces.addAll(facePoints);
        }
        
        public Card getHighCard() {
            return Collections.max(cards);
        }
        
        public boolean hasTwoOfAKind() {
            return this.twoOfAKind != null;
        }

        public boolean hasSecondTwoOfAKind() {
            return this.secondTwoOfAKind != null;
        }
        
        public boolean hasThreeOfAKind() {
            return this.threeOfAKind != null;
        }

        public boolean hasFourOfAKind() {
            return this.fourOfAKind != null;
        }
        
        public boolean hasFullHouse() {
            return hasThreeOfAKind() && hasTwoOfAKind();
        }
        
        public boolean hasFlush() {
            boolean hasFlush = true;
            Card.Suit prevCard = cards.get(0).getSuit();
            for (int i = 1; i < cards.size(); ++i) {
                if (prevCard.equals(cards.get(i).getSuit()) == false) {
                    return false;
                }
            }
            
            return hasFlush;
        }

        public boolean hasStraight() {
            boolean hasStraight = true;
            List<Integer> facePoints = getFacePoints();
            Collections.sort(facePoints);
            int faceValue = facePoints.get(0);
            for (int i = 1; i < facePoints.size(); i++) {
                int nextValue = facePoints.get(i);
                if ((faceValue + 1 == nextValue) == false) {
                    return false;
                }
                faceValue = nextValue;
            }
            
            return hasStraight;
        }

        public boolean hasStraightFlush() {
            return hasFlush() && hasStraight();
        }
        
        public boolean hasRoyalFlush() {
            return hasStraightFlush() && (getHighCard().getFace() == Card.Face.ACE);
        }
        
        public int playHand(Hand opponent) {
            if (hasRoyalFlush() || opponent.hasRoyalFlush()) {
                System.out.println("We have a royal flush");
                if (hasRoyalFlush() && opponent.hasRoyalFlush()) {
                    System.out.println("Both have royal flush: ha!!!");
                    return TIE;
                } else if (hasRoyalFlush()) {
                    return WIN;
                } else {
                    return LOSS;
                }               
            } 
            
            if (hasStraightFlush() || opponent.hasStraightFlush()) {
                System.out.println("We have a straight flush");
                if (hasStraightFlush() && opponent.hasStraightFlush()) {
                    System.out.println("Both have straight flush");
                    return getHighCard().compareTo(opponent.getHighCard());
                } else if (hasStraightFlush()) {
                    return WIN;
                } else {
                    return LOSS;
                }               
            } 
            
            if (hasFourOfAKind() || opponent.hasFourOfAKind()) {
                System.out.println("We have a four of a kind");
                if (hasFourOfAKind() && opponent.hasFourOfAKind()) {
                    System.out.println("Both have a four of a kind");
                    if (this.fourOfAKind.compareTo(opponent.getFourOfAKind()) == 0) {
                        return compareSingleFaces(opponent.getSingleFaces());
                    } else {
                        return this.fourOfAKind.compareTo(opponent.getFourOfAKind());
                    }
                } else if (hasFourOfAKind()) {
                    return WIN;
                } else {
                    return LOSS;
                }               
            }
            
            if (hasFullHouse() || opponent.hasFullHouse()) {
                System.out.println("We have a full house");
                if (hasFullHouse() && opponent.hasFullHouse()) {
                    System.out.println("Both have full house");
                    if (this.threeOfAKind.compareTo(opponent.getThreeOfAKind()) == 0) {
                        return this.twoOfAKind.compareTo(opponent.getTwoOfAKind());
                    } else {
                        return this.threeOfAKind.compareTo(opponent.getThreeOfAKind());
                    }                    
                } else if (hasFullHouse()) {
                    return WIN;
                } else {
                    return LOSS;
                }               
            }
            
            if (hasFlush() || opponent.hasFlush()) {
                System.out.println("We have a flush");
                if (hasFlush() && opponent.hasFlush()) {
                    System.out.println("Both have flush");
                    return getHighCard().compareTo(opponent.getHighCard());
                } else if (hasFlush()) {
                    return WIN;
                } else {
                    return LOSS;
                }               
            } 
            
            if (hasStraight() || opponent.hasStraight()) {
                System.out.println("We have a straight");
                if (hasStraight() && opponent.hasStraight()) {
                    System.out.println("Both have straight");
                    return getHighCard().compareTo(opponent.getHighCard());
                } else if (hasStraight()) {
                    return WIN;
                } else {
                    return LOSS;
                }               
            } 
            
            if (hasThreeOfAKind() || opponent.hasThreeOfAKind()) {
                System.out.println("We have a three of a kind");
                if (hasThreeOfAKind() && opponent.hasThreeOfAKind()) {
                    System.out.println("Both have a three of a kind");
                    if (this.threeOfAKind.compareTo(opponent.getThreeOfAKind()) == 0) {
                        return compareSingleFaces(opponent.getSingleFaces());
                    } else {
                        return this.threeOfAKind.compareTo(opponent.getThreeOfAKind());
                    }                     
                } else if (hasThreeOfAKind()) {
                    return WIN;
                } else {
                    return LOSS;
                }
            }
            
            if (hasSecondTwoOfAKind() || opponent.hasSecondTwoOfAKind()) {
                System.out.println("We have two pair");
                if (hasSecondTwoOfAKind() && opponent.hasSecondTwoOfAKind()) {
                    System.out.println("Both have two pair");
                    if (this.twoOfAKind.compareTo(opponent.getTwoOfAKind()) == 0) {
                        if (this.secondTwoOfAKind.compareTo(opponent.getSecondTwoOfAKind()) == 0) {
                            return compareSingleFaces(opponent.getSingleFaces());
                        } else {
                            return this.secondTwoOfAKind.compareTo(opponent.getSecondTwoOfAKind());
                        }
                    } else {
                        return this.twoOfAKind.compareTo(opponent.getTwoOfAKind());
                    }                     
                } else if (hasSecondTwoOfAKind()) {
                    return WIN;
                } else {
                    return LOSS;
                }
            }
            
            if (hasTwoOfAKind()|| opponent.hasTwoOfAKind()) {
                System.out.println("We have two of a kind");
                if (hasTwoOfAKind() && opponent.hasTwoOfAKind()) {
                    System.out.println("Both have two of a kind");
                    if (this.twoOfAKind.compareTo(opponent.getTwoOfAKind()) == 0) {
                        System.out.println("Now checking singles");
                        return compareSingleFaces(opponent.getSingleFaces());
                    } else {
                        return this.twoOfAKind.compareTo(opponent.getTwoOfAKind());
                    }
                } else if (hasTwoOfAKind()) {
                    return WIN;
                } else {
                    return LOSS;
                }               
            } 
            
            return compareSingleFaces(opponent.getSingleFaces());
        }
        
        @Override
        public String toString() {
            final String newline = System.getProperty("line.separator");
            StringBuilder sb = new StringBuilder();

            sb.append("hasRoyalFlush = ").append(this.hasRoyalFlush()).append(newline);    
            sb.append("hasStraightFlush = ").append(this.hasStraightFlush()).append(newline);    
            sb.append("hasFourOfAKind = ").append(this.hasFourOfAKind()).append(newline);    
            sb.append("hasFullHouse = ").append(this.hasFullHouse()).append(newline);    
            sb.append("hasFlush = ").append(this.hasFlush()).append(newline);    
            sb.append("hasStraight = ").append(this.hasStraight()).append(newline);    
            sb.append("hasThreeOfAKind = ").append(this.hasThreeOfAKind()).append(newline);    
            sb.append("hasSecondTwoOfAKind = ").append(this.hasSecondTwoOfAKind()).append(newline);    
            sb.append("hasTwoOfAKind = ").append(this.hasTwoOfAKind()).append(newline);    
            sb.append("highCard = ").append(this.getHighCard()).append(newline);    
            sb.append("getSingleFaces = ").append(this.getSingleFaces()).append(newline);    
            
            return sb.toString();
        }        
    }
    
    public static class Card implements Comparable<Card> {

        public enum Face {
            DEUCE(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10), JACK(11), QUEEN(12), KING(13), ACE(14);

            private final int facePoints;

            private Face(int points) {
                this.facePoints = points;
            }

            public int getFacePoints() {
                return this.facePoints;
            }

            public static Face getFaceFromId(int id) {
                for (Face type : values()) {
                    if (type.getFacePoints() == id) {
                        return type;
                    }
                }
                return null;
            }            
            
            public static Face getFace(Character faceValue) {
                switch (faceValue) {
                    case 'A':
                        return ACE;
                    case 'K':
                        return KING;
                    case 'Q':
                        return QUEEN;
                    case 'J':
                        return JACK;
                    case 'T':
                        return TEN;
                    case '9':
                        return NINE;
                    case '8':
                        return EIGHT;
                    case '7':
                        return SEVEN;
                    case '6':
                        return SIX;
                    case '5':
                        return FIVE;
                    case '4':
                        return FOUR;
                    case '3':
                        return THREE;
                    case '2':
                        return DEUCE;
                    default:
                        System.out.println("This should never reach here.");
                        break;
                }
                return DEUCE;
            }            
        }
        
        public enum Suit {
            CLUBS("C"), DIAMONDS("D"), HEARTS("H"), SPADES("S");
            
            private final String suit;
            
            private Suit(String suit) {
                this.suit = suit;
            }
            
            public String getSuitString() {
                return this.suit;
            }

            public static Suit getSuit(String suitString) {
                if (suitString.equals("C")) {
                    return CLUBS;
                } else if (suitString.equals("D")) {
                    return DIAMONDS;
                } else if (suitString.equals("H")) {
                    return HEARTS;
                } else {
                    return SPADES;
                }                        
            }
        }
        
        private final Face face;
        private final Suit suit;

        public Card(Face face, Suit suit) {
            this.face = face;
            this.suit = suit;
        }
        
        public Face getFace() {
            return face;
        }

        public Suit getSuit() {
            return suit;
        }

        @Override
        public int compareTo(Card card) {
            if (this.face.getFacePoints() > card.getFace().getFacePoints()) {
                return 1;
            } else if (this.face.getFacePoints() == card.getFace().getFacePoints()) {
                return 0;
            }
            
            return -1;
        }
        
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();

            sb.append("face = ").append(this.face).append(", ");    
            sb.append("suit = ").append(this.suit); 
            
            return sb.toString();
        }
    }
    
    //answer is 376
    public static int problem54() {   
        int playerOneWins = 0;
        try {
            BufferedReader reader = IOUtil.getBufferedFileReader("C:\\shawns" + File.separatorChar + "p054_poker.txt");
            String input;
            int handsPlayed = 0;
            while ((input = reader.readLine()) != null) {
                System.out.println(input);
                Hand playerOne = new Hand(FIVE_CARD_NODRAW);
                Hand playerTwo = new Hand(FIVE_CARD_NODRAW);

                String[] cards = input.split(" ");
                for (int i = 0; i < cards.length; i++) {
                    Card card = new Card(Card.Face.getFace(cards[i].charAt(0)), Card.Suit.getSuit(cards[i].substring(1,2)));
                    if (i < FIVE_CARD_NODRAW) {
                        playerOne.addCard(card);
                    } else {
                        playerTwo.addCard(card);
                    }                    
                }
                
                playerOne.setUpHand();
                playerTwo.setUpHand();
                
                if (playerOne.playHand(playerTwo) == WIN) {
                    playerOneWins++;
                }
                handsPlayed++;
            }
            System.out.println("total hands played: " + handsPlayed);
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
        
        return playerOneWins;
    }

    public static void main(String[] args){
        System.out.println(problem54());
    } 
}

