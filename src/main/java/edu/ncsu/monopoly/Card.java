package edu.ncsu.monopoly;
//updated 2021
public abstract class Card {
//Card comment
    public static final int TYPE_CHANCE = 1;
    public static final int TYPE_CC = 2;

    public abstract String getLabel();
    public abstract void applyAction();
    public abstract int getCardType();
}
