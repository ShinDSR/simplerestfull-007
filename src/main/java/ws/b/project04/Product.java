/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ws.b.project04;

/**
 *
 * @author fa506
 */
public class Product {//Membuat class Product
    private String id;//Membuat variable id
    private String name;//Membuat variable name
    private int price;//Membuat variable price
    private int number;//Membuat variable number
    private int total_buy;//Membuat variable total_buy

    public String getId() {//Membuat mathod  getId
        return id;//Mengembalikan parameter id
    }

    public void setId(String id) {//Membuat method setId
        this.id = id;//Mengatur isi variable id
    }

    public String getName() {//Membuat mathod  getName
        return name;//Mengembalikan parameter name
    }

    public void setName(String name) {//Membuat method setName
        this.name = name;//Mengatur isi variable name
    }

    public int getPrice() {//Membuat mathod  getPrice
        return price;//Mengembalikan parameter price
    }

    public void setPrice(int price) {//Membuat method setPrice
        this.price = price;//Mengatur isi variable price
    }

    public int getNumber() {//Membuat mathod  getNumber
        return number;//Mengembalikan parameter number
    }

    public void setNumber(int number) {//Membuat method setNumber
        this.number = number;//Mengatur isi variable number
    }

    public int getTotal_buy() {//Membuat mathod  getTotal_buy
        return price * number;//Mengembalikan parameter dengan mengalikan variable price dan number
    }

    public void setTotal_buy(int total_buy) {//Membuat method setTotal_buy
        this.total_buy = total_buy;//Mengatur isi variable total_buy
    }
    
}
