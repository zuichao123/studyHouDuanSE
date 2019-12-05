import org.testng.annotations.Test;

public class CodeDemo {

    @Test
    public void test(){
        int age = 10;
        if(age < 7){
            System.out.printf(age + "岁，属于儿童");
        }else if(age < 18){
            System.out.printf(age + "岁，属于少年");

        }else if(age < 41){
            System.out.printf(age + "岁，属于中青年");
        }else if(age < 60){
            System.out.printf(age + "岁，属于老年");
        }
    }

}
