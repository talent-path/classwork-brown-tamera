import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PokerHand {
    //field variables
    //we'll "compose" a poker hand from multiple sub-objects that we pull into a collection
    private Card[] cards;

    //need a constructor to make sure every hand is built with all the cards needed
    public PokerHand(Card[] cards) {
        //for now we'll cross our fingers and hope its always 5
//        if( cards.length < 5 ){
//            //TODO: create a specific exception for this
//            throw new Exception("Invalid number of cards.");
//        }


        this.cards = cards;

        sortCards();
    }

    private void sortCards() {

        //bubble sort
        boolean sorted = false;

        while (!sorted) {

            sorted = true;
            for (int i = 0; i < cards.length - 1; i++) {
                //does the element at i need to be flipped with the element at i + 1?
                if ((cards[i].getCardValue().value < cards[i + 1].getCardValue().value) ||

                        (cards[i].getCardValue().value == cards[i + 1].getCardValue().value
                                && cards[i].getCardSuit().value < cards[i + 1].getCardSuit().value
                        )
                ) {
                    //we need to swap elements at i and i + 1
                    //it also means we found elements out of order
                    sorted = false;
                    Card temp = cards[i + 1];
                    cards[i + 1] = cards[i];
                    cards[i] = temp;
                }
            }

        }

    }

    public Card[] getCards() {
        return cards;
    }

    public Map<FaceValue, Integer> countFaceValues() {

        Map<FaceValue, Integer> count = new HashMap<FaceValue, Integer>();

        for (Card toCount : cards) {
            if (!count.containsKey(toCount.getCardValue())) {
                count.put(toCount.getCardValue(), 0);
            }

            Integer currentCount = count.get(toCount.getCardValue());

            count.put(toCount.getCardValue(),
                    1 + currentCount);

        }

        return count;
    }

    public Map<Suit, Integer> countSuits() {

        Map<Suit, Integer> count = new HashMap<Suit, Integer>();

        for (Card toCount : cards) {
            if (!count.containsKey(toCount.getCardSuit())) {
                count.put(toCount.getCardSuit(), 0);
            }

            Integer currentCount = count.get(toCount.getCardSuit());

            count.put(toCount.getCardSuit(),
                    1 + currentCount);

        }

        return count;
    }


    //if no straight, return a null
    public FaceValue straightHighCardValue() {
        Map<FaceValue, Integer> straFlush = countFaceValues();
        int start = this.cards[0].getCardValue().value;
        for (int i = start; i > start - 5; i--) {
            if (straFlush.keySet().contains(i)) {

            } else return null;
        }
        return null;
    }

    public boolean isFlush() {
        Map<Suit, Integer> suits = countSuits();

        return suits.keySet().size() == 1;

    }

    public boolean isStraightFlush() {
        return (straightHighCardValue() != null) && isFlush();
    }

    public boolean isFullHouse() {
        return pairValue() != null && threeOfAKindValue() != null;
    }

    public boolean isRoyalFlush() {
        return isStraightFlush() && cards[0].getCardValue() == FaceValue.ACE;
    }

    //if not 4 of a kind, return null
    public FaceValue fourOfAKindValue() {
        Map<FaceValue, Integer> face = countFaceValues();
        if (face.keySet().size() == 2) {
            for (FaceValue key : face.keySet()) {
                if (key.value == 4)
                    return key;
            }

        }
        return null;
    }

    //should return null if there are really 4
    public FaceValue threeOfAKindValue() {
        Map<FaceValue, Integer> face = countFaceValues();
        if (face.keySet().size() == 3) {
            for (FaceValue key : face.keySet()) {
                if (key.value == 3) return key;
            }
        }
        return null;
    }

    //should return null if there are really 3 (or more of the same card)
    public FaceValue pairValue() {
        Map<FaceValue, Integer> face = countFaceValues();

        for (FaceValue key : face.keySet()) {
            if (face.get(key) == 2) {

                return key;
            }
        }


        return null;

    }

    //should return null when there is only one pair
    public FaceValue higherPairValue() {
        List<FaceValue> c1 = new ArrayList<>();
        Map<FaceValue, Integer> face = countFaceValues();
        if (pairValue() == null) return null;

        for (FaceValue key : face.keySet()) {
            if (face.get(key) == 2) {
                c1.add(key);
            }
        }
        if (c1.size() == 2) {
            return c1.get(0).value < c1.get(1).value ? c1.get(1) : c1.get(0);
        }


        return null;
    }

    public static void sevenChooseFive(
            Card[] possible,
            int nextIndex,
            List<Card> currentlySelected,
            List<List<Card>> allCombinations) {

        int chosenNum = currentlySelected.size();
        int remainingNum = 5 - chosenNum;

        int availableCards = possible.length - nextIndex;


        //base cases
        if (currentlySelected.size() == 5) {
            List<Card> copy = new ArrayList<>();
            for (Card toCopy : currentlySelected) copy.add(toCopy);

            allCombinations.add(copy);
            return;
        }

        //if( nextIndex >= possible.length ) return;

        if (availableCards < remainingNum)
            return;

        //iterate through each card
        //for each card, we either include or don't
        //we'll try the recursion with the card included and with
        //the card excluded


        //try with the "card" first
        currentlySelected.add(possible[nextIndex]);
        sevenChooseFive(possible, nextIndex + 1, currentlySelected, allCombinations);

        currentlySelected.remove(currentlySelected.size() - 1);

        //try without choosing the card
        sevenChooseFive(possible, nextIndex + 1, currentlySelected, allCombinations);

    }


    //return 0 if "this" ties with "that"
    //return negative number if "this" wins over "that"
    //return positive number if "this" loses to "that"
    public int compareTo(PokerHand that) {
        int player = this.getRoughValue();
        int em = that.getRoughValue();

        if (player > em) {
            return -1;
        } else if (player < em) {
            return 1;
        }


        return 0;    //for now
    }

    public int roughRank(int rank) {
       // int num;
        switch (rank) {
            case 10: return 12;
            //case 9: return this.getCards()

        }
        return 0;
    }


    public int getRoughValue(){
        int player = 0;
        if(this.isRoyalFlush()){
            player = 10;
        }
        else if(this.isStraightFlush()){
            player = 9;
        }
        else if(this.fourOfAKindValue() != null){
            player = 8;
        }
        else if(this.isFullHouse()){
            player = 7;
        }
        else if(this.isFlush()){
            player = 6;
        }

        else if(this.straightHighCardValue()!=null){
            player=5;
        }
        else if(this.threeOfAKindValue()!=null){
            player=4;
        }
        else if(this.higherPairValue()!=null){
            player=3;
        }
        else if(this.pairValue()!=null){
            player=2;
        }
        else player=1;

        return player;

    }

    }

    //in general compareTo() sematics are
    // - means "this before that"
    // 0 means "they're equal"
    // + means "that before this"





