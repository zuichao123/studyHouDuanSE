package com.kjpracs.T20191220;

public class InterfaceImplementsDuotai {
    public static void main(String[] args) {
        CarShop aShop = new CarShop();
        //卖出一辆宝马
        aShop.sellCar(new BMW());
        //卖出一辆奇瑞QQ
        aShop.sellCar(new CheryQQ());
        //卖出一辆桑塔纳
        aShop.sellCar(new Santana());
        System.out.println("总收入：" + aShop.getMoney());
    }
}

//汽车接口
interface Car {
    //汽车名称
    String getName();

    //获得汽车售价
    int getPrice();
}

//宝马
class BMW implements Car {
    public String getName() {
        return "BMW";
    }

    public int getPrice() {
        return 300000;
    }
}

//奇瑞QQ
class CheryQQ implements Car {
    public String getName() {
        return "CheryQQ";
    }

    public int getPrice() {
        return 20000;
    }
}

//桑塔纳汽车
class Santana implements Car {
    public String getName() {
        return "Santana";
    }

    public int getPrice() {
        return 80000;
    }
}

//汽车出售店
class CarShop {
    //售车收入
    private int money = 0;

    //卖出一部车
    public void sellCar(Car car) {
        System.out.println("车型：" + car.getName() + "单价：" + car.getPrice());
        //增加卖出车售价的收入
        money += car.getPrice();
    }

    //售车总收入
    public int getMoney() {
        return money;
    }
}
