class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int n = students.length;
        int m = sandwiches.length;
        int circular = 0;
        int square = 0;
        for(int i = 0;i<n;i++){
            if(students[i] == 0){
                circular++;
            }
            else{
                square++;
            }
        }
        for(int i : sandwiches){
            if(i == 0 && circular == 0){
                return square;
            }
            if(i == 1 && square == 0){
                return circular;
            }
            if(i == 0){
                circular--;
            }
            else{
                square--;
            }
        }
        return 0;
    }
}