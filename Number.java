import java.util.Random;

public class Number {

	int count;
	int numerato;
	int denominator;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getNumerato() {
		return numerato;
	}

	public void setNumerato(int numerato) {
		this.numerato = numerato;
	}

	public int getDenominator() {
		return denominator;
	}

	public void setDenominator(int denominator) {
		this.denominator = denominator;
	}

	public Number(String str) {
		boolean fra = false,fu=false;
		int coun=0;
		int left = 0, right = 0;
		char[] charArr = str.trim().toCharArray();
		for (int i = 0; i < charArr.length; i++) {
			if(charArr[i] == '-'){
				fu=true;
				
			}
			if (charArr[i] >= '0' && charArr[i] <= '9') {
				if (fra) {
					right = right * 10 + (charArr[i] - '0');

				} else {
					left = left * 10 + (charArr[i] - '0');

				}

			} 
			if(charArr[i]=='/') {
				fra = true;

			}
			if(charArr[i]=='’') {
				coun=left;
				left=0;

			}

		}
		if (fra) {
			if(fu)
				coun = -coun;
			this.setCount(coun);
			this.setNumerato(left);
			this.setDenominator(right);
				

		} else {
			if(fu)
				left = -left;
			this.setCount(left);
			this.setNumerato(0);
			this.setDenominator(0);
		}

	}
	public Number(){
		this.setCount(0);
		this.setNumerato(0);
		this.setDenominator(0);
	}
	public Number add(Number num2){
		Number an = new Number();
		if(this.getDenominator()==0 && num2.getDenominator()==0){
			an.setCount(this.getCount() + num2.getCount());
		}
		if(this.getDenominator()!=0 && num2.getDenominator()!=0){
			an.setCount(this.getCount() + num2.getCount());
			an.setDenominator(this.getDenominator() * num2.getDenominator());
			an.setNumerato(this.getNumerato()* num2.getDenominator() + num2.getNumerato() * this.getDenominator());
		}
		if(this.getDenominator()!=0 && num2.getDenominator()==0){
			an.setCount(this.getCount() + num2.getCount());
			an.setDenominator(this.getDenominator());
			an.setNumerato(this.getNumerato());
		}
		if(this.getDenominator()==0 && num2.getDenominator()!=0){
			an.setCount(this.getCount() + num2.getCount());
			an.setDenominator(num2.getDenominator());
			an.setNumerato(num2.getNumerato());
		}
		an.trim();
		return an;
		
	}
	public Number sub(Number num2){
		Number an = new Number();
		if(this.getDenominator()==0 && num2.getDenominator()==0){
			an.setCount(this.getCount() - num2.getCount());
		}
		if(this.getDenominator()!=0 && num2.getDenominator()!=0){
			an.setCount(this.getCount() - num2.getCount());
			an.setDenominator(this.getDenominator() * num2.getDenominator());
			an.setNumerato(this.getNumerato()* num2.getDenominator() - num2.getNumerato() * this.getDenominator());
		}
		if(this.getDenominator()!=0 && num2.getDenominator()==0){
			an.setCount(this.getCount() - num2.getCount());
			an.setDenominator(this.getDenominator());
			an.setNumerato(this.getNumerato());
		}
		if(this.getDenominator()==0 && num2.getDenominator()!=0){
			an.setCount(this.getCount() - num2.getCount());
			an.setDenominator(num2.getDenominator());
			an.setNumerato(-num2.getNumerato());
		}
		an.trim();
		return an;
		
	}
	public Number muti(Number num2){
		Number an = new Number();
		if(this.getDenominator()==0 && num2.getDenominator()==0){
			an.setCount(this.getCount() * num2.getCount());
		}
		if(this.getDenominator()!=0 && num2.getDenominator()!=0){
			an.setCount(0);
			an.setDenominator(this.getDenominator() * num2.getDenominator());
			an.setNumerato((this.getNumerato() + this.getCount() * this.getDenominator()) *
					(num2.getNumerato() + num2.getCount() * num2.getDenominator()));
		}
		if(this.getDenominator()!=0 && num2.getDenominator()==0){
			an.setCount(0);
			an.setDenominator(this.getDenominator());
			an.setNumerato(this.getNumerato() * num2.getCount());
		}
		if(this.getDenominator()==0 && num2.getDenominator()!=0){
			an.setCount(0);
			an.setDenominator(num2.getDenominator());
			an.setNumerato(num2.getNumerato() * this.getCount());
		}
		an.trim();
		return an;
		
	}
	
	public Number division(Number num2){
		Number an = new Number();
		if(this.getDenominator()!=0 && num2.getDenominator()!=0){
			an.setCount(0);
			an.setDenominator(this.getDenominator() * (num2.getNumerato() + num2.getCount() * num2.getDenominator()));
			an.setNumerato((this.getNumerato() + this.getCount() * this.getDenominator()) *
					num2.getDenominator());
		}
		if(this.getDenominator()==0 && num2.getDenominator()==0){
			an.setCount(0);
			an.setNumerato(this.getCount());
			an.setDenominator(num2.getCount());
		}
		if(this.getDenominator()==0 && num2.getDenominator()!=0){
			an.setCount(0);
			an.setDenominator(num2.getNumerato());
			an.setNumerato(num2.getDenominator() * this.getCount());
		}
		if(this.getDenominator()!=0 && num2.getDenominator()==0){
			an.setCount(0);
			an.setDenominator(this.getDenominator() * num2.getCount());
			an.setNumerato(this.getNumerato());
		}
		an.trim();
		return an;
		
	}
	public void trim(){
		if(this.getDenominator()==0)
			return;
		int count = this.getCount();
		if(this.getNumerato()<0&&this.getCount()>0){
			this.setNumerato(this.getCount()*this.getDenominator() + this.getNumerato());
			this.setCount(0);
		}
		//化为带分数
		if(this.getNumerato()>=this.getDenominator()){
			count += this.getNumerato()/this.getDenominator();
			this.setCount(count);
			this.setNumerato(this.getNumerato()%this.getDenominator());
			
		}
		//分数约分
		for(int i=2;i<this.getDenominator();i++){
			if(this.getNumerato()%i==0&&this.getDenominator()%i==0){
				this.setNumerato(this.getNumerato()/i);
				this.setDenominator(this.getDenominator()/i);
			}
			
		}
		if(this.getNumerato()==0)
			this.setDenominator(0);
		
		
	}
	public String toString(){
		if(this.getDenominator()==0){
			return String.valueOf(this.getCount());
			
		}else{
			String str = "";
			if(this.getCount()!=0){
				str += String.valueOf(this.getCount())+ "’";								
			}
			str += String.valueOf(this.getNumerato())+ "/" + this.getDenominator();
			return str;
		}
	}
	public void create(int n){
		
		
		Random rand = new Random();
		int fenshu = rand.nextInt(5+1); 
		if(fenshu == 1){
			this.setCount(0);
			this.setDenominator(rand.nextInt(10)+1);
			this.setNumerato(rand.nextInt(this.getDenominator())+1);
			this.trim();
		}else{
			this.setCount(rand.nextInt(n)+1);
			this.setDenominator(0);
			this.setNumerato(0);
		}	

		
	}

	public boolean equals(Number num) {
		if (num.getCount() == this.getCount() && num.getDenominator() == this.getDenominator()
				&& num.getNumerato() == this.getNumerato()) {
			return true;
		}
		return false;
	}
}
