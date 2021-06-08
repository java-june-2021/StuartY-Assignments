import java.util.HashMap;
import java.util.Set;

public class HashmatiqueMap{

    public HashMap<String, String> makePlaylist(){
        HashMap<String, String> playlist = new HashMap<String, String>();
        playlist.put("Another One Bites the Dust", "Steve walks warily down the street With his brim pulled way down low...");
        playlist.put("Another Brick in the Wall", "We don't need no education...");
        playlist.put("Immigrant Song", "We come from the land of the ice and snow...");
        playlist.put("Don't Bring Me Down", "Don't bring me down...groos!");

        return playlist;
    }

    public String getLyrics(String title, HashMap<String, String> playlist){
        return playlist.get(title);
    }

    public void printTracks(HashMap<String, String> playList){
        Set<String> songs = playList.keySet();
        for(String title : songs){
            System.out.println("Title: " + title);
            System.out.println("Lyrics: " + playList.get(title));
        }
    }

}