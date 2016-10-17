package com.dev.touyou.flashcardplus;

/**
 * Created by touyou on 2016/10/17.
 */
public class Card {
    public int imageId;
    public String title;
    public String content;
    public int likeNum = 0;

    public String meaning;

    public Card(int imageId, String title, String content, String meaning) {
        this.imageId = imageId;
        this.title = title;
        this.content = content;
        this.meaning = meaning;
    }
}
