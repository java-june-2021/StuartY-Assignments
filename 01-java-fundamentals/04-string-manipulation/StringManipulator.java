public class StringManipulator{
    public String trimAndConcat(String stringA, String stringB){
        return stringA.trim() + stringB.trim();
    }

    public Integer getIndexOrNull(String fullString, String subString){
        Integer indexA = fullString.indexOf(subString);
        if(indexA >= 0){
            return indexA;
        }
        else{
            return null;
        }
    }

    public String concatSubstring(String firstString, int beginning, int end, String secondString){
        String subString = firstString.substring(beginning, end);
        return subString + secondString;
    }
}