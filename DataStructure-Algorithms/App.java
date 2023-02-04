class App {
    public int romanToInt(String s) {
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == 'I'){
                num += 1;
            }else if(s.charAt(i) == 'V'){
                num += 5;
            }else if(s.charAt(i) == 'X'){
                num += 10;
            }else if(s.charAt(i) == 'L'){
                num += 50;
            }else if(s.charAt(i) == 'C'){
                num += 100;
            }else if(s.charAt(i) == 'D'){
                num += 500;
            }else if(s.charAt(i) == 'M'){
                num += 1000;
            }
        }

        return num;
    }
}
// I             1
// V             5
// X             10
// L             50
// C             100
// D             500
// M             1000