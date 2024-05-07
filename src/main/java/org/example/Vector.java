package org.example;

public class Vector {
    public int x;
    public int y;
    public int z;

    Vector(int x, int y, int z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector sum(Vector second_vector){
        Vector new_vector = new Vector(this.x, this.y, this.z);
        new_vector.x += second_vector.x;
        new_vector.y += second_vector.y;
        new_vector.z += second_vector.z;
        return new_vector;
    }

    public Vector minus(Vector second_vector){
        Vector new_vector = new Vector(this.x, this.y,this.z);
        new_vector.x -= second_vector.x;
        new_vector.y -= second_vector.y;
        new_vector.z -= second_vector.z;
        return new_vector;
    }

    public double find_cos(Vector second_vector)throws Exception{
        if (this.lenght_of_vector() * second_vector.lenght_of_vector() == 0){
            throw new Exception("Деление на ноль");
        }
        int numerator = multiplication_vectors(second_vector);
        numerator /= this.lenght_of_vector() * second_vector.lenght_of_vector();
        return numerator;
    }

    public int multiplication_vectors(Vector second_vector){
        return this.x * second_vector.x + this.y * second_vector.y + this.z * second_vector.z;
    }

    public double lenght_of_vector(){ // Длина вектора
        return Math.sqrt((this.x * this.x) + (this.y * this.y) + (this.z * this.z));
    }

    public static void main(String args[]){

    }
}
