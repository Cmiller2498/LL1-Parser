
import java.util.StringTokenizer;
import java.util.Random;

public class Parser {

    public static String token;
    public static StringTokenizer st;


    public static void main(String[] args) {
            String expression = args[0];

        expression = expression + "$";
        System.out.println(expression);
        check();

        st = new StringTokenizer(expression,"+-*/()$", true);
        token = st.nextToken();



        E(); // Begins the process of parsing the string.


        if(token.equals("$")){
            System.out.println("Yes");

        }
        else
        {
            fail();
        }
        }
	//test
        public static void check(){
          Random rand = new Random();
          int random = rand.nextInt(100);
          System.out.println(random);

        }
	/*	
		Prints false if program has invalid expression
	*/
        public static void fail(){
              System.out.println("Invalid expression");
              System.exit(1);
            }

	/*
	determines if its a string, if so, it parses it into an integer
		
	*/
          public static boolean numberCheck(String number){
             
              try{
                  int n = Integer.parseInt(number);
                  return true;
              } catch (NumberFormatException e){
                  return false;
              }
          }

    public static void E(){
        if (numberCheck(token)){
            T();
            ePrime();
        }else{
            switch (token){
                case "+":
                    fail();
                    break;
                case "-":
                    fail();
                    break;
                case "*":
                    fail();
                    break;
                case "/":
                    fail();
                    break;
                case "(":
                    T();
                    ePrime(); // calling rule 1
                    break;
                case ")":
                    fail();
                    break;
                case "$":
                    fail();
                    break;
                }

        }
    }

    public static void ePrime(){
        if (numberCheck(token)){
            fail();
        }else{
            switch (token){
                case "+": // Calling rule 2
                    token = st.nextToken();
                    T();
                    ePrime();
                    break;
                case "-": // Calling rule 3
                    token = st.nextToken();
                    T();
                    ePrime();
                    break;
                case "*":
                    fail();
                    break;
                case "/":
                    fail();
                    break;
                case "(":
                    fail();
                    break;
                case ")": // calling rule 4
                    break;
                case "$": // calling rule 4
                    break;
                }
            }
    }

    public static void T(){
        if (numberCheck(token)){
            F(); // Rule 5
            tPrime();
        }else{
            switch (token){
                case "+":
                    fail();
                    break;
                case "-":
                    fail();
                    break;
                case "*":
                    fail();
                    break;
                case "/":
                    fail();
                    break;
                case "(": // Rule 5
                    F();
                    tPrime();
                    break;
                case ")":
                    fail();
                    break;
                case "$":
                    fail();
                    break;
                }
        }
    }

    public static void tPrime(){
        if (numberCheck(token)){
            fail();
        }else{
            switch (token){
                case "+": // Rule 8
                    break;
                case "-": // Rule 8
                    break;
                case "*": // Rule 6
                    token = st.nextToken();
                    F();
                    tPrime();
                    break;
                case "/": // Rule 7
                    token = st.nextToken();
                    F();
                    tPrime();
                    break;
                case "(":
                    fail();
                    break;
                case ")": // Rule 8
                    break;
                case "$": // Rule 8
                    break;
                }
        }
    }

    public static void F(){
        if (numberCheck(token)){ // Rule 10
            token = st.nextToken();
        }else{
            switch (token){
                case "+":
                    fail();
                    break;
                case "-":
                    fail();
                    break;
                case "*":
                    fail();
                    break;
                case "/":
                    fail();
                    break;
                case "(": // Rule 9
                    token = st.nextToken();
                    E();
                    if(!token.equals(")")){
                        fail();
                    }
                    else{
                        token = st.nextToken();
                    }
                    break;
                case ")":
                    fail();
                    break;
                case "$":
                    fail();
                    break;
                }
        }
    }




}
