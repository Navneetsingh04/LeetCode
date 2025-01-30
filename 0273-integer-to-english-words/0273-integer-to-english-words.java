import java.util.AbstractMap.SimpleEntry;
class Solution {
     List<Map.Entry<Integer,String>> mp = Arrays.asList(
        new SimpleEntry<>(1000000000, "Billion"),
        new SimpleEntry<>(1000000, "Million"),
        new SimpleEntry<>(1000, "Thousand"),
        new SimpleEntry<>(100, "Hundred"),
        new SimpleEntry<>(90, "Ninety"),
        new SimpleEntry<>(80, "Eighty"),
        new SimpleEntry<>(70, "Seventy"),
        new SimpleEntry<>(60, "Sixty"),
        new SimpleEntry<>(50, "Fifty"),
        new SimpleEntry<>(40, "Forty"),
        new SimpleEntry<>(30, "Thirty"),
        new SimpleEntry<>(20, "Twenty"),
        new SimpleEntry<>(19, "Nineteen"),
        new SimpleEntry<>(18, "Eighteen"),
        new SimpleEntry<>(17, "Seventeen"),
        new SimpleEntry<>(16, "Sixteen"),
        new SimpleEntry<>(15, "Fifteen"),
        new SimpleEntry<>(14, "Fourteen"),
        new SimpleEntry<>(13, "Thirteen"),
        new SimpleEntry<>(12, "Twelve"),
        new SimpleEntry<>(11, "Eleven"),
        new SimpleEntry<>(10, "Ten"),
        new SimpleEntry<>(9, "Nine"),
        new SimpleEntry<>(8, "Eight"),
        new SimpleEntry<>(7, "Seven"),
        new SimpleEntry<>(6, "Six"),
        new SimpleEntry<>(5, "Five"),
        new SimpleEntry<>(4, "Four"),
        new SimpleEntry<>(3, "Three"),
        new SimpleEntry<>(2, "Two"),
        new SimpleEntry<>(1, "One")
        );
    public String numberToWords(int num) {
            if(num == 0){
                return "Zero";
            }
            for(Map.Entry<Integer,String> it:mp){
                if(num>=it.getKey()){
                    String a = "";
                    if(num>=100){
                        a = numberToWords(num/it.getKey())+" ";
                    }
                    String b = it.getValue();
                    String c = "";
                    if(num%it.getKey() != 0){
                        c = " "+numberToWords(num%it.getKey());
                    }
                    return a+b+c;
                }
            }
            return "";
        }
    }