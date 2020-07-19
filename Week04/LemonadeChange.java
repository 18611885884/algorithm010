/**
 * 860. 柠檬水找零
 *
 * @ClassName LemonadeChange
 * @Description
 * @Author luozhengqi
 * @Date 2020-07-12 23:26
 * @Version 1.0
 **/
public class LemonadeChange {

    //[5,5,10,10,20]
    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        for(int i = 0; i < bills.length; i++){
            switch (bills[i]){
                case 5:
                    five++;
                    break;
                case 10:
                    ten++;
                    five--;
                    break;
                default:
                    if(ten > 0){
                        ten--;
                        five--;
                    }else{
                        five -= 3;
                    }
                    break;
            }
            if(five < 0 || ten < 0){
                return false;
            }
        }
        return true;
    }
}
