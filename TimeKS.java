import java.util.Date;

public class TimeKS { //TS = Tonya Shchirska
    private int second;
    private int minute;
    private int hour;

    public int getSecond() {
        return second;
    }

    public int getMinute() {
        return minute;
    }

    public int getHour() {
        return hour;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public TimeKS() {
        this.second = 0;
        this.minute = 0;
        this.hour = 0;
    }

    public TimeKS(int hour, int minute, int second) {
        if (((hour < 0)||(hour > 24))||((minute < 0)||(minute > 60))||((second < 0)||(second > 60))){
            this.second = 0;
            this.minute = 0;
            this.hour = 0;
        }
        else{
            this.second = second;
            this.minute = minute;
            this.hour = hour;
        }
    }

    public TimeKS(Date date){
        this.second = date.getSeconds();
        this.minute = date.getMinutes();
        this.hour = date.getHours();
    }

    public String getTime() {
        String zz = "AM";
        if (hour > 12) {
            hour = hour - 12;
            zz = "PM";
        }
        String stHour = "", stMinute = "", stSecond = "";
        if(hour < 10){
            stHour += "0" + hour;
        }
        else{
            stHour += hour;
        }
        if(minute < 10){
            stMinute += "0" + minute;
        }
        else{
            stMinute += minute;
        }
        if(second < 10){
            stSecond += "0" + second;
        }
        else{
            stSecond += second;
        }
        String time = stHour + ":" + stMinute + ":" + stSecond + zz;
        return time;
    }

    public TimeKS sumCurrent(TimeKS TimeKS){
        TimeKS time = new TimeKS();
        time.setHour(hour + TimeKS.getHour());
        time.setMinute(minute + TimeKS.getMinute());
        time.setSecond(second + TimeKS.getSecond());
        if(time.getSecond() >= 60){
            time.setSecond(time.getSecond()-60);
            time.setMinute(time.getMinute()+1);
        }
        if(time.getMinute() >= 60){
            time.setMinute(time.getMinute()-60);
            time.setHour(time.getHour()+1);
        }
        if(time.getHour() >= 24){
            time.setHour(time.getHour()-24);
            if (time.getHour() == 0){
                time.setHour(12);
            }
        }
        return time;
    }

    public TimeKS difCurrent(TimeKS TimeKS){
        TimeKS time = new TimeKS();
        time.setHour(hour - TimeKS.getHour());
        time.setMinute(minute - TimeKS.getMinute());
        time.setSecond(second - TimeKS.getSecond());
        if(time.getSecond() <= 0){
            time.setSecond(time.getSecond()+60);
            time.setMinute(time.getMinute()-1);
        }
        if(time.getMinute() <= 0){
            time.setMinute(time.getMinute()+60);
            time.setHour(time.getHour()-1);
        }
        if(time.getHour() <= 0){
            time.setHour(time.getHour()+24);
            if (time.getHour() == 0){
                time.setHour(12);
            }
        }
        return time;
    }

    public static TimeKS sum(TimeKS TimeKS1, TimeKS TimeKS2){
        TimeKS time = new TimeKS();
        time.setHour(TimeKS1.getHour() + TimeKS2.getHour());
        time.setMinute(TimeKS1.getMinute() + TimeKS2.getMinute());
        time.setSecond(TimeKS1.getSecond() + TimeKS2.getSecond());
        if(time.getSecond() >= 60){
            time.setSecond(time.getSecond()-60);
            time.setMinute(time.getMinute()+1);
        }
        if(time.getMinute() >= 60){
            time.setMinute(time.getMinute()-60);
            time.setHour(time.getHour()+1);
        }
        if(time.getHour() >= 24){
            time.setHour(time.getHour()-24);
            if (time.getHour() == 0){
                time.setHour(12);
            }
        }
        return time;
    }
    public static TimeKS dif(TimeKS TimeKS1, TimeKS TimeKS2){
        TimeKS time = new TimeKS();
        time.setHour(TimeKS1.getHour() - TimeKS2.getHour());
        time.setMinute(TimeKS1.getMinute() - TimeKS2.getMinute());
        time.setSecond(TimeKS1.getSecond() - TimeKS2.getSecond());
        if(time.getSecond() <= 0){
            time.setSecond(time.getSecond()+60);
            time.setMinute(time.getMinute()-1);
        }
        if(time.getMinute() <= 0){
            time.setMinute(time.getMinute()+60);
            time.setHour(time.getHour()-1);
        }
        if(time.getHour() <= 0){
            time.setHour(time.getHour()+24);
            if (time.getHour() == 0){
                time.setHour(12);
            }
        }
        return time;
    }

    public static void main(String[] args) {
        TimeKS time1 = new TimeKS();
        TimeKS time2 = new TimeKS(23, 59, 59);
        TimeKS time3 = new TimeKS(0, 0, 1);
        TimeKS time4 = new TimeKS(12, 34, 53);

        Date date = new Date();
        TimeKS time5 = new TimeKS(date);

        System.out.println(time1.getTime());
        System.out.println(time2.getTime());
        System.out.println(time3.getTime());
        System.out.println(time4.getTime());
        System.out.println(time5.getTime());
        System.out.println();

        System.out.println("version 1");
        System.out.println("time 1 + time 2 = " + time1.sumCurrent(time2).getTime());
        System.out.println("time 2 + time 3 = " + time2.sumCurrent(time3).getTime());
        System.out.println("time 2 + time 4 = " + time2.sumCurrent(time4).getTime());
        System.out.println("time 2 - time 4 = " + time2.difCurrent(time4).getTime());
        System.out.println("time 3 - time 4 = " + time3.difCurrent(time4).getTime());
        System.out.println();

        System.out.println("version 2");
        System.out.println("time 1 + time 2 = " + sum(time1, time2).getTime());
        System.out.println("time 2 + time 3 = " + sum(time2, time3).getTime());
        System.out.println("time 2 + time 4 = " + sum(time2, time4).getTime());
        System.out.println("time 2 - time 4 = " + dif(time2, time4).getTime());
        System.out.println("time 3 - time 4 = " + dif(time3, time4).getTime());

    }
}
