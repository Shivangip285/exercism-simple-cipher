public class Cipher {
    public String key;

    public Cipher() {
        this.key= "aaaaaaaaaa";
    }

    public Cipher(String key) {
       this.key=key;
     }

    public String getKey() {
        return this.key;
    }

    public String encode(String plainText) {
        return performTextTranslation(plainText,true);
    }

    public String decode(String cipherText) {
        return performTextTranslation(cipherText,false);
    }

    private String performTextTranslation(String text, boolean encode) {
         StringBuilder translatedText= new StringBuilder();
         for(int i=0;i<text.length();i++){
             int alphabetStartingIndex = 97;
             int textIndex = (int) text.charAt(i)- alphabetStartingIndex;
             int keyIndex=this.getKey().charAt(i%this.getKey().length())- alphabetStartingIndex;
             if(encode){
                 keyIndex=(keyIndex+textIndex)%26;
             }
              else{
                  keyIndex=(keyIndex<textIndex)?(textIndex-keyIndex)%26:(textIndex-keyIndex+26)%26;
              }
            translatedText.append((char) (keyIndex + alphabetStartingIndex));
        }
        return translatedText.toString();
    }
}
