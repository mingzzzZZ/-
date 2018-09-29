package test;
import java.util.Stack;
public class question {
char opr[]={'+','-','*','/'};
number oprd[]=new number[100];
char op[]=new char[100];
number result=new number();
String res;
private Object PRT;

   public void initialize(int r, int l){
	   int i,j;
	   for(i=0;i<1;i++){
		   oprd[i]=new number();
		   oprd[i].d=(int) (Math.random()*r)+1;
		   oprd[i].n=(int) (Math.random()*r)+1;
		   if(oprd[i].d>oprd[i].n){
			   oprd[i].d/=oprd[i].n;
			   oprd[i].n=1;
		   }
		   yf(oprd[i]);
	   }
		   
	   for (i=0;i<l-1;i++){
		   op[i]=opr[(int) (Math.random()*4)];
	   }
	   op[l-1]= '=';
	   Stack<Character>operator=new Stack<Character>();
	   Stack<number>operand=new Stack<number>();
	   number x= new number(),y=new number(),z=new number();
	   i=j=0;
	   boolean ture = false;
	while (ture){
		   operand.push(oprd[i++]);
		   if(j==l-1)   break;
		   while(!operator.isEmpty() && PRT(op[j]) <=PRT(operator.peek())){
			   y=operand.pop();
			   x=operand.pop();
			   z=solve(x,y,((Stack<Character>) operator).pop());
			   operand.push(z);
		   }
		   operator.push(op[j++]);
	   }
	   while (operand.size() !=1){
		   y=operand.pop();
		   x=operand.pop();
		   z=solve(x,y,operator.pop());
		   operand.push(z);
	   }
	   result=operand.pop();
	   if(result.n==0) res=String.valueOf(0);
	   else if(result.d == 1) res =String.valueOf(result.n );
	   else res =String.valueOf(result.n) + '/' + String.valueOf(result.d);
   }
   public number solve(number x, number y, char op){
	   number t1=new number(),t2= new number();
	   int lcm=LCM(x.d,y.d);
	   t1.n=x.n * lcm /x.d;
	   t1.n=y.n * lcm /y.d;
	   t1.d=t2.d = lcm;
	   switch(op){
	   case '+':
		   t1.n += t2.n;
		   break;
	   case '-':
		   t1.n -= t2.n;
		   break;
	   case '*':
		   t1.n = x.n * y.n;
		   t1.d = x.d * y.d;
		   break;
	   case '/':
		   t1.n = x.n * y.d;
		   t1.d = x.d * y.n;
		   break;
	   default:
		   break;
	   }
	   yf(t1);
	   return t1;
   }
   public int PRT(char c){
	   if(c=='+' || c=='/') return 0;
	   else if (c== '*' || c=='/') return 1;
	   else return -1;
   }
   public void print(int l){
	   String exp = new String();
	   for (int i=0;i<1;i++){
		   if(oprd[i].d ==1) exp+= String.valueOf(oprd[i].n);
		   else exp +=String.valueOf(oprd[i].n) + '/' + String.valueOf(oprd[i].d);
		   exp += " " + op[i] + " ";
	   }
	   System.out.println(exp);
   }
   public int GCD (int a,int b){
	   int gcd=1;
	   for (int i=1;i<=a;i++){
		   if(a%i == 0 && b%i == 0){
			   gcd=i;
		   }
	   }
	   return gcd;
   }
   public int LCM (int a, int b){
	   return a * b /GCD(a,b);
   }
   public void yf (number p){
	   int gcd=GCD (p.d,p.n);
	   p.d /=gcd;
	   p.n /=gcd;
   }
}

