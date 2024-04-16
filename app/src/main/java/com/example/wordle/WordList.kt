package com.example.wordle

class WordList { //class that stores all Wordle game possible answers
    private val words: List<String> = listOf(
        "apple", "bacon", "bagel", "basil", "beans", "berry", "bread", "cacao", "candy", "caper",
        "chili", "chips", "cider", "cream", "crisp", "curry", "dates", "decaf", "donut", "flour",
        "fries", "grape", "guava", "honey", "jelly", "juice", "kebab", "kefir", "latte", "lemon",
        "mango", "melon", "mocha", "nacho", "olive", "onion", "pasta", "peach", "pecan", "pesto",
        "pizza", "punch", "quark", "ramen", "salsa", "salad", "squid", "steak", "sugar", "sushi",
        "syrup", "toast", "tonic", "trout", "water", "yeast"
    )

    fun randomWord(): String { //function that chooses random word for the game
        return words.random()
    }
}