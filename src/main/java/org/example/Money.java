package org.example;

// 2 задание на деньги
public class Money {

    private int rubles;
    private int cents;

    Money(int rubles, int cents) throws  Exception{
        if (rubles < 0 || cents < 0){
            throw new Exception("Отрицательное значение");
        }
        if (cents > 100){
            throw new Exception("Не может быть больше 100 копеек");
        }
        else {
            this.rubles = rubles;
            this.cents = cents;
        }
    }

    @Override
    public String toString() {
        return rubles + "," + cents;
    }

    public void sum(Money second_money){
        int ruble = 0;
        this.cents += second_money.cents;
        if (this.cents > 100){
            ruble = this.cents / 100;
            this.cents /= 10;
        }
        this.rubles += ruble + second_money.rubles;
    }

    public void minus(Money second_money)throws Exception{
        if (this.rubles < second_money.rubles){
            throw new Exception("Не хватает денег");
        }
        if (this.cents < second_money.cents){
            this.cents += 100;
            this.rubles -= 1;
        }
        this.cents -= second_money.cents;
        this.rubles -= second_money.rubles;
    }

    private void correct_money(){
        while (this.cents > 100){ // while если при умножении получим 300
            this.cents -= 100;
            this.rubles++;
        }
    }

    public void divide(int dividor){
        int cent = 0;
        if (this.rubles % dividor > 0){
            cent = this.rubles % dividor;
        }
        this.rubles /= dividor;
        this.cents /= dividor;
        this.cents += cent;
        correct_money();
    }

    public void multiplication_on_number(int number){
        this.rubles *= number;
        this.cents *= number;
        correct_money();
    }

    public void divide_on_fraction(int numeric, int denumeric)throws Exception{
        if (denumeric == 0){
            throw new Exception("Знаменатель не может быть равен нулю");
        }
       this.rubles *= denumeric;
       this.cents *= denumeric;
       int cent = this.rubles % numeric;
       this.rubles /= numeric;
       this.cents /= numeric;
       this.cents += cent;
       correct_money();
    }

    public void multiplication_on_fraction(int numeric, int denumeric) throws Exception{
        if (denumeric < 0){
            throw new Exception("Знаменатель меньше нуля");
        }
        try{
            divide_on_fraction(denumeric, numeric);
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    public boolean equal(Money second_money){
        if (this.rubles == second_money.rubles && this.cents == second_money.cents){
            return true;
        }
        return false;
    }

    public boolean more_than(Money second_money){
        if (this.rubles > second_money.rubles || (this.rubles == second_money.rubles && this.cents > second_money.cents)){
            return true;
        }
        return false;
    }

    public boolean less_than(Money second_money){
        if (this.rubles < second_money.rubles || (this.rubles == second_money.rubles && this.cents < second_money.cents)){
            return true;
        }
        return false;
    }








    public static void main(String args[]){

    }

}
