public class RunLengthEncode {

	public static String RunLengthEncode(String source){
        if (source.length()==0) return "\"\"";
        StringBuilder dest= new StringBuilder();
        for (int i=0;i<source.length();i++){
            int runlength=1;
            while (i+1<source.length()&& source.charAt(i)==source.charAt(i+1)){
                runlength++;
                i++;
            }
            if (runlength<=4){
                for (int k=0;k<runlength;k++) dest.append(source.charAt(i));
            }
            else{
                if (runlength>10){
                    dest.append("/"+runlength+source.charAt(i));
                }
                else dest.append("/0"+runlength+source.charAt(i));
            }
        }
        return dest.toString();
    }

    public static void main(String[] args) {
        String input="if(a){if(b){if(c){if(d){if(e){5 deeeeeeep}}}}}";
        System.out.println(RunLengthEncode("aaaaa"));
        System.out.println(RunLengthEncode("aaaa"));
        System.out.println(RunLengthEncode(input));
        System.out.println(RunLengthEncode(""));
    }}
