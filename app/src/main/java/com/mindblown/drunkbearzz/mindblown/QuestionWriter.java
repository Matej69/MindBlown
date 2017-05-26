package com.mindblown.drunkbearzz.mindblown;

import android.content.Context;
import android.util.Log;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.Map;

/**
 * Created by Matej on 21/05/2017.
 */


/**************USED ONLY WHEN WRITING WHOLE DATABASE AND PUTTING IT ONLINE
 * THERE IS NO NEED TO COMPILE THIS CLASS WITH .APK IF THERE ALREADY IS INITIALISED DATABASE
 *IN 'DatabaseInit' CLASS WE WILL BE WRITING/INITIALISING DATABASE IF NEEDED BUT THAT WILL NOT BE IN FINAL .APK
 * P.S. WRITTING TO DATABASE SHOULD BE REMOVED AN PUT IN SEPARATE APPLICATION BUT WHO HAS TIME FOR THAT, RIGHT :)
*/

public class QuestionWriter {
/*
    //Write child
    static private void CreateChild(Firebase _parent, String _nameID, String _val)
    {
        Firebase child = _parent.child(_nameID);
        child.setValue(_val);
    }


    static private int numOfQ = 0;
    static public void AddQuestionToDatabase(QuestionInfo.E_CATEGORY _cat, QuestionInfo _questionInfo)
    {
        Firebase category = new Firebase("https://mindblown-cb605.firebaseio.com/" + _cat.toString());

        //Add new Question with name Q+numOfQ
        Firebase newQ = category.child("Q" + String.valueOf(numOfQ));
        numOfQ++;
        //Add new Question properties as childreen
        CreateChild(newQ, "Q", _questionInfo.question);
        CreateChild(newQ, "A1", _questionInfo.answer1);
        CreateChild(newQ, "A2", _questionInfo.answer2);
        CreateChild(newQ, "A3", _questionInfo.answer3);
        CreateChild(newQ, "C", _questionInfo.correctAnswer);
    }


    //**************************************** DATABASE CREATION ********************************************
    //*********************************** WILL NOT BE IN FINAL BUILD ***************************************
    //Init all categories
    static private void InitCategoriesToDatabase()
    {
        Firebase databaseRoot = new Firebase("https://mindblown-cb605.firebaseio.com/");
        for (QuestionInfo.E_CATEGORY category : QuestionInfo.E_CATEGORY.values())
            CreateChild(databaseRoot, category.toString(), "0");
    }

    static public void InitDatabase() {
        InitCategoriesToDatabase();

        //ANIMALS
        numOfQ = 0;
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.ANIMALS, new QuestionInfo("A chameleon's tongue can be as long as...", "Its Body", "Human hand", "2.76 meters", "Its Body"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.ANIMALS, new QuestionInfo("Great white sharks can detect a drop of blood from...", "3 miles away", "1 mile", "3.7 kilometers away", "3 miles away"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.ANIMALS, new QuestionInfo("The blue whale's tongue weighs as much as an...", "Adult elephant", "Adult bear", "3 adult bisons", "Adult elephant"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.ANIMALS, new QuestionInfo("Houseflies hum in the shape of letter...", "F", "O", "L", "F"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.ANIMALS, new QuestionInfo("Fleas can jump distances longer then how many times fo their body length?", "70", "100", "150", "70"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.ANIMALS, new QuestionInfo("What is the loudest land animal?", "Silver tusk elephant", "Howler monkey", "Gray wolf", "Howler monkey"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.ANIMALS, new QuestionInfo("With good hearing you could hear blue whales from...", "5 miles away", " 250 miles away", "500 miles away", "500 miles away"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.ANIMALS, new QuestionInfo("A cheetah can go from zero to 60 miles in...", "3 seconds", "4 seconds", "5 seconds", "3 seconds"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.ANIMALS, new QuestionInfo("Male emperor penguins will stand without eating for up to...", "30 days", "45 days", "60 days", "60 days"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.ANIMALS, new QuestionInfo("Which male animal bears the unborn young?", "Seahorse", "Kangaroo", "Pelican", "Seahorse"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.ANIMALS, new QuestionInfo("Which bird uses most energy while taking off before flying?", "Albatros", "Parrot", "Seagul", "Albatros"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.ANIMALS, new QuestionInfo("Polar bears have what color of skin under their white fur?", "White", "Black", "Gray", "Black"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.ANIMALS, new QuestionInfo("The name jaguar means what?", "One leap killer", "Thunder speed", "Speed of light", "One leap killer"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.ANIMALS, new QuestionInfo("Hippos secrete a red oily substance from their skin to...", "Repel predators", "Moisturize skin", "Reveal stress", "Moisturize skin"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.ANIMALS, new QuestionInfo("The 2-inch-long golden poison dart frog has enough venom to kill how many adult men?", "10", "25", "70", "10"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.ANIMALS, new QuestionInfo("Galapagos tortoises sleep for how many hours a day?", "10", "23", "16", "16"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.ANIMALS, new QuestionInfo("Galapagos tortoises can go without food for how many days?", "160", "260", "360", "360"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.ANIMALS, new QuestionInfo("Scorpions are able to live on a single insect per...", "Day", "Month", "Year", "Year"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.ANIMALS, new QuestionInfo("What animal lives on even after being frozen and thawed? ", "Scorpion", "Neglectic fish", "Electric eel", "Scorpion"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.ANIMALS, new QuestionInfo("African elephants can be pregnant up to how many years?", "1", "1.5", "2", "2"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.ANIMALS, new QuestionInfo("Snow leopards can leap to how many feet in one jump?", "30", "50", "80", "50"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.ANIMALS, new QuestionInfo("Animals bitten by what animal typically die within 24 hours from blood poisoning?", "Golden frog", "Komodo dragon", "African bat", "Komodo dragon"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.ANIMALS, new QuestionInfo("The three-toed sloth sleep up to how many hours a day", "15", "20", "22", "20"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.ANIMALS, new QuestionInfo("Algae can grow on the back of which animal?", "Three-toed sloth", "African turtle", "Amu", "Three-toed sloth"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.ANIMALS, new QuestionInfo("Which animal can se up to 360 degrees around itself?", "Goat", "Pelican", "Chicken", "Goat"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.ANIMALS, new QuestionInfo("Can the kick of an ostrich can kill any lion and man?", "Yes", "No", "WTF man??!?", "Yes"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.ANIMALS, new QuestionInfo("Flying fish can glide for the length of a how many football fields?", "1", "2", "3", "2"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.ANIMALS, new QuestionInfo("When tarantulas molt, they can replace their...", "Skin", "Bones", "Iternal organs", "Iternal organs"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.ANIMALS, new QuestionInfo(" Elephants can smell water from how many miles away?", "Several", "20", "50", "Several"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.ANIMALS, new QuestionInfo("The largest fish in the sea is?", "White whale", "Whale shark", "Gray Whale", "Whale shark"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.ANIMALS, new QuestionInfo("Acient goblin shar is actually...", "Ugly as hell", "Colorful", "Pretty cool", "Ugly as hell"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.ANIMALS, new QuestionInfo("The king cobra has enough venom to kill how many elephants?", "1", "2", "3", "1"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.ANIMALS, new QuestionInfo("The narwhal has how many teeth?", "1", "2", "3", "2"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.ANIMALS, new QuestionInfo("Chameleons change colors to?", "Avoid predators", "Show emotions", "Support gay rights", "Show emotions"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.ANIMALS, new QuestionInfo("When anacondas mate, several competing males can do what around a female", "Form a ball", "Fight", "Mate", "Form a ball"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.ANIMALS, new QuestionInfo("When a queen bee dies what do worker bees do?", "Wait to die", "Create a new queen", "Create a new base", "Create a new queen"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.ANIMALS, new QuestionInfo("Alligators have been around for how many years?", "500 thousand", "150 million", "500 milion", "150 million"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.ANIMALS, new QuestionInfo("A hungry tiger can eat how many pound a meat in one meal?", "40", "60", "110", "60"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.ANIMALS, new QuestionInfo("Koalas sleep for how many hours a day?", "23", "18", "16", "18"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.ANIMALS, new QuestionInfo("What can male ostriches do?", "Kill elephants", "Roar like lions", "Fly", "Roar like lions"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.ANIMALS, new QuestionInfo("A lion in the wild usually makes no more than how many kills a year?", "5", "10", "20", "20"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.ANIMALS, new QuestionInfo("The female lion does how many percent of the hunting?", "90%", "80%", "70%", "90%"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.ANIMALS, new QuestionInfo("Ostriches can run faster than what animal?", "Gazelle", "Cheetah", "Horse", "Horse"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.ANIMALS, new QuestionInfo("Half of the pigs in world are kept where?", "In China", "In Australia", "On American farms", "In China"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.ANIMALS, new QuestionInfo("What animal is the only mammal that can fly", "Bat", "Squirrel", "Chipmunk", "Bat"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.ANIMALS, new QuestionInfo("The bat can not walk becouse he has?", "Thin leg bones", "Lack of cordination", "Big skull", "Thin leg bones"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.ANIMALS, new QuestionInfo("Some male songbirds sing more than how many times a day?", "200", "1000", "2000", "2000"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.ANIMALS, new QuestionInfo("A tarantula spider can survive for more than how many year without food?", "1", "2", "3", "2"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.ANIMALS, new QuestionInfo("For every human in the world there are how many ants", "100 thousand", "1 million", "10 million", "1 million"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.ANIMALS, new QuestionInfo("If you lift a kangaroo’s tail off the ground it can’t do what?", "Hop", "Walk", "Breath", "Hop"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.ANIMALS, new QuestionInfo("If you keep a goldfish in a dark room it will become...", "Pale", "Dead", "Furious", "Pale"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.ANIMALS, new QuestionInfo("Cows can sleep while...", "Standing", "Sitting", "Walking", "Standing"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.ANIMALS, new QuestionInfo("Cows can dream only while...", "Standing", "Sitting", "Lying down", "Lying down"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.ANIMALS, new QuestionInfo("The average fox weighs how many pounds?", "5", "14", "32", "14"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.ANIMALS, new QuestionInfo("In green areas there are average of how many thousands of spiders per acre?", "10", "30", "50", "50"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.ANIMALS, new QuestionInfo("Snakes only eat what?", "Mammals", "Animals", "Small animals", "Animals"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.ANIMALS, new QuestionInfo("Alligators can live up to how many years?", "100", "300", "600", "100"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.ANIMALS, new QuestionInfo("During World War II, Americans tried to train what animal to drop bombs?", "Seagulls", "Bats", "Eagles", "Bats"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.ANIMALS, new QuestionInfo("To escape the grip of a crocodile’s jaw you need to?", "Play dead", "Push its eyeballs", "Slap it", "Push its eyeballs"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.ANIMALS, new QuestionInfo("Even a small amount of alcohol placed on a scorpion will make it do what?", "Circles", "Sting itself", "Fall asleep", "Sting itself"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.ANIMALS, new QuestionInfo("A group of owls is called what?", "A parliament", "Owl meeting", "Circle of thoughts", "A parliament"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.ANIMALS, new QuestionInfo("Apple and pear seeds can kill what animal?", "Bird", "Dog", "Fox", "Dog"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.ANIMALS, new QuestionInfo("Cats have lived with people for how many years?", "1 thousand", "4 thousand", "7 thousand", "7 thousand"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.ANIMALS, new QuestionInfo("A cat has 32 muscles in each...", "Ear", "Paw", "Leg", "Ear"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.ANIMALS, new QuestionInfo("Hippos can run faster than...", "Humans", "Leopards", "Flamingos", "Humans"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.ANIMALS, new QuestionInfo("A woodpecker can peck how many times per second?", "10", "20", "30", "20"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.ANIMALS, new QuestionInfo("A moth has no...", "Head", "Stomach", "Sight", "Stomach"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.ANIMALS, new QuestionInfo("If you cut off a snail’s eye it will do what?", "Be angry", "Remember you", "Grow new one", "Grow new one"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.ANIMALS, new QuestionInfo("The ostrich has how many toes on each foot?", "1", "2", "3", "2"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.ANIMALS, new QuestionInfo("first animals domesticated by man were...", "Dogs", "Pigs", "Goats", "Goats"));

        //MEMES
        numOfQ = 0;
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.MEMES, new QuestionInfo("'All your base are belong to us' comes from what game?", "Zero Wing", "Super Mario", "Starcraft", "Zero Wing"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.MEMES, new QuestionInfo("The Philosoraptor meme was originally a...", "Logo", "T-shirt", "Tatoo", "T-shirt"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.MEMES, new QuestionInfo("One does not simply walk into what?", "KFC", "Mordor", "Bar", "Mordor"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.MEMES, new QuestionInfo("Which animal is known for crashing many pictures since 2009", "Dog", "Fox", "Squirrel", "Squirrel"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.MEMES, new QuestionInfo("What nationality is the Standing Cat named Rocky?", "Croatian", "Spanish", "French", "French"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.MEMES, new QuestionInfo("'They're eating her!' is a line from which movie?", "Troll 2", "Zombies now 2", "Mummy 2", "Troll 2"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.MEMES, new QuestionInfo("Which type of cat is watching you, always?", "Underbed", "Ceiling", "Floot", "Ceiling"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.MEMES, new QuestionInfo("What is the frog riding?", "A unicycle", "A unicorn", "A motorbike", "A unicycle"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.MEMES, new QuestionInfo("You're supposed to put what substance on your nipples in order to get high?", "Toothpaste", "Bacon sirup", "Maple sirup", "Toothpaste"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.MEMES, new QuestionInfo("Where can you get free candy?", "In a van", "In a basement", "In a kitchen", "In a van"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.MEMES, new QuestionInfo("Why can't we stop here?", "This is bat country", "This is cat country", "This is frog country", "This is bat country"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.MEMES, new QuestionInfo("What sort of cartoon animal most frequently appears in the Dolan memes?", "Duck", "Frog", "Rabbit", "Duck"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.MEMES, new QuestionInfo("One meme always features people in white masks as an homage to which group?", "Clowns", "Anonymous", "KKK", "Anonymous"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.MEMES, new QuestionInfo("A viral Kickstarter campaign resulted in a meme about recipes for what dish?", "Red bread", "Potato salad", "Shark eye", "Potato salad"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.MEMES, new QuestionInfo("Which font is ridiculed endlessly?", "Arial", "Comic sans", "Arial light", "Comic sans"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.MEMES, new QuestionInfo("Gandhi is always obsessed with what?", "Nuclear bombs", "Female sheeps", "Giant ships", "Nuclear bombs"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.MEMES, new QuestionInfo("Which world leader is hanging out with a rainbow?", "Stalin", "Trump", "Obama", "Stalin"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.MEMES, new QuestionInfo("What is Polybius?", "An arcade game", "Experimental drug", "Type of cat", "An arcade game"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.MEMES, new QuestionInfo("In what year did the word cringeworthy really come to light?", "1876", "1972", "2013", "1972"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.MEMES, new QuestionInfo("What sort of animal is drinking out of cups?", "Lizard", "Bird", "Monkey", "Lizard"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.MEMES, new QuestionInfo("Where is the cat on the keyboard?", "In space", "On moon", "On cloud", "In space"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.MEMES, new QuestionInfo("The Miami Zombie was supposedly under the influence of what substance?", "Bath salts", "Dead bats", "Vampire bool", "Bath salts"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.MEMES, new QuestionInfo("Running girl has jacket of what color?", "Blue", "Red", "Yellow", "Yellow"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.MEMES, new QuestionInfo("Older guy in 'I don't always' meme has what else on the table? ", "Wine", "Beer", "Cocktail", "Beer"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.MEMES, new QuestionInfo("Guy in 'One does not simply' meme made what shape with his hand?'", "Triangle", "Circle", "Ellipse", "Circle"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.MEMES, new QuestionInfo("Girl which holds books hold hown many of them?", "2", "3", "4", "3"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.MEMES, new QuestionInfo("'What if I told you' has what movie character in it?", "Morpheus", "Pepe", "Lizzard", "Morpheus"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.MEMES, new QuestionInfo("In Patrick Stewart(Star Trek) meme what color is his shirt?", "Purple and Black", "Yellow and Black", "Orange and Black", "Purple and Black"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.MEMES, new QuestionInfo("Never satisfied parent is of what race?", "Asian", "African", "Indian", "Asian"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.MEMES, new QuestionInfo("High guy meme is using...", "Misspell words", "World domination", "Sell weed", "Misspell words"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.MEMES, new QuestionInfo("Angry cat is doing what?", "Hating everything", "Preparing for domination", "Hating People", "Hating everything"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.MEMES, new QuestionInfo("In meme where Jesus is pointing with his hand he is also winking with his...", "Left eye", "Right eye", "Both eyes", "Right eye"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.MEMES, new QuestionInfo("Pepe is what?", "Happy", "Sad", "Angry", "Sad"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.MEMES, new QuestionInfo("Pepe is what animal?", "Frog", "Bunny", "Deer", "Frog"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.MEMES, new QuestionInfo("Pepe is doing what?", "Jumping", "Crying", "Dancing", "Crying"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.MEMES, new QuestionInfo("In meme where the guy is sitting at desk with veins on his forehead, who is next to him?", "Guy", "Girl", "Child", "Girl"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.MEMES, new QuestionInfo("'Tell me more' meme features which actor", "Gene Wilder", "Harrison Ford", "Jack Nicholson", "Gene Wilder"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.MEMES, new QuestionInfo("LOL stands for", "Laugh out loud", "Lots of love", "Love outer space", "Laugh out loud"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.MEMES, new QuestionInfo("What is meme name for Sonic", "Senic", "Sanic", "Sunic", "Sanic"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.MEMES, new QuestionInfo("Which frog was in love with a pig?", "Pepe", "Kermit", "pepito", "Kermit"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.MEMES, new QuestionInfo("Which boi is never gonna give you up?", "Rick Roll", "Rick Rock", "Jim Roll", "Rick Roll"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.MEMES, new QuestionInfo("Most popular dog meme?", "Dogu", "Doge", "Dogy", "Doge"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.MEMES, new QuestionInfo("YOLO means what?", "You only live once", "You only love ovens", "You only love Oliver", "You only live once"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.MEMES, new QuestionInfo("Rainbow cat is also known as...", "Nyan cat", "Neon Cat", "Nyah Cat", "Nyan cat"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.MEMES, new QuestionInfo("On meme with orange cat, what does the cat play?", "Mini piano", "Flute", "Guitar", "Mini piano"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.MEMES, new QuestionInfo("What is written on most famous troll face meme?", "Problem?", "Problem!", "Problem.", "Problem?"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.MEMES, new QuestionInfo("What facial expression does most famous troll face has?", "Smile", "Anger", "Concentration", "Smile"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.MEMES, new QuestionInfo("What is the color of trollzilla?", "White", "Green", "Blue", "Green"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.MEMES, new QuestionInfo("How many fingers does 'Like a boss' meme guy has on each hand?", "3", "4", "5", "4"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.MEMES, new QuestionInfo("What prefix is often added to memes", "El", "Le", "Dis", "El"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.MEMES, new QuestionInfo("'Keep calm and' meme was originally what?", "Rock band poster", "Motivational poster", "Boxing slogan", "Motivational poster"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.MEMES, new QuestionInfo("What actor is in 'You don't say' meme?", "Nicolas Cage", "Steven Seagal", "Brad pitt", "Nicolas Cage"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.MEMES, new QuestionInfo("'Bitch Please' meme is actually who?", "Yao Ming", "Yao Mingus Develona", "Yayin Minge", "Yao Ming"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.MEMES, new QuestionInfo("'Bitch Please' face was made during what?", "Press conference", "Voting", "Football game", "Press conference"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.MEMES, new QuestionInfo("'Impossibru!' face is from what Japanesse show?", "Prank King", "Prank Queen", "Prank Deer", "Prank King"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.MEMES, new QuestionInfo("Who mentioned term 'Meme' for the first time?", "Richard Dawkins", "Sir Isaac Newton", "Isaac Newton", "Richard Dawkins"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.MEMES, new QuestionInfo("How much money did Carlos Ramirez earn for licensing a troll face?", "100 thousand", "1 million", "12 million", "100 thousand"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.MEMES, new QuestionInfo("Popular song has badgers, snakes and what else", "Flower", "Mushrooms", "Elephants", "Mushrooms"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.MEMES, new QuestionInfo("Who is the biggest scumbag of all in the world of memes?", "Steve", "Bruno", "Bill", "Steve"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.MEMES, new QuestionInfo("Doge is actually what?", "Shiba Inu", "African monkey", "Gnu", "Shiba Inu"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.MEMES, new QuestionInfo("What is popular meme website?", "4Chan", "Facebook", "Twitter", "4Chan"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.MEMES, new QuestionInfo("What is popular meme website?", "Reddit", "Instagram", "Youtube", "Reddit"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.MEMES, new QuestionInfo("Scumbag Steve wears what?", "Hat", "Leopard jacket", "Elephant Socks", "Hat"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.MEMES, new QuestionInfo("Creazy girl with eyes widespread is doing what?", "Creeping on a guy", "Loving lizzards", "Slapping Elephants", "Creeping on a guy"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.MEMES, new QuestionInfo("What word is used in the meme world?", "Dank", "Sank", "Sunk", "Dank"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.MEMES, new QuestionInfo("'You Don't Say' refers to what?", "Obvious observation", "Weird women", "Sky lizzards", "Obvious observation"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.MEMES, new QuestionInfo("Doge is sometimes watching you from...", "Sun", "Moon", "Mothers basement", "Sun"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.MEMES, new QuestionInfo("Kermit is drinking what?", "Milk", "Fuel", "Pure orange juice", "Milk"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.MEMES, new QuestionInfo("'Not Sure If' guy is from which TV show?", "Simpsons", "Futurama", "Family guy", "Futurama"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.MEMES, new QuestionInfo("What does Chuck Norris holds in his hands?", "2 Uzis", "2 Shotguns", "2 AK-47s", "2 Uzis"));

        //INTERNET
        numOfQ = 0;
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.INTERNET, new QuestionInfo("Who is the slowest?", "Internet Explorer", "Mozzila Firefox", "Chrome", "Internet Explorer"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.INTERNET, new QuestionInfo("Which browser has animal on its logo?", "Internet Explorer", "Mozzila Firefox", "Chrome", "Mozzila Firefox"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.INTERNET, new QuestionInfo("Which browser is the oldest?", "Opera", "Firefox", "Safari", "Firefox"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.INTERNET, new QuestionInfo("Which browser is the oldest?", "Internet explorer", "World Wide Web", "Mosaic", "World Wide Web"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.INTERNET, new QuestionInfo("HTML is what?", "Markup language", "Programming language", "English language", "Markup language"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.INTERNET, new QuestionInfo("HTML is used with what?", "Windows", "Apple", "Internet pages", "Internet pages"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.INTERNET, new QuestionInfo("CSS means what?", "Cascading Style Sheets", "Casual Style Sheets", "Circular Style Sheets", "Cascading Style Sheets"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.INTERNET, new QuestionInfo("CSS is meant to be used to do what with web pages?", "Stylize it", "Make it work", "Show data", "Stylize it"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.INTERNET, new QuestionInfo("How many users does Facebook have?", "1.71 billion", "11 million", "400 million", "1.71 billion"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.INTERNET, new QuestionInfo("How many users does Instagram have?", "1.71 billion", "11 million", "400 million", "400 million"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.INTERNET, new QuestionInfo("How many users does 4Chan have?", "1.71 billion", "11 million", "400 million", "11 million"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.INTERNET, new QuestionInfo("How many users does Twitter have?", "1.71 billion", "11 million", "400 million", "11 million"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.INTERNET, new QuestionInfo("How many users does Snapchat have?", "100 million", "41 million", "200 million", "100 million"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.INTERNET, new QuestionInfo("How many users does Youtube have?", "1 billion", "11 million", "400 million", "1 billion"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.INTERNET, new QuestionInfo("How many users does MySpace have?", "71 million", "50.6 million", "400 million", "50.6 million"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.INTERNET, new QuestionInfo("How many users does Pinterest have?", "71 million", "50.6 million", "100 million", "100 million"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.INTERNET, new QuestionInfo("How many users does LinkedIn have?", "450 million", "50.6 million", "200 million", "450 million"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.INTERNET, new QuestionInfo("How many users does WhatsApp have?", "100 million", "20 million", "900 million", "900 million"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.INTERNET, new QuestionInfo("Google processes how many searches a month?", "800 million", "50 billion", "100 billion", "100 billion"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.INTERNET, new QuestionInfo("How many pages has google indexed by 2014?", "700 billion", "200 billion", "30 trillion", "30 trillion"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.INTERNET, new QuestionInfo("What color represents Youtube?", "Red", "Green", "Blue", "Red"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.INTERNET, new QuestionInfo("What color represents Facebook?", "Red", "Green", "Blue", "Blue"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.INTERNET, new QuestionInfo("What company owns Youtube?", "Google", "Apple", "Microsoft", "Google"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.INTERNET, new QuestionInfo("What color is not on googles logo?", "Green", "Yellow", "Orange", "Orange"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.INTERNET, new QuestionInfo("What logo usses golden ratio?", "Apple", "Google", "Windows", "Apple"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.INTERNET, new QuestionInfo("What percent of internet users use instagram?", "10%", "15%", "30%", "30%"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.INTERNET, new QuestionInfo("Internet started as what?", "ARPANET", "Internet 1.0", "WWW", "ARPANET"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.INTERNET, new QuestionInfo("WWW means?", "World Wide Web", "Wide World Web", "Wide Web World", "World Wide Web"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.INTERNET, new QuestionInfo("URL is another name for?", "Unified rules", "Web adress", "Home adress", "Web adress"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.INTERNET, new QuestionInfo("HTTPS is what when its compared to HTTP?", "Less secure", "More secure", "Faster", "More secure"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.INTERNET, new QuestionInfo("Free online encyclopedia is also known as what?", "Wikipedia", "Onlinepedia", "WikiLeaks", "Wikipedia"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.INTERNET, new QuestionInfo("More secure informations can be shared on what platform?", "Wikipedia", "WikiLeaks", "Facebook", "WikiLeaks"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.INTERNET, new QuestionInfo("How many computers a single google search usess to give you an information?", "1000", "500", "100", "1000"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.INTERNET, new QuestionInfo("When was GIF format invented?", "1987", "1991", "1995", "1987"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.INTERNET, new QuestionInfo("What is the most viewed video of all time?", "Gangam style", "Justin Bieber crap", "Pewdiepie crap", "Gangam style"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.INTERNET, new QuestionInfo("What is first domain ever registered?", " Symbolics.com", "Test.com", "Internet.com", "Symbolics.com"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.INTERNET, new QuestionInfo("Who is inventor of World Wide Web?", "Tim Berners-Lee", "Tim Jones", "Luke Jones", "Tim Berners-Lee"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.INTERNET, new QuestionInfo("When did the first ever banner ad run?", "1991", "1994", "2001", "1994"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.INTERNET, new QuestionInfo("First item sold on eBay was...", "Laser pointer", "Dirty bowl", "Cat remains", "Laser Pointer"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.INTERNET, new QuestionInfo("When was the first item on eBay sold?", "1991", "1995", "1998", "1995"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.INTERNET, new QuestionInfo("First real Facebook user is now what?", "A plumer", "Facebook employ", "A rabbi", "A rabbi"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.INTERNET, new QuestionInfo("What was the destination of the first video on Youtube?", "At the zoo", "at girlfriends house", "At the festival", "At the zoo"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.INTERNET, new QuestionInfo("When was the first email sent?", "1971", "1980", "1984", "1971"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.INTERNET, new QuestionInfo("What was written in the first ever email?", "Nobody knows", "I love you Mike", "I love milk", "Nobody knows"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.INTERNET, new QuestionInfo("When did the first version of Facebook come up?", "2003", "2004", "2005", "2004"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.INTERNET, new QuestionInfo("When did the first version of Youtube come up?", "2004", "2005", "2006", "2005"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.INTERNET, new QuestionInfo("When did the first version of Twitter come up?", "2006", "2007", "2008", "2006"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.INTERNET, new QuestionInfo("When did the first version of Instagram come up?", "2010", "2011", "2012", "2010"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.INTERNET, new QuestionInfo("When did the first version of Myspace come up?", "2002", "2003", "2004", "2003"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.INTERNET, new QuestionInfo("When did the first version of LinkedIn come up?", "2003", "2004", "2005", "2003"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.INTERNET, new QuestionInfo("When did the first version of Wikipedia come up?", "1999", "2000", "2001", "2001"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.INTERNET, new QuestionInfo("Match.com made how many babies?", "500 thousand", "1 million", "1.5 million", "1 million"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.INTERNET, new QuestionInfo("What is the color of arrow on Amazon logo?", "yellow", "blue", "green", "yellow"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.INTERNET, new QuestionInfo("What 2 letter does arrow on Amazon logo connects?", "A and Z", "A and O", "A and N", "A and Z"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.INTERNET, new QuestionInfo("What did people traded over internet in 70's and 80's?", "ASCII images", "ASCII porn", "ASCII emoticons", "ASCII porn"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.INTERNET, new QuestionInfo("There is subreddit devoted to chicken nuggets that look like...", "Animals", "Other things", "Presidents", "Other things"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.INTERNET, new QuestionInfo("What country has treatment camps for internet addicts?", "Japan", "China", "Australia", "China"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.INTERNET, new QuestionInfo("How many wesites are hacked every day?", "10000", "50000", "100000", "50000"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.INTERNET, new QuestionInfo("First webcam was created at the University Of Cambridge to monitor the...", "Students", "Coffee pot", "Flower pot", "Coffee pot"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.INTERNET, new QuestionInfo("How much money is spent on the internet?", "90 billion", "950 billion", "1.7 trillion", "1.7 trillion"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.INTERNET, new QuestionInfo("The Internet is a...", "Network of computers", "Network of websites", "Network of WWW", "Network of computers"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.INTERNET, new QuestionInfo("Modern WWW inventor Tim Berners-Lee was...", "In jail", "Knighted by Queen", "In Antarctic", "Knighted by Queen"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.INTERNET, new QuestionInfo("Online dating generates how many dollars every year?", "500 million", "1 billion", "2.35 billion", "1 billion"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.INTERNET, new QuestionInfo("Dark side of internet is called...", "Surface web", "Deep web", "Hidden web", "Deep web"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.INTERNET, new QuestionInfo("What part of internet you can access using google or bing?", "Surface web", "Deep web", "Hidden web", "Surface web"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.INTERNET, new QuestionInfo("What browser can access deep web?", "Firefox", "Opera", "Tor", "Tor"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.INTERNET, new QuestionInfo("In which country is Internet access legal right?", "Finland", "Croatia", "Sweden", "Finland"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.INTERNET, new QuestionInfo("In 'URL' 'L' stands for what?", "Locater", "Locator", "Location", "Locater"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.INTERNET, new QuestionInfo("Weight of all information on Internet is same as that of...?", "Apple", "Strawberry", "Pumpkin", "Strawberry"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.INTERNET, new QuestionInfo("How many machines are currently connected to the Internet?", "8.7 billion", "20 billion", "25 billion", "8.7 billion"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.INTERNET, new QuestionInfo("1.7 billion of the Internet users are from where?", "America", "Asia", "Europe", "Asia"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.INTERNET, new QuestionInfo("The best connected cities are in South Korea and...", "Japan", "China", "Austria", "Japan"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.INTERNET, new QuestionInfo("Top level domain '.com/.eu/...' tells you what...", "Website is about", "Connection you need", "Access you have", "Website is about"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.INTERNET, new QuestionInfo("Top level domain '.org' stands for what?", "Commercial", "Component", "Computer", "Commercial"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.INTERNET, new QuestionInfo("Top level domain '.edu ' stands for what?", "Education", "Educational", "Educator", "Education"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.INTERNET, new QuestionInfo("Top level domain '.mobi' stands for what?", "Mobilisation", "Mobile", "Mobility", "Mobile"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.INTERNET, new QuestionInfo("Top level domain '.tel ' stands for what?", "Telegraph", "Telephone", "Telnic", "Telnic"));

        //SPORTS
        numOfQ = 0;
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.SPORT, new QuestionInfo("How big is the diameter of a basketball hoop?", "18 inches", "21 inch", "25 inches", "18 inches"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.SPORT, new QuestionInfo("What sport used the term ‘home run’ long before baseball?", "Cricket", "Football", "Baseball", "Cricket"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.SPORT, new QuestionInfo("What was the first sport in which women were invited to compete at the Olympics?", "Tennis", "Swimming", "Cricket", "Tennis"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.SPORT, new QuestionInfo("What does BMX stands for?", "Bicycle moto x", "Bicycle motor x", "Bicycle moto ex", "Bicycle moto x"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.SPORT, new QuestionInfo("Which type of ball was basketball played with until 1929? ", "Soccer ball", "Tennis ball", "Volleyball", "Soccer ball"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.SPORT, new QuestionInfo("What number lies between 5 and 9 on a British dart board?", "11", "12", "13", "12"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.SPORT, new QuestionInfo("The San Siro Stadium is in which Italian city?", "Milan", "Palermo", "Vatican", "Milan"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.SPORT, new QuestionInfo("Which is the only country to have played in each and every World Cup?", "Brazil", "Spain", "Portugal", "Brazil"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.SPORT, new QuestionInfo("Which was the first African country to qualify for a World Cup? ", "Egypt", "Syron", "Syracuza", "Egypt"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.SPORT, new QuestionInfo("Which country won the first World Cup held in 1930? ", "Uruguay", "Brazil", "Italy", "Uruguay"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.SPORT, new QuestionInfo("How many players are on the field for each team in an Australian rules football match?", "18", "20", "22", "18"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.SPORT, new QuestionInfo("A game between club giants Real Madrid and Barcelona is called...", "El Clásico", "El Classico", "El Clasico", "El Clásico"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.SPORT, new QuestionInfo("How many World Cups have been won by Australian?", "3", "4", "5", "4"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.SPORT, new QuestionInfo("The coldest game in NFL history was played at?", "-25 degrees", "-13 degrees", " - 5 degrees", "-13 degrees"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.SPORT, new QuestionInfo("How many players, including the goaltender, make up an ice hockey team?", "5", "6", "7", "6"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.SPORT, new QuestionInfo("Wladimir Klitschko is a champion boxer from which country? ", "Russia", "Poland", "Ukraine", "Ukraine"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.SPORT, new QuestionInfo("What was banned from 1967 to 1976?", "Slam dunk", "Fake shoots", "Agressive game", "Slam dunk"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.SPORT, new QuestionInfo("In feet, how high is a basketball hoop? ", "10", "12", "14", "10"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.SPORT, new QuestionInfo("What three movements are required for an athlete to successfully complete a triple jump?", "Hop, step, jump", "Lean, step, jump", "Lean, hop, jump", "Hop, step, jump"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.SPORT, new QuestionInfo("When was an underdog with odds of 42:1 stun Mike Tyson?", "1987", "1990", "1997", "1990"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.SPORT, new QuestionInfo("When had the first athlete failed an Olympic drug test?", "1968", "1978", "1988", "1968"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.SPORT, new QuestionInfo("In which sport are the terms ‘stale fish’ and ‘mulekick’ used?", "Golf", "Cricket", "Snowboarding", "Snowboarding"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.SPORT, new QuestionInfo("Name the only major team sport in the USA with no game clock?", "Baseball", "Golf", "Cricket", "Baseball"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.SPORT, new QuestionInfo("Who choked the most popular UFC fighter in 2016?", "Nate Diaz", "Nick Diaz", "Stipe Miocic", "Nate Diaz"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.SPORT, new QuestionInfo("Who got surprisingly choked in UFC in 2016?", "Conor McGregor", "Eddie Alvarez", "Demian Maia", "Conor McGregor"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.SPORT, new QuestionInfo("In cricket, how many matches generally make up an Ashes Test series", "5", "6", "7", "5"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.SPORT, new QuestionInfo("What city of Asia hosted the Summer Olympics in 2008?", "Beijing", "London", "Venezuela", "Beijing"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.SPORT, new QuestionInfo("The average golf ball has how many simples", "15", "336", "504", "336"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.SPORT, new QuestionInfo("There are how many minutes of total action in baseball game", "15", "18", "23", "18"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.SPORT, new QuestionInfo("First sport on the Moon was...", "Soccer", "Basketball", "Golf", "Golf"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.SPORT, new QuestionInfo("The Phillippines has competed in the most Summer Olympics without winning...", "Any medal", "A gold medal", "A silver medal", "A gold medal"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.SPORT, new QuestionInfo("The Liechtenstein has competed in the most Summer Olympics without winning...", "Any medal", "A gold medal", "A silver medal", "Any medal"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.SPORT, new QuestionInfo("The longest recorded point in tennis history took how many minutes?", "9", "16", "29", "29"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.SPORT, new QuestionInfo("At the first modern Olympics, winners were awarded...", "Silver medals", "Bronce medals", "Flowers", "Silver medals"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.SPORT, new QuestionInfo("Demetrious johnson nickname is...", "Dem", "Mighty mouse", "Mighty horse", "Mighty mouse"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.SPORT, new QuestionInfo("Chuck Liddells nickname is...", "Iceman", "Lidenor", "Brick", "Iceman"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.SPORT, new QuestionInfo("Where is Anderson silva mostly at?", "The matrix", "A bathroom", "At the table", "The matrix"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.SPORT, new QuestionInfo("Which MMA fighter has weird chin?", "Anderson silva", "Demetrious johnson", "Uriah Faber", "Urijah Faber"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.SPORT, new QuestionInfo("Who of this fighters was not impressed by someones performance?", "Georges St-Pierre", "Georges McNugget", "Georges MacDonald", "Georges St-Pierre"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.SPORT, new QuestionInfo("Stipe Miocic is from where", "Bosnia", "Cleveland", "Brazil", "Cleveland"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.SPORT, new QuestionInfo("Who knocked out Rondy Rousey?", "Holly Holm", "Stipe Miocic", "Iceman", "Holly Holm"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.SPORT, new QuestionInfo("Who knocked out Rondy Rousey?", "Amanda Nunes", "Stipe Miocic", "Iceman", "Amanda Nunes"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.SPORT, new QuestionInfo("Who has a killer leg kick", "Iceman", "Cro cop", "Bob Sapp", "Cro cop"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.SPORT, new QuestionInfo("With what organisation does the UFC has sponsor contract with_", "Reebok", "Nike", "Adidas", "Reebok"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.SPORT, new QuestionInfo("The Pittsburgh Pirates’ almost built a new stadium in the middle of a...", "Village", "River", "Warzone", "River"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.SPORT, new QuestionInfo("Major League Baseball game is played under how many minutes?", "15", "18", "25", "18"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.SPORT, new QuestionInfo("Olympic gold medals are actually made of...", "Titanium", "Cooper", "Silver", "Silver"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.SPORT, new QuestionInfo("The word “Soccer” is a...", "Name for burglar", "Medical operation", "Slang term", "Slang term"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.SPORT, new QuestionInfo("Who tested positive for cocaine in 1991?", "Diego Maradona", "Diego Sanchez", "Diego Santos", "Diego Maradona"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.SPORT, new QuestionInfo("A soccer ball has how many panels?", "28", "32", "38", "32"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.SPORT, new QuestionInfo("How many medals are awarded at Olympics", "500", "1300", "1800", "1800"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.SPORT, new QuestionInfo("A chinese checkerboard has how many holes?", "111", "121", "131", "121"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.SPORT, new QuestionInfo("Golf balls can reach speeds of how many miles per hour?", "150", "170", "220", "170"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.SPORT, new QuestionInfo("How many lb does the hockey puck weights?", "0.38", "0.57", "0.89", "0.38"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.SPORT, new QuestionInfo("The opposite sides of a dice cube always add up to...", "9", "8", "7", "7"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.SPORT, new QuestionInfo("Every ball used in Major League Baseball is...", "Clean", "Slimey", "Dirty", "Dirty"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.SPORT, new QuestionInfo("Olympic Badminton rules say that the birdie has to have exactly how many feathers?", "12", "14", "16", "14"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.SPORT, new QuestionInfo("In Rome, 3 consecutive strikes in bowling is called a...", "Chicken", "Turkey", "Pigeon", "Turkey"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.SPORT, new QuestionInfo("The first baseball caps were made of...", "Leopard skin", "Koala skin", "Straw", "Straw"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.SPORT, new QuestionInfo("People in nudist colonies mostly play what sport?", "Volleyball", "Chess", "Swimming", "Volleyball"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.SPORT, new QuestionInfo("Who was the first fighter in the UFC that wore gloves?", "Steve Jennum", "Steve Mazagati", "Steve Teriona", "Steve Jennum"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.SPORT, new QuestionInfo("Tito Ortiz's real name is...", "Jacob", "John", "Nick", "Jacob"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.SPORT, new QuestionInfo("Steve Jennum was a UFC champion who only won...", "1 fight", "2 fights", "3 fights", "2 fights"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.SPORT, new QuestionInfo("Who knock out Cro Cop by leg kick in the UFC?", "Gabriel Gonzaga", "Steve Gaselum", "Rory MacDonald", "Gabriel Gonzaga"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.SPORT, new QuestionInfo("Wanderlei Silvas nickname is...", "Rampage", "The Axe Murderer", "Destructor", "The Axe Murderer"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.SPORT, new QuestionInfo("Ian McCall's nickname is...", "Rampage", "Uncle Creepy", "The Last Emperor", "Uncle Creepy"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.SPORT, new QuestionInfo("Fedor Emelianenko's nickname is...", "Rampage", "Uncle Creepy", "The Last Emperor", "The Last Emperor"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.SPORT, new QuestionInfo("Mauricio Ruas nickname is...", "Rampage", "The Prodigy", "Shogun", "Shogun"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.SPORT, new QuestionInfo("BJ Pen's nickname is...", "Shogun", "The Prodigy", "Destructor", "The Prodigy"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.SPORT, new QuestionInfo("Mirko Filipovic's nickname is...", "Rampage", "Cro Cop", "Shogun", "Cro Cop"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.SPORT, new QuestionInfo("Randy Couture's nickname is...", "Rampage", "The Natural", "Shogun", "The Natural"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.SPORT, new QuestionInfo("Bas Rutten's nickname is...", "Rampage", "El Guapo", "Shogun", "El Guapo"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.SPORT, new QuestionInfo("Anderson Silvas's nickname is...", "The Spider", "Cleaner", "Shogun", "The Spider"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.SPORT, new QuestionInfo("Jon Jones's nickname is...", "Bones", "Cleaner", "Shogun", "Bones"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.SPORT, new QuestionInfo("Jason Miller's nickname is...", "Mayhem", "Semtex", "Shogun", "Mayhem"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.SPORT, new QuestionInfo("Paul Daley's nickname is...", "Rampage", "Cleaner", "Semtex", "Semtex"));
        QuestionWriter.AddQuestionToDatabase(QuestionInfo.E_CATEGORY.SPORT, new QuestionInfo("Chris Leben's nickname is...", "The Crippler", "Mayhem", "Shogun", "The Crippler"));
    }



*/
}


