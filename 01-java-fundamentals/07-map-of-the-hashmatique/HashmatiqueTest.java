import java.util.HashMap;
import java.util.Set;

public class HashmatiqueTest{
    
    public static void main(String[] args){

        HashmatiqueMap list = new HashmatiqueMap();
        HashMap<String, String> playList = list.makePlaylist();
        System.out.println(list.getLyrics("Another One Bites the Dust", playList));
        list.printTracks(playList);

    }

}